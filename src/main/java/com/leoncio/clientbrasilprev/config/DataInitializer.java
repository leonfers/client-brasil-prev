package com.leoncio.clientbrasilprev.config;

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

import java.util.List;

@Component
@Profile("!dev")
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
//        if (Boolean.parseBoolean(System.getProperty("DEBUG"))) {
//            List<User> users = userRepository.findAll();
//            if (users.isEmpty()) {
//                createUser("Admin", "admin@admin.com", passwordEncoder.encode("123456"), Const.ROLE_ADMIN);
//                createUser("Cliente Teste 1", "cliente1@email.com", passwordEncoder.encode("123456"), Const.ROLE_CLIENT);
//            }
//            List<Bank> banks = bankRepository.findAll();
//            if (banks.isEmpty()) {
//                setupSampleData();
//            }
//        } else {
//            roleRepository.save(new Role(Const.ROLE_ADMIN));
//            roleRepository.save(new Role(Const.ROLE_CLIENT));
//        }
    }

    public void createUser(String name, String email, String password, String roleName) {
//        Role role = new Role(roleName);
//        this.roleRepository.save(role);
//        User user = new User(name, email, password, Arrays.asList(role));
//        user.setCreatedAt(LocalDateTime.now());
//        userRepository.save(user);
    }

    public void setupSampleData() {
//        List<Bank> banks = new ArrayList<>();
//        banks.add(new Bank("001", "BANCO DO BRASIL S.A"));
//        banks.add(new Bank("237", "BRADESCO S.A"));
//        banks.add(new Bank("260", "NU PAGAMENTOS S.A "));
//        banks.add(new Bank("380", "PicPay Servicos S.A."));
//        banks.add(new Bank("077", "BANCO INTER S.A"));
//        banks.add(new Bank("341", "ITAÚ UNIBANCO S.A"));
//        banks.add(new Bank("104", "CAIXA ECONÔMICA FEDERAL"));
//        banks.forEach(bankRepository::save);
//        List<Branch> branches = new ArrayList<>();
//        banks.forEach(bank -> {
//            Branch branch = new Branch("0001", bank);
//            branches.add(branch);
//            branchRepository.save(branch);
//        });
//        List<User> users = userRepository.findAll();
//        branches.forEach(branch -> {
//            users.forEach(user -> {
//                Account account = new Account(branch, LocalDateTime.now(), user);
//                accountRepository.save(account);
//            });
//        });
    }

}
