package com.exemplo.agendamento.repository;

import com.exemplo.agendamento.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}