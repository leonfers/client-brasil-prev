package com.leoncio.clientbrasilprev.services;

import com.leoncio.clientbrasilprev.dtos.ClientDTO;
import com.leoncio.clientbrasilprev.models.Client;
import com.leoncio.clientbrasilprev.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDTO> findAll() {
        return clientRepository.findAll()
                .stream().map(ClientDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO findClientById(Long id) {
        return new ClientDTO(clientRepository.findClientById(id));
    }

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        Client client;
        if (clientDTO.getId() == null) {
            client = new Client(clientDTO);
        } else {
            client = clientRepository.findClientById(clientDTO.getId());
        }
        return new ClientDTO(clientRepository.save(client));
    }

    @Override
    public void destroy(Long id) {
        clientRepository.deleteById(id);
    }
}
