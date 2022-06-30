package info.oldcolony.shopplacementapp.controllers.users;

import info.oldcolony.shopplacementapp.controllers.MainController;
import info.oldcolony.shopplacementapp.model.admin.Admin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring REST controller class that handles all HTTP request for the Admin resource, including adding, removing,
 * updating, and deleting users from the {@code ShopPlacementModel}
 */

@RestController
@RequestMapping(path="/api/v1/users/admins")
public class AdminController extends MainController<Admin> {



}
