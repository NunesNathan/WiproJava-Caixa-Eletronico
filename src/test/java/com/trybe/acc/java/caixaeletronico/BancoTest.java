package com.trybe.acc.java.caixaeletronico;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para a classe Banco")
class BancoTest {

  @Test
  @DisplayName("1 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    Banco banco = new Banco();

    assertTrue(banco.gerarNumeroNovaConta().length() == 10);
  }

  @Test
  @DisplayName("2 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    Banco banco = new Banco();

    assertTrue(banco.adicionarPessoaCliente("Adalto Alto", "333.444.111-25", "6789") instanceof PessoaCliente);
  }

  @Test
  @DisplayName("3 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    Banco banco = new Banco();
    banco.adicionarPessoaCliente("Adalto Alto", "333.444.111-25", "6789");

    assertTrue(banco.pessoaClienteLogin("333.444.111-25", "6789") instanceof PessoaCliente);

  }

  @Test
  @DisplayName("4 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente =  banco.adicionarPessoaCliente("Adalto Alto", "333.444.111-25", "6789");

    Conta conta1 = new Conta("Corrente", pessoaCliente, banco);
    Conta conta2 = new Conta("Poupança", pessoaCliente, banco);

    pessoaCliente.adicionarConta(conta1);
    pessoaCliente.adicionarConta(conta2);

    banco.transferirFundos(pessoaCliente, 0, 1, 12.00);

    assertTrue(conta1.quantidadeTransacoes() == 1);
  }

  @Test
  @DisplayName("5 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    Banco banco = new Banco();
    PessoaCliente pessoaCliente =  banco.adicionarPessoaCliente("Adalto Alto", "333.444.111-25", "6789");

    Conta conta = new Conta("Poupança", pessoaCliente, banco);

    pessoaCliente.adicionarConta(conta);

    banco.sacar(pessoaCliente, 0, 12.00);

    assertTrue(conta.quantidadeTransacoes() == 1);
  }

}
