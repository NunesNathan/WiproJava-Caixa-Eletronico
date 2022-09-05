package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@DisplayName("Testes dos métodos da classe Transacao")
class TransacaoTest {


  @Test
  @DisplayName("21 - Testa o método construtor da classe Transacao.")
  void construtorTest() {
    Transacao transacao = new Transacao(12.00, "transferencia recebida");
    assertEquals(transacao.getDescricao(), "transferencia recebida");
    assertEquals(transacao.getQuantia(), 12.00);
  }


  @Test
  @DisplayName("22 - Testa o método Getter do atributo quantia.")
  void getQuantiaTest() {
    Transacao transacao = new Transacao(12.00, "transferencia recebida");
    assertEquals(transacao.getQuantia(), 12.00);
  }

  @Test
  @DisplayName("23 - Testa o método retornar resumo transacao.")
  void retornarResumoTransacaoTest() {
    Transacao transacao = new Transacao(12.00, "transferencia recebida");
    assertEquals(transacao.retornarResumoTransacao(), transacao.retornarInstante() + " -------- transferencia recebida: R$ 12.0 +");
  }

  @Test
  @DisplayName("24 - Testa o método instante está gerando o instante corretamente.")
  void retornarInstanteTest() {
    Transacao transacao = new Transacao(12.00, "transferencia recebida");
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    assertEquals(transacao.retornarInstante(), dtf.format(LocalDateTime.now()));
  }

}
