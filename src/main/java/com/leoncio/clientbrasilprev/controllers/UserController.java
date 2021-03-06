package com.leoncio.clientbrasilprev.controllers;

import com.leoncio.clientbrasilprev.config.Const;
import com.leoncio.clientbrasilprev.models.User;
import com.leoncio.clientbrasilprev.repositories.RoleRepository;
import com.leoncio.clientbrasilprev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/user")
@Profile("prod")
public class UserController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid User user) {
        user = createUser(user);
        user.setRoles(null);
        user.setPassword(null);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Secured({Const.ROLE_ADMIN})
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<User> edit(@RequestBody User user) {
        user = this.userRepository.save(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @Secured({Const.ROLE_CLIENT, Const.ROLE_ADMIN})
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Page<User>> list(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
        return new ResponseEntity<>(userRepository.findAll(pageable), HttpStatus.OK);
    }

    @Transactional
    public User createUser(User user){
        user.setRoles(roleRepository.findAll());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user = this.userRepository.save(user);
        return user;
    }


}
