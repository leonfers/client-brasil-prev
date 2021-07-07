package com.leoncio.clientbrasilprev.forms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientForm {
    private String name;
    private String cpf;
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String zipCode;
    private String uf;
}
