package com.example.tarrito.login_francisco_tiayna;

import com.example.tarrito.login_francisco_tiayna.MyAplication;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Trabajador  extends RealmObject{

    @PrimaryKey
    private int id;
    private String nombrebd;
    private String passwordbd;
    private String rutbd;
    private String edadbd;
    private String direccionbd;
    private String sueldobd;
    private String cargobd;

    public Trabajador(String juanito, String passwordbd, String rutbd, int i, String direccionbd, String sueldobd, String gerente){}

    public Trabajador(String nombrebd, String passwordbd, String rutbd, String edadbd, String direccionbd, String sueldobd, String cargobd){
        this.id = MyAplication.trabajadorID.incrementAndGet();
        this.nombrebd = nombrebd;
        this.passwordbd = passwordbd;
        this.rutbd = rutbd;
        this.edadbd = edadbd;
        this.direccionbd = direccionbd;
        this.sueldobd = sueldobd;
        this.cargobd = cargobd;
    }

    public int getId(){return id;}

    public void setId(int id){this.id = id;}

    public String getNombrebd() {
        return nombrebd;
    }

    public void setNombrebd(String nombrebd) {
        this.nombrebd = nombrebd;
    }

    public String getPasswordbd() {
        return passwordbd;
    }

    public void setPasswordbd(String passwordbd) {
        this.passwordbd = passwordbd;
    }

    public String getRutbd() {
        return rutbd;
    }

    public void setRutbd(String rutbd) {
        this.rutbd = rutbd;
    }

    public String getEdadbd() {
        return edadbd;
    }

    public void setEdadbd(String edadbd) {
        this.edadbd = edadbd;
    }

    public String getDireccionbd() {
        return direccionbd;
    }

    public void setDireccionbd(String direccionbd) {
        this.direccionbd = direccionbd;
    }

    public String getSueldobd() {
        return sueldobd;
    }

    public void setSueldobd(String sueldobd) {
        this.sueldobd = sueldobd;
    }

    public String getCargobd() {
        return cargobd;
    }

    public void setCargobd(String cargobd) {
        this.cargobd = cargobd;
    }
}
