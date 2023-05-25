package database.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NamedQuery(name = "GetIdCamin", query = "SELECT c.id FROM CamineEntity c WHERE c.denumire=:nume")
@NamedQuery(name = "GetNumberC1", query = "SELECT c.capacitateTotala FROM CamineEntity c WHERE c.denumire=:nume")
@NamedQuery(name = "GetNumberC2", query = "SELECT c.capacitateTotala FROM CamineEntity c WHERE c.denumire=:nume")
@NamedQuery(name = "GetNumberC3", query = "SELECT c.capacitateTotala FROM CamineEntity c WHERE c.denumire=:nume")
@NamedQuery(name = "GetNumberC4", query = "SELECT c.capacitateTotala FROM CamineEntity c WHERE c.denumire=:nume")
@NamedQuery(name = "GetNumberC5", query = "SELECT c.capacitateTotala FROM CamineEntity c WHERE c.denumire=:nume")
@NamedQuery(name = "GetNumber", query = "SELECT c.capacitateTotala FROM CamineEntity c WHERE c.id=?1")
@NamedQuery(name = "Camine_ShowAll", query = "SELECT c FROM CamineEntity c")
@NamedQuery(name = "Camine_FindById", query = "SELECT c FROM CamineEntity c WHERE c.id=?1")
@NamedQuery(name = "Camine_FindByName", query = "SELECT c FROM CamineEntity c WHERE c.denumire=:denumire")
@NamedQuery(name = "Camine_ExistsById", query = "SELECT COUNT(c) FROM CamineEntity c WHERE c.id=?1")
@NamedQuery(name = "Camine_ExistsByName", query = "SELECT COUNT(c) FROM CamineEntity c WHERE c.denumire=:denumire")
@Table(name = "camine", schema = "public", catalog = "xunyvuvx")

public class CamineEntity {
    @Basic
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "denumire")
    private String denumire;
    @Basic
    @Column(name = "pret_ron")
    private Integer pretRon;
    @Basic
    @Column(name = "capacitate_totala")
    private Integer capacitateTotala;
    @Basic
    @Column(name = "capacitate_per_camera")
    private Integer capacitatePerCamera;
    @Basic
    @Column(name = "nr_camere_total")
    private Integer nrCamereTotal;
    @Basic
    @Column(name = "nr_camere_baieti")
    private Integer nrCamereBaieti;
    @Basic
    @Column(name = "nr_camere_fete")
    private Integer nrCamereFete;
    @OneToMany(mappedBy = "camineByIdCamin")
    private Collection<StudentiEntity> studentisById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public Integer getPretRon() {
        return pretRon;
    }

    public void setPretRon(Integer pretRon) {
        this.pretRon = pretRon;
    }

    public Integer getCapacitateTotala() {
        return capacitateTotala;
    }

    public void setCapacitateTotala(Integer capacitateTotala) {
        this.capacitateTotala = capacitateTotala;
    }

    public Integer getCapacitatePerCamera() {
        return capacitatePerCamera;
    }

    public void setCapacitatePerCamera(Integer capacitatePerCamera) {
        this.capacitatePerCamera = capacitatePerCamera;
    }

    public Integer getNrCamereTotal() {
        return nrCamereTotal;
    }

    public void setNrCamereTotal(Integer nrCamereTotal) {
        this.nrCamereTotal = nrCamereTotal;
    }

    public Integer getNrCamereBaieti() {
        return nrCamereBaieti;
    }

    public void setNrCamereBaieti(Integer nrCamereBaieti) {
        this.nrCamereBaieti = nrCamereBaieti;
    }

    public Integer getNrCamereFete() {
        return nrCamereFete;
    }

    public void setNrCamereFete(Integer nrCamereFete) {
        this.nrCamereFete = nrCamereFete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CamineEntity that = (CamineEntity) o;

        if (id != that.id) return false;
        if (denumire != null ? !denumire.equals(that.denumire) : that.denumire != null) return false;
        if (pretRon != null ? !pretRon.equals(that.pretRon) : that.pretRon != null) return false;
        if (capacitateTotala != null ? !capacitateTotala.equals(that.capacitateTotala) : that.capacitateTotala != null)
            return false;
        if (capacitatePerCamera != null ? !capacitatePerCamera.equals(that.capacitatePerCamera) : that.capacitatePerCamera != null)
            return false;
        if (nrCamereTotal != null ? !nrCamereTotal.equals(that.nrCamereTotal) : that.nrCamereTotal != null)
            return false;
        if (nrCamereBaieti != null ? !nrCamereBaieti.equals(that.nrCamereBaieti) : that.nrCamereBaieti != null)
            return false;
        if (nrCamereFete != null ? !nrCamereFete.equals(that.nrCamereFete) : that.nrCamereFete != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (denumire != null ? denumire.hashCode() : 0);
        result = 31 * result + (pretRon != null ? pretRon.hashCode() : 0);
        result = 31 * result + (capacitateTotala != null ? capacitateTotala.hashCode() : 0);
        result = 31 * result + (capacitatePerCamera != null ? capacitatePerCamera.hashCode() : 0);
        result = 31 * result + (nrCamereTotal != null ? nrCamereTotal.hashCode() : 0);
        result = 31 * result + (nrCamereBaieti != null ? nrCamereBaieti.hashCode() : 0);
        result = 31 * result + (nrCamereFete != null ? nrCamereFete.hashCode() : 0);
        return result;
    }

    public Collection<StudentiEntity> getStudentisById() {
        return studentisById;
    }

    public void setStudentisById(Collection<StudentiEntity> studentisById) {
        this.studentisById = studentisById;
    }
}

