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
@Table(name = "si_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiUsuario.findAll", query = "SELECT s FROM SiUsuario s"),
    @NamedQuery(name = "SiUsuario.findById", query = "SELECT s FROM SiUsuario s WHERE s.id = :id"),
    @NamedQuery(name = "SiUsuario.findByNombre", query = "SELECT s FROM SiUsuario s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SiUsuario.findByAlias", query = "SELECT s FROM SiUsuario s WHERE s.alias = :alias"),
    @NamedQuery(name = "SiUsuario.findByCorreo", query = "SELECT s FROM SiUsuario s WHERE s.correo = :correo"),
    @NamedQuery(name = "SiUsuario.findByPassword", query = "SELECT s FROM SiUsuario s WHERE s.password = :password"),
    @NamedQuery(name = "SiUsuario.findBySemestre", query = "SELECT s FROM SiUsuario s WHERE s.semestre = :semestre"),
    @NamedQuery(name = "SiUsuario.findByTieneRelacion", query = "SELECT s FROM SiUsuario s WHERE s.tieneRelacion = :tieneRelacion"),
    @NamedQuery(name = "SiUsuario.findByFechaGenero", query = "SELECT s FROM SiUsuario s WHERE s.fechaGenero = :fechaGenero"),
    @NamedQuery(name = "SiUsuario.findByHoraGenero", query = "SELECT s FROM SiUsuario s WHERE s.horaGenero = :horaGenero"),
    @NamedQuery(name = "SiUsuario.findByEliminado", query = "SELECT s FROM SiUsuario s WHERE s.eliminado = :eliminado")})
public class SiUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "alias")
    private String alias;
    @Column(name = "correo")
    private String correo;
    @Column(name = "password")
    private String password;
    @Column(name = "semestre")
    private Integer semestre;
    @Column(name = "tiene_relacion")
    private Boolean tieneRelacion;
    @Column(name = "fecha_genero")
    @Temporal(TemporalType.DATE)
    private Date fechaGenero;
    @Column(name = "hora_genero")
    @Temporal(TemporalType.TIME)
    private Date horaGenero;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @OneToMany(mappedBy = "siUsuarioAmigo")
    private Collection<SoAmigo> soAmigoCollection;
    @OneToMany(mappedBy = "siUsuario")
    private Collection<SoAmigo> soAmigoCollection1;
    @OneToMany(mappedBy = "siUsuario")
    private Collection<SoCompartir> soCompartirCollection;
    @OneToMany(mappedBy = "siUsuarioPara")
    private Collection<SoSolicitudAmistad> soSolicitudAmistadCollection;
    @OneToMany(mappedBy = "siUsuarioSolicita")
    private Collection<SoSolicitudAmistad> soSolicitudAmistadCollection1;
    @OneToMany(mappedBy = "genero")
    private Collection<SiAdjunto> siAdjuntoCollection;
    @OneToMany(mappedBy = "siUsuario")
    private Collection<SoComentario> soComentarioCollection;
    @OneToMany(mappedBy = "siUsuario")
    private Collection<SoPost> soPostCollection;
    @JoinColumn(name = "so_tipo_usuario", referencedColumnName = "id")
    @ManyToOne
    private SoTipoUsuario soTipoUsuario;
    @JoinColumn(name = "so_carrera", referencedColumnName = "id")
    @ManyToOne
    private SoCarrera soCarrera;
    @OneToMany(mappedBy = "siUsuario")
    private Collection<SoNotificacion> soNotificacionCollection;
    @OneToMany(mappedBy = "siUsuario")
    private Collection<SoMeGusta> soMeGustaCollection;
    @OneToMany(mappedBy = "siUsuario")
    private Collection<SiMovimiento> siMovimientoCollection;

    public SiUsuario() {
    }

    public SiUsuario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Boolean getTieneRelacion() {
        return tieneRelacion;
    }

    public void setTieneRelacion(Boolean tieneRelacion) {
        this.tieneRelacion = tieneRelacion;
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
    public Collection<SoAmigo> getSoAmigoCollection() {
        return soAmigoCollection;
    }

    public void setSoAmigoCollection(Collection<SoAmigo> soAmigoCollection) {
        this.soAmigoCollection = soAmigoCollection;
    }

    @XmlTransient
    public Collection<SoAmigo> getSoAmigoCollection1() {
        return soAmigoCollection1;
    }

    public void setSoAmigoCollection1(Collection<SoAmigo> soAmigoCollection1) {
        this.soAmigoCollection1 = soAmigoCollection1;
    }

    @XmlTransient
    public Collection<SoCompartir> getSoCompartirCollection() {
        return soCompartirCollection;
    }

    public void setSoCompartirCollection(Collection<SoCompartir> soCompartirCollection) {
        this.soCompartirCollection = soCompartirCollection;
    }

    @XmlTransient
    public Collection<SoSolicitudAmistad> getSoSolicitudAmistadCollection() {
        return soSolicitudAmistadCollection;
    }

    public void setSoSolicitudAmistadCollection(Collection<SoSolicitudAmistad> soSolicitudAmistadCollection) {
        this.soSolicitudAmistadCollection = soSolicitudAmistadCollection;
    }

    @XmlTransient
    public Collection<SoSolicitudAmistad> getSoSolicitudAmistadCollection1() {
        return soSolicitudAmistadCollection1;
    }

    public void setSoSolicitudAmistadCollection1(Collection<SoSolicitudAmistad> soSolicitudAmistadCollection1) {
        this.soSolicitudAmistadCollection1 = soSolicitudAmistadCollection1;
    }

    @XmlTransient
    public Collection<SiAdjunto> getSiAdjuntoCollection() {
        return siAdjuntoCollection;
    }

    public void setSiAdjuntoCollection(Collection<SiAdjunto> siAdjuntoCollection) {
        this.siAdjuntoCollection = siAdjuntoCollection;
    }

    @XmlTransient
    public Collection<SoComentario> getSoComentarioCollection() {
        return soComentarioCollection;
    }

    public void setSoComentarioCollection(Collection<SoComentario> soComentarioCollection) {
        this.soComentarioCollection = soComentarioCollection;
    }

    @XmlTransient
    public Collection<SoPost> getSoPostCollection() {
        return soPostCollection;
    }

    public void setSoPostCollection(Collection<SoPost> soPostCollection) {
        this.soPostCollection = soPostCollection;
    }

    public SoTipoUsuario getSoTipoUsuario() {
        return soTipoUsuario;
    }

    public void setSoTipoUsuario(SoTipoUsuario soTipoUsuario) {
        this.soTipoUsuario = soTipoUsuario;
    }

    public SoCarrera getSoCarrera() {
        return soCarrera;
    }

    public void setSoCarrera(SoCarrera soCarrera) {
        this.soCarrera = soCarrera;
    }

    @XmlTransient
    public Collection<SoNotificacion> getSoNotificacionCollection() {
        return soNotificacionCollection;
    }

    public void setSoNotificacionCollection(Collection<SoNotificacion> soNotificacionCollection) {
        this.soNotificacionCollection = soNotificacionCollection;
    }

    @XmlTransient
    public Collection<SoMeGusta> getSoMeGustaCollection() {
        return soMeGustaCollection;
    }

    public void setSoMeGustaCollection(Collection<SoMeGusta> soMeGustaCollection) {
        this.soMeGustaCollection = soMeGustaCollection;
    }

    @XmlTransient
    public Collection<SiMovimiento> getSiMovimientoCollection() {
        return siMovimientoCollection;
    }

    public void setSiMovimientoCollection(Collection<SiMovimiento> siMovimientoCollection) {
        this.siMovimientoCollection = siMovimientoCollection;
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
        if (!(object instanceof SiUsuario)) {
            return false;
        }
        SiUsuario other = (SiUsuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SiUsuario[ id=" + id + " ]";
    }
    
}
