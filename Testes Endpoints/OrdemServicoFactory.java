package com.unibh.assistencia.factory;

import com.unibh.assistencia.model.*;

import java.time.LocalDate;

public class OrdemServicoFactory {

    public static OrdemServico criar(String descricao, Cliente cliente) {

        OrdemServico ordem = new OrdemServico();

        ordem.setDescricao(descricao);
        ordem.setCliente(cliente);
        ordem.setStatus(StatusOrdem.ABERTA);
        ordem.setDataAbertura(LocalDate.now());

        return ordem;
    }
}
