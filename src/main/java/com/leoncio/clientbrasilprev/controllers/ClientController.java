package com.leoncio.clientbrasilprev.controllers;

import com.leoncio.clientbrasilprev.config.Const;
import com.leoncio.clientbrasilprev.dtos.ClientDTO;
import com.leoncio.clientbrasilprev.dtos.Response;
import com.leoncio.clientbrasilprev.forms.ClientForm;
import com.leoncio.clientbrasilprev.models.Client;
import com.leoncio.clientbrasilprev.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("clients")
//@Secured(Const.ROLE_ADMIN)
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(produces = "application/json")
    public Response list() {
        return new Response(clientService.findAll());
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public Response show(@PathVariable Long id) {
        return new Response(clientService.findClientById(id));
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public Response edit(@PathVariable Long id, @Valid @RequestBody ClientForm clientForm) {
        ClientDTO clientDTO = new ClientDTO(clientForm);
        clientDTO.setId(id);
        return new Response(clientService.save(clientDTO));
    }

    @PostMapping(produces = "application/json")
    public Response create(@RequestBody @Valid ClientForm clientForm) {
        return new Response(clientService.save(new ClientDTO(clientForm)));
    }

    @DeleteMapping(path = "/{id}", produces = "application/json")
    public Response destroy(@PathVariable Long id) {
        clientService.destroy(id);
        return new Response("Client was removed successfully");
    }
}
