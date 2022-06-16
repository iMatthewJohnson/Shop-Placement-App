package info.oldcolony.test.testdatageneration;

import info.oldcolony.shopplacementapp.model_controller.Shop;

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
