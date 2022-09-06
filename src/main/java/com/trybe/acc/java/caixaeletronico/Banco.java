package com.trybe.acc.java.caixaeletronico;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Banco {
  private ArrayList<PessoaCliente> pessoasClientes = new ArrayList<PessoaCliente>();
  private ArrayList<Conta> contas = new ArrayList<Conta>();

  public String gerarNumeroNovaConta() {
    ArrayList<Integer> numerosDaConta = new ArrayList<Integer>();
    for (int x = 1; x < 11; x++) {
      numerosDaConta.add((int) Math.round(Math.random()*9));
    }

    return numerosDaConta.stream().map(Object::toString)
            .collect(Collectors.joining(""));
  }

  public PessoaCliente adicionarPessoaCliente(String nome, String cpf, String senha) {
    PessoaCliente pessoa = new PessoaCliente(nome, cpf, senha);
    pessoasClientes.add(pessoa);
    return pessoa;
  }

  public void adicionarConta(Conta conta) {
    contas.add(conta);
  }

  public PessoaCliente pessoaClienteLogin(String cpf, String senha) {
    PessoaCliente pessoa = (PessoaCliente) pessoasClientes.stream()
            .filter(cliente -> Objects.equals(cliente.getCpf(), cpf));

    if (pessoa != null & pessoa.validarSenha(senha)) {
      return pessoa;
    }

    return null;
  }

  public void transferirFundos(PessoaCliente pessoaCliente, int daConta, int paraConta, double quantia) {
    pessoaCliente.adicionarTransacaoContaEspecifica(daConta, quantia, "Transferencia efetuada");

    pessoaCliente.adicionarTransacaoContaEspecifica(paraConta, quantia, "Transferência recebida");
  }

  public void sacar(PessoaCliente pessoaCliente, int daConta, double quantia) {
    pessoaCliente.adicionarTransacaoContaEspecifica(daConta, quantia, "Saque efetuado");
  }

  public void depositar(PessoaCliente pessoaCliente, int paraConta, double quantia) {
    pessoaCliente.adicionarTransacaoContaEspecifica(paraConta, quantia, "Deposito efetuado");
  }

  public void mostrarExtrato(PessoaCliente pessoaCliente, int conta) {
    pessoaCliente.retornarExtratoContaEspecifica(conta);
  }
}
