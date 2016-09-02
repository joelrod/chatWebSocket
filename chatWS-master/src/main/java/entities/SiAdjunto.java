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
@Table(name = "si_adjunto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiAdjunto.findAll", query = "SELECT s FROM SiAdjunto s"),
    @NamedQuery(name = "SiAdjunto.findById", query = "SELECT s FROM SiAdjunto s WHERE s.id = :id"),
    @NamedQuery(name = "SiAdjunto.findByNombre", query = "SELECT s FROM SiAdjunto s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SiAdjunto.findByTipoArchivo", query = "SELECT s FROM SiAdjunto s WHERE s.tipoArchivo = :tipoArchivo"),
    @NamedQuery(name = "SiAdjunto.findByRuta", query = "SELECT s FROM SiAdjunto s WHERE s.ruta = :ruta"),
    @NamedQuery(name = "SiAdjunto.findByExtension", query = "SELECT s FROM SiAdjunto s WHERE s.extension = :extension"),
    @NamedQuery(name = "SiAdjunto.findByFechaGenero", query = "SELECT s FROM SiAdjunto s WHERE s.fechaGenero = :fechaGenero"),
    @NamedQuery(name = "SiAdjunto.findByHoraGenero", query = "SELECT s FROM SiAdjunto s WHERE s.horaGenero = :horaGenero"),
    @NamedQuery(name = "SiAdjunto.findByEliminado", query = "SELECT s FROM SiAdjunto s WHERE s.eliminado = :eliminado")})
public class SiAdjunto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo_archivo")
    private String tipoArchivo;
    @Column(name = "ruta")
    private String ruta;
    @Column(name = "extension")
    private String extension;
    @Column(name = "fecha_genero")
    @Temporal(TemporalType.DATE)
    private Date fechaGenero;
    @Column(name = "hora_genero")
    @Temporal(TemporalType.TIME)
    private Date horaGenero;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @JoinColumn(name = "genero", referencedColumnName = "id")
    @ManyToOne
    private SiUsuario genero;
    @OneToMany(mappedBy = "siAdjunto")
    private Collection<SoPost> soPostCollection;

    public SiAdjunto() {
    }

    public SiAdjunto(Integer id) {
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

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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

    public SiUsuario getGenero() {
        return genero;
    }

    public void setGenero(SiUsuario genero) {
        this.genero = genero;
    }

    @XmlTransient
    public Collection<SoPost> getSoPostCollection() {
        return soPostCollection;
    }

    public void setSoPostCollection(Collection<SoPost> soPostCollection) {
        this.soPostCollection = soPostCollection;
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
        if (!(object instanceof SiAdjunto)) {
            return false;
        }
        SiAdjunto other = (SiAdjunto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SiAdjunto[ id=" + id + " ]";
    }
    
}
