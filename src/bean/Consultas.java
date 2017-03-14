/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Edson Ricardo Czarneski (contato@edsonrczarneski.com)
 */
@Entity
@Table(name = "consultas", catalog = "dbconsultorio", schema = "")
@NamedQueries({
    @NamedQuery(name = "Consultas.findAll", query = "SELECT c FROM Consultas c"),
    @NamedQuery(name = "Consultas.findByIdconsulta", query = "SELECT c FROM Consultas c WHERE c.idconsulta = :idconsulta"),
    @NamedQuery(name = "Consultas.findByData", query = "SELECT c FROM Consultas c WHERE c.data = :data"),
    @NamedQuery(name = "Consultas.findByHora", query = "SELECT c FROM Consultas c WHERE c.hora = :hora"),
    @NamedQuery(name = "Consultas.findByPacienteIdpaciente", query = "SELECT c FROM Consultas c WHERE c.pacienteIdpaciente = :pacienteIdpaciente"),
    @NamedQuery(name = "Consultas.findByMedicoIdmedico", query = "SELECT c FROM Consultas c WHERE c.medicoIdmedico = :medicoIdmedico")})
public class Consultas implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconsulta")
    private Integer idconsulta;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @ManyToOne
    @JoinColumn(name = "paciente_idpaciente")
    private Paciente pacienteIdpaciente;
    @ManyToOne
    @JoinColumn(name = "medico_idmedico")
    private Medico medicoIdmedico;

    public Consultas() {
    }

    public Consultas(Integer idconsulta) {
        this.idconsulta = idconsulta;
    }

    public Consultas(Integer idconsulta, Paciente pacienteIdpaciente, Medico medicoIdmedico) {
        this.idconsulta = idconsulta;
        this.pacienteIdpaciente = pacienteIdpaciente;
        this.medicoIdmedico = medicoIdmedico;
    }

    public Integer getIdconsulta() {
        return idconsulta;
    }

    public void setIdconsulta(Integer idconsulta) {
        Integer oldIdconsulta = this.idconsulta;
        this.idconsulta = idconsulta;
        changeSupport.firePropertyChange("idconsulta", oldIdconsulta, idconsulta);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        Date oldHora = this.hora;
        this.hora = hora;
        changeSupport.firePropertyChange("hora", oldHora, hora);
    }

    public Paciente getPacienteIdpaciente() {
        return pacienteIdpaciente;
    }

    public void setPacienteIdpaciente(Paciente pacienteIdpaciente) {
        Paciente oldPacienteIdpaciente = this.pacienteIdpaciente;
        this.pacienteIdpaciente = pacienteIdpaciente;
        changeSupport.firePropertyChange("pacienteIdpaciente", oldPacienteIdpaciente, pacienteIdpaciente);
    }

    public Medico getMedicoIdmedico() {
        return medicoIdmedico;
    }

    public void setMedicoIdmedico(Medico medicoIdmedico) {
        Medico oldMedicoIdmedico = this.medicoIdmedico;
        this.medicoIdmedico = medicoIdmedico;
        changeSupport.firePropertyChange("medicoIdmedico", oldMedicoIdmedico, medicoIdmedico);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconsulta != null ? idconsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultas)) {
            return false;
        }
        Consultas other = (Consultas) object;
        if ((this.idconsulta == null && other.idconsulta != null) || (this.idconsulta != null && !this.idconsulta.equals(other.idconsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Consultas[ idconsulta=" + idconsulta + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
