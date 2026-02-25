package br.com.forum.hub.controller;

import br.com.forum.hub.domain.topico.Topico;
import br.com.forum.hub.repository.TopicoRepository;
import br.com.forum.hub.domain.topico.dto.DadosAtualizacaoTopicoDTO;
import br.com.forum.hub.domain.topico.dto.DadosCadastroTopicoDTO;
import br.com.forum.hub.domain.topico.dto.DadosDetalhamentoTopicoDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid DadosCadastroTopicoDTO dados) {

        if (repository.existsByTituloAndMensagem(dados.titulo(), dados.mensagem())) {
            return ResponseEntity.badRequest().body("Tópico duplicado");
        }

        Topico topico = new Topico(dados);

        repository.save(topico);

        return ResponseEntity.ok(new DadosDetalhamentoTopicoDTO(topico));
    }

    @GetMapping
    public List<DadosDetalhamentoTopicoDTO> listar() {
        return repository.findAll().stream()
                .map(DadosDetalhamentoTopicoDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhar(@PathVariable Long id) {
        return repository.findById(id)
                .map(t -> ResponseEntity.ok(new DadosDetalhamentoTopicoDTO(t)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid DadosAtualizacaoTopicoDTO dados
    ) {
        return repository.findById(id)
                .map(topico -> {
                    topico.setTitulo(dados.titulo());
                    topico.setMensagem(dados.mensagem());
                    return ResponseEntity.ok(new DadosDetalhamentoTopicoDTO(topico));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}