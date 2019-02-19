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
@Table(name = "zam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zam.findAll", query = "SELECT z FROM Zam z")
    , @NamedQuery(name = "Zam.findById", query = "SELECT z FROM Zam z WHERE z.id = :id")
    , @NamedQuery(name = "Zam.findByNazwa", query = "SELECT z FROM Zam z WHERE z.nazwa = :nazwa")
    , @NamedQuery(name = "Zam.findByCenaTotalZl", query = "SELECT z FROM Zam z WHERE z.cenaTotalZl = :cenaTotalZl")})
public class Zam implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "cena_total_zl")
    private float cenaTotalZl;

    public Zam() {
    }

    public Zam(Integer id) {
        this.id = id;
    }

    public Zam(Integer id, String nazwa, float cenaTotalZl) {
        this.id = id;
        this.nazwa = nazwa;
        this.cenaTotalZl = cenaTotalZl;
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

    public float getCenaTotalZl() {
        return cenaTotalZl;
    }

    public void setCenaTotalZl(float cenaTotalZl) {
        this.cenaTotalZl = cenaTotalZl;
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
        if (!(object instanceof Zam)) {
            return false;
        }
        Zam other = (Zam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "web.Zam[ id=" + id + " ]";
    }
    
}
