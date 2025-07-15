package com.exemplo.agendamento.controller;

import com.exemplo.agendamento.dto.ServicoDTO;
import com.exemplo.agendamento.model.Servico;
import com.exemplo.agendamento.model.Usuario;
import com.exemplo.agendamento.service.ServicoService;
import com.exemplo.agendamento.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {
    @Autowired
    private ServicoService servicoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Servico> listar() {
        return servicoService.listar();
    }

    @PostMapping
    public ResponseEntity<Servico> cadastrar(@Valid @RequestBody ServicoDTO dto, Authentication auth) {
        Usuario prestador = usuarioService.buscarPorEmail(auth.getName());
        Servico servico = new Servico();
        servico.setNome(dto.getNome());
        servico.setDescricao(dto.getDescricao());
        servico.setPrestador(prestador);
        return ResponseEntity.ok(servicoService.salvar(servico));
    }
}