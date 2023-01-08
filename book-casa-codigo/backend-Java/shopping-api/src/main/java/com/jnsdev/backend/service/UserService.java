package com.jnsdev.backend.service;

import com.jnsdev.backend.dto.user.UserDTO;
import com.jnsdev.backend.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * @Autor Jairo Nascimento
 * @Created 06/01/2023 - 13:36
 */
@Service
public class UserService {

    public UserDTO getUserByCpf(String cpf) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8080/user/cpf/" + cpf;
            ResponseEntity<UserDTO> response =
                    restTemplate.getForEntity(url, UserDTO.class);
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new UserNotFoundException();
        }
    }
}
