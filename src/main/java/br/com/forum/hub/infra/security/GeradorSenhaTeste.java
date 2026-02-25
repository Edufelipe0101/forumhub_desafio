package br.com.forum.hub.infra.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class GeradorSenhaTeste implements CommandLineRunner {

    private final PasswordEncoder encoder;

    public GeradorSenhaTeste(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public void run(String... args) {
        System.out.println(encoder.encode("123456"));
    }
}
