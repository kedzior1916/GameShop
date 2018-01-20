package pl.kedzierski.gameshop.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import pl.kedzierski.gameshop.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kedzierski.gameshop.services.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registration(Model model) {
        model.addAttribute("userCommand", new User());
        return "registrationForm";
    }

    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("userCommand") User userForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "registrationForm";
        }
        userService.save(userForm);
        return "registrationSuccess";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //aby użytkownik nie mógł sobie wstrzyknąć aktywacji konta oraz ról (np., ADMIN)
        //roles są na wszelki wypadek, bo warstwa serwisów i tak ustawia ROLE_USER dla nowego usera
        binder.setDisallowedFields("enabled", "roles");
    }
}
