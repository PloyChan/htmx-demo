package com.modernfrontendshtmx.contactsapp;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@NoDuplicateContactsByEmail
public class CreateContactFormData {
    @NotBlank
    private String givenName;
    @NotBlank
    private String familyName;
    @NotBlank
    private String phone;
    @Email
    private String email;

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

