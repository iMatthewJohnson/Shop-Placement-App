package info.oldcolony.shopplacementapp.model.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopDataModel {

    @Autowired
    ShopRepository shopRepository;

}
