package info.oldcolony.shopplacementapp.controllers;

import info.oldcolony.test.testdatageneration.TestDataGenerator;

public interface TestableShop {
    String[] SHOP_NAMES = {"Automotive Technology", "Business Technology", "CAD", "Computer Science",
            "Cosmetology",
            "Culinary Arts", "Electrical", "Electronics", "Graphic Communication", "Health Careers", "Carpentry", "Machine & Tool", "Metal Fabrication"};

    static String getRandomShopName() {
        int randomIndex = TestDataGenerator.getRandomInt(0, SHOP_NAMES.length);
        return SHOP_NAMES[randomIndex];
    }













}
