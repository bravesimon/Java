package com.example.formula1web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd h:m");

    @Autowired private FormModelRepo formModelRepo;

    @Autowired private GpModelRepo gpModelRepo;
    @Autowired private PilotModelRepo pilotModelRepo;
    @Autowired private ResultRepo resultRepo;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/home/gp")
    public String gpPage(Model model) {
        model.addAttribute("foundDB", GetGps());
        return "user";
    }

    @GetMapping("/home/pilot")
    public String pilotsPage(Model model) {
        model.addAttribute("foundDB", GetPilots());
        return "user";
    }

    @GetMapping("/home/result")
    public String resultsPage(Model model) {
        model.addAttribute("foundDB", GetResults());
        return "user";
    }

    @GetMapping("/home")
    public String user(Model model) {
        return "user";
    }

    @GetMapping("/admin/home")
    public String admin(Model model) {
        model.addAttribute("foundDB", GetMessages());
        return "admin";
    }

    @GetMapping("/regisztral")
    public String greetingForm(Model model) {
        model.addAttribute("reg", new User());
        return "regisztral";
    }

    @PostMapping("/regisztral_feldolgoz")
    public String Registration(@ModelAttribute User user, Model model) {
       for(User foundUser: userRepo.findAll()) {
            if (foundUser.getEmail().equals(user.getEmail())) {
                model.addAttribute("uzenet", "A regisztrációs email már foglalt!");
                return "registration_error";
            }
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_Vendeg");

        try {
            userRepo.save(user);
        } catch (Exception e) {
            model.addAttribute("uzenet", "Hiba lepett fel!");
            return "registration_error";
        }

        model.addAttribute("id", user.getId());
        return "registration_successful";
    }

    @GetMapping("/sendForm")
    public String sendForm(Model model) {
        model.addAttribute("form", new FormModel());
        return "sendform";
    }

    @PostMapping("/uzenet_feldolgoz")
    public String UzenetFeldolgoz(@ModelAttribute FormModel form, Model model) {

        try {
            String timeStamp = dateFormat.format(Calendar.getInstance().getTime());
            form.setSent(timeStamp);
            formModelRepo.save(form);
            model.addAttribute("msg", "Uzenet elkuldve!");
        } catch (Exception e) {
            model.addAttribute("msg", "Hiba lepett fel, nem sikerult elkuldeni!");
        }

        return "index";
    }

    String GetGps() {
        String htmlString="";

        for(GpModel gpmodel: gpModelRepo.findAll()) {
            htmlString+=gpmodel.getName()+"; "+gpmodel.getDate()+"; "+gpmodel.getDate();
            htmlString+="<br>";
        }

        return htmlString;
    }

    String GetPilots() {
        String htmlString = "";

        for (PilotModel pilotModel : pilotModelRepo.findAll()) {
            htmlString += pilotModel.getIdentifier() + "; " + pilotModel.getName() + "; " + pilotModel.getSex() + ";" + pilotModel.getBirthDate() + "; " + pilotModel.getNation();
            htmlString += "<br>";
        }

        return htmlString;
    }

    String GetResults() {
        String htmlString="";

        for(Result result: resultRepo.findAll()) {
            htmlString+=result.getDate()+"; "+result.getPilotId()+result.getPlace()+"; "+result.getMistake()+"; "+result.getTeam()+"; "+ result.getType()+"; "+result.getMotor();
            htmlString+="<br>";
        }

        return htmlString;
    }

    String GetMessages() {
        if (formModelRepo.findAll().isEmpty()) {
            return new String();
        }

        List<FormModel> sortedList = formModelRepo.findAll();
        Collections.sort(sortedList, (a, b) -> {
            try {
                return dateFormat.parse(a.getSent()).before(dateFormat.parse(b.getSent())) ? 1 : -1;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });

        String htmlString="<table><tr><th>Nev</th><th>Ido</th><th>Uzenet</th></tr>";

        for (FormModel form : sortedList) {
            htmlString+="<tr> <td>" + form.getName() + "</td>";
            htmlString+="<td>" + form.getSent() + "</td>";
            htmlString+="<td>" + form.getMessage() + "</td> </tr>";
        }

        htmlString+="</table>";
        return htmlString;
    }
}
