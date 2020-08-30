package pl.sda.final_project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {


    @GetMapping("/register")
    public String registrationForm(Model model) {
        RegistrationDto registrationDto = new RegistrationDto();
        model.addAttribute("countries", Countries.values());
        model.addAttribute("registrationObject", registrationDto);
        return "registrationPage";
    }

    @PostMapping("/register")
    public String registrationEffect(RegistrationDto registrationDto) {
        return "redirect:/login";

    }


}
