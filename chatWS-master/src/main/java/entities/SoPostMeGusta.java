/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ihsa
 */
@Entity
@Table(name = "so_post_me_gusta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoPostMeGusta.findAll", query = "SELECT s FROM SoPostMeGusta s"),
    @NamedQuery(name = "SoPostMeGusta.findById", query = "SELECT s FROM SoPostMeGusta s WHERE s.id = :id"),
    @NamedQuery(name = "SoPostMeGusta.findByFechaGenero", query = "SELECT s FROM SoPostMeGusta s WHERE s.fechaGenero = :fechaGenero"),
    @NamedQuery(name = "SoPostMeGusta.findByHoraGenero", query = "SELECT s FROM SoPostMeGusta s WHERE s.horaGenero = :horaGenero"),
    @NamedQuery(name = "SoPostMeGusta.findByEliminado", query = "SELECT s FROM SoPostMeGusta s WHERE s.eliminado = :eliminado")})
public class SoPostMeGusta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_genero")
    @Temporal(TemporalType.DATE)
    private Date fechaGenero;
    @Column(name = "hora_genero")
    @Temporal(TemporalType.TIME)
    private Date horaGenero;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @JoinColumn(name = "so_post", referencedColumnName = "id")
    @ManyToOne
    private SoPost soPost;
    @JoinColumn(name = "so_me_gusta", referencedColumnName = "id")
    @ManyToOne
    private SoMeGusta soMeGusta;

    public SoPostMeGusta() {
    }

    public SoPostMeGusta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaGenero() {
        return fechaGenero;
    }

    public void setFechaGenero(Date fechaGenero) {
        this.fechaGenero = fechaGenero;
    }

    public Date getHoraGenero() {
        return horaGenero;
    }

    public void setHoraGenero(Date horaGenero) {
        this.horaGenero = horaGenero;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public SoPost getSoPost() {
        return soPost;
    }

    public void setSoPost(SoPost soPost) {
        this.soPost = soPost;
    }

    public SoMeGusta getSoMeGusta() {
        return soMeGusta;
    }

    public void setSoMeGusta(SoMeGusta soMeGusta) {
        this.soMeGusta = soMeGusta;
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
        if (!(object instanceof SoPostMeGusta)) {
            return false;
        }
        SoPostMeGusta other = (SoPostMeGusta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SoPostMeGusta[ id=" + id + " ]";
    }
    
}
