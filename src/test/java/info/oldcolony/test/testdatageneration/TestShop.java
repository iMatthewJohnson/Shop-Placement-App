package info.oldcolony.test.testdatageneration;


import info.oldcolony.shopplacementapp.controllers.TestShopRepository;
import info.oldcolony.shopplacementapp.model.shop.Shop;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TestShop extends Shop implements TestableShop {

    @Autowired
    @Transient
    private static TestShopRepository testShopRepository;
    public TestShop() {
        super(TestableShop.getRandomShopName(), TestDataGenerator.getRandomInt(6, 20));
    }

    public static List<TestShop> getAllShops() {
        Iterable<TestShop> shops = testShopRepository.findAll();
        ArrayList<TestShop> shopsList = new ArrayList<>();
        shops.forEach(shopsList::add);
        return shopsList;
    }
}
