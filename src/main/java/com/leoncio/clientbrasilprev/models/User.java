package com.leoncio.clientbrasilprev.models;

import com.leoncio.clientbrasilprev.dtos.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Entity(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email with wrong format")
    @Column(unique = true)
    private String username;

    @NotBlank(message = "Password is mandatory")
    private String password;

    private LocalDateTime createdAt;

    private List<Role> roles;

    public User(User user) {
        this.id = user.id;
        this.name = user.getName();
        this.username = user.getUsername();
        this.createdAt = user.getCreatedAt();
        this.roles = user.getRoles();
        this.password = user.getPassword();
    }

    public User(UserDTO userDto) {
        this.id = userDto.getId();
        this.name = userDto.getName();
        this.username = userDto.getEmail();
        this.createdAt = LocalDateTime.now();
        this.password = userDto.getPassword();
        this.roles = Collections.singletonList(new Role());
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
