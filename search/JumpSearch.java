package search;

import java.util.List;

public class JumpSearch {

    public static <T extends Comparable<T>> int find(List<T> sortedList, T element) {
        int size = sortedList.size();
        int baseJump = (int) Math.sqrt(size);
        int jump = baseJump;
        int prevStep = 0;

        while (sortedList.get(Math.min(jump, size) - 1).compareTo(element) < 0) {
            prevStep = jump;
            jump += baseJump;
            if (prevStep >= size)
                return -1;
        }

        while (sortedList.get(prevStep).compareTo(element) < 0) {
            prevStep++;
            if (prevStep == Math.min(jump, size))
                return -1;
        }

        if (sortedList.get(prevStep).equals(element)) {
            return prevStep;
        }

        return -1;
    }

}
