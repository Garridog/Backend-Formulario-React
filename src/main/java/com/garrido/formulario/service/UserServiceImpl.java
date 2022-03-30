package com.garrido.formulario.service;

import com.garrido.formulario.dao.UserRepository;
import com.garrido.formulario.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public void persistUser(User user) {
        isValid(user.getNombre());
        isValid(user.getCorreo());
        isValid(user.getFecha());
        isValid(user.getSexo());
        userRepository.save(user);
    }

    private boolean isValid(String value) {
        if (value == null || value.equals(""))
            throw new IllegalArgumentException("Valor no valido");

        return true;
    }
}
