package frc.team6434.robot

import edu.wpi.first.wpilibj.GenericHID.Hand
import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.XboxController

class Robot : IterativeRobot() {
    val XBOX_CONTROLLER_PORT = 0

    val controller = XboxController(XBOX_CONTROLLER_PORT)

    override fun robotInit() {
        println("Hello World from Kotlin!")
    }

    override fun teleopPeriodic() {
      val x = controller.getY(Hand.kRight)
      val y = controller.getY(Hand.kLeft)
    }
}