package com.leoncio.clientbrasilprev.config;

import com.leoncio.clientbrasilprev.models.Client;
import com.leoncio.clientbrasilprev.models.Role;
import com.leoncio.clientbrasilprev.models.User;
import com.leoncio.clientbrasilprev.repositories.ClientRepository;
import com.leoncio.clientbrasilprev.repositories.RoleRepository;
import com.leoncio.clientbrasilprev.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Profile("prod")
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        if (Boolean.parseBoolean(System.getProperty("DEBUG"))) {
            List<User> users = userRepository.findAll();
            if (users.isEmpty()) {
                createUser("Admin", "admin@admin.com", passwordEncoder.encode("123456"), Const.ROLE_ADMIN);
            }
            List<Client> clients = clientRepository.findAll();
            if (clients.isEmpty()) {
                createClient("Cliente de Teste", "00901903000", "000", "Rua de Teste","Bairro de Teste", "Cidade Teste","PI","6400000");

            }
        } else {
            roleRepository.save(new Role(Const.ROLE_ADMIN));
            roleRepository.save(new Role(Const.ROLE_CLIENT));
        }
    }

    /**
     * Initialize sample client data
     *
     * @param name
     * @param cpf
     * @param number
     * @param street
     * @param city
     * @param uf
     * @param zip
     */
    private void createClient(String name, String cpf, String number, String street, String neighborhood, String city, String uf, String zip) {
        Client client = new Client();
        client.setName(name);
        client.setCpf(cpf);
        client.setNumber(number);
        client.setStreet(street);
        client.setCity(city);
        client.setUf(uf);
        client.setZipCode(zip);
        client.setNeighborhood(neighborhood);
        clientRepository.save(client);
    }

    /**
     * Initialize sample user data
     *
     * @param name
     * @param email
     * @param password
     * @param roleName
     */
    public void createUser(String name, String email, String password, String roleName) {
        Role role = new Role(roleName);
        this.roleRepository.save(role);
        User user = new User(name, email, password, Collections.singletonList(role));
        user.setCreatedAt(LocalDateTime.now());
        userRepository.save(user);
    }

}
