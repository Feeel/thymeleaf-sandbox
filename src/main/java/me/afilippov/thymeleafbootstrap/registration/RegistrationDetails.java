package me.afilippov.thymeleafbootstrap.registration;

import org.springframework.core.style.ToStringCreator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class RegistrationDetails {
    @NotBlank(message = "Username must be specified")
    private String username;
    @NotBlank(message = "Password must be specified")
    private String password;
    @NotBlank(message = "Email must be specified")
    @Email
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("username", username)
                .append("email", email)
                .append("password", password)
                .toString();
    }
}
