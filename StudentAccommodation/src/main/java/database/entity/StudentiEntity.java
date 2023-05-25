package database.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@NamedQuery(name = "CheckRegister", query = "SELECT c.inregistrat FROM StudentiEntity c WHERE c.nrMatricol=:nrMatricol")
@NamedQuery(name = "StudentsShowAll", query = "SELECT c FROM StudentiEntity c")
@NamedQuery(name = "StudentsFindById", query = "SELECT c FROM StudentiEntity c WHERE c.id=?1")
@NamedQuery(name = "StudentsFindBySerialNumber", query = "SELECT c FROM StudentiEntity c WHERE c.nrMatricol=:nrMatricol")
@NamedQuery(name = "StudentsExistsById", query = "SELECT COUNT(c) FROM StudentiEntity c WHERE c.id=?1")
@NamedQuery(name = "StudentsExistsBySerialNumber", query = "SELECT COUNT(c) FROM StudentiEntity c WHERE c.nrMatricol=:nrMatricol")
@NamedQuery(name = "StudentsShowGPABySerialNumber", query = "SELECT c.medie FROM StudentiEntity c WHERE c.nrMatricol=:nrMatricol")
@NamedQuery(name = "StudentValidation", query = "SELECT count(c) FROM StudentiEntity c WHERE c.nrMatricol=:nr_matricol")
@NamedQuery(name = "UpdateCamin", query = "SELECT c.nrMatricol FROM StudentiEntity c WHERE c.camineByIdCamin=1")
@NamedQuery(name = "UpdateCamin10", query = "SELECT c.nrMatricol FROM StudentiEntity c WHERE c.camineByIdCamin=2")
@NamedQuery(name = "UpdateCamin20", query = "SELECT c.nrMatricol FROM StudentiEntity c WHERE c.camineByIdCamin=3")
@NamedQuery(name = "UpdateCamin30", query = "SELECT c.nrMatricol FROM StudentiEntity c WHERE c.camineByIdCamin=4")
@NamedQuery(name = "UpdateCamin40", query = "SELECT c.nrMatricol FROM StudentiEntity c WHERE c.camineByIdCamin=5")
@NamedQuery(name = "UpdateCamin2", query = "SELECT c.medie FROM StudentiEntity c WHERE c.nrMatricol=:matricol")
@NamedQuery(name = "UpdateCamin3", query = "SELECT c.camineByIdCamin FROM StudentiEntity c WHERE c.nrMatricol=:matricol")
@NamedQuery(name = "StudentOrderByGender", query = "SELECT c from StudentiEntity c WHERE c.camineByIdCamin > 0 and c.inregistrat = true ORDER BY c.medie desc, c.gen")
@NamedQuery(name = "ShowStudentsDormitory1", query = "SELECT c from StudentiEntity c WHERE c.camineByIdCamin = 1 and c.inregistrat = true ORDER BY c.medie desc, c.gen")
@NamedQuery(name = "ShowStudentsDormitory2", query = "SELECT c from StudentiEntity c WHERE c.camineByIdCamin = 2 and c.inregistrat = true ORDER BY c.medie desc, c.gen")
@NamedQuery(name = "ShowStudentsDormitory3", query = "SELECT c from StudentiEntity c WHERE c.camineByIdCamin = 3 and c.inregistrat = true ORDER BY c.medie desc, c.gen")
@NamedQuery(name = "ShowStudentsDormitory4", query = "SELECT c from StudentiEntity c WHERE c.camineByIdCamin = 4 and c.inregistrat = true ORDER BY c.medie desc, c.gen")
@NamedQuery(name = "ShowStudentsDormitory5", query = "SELECT c from StudentiEntity c WHERE c.camineByIdCamin = 5 and c.inregistrat = true ORDER BY c.medie desc, c.gen")
@Table(name = "studenti", schema = "public", catalog = "xunyvuvx")
public class StudentiEntity implements Serializable {
    @Basic
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nr_matricol")
    private String nrMatricol;
    @Basic
    @Column(name = "nume")
    private String nume;
    @Basic
    @Column(name = "prenume")
    private String prenume;
    @Basic
    @Column(name = "an")
    private Integer an;
    @Basic
    @Column(name = "grupa")
    private String grupa;
    @Basic
    @Column(name = "data_nastere")
    private String dataNastere;
    @Basic
    @Column(name = "gen")
    private String gen;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "medie")
    private Double medie;
    @Basic
    @Column(name = "inregistrat")
    private Boolean inregistrat;

    @Basic
    @Column(name = "id_camin")
    private Integer camineByIdCamin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNrMatricol() {
        return nrMatricol;
    }

    public void setNrMatricol(String nrMatricol) {
        this.nrMatricol = nrMatricol;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public Integer getAn() {
        return an;
    }

    public void setAn(Integer an) {
        this.an = an;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public String getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(String dataNastere) {
        this.dataNastere = dataNastere;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getMedie() {
        return medie;
    }

    public void setMedie(Double medie) {
        this.medie = medie;
    }

    public Boolean getInregistrat() {
        return inregistrat;
    }

    public void setInregistrat(Boolean inregistrat) {
        this.inregistrat = inregistrat;
    }

    public String getGen() {
        return gen;
    }


    public void setGen(String gen) {
        this.gen = gen;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentiEntity that = (StudentiEntity) o;

        if (id != that.id) return false;
        if (nrMatricol != null ? !nrMatricol.equals(that.nrMatricol) : that.nrMatricol != null) return false;
        if (nume != null ? !nume.equals(that.nume) : that.nume != null) return false;
        if (prenume != null ? !prenume.equals(that.prenume) : that.prenume != null) return false;
        if (an != null ? !an.equals(that.an) : that.an != null) return false;
        if (grupa != null ? !grupa.equals(that.grupa) : that.grupa != null) return false;
        if (gen != null ? !gen.equals(that.gen) : that.gen != null) return false;
        if (dataNastere != null ? !dataNastere.equals(that.dataNastere) : that.dataNastere != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (medie != null ? !medie.equals(that.medie) : that.medie != null) return false;
        if (inregistrat != null ? !inregistrat.equals(that.inregistrat) : that.inregistrat != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nrMatricol != null ? nrMatricol.hashCode() : 0);
        result = 31 * result + (nume != null ? nume.hashCode() : 0);
        result = 31 * result + (prenume != null ? prenume.hashCode() : 0);
        result = 31 * result + (an != null ? an.hashCode() : 0);
        result = 31 * result + (grupa != null ? grupa.hashCode() : 0);
        result = 31 * result + (dataNastere != null ? dataNastere.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (medie != null ? medie.hashCode() : 0);
        result = 31 * result + (inregistrat != null ? inregistrat.hashCode() : 0);
        result = 31 * result + (gen != null ? gen.hashCode() : 0);
        return result;
    }

    public Integer getCamineByIdCamin() {
        return camineByIdCamin;
    }

    public void setCamineByIdCamin(Integer camineByIdCamin) {
        this.camineByIdCamin = camineByIdCamin;
    }

    @Override
    public String toString() {
        return "StudentiEntity{" +
                "id=" + id +
                ", nrMatricol='" + nrMatricol + '\'' +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", gen='" + gen + '\'' +
                ", an=" + an +
                ", grupa='" + grupa + '\'' +
                ", dataNastere='" + dataNastere + '\'' +
                ", email='" + email + '\'' +
                ", medie=" + medie +
                ", inregistrat=" + inregistrat +
                ", camineByIdCamin=" + camineByIdCamin +
                '}';
    }
}
