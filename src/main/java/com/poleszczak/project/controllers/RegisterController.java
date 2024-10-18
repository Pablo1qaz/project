package com.poleszczak.project.controllers;

import com.poleszczak.project.models.NewUsers;
import com.poleszczak.project.models.RegisterData;
import com.poleszczak.project.repositories.NewUsersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class RegisterController {

    @Autowired
    private NewUsersRepository repo;

    @GetMapping("/register")
    public String register(Model model){
        RegisterData registerData = new RegisterData();
        model.addAttribute(registerData);
        model.addAttribute("success", false);
        return "register";

    }


    @PostMapping("/register")
    public String register(
            Model model,
            @Valid @ModelAttribute RegisterData registerData,
            BindingResult result
    ) {

        if (!registerData.getPassword().equals(registerData.getConfirmPassword())) {
            result.addError(
                    new FieldError("registerData", "confirmPassword"
                            , "Password and Confirm Password do not match")
            );
        }

        NewUsers newUsers = repo.findByEmail(registerData.getEmail());
        if (newUsers != null) {
            result.addError(
                    new FieldError("registerData", "email"
                            , "Email address is already used")
            );
        }

        if (registerData.getPhoneNumber().length() != 9){
            result.addError(
                    new FieldError("registerData", "phoneNumber"
                    ,"Phone Number is incorrect")
            );
        }


        if (result.hasErrors()) {
            return "register";
        }

        try{

            var bCryptEncoder = new BCryptPasswordEncoder();

            NewUsers newUsers1 = new NewUsers();
            newUsers1.setFirstName(registerData.getFirstName());
            newUsers1.setLastName(registerData.getLastName());
            newUsers1.setEmail(registerData.getEmail());
            newUsers1.setPhoneNumber(registerData.getPhoneNumber());
            newUsers1.setAddress(registerData.getAddress());
            newUsers1.setRole("member");
            newUsers1.setCreatedAt(new Date());
            newUsers1.setPassword(bCryptEncoder.encode(registerData.getPassword()));

            repo.save(newUsers1);

            model.addAttribute("registerData", new RegisterData());
            model.addAttribute("success", true);

        }
        catch (Exception exception){
            result.addError(
                    new FieldError("registerData", "firstName"
                    , exception.getMessage())
            );
        }

        return "register";
    }


}
