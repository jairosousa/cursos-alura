package com.jnsdev.backend.service;

import com.jnsdev.backend.dto.DTOConverter;
import com.jnsdev.backend.dto.user.UserDTO;
import com.jnsdev.backend.model.User;
import com.jnsdev.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        Optional<User> usuario = userRepository.findById(id);

        if (usuario.isPresent()) {
            return DTOConverter.convert(usuario.get());
        }
        return null;
    }

    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(User.convert(userDTO));
        return DTOConverter.convert(user);
    }

    public UserDTO delete(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
        return null;
    }

    public UserDTO findByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);

        if (user != null) {
            return DTOConverter.convert(user);
        }
        return null;
    }

    public List<UserDTO> queryByName(String nome) {
        List<User> usuarios = userRepository.queryByNomeLike("%".concat(nome).concat("%"));

        return usuarios
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }

}
