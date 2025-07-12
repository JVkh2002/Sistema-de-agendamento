package com.exemplo.agendamento.controller;

import com.exemplo.agendamento.model.Agendamento;
import com.exemplo.agendamento.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {
    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<Agendamento> agendar(@RequestBody Agendamento agendamento) {
        return ResponseEntity.ok(agendamentoService.salvar(agendamento));
    }

    @GetMapping
    public List<Agendamento> listar() {
        return agendamentoService.listar();
    }
}