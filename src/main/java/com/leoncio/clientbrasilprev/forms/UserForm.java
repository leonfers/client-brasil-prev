package com.leoncio.clientbrasilprev.forms;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserForm {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email with wrong format")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;
}
