package frc.team6434.robot

import edu.wpi.first.wpilibj.GenericHID.Hand
import edu.wpi.first.wpilibj.IterativeRobot
import edu.wpi.first.wpilibj.XboxController
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX

class Robot : IterativeRobot() {
    val XBOX_CONTROLLER_PORT = 0

    // CAN Bus Node IDs
    val LEFT_A_CANID = 1
    val LEFT_B_CANID = 2
    val RIGHT_A_CANID = 3
    val RIGHT_B_CANID = 4

    var controller: XboxController? = null

    var leftA: WPI_TalonSRX? = null
    var leftB: WPI_TalonSRX? = null
    var rightA: WPI_TalonSRX? = null
    var rightB: WPI_TalonSRX? = null

    override fun robotInit() {
        println("Hello Illawarra 9761")

        controller = XboxController(XBOX_CONTROLLER_PORT)

        leftA = WPI_TalonSRX(LEFT_A_CANID)
        leftB = WPI_TalonSRX(LEFT_B_CANID)
        rightA = WPI_TalonSRX(RIGHT_A_CANID)
        rightB = WPI_TalonSRX(RIGHT_B_CANID)

        leftB!!.follow(leftA)
        rightB!!.follow(rightA)
    }

    fun clamp(num: Double): Double {
      if (num < -1.0)
        return -1.0
      if (num > 1.0)
        return 1.0
      return num
    }

    override fun teleopPeriodic() {
      val x = controller!!.getY(Hand.kRight)
      val y = controller!!.getY(Hand.kLeft)

      var leftPower = clamp(y + x)
      var rightPower = clamp(y - x)
      leftA!!.set(leftPower)
      rightA!!.set(rightPower)
    }
}