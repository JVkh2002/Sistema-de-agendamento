package com.exemplo.agendamento.controller;

import com.exemplo.agendamento.model.Servico;
import com.exemplo.agendamento.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {
    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public List<Servico> listar() {
        return servicoService.listar();
    }

    @PostMapping
    public ResponseEntity<Servico> cadastrar(@RequestBody Servico servico) {
        return ResponseEntity.ok(servicoService.salvar(servico));
    }
}