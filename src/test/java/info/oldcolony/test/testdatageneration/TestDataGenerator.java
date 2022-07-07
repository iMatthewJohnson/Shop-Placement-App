package info.oldcolony.test.testdatageneration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestDataGenerator {

    public static int getRandomInt() {
        return getRandomInt(Integer.MAX_VALUE);
    }

    public static int getRandomInt(int max) {
        return (int) (Math.random() * max);
    }

    public static int getRandomInt(int min, int max) {
        return getRandomInt(max - min) + min;
    }

    public static int getRandomInt(List<Integer> excludedNumbers) {
        int randomInt = getRandomInt();
        while (excludedNumbers.contains(randomInt)) {
            randomInt = getRandomInt();
        }
        return randomInt;
    }

    public static double getRandomDouble() {
         return Math.random();
    }

    public static double getRandomDouble(long max) {
        return Math.random() * max;
    }

    public static double getRandomDouble(long min, long max) {
        return getRandomDouble(max - min) + min;
    }

    public static List<Integer> getRandomArrayOfIntegers(int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = min; i < max; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }

}
