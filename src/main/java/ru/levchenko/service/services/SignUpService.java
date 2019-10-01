package ru.levchenko.service.services;

import ru.levchenko.service.security.forms.UserForm;
import ru.levchenko.service.models.User;

import java.util.Optional;

public interface SignUpService {
    public boolean signUp(UserForm userForm);
    public Optional<User> findByUserName(String userName);
}
