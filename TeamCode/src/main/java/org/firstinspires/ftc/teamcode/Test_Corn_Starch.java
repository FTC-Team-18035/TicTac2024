package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Robot: Teleop Tank", group="Robot")
public class Test_Corn_Starch extends OpMode {
    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;
    double turboPower = 2;

    @Override
    public void init() {
        leftDrive = hardwareMap.get(DcMotor.class, "Left");
        rightDrive = hardwareMap.get(DcMotor.class, "Right");
        rightDrive.setDirection(DcMotor.Direction.REVERSE);
        leftDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        telemetry.addData(">", "Robot Ready. PRESS START.");
    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
    }

    @Override
    public void loop() {
        double left;
        double right;
        if(gamepad1.right_bumper){
            turboPower = 1;
        }
        else{
            turboPower = 2;
        }
        telemetry.addData("turboPower", turboPower);
        left = -gamepad1.left_stick_y / turboPower;
        right = -gamepad1.right_stick_y / turboPower;
        leftDrive.setPower(left);
        rightDrive.setPower(right);
        telemetry.addData("left", "%.2f", left);
        telemetry.addData("right", "%.2f", right);
    }

    @Override
    public void stop() {
    }
}
