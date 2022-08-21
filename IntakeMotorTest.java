package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;

@TeleOp(name = "IntakeMotorTest (Blocks to Java)")
public class IntakeMotorTest extends LinearOpMode {

  private CRServo intakmoter;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    intakmoter = hardwareMap.get(CRServo.class, "intak moter");

    // Put initialization blocks here.
    waitForStart();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        if (gamepad1.a) {
          intakmoter.setPower(1);
        } else {
          intakmoter.setPower(0);
        }
        if (gamepad1.b) {
          intakmoter.setPower(-1);
        } else {
          intakmoter.setPower(0);
        }
        telemetry.update();
      }
    }
  }
}
