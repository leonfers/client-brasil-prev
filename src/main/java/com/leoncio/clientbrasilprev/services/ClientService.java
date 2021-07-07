package com.leoncio.clientbrasilprev.services;

import com.leoncio.clientbrasilprev.dtos.ClientDTO;

import java.util.List;

public interface ClientService {

    List<ClientDTO> findAll();

    ClientDTO findClientById(Long id);

    ClientDTO save(ClientDTO client);

    void destroy(Long id);
}
