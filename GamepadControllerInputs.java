package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "GamepadControllerInputs (Blocks to Java)")
public class GamepadControllerInputs extends LinearOpMode {

  private DcMotor BackLeft;
  private DcMotor DuckySpinMotor;
  private DcMotor BackRight;
  private DcMotor Leftyarm;
  private CRServo intakmoter;

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
    Leftyarm = hardwareMap.get(DcMotor.class, "Lefty arm");
    intakmoter = hardwareMap.get(CRServo.class, "intak moter");

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
          DuckySpinMotor.setPower(1);
        } else if (gamepad1.dpad_up) {
          DuckySpinMotor.setPower(-1);
        } else {
          DuckySpinMotor.setPower(0);
        }
        if (gamepad1.x) {
          Leftyarm.setPower(1);
        } else {
          Leftyarm.setPower(0);
        }
        if (gamepad1.y) {
          Leftyarm.setPower(-0.75);
        } else {
          Leftyarm.setPower(0);
        }
        if (gamepad1.a) {
          intakmoter.setPower(1);
        } else {
          intakmoter.setPower(0);
        }
        if (gamepad1.b) {
          intakmoter.setPower(-0.5);
        } else {
          intakmoter.setPower(0);
        }
        telemetry.update();
      }
    }
  }
}
