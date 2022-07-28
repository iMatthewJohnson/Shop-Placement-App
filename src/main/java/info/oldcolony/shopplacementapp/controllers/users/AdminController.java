package info.oldcolony.shopplacementapp.controllers.users;

import info.oldcolony.shopplacementapp.controllers.MainController;
import info.oldcolony.shopplacementapp.model.admin.Admin;
import info.oldcolony.shopplacementapp.model.admin.AdminDataModel;
import info.oldcolony.shopplacementapp.model.shop.ShopDataModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Spring REST controller class that handles all HTTP request for the Admin resource, including adding, removing,
 * updating, and deleting users from the {@code ShopPlacementModel}
 */

@RestController
@RequestMapping(path="/api/v1/users/admins")
public class AdminController extends MainController<Admin> {

    @Autowired
    AdminDataModel model;

    @Autowired
    ShopDataModel shopModel;

    //region POST requests

    /**
     * Adds a single Admin to the application
     * @param id REQUIRED Admin's Admin ID
     * @param firstName REQUIRED Admin's first name
     * @param lastName REQUIRED Admin's last name
     */
    @PostMapping
    public void addAdmin(@RequestParam Integer id,
                           @RequestParam String firstName,
                           @RequestParam String lastName ) {
        Admin newAdmin = new Admin(id, firstName, lastName);
        model.add(newAdmin);
    }

    /**
     * Updates a single Admin's information
     * @param id REQUIRED Admin ID of the Admin being updated
     * @param firstName OPTIONAL Admin's updated first name
     * @param lastName OPTIONAL Admin's updated last name
     */
    @PatchMapping(path = "/{id}")
    public void updateAdmin(@PathVariable Integer id,
                              @RequestParam (required = false) String firstName,
                              @RequestParam (required = false) String lastName) {
        model.update(id, firstName, lastName);
    }

    //endregion
}
