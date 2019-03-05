package com.example.will.app_for_child_demo.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName = "child_table")
public class Child implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String name;

    @NonNull
    private Date birthday;

    @NonNull
    private boolean gender; // male 0, female 1

    @NonNull
    private String dni;

    private double birthWeight = 0;

    private String motherName = "";

    private String location = "";

    private String community = "";

    private boolean facility = false; // home 0, healthcenter 1

    private boolean disability = false; // 0 none, 1 have

    // home visit info
    private boolean psysicalDev = false;

    private boolean languageDev = false;

    // home visit register info
    private double weight = 0;

    private double height = 0;

    private double hemoLevel = 0;

    private Date dateVisit;

    private boolean finished = false;

    private Date dateCheck;

    private Date dateDewarm;

    // vaccines
    private boolean bcg = false;

    private boolean hvb = false;

    private boolean penta1 = false;

    private boolean vop1 = false;

    private boolean todpt = false;

    private boolean hib = false;

    private boolean vop2 = false;

    private boolean penta2 = false;

    private boolean vop3 = false;

    private boolean spr = false;

    private boolean ama = false;

    // diseases
    private boolean diarrhea = false;

    private boolean malaria = false;

    private boolean flu = false;

    private boolean pneumonia = false;

    private boolean tuberculosis = false;

    public Child(@NonNull String name, @NonNull Date birthday, @NonNull boolean gender, @NonNull String dni, double birthWeight, String motherName, String location, String community, boolean facility, boolean disability) {

        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.dni = dni;
        this.birthWeight = birthWeight;
        this.motherName = motherName;
        this.location = location;
        this.community = community;
        this.facility = facility;
        this.disability = disability;
        this.dateVisit = new Date();
        this.dateCheck = new Date();
        this.dateDewarm = new Date();
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public Date getBirthday() {
        return birthday;
    }

    @NonNull
    public boolean isGender() {
        return gender;
    }

    @NonNull
    public String getDni() {
        return dni;
    }

    public double getBirthWeight() {
        return birthWeight;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getLocation() {
        return location;
    }

    public String getCommunity() {
        return community;
    }

    public boolean isFacility() {
        return facility;
    }

    public boolean isDisability() {
        return disability;
    }

    public boolean isPsysicalDev() {
        return psysicalDev;
    }

    public boolean isLanguageDev() {
        return languageDev;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double getHemoLevel() {
        return hemoLevel;
    }

    public boolean isBcg() {
        return bcg;
    }

    public boolean isHvb() {
        return hvb;
    }

    public boolean isPenta1() {
        return penta1;
    }

    public boolean isVop1() {
        return vop1;
    }

    public boolean isTodpt() {
        return todpt;
    }

    public boolean isHib() {
        return hib;
    }

    public boolean isVop2() {
        return vop2;
    }

    public boolean isPenta2() {
        return penta2;
    }

    public boolean isVop3() {
        return vop3;
    }

    public boolean isSpr() {
        return spr;
    }

    public boolean isAma() {
        return ama;
    }

    public boolean isDiarrhea() {
        return diarrhea;
    }

    public boolean isMalaria() {
        return malaria;
    }

    public boolean isFlu() {
        return flu;
    }

    public boolean isPneumonia() {
        return pneumonia;
    }

    public boolean isTuberculosis() {
        return tuberculosis;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(@NonNull String name) {
        this.name = name;
    }

    public void setBirthday(@NonNull Date birthday) {
        this.birthday = birthday;
    }

    public void setGender(@NonNull boolean gender) {
        this.gender = gender;
    }

    public void setDni(@NonNull String dni) {
        this.dni = dni;
    }

    public void setBirthWeight(double birthWeight) {
        this.birthWeight = birthWeight;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public void setFacility(boolean facility) {
        this.facility = facility;
    }

    public void setDisability(boolean disability) {
        this.disability = disability;
    }

    public void setPsysicalDev(boolean psysicalDev) {
        this.psysicalDev = psysicalDev;
    }

    public void setLanguageDev(boolean languageDev) {
        this.languageDev = languageDev;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setHemoLevel(double hemoLevel) {
        this.hemoLevel = hemoLevel;
    }

    public void setBcg(boolean bcg) {
        this.bcg = bcg;
    }

    public void setHvb(boolean hvb) {
        this.hvb = hvb;
    }

    public void setPenta1(boolean penta1) {
        this.penta1 = penta1;
    }

    public void setVop1(boolean vop1) {
        this.vop1 = vop1;
    }

    public void setTodpt(boolean todpt) {
        this.todpt = todpt;
    }

    public void setHib(boolean hib) {
        this.hib = hib;
    }

    public void setVop2(boolean vop2) {
        this.vop2 = vop2;
    }

    public void setPenta2(boolean penta2) {
        this.penta2 = penta2;
    }

    public void setVop3(boolean vop3) {
        this.vop3 = vop3;
    }

    public void setSpr(boolean spr) {
        this.spr = spr;
    }

    public void setAma(boolean ama) {
        this.ama = ama;
    }

    public void setDiarrhea(boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public void setMalaria(boolean malaria) {
        this.malaria = malaria;
    }

    public void setFlu(boolean flu) {
        this.flu = flu;
    }

    public void setPneumonia(boolean pneumonia) {
        this.pneumonia = pneumonia;
    }

    public void setTuberculosis(boolean tuberculosis) {
        this.tuberculosis = tuberculosis;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public Date getDateVisit() {
        return dateVisit;
    }

    public void setDateVisit(Date dateVisit) {
        this.dateVisit = dateVisit;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Date getDateCheck() {
        return dateCheck;
    }

    public void setDateCheck(Date dateCheck) {
        this.dateCheck = dateCheck;
    }

    public Date getDateDewarm() {
        return dateDewarm;
    }

    public void setDateDewarm(Date dateDewarm) {
        this.dateDewarm = dateDewarm;
    }
}