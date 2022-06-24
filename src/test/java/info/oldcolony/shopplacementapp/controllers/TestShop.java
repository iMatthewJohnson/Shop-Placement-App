package info.oldcolony.shopplacementapp.controllers;


import info.oldcolony.shopplacementapp.model.cruds.Shop;
import info.oldcolony.test.testdatageneration.TestDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="test_shops")
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
