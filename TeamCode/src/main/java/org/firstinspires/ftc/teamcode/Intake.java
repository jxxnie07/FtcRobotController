package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp (name = "Intake Test", group = "Test")
public class Intake extends OpMode {
    DcMotorEx intake;

    //simple intake code with comments if any issue - Jahnavi
    @Override
    public void init () {
        intake = hardwareMap.get(DcMotorEx.class, "intake");
        intake.setDirection(DcMotorEx.Direction.FORWARD); //reverse if wrong direction
    }

    @Override
    public void loop () {

        if (gamepad1.a) {
            intake.setPower(0.7);
        } else if (gamepad1.b) {
            intake.setPower(-0.7); //opposite direction
        }
    }
}
