import java.util.Arrays;
import java.util.Random;
/**
 for each (unsorted) partition

 set first element as pivot

 storeIndex = pivotIndex+1

 for i = pivotIndex+1 to rightmostIndex

 if ((a[i] < a[pivot]) or (equal but 50% lucky))

 swap(i, storeIndex); ++storeIndex

 swap(pivot, storeIndex-1)
 */

/**
 Worst case time complexity: Θ(N^2)
 Average case time complexity: Θ(N log N)
 Best case time complexity: Θ(N log N) (simple partition); Θ(N) (three way partition)
 Space complexity: Θ(N) (naive); Θ(log N)
 */
public class QuickSort {
    public static void main(String[] args) {   // Arrayin icinde random bir sayi sececegiz(PIVOT). Pivottan kucuk sayilari pivotun soluna ve buyuk sayilari sagine yerlestircez. ve pivot sayi bir daha yer degistirmice. onun solundaki sayilari da tekrar quicksortlayarak duzenlencek ve sagindakilerde ayni sekilde
    // MERGE SORTTAN FARKI Bu sorting en kucuk array uzunluguna kadar habire bolup durmuyor sadece hep pivot bir sayi seciyor

        Random rand = new Random();

        int[] numbers = new int[10];

        for(int i = 0; i< numbers.length; i++){
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("ONCESI");
        System.out.println(Arrays.toString(numbers));
        System.out.println("SONRASI");
        quickSort(numbers,0, numbers.length-1);
        System.out.println(Arrays.toString(numbers));





    }

    private static void quickSort(int[] arr, int lowIndex, int highIndex) {  // RECURSIV KULLANDIGIMIZ ICIN ARA MESAFE VERMEMIZ LAZIM YOKSA HEP ARRAYI DUYENLICEK AMA PIVOT SAGINI SOLUNA BAKMADAN
        if(lowIndex >= highIndex){
            return;
        }

        int pivot = arr[highIndex];                                          // 2 variables as --> Left pointer arrayin en solunda baslicak ve right pointer da en sag kisminda olucak. Left pointer soldan saga gudecek ve pivottan buyuk bir sayi bulunca duracak. Right pointerda soldan saga gidecek ve pivottan kucuk bir sayi buldugunda duracak.
                                                                            // Bu pointerlarlarin icindeki sayilar yer degistircez ve tekrar devam edicek ayni sey taki left pointer ve right pointer ayni sayiya gosterene kadar.
                                                                            // Pivotla leftpointerin icindeki sayiyla yer degistircek ve pivottan kucuk sayilarin hepsi solda buyuk olanlar sagda

        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer){
            while(arr[leftPointer] <= pivot && leftPointer < rightPointer){

                leftPointer++;
            }

            while(arr[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(arr,leftPointer,rightPointer);
        }
        swap(arr,leftPointer, highIndex);

        quickSort(arr, lowIndex, leftPointer-1);
        quickSort(arr,leftPointer+1, highIndex );
    }

    private static void swap(int[] arr, int index1, int index2){
        int temmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temmp;



    }


}
