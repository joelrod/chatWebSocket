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
@Table(name = "so_notificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoNotificacion.findAll", query = "SELECT s FROM SoNotificacion s"),
    @NamedQuery(name = "SoNotificacion.findById", query = "SELECT s FROM SoNotificacion s WHERE s.id = :id"),
    @NamedQuery(name = "SoNotificacion.findByFechaReviso", query = "SELECT s FROM SoNotificacion s WHERE s.fechaReviso = :fechaReviso"),
    @NamedQuery(name = "SoNotificacion.findByHoraReviso", query = "SELECT s FROM SoNotificacion s WHERE s.horaReviso = :horaReviso"),
    @NamedQuery(name = "SoNotificacion.findByFechaGenero", query = "SELECT s FROM SoNotificacion s WHERE s.fechaGenero = :fechaGenero"),
    @NamedQuery(name = "SoNotificacion.findByHoraGenero", query = "SELECT s FROM SoNotificacion s WHERE s.horaGenero = :horaGenero"),
    @NamedQuery(name = "SoNotificacion.findByEliminado", query = "SELECT s FROM SoNotificacion s WHERE s.eliminado = :eliminado")})
public class SoNotificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_reviso")
    @Temporal(TemporalType.DATE)
    private Date fechaReviso;
    @Column(name = "hora_reviso")
    @Temporal(TemporalType.TIME)
    private Date horaReviso;
    @Column(name = "fecha_genero")
    @Temporal(TemporalType.DATE)
    private Date fechaGenero;
    @Column(name = "hora_genero")
    @Temporal(TemporalType.TIME)
    private Date horaGenero;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @JoinColumn(name = "so_tipo_notificacion", referencedColumnName = "id")
    @ManyToOne
    private SoTipoNotificacion soTipoNotificacion;
    @JoinColumn(name = "si_usuario", referencedColumnName = "id")
    @ManyToOne
    private SiUsuario siUsuario;

    public SoNotificacion() {
    }

    public SoNotificacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaReviso() {
        return fechaReviso;
    }

    public void setFechaReviso(Date fechaReviso) {
        this.fechaReviso = fechaReviso;
    }

    public Date getHoraReviso() {
        return horaReviso;
    }

    public void setHoraReviso(Date horaReviso) {
        this.horaReviso = horaReviso;
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

    public SoTipoNotificacion getSoTipoNotificacion() {
        return soTipoNotificacion;
    }

    public void setSoTipoNotificacion(SoTipoNotificacion soTipoNotificacion) {
        this.soTipoNotificacion = soTipoNotificacion;
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
        if (!(object instanceof SoNotificacion)) {
            return false;
        }
        SoNotificacion other = (SoNotificacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SoNotificacion[ id=" + id + " ]";
    }
    
}
