/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ihsa
 */
@Entity
@Table(name = "so_me_gusta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoMeGusta.findAll", query = "SELECT s FROM SoMeGusta s"),
    @NamedQuery(name = "SoMeGusta.findById", query = "SELECT s FROM SoMeGusta s WHERE s.id = :id"),
    @NamedQuery(name = "SoMeGusta.findByFechaGenero", query = "SELECT s FROM SoMeGusta s WHERE s.fechaGenero = :fechaGenero"),
    @NamedQuery(name = "SoMeGusta.findByHoraGenero", query = "SELECT s FROM SoMeGusta s WHERE s.horaGenero = :horaGenero"),
    @NamedQuery(name = "SoMeGusta.findByEliminado", query = "SELECT s FROM SoMeGusta s WHERE s.eliminado = :eliminado")})
public class SoMeGusta implements Serializable {
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
    @OneToMany(mappedBy = "soMeGusta")
    private Collection<SoComentarioMeGusta> soComentarioMeGustaCollection;
    @OneToMany(mappedBy = "soMeGusta")
    private Collection<SoPostMeGusta> soPostMeGustaCollection;
    @JoinColumn(name = "si_usuario", referencedColumnName = "id")
    @ManyToOne
    private SiUsuario siUsuario;

    public SoMeGusta() {
    }

    public SoMeGusta(Integer id) {
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

    @XmlTransient
    public Collection<SoComentarioMeGusta> getSoComentarioMeGustaCollection() {
        return soComentarioMeGustaCollection;
    }

    public void setSoComentarioMeGustaCollection(Collection<SoComentarioMeGusta> soComentarioMeGustaCollection) {
        this.soComentarioMeGustaCollection = soComentarioMeGustaCollection;
    }

    @XmlTransient
    public Collection<SoPostMeGusta> getSoPostMeGustaCollection() {
        return soPostMeGustaCollection;
    }

    public void setSoPostMeGustaCollection(Collection<SoPostMeGusta> soPostMeGustaCollection) {
        this.soPostMeGustaCollection = soPostMeGustaCollection;
    }

    public SiUsuario getSiUsuario() {
        return siUsuario;
    }

    public void setSiUsuario(SiUsuario siUsuario) {
        this.siUsuario = siUsuario;
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
        if (!(object instanceof SoMeGusta)) {
            return false;
        }
        SoMeGusta other = (SoMeGusta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SoMeGusta[ id=" + id + " ]";
    }
    
}
