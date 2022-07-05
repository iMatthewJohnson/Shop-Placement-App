package info.oldcolony.test.testhelpers;

public class TestUtilities {

    public static String removeWhiteSpace(String str) {
        str = str.replaceAll("\\s+", "");
        return str;
    }
}
