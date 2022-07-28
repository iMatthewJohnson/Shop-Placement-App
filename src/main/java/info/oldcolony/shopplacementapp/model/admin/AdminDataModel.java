package info.oldcolony.shopplacementapp.model.admin;

import info.oldcolony.shopplacementapp.model.ShopPlacementModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
//TODO: Add documentation
@Component
public class AdminDataModel extends ShopPlacementModel<Admin> {

    @Autowired
    AdminRepository adminRepository;

    @Override
    protected CrudRepository<Admin, Integer> getRepo() {
        return adminRepository;
    }

    public void update(@NonNull Integer id,
                       @Nullable String firstName,
                       @Nullable String lastName) {
        Optional<Admin> adminQuery = adminRepository.findById(id);
        if (adminQuery.isPresent()) {
            Admin admin = adminQuery.get();
            if (firstName != null) admin.setFirstName(firstName);
            if (lastName != null)admin.setLastName(lastName);
            adminRepository.save(admin);
        }
    }

    @Override
    public void update(List<Admin> admins) {

        admins.forEach(admin ->
                update(admin.getId(),
                        admin.getFirstName(),
                        admin.getLastName()));
            
    }
}
