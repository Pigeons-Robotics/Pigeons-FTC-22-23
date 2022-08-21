package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "EncoderTest40InProgress (Blocks to Java)")
public class EncoderTest40InProgress extends LinearOpMode {

  private DcMotor BackLeft;
  private DcMotor BackRight;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    BackLeft = hardwareMap.get(DcMotor.class, "Back Left");
    BackRight = hardwareMap.get(DcMotor.class, "Back Right");

    drive(3, 3, 1, 1);
    sleep(100);
    drive(-1, -1, -0.5, -0.5);
  }

  /**
   * Describe this function...
   */
  private void drive(int right_rotations, int left_rotations, double right_speed, double left_speed) {
    BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    BackLeft.setTargetPosition(1440 * left_rotations);
    BackRight.setTargetPosition(1440 * right_rotations);
    waitForStart();
    BackLeft.setPower(left_speed);
    BackRight.setPower(right_speed);
    while (opModeIsActive() && BackLeft.isBusy() && BackRight.isBusy()) {
      telemetry.addData("right-rotations", BackRight.getTargetPosition());
      telemetry.addData("left-rotations", BackLeft.getTargetPosition());
      telemetry.update();
    }
  }
}
