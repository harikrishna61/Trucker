package com.harik.Alerts;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = "Set RPM Priority")
public class alertRPM {

    private double engineRpm;
    private double redlineRpm;
    private boolean result;

    @Condition
    public boolean checkRPM() {
        if(engineRpm>redlineRpm)
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

    public alertRPM(double redlineRpm,double engineRpm) {
        this.engineRpm = engineRpm;
        this.redlineRpm = redlineRpm;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
