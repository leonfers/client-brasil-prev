package com.leoncio.clientbrasilprev.dtos;

import com.leoncio.clientbrasilprev.forms.ClientForm;
import com.leoncio.clientbrasilprev.models.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientDTO {

    private Long id;
    private String name;
    private String cpf;
    private String street;
    private String number;
    private String zipCode;
    private String city;
    private String uf;

    public ClientDTO(Client client) {
    }

    public ClientDTO(ClientForm clientForm) {
    }
}
