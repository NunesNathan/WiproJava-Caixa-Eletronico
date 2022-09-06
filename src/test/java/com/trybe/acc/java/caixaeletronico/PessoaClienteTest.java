package com.trybe.acc.java.caixaeletronico;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste dos métodos da classe PessoaCliente")
class PessoaClienteTest {

  @Test
  @DisplayName("12 - Testa o construtor da classe Pessoa Cliente.")
  void construtorTest() {
    PessoaCliente pessoa = new PessoaCliente("Adalto Alto", "333.444.111-25", "6789");

    assertEquals(pessoa.getCpf(), "333.444.111-25");
    assertEquals(pessoa.getPessoaCliente(), "Adalto Alto");
  }

  @Test
  @DisplayName("13 - Testa o método adicionar conta e o método retornar número de contas.")
  void adicionarContaTestRetornaNumeroDeContasTest() {
    PessoaCliente pessoa = new PessoaCliente("Adalto Alto", "333.444.111-25", "6789");
    pessoa.adicionarConta(new Conta("Poupança", pessoa, new Banco()));

    assertTrue(pessoa.retornaNumeroDeContas() == 1);
  }

  @Test
  @DisplayName("14 - Testa o método retornar saldo de uma conta específica da pessoa cliente.")
  void retornarSaldoContaEspecificaTest() {
    PessoaCliente pessoa = new PessoaCliente("Adalto Alto", "333.444.111-25", "6789");
    pessoa.adicionarConta(new Conta("Poupança", pessoa, new Banco()));

    assertTrue(pessoa.retornarSaldoContaEspecifica(0) == 0.0);
  }


  @Test
  @DisplayName("15 - Testa o método retornar id de uma conta específica da pessoa cliente.")
  void retornarIdContaEspecificaTest() {
    PessoaCliente pessoa = new PessoaCliente("Adalto Alto", "333.444.111-25", "6789");
    pessoa.adicionarConta(new Conta("Poupança", pessoa, new Banco()));

    assertTrue(pessoa.retornarIdContaEspecifica(0).length() == 10);
  }

  @Test
  @DisplayName("16 - Testa o método retornar o extrato de uma conta específica da pessoa cliente.")
  void retornarExtratoContaEspecificaTest() {
    fail("Não implementado");

  }

  @Test
  @DisplayName("17 - Testa o método adiciona transacao de uma conta específica da pessoa cliente.")
  void adicionarTransacaoContaEspecificaTest() {
    PessoaCliente pessoa = new PessoaCliente("Adalto Alto", "333.444.111-25", "6789");
    pessoa.adicionarConta(new Conta("Poupança", pessoa, new Banco()));
    pessoa.adicionarTransacaoContaEspecifica(0, 12.00, "Tranferencia recebida");

    assertEquals(pessoa.retornarSaldoContaEspecifica(0), 12);
  }

  @Test
  @DisplayName("18 - Testa o método validar senha.")
  void validarSenhaTest() {
    PessoaCliente pessoa = new PessoaCliente("Adalto Alto", "333.444.111-25", "6789");

    assertTrue(pessoa.validarSenha("6789"));
    assertFalse(pessoa.validarSenha("6788"));
  }

  @Test
  @DisplayName("19 - Testa o método retornar resumo contas.")
  void retornarResumoContasTest() {
    fail("Não implementado");


  }

  @Test
  @DisplayName("20 - Testa o método Getter do atributo cpf está retornando.")
  void getCpfTest() {
    PessoaCliente pessoa = new PessoaCliente("Adalto Alto", "333.444.111-25", "6789");

    assertEquals(pessoa.getCpf(), "333.444.111-25");
  }

}
