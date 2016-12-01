/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "conta")
public class Conta implements Serializable {
  
  @Id
  @SequenceGenerator(name = "seq_conta", sequenceName = "seq_conta_id", allocationSize = 1)
  @GeneratedValue(generator = "seq_conta", strategy = GenerationType.SEQUENCE)
  private Integer id;
  @NotNull(message = "A descrição não pode ser nula")
  @NotBlank(message = "A descrição não pode em branco")
  @Length(max = 100, message = "A descrição não pode ter mais de 100 caracteres")
  @Column(name = "descricao", length = 100, nullable = false)
  private String descricao;
  @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private List<Servico> servicos = new ArrayList<>();
  @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private List<Ligacao> ligacoes = new ArrayList<>();
  @ManyToMany
  @JoinTable(name = "conta_usuario", 
      joinColumns = @JoinColumn(name = "conta", referencedColumnName = "id", nullable = false),
      inverseJoinColumns = @JoinColumn(name = "conta_usuario", referencedColumnName = "id", nullable = false)
  )
  private List<Usuario> usuarios = new ArrayList<>();
  
  public Conta () {
  }
  
  public void adicionarUsuario (Usuario u) {
    this.getUsuarios().add(u);
  }

  public void removerRamal (int index) {
    Usuario u = this.getUsuarios().get(index);
    this.getUsuarios().remove(index);
  }

  public void adicionarServico (Servico s) {
    s.setConta(this);
    this.servicos.add(s);
  }

  public void removerServico (int index) {
    this.servicos.remove(index);
  }
  
  public void adicionarLigacao (Ligacao l) {
    l.setConta(this);
    this.ligacoes.add(l);
  }

  public void removerLigacao (int index) {
    this.ligacoes.remove(index);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public List<Servico> getServicos() {
    return servicos;
  }

  public void setServicos(List<Servico> servicos) {
    this.servicos = servicos;
  }

  public List<Ligacao> getLigacoes() {
    return ligacoes;
  }

  public void setLigacoes(List<Ligacao> ligacoes) {
    this.ligacoes = ligacoes;
  }

  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<Usuario> usuarios) {
    this.usuarios = usuarios;
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
    final Conta other = (Conta) obj;
    if (this.id != other.id) {
      return false;
    }
    return true;
  }
  
}
