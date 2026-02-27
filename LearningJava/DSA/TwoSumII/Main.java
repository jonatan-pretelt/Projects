class Main {

    public static boolean checkSum(int[] inputArray, int target) {
        int i = 0;
        int j = inputArray.length - 1;

        while (i <= j) {
            int x = inputArray[i];
            int y = inputArray[j];
            int sum = x + y;
            if (sum == target) {
                return true;
            } else if (sum < target ) {
                i++;
            } else if( sum > target){
                j--;
            }
            
        }

    return false;

    }

    public static void main(String[] args) {
        int[] input = { 1, 2, 4, 6, 10 }; // target =8 Output: true (2+6)
        int[] input2 = { 1, 2, 4, 6, 10 }; // target =17 Output: false

        // [5,6,7,8] 12
        System.out.println(checkSum(input, 8));
        System.out.println(checkSum(input2, 17));
        int[] input3 ={5,6,7,8};
        System.out.println(checkSum(input3, 12));
    }
}