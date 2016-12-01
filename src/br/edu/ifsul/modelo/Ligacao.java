/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "ligacao")
public class Ligacao implements Serializable {
  
  @Id
  @SequenceGenerator(name = "seq_ligacao", sequenceName = "seq_ligacao_id", allocationSize = 1)
  @GeneratedValue(generator = "seq_ligacao", strategy = GenerationType.SEQUENCE)
  private int id;
  @NotNull(message = "O ramal não pode ser nulo")
  @NotBlank(message = "O ramal não pode em branco")
  @Length(max = 10, message = "O ramal não pode ter mais de 10 caracteres")
  @Column(name = "ramal", length = 10, nullable = false)
  private String ramal;
  @NotNull(message = "O numero não pode ser nulo")
  @NotBlank(message = "O numero não pode em branco")
  @Length(max = 30, message = "O numero não pode ter mais de 30 caracteres")
  @Column(name = "numero", length = 30, nullable = false)
  private String numero;
  @Column(name = "custo", columnDefinition = "numeric(12,2)")
  private Double custo;
  @Column(name = "custo_cobrado", columnDefinition = "numeric(12,2)")
  private Double custoCobrado;
  @Column(name = "duracao", columnDefinition = "numeric(12,2)")
  private Double duracao;
  @NotNull(message = "A conta deve ser informada")
  @ManyToOne
  @JoinColumn(name = "conta", referencedColumnName = "id", nullable = false)
  private Conta conta;

  public Ligacao() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRamal() {
    return ramal;
  }

  public void setRamal(String ramal) {
    this.ramal = ramal;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public Double getCusto() {
    return custo;
  }

  public void setCusto(Double custo) {
    this.custo = custo;
  }

  public Double getCustoCobrado() {
    return custoCobrado;
  }

  public void setCustoCobrado(Double custoCobrado) {
    this.custoCobrado = custoCobrado;
  }

  public Double getDuracao() {
    return duracao;
  }

  public void setDuracao(Double duracao) {
    this.duracao = duracao;
  }

  public Conta getConta() {
    return conta;
  }

  public void setConta(Conta conta) {
    this.conta = conta;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 41 * hash + this.id;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Ligacao other = (Ligacao) obj;
    if (this.id != other.id) {
      return false;
    }
    return true;
  }

  
  
}
