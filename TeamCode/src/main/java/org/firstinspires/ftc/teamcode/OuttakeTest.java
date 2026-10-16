package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class OuttakeTest extends OpMode {

    DcMotorEx shooter;

    int velocity = 0;

    @Override
    public void init(){

        shooter = hardwareMap.get(DcMotorEx.class, "s");
        shooter.setDirection(DcMotorSimple.Direction.FORWARD); // Either FORWARD or REVERSE
        shooter.setVelocityPIDFCoefficients(0.01, 5, 10, 0);


    }

    @Override
    public void loop(){



        shooter.setVelocity(velocity);

        if (gamepad2.dpad_right){
            velocity = 1000;
        } else if (gamepad2.dpad_left){
            velocity = 0;
        } else if (gamepad2.dpadUpWasPressed()){
            velocity += 10;
        } else if (gamepad2.dpadDownWasPressed()){
            velocity -= 10;
        }



        telemetry.addData("Current Velocity", shooter.getVelocity());
        telemetry.addData("Target Velocity", velocity);
        telemetry.addData("Set Power", shooter.getPower());
        telemetry.update();
    }
}
