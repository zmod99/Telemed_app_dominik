package com.telemed.telemed;

import com.telemed.telemed.model.RecordRepository;
import com.telemed.telemed.model.User;
import com.telemed.telemed.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    static User currUser;

    @Autowired
    UserRepository userRepository;

    @Autowired

    RecordRepository recordRepository;



    @GetMapping("/processLogin")
    public String processLogin(Model model, String email, String password) {
        currUser = userRepository.findByLoginEmailAndLoginPassword(email, password);
        if (userRepository.findByLoginEmailAndLoginPassword(email, password) != null) {
            if (currUser.getType() == 0) {
                return "redirect:/patients?userId=" + currUser.getId();
            } else{
                return "redirect:/records?userId=" + currUser.getId();

            }

        } else{
            model.addAttribute ("userMessage", "Pogresni unos emaila i/ili lozinke!");
            return "login.html";
        }

    }
}
