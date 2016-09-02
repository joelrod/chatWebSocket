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
@Table(name = "so_post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SoPost.findAll", query = "SELECT s FROM SoPost s"),
    @NamedQuery(name = "SoPost.findById", query = "SELECT s FROM SoPost s WHERE s.id = :id"),
    @NamedQuery(name = "SoPost.findByMensaje", query = "SELECT s FROM SoPost s WHERE s.mensaje = :mensaje"),
    @NamedQuery(name = "SoPost.findByNumeroMeGusta", query = "SELECT s FROM SoPost s WHERE s.numeroMeGusta = :numeroMeGusta"),
    @NamedQuery(name = "SoPost.findByNumeroComentarios", query = "SELECT s FROM SoPost s WHERE s.numeroComentarios = :numeroComentarios"),
    @NamedQuery(name = "SoPost.findByNumeroCompartido", query = "SELECT s FROM SoPost s WHERE s.numeroCompartido = :numeroCompartido"),
    @NamedQuery(name = "SoPost.findByNumeroVisto", query = "SELECT s FROM SoPost s WHERE s.numeroVisto = :numeroVisto"),
    @NamedQuery(name = "SoPost.findByFechaGenero", query = "SELECT s FROM SoPost s WHERE s.fechaGenero = :fechaGenero"),
    @NamedQuery(name = "SoPost.findByHoraGenero", query = "SELECT s FROM SoPost s WHERE s.horaGenero = :horaGenero"),
    @NamedQuery(name = "SoPost.findByEliminado", query = "SELECT s FROM SoPost s WHERE s.eliminado = :eliminado")})
public class SoPost implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "mensaje")
    private String mensaje;
    @Column(name = "numero_me_gusta")
    private Integer numeroMeGusta;
    @Column(name = "numero_comentarios")
    private Integer numeroComentarios;
    @Column(name = "numero_compartido")
    private Integer numeroCompartido;
    @Column(name = "numero_visto")
    private Integer numeroVisto;
    @Column(name = "fecha_genero")
    @Temporal(TemporalType.DATE)
    private Date fechaGenero;
    @Column(name = "hora_genero")
    @Temporal(TemporalType.TIME)
    private Date horaGenero;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @OneToMany(mappedBy = "soPost")
    private Collection<SoCompartir> soCompartirCollection;
    @OneToMany(mappedBy = "soPost")
    private Collection<SoPostMeGusta> soPostMeGustaCollection;
    @OneToMany(mappedBy = "soPost")
    private Collection<SoComentario> soComentarioCollection;
    @JoinColumn(name = "so_tipo_post", referencedColumnName = "id")
    @ManyToOne
    private SoTipoPost soTipoPost;
    @JoinColumn(name = "so_carrera", referencedColumnName = "id")
    @ManyToOne
    private SoCarrera soCarrera;
    @JoinColumn(name = "si_usuario", referencedColumnName = "id")
    @ManyToOne
    private SiUsuario siUsuario;
    @JoinColumn(name = "si_adjunto", referencedColumnName = "id")
    @ManyToOne
    private SiAdjunto siAdjunto;

    public SoPost() {
    }

    public SoPost(Integer id) {
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

    public Integer getNumeroComentarios() {
        return numeroComentarios;
    }

    public void setNumeroComentarios(Integer numeroComentarios) {
        this.numeroComentarios = numeroComentarios;
    }

    public Integer getNumeroCompartido() {
        return numeroCompartido;
    }

    public void setNumeroCompartido(Integer numeroCompartido) {
        this.numeroCompartido = numeroCompartido;
    }

    public Integer getNumeroVisto() {
        return numeroVisto;
    }

    public void setNumeroVisto(Integer numeroVisto) {
        this.numeroVisto = numeroVisto;
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
    public Collection<SoCompartir> getSoCompartirCollection() {
        return soCompartirCollection;
    }

    public void setSoCompartirCollection(Collection<SoCompartir> soCompartirCollection) {
        this.soCompartirCollection = soCompartirCollection;
    }

    @XmlTransient
    public Collection<SoPostMeGusta> getSoPostMeGustaCollection() {
        return soPostMeGustaCollection;
    }

    public void setSoPostMeGustaCollection(Collection<SoPostMeGusta> soPostMeGustaCollection) {
        this.soPostMeGustaCollection = soPostMeGustaCollection;
    }

    @XmlTransient
    public Collection<SoComentario> getSoComentarioCollection() {
        return soComentarioCollection;
    }

    public void setSoComentarioCollection(Collection<SoComentario> soComentarioCollection) {
        this.soComentarioCollection = soComentarioCollection;
    }

    public SoTipoPost getSoTipoPost() {
        return soTipoPost;
    }

    public void setSoTipoPost(SoTipoPost soTipoPost) {
        this.soTipoPost = soTipoPost;
    }

    public SoCarrera getSoCarrera() {
        return soCarrera;
    }

    public void setSoCarrera(SoCarrera soCarrera) {
        this.soCarrera = soCarrera;
    }

    public SiUsuario getSiUsuario() {
        return siUsuario;
    }

    public void setSiUsuario(SiUsuario siUsuario) {
        this.siUsuario = siUsuario;
    }

    public SiAdjunto getSiAdjunto() {
        return siAdjunto;
    }

    public void setSiAdjunto(SiAdjunto siAdjunto) {
        this.siAdjunto = siAdjunto;
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
        if (!(object instanceof SoPost)) {
            return false;
        }
        SoPost other = (SoPost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SoPost[ id=" + id + " ]";
    }
    
}
