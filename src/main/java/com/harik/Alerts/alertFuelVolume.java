package com.harik.Alerts;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name="Sets fuel volume priority")
public class alertFuelVolume {

    private double maxFuelVolume;
    private  double fuelVolume;
    private boolean result;



    @Condition
    public boolean checkRPM() {
        if(fuelVolume<(maxFuelVolume*0.1))
            return true;
        return false;
    }

    @Action
    public void rpmCall() throws Exception
    {
        setResult(true);
    }

    public boolean isResult() {
        return result;
    }

    public alertFuelVolume(double maxFuelVolume, double fuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
        this.fuelVolume = fuelVolume;
    }

    public void setResult(boolean result) {
        this.result = result;
    }




}
