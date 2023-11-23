package com.example.formula1;

import com.example.formula1.db.DbController;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainPageController {
    private static final int  kMinChar = 4;

    private List<LoginModel> logins;

    MainPageController() {
        logins = new ArrayList<>();
        logins.add(new LoginModel("admin", "123456"));
    }

    @GetMapping("/")
    public String MainPage(Model model) {
        return "index";
    }

    @GetMapping("/loggedin")
    public String LoggedinPage(Model model) {
        return "loggedin";
    }

    @GetMapping("/login")
    public String Login(Model model) {
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/loggedin")
    public String Loggedin(@Valid @ModelAttribute LoginModel loginModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }

        if (loginModel == null || loginModel.getEmail().length() < kMinChar || loginModel.getPassword().length() < kMinChar ) {
            model.addAttribute("msg", String.format("Hibas adatokat adott meg. Email es jelszo minimum karakter hossz: %d!", kMinChar) );
            return "error";
        }

        if (!logins.contains(loginModel)) {
            model.addAttribute("msg", "Nincs ilyen felhasznalo!");
            return "error";
        }

        model.addAttribute("loginModelAttr", loginModel);
        //model.addAttribute("gps", DbController);

        return "loggedin";
    }

    @GetMapping("/register")
    public String Register(Model model) {
        model.addAttribute("loginModel", new LoginModel());
        return "register";
    }

    @PostMapping("/registered")
    public String Registered(@Valid @ModelAttribute LoginModel loginModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }

        if (loginModel == null || loginModel.getEmail().length() < kMinChar || loginModel.getPassword().length() < kMinChar ) {
            model.addAttribute("msg", String.format("Hibas adatokat adott meg. Email es jelszo minimum karakter hossz: %d!", kMinChar) );
            return "error";
        }

        logins.add(loginModel);

        model.addAttribute("loginModelAttr", loginModel);
        return "registered";
    }
}
