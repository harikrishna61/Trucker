package com.harik.Alerts;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = "checks engine coolant or lights true")
public class alertCoolantLights {

    private boolean checkEngineLightOn;

    private boolean engineCoolantLow;

    private boolean result;

    @Condition
    public boolean checkCoolantAndLights()
    {
        if(checkEngineLightOn || engineCoolantLow)
            return true;
        return false;
    }

    @Action
    public void checkCoolantANDLIGHTSCALL()
    {
        setResult(true);
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public alertCoolantLights(boolean checkEngineLightOn, boolean engineCoolantLow) {
        this.checkEngineLightOn = checkEngineLightOn;
        this.engineCoolantLow = engineCoolantLow;
    }


}
