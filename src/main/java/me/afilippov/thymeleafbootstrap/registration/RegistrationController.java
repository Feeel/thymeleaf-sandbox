package me.afilippov.thymeleafbootstrap.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    private static final String REGISTRATION_TEMPLATE = "registration";

    @GetMapping
    public String showRegistrationPage(Model model) {
        LOGGER.info("Showing the registration page with new model.");

        model.addAttribute("registrationDetails", new RegistrationDetails());
        return REGISTRATION_TEMPLATE;
    }

    @PostMapping("/register")
    public String submitRegistrationForm(
            @Valid @ModelAttribute RegistrationDetails registrationDetails,
            BindingResult bindingResult) {

        LOGGER.info("Submitting the registration form: {}.", registrationDetails);

        if (bindingResult.hasErrors()) {
            return REGISTRATION_TEMPLATE;
        }
        return "redirect:/success?username=" + registrationDetails.getUsername();
    }

    @GetMapping("/success")
    public ModelAndView showRegistrationConfirmation(@RequestParam("username") String username) {
        LOGGER.info("User {} was registered.", username);
        return new ModelAndView("confirmation", "username", username);
    }
}
