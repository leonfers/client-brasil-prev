package com.leoncio.clientbrasilprev.repositories;

import com.leoncio.clientbrasilprev.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
