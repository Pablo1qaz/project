package com.poleszczak.project.controllers;

import com.poleszczak.project.models.NewUsers;
import com.poleszczak.project.models.RegisterData;
import com.poleszczak.project.models.company.Company;
import com.poleszczak.project.models.company.CompanyType;
import com.poleszczak.project.repositories.NewUsersRepository;
import com.poleszczak.project.repositories.company.CompanyRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class CompanyController {

    @Autowired
    private CompanyRepository repo;

    @GetMapping("/company")
    public String register(Model model){
        Company company = new Company();
        model.addAttribute(company);
        model.addAttribute("success", false);
        return "company";

    }

    @GetMapping("/company/{type}")
    public String companyList(Model model, @PathVariable("type") String type) {
        var companies = repo.findByCompanyTypeTypeName(type);
        model.addAttribute("companies", companies);
        return "halls";
    }


    @PostMapping("/company")
    public String company(
            Model model,
            @Valid @ModelAttribute Company company,
            BindingResult result
    ) {


        Company company2 = repo.findByContactEmail(company.getContactEmail());
        if (company2 != null) {
            result.addError(
                    new FieldError("company", "contactEmail"
                            , "Email address is already used")
            );
        }

        String polishPhoneNumberPattern = "^(\\+48)?\\d{9}$";
        if (!company.getContactPhone().matches(polishPhoneNumberPattern)){
            result.addError(
                    new FieldError("company", "contactPhone"
                            ,"Phone Number is incorrect. Correct format +48")
            );
        }


        if (result.hasErrors()) {
            return "company";
        }

        try{

            var bCryptEncoder = new BCryptPasswordEncoder();

            Company company1 = new Company();
            company1.setName(company.getName());
            company1.setContactEmail(company.getContactEmail());
            company1.setContactPhone(company.getContactPhone());
            company1.setAddress(company.getAddress());
            company1.setWebsite(company.getWebsite());
            company1.setCompanyType(company.getCompanyType());


            repo.save(company1);


            model.addAttribute("company", new Company());
            model.addAttribute("success", true);

        }
        catch (Exception exception){
            result.addError(
                    new FieldError("company", "name"
                            , exception.getMessage())
            );
        }

        return "company";
    }


}
