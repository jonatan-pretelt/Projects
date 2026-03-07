public class SubArrayMaxSum {
 
    
    public static int calcMaxSum(int[] input){
        int maxSum =0;
        int currentSum=0;

        for(int i=0;i<input.length;i++){
            currentSum += input[i];
            if(currentSum>maxSum){
                maxSum = currentSum;
            }
            if(currentSum<0){
                currentSum=0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args){
        
        int[] test = {-2,1,-3,4,-1,2,1,-5,4}; //output: 6
        int[] test2 = {5, 4, -1, 7, 8}; //output: 23
        System.out.println(calcMaxSum(test));
        System.out.println(calcMaxSum(test2));
    }
}
