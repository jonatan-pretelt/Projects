import java.lang.Math;

class Main {

    public static int findMaxSum(int[] input, int k) {

        // int start = 0;
        // int end = k - 1;
        int currentSum = 0;
        for(int i =0;i < k;i++){
            currentSum += input[i];
        }
        int maxSum = currentSum;

        for(int end=k; end< input.length; end++) {
            currentSum = currentSum - input[end-k] + input[end];
            maxSum = Math.max(maxSum, currentSum);

        }

        return maxSum;

    }

    public static void main(String[] args) {

        int[] test = { 2, 1, 5, 1, 3, 2 }; // output: 9

        System.out.println(findMaxSum(test, 3));

    }
}