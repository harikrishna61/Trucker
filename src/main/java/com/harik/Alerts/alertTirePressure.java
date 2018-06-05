package com.harik.Alerts;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = "Check Tire Pressure b/w 32 and 36")
public class alertTirePressure
{

    private double frontLeft;
    private double frontRight;
    private double rearLeft;
    private double rearRight;
    private boolean result;

    @Condition
    public boolean checkPressure() {
        if(frontLeft<32 && frontLeft >36 &&
                frontRight<32 && frontRight>36 &&
                rearLeft<32 && rearLeft>36 &&
                rearRight<32 && rearRight>36)
            return true;
        return false;
    }

    @Action
    public void callcheckPressure()
    {
        setResult(true);
    }

    public alertTirePressure(double frontLeft, double frontRight, double rearLeft, double rearRight) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.rearLeft = rearLeft;
        this.rearRight = rearRight;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public boolean isResult() {
        return result;
    }
}
