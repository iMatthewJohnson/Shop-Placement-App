package info.oldcolony.test.testdatageneration;

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



}
