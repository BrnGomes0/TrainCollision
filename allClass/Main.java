package allClass;

import java.net.FileNameMap;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        // Instance of Trains

        Train trainOne = new Train();
        Train trainSecond = new Train();

        // Variables about train and the Loop
        boolean positionTrain = true;
        boolean velocityTrain = true;

        // Variables about train
        double valuePositionA = 0;
        double valueVelocityA = 0;
        double valuePositionB = 0;
        double valueVelocityB = 0;
        double finalPositionA, finalPositionB, time;
        final double hour = 17;


        // Validation Train velocity
        while (true) {
            while (velocityTrain) {
                System.out.println("Insert Velocity train A: ");
                valueVelocityA = scan.nextDouble();
                if (valueVelocityA < 0 || valueVelocityA > 300) {
                    System.out.println("The minimum speed is 0 and the maximum is 300Km/h!");
                    continue;
                }
                trainOne.setvalueVelocityTrain(valueVelocityA);

                System.out.println("Insert Velocity train B: "); // Improve the code in While back in the wrong input user
                valueVelocityB = scan.nextDouble();
                if (valueVelocityB > 0 || valueVelocityB < -300) {
                    System.out.println("The velocity train B, need be negative!");
                    continue;
                }
                trainSecond.setvalueVelocityTrain(valueVelocityB);
                velocityTrain = false;

            }
            // Validation Train position
            while (positionTrain) {
                System.out.println("Insert the position train A: ");
                valuePositionA = scan.nextDouble();
                if (valuePositionA < 0 || valuePositionA > 10_000) {
                    System.out.println("The minimum position is Km0 and the maximum is Km10.000!");
                    continue;
                }
                trainOne.setValuePositionTrain(valuePositionA);

                System.out.println("Insert the position train B: ");
                valuePositionB = scan.nextDouble();
                if (valuePositionB < 0 || valuePositionB > 10_000) {
                    System.out.println("The minimum position is Km0 and the maximum is Km10.000!");
                    continue;
                }
                trainSecond.setValuePositionTrain(valuePositionB);
                positionTrain = false;
            }
            // Logic Train Collision -> S = So + v*t (Space) and Time (t = Soa - Sob / Va - Vb)
            // The time
            time = (trainOne.getValuePositionTrain() - trainSecond.getValuePositionTrain()) / (trainSecond.getValueVelocityTrain() - trainOne.getValueVelocityTrain());
            System.out.printf("The time is %.1f seconds\n", time * 60 * 60);

            // The KM Train A
            finalPositionA = trainOne.getValuePositionTrain() + trainOne.getValueVelocityTrain() * time;
            System.out.printf("The position train KM%.1f\n", finalPositionA);

            // The KM Train B
            finalPositionB = trainSecond.getValuePositionTrain() + trainSecond.getValueVelocityTrain() * time;
            System.out.printf("The position train KM%.1f\n", finalPositionB);

            // Logic for show the time correct
            double hourCorret;
            


            break;
        }

    }
}