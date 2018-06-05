package com.harik.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Readings {


    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String readingsId;

//    @ManyToOne (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinColumn(name = "vin", foreignKey=@ForeignKey(name = "vin"))
    private String vin;


    private double latitude;
    private double longitude;
    private Date timestamp;
    private  double fuelVolume;
    private double speed;
    private double engineHp;
    private boolean checkEngineLightOn;
    private boolean engineCoolantLow;
    private boolean cruiseControlOn;
    private double engineRpm;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "tiresID")
    private Tires tires;

    public Readings() {
        this.readingsId = UUID.randomUUID().toString();
    }


    public String getVin() {
        return vin;
    }

    public void setVin(String  vin) {
        this.vin = vin;
    }


    public void setReadingsId(String readingsId) {
        this.readingsId = readingsId;
    }
    public String getReadingsId() {
        return readingsId;
    }



    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(double engineHp) {
        this.engineHp = engineHp;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public double getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(double engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }


}
