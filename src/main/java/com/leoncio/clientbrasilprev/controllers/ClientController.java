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
@RequestMapping("clients")
@Secured(Const.ROLE_ADMIN)
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping(produces = "application/json")
    public ResponseDTO list() {
        return null;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO show(@PathVariable String id) {
        return null;
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO edit(@PathVariable String id, @Valid @RequestBody ClientForm clientForm) {
        return null;
    }

    @PostMapping(produces = "application/json")
    public ResponseDTO create(@RequestBody @Valid ClientForm clientForm) {
        return null;
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseDTO destroy(@PathVariable String id) {
        return null;
    }
}
