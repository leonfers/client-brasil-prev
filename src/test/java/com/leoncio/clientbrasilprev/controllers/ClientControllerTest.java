package com.leoncio.clientbrasilprev.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leoncio.clientbrasilprev.dtos.ClientDTO;
import com.leoncio.clientbrasilprev.forms.ClientForm;
import com.leoncio.clientbrasilprev.models.Client;
import com.leoncio.clientbrasilprev.services.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles({ "test"})
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
class ClientControllerTest {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;


    @Test
    void it_should_return_list_of_clients_dto() throws Exception {
        List<ClientDTO> clients = new ArrayList<>();
        ClientDTO client = new ClientDTO();
        client.setId(1L);
        client.setName("Cliente de Teste");
        client.setCpf("00901903000");
        client.setNumber("000");
        client.setStreet("Rua de Teste");
        client.setCity("Cidade Teste");
        client.setUf("PI");
        client.setZipCode("6400000");

        clients.add(client);

        when(clientService.findAll()).thenReturn(clients);
        mockMvc.perform(MockMvcRequestBuilders.get("/clients")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].id").value(client.getId()));
    }


    @Test
    void it_should_return_one_client_dto() throws Exception {
        ClientDTO client = new ClientDTO();
        client.setId(1L);
        client.setName("Cliente de Teste");
        client.setCpf("00901903000");
        client.setNumber("000");
        client.setStreet("Rua de Teste");
        client.setCity("Cidade Teste");
        client.setUf("PI");
        client.setZipCode("6400000");

        when(clientService.findClientById(anyLong())).thenReturn(client);
        mockMvc.perform(MockMvcRequestBuilders.get("/clients/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").value(client.getId()));
    }

    @Test
    void it_should_return_one_edited_client_dto() throws Exception {
        ClientForm client = new ClientForm();
        client.setName("Cliente de Teste Editado");
        client.setCpf("00901903000");
        client.setNumber("000");
        client.setStreet("Rua de Teste");
        client.setCity("Cidade Teste");
        client.setUf("PI");
        client.setZipCode("6400000");

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(1L);
        clientDTO.setName("Cliente de Teste Editado");
        clientDTO.setCpf("00901903000");
        clientDTO.setNumber("000");
        clientDTO.setStreet("Rua de Teste");
        clientDTO.setCity("Cidade Teste");
        clientDTO.setUf("PI");
        clientDTO.setZipCode("6400000");

        when(clientService.save(any(ClientDTO.class))).thenReturn(clientDTO);
        mockMvc.perform(MockMvcRequestBuilders.put("/clients/1")
                .content(mapper.writeValueAsString(client))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.name").value(client.getName()));
    }

}