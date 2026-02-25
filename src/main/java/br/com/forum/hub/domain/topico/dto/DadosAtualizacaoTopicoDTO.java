package br.com.forum.hub.domain.topico.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoTopicoDTO(
        @NotBlank String titulo,
        @NotBlank String mensagem
) {
}
