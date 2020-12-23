package org.firstinspires.ftc.teamcode.robot.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Transfer extends SubsystemBase {
    private HardwareMap hardwareMap;

    private DcMotor transfer;

    private double power = 0;

    public Transfer(HardwareMap hardwareMap){
        this.hardwareMap = hardwareMap;

        initHardware();
    }

    public void initHardware() {
        transfer = hardwareMap.get(DcMotor.class, "transfer");
        transfer.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void periodic() {
        transfer.setPower(power);
    }

    public void setDirection(DcMotorSimple.Direction direction) {
        transfer.setDirection(direction);
    }

    public void setPower(double power) {
        this.power = power;
    }

    public void reverse() {
        if(transfer.getDirection() == DcMotorSimple.Direction.FORWARD) transfer.setDirection(DcMotorSimple.Direction.REVERSE);
        else transfer.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    public DcMotorSimple.Direction getDirection() {
        return transfer.getDirection();
    }

    public double getPower() {
        return power;
    }

}
