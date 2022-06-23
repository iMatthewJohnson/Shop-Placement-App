//package info.oldcolony.test.testdatageneration;
//
//import info.oldcolony.shopplacementapp.model_controller.ShopModel;
//
//public class TestShop extends ShopModel implements TestableShop {
//
//    public TestShop() {
//        super(TestableShop.getRandomShopName(), TestableShop.getRandomShopCapacity());
//    }
//
//
//    public static ShopModel[] getAllShops() {
//        ShopModel[] shops = new ShopModel[TestableShop.SHOP_NAMES.length];
//        for (int i = 0; i < shops.length; i++) {
//            shops[i] = new ShopModel(TestableShop.SHOP_NAMES[i], TestableShop.getRandomShopCapacity());
//        }
//        return shops;
//    }
//}
