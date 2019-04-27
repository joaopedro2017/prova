/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rio.puc.inf.les.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tassio
 */
@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByCodigoCategoria", query = "SELECT c FROM Categoria c WHERE c.codigoCategoria = :codigoCategoria"),
    @NamedQuery(name = "Categoria.findByTipoCategoria", query = "SELECT c FROM Categoria c WHERE c.tipoCategoria = :tipoCategoria"),
    @NamedQuery(name = "Categoria.findByValorDiaria", query = "SELECT c FROM Categoria c WHERE c.valorDiaria = :valorDiaria"),
    @NamedQuery(name = "Categoria.findByCapacidade", query = "SELECT c FROM Categoria c WHERE c.capacidade = :capacidade")})
public class Item implements Serializable {

    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoItem")    
    private Integer codigoItem;
    
    @Basic(optional = false)
    @Column(name = "nome")    
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "descricao")    
    private String descricao;
    
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;

    public Item() {
    }

    public Item(Integer codigoItem, String nome, String descricao, int quantidade) {
        this.codigoItem = codigoItem;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Integer getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(Integer codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoItem != null ? codigoItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.codigoItem == null && other.codigoItem != null) || (this.codigoItem != null && !this.codigoItem.equals(other.codigoItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.rio.puc.inf.les.model.Categoria[ codigoCategoria=" + codigoItem + " ]";
    }  
    
}
