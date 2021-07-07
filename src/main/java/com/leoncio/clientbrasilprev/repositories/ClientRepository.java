package com.leoncio.clientbrasilprev.repositories;

import com.leoncio.clientbrasilprev.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
}