package com.example.formula1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("db")
public class DbController {
    @Autowired private GpModelRepo gpModelRepo;
    @Autowired private PilotModelRepo pilotModelRepo;
    @Autowired private ResultRepo resultRepo;

    @GetMapping("/db/")
    public String DbMainPage(Model model) {
        String all = GetGps() + GetPilots() + GetResults();
        model.addAttribute("body", all);
        return "index2";
    }

    @GetMapping("db/gps")
    public String GpsPage(Model model) {
        model.addAttribute("body", GetGps());
        return "index2";

        // loggedin
    }

    @GetMapping("db/pilots")
    public String PilotsPage(Model model) {
        model.addAttribute("body", GetPilots());
        return "index2";
    }
    @GetMapping("db/results")
    public String ResultsPage(Model model) {
        model.addAttribute("body", GetResults());
        return "index2";
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
            htmlString += pilotModel.getIdentifier() + "; " + pilotModel.getName() + "; " + pilotModel.getSex() + ";" + pilotModel.getSzuldat() + "; " + pilotModel.getNation();
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
}
