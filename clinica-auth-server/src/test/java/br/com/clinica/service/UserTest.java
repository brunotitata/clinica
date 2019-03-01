package br.com.clinica.service;

import java.util.Base64;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Test
    public void criarUsuario() {

        String code = "clinica:$2a$10$NNMU0qi29IGF1100JAJpyezpz/slGXxhl6CPzOzf5Wo.ZW2ITjns.";
        System.out.println("#######: "
                + Base64.getEncoder().encodeToString(code.getBytes()));

        System.out.println(
                "######## SENHA : " + bCryptPasswordEncoder.encode("123456"));
    }

}
