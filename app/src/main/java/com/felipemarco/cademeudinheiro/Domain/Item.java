package com.felipemarco.cademeudinheiro.domain;

import java.math.BigDecimal;

/**
 * Created by Felipe on 25/02/2017.
 */

public class Item {

    private Integer codigo;
    private String descricao;
    private BigDecimal valor;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
