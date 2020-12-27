package org.firstinspires.ftc.teamcode.robot.commands.teleop;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.robot.subsystems.Drive;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class TeleOpDriveControl extends CommandBase {
    private final Drive drive;

    private DoubleSupplier dri;
    private DoubleSupplier str;
    private DoubleSupplier twi;

    private final boolean GO_SLOW = false;

    public TeleOpDriveControl(Drive drive, DoubleSupplier dri, DoubleSupplier str, DoubleSupplier twi) {
        this.drive = drive;

        this.dri = dri;
        this.str = str;
        this.twi = twi;

        addRequirements(drive);
    }

    @Override
    public void initialize() {
        drive.setRunMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    @Override
    public void execute() {
        drive.setMecanumPower(dri.getAsDouble(), str.getAsDouble(), twi.getAsDouble(), GO_SLOW);
    }

    @Override
    public void end(boolean interrupted) {
        drive.stop();
    }

}