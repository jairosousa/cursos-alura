package br.com.alura.microservice.loja.dto;

import java.time.LocalDate;

/**
 * @Autor Jairo Nascimento
 * @Created 06/08/2021 - 10:35
 */
public class InfoEntregaDTO {

    private Long pedidoId;

    private LocalDate dataParaEntrega;

    private String enderecoOrigem;

    private String enderecoDestino;

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public LocalDate getDataParaEntrega() {
        return dataParaEntrega;
    }

    public void setDataParaEntrega(LocalDate dataParaEntrega) {
        this.dataParaEntrega = dataParaEntrega;
    }

    public String getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public void setEnderecoOrigem(String enderecoOrigem) {
        this.enderecoOrigem = enderecoOrigem;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(String enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }
}
