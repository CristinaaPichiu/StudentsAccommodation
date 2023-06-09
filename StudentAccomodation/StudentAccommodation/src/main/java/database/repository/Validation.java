package database.repository;


import database.model.StudentiEntity;
import database.managerfactory.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.Objects;


public class Validation {
    /**
     * Holds the last name .
     */
    private String lastName;
    /**
     * Holds the first name .
     */
    private String firstName;
    /**
     * Holds the year.
     */
    private String an;
    /**
     * Holds the group .
     */
    private String grupa;
    /**
     * Holds the email .
     */
    private String emailAdress;
    /**
     * Holds the serial number .
     */
    public String matricol;
    /**
     * Holds the GPA.
     */
    private String medie;
    /**
     * Holds the date of birth.
     */
    private String dataNastere;
    /**
     * Holds the gender.
     */
    private String femaleGender;
    /**
     * Holds the gender.
     */
    private String maleGender;
    /**
     * Holds the dormitory id.
     */
    private int camin;
    private double average = 0.0;
    javax.persistence.EntityManager entityManager = EntityManager.getEntityManagerFactory().createEntityManager();

    EntityTransaction transaction = entityManager.getTransaction();

    /**
     * Class constructor specifying the last name, the first name, the year, the group, the email, the serial number, the GPA, the date of birth, the gender of the student.
     */
    public Validation(String lastName, String firstName, String an, String grupa, String emailAdress, String matricol, String medie, String dataNastere, String femaleGender, String maleGender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.an = an;
        this.grupa = grupa;
        this.emailAdress = emailAdress;
        this.matricol = matricol;
        this.medie = medie;
        this.dataNastere = dataNastere;
        this.femaleGender = femaleGender;
        this.maleGender = maleGender;
    }

    /**
     * This method converts the date of birth.
     *
     * @param date
     * @return
     */
    private String formDate(String date) {
        String newDate;
        String month = null;
        newDate = date.substring(0, 2);
        newDate += "-";
        if (date.startsWith("01", 3)) {
            month = "JAN";
        } else if (date.startsWith("02", 3)) {
            month = "FEB";
        } else if (date.startsWith("03", 3)) {
            month = "MAR";
        } else if (date.startsWith("04", 3)) {
            month = "APR";
        } else if (date.startsWith("05", 3)) {
            month = "MAY";
        } else if (date.startsWith("06", 3)) {
            month = "JUN";
        } else if (date.startsWith("07", 3)) {
            month = "JUL";
        } else if (date.startsWith("08", 3)) {
            month = "AUG";
        } else if (date.startsWith("09", 3)) {
            month = "SEP";
        } else if (date.startsWith("10", 3)) {
            month = "OCT";
        } else if (date.startsWith("11", 3)) {
            month = "NOV";
        } else if (date.startsWith("12", 3)) {
            month = "DEC";
        }
        newDate += month;
        newDate += "-";
        newDate += date.substring(8, 10);

        return newDate;
    }

    /**
     * This method validates the student's accommodation at the dormitory.
     *
     * @return
     */
    public String validare() {

        String gen1;
        int anInt = Integer.parseInt(an);
        double medieDouble = Double.parseDouble(medie);
        dataNastere = formDate(dataNastere);

        if (Objects.equals(femaleGender, "true"))
            gen1 = "F";
        else
            gen1 = "M";

        Query query = entityManager.createQuery("SELECT c FROM StudentiEntity c");
        List<StudentiEntity> results = query.getResultList();
        for (StudentiEntity student : results) {
            System.out.println(student.toString());
        }

        System.out.println(matricol);
        System.out.println(lastName);
        System.out.println(firstName);
        System.out.println(gen1);
        System.out.println(anInt);
        System.out.println(grupa);
        System.out.println(dataNastere);
        System.out.println(emailAdress);
        System.out.println(medieDouble);



        int count = Math.toIntExact((long) entityManager.createNamedQuery("StudentValidation")
                .setParameter("nr_matricol", matricol)
                .getSingleResult());

        System.out.println(count);


        if (count > 0) {
            if (!verificareInregistrat(matricol)) {

                if (verifica_camin(matricol)) {

                    transaction.begin();
                    entityManager.createNativeQuery("UPDATE studenti SET inregistrat=true WHERE nr_matricol=:matricol")
                            .setParameter("matricol", matricol)
                            .executeUpdate();
                    transaction.commit();

                    transaction.begin();
                    int c = (int) entityManager.createNamedQuery("UpdateCamin3")
                            .setParameter("matricol", matricol)
                            .getSingleResult();
                    transaction.commit();

                    transaction.begin();
                    entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                            .setParameter("camin", c)
                            .setParameter("matricol", matricol)
                            .executeUpdate();
                    transaction.commit();
                    transaction.begin();
                    count = Math.toIntExact((int) entityManager.createNamedQuery("GetNumber")
                            .setParameter(1, c)
                            .getSingleResult());
                    transaction.commit();

                    count--;
                    transaction.begin();
                    entityManager.createNativeQuery("UPDATE camine SET capacitate_totala=:count WHERE id=:camin")
                            .setParameter("count", count)
                            .setParameter("camin", c)
                            .executeUpdate();
                    transaction.commit();

                    entityManager.close();
                    return "Ai aplicat cu succes!";
                }

                return "Esti in asteptare!";
            }
            return "Esti deja inregistrat!";
        }
        return "Informatii invalide!";
    }

    /**
     * This method validates the student's accommodation at the dormitory.
     *
     * @return
     */
    private boolean verifica_camin(String matricol) {
        double medie3 = (double) entityManager.createNamedQuery("UpdateCamin2")
                .setParameter("matricol", matricol)
                .getSingleResult();
        setMatricol(matricol);
        average = 0.0;
        int idCamin;
        double minim = 99999.0;
        String nr_matricolAdiacent = null;
        transaction.begin();
        int count1 = Math.toIntExact((int) entityManager.createNamedQuery("GetNumberC1")
                .setParameter("nume", "C1")
                .getSingleResult());
        transaction.commit();


        if (count1 > 0) {

            transaction.begin();
            idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                    .setParameter("nume", "C1")
                    .getSingleResult();
            transaction.commit();

            transaction.begin();
            entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                    .setParameter("camin", idCamin)
                    .setParameter("matricol", matricol)
                    .executeUpdate();
            transaction.commit();
            return true;


        } else {
            average = 0.0;
            transaction.begin();
            List name = entityManager.createNamedQuery("UpdateCamin")
                    .getResultList();
            transaction.commit();

            for (Object index : name) {
                transaction.begin();
                double medie1 = (double) entityManager.createNamedQuery("UpdateCamin2")
                        .setParameter("matricol", index)
                        .getSingleResult();
                transaction.commit();
                if (medie1 < medie3) {
                    if (medie1 < minim) {
                        average = medie1;
                        nr_matricolAdiacent = index.toString();
                        minim = medie1;
                    }
                }
            }

            if (average > 0.0) {

                transaction.begin();
                idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                        .setParameter("nume", "C1")
                        .getSingleResult();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET inregistrat=true WHERE nr_matricol=:matricol")
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                        .setParameter("camin", idCamin)
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=0 WHERE nr_matricol=:matricol")
                        .setParameter("matricol", nr_matricolAdiacent)
                        .executeUpdate();
                transaction.commit();
                verifica_camin(nr_matricolAdiacent);
                return true;

            }

        }
        minim = 99999.0;
        transaction.begin();
        int count2 = Math.toIntExact((int) entityManager.createNamedQuery("GetNumberC2")
                .setParameter("nume", "C2")
                .getSingleResult());
        transaction.commit();
        average = 0.0;
        if (count2 > 0) {

            transaction.begin();
            idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                    .setParameter("nume", "C2")
                    .getSingleResult();
            transaction.commit();
            transaction.begin();
            entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                    .setParameter("camin", idCamin)
                    .setParameter("matricol", matricol)
                    .executeUpdate();
            transaction.commit();
            return true;
        } else {
            average = 0.0;
            transaction.begin();
            List name = entityManager.createNamedQuery("UpdateCamin10")
                    .getResultList();
            transaction.commit();


            for (Object index : name) {
                transaction.begin();
                double medie1 = (double) entityManager.createNamedQuery("UpdateCamin2")
                        .setParameter("matricol", index)
                        .getSingleResult();

                transaction.commit();
                if (medie1 < medie3) {
                    if (medie1 < minim) {
                        average = medie1;
                        nr_matricolAdiacent = index.toString();
                        minim = medie1;
                    }
                }
            }
            if (average > 0.0) {
                transaction.begin();
                idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                        .setParameter("nume", "C2")
                        .getSingleResult();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET inregistrat=true WHERE nr_matricol=:matricol")
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                        .setParameter("camin", idCamin)
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();
                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=0 WHERE nr_matricol=:matricol")
                        .setParameter("matricol", nr_matricolAdiacent)
                        .executeUpdate();
                transaction.commit();
                verifica_camin(nr_matricolAdiacent);
                return true;
            }
        }

        average = 0.0;
        minim = 9999.0;
        transaction.begin();
        int count3 = Math.toIntExact((int) entityManager.createNamedQuery("GetNumberC3")
                .setParameter("nume", "C3")
                .getSingleResult());
        transaction.commit();

        if (count3 > 0) {

            transaction.begin();
            idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                    .setParameter("nume", "C3")
                    .getSingleResult();
            transaction.commit();

            transaction.begin();
            entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                    .setParameter("camin", idCamin)
                    .setParameter("matricol", matricol)
                    .executeUpdate();
            transaction.commit();
            return true;
        } else {
            average = 0.0;
            transaction.begin();
            List name = entityManager.createNamedQuery("UpdateCamin20")
                    .getResultList();
            transaction.commit();

            for (Object index : name) {
                transaction.begin();
                double medie1 = (double) entityManager.createNamedQuery("UpdateCamin2")
                        .setParameter("matricol", index)
                        .getSingleResult();
                transaction.commit();
                if (medie1 < medie3) {
                    if (medie1 < minim) {
                        average = medie1;
                        nr_matricolAdiacent = index.toString();
                        minim = medie1;
                    }
                }
            }
            if (average > 0.0) {

                transaction.begin();
                idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                        .setParameter("nume", "C3")
                        .getSingleResult();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET inregistrat=true WHERE nr_matricol=:matricol")
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                        .setParameter("camin", idCamin)
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=0 WHERE nr_matricol=:matricol")
                        .setParameter("matricol", nr_matricolAdiacent)
                        .executeUpdate();
                transaction.commit();
                verifica_camin(nr_matricolAdiacent);
                return true;
            }

        }

        average = 0.0;
        minim = 9999.0;
        transaction.begin();
        int count4 = Math.toIntExact((int) entityManager.createNamedQuery("GetNumberC4")
                .setParameter("nume", "C4")
                .getSingleResult());
        transaction.commit();

        if (count4 > 0) {

            transaction.begin();
            idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                    .setParameter("nume", "C4")
                    .getSingleResult();
            transaction.commit();

            transaction.begin();
            entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                    .setParameter("camin", idCamin)
                    .setParameter("matricol", matricol)
                    .executeUpdate();
            transaction.commit();
            return true;

        } else {
            average = 0.0;
            transaction.begin();
            List name = entityManager.createNamedQuery("UpdateCamin30")
                    .getResultList();
            transaction.commit();

            for (Object index : name) {
                transaction.begin();
                double medie1 = (double) entityManager.createNamedQuery("UpdateCamin2")
                        .setParameter("matricol", index)
                        .getSingleResult();
                transaction.commit();
                if (medie1 < medie3) {
                    if (medie1 < minim) {
                        average = medie1;
                        nr_matricolAdiacent = index.toString();
                        minim = medie1;
                    }
                }
            }
            if (average > 0.0) {

                transaction.begin();
                idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                        .setParameter("nume", "C4")
                        .getSingleResult();
                transaction.commit();


                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET inregistrat=true WHERE nr_matricol=:matricol")
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                        .setParameter("camin", idCamin)
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=0 WHERE nr_matricol=:matricol")
                        .setParameter("matricol", nr_matricolAdiacent)
                        .executeUpdate();
                transaction.commit();
                verifica_camin(nr_matricolAdiacent);
                return true;

            }

        }

        average = 0.0;
        minim = 9999.0;
        transaction.begin();
        int count5 = Math.toIntExact((int) entityManager.createNamedQuery("GetNumberC5")
                .setParameter("nume", "C5")
                .getSingleResult());
        transaction.commit();
        if (count5 > 0) {

            transaction.begin();
            idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                    .setParameter("nume", "C5")
                    .getSingleResult();
            transaction.commit();

            transaction.begin();
            entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                    .setParameter("camin", idCamin)
                    .setParameter("matricol", matricol)
                    .executeUpdate();
            transaction.commit();
            return true;

        } else {
            average = 0.0;
            transaction.begin();
            List name = entityManager.createNamedQuery("UpdateCamin40")
                    .getResultList();
            transaction.commit();

            for (Object index : name) {
                transaction.begin();
                double medie1 = (double) entityManager.createNamedQuery("UpdateCamin2")
                        .setParameter("matricol", index)
                        .getSingleResult();
                transaction.commit();
                if (medie1 < medie3) {
                    if (medie1 < minim) {
                        average = medie1;
                        nr_matricolAdiacent = index.toString();
                        minim = medie1;
                    }
                }
            }
            if (average > 0.0) {

                transaction.begin();
                idCamin = (int) entityManager.createNamedQuery("GetIdCamin")
                        .setParameter("nume", "C5")
                        .getSingleResult();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET inregistrat=true WHERE nr_matricol=:matricol")
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=:camin WHERE nr_matricol=:matricol")
                        .setParameter("camin", idCamin)
                        .setParameter("matricol", matricol)
                        .executeUpdate();
                transaction.commit();

                transaction.begin();
                entityManager.createNativeQuery("UPDATE studenti SET id_camin=0 WHERE nr_matricol=:matricol")
                        .setParameter("matricol", nr_matricolAdiacent)
                        .executeUpdate();
                transaction.commit();
                verifica_camin(nr_matricolAdiacent);
                return true;
            }

        }


        return false;
    }

    /**
     *
     * This method validates the student's accommodation at the dormitory.
     * @return
     */
    private boolean verificareInregistrat(String matricol) {

        boolean count = (boolean) entityManager.createNamedQuery("CheckRegister")
                .setParameter("nrMatricol", matricol)
                .getSingleResult();
        return count;
    }

    /**
     * This is a method called Setter that is used to set the dormitory.
     * @param camin
     */
    public void setCamin(int camin) {
        this.camin = camin;
    }

    /**
     * This is a method called Getter that is used to get the last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This is a method called Setter that is used to set the last name.
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This is a method called Getter that is used to get the first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This is a method called Setter that is used to set the first name.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This is a method called Getter that is used to get the year.
     */
    public String getAn() {
        return an;
    }

    /**
     * This is a method called Setter that is used to set the year.
     * @param an
     */
    public void setAn(String an) {
        this.an = an;
    }

    /**
     * This is a method called Getter that is used to get the group.
     */
    public String getGrupa() {
        return grupa;
    }

    /**
     * This is a method called Setter that is used to set the group.
     * @param grupa
     */
    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    /**
     * This is a method called Getter that is used to get the email.
     */
    public String getEmailAdress() {
        return emailAdress;
    }

    /**
     * This is a method called Setter that is used to set the email.
     * @param emailAdress
     */
    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    /**
     * This is a method called Getter that is used to get the serial number.
     */
    public String getMatricol() {
        return matricol;
    }

    /**
     * This is a method called Setter that is used to set the serial number.
     * @param matricol
     */
    public void setMatricol(String matricol) {
        this.matricol = matricol;
    }

    /**
     * This is a method called Getter that is used to get the GPA.
     */
    public String getMedie() {
        return medie;
    }

    /**
     *  This is a method called Setter that is used to set the GPA.
     * @param medie
     */
    public void setMedie(String medie) {
        this.medie = medie;
    }

    /**
     * This is a method called Getter that is used to get the date of birth.
     */
    public String getDataNastere() {
        return dataNastere;
    }

    /**
     * This is a method called Setter that is used to set the date of birth.
     * @param dataNastere
     */
    public void setDataNastere(String dataNastere) {
        this.dataNastere = dataNastere;
    }

    /**
     * This is a method called Getter that is used to get the gender.
     */

    public String getFemaleGender() {
        return femaleGender;
    }

    /**
     * This is a method called Setter that is used to set the gender.
     * @param femaleGender
     */
    public void setFemaleGender(String femaleGender) {
        this.femaleGender = femaleGender;
    }

    /**
     * This is a method called Getter that is used to get the gender.
     */
    public String getMaleGender() {
        return maleGender;
    }

    /**
     * This is a method called Setter that is used to set the gender.
     * @param maleGender
     */
    public void setMaleGender(String maleGender) {
        this.maleGender = maleGender;
    }
}