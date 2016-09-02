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
@Table(name = "so_solicitud_amistad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoSolicitudAmistad.findAll", query = "SELECT s FROM SoSolicitudAmistad s"),
    @NamedQuery(name = "SoSolicitudAmistad.findById", query = "SELECT s FROM SoSolicitudAmistad s WHERE s.id = :id"),
    @NamedQuery(name = "SoSolicitudAmistad.findByMensaje", query = "SELECT s FROM SoSolicitudAmistad s WHERE s.mensaje = :mensaje"),
    @NamedQuery(name = "SoSolicitudAmistad.findByAceptada", query = "SELECT s FROM SoSolicitudAmistad s WHERE s.aceptada = :aceptada"),
    @NamedQuery(name = "SoSolicitudAmistad.findByRevisada", query = "SELECT s FROM SoSolicitudAmistad s WHERE s.revisada = :revisada"),
    @NamedQuery(name = "SoSolicitudAmistad.findByFechaAceptada", query = "SELECT s FROM SoSolicitudAmistad s WHERE s.fechaAceptada = :fechaAceptada"),
    @NamedQuery(name = "SoSolicitudAmistad.findByHoraAceptada", query = "SELECT s FROM SoSolicitudAmistad s WHERE s.horaAceptada = :horaAceptada"),
    @NamedQuery(name = "SoSolicitudAmistad.findByFechaGenero", query = "SELECT s FROM SoSolicitudAmistad s WHERE s.fechaGenero = :fechaGenero"),
    @NamedQuery(name = "SoSolicitudAmistad.findByHoraGenero", query = "SELECT s FROM SoSolicitudAmistad s WHERE s.horaGenero = :horaGenero"),
    @NamedQuery(name = "SoSolicitudAmistad.findByEliminado", query = "SELECT s FROM SoSolicitudAmistad s WHERE s.eliminado = :eliminado")})
public class SoSolicitudAmistad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "mensaje")
    private String mensaje;
    @Column(name = "aceptada")
    private Boolean aceptada;
    @Column(name = "revisada")
    private Boolean revisada;
    @Column(name = "fecha_aceptada")
    @Temporal(TemporalType.DATE)
    private Date fechaAceptada;
    @Column(name = "hora_aceptada")
    @Temporal(TemporalType.TIME)
    private Date horaAceptada;
    @Column(name = "fecha_genero")
    @Temporal(TemporalType.DATE)
    private Date fechaGenero;
    @Column(name = "hora_genero")
    @Temporal(TemporalType.TIME)
    private Date horaGenero;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @JoinColumn(name = "si_usuario_para", referencedColumnName = "id")
    @ManyToOne
    private SiUsuario siUsuarioPara;
    @JoinColumn(name = "si_usuario_solicita", referencedColumnName = "id")
    @ManyToOne
    private SiUsuario siUsuarioSolicita;

    public SoSolicitudAmistad() {
    }

    public SoSolicitudAmistad(Integer id) {
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

    public Boolean getAceptada() {
        return aceptada;
    }

    public void setAceptada(Boolean aceptada) {
        this.aceptada = aceptada;
    }

    public Boolean getRevisada() {
        return revisada;
    }

    public void setRevisada(Boolean revisada) {
        this.revisada = revisada;
    }

    public Date getFechaAceptada() {
        return fechaAceptada;
    }

    public void setFechaAceptada(Date fechaAceptada) {
        this.fechaAceptada = fechaAceptada;
    }

    public Date getHoraAceptada() {
        return horaAceptada;
    }

    public void setHoraAceptada(Date horaAceptada) {
        this.horaAceptada = horaAceptada;
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

    public SiUsuario getSiUsuarioPara() {
        return siUsuarioPara;
    }

    public void setSiUsuarioPara(SiUsuario siUsuarioPara) {
        this.siUsuarioPara = siUsuarioPara;
    }

    public SiUsuario getSiUsuarioSolicita() {
        return siUsuarioSolicita;
    }

    public void setSiUsuarioSolicita(SiUsuario siUsuarioSolicita) {
        this.siUsuarioSolicita = siUsuarioSolicita;
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
        if (!(object instanceof SoSolicitudAmistad)) {
            return false;
        }
        SoSolicitudAmistad other = (SoSolicitudAmistad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SoSolicitudAmistad[ id=" + id + " ]";
    }
    
}
