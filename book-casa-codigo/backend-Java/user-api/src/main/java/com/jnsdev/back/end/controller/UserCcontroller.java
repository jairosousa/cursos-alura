package com.jnsdev.back.end.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jnsdev.back.end.dto.UserDTO;
import com.jnsdev.back.end.service.UserService;

@RestController
public class UserCcontroller {

      @Autowired
      private UserService userService;

      public static List<UserDTO> usuarios = new ArrayList<>();

      @PostConstruct
      public void initiateList() {

            UserDTO userDTO = new UserDTO();
            userDTO.setNome("Eduardo");
            userDTO.setCpf("123");
            userDTO.setEndereco("Rua A");
            ;
            userDTO.setEmail("eduardo@emeal.com");
            userDTO.setTelefone("1234-3454");
            userDTO.setDataCadastro(new Date());

            UserDTO userDTO2 = new UserDTO();
            userDTO2.setNome("Luiz");
            userDTO2.setEndereco("Rua B");
            ;
            userDTO2.setEmail("luiz@emeal.com");
            userDTO2.setTelefone("1234-3455");
            userDTO2.setDataCadastro(new Date());
            userDTO2.setCpf("456");

            UserDTO userDTO3 = new UserDTO();
            userDTO3.setNome("Bruna");
            userDTO3.setEndereco("Rua C");
            userDTO3.setEmail("bruna@emeal.com");
            userDTO3.setTelefone("1234-3456");
            userDTO3.setDataCadastro(new Date());
            userDTO3.setCpf("789");

            usuarios.add(userDTO);
            usuarios.add(userDTO2);
            usuarios.add(userDTO3);
      }

      @GetMapping("/")
      public String getMensagem() {
            return "Spring boot is working!";
      }

      @GetMapping("/users")
      public List<UserDTO> gerUsersDtos() {
            return usuarios;
      }

      @GetMapping("/users/{cpf}")
      public UserDTO gerUsersFiltro(@PathVariable String cpf) {
            for (UserDTO dto : usuarios) {
                  if (dto.getCpf().equals(cpf)) {
                        return dto;
                  }
            }
            return null;
      }

      @PostMapping("/newUser")
      UserDTO inserir(@RequestBody UserDTO userDTO) {
            userDTO.setDataCadastro(new Date());
            usuarios.add(userDTO);
            return userDTO;
      }

      @DeleteMapping("/users/{cpf}")
      public boolean remover(@PathVariable String cpf) {
            for (UserDTO dto : usuarios) {
                  if (dto.getCpf().equals(cpf)) {
                        usuarios.remove(dto);
                        return true;
                  }
            }
            return false;
      }

}
