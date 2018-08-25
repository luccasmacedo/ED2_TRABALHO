package com.company;

public class QuickSort {

    private int numberComparisionsKey;
    private int numberCopies;
    private long estimatedTime;

    private void swap(int[] vet, int dex1, int dex2) {
        int temp;
        temp = vet[dex1];
        vet[dex1] = vet[dex2];
        vet[dex2] = temp;
        numberCopies += 3;
    }
    private void recQuickSort(int[] vet, int left, int right){

        if(right - left <= 0) {
            numberComparisionsKey++;
            return;
        }else{
            int pivot = vet[right];
            numberCopies++;

            int partition = partitionIt(vet,left, right, pivot);
            recQuickSort(vet,left, partition - 1);
            recQuickSort(vet,partition + 1, right);
        }
    }
    public void quickSort(int[] vet, int size){
        numberComparisionsKey = 0;
        numberCopies = 0;
        long startTime = System.nanoTime();
        recQuickSort(vet, 0, size - 1);
        estimatedTime = System.nanoTime() - startTime;
    }
    private int partitionIt(int vet[], int left, int right, int pivot) {
        int leftPtr = left - 1;
        numberCopies++;
        int rightPtr = right;
        numberCopies++;

        while (true) {
            while (vet[++leftPtr] < pivot){
                numberComparisionsKey++;
            }
            while (rightPtr > 0 && vet[--rightPtr] > pivot){
                numberComparisionsKey++;
            }

            if (leftPtr >= rightPtr) {
                numberComparisionsKey++;
                break;
            }
            else
                swap(vet,leftPtr, rightPtr);
        }
        swap(vet,leftPtr,right);

        return leftPtr;
    }

    public int getNumberComparisionsKey() {
        return numberComparisionsKey;
    }

    public int getNumberCopies() {
        return numberCopies;
    }

    public long getEstimatedTime() {
        return estimatedTime;
    }
}