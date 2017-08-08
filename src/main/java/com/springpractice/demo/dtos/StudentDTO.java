package com.springpractice.demo.dtos;

import java.sql.Date;

public class StudentDTO {

    private boolean bursier=false;
    private Date dataNastere;
    private String nrMatricol;
    private String nume;
    private String prenume;


    public StudentDTO(Date dataNastere, String nrMatricol, String nume, String prenume) {
        this.dataNastere = dataNastere;
        this.nrMatricol = nrMatricol;
        this.nume = nume;
        this.prenume = prenume;
    }

    public void addBursa(){
        this.bursier=true;
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
}
