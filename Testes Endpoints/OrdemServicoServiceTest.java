package com.unibh.assistencia.service;

import com.unibh.assistencia.model.*;
import com.unibh.assistencia.repository.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OrdemServicoServiceTest {

    @Test
    void deveAtualizarStatus() {

        OrdemServicoRepository repository =
                Mockito.mock(OrdemServicoRepository.class);

        ClienteRepository clienteRepository =
                Mockito.mock(ClienteRepository.class);

        OrdemServico ordem = new OrdemServico();

        ordem.setStatus(StatusOrdem.ABERTA);

        Mockito.when(repository.findById(1L))
                .thenReturn(Optional.of(ordem));

        Mockito.when(repository.save(ordem))
                .thenReturn(ordem);

        OrdemServicoService service =
                new OrdemServicoService(
                        repository,
                        clienteRepository);

        OrdemServico resultado =
                service.atualizarStatus(
                        1L,
                        StatusOrdem.FINALIZADA);

        assertEquals(
                StatusOrdem.FINALIZADA,
                resultado.getStatus());
    }
}
