package br.com.forum.hub.domain.topico.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTopicoDTO(
        @NotBlank String titulo,
        @NotBlank String mensagem,
        @NotBlank String autor,
        @NotBlank String curso
) {
}
