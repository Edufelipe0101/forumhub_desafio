package br.com.forum.hub.controller;

import br.com.forum.hub.domain.usuario.DadosLoginDTO;
import br.com.forum.hub.domain.usuario.Usuario;
import br.com.forum.hub.infra.security.DadosTokenJWT;
import br.com.forum.hub.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody DadosLoginDTO dados) {

        var authToken =
                new UsernamePasswordAuthenticationToken(
                        dados.login(),
                        dados.senha()
                );

        var authentication = manager.authenticate(authToken);

        var token = tokenService.gerarToken(
                (Usuario) authentication.getPrincipal()
        );

        return ResponseEntity.ok(new DadosTokenJWT(token));
    }
}
