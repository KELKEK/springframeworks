package com.test.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {

    @Autowired
    private EmailService emailService;

    private String generatedCode;

    @GetMapping("/sendCode")
    public String showSendCodeForm() {
        return "sendCodeForm";
    }

    @PostMapping("/sendCode")
    public String sendCode(@RequestParam("email") String email, Model model) {
        generatedCode = CodeGenerator.generateCode();
        emailService.sendSimpleMessage(email, "Your Verification Code", "Your code is: " + generatedCode);
        model.addAttribute("message", "Verification code sent to " + email);
        return "verifyCodeForm";
    }

    @PostMapping("/verifyCode")
    public String verifyCode(@RequestParam("code") String code, Model model) {
        if (code.equals(generatedCode)) {
            model.addAttribute("message", "Verification successful!");
            return "success";
        } else {
            model.addAttribute("message", "Invalid code. Please try again.");
            return "verifyCodeForm";
        }
    }
}