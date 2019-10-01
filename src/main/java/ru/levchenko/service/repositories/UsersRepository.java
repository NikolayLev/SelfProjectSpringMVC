package ru.levchenko.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.levchenko.service.models.User;


import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByLogin(String login);
}
