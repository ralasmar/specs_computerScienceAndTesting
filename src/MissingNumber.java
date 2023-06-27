import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

//write a function that takes in a list of numbers and the maxNum and returns the missing number
public class MissingNumber {
    public static int missingNumber(int[] nums, int maxNum){
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for(int i = 1; i <maxNum; i += 1){
            if(!set.contains(i)){
                return i;
            }
        }
        return 0;
    }
    //reduce memory
//    public static int missingNumberSort(int[] nums, int maxNum){
//        Arrays.sort(nums);
//        for(int i=1; i < maxNum; i+=1){
//            return i;
//        }
//        if(nums.length == maxNum && nums[maxNum -1]== maxNum){
//        return 0;
//    }
//        return maxNum;
//    }

    //invoke function and pass in array and maxNum
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8 };

        System.out.println("Missing Max:" + missingNumber(array, 10));
    }
}


