package com.company;

import java.util.Arrays;

public class QuickSortInsertion <T extends Comparable<T>>{

    private int numberComparisionsKey;
    private int numberCopies;
    private long estimatedTime;

    private void swap(T[] vet, int dex1, int dex2) {
        T temp;
        temp = vet[dex1];
        vet[dex1] = vet[dex2];
        vet[dex2] = temp;
        numberCopies += 3;
    }
    private void recQuickSort(T[] vet, int left, int right, int m){

        if(right - left <= m) {
            numberComparisionsKey++;

            Sort insertion = new Sort();
            T subArray[] = Arrays.copyOfRange(vet, left, right + 1);
            insertion.InsertionSort(subArray);

            for(int i = 0; i < subArray.length; i++){
                vet[left++] = subArray[i];
            }
            numberComparisionsKey += insertion.getNumberComparisionsKey();
            numberCopies += insertion.getNumberCopies();
            estimatedTime -= insertion.getEstimatedTime();

            return;
        }else{
            T pivot = vet[right];
            numberCopies++;

            int partition = partitionIt(vet,left, right, pivot);
            recQuickSort(vet,left, partition - 1, m);
            recQuickSort(vet,partition + 1, right, m);
        }
    }
    public void quickSort(T[] vet, int size, int m){
        numberComparisionsKey = 0;
        numberCopies = 0;
        long startTime = System.nanoTime();
        recQuickSort(vet, 0, size - 1, m);
        estimatedTime = System.nanoTime() - startTime;
    }
    private int partitionIt(T vet[], int left, int right, T pivot) {
        int leftPtr = left - 1;
        numberCopies++;
        int rightPtr = right;
        numberCopies++;

        while (true) {
            while (pivot.compareTo(vet[++leftPtr]) > 0){
                numberComparisionsKey++;
            }
            while (rightPtr > 0 && (vet[--rightPtr].compareTo(pivot) > 0)){
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