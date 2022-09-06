package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;

public class PessoaCliente {
  private String nomeCompleto;
  private String cpf;
  private String senha;
  private ArrayList<Conta> contas = new ArrayList<Conta>();

  /** PessoaCliente Constructor.*/
  public PessoaCliente(String nomeCompleto, String cpf, String senha) {
    this.nomeCompleto = nomeCompleto;
    this.cpf = cpf;
    this.senha = senha;

    System.out.println(String.format("Nova pessoa cliente %s com CPF: %s criada!",
            this.nomeCompleto, this.cpf));
  }

  public void adicionarConta(Conta conta) {
    this.contas.add(conta);
  }

  /** retornaNumeroDeContas method.*/
  public int retornaNumeroDeContas() {
    return this.contas.size();
  }

  /** retornarSaldoContaEspecifica method.*/
  public double retornarSaldoContaEspecifica(int indice) {
    Conta conta = this.contas.get(indice);

    return conta.retornarSaldo();
  }

  /** retornarIdContaEspecifica method.*/
  public String retornarIdContaEspecifica(int indice) {
    Conta conta = this.contas.get(indice);

    return conta.getIdConta();
  }

  /** retornarExtratoContaEspecifica method.*/
  public void retornarExtratoContaEspecifica(int indice) {
    Conta conta = this.contas.get(indice);

    conta.retornarExtrato();
  }

  /** adicionarTransacaoContaEspecifica method.*/
  public void adicionarTransacaoContaEspecifica(int indice, double quantia, String descricao) {
    Conta conta = this.contas.get(indice);

    conta.adicionarTransacao(quantia, descricao);
  }

  public boolean validarSenha(String senha) {
    return this.senha == senha;
  }

  public String getCpf() {
    return cpf;
  }

  /** getPessoaCliente method.*/
  public String getPessoaCliente() {
    return this.nomeCompleto;
  }

  /** retornarResumoContas method.*/
  public void retornarResumoContas() {
    for (Conta conta : this.contas) {
      System.out.println(conta.retornarResumoConta());
    }
  }
}
