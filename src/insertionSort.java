public class insertionSort {
    public static void main(String[] args){
        int[] array = {9,5,1,3,10,7};
        insertionSort(array);

        System.out.println("Sorted array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    private static void insertionSort(int[] array) {
        int n = array.length;
        //starts with second element and compares it with previous element
        for (int i=1; i<n; i++){
            int key = array[i];
            int j = i-1;

            while (j >= 0 && array[j]>key){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
    }
}