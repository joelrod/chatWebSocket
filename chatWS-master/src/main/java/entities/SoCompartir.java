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
@Table(name = "so_compartir")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoCompartir.findAll", query = "SELECT s FROM SoCompartir s"),
    @NamedQuery(name = "SoCompartir.findById", query = "SELECT s FROM SoCompartir s WHERE s.id = :id"),
    @NamedQuery(name = "SoCompartir.findByMensaje", query = "SELECT s FROM SoCompartir s WHERE s.mensaje = :mensaje"),
    @NamedQuery(name = "SoCompartir.findByNumeroMeGusta", query = "SELECT s FROM SoCompartir s WHERE s.numeroMeGusta = :numeroMeGusta"),
    @NamedQuery(name = "SoCompartir.findByFechaGenero", query = "SELECT s FROM SoCompartir s WHERE s.fechaGenero = :fechaGenero"),
    @NamedQuery(name = "SoCompartir.findByHoraGenero", query = "SELECT s FROM SoCompartir s WHERE s.horaGenero = :horaGenero"),
    @NamedQuery(name = "SoCompartir.findByEliminado", query = "SELECT s FROM SoCompartir s WHERE s.eliminado = :eliminado")})
public class SoCompartir implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "mensaje")
    private String mensaje;
    @Column(name = "numero_me_gusta")
    private Integer numeroMeGusta;
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
    @JoinColumn(name = "si_usuario", referencedColumnName = "id")
    @ManyToOne
    private SiUsuario siUsuario;

    public SoCompartir() {
    }

    public SoCompartir(Integer id) {
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

    public Integer getNumeroMeGusta() {
        return numeroMeGusta;
    }

    public void setNumeroMeGusta(Integer numeroMeGusta) {
        this.numeroMeGusta = numeroMeGusta;
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
        if (!(object instanceof SoCompartir)) {
            return false;
        }
        SoCompartir other = (SoCompartir) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SoCompartir[ id=" + id + " ]";
    }
    
}
