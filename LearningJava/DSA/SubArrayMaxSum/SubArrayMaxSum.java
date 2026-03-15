public class SubArrayMaxSum {
 
    
    public static int calcMaxSum(int[] input){
        int maxSum =input[0];
        int currentSum=input[0];

        for(int i=1;i<input.length;i++){
            if(currentSum<0){
                currentSum=0;
            }
            currentSum += input[i];
            if(currentSum>maxSum){
                maxSum = currentSum;
            }
            
        }
        return maxSum;
    }

    public static void main(String[] args){
        
        int[] test = {-2,1,-3,4,-1,2,1,-5,4}; //output: 6
        int[] test2 = {5, 4, -1, 7, 8}; //output: 23
        int[] test3 = {-2, 2,3};
        System.out.println(calcMaxSum(test));
        System.out.println(calcMaxSum(test2));
        System.out.println(calcMaxSum(test3));
    }
}
