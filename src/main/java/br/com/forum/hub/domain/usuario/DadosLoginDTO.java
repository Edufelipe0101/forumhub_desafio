package br.com.forum.hub.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosLoginDTO(
        @NotBlank String login,
        @NotBlank String senha
) {}