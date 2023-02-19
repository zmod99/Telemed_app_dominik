package com.telemed.telemed;

import com.telemed.telemed.model.Record;
import com.telemed.telemed.model.RecordRepository;
import com.telemed.telemed.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.telemed.telemed.model.User;

import java.util.Date;
import java.util.Optional;


@Controller
public class PatientController {

    User currUser;



    @Autowired

    RecordRepository recordRepository;

    @Autowired
    UserRepository userRepository;



    @GetMapping("/records")
    public String showRecords(long userId, Model model) {
         currUser = LoginController.currUser;
        model.addAttribute(recordRepository.findByUser(currUser));
        model.addAttribute("currUser", currUser);
        return "patient_dashboard.html";
    }

    @GetMapping("/newRecord")
    public String newRecord(long userId, Model model) {

        model.addAttribute("currUser",currUser);
        return "new_record.html";
    }

    @GetMapping("/addRecord")
    public String addRecord(long userId, int sistol, int dijastol, int otkucaji, String text) {
        recordRepository.save(new Record(new Date(), currUser, sistol, dijastol, otkucaji, text));
        return "redirect:/records?userId=" + userId;
    }
}
