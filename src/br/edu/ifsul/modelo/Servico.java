/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
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
@Table(name = "servico")
public class Servico implements Serializable {
  
  @Id
  @SequenceGenerator(name = "seq_servico", sequenceName = "seq_servico_id", allocationSize = 1)
  @GeneratedValue(generator = "seq_servico", strategy = GenerationType.SEQUENCE)
  private int id;
  @NotNull(message = "O nome não pode ser nulo")
  @NotBlank(message = "O nome não pode em branco")
  @Length(max = 50, message = "O nome não pode ter mais de 50 caracteres")
  @Column(name = "nome", length = 50, nullable = false)
  private String nome;
  @Column(name = "custo", columnDefinition = "numeric(12,2)")
  private Double custo;
  @Column(name = "custo_cobrado", columnDefinition = "numeric(12,2)")
  private Double custoCobrado;
  @Column(name = "qtde", columnDefinition = "numeric(12,2)")
  private Double qtde;
  @NotNull(message = "A unidade não pode ser nula")
  @NotBlank(message = "A unidade não pode em branco")
  @Length(max = 50, message = "A unidade não pode ter mais de 50 caracteres")
  @Column(name = "unidade", length = 50, nullable = false)
  private String unidade;
  @NotNull(message = "A conta deve ser informada")
  @ManyToOne
  @JoinColumn(name = "conta", referencedColumnName = "id", nullable = false)
  private Conta conta;

  public Servico() {
  }
  
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
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

  public Double getQtde() {
    return qtde;
  }

  public void setQtde(Double qtde) {
    this.qtde = qtde;
  }

  public String getUnidade() {
    return unidade;
  }

  public void setUnidade(String unidade) {
    this.unidade = unidade;
  }

  public Conta getConta() {
    return conta;
  }

  public void setConta(Conta conta) {
    this.conta = conta;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 79 * hash + this.id;
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
    final Servico other = (Servico) obj;
    if (this.id != other.id) {
      return false;
    }
    return true;
  }

  
  
}
