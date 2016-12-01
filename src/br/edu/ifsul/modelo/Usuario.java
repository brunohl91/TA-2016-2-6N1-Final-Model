/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Bruno
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

  @Id
  @SequenceGenerator(name = "seq_ligacao", sequenceName = "seq_ligacao_id", allocationSize = 1)
  @GeneratedValue(generator = "seq_ligacao", strategy = GenerationType.SEQUENCE)
  private int id;
  @NotNull(message = "O nome não pode ser nulo")
  @NotBlank(message = "O nome não pode em branco")
  @Length(max = 50, message = "O nome não pode ter mais de 50 caracteres")
  @Column(name = "numero", length = 50, nullable = false)
  private String nome;
  @NotNull(message = "O cargo não pode ser nulo")
  @NotBlank(message = "O cargo não pode em branco")
  @Length(max = 50, message = "O cargo não pode ter mais de 50 caracteres")
  @Column(name = "cargo", length = 50, nullable = false)
  private String cargo;
  @NotNull(message = "O cc não pode ser nulo")
  @Column(name = "cc", nullable = false)
  private Integer cc;
  
  public Usuario() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public Integer getCc() {
    return cc;
  }

  public void setCc(Integer cc) {
    this.cc = cc;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 53 * hash + this.id;
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
    final Usuario other = (Usuario) obj;
    if (this.id != other.id) {
      return false;
    }
    return true;
  }
  
}
