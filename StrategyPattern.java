//Strategy Pattern
// class Vehicle
// {
//     void drive()
//     {
//         System.out.println("Normal Drive Capability");
//     }
// }

// class PassengerVehicle extends Vehicle
// {

// }

// class SportsVehicle extends Vehicle
// {
//     void drive()
//     {
//         System.out.println("Sports Drive Capability");
//     }
// }

// class offRoadVehicle extends Vehicle
// {
//     void drive()
//     {
//         System.out.println("Sports Drive Capability");
//     }
// }

// Same drive capability is used for offRoad and sports vehicle.
// Code is duplicate and will inceares with increase of other functions.
// To resolve this we implement a strategy interface.

interface DriveStrategy {
    void drive();
}
class NormalDrive implements DriveStrategy
{
    @Override
    public void drive() {
        System.out.println("Normal Drive Capability");
    }
    
}
class SportsDrive  implements DriveStrategy
{

    @Override
    public void drive() {
        System.out.println("Sports Drive Capability");
    }
    
}

// Now our base class has a drive strategy.
// This helps in reducing redundant code
class Vehicle
{
    DriveStrategy driveStrategy;

    public Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }
    void drive()
    {
        driveStrategy.drive();
    }
}    

class PassengerVehicle extends Vehicle
{
    PassengerVehicle()
    {
        super(new NormalDrive());
    }
}

class SportsVehicle extends Vehicle
{

    public SportsVehicle() {
        super(new SportsDrive());
    }
       
}

class offRoadVehicle extends Vehicle
{

    public offRoadVehicle() {
        super(new SportsDrive());
    }
}

public class StrategyPattern
{
    public static void main(String[] args) {
        
        Vehicle i10=new PassengerVehicle();
        Vehicle ferrari=new SportsVehicle();
        Vehicle monsterTruck=new offRoadVehicle();
        i10.drive();
        ferrari.drive();
        monsterTruck.drive();
    }
}