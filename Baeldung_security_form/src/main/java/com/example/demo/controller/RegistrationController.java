package com.example.demo.controller;

import com.example.demo.model.Users;
import com.example.demo.repo.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Dto.UserDto;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import jakarta.validation.*;
import org.springframework.validation.*;
import com.example.demo.exception.UserAlreadyExistException;
import org.springframework.http.ResponseEntity;
@RestController
public class RegistrationController {
    private IUserService userService;
    @GetMapping("/user/registration2")
    public String showRegistrationForm(HttpServletRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @GetMapping("/user/registration")
    public ModelAndView ShowRegisForm(@ModelAttribute("user") @Valid UserDto userDto, Errors errors){
        ModelAndView mav = new ModelAndView("registration");
        try {
            Users registered = userService.registerNewUserAccount(userDto);
        } catch (UserAlreadyExistException uaeEx) {
            mav.addObject("message", "An account for that username/email already exists.");
            return mav;
        }
        return mav;
    }
    @GetMapping("/testapi")
    public ResponseEntity<String> testapi() {
        return ResponseEntity.ok("testtest");
    }

}

//Model:pass data from the controller to the view(like thymealeaf)
// HttpServletRequest object is  necessary if you  need to access request-specific information.(thong tin request)
// model addAttribute to the file html, when return a string, View Resolver view template file registration.html located in the src/main/resources/templates directory.
// String render ra template html, Modelandview render ra view và dữ liệu model