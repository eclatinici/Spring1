package com.springpractice.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name="trainingsql.student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name="bursier")
    private boolean bursier;

    @NotNull
    @Column(name="data_nastere")
    private Date dataNastere;

    @NotNull
    @Column(name="nr_matricol")
    private String nrMatricol;

    @NotNull
    @Column(name="nume")
    private String nume;

    @NotNull
    @Column(name="prenume")
    private String prenume;

    public Student(boolean bursier, Date dataNastere, String nrMatricol, String nume, String prenume) {
        this.bursier = bursier;
        this.dataNastere = dataNastere;
        this.nrMatricol = nrMatricol;
        this.nume = nume;
        this.prenume = prenume;
    }

    public boolean isBursier() {
        return bursier;
    }

    public Date getDataNastere() {
        return dataNastere;
    }

    public String getNrMatricol() {
        return nrMatricol;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }


    public void setBursier(boolean bursier) {
        this.bursier = bursier;
    }

    public void setDataNastere(Date dataNastere) {
        this.dataNastere = dataNastere;
    }

    public void setNrMatricol(String nrMatricol) {
        this.nrMatricol = nrMatricol;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    @Override
    public String toString(){
        return this.nume+" "+this.prenume;
    }
}
