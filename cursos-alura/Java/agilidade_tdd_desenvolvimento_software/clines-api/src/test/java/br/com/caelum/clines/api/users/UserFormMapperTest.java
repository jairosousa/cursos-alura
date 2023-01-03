package br.com.caelum.clines.api.users;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserFormMapperTest {

    private final String NAME = "FULANO";
    private final String EMAIL = "fulano@email.com";
    private final String PASSWORD = "123456";

    private UserFormMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new UserFormMapper();
    }

    @Test
    void shouldConvertUserToFormToUser() {
        var userForm = new UserForm(NAME, EMAIL, PASSWORD);

        var user = mapper.map(userForm);

        assertEquals(NAME, user.getName());
        assertEquals(EMAIL, user.getEmail());
        assertEquals(PASSWORD, user.getPassword());
    }
}