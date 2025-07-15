package com.exemplo.agendamento.controller;

import com.exemplo.agendamento.dto.AgendamentoDTO;
import com.exemplo.agendamento.model.Agendamento;
import com.exemplo.agendamento.model.Servico;
import com.exemplo.agendamento.model.Usuario;
import com.exemplo.agendamento.service.AgendamentoService;
import com.exemplo.agendamento.service.ServicoService;
import com.exemplo.agendamento.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<Agendamento> agendar(@Valid @RequestBody AgendamentoDTO dto, Authentication auth) {
        Usuario cliente = usuarioService.buscarPorEmail(auth.getName());
        Servico servico = servicoService.listar().stream()
                .filter(s -> s.getId().equals(dto.getServicoId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(cliente);
        agendamento.setServico(servico);
        agendamento.setDataHora(dto.getDataHora());
        agendamento.setStatus(Agendamento.Status.AGENDADO);

        return ResponseEntity.ok(agendamentoService.salvar(agendamento));
    }

    @GetMapping
    public List<Agendamento> listar() {
        return agendamentoService.listar();
    }
}