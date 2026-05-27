package com.unibh.assistencia.service;

import com.unibh.assistencia.factory.OrdemServicoFactory;
import com.unibh.assistencia.model.*;
import com.unibh.assistencia.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdemServicoService {

    private final OrdemServicoRepository repository;
    private final ClienteRepository clienteRepository;

    public OrdemServicoService(
            OrdemServicoRepository repository,
            ClienteRepository clienteRepository) {

        this.repository = repository;
        this.clienteRepository = clienteRepository;
    }

    public OrdemServico criar(String descricao, Long clienteId) {

        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow();

        OrdemServico ordem =
                OrdemServicoFactory.criar(descricao, cliente);

        return repository.save(ordem);
    }

    public List<OrdemServico> listar() {
        return repository.findAll();
    }

    public OrdemServico atualizarStatus(Long id, StatusOrdem status) {

        OrdemServico ordem =
                repository.findById(id).orElseThrow();

        ordem.setStatus(status);

        return repository.save(ordem);
    }
}
