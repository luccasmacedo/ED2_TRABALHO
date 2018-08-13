import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Integer vet[] = {9,3,2,1,3,4,7};

        Sort.InsertionSort(vet);

        for (int i = 0; i < vet.length; i++){
            System.out.println(vet[i]);
        }
        }
}
