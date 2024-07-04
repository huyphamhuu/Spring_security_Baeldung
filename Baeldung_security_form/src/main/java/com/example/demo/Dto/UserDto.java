package com.example.demo.Dto;

import com.example.demo.validation.PasswordMatches;
import com.example.demo.validation.ValidEmail;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
public class UserDto {
    @NotNull
    @NotEmpty
    @Size(min = 1, message = "{Size.userDto.firstName}")
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(min = 1, message = "{Size.userDto.lastName}")
    private String lastName;

    @PasswordMatches
    private String password;

    @NotNull
    @Size(min = 1)
    private String matchingPassword;

    @NotNull
    @Size(min = 1, message = "{Size.userDto.email}")
    @ValidEmail
    private String email;

    private boolean isUsing2FA;

    public @NotNull @NotEmpty @Size(min = 1, message = "{Size.userDto.firstName}") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotNull @NotEmpty @Size(min = 1, message = "{Size.userDto.firstName}") String firstName) {
        this.firstName = firstName;
    }

    public @NotNull @NotEmpty @Size(min = 1, message = "{Size.userDto.lastName}") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotNull @NotEmpty @Size(min = 1, message = "{Size.userDto.lastName}") String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public @NotNull @Size(min = 1) String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(@NotNull @Size(min = 1) String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

}
