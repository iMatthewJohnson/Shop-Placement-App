package info.oldcolony.test.testdatageneration;

import info.oldcolony.shopplacementapp.Shop;

public class TestShop extends Shop implements TestableShop {

    public TestShop() {
        super(TestableShop.getRandomShopName(), TestableShop.getRandomShopCapcity());
    }
}
