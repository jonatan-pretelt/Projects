class Main{
    public static int minLengthArr(int[] inputArray, int target){
        int minLength =Integer.MAX_VALUE;
        int leftPointer =0;
        int currentSum= inputArray[0];
        for(int i=1;i<inputArray.length;i++){
            currentSum += inputArray[i];
            while(currentSum>=target){
                minLength= Math.min((i - leftPointer) +1,minLength);
                currentSum -= inputArray[leftPointer];
                leftPointer++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    public static void main(String[] args){
        int[] input = {2, 3, 1, 2,4, 3};
        int ans = minLengthArr(input, 7);
        System.out.println(ans);
    }
}