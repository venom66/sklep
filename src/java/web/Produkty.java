/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BartD
 */
@Entity
@Table(name = "produkty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produkty.findAll", query = "SELECT p FROM Produkty p")
    , @NamedQuery(name = "Produkty.findById", query = "SELECT p FROM Produkty p WHERE p.id = :id")
    , @NamedQuery(name = "Produkty.findByNazwa", query = "SELECT p FROM Produkty p WHERE p.nazwa = :nazwa")
    , @NamedQuery(name = "Produkty.findByCena", query = "SELECT p FROM Produkty p WHERE p.cena = :cena")
    , @NamedQuery(name = "Produkty.findByWaluta", query = "SELECT p FROM Produkty p WHERE p.waluta = :waluta")})
public class Produkty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nazwa")
    private String nazwa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "cena")
    private Float cena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "waluta")
    private String waluta;

    public Produkty() {
    }

    public Produkty(Integer id) {
        this.id = id;
    }

    public Produkty(Integer id, String nazwa, String waluta) {
        this.id = id;
        this.nazwa = nazwa;
        this.waluta = waluta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Float getCena() {
        return cena;
    }

    public void setCena(Float cena) {
        this.cena = cena;
    }

    public String getWaluta() {
        return waluta;
    }

    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produkty)) {
            return false;
        }
        Produkty other = (Produkty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.Produkty[ id=" + id + " ]";
    }
    
}
