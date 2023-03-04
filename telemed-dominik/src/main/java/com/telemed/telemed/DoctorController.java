package com.telemed.telemed;


import com.telemed.telemed.model.RecordRepository;
import com.telemed.telemed.model.User;
import com.telemed.telemed.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoctorController {

    User currUser;
    @Autowired
    UserRepository userRepository;

    @Autowired

    RecordRepository recordRepository;



    @GetMapping("/")
    public String showLogin(Model model) {
        return "login.html";
    }



    @GetMapping("/patients")
    public String showUsers(Model model) {
        currUser = LoginController.currUser;
        model.addAttribute(userRepository.findByType(1));
        model.addAttribute("currUser",currUser);
        return "doctor_dashboard.html";
    }

    @GetMapping("/newPatient")
    public String newPatient(Model model) {
        model.addAttribute(currUser);
        return "new_patient.html";
    }

    @GetMapping("/addPatient")
    public String addPatient(String email, String password, String firstName, String lastName, String phoneNumber, String mbo) {
        User newUser = new User(email, password, firstName, lastName, phoneNumber, mbo);
        userRepository.save(newUser);
        return "redirect:/patients";
    }

    @GetMapping("/deletePatient")
    public String deletePatient(long id, Model model) {
        recordRepository.deleteByUserId(id);
        userRepository.deleteById(id);
        return "redirect:/patients";
    }

}
