package com.poleszczak.project.repositories;

import com.poleszczak.project.models.NewUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewUsersRepository extends JpaRepository<NewUsers, Integer> {

    public NewUsers findByEmail(String email);
}
