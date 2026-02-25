package br.com.forum.hub.domain.topico.dto;

import br.com.forum.hub.domain.topico.StatusTopico;
import br.com.forum.hub.domain.topico.Topico;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopicoDTO(
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        StatusTopico status,
        String autor,
        String curso
) {
    public DadosDetalhamentoTopicoDTO(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
