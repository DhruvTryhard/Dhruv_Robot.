package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ColorSensor;

@Autonomous(name = "Color Test", group = "nobody asked")
public class AutoHPBoxA extends LinearOpMode
{
    DcMotor TopLeft;

    DcMotor TopRight;
    DcMotor BottomLeft;
    DcMotor BottomRight;
    DcMotor Intake;
    DcMotor Shooter;
    Servo ShooterServo;
    Servo LinearSlidesServo;
    Servo ClawServo;
    ColorSensor color;

    @Override
    public void runOpMode() throws InterruptedException{
        TopLeft = hardwareMap.dcMotor.get("topLeft");
        TopRight = hardwareMap.dcMotor.get("topRight");
        BottomLeft = hardwareMap.dcMotor.get("bottomLeft");
        BottomRight = hardwareMap.dcMotor.get("bottomRight");
        Intake = hardwareMap.dcMotor.get("intakeMotor");
        ShooterServo = hardwareMap.servo.get("test");
        ClawServo = hardwareMap.servo.get("test2");
        Shooter = hardwareMap.dcMotor.get("shooterMotor");
        LinearSlidesServo = hardwareMap.servo.get("linearSlideServo");
        TopLeft.setDirection(DcMotor.Direction.REVERSE);
        color = hardwareMap.get(ColorSensor.class,"color");
        TopRight.setDirection(DcMotor.Direction.FORWARD);
        BottomLeft.setDirection(DcMotor.Direction.REVERSE);
        BottomRight.setDirection(DcMotor.Direction.FORWARD);
        LinearSlidesServo.setPosition(0.9);
        ClawServo.setPosition(0);
        ShooterServo.setPosition(.2);

        waitForStart();

        //Moving to shooter position
       while(true){
           telemetry.addData("Red", color.red());
           telemetry.addData("Blue", color.blue());
           telemetry.addData("Green", color.green());
           telemetry.update();
       }
    }
}