import java.util.Map;
import java.util.HashMap;

public class Main{

    public static int subArraySum(int[] input, int target){
        int runningSum =0;
        int count =0;
        HashMap<Integer,Integer> seen = new HashMap<>(Map.of(0,1));

        for(int num: input){
            runningSum +=num;
            if(seen.containsKey(runningSum-target)){
                count += seen.get(runningSum - target);
            }

            seen.put(runningSum,seen.getOrDefault(runningSum,0)+1);
        }

        return count;
    }
    public static void main(String[] args){

        int[] nums = {1, 2, 3, 5};

        System.out.println(subArraySum(nums, 3));
    }
}

