package com.modernfrontendshtmx.contactsapp;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.expression.Strings;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    @GetMapping
    public String viewContract(Model model, @RequestParam(value = "q", required = false) String query) {
        List<Contact> contacts;
        if (query != null) {
            model.addAttribute("query", query);
            contacts = contactService.searchContact(query);
        } else {
            contacts = contactService.getAll();
        }
         model.addAttribute("contacts", contacts);
        return "contacts/list";
    }

    @GetMapping("/new")
    public String newContact(Model model) {
        model.addAttribute("formData",new CreateContactFormData());
        return "contacts/edit";
    }
    @PostMapping("/new")
    public String createNewContact(Model model, @ModelAttribute("formData") @Valid CreateContactFormData formData, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "contacts/edit";
        }
        contactService.storeNewContact(formData.getGivenName(),formData.getFamilyName(), formData.getPhone(), formData.getEmail());
        return "redirect:/contacts";
    }

}
