package info.oldcolony.shopplacementapp.model.shop;

import info.oldcolony.shopplacementapp.model.ShopPlacementModel;
import info.oldcolony.shopplacementapp.model.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ShopDataModel extends ShopPlacementModel<Shop> {

    @Autowired
    ShopRepository shopRepository;

    @Override
    protected CrudRepository<Shop, Integer> getRepo() {
        return shopRepository;
    }

    @Override
    public void update(List<Shop> elements) {

    }

    public void enrollStudentInShop(Student student, Integer shopId) {
        Optional<Shop> shop = shopRepository.findById(shopId);
        if (shop.isPresent()) {
            Shop theShop = shop.get();
            theShop.enrollStudentWithId(student.getStudentId());
            shopRepository.save(theShop);
        }
    }

    public void unenrollStudentInShop(Integer studentId, Integer shopId) {
        Optional<Shop> shop = shopRepository.findById(shopId);
        if (shop.isPresent()) {
            Shop theShop = shop.get();
            theShop.unenrollStudentWithId(studentId);
            shopRepository.save(theShop);
        }
    }
}
