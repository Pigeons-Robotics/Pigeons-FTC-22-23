package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "ThereAreLotsOfOpModes (Blocks to Java)")
public class ThereAreLotsOfOpModes extends LinearOpMode {

  private DcMotor BackLeft;
  private DcMotor DuckySpinMotor;
  private DcMotor BackRight;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    float x;
    float y;

    BackLeft = hardwareMap.get(DcMotor.class, "Back Left");
    DuckySpinMotor = hardwareMap.get(DcMotor.class, "Ducky Spin Motor");
    BackRight = hardwareMap.get(DcMotor.class, "Back Right");

    BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    DuckySpinMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        x = gamepad1.left_stick_x;
        y = -gamepad1.left_stick_y;
        BackRight.setPower(y - x);
        BackLeft.setPower(y + x);
        if (gamepad1.dpad_down) {
          DuckySpinMotor.setPower(0.5);
        } else if (gamepad1.dpad_up) {
          DuckySpinMotor.setPower(-0.5);
        } else {
          DuckySpinMotor.setPower(0);
        }
        telemetry.update();
      }
    }
  }
}
