package org.usfirst.frc.team2706.robot.commands.teleop;

import org.usfirst.frc.team2706.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Have the robot drive arcade style using the Xbox Joystick until interrupted.
 */
public class ArcadeDriveWithJoystick extends Command {

    protected Joystick joystick;

    /**
     * Arcade drives with the driver joystick
     */
    public ArcadeDriveWithJoystick() {
        this(Robot.oi.getDriverJoystick());
    }

    /**
     * Arcade drives with a given joystick
     * 
     * @param joystick The joystick to drive with
     */
    public ArcadeDriveWithJoystick(Joystick joystick) {
        requires(Robot.driveTrain);

        this.joystick = joystick;
    }

    /**
     * Sets the joystick to be used to arcade drive with
     * 
     * @param joystick The joystick to drive with
     */
    public void setJoystick(Joystick joystick) {
        this.joystick = joystick;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.driveTrain.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.driveTrain.swerveDrive(joystick);

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; // Runs until interrupted
    }

    // Called once after isFinished returns true
    protected void end() {
        // Stop the servoing until swerve drive is used again
        Robot.driveTrain.stopSwerve();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
