package com.unibh.assistencia.controller;

import com.unibh.assistencia.model.*;
import com.unibh.assistencia.service.OrdemServicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordens")
public class OrdemServicoController {

    private final OrdemServicoService service;

    public OrdemServicoController(OrdemServicoService service) {
        this.service = service;
    }

    @PostMapping
    public OrdemServico criar(
            @RequestParam String descricao,
            @RequestParam Long clienteId) {

        return service.criar(descricao, clienteId);
    }

    @GetMapping
    public List<OrdemServico> listar() {
        return service.listar();
    }

    @PutMapping("/{id}")
    public OrdemServico atualizar(
            @PathVariable Long id,
            @RequestParam StatusOrdem status) {

        return service.atualizarStatus(id, status);
    }
}
