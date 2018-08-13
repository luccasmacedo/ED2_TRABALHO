public class Sort {

    public static <T extends Comparable<T>> void InsertionSort (T vet[]){

        for (int i = 1; i < vet.length; i++){
            T pivot = vet[i];
            int j = i - 1;

            while(j >= 0 && vet[j].compareTo(pivot) > 0){
                vet[j + 1] = vet[j];
                j--;
            }
            vet[j + 1] = pivot;
        }
    }

    public static void MergeSort(int vet[]){
        AuxMergeSort(vet,0,vet.length - 1);
    }
    private static void AuxMergeSort(int vet[], int start, int end){
        int middle;

        if(start < end){
            middle = (start + end)/2;
            AuxMergeSort(vet,start,middle);
            AuxMergeSort(vet,middle + 1,end);
            //Intercalate(vet,start,middle,end);
        }
    }
}
