import java.util.Arrays;
import java.util.Random;

public class InsertionSort {       /**
 The worst case time complexity of Insertion sort is O(N^2)  nested loops!!
 The average case time complexity of Insertion sort is O(N^2)
 The time complexity of the best case is O(N).
 The space complexity is O(1)
                                    **/

    /**
     mark first element as sorted

     for each unsorted element X

        'extract' the element X

        for j = lastSortedIndex down to 0

            if current element j > X

            move sorted element to the right by 1

        break loop and insert X here
     **/
    public static void main(String[] args) {
//        Arrayin basindan baslayip ilk elemani gecici var a kopyaliyip listenin 2. elemaniyla karsilastirir 2. elemandan zaten kucukse ayni yerinde kalir degilse 3. 4. 5. gibi gibi hepsiyle karsilastirilir taki digerinden kucuk olana dek, eger zaten kucukse 2. eleman gecici var a kopyalanir ve 3. elemanla karsilasitiril ve ayni olay


        Random rand = new Random();

        int[] numbers = new int[10];
        for (int i = 0; i<numbers.length; i++){
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Once");
        System.out.println(Arrays.toString(numbers));
        insertionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void insertionSort(int [] array){
        for (int i = 1; i<array.length; i++){
                                                                    // 1. elemandan baslamak sacma olur zaten kendi icinde sorted oyuzden 2. elemandan basliyacagiz karsilastirmaya ve once ilk elemanla karsilastircak kucukse oraya insert(yerlesctirilcek) degilse diger elemanlarla karsilastiralcak
            int currentValue = array[i];

            int j = i-1;

            while(array[j] > currentValue && j > 0){            // burda j indexti eleman i indexteki elemandan buyukse eger j deki eleman bir i indextekiu elemanin yanina insert edilecek

                array[j+1] = array[j];                      // j+1 aslinda zaten i demek ve burda atama yaparak j indextekini bir saga kaydirmis olduk
                j--;
            }

            array[j+1] = currentValue;           // gecici vari simdi bir sola goturmus oldu

        }


        }
}
