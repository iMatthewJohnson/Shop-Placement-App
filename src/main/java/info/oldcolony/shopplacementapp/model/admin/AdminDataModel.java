package info.oldcolony.shopplacementapp.model.admin;

import info.oldcolony.shopplacementapp.model.ShopPlacementModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminDataModel extends ShopPlacementModel<Admin> {

    @Autowired
    AdminRepository adminRepository;

    @Override
    protected CrudRepository<Admin, Integer> getRepo() {
        return adminRepository;
    }

    @Override
    public void update(List<Admin> elements) {

    }
}
