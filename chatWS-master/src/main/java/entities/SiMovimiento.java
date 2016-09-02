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
@Table(name = "si_movimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiMovimiento.findAll", query = "SELECT s FROM SiMovimiento s"),
    @NamedQuery(name = "SiMovimiento.findById", query = "SELECT s FROM SiMovimiento s WHERE s.id = :id"),
    @NamedQuery(name = "SiMovimiento.findByMensaje", query = "SELECT s FROM SiMovimiento s WHERE s.mensaje = :mensaje"),
    @NamedQuery(name = "SiMovimiento.findByFechaGenero", query = "SELECT s FROM SiMovimiento s WHERE s.fechaGenero = :fechaGenero"),
    @NamedQuery(name = "SiMovimiento.findByHoraGenero", query = "SELECT s FROM SiMovimiento s WHERE s.horaGenero = :horaGenero"),
    @NamedQuery(name = "SiMovimiento.findByEliminado", query = "SELECT s FROM SiMovimiento s WHERE s.eliminado = :eliminado")})
public class SiMovimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "mensaje")
    private String mensaje;
    @Column(name = "fecha_genero")
    @Temporal(TemporalType.DATE)
    private Date fechaGenero;
    @Column(name = "hora_genero")
    @Temporal(TemporalType.TIME)
    private Date horaGenero;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @JoinColumn(name = "so_tipo_movimiento", referencedColumnName = "id")
    @ManyToOne
    private SoTipoMovimiento soTipoMovimiento;
    @JoinColumn(name = "si_usuario", referencedColumnName = "id")
    @ManyToOne
    private SiUsuario siUsuario;

    public SiMovimiento() {
    }

    public SiMovimiento(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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

    public SoTipoMovimiento getSoTipoMovimiento() {
        return soTipoMovimiento;
    }

    public void setSoTipoMovimiento(SoTipoMovimiento soTipoMovimiento) {
        this.soTipoMovimiento = soTipoMovimiento;
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
        if (!(object instanceof SiMovimiento)) {
            return false;
        }
        SiMovimiento other = (SiMovimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SiMovimiento[ id=" + id + " ]";
    }
    
}
