package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp (name = "Drivetrain Drive Test", group = "Test")
public class Drivetrain extends OpMode {

    //exact copy of drive train code from my repo - Jahnavi
    private DcMotorEx leftDrive, rightDrive, leftBackDrive, rightBackDrive;

    @Override
    public void init () {
        leftDrive = hardwareMap.get(DcMotorEx.class, "FL");
        leftBackDrive = hardwareMap.get(DcMotorEx.class, "BL");
        rightDrive = hardwareMap.get(DcMotorEx.class, "FR");
        rightBackDrive = hardwareMap.get(DcMotorEx.class, "BR");

        leftDrive.setDirection(DcMotorEx.Direction.FORWARD);
        leftBackDrive.setDirection(DcMotorEx.Direction.FORWARD);
        rightDrive.setDirection(DcMotorEx.Direction.REVERSE);
        rightBackDrive.setDirection(DcMotorEx.Direction.FORWARD);
    }

    @Override
    public void loop () {
        double x = -gamepad1.left_stick_y; //fix front and back
        double y = gamepad1.left_stick_x * 1.1;
        double rx = gamepad1.right_stick_x;

        //following gm0 mecanum drive
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double leftPower = (y + x + rx) / denominator;
        double rightPower = (y - x + rx) / denominator;
        double leftBackPower = (y - x - rx) / denominator;
        double rightBackPower = (y + x - rx) / denominator;

        //drive train
        leftDrive.setPower (leftPower * 0.7);
        rightDrive.setPower(rightPower * 0.7);
        leftBackDrive.setPower(leftBackPower * 0.7);
        rightBackDrive.setPower(rightBackPower * 0.7);
    }
}