package com.jnsdev.backend.service;

import com.jnsdev.backend.dto.user.UserDTO;
import com.jnsdev.backend.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @Autor Jairo Nascimento
 * @Created 06/01/2023 - 13:36
 */
@Service
public class UserService {

    @Value("${USER_API_URL:http://localhost:8080}")
    private String userApiURL;

    public UserDTO getUserByCpf(String cpf, String key) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            String url = userApiURL + "/user/cpf/" + cpf;

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            builder.queryParam("key", key);

            System.out.println("URL: " + builder.toUriString());

            ResponseEntity<UserDTO> response =
                    restTemplate.getForEntity(builder.toUriString(), UserDTO.class);

            return response.getBody();

        } catch (HttpClientErrorException.NotFound e) {
            throw new UserNotFoundException();
        }
    }
}
