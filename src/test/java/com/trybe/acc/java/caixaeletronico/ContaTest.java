package com.trybe.acc.java.caixaeletronico;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste da classe Conta")
class ContaTest {

  @Test
  @DisplayName("6 - Testa o construtor da classe conta.")
  void construtorTest() {
    Conta conta = new Conta("Poupança", new PessoaCliente("Adalto Alto", "333.444.111-25", "6789"), new Banco());

    assertEquals(conta.getTipoConta(), "Poupança");
    assertEquals(conta.getIdConta().length(), 10);
    assertTrue(conta.getPessoaCliente() instanceof PessoaCliente);
  }

  @Test
  @DisplayName("7 - Testa o método adicionar transação e retornar saldo da conta.")
  void adicionarTransacaoTestRetornarSaldoTest() {
    Conta conta = new Conta("Poupança", new PessoaCliente("Adalto Alto", "333.444.111-25", "6789"), new Banco());
    conta.adicionarTransacao(12.00, "Transferencia recebida");

    assertTrue(conta.quantidadeTransacoes() == 1);

    conta.adicionarTransacao(13.10, "Transferencia recebida");

    assertTrue(conta.retornarSaldo() == 25.10);
  }

  @Test
  @DisplayName("8 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    Conta conta = new Conta("Poupança", new PessoaCliente("Adalto Alto", "333.444.111-25", "6789"), new Banco());
    conta.adicionarTransacao(12.00, "Transferencia recebida");

    assertEquals(conta.retornarResumoConta(), String.format("%s : R$12.0 : Poupança", conta.getIdConta()));
  }

  @Test
  @DisplayName("9 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  void retornarExtratoTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("10 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    Conta conta = new Conta("Poupança", new PessoaCliente("Adalto Alto", "333.444.111-25", "6789"), new Banco());

    assertEquals(conta.getIdConta().length(), 10);
  }

  @Test
  @DisplayName("11 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    Conta conta = new Conta("Poupança", new PessoaCliente("Adalto Alto", "333.444.111-25", "6789"), new Banco());

    assertTrue(conta.getPessoaCliente() instanceof PessoaCliente);
  }

}
