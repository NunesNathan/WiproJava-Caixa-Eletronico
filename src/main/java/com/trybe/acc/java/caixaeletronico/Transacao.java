package com.trybe.acc.java.caixaeletronico;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
  private double quantia;
  private String instante;
  private String descricao;
  private Conta conta;

  public Transacao(double quantia, String descricao) {
    this.quantia = quantia;
    this.descricao = descricao;

    this.instante = this.retornarInstante();
  }

  public double getQuantia() {
    return this.quantia;
  }

  public String getDescricao() {
    return descricao;
  }

  public String retornarResumoTransacao() {
    return this.instante + " -------- " + this.descricao + ": R$ " + this.quantia + " +";
  }

  public String retornarInstante() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    return dtf.format(LocalDateTime.now());
  }

}

