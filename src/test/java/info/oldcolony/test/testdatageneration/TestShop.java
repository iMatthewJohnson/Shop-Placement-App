package info.oldcolony.test.testdatageneration;

import info.oldcolony.shopplacementapp.Shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestShop extends Shop implements TestableShop {

    public TestShop() {
        super(TestableShop.getRandomShopName(), TestableShop.getRandomShopCapacity());
    }


    public static Shop[] getAllShops() {
        Shop[] shops = new Shop[TestableShop.shopNames.length];
        for (int i = 0; i < shops.length; i++) {
            shops[i] = new Shop(TestableShop.shopNames[i], TestableShop.getRandomShopCapacity());
        }
        return shops;
    }
}
