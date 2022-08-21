package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "TurnyTootsterEncoderFunctionsWorking (Blocks to Java)")
public class TurnyTootsterEncoderFunctionsWorking extends LinearOpMode {

  private DcMotor DuckySpinMotor;
  private DcMotor BackLeft;
  private DcMotor BackRight;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    DuckySpinMotor = hardwareMap.get(DcMotor.class, "Ducky Spin Motor");
    BackLeft = hardwareMap.get(DcMotor.class, "Back Left");
    BackRight = hardwareMap.get(DcMotor.class, "Back Right");

    waitForStart();
    spin_le_ducky_motor(-9.3);
    drive(3, 3, 1, 1);
    turn_right();
    drive(3, 3, 1, 1);
    turn_left();
  }

  /**
   * Describe this function...
   */
  private void turn_right() {
    drive(-1.75, 1.75, 0.5, 0.5);
  }

  /**
   * Describe this function...
   */
  private void spin_le_ducky_motor(double ducke_speenm_go_brrrrrr) {
    sleep(1000);
    DuckySpinMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    DuckySpinMotor.setTargetPosition((int) (1440 * ducke_speenm_go_brrrrrr));
    DuckySpinMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    DuckySpinMotor.setPower(1);
    waitForStart();
    while (opModeIsActive() && DuckySpinMotor.isBusy()) {
      telemetry.addData("ducky-spin-motor", DuckySpinMotor.getTargetPosition());
      telemetry.update();
    }
  }

  /**
   * Describe this function...
   */
  private void turn_left() {
    drive(1.75, -1.75, 0.5, 0.5);
  }

  /**
   * Describe this function...
   */
  private void drive(double right_rotations, double left_rotations, double right_speed, double left_speed) {
    sleep(100);
    spin_le_ducky_motor(null);
    BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    BackLeft.setTargetPosition((int) (1440 * left_rotations));
    BackRight.setTargetPosition((int) (1440 * right_rotations));
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
