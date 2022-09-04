package com.example.sfgpetclinic.controller;

import com.example.sfgpetclinic.services.Ownerservice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final Ownerservice ownerservice;

    public OwnerController(Ownerservice ownerservice) {
        this.ownerservice = ownerservice;
    }

    @RequestMapping({"", "/index", "/index.html"})
    public String listOwner(Model model) {
        model.addAttribute("owners", ownerservice.findAll());
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(){
        return "notImplemented";
    }
}
