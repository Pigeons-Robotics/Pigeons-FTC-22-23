package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "AutonomousEncodersInProgress (Blocks to Java)")
public class AutonomousEncodersInProgress extends LinearOpMode {

  private DcMotor DuckySpinMotor;
  private DcMotor BackLeft;
  private DcMotor BackRight;

  /**
   * Describe this function...
   */
  private void turn_left(double Degrees, double Speed) {
    drive(Degrees / 72, Degrees / -72, Speed, Speed);
  }

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    DuckySpinMotor = hardwareMap.get(DcMotor.class, "Ducky Spin Motor");
    BackLeft = hardwareMap.get(DcMotor.class, "Back Left");
    BackRight = hardwareMap.get(DcMotor.class, "Back Right");

    waitForStart();
    drive(0.7, 0.7, 1, 1);
    turn_right(35, 0.5);
  }

  /**
   * Describe this function...
   */
  private void turn_right(int Degrees, double Speed) {
    drive(Degrees / -72, Degrees / 72, Speed, Speed);
    // Speed is a combination of left & right speed
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
  private void drive(double right_rotations, double left_rotations, double right_speed, double left_speed) {
    sleep(100);
    // We have the sleep here because
    // the robot couldn't finish the previous
    // command sent. This adds a small time buffer.
    BackLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    BackRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    BackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    sleep(100);
    // 1440 is the amount of ticks in a rotation
    // of the wheel. That's why it's 1440.
    BackLeft.setTargetPosition((int) (1440 * left_rotations));
    BackRight.setTargetPosition((int) (1440 * right_rotations));
    waitForStart();
    BackLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    BackRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    BackLeft.setPower(left_speed);
    BackRight.setPower(right_speed);
    // The giant thing below just basically is a loop
    // that runs until the motor is no longer busy.
    // Telemetry collects the data of distance moved.
    while (opModeIsActive() && BackLeft.isBusy() && BackRight.isBusy()) {
      telemetry.addData("right-rotations", BackRight.getTargetPosition());
      telemetry.addData("left-rotations", BackLeft.getTargetPosition());
      telemetry.update();
    }
  }
}
