class RecursionExercises {

    public static long factorial(int n) {
        // Base case: factorial(0) = 1, factorial(1) = 1
        if (n <= 1) {
            return 1;
        } else {
            // Recursive case: factorial(n) = n * factorial(n-1)
            return n * factorial(n - 1);
        }

    }

    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 2) + fibonacci(n - 1);
        }
    }

    public static int sumDigits(int number) {
        if (number / 10 == 0) {
            return number;
        } else {
            return number % 10 + sumDigits(number / 10);
        }
    }

    public static String reverse(String str) {
        if (str.length() <= 1) {
            return str;
        } else {

            return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
        }

    }

     // countChar("hello", 'l') = 2
    public static int countChar(String str, char target) {
        if( str.indexOf(target) < 0){
            return 0;
        }else{
            return 1 + countChar(str.substring(str.indexOf(target) + 1), target);
        }

        //cc("hi", 'i') 

    }

    public static void main(String[] args) {
        // Test factorial
        System.out.println("Factorial Tests:");
        System.out.println("factorial(5) = " + factorial(5) + " (should be 120)");
        System.out.println("factorial(0) = " + factorial(0) + " (should be 1)");

        // Test fibonacci
        System.out.println("\nFibonacci Tests:");
        System.out.println("fibonacci(6) = " + fibonacci(6) + " (should be 8)");
        System.out.println("fibonacci(10) = " + fibonacci(10) + " (should be 55)");

        // Test sumDigits
        System.out.println("\nSum Digits Tests:");
        System.out.println("sumDigits(1234) = " + sumDigits(1234) + " (should be 10)");
        System.out.println("sumDigits(999) = " + sumDigits(999) + " (should be 27)");

        // Test reverse
        System.out.println("\nReverse Tests:");
        System.out.println("reverse('hello') = '" + reverse("hello") + "' (should be 'olleh')");
        System.out.println("reverse('Java') = '" + reverse("Java") + "' (should be 'avaJ')");

        // Test countChar
        System.out.println("\nCount Char Tests:");
        System.out.println("countChar('hello', 'l') = " + countChar("hello", 'l') + " (should be 2)");
        System.out.println("countChar('programming', 'm') = " + countChar("programming", 'm') + " (should be 2)");
    }
}