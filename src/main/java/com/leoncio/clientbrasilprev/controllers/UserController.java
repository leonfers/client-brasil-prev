package com.leoncio.clientbrasilprev.controllers;

import com.leoncio.clientbrasilprev.config.Const;
import com.leoncio.clientbrasilprev.dtos.ResponseDTO;
import com.leoncio.clientbrasilprev.forms.ClientForm;
import com.leoncio.clientbrasilprev.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("users")
public class UserController {

    private final ClientService clientService;

    @Autowired
    public UserController(ClientService clientService) {
        this.clientService = clientService;
    }


    @Secured(Const.ROLE_ADMIN)
    @GetMapping(produces = "application/json")
    public ResponseDTO list() {
        return null;
    }

    @Secured(Const.ROLE_ADMIN)
    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO show(@PathVariable String id) {
        return null;
    }

    @Secured(Const.ROLE_ADMIN)
    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO edit(@PathVariable String id, @Valid @RequestBody ClientForm clientForm) {
        return null;
    }

    @PostMapping(produces = "application/json")
    public ResponseDTO create(@RequestBody @Valid ClientForm clientForm) {
        return null;
    }

    @Secured(Const.ROLE_ADMIN)
    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO destroy(@PathVariable String id) {
        return null;
    }
}
