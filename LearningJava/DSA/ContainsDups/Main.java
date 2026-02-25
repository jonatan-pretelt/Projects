import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static boolean checkContainsDups1(List<Integer> input) {
        List<Integer> checkInput = new ArrayList<>();
        boolean containsDups = false;

        for (int i : input) {
            if (checkInput.contains(i)) {
                return true;
            } else {
                checkInput.add(i);
            }
            ;
        }

        return containsDups;
    }

    public static boolean checkContainsDups2(List<Integer> input) {
        Set<Integer> checkInput = new HashSet<>();

        for (int i : input) {
            boolean contains = checkInput.contains(i);
            if (contains) {
                return true;
            } else {
                checkInput.add(i);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        List<Integer> input1 = new ArrayList<>(Arrays.asList(1, 2, 3, 1));
        List<Integer> input2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        System.out.println(checkContainsDups1(input1)); // true
        System.out.println(checkContainsDups1(input2)); // false
        System.out.println(checkContainsDups2(input1)); // true
        System.out.println(checkContainsDups2(input2)); // false

    }

}
