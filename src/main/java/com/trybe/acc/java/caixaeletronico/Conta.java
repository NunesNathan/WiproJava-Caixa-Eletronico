package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class Conta {
  private String tipoConta;
  private String idConta;
  private PessoaCliente pessoaCliente;
  private ArrayList<Transacao> transacoes = new ArrayList<Transacao>();

  /** Conta Contructor.*/
  public Conta(String tipoConta, PessoaCliente pessoaCliente, Banco banco) {
    this.tipoConta = tipoConta;
    this.pessoaCliente = pessoaCliente;
    this.idConta = banco.gerarNumeroNovaConta();
  }

  public void adicionarTransacao(double quantia, String descricao) {
    transacoes.add(new Transacao(quantia, descricao));
  }

  /** retornarSaldo method.*/
  public double retornarSaldo() {
    double total = 0;
    for (Transacao transacao : transacoes) {
      total += transacao.getQuantia();
    }

    return total;
  }

  public String getIdConta() {
    return this.idConta;
  }

  public PessoaCliente getPessoaCliente() {
    return this.pessoaCliente;
  }

  public int quantidadeTransacoes() {
    return this.transacoes.size();
  }

  public String getTipoConta() {
    return this.tipoConta;
  }

  public String retornarResumoConta() {
    return this.idConta + " : " + "R$" + this.retornarSaldo() + " : " + this.tipoConta;
  }

  /** retornarExtrato method.*/
  public void retornarExtrato() {
    for (int i = 0; i <= transacoes.size(); i++) {
      System.out.println(String.valueOf(i + 1) + ") " + transacoes.get(i)
              .retornarResumoTransacao());
    }
  }
}
