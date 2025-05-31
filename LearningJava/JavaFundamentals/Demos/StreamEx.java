package Demos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StreamEx {
    public static void main(String[] args) {

        int size = 10_000;
        List<Integer> nums = new ArrayList<>(size);

        Random ran = new Random();

        for (int i = 0; i < size; i++) {
            nums.add(ran.nextInt(100));
        }

        long start = System.currentTimeMillis();

        int sum1 = nums.stream()
                .map(i -> i*2)
                .reduce(0,(e,c) -> e + c);
         
        long end = System.currentTimeMillis();
        
        
        long start2 = System.currentTimeMillis();
        int sum2 = nums.stream() 
                   .map(i -> i*2)
                   .mapToInt( i -> i)
                   .sum();

        long end2 = System.currentTimeMillis();


        long start3 = System.currentTimeMillis();
        int sum3 = nums.parallelStream()
                   .map(i -> i*2)
                   .mapToInt(i -> i)
                   .sum();
        long end3 = System.currentTimeMillis();
        

        System.out.println(sum1 + " " + " " + sum2 + " "  + sum3);

        System.out.println("Sum1 time: " + (end - start ));
        System.out.println("Sum2 time: " + (end2 - start2 ));
        System.out.println("Sum3 time: " + (end3 - start3 ));
    }

}
