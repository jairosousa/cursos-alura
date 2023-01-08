package com.jnsdev.backend.dto;

import com.jnsdev.backend.dto.user.UserDTO;
import com.jnsdev.backend.model.User;

/**
 * @Autor Jairo Nascimento
 * @Created 06/01/2023 - 12:25
 */
public class DTOConverter {

    public static UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome(user.getNome());
        userDTO.setCpf(user.getCpf());
        userDTO.setEndereco(user.getEndereco());
        userDTO.setEmail(user.getEmail());
        userDTO.setTelefone(user.getTelefone());
        userDTO.setDataCadastro(user.getDataCadastro());
        userDTO.setKey(user.getKey());
        return userDTO;
    }
}
