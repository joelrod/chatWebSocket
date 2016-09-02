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
@Table(name = "so_comentario_me_gusta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoComentarioMeGusta.findAll", query = "SELECT s FROM SoComentarioMeGusta s"),
    @NamedQuery(name = "SoComentarioMeGusta.findById", query = "SELECT s FROM SoComentarioMeGusta s WHERE s.id = :id"),
    @NamedQuery(name = "SoComentarioMeGusta.findByFechaGenero", query = "SELECT s FROM SoComentarioMeGusta s WHERE s.fechaGenero = :fechaGenero"),
    @NamedQuery(name = "SoComentarioMeGusta.findByHoraGenero", query = "SELECT s FROM SoComentarioMeGusta s WHERE s.horaGenero = :horaGenero"),
    @NamedQuery(name = "SoComentarioMeGusta.findByEliminado", query = "SELECT s FROM SoComentarioMeGusta s WHERE s.eliminado = :eliminado")})
public class SoComentarioMeGusta implements Serializable {
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
    @JoinColumn(name = "so_me_gusta", referencedColumnName = "id")
    @ManyToOne
    private SoMeGusta soMeGusta;
    @JoinColumn(name = "so_comentario", referencedColumnName = "id")
    @ManyToOne
    private SoComentario soComentario;

    public SoComentarioMeGusta() {
    }

    public SoComentarioMeGusta(Integer id) {
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

    public SoMeGusta getSoMeGusta() {
        return soMeGusta;
    }

    public void setSoMeGusta(SoMeGusta soMeGusta) {
        this.soMeGusta = soMeGusta;
    }

    public SoComentario getSoComentario() {
        return soComentario;
    }

    public void setSoComentario(SoComentario soComentario) {
        this.soComentario = soComentario;
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
        if (!(object instanceof SoComentarioMeGusta)) {
            return false;
        }
        SoComentarioMeGusta other = (SoComentarioMeGusta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SoComentarioMeGusta[ id=" + id + " ]";
    }
    
}
