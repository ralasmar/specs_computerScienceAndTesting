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
    public static int missingNumberSort(int[] nums, int maxNum){
        Arrays.sort(nums);
        for(int i=1; i < maxNum; i+=1){
            return i;
        }
        if(nums.length == maxNum && nums[maxNum -1]== maxNum){
        return 0;
    }
        return maxNum;
    }

}
