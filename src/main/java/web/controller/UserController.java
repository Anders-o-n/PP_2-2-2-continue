package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.ServiceUser;


@Controller
public class UserController {

    private final ServiceUser serviceUser;

    @Autowired
    public UserController(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @GetMapping()
    public String moreListServ (Model model) {
        model.addAttribute("users", serviceUser.moreListServ());
        return "moreListUsers";
    }

    @GetMapping("/{id}")
    public String inIdUsers (@PathVariable int id, Model model) {
        model.addAttribute("user", serviceUser.inIdServ(id));
        return "inIdUsers";
    }


    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "newUser";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", serviceUser.inIdServ(id));
        return "/editUser";
    }

    @PostMapping()
    public String createUser(@ModelAttribute User user) {
        serviceUser.saveUserServ (user);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable int id) {
        serviceUser.updateUserServ(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        serviceUser.deleteUserServ (id);
        return "redirect:/";
    }
}
