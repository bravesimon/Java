package com.example.formula1.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("db")
public class DbController {
    @Autowired private GpModelRepo gpModelRepo;
    @Autowired private PilotModelRepo pilotModelRepo;
    @Autowired private ResultRepo resultRepo;

    @GetMapping("/")
    public String Fooldal(Model model, String uzenet) {
        model.addAttribute("gps", GetGps());
        return "dbindex";
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

    String Get() {
        String htmlString="";

        for(Result result: resultRepo.findAll()) {
            htmlString+=result.getDate()+"; "+result.getPilotId()+result.getPlace()+"; "+result.getMistake()+"; "+result.getTeam()+"; "+ result.getType()+"; "+result.getMotor();
            htmlString+="<br>";
        }

        return htmlString;
    }
}
