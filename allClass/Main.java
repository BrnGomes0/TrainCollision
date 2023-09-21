package allClass;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        boolean loopInfinite = true;

        Scanner scan = new Scanner(System.in);

        // Instance of Trains
        Train trainOne = new Train();
        Train trainSecond = new Train();

        // Get Value User Train A
        while (true){
            System.out.println("Velocity A: ");
            double valueUserVelocityA = scan.nextDouble();
            if (valueUserVelocityA > 300){
                System.out.println("The velocity max is 300Km/h! Insert Again:");
                continue;
            }
            trainOne.setvalueVelocityTrain(valueUserVelocityA);
            System.out.println("Position A: ");
            double valueUserPositionA = scan.nextDouble();
            if (valueUserPositionA < 0 || valueUserPositionA > 10000){
                System.out.println("Position Max (KM 10.000) and Min (KM 0)! Insert Again: ");
                continue;
            }
            trainOne.setValuePositionTrain(valueUserPositionA);
            System.out.println("Velocity B: ");
            double valueUserVelocityB = scan.nextDouble();
            if (valueUserVelocityB > 300){
                System.out.println("The velocity max is 300Km/h! Insert Again:");
                continue;
            }
            trainSecond.setvalueVelocityTrain(valueUserVelocityB);
            System.out.println("Position B: ");
            double valueUserPositionB = scan.nextDouble();
            if (valueUserPositionB > 300){
                System.out.println("Position Max (KM 10.000) and Min (KM 0)! Insert Again: ");
                continue;
            }
            trainSecond.setvalueVelocityTrain(valueUserPositionB);
        }





        // Access the object instanced in other class

    }
}