package br.com.alura.loja;/*
 *
 * @Author: Jairo Nascimento on 30/05/2021 - 15:45
 *
 */

public class DomainException extends RuntimeException {

  public DomainException(String mensagem) {
    super(mensagem);
  }
}
