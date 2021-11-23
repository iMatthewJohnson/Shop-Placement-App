package info.oldcolony.test.testdatageneration;

import java.util.HashMap;

public interface TestableShop {
    HashMap<String, Integer> shopsAndCapacity = new HashMap<>();
    String[] shopNames = {"Automotive Technology", "Business Technology", "CAD", "Computer Science", "Cosmetology",
            "Culinary Arts", "Electrical", "Electronics", "Graphic Communication", "Health Careers", "Carpentry", "Machine & Tool", "Metal Fabrication"};

    static String getRandomShopName() {
        int randomIndex = (int) (Math.random() * shopNames.length);
        return shopNames[randomIndex];
    }

    static Integer getRandomShopCapacity() {
        int[] capacities = {8,8,8,12,12,12,12,12,12,12,12,16,16};
        int randomIndex = (int) (Math.random() * capacities.length);
        return capacities[randomIndex];
    }













}
