package com.leoncio.clientbrasilprev.models;

import com.leoncio.clientbrasilprev.dtos.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String zipCode;
    private String uf;

    public Client(ClientDTO clientDTO) {
    }
}
