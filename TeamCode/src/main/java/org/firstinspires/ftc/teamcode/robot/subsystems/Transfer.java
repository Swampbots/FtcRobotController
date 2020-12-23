package org.firstinspires.ftc.teamcode.robot.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Transfer extends SubsystemBase {
    private HardwareMap hardwareMap;

    private DcMotor transfer;

    private double power = 0;
    private boolean reverse = false;

    public Transfer(HardwareMap hardwareMap){
        this.hardwareMap = hardwareMap;

        initHardware();
    }


    public void initHardware() {
        transfer = hardwareMap.get(DcMotor.class, "transfer");
    }

    @Override
    public void periodic() {
        transfer.setPower(power * (reverse?-1:1));
    }

    public void setPower(double power){
        this.power = power;
    }

    public double getPower(){
        return power;
    }

    public void setReverse(boolean reverse){
        this.reverse = reverse;
    }

    public void reverse(){
        this.reverse = !this.reverse;
    }

    public boolean getReverse(){
        return reverse;
    }
}
