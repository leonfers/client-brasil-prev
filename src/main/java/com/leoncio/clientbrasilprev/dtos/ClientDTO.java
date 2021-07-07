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
    private String neighborhood;
    private String zipCode;
    private String city;
    private String uf;

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.street = client.getStreet();
        this.neighborhood = client.getNeighborhood();
        this.number = client.getNumber();
        this.zipCode = client.getZipCode();
        this.city = client.getCity();
        this.uf = client.getUf();
    }

    public ClientDTO(ClientForm clientForm) {
        this.name = clientForm.getName();
        this.cpf = clientForm.getCpf();
        this.street = clientForm.getStreet();
        this.neighborhood = clientForm.getNeighborhood();
        this.number = clientForm.getNumber();
        this.zipCode = clientForm.getZipCode();
        this.city = clientForm.getCity();
        this.uf = clientForm.getUf();
    }
}
