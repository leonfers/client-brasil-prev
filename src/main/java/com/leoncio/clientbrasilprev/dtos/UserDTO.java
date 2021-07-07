package com.leoncio.clientbrasilprev.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserDTO {
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Id
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email with wrong format")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;
}
