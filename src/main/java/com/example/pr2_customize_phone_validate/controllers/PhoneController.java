package com.example.pr2_customize_phone_validate.controllers;


import com.example.pr2_customize_phone_validate.models.PhoneNumber;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PhoneController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "/index";
    }

    @PostMapping("/")
    public ModelAndView checkValidation(@ModelAttribute("phoneNumber") PhoneNumber phoneNumber,
                                        BindingResult bindingResult) {
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/index");
        } else {
            return new ModelAndView("/result");
        }
    }
}