package frc.team6434.robot


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX

class Lift {
      val liftA = WPI_TalonSRX(Ports.LIFT_LEFT_A_CANID)
      val liftB = WPI_TalonSRX(Ports.LIFT_LEFT_B_CANID)
      val liftC = WPI_TalonSRX(Ports.LIFT_RIGHT_A_CANID)
      val liftD = WPI_TalonSRX(Ports.LIFT_RIGHT_B_CANID)

      fun raise() {
        setLiftPower(Speeds.RAISE_POWER)
      }

      fun lower() {
        setLiftPower(Speeds.LOWER_POWER)
      }

      fun stop() {
        setLiftPower(0.0)
      }

      fun setLiftPower(liftPower: Double) {
        SmartDashboard.putNumber("liftPower", liftPower)
        liftA.set(liftPower)
        liftB.set(liftPower)
        liftC.set(-liftPower)
        liftD.set(-liftPower)

      }

      
}
