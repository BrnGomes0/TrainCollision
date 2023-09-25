package allClass;

import java.net.FileNameMap;
import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception {

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
        double finalPositionA, finalPositionB, time, hourCollision;
        final double hour = 17;


        // Validation Train velocity
        while (true) {
            while (velocityTrain) {
                // Validation of Velocity Train A
                try{
                    System.out.println("Insert Velocity train A: ");
                    valueVelocityA = scan.nextDouble();
                    if (valueVelocityA < 0 || valueVelocityA > 300) {
                        throw new Exception("Invalid Input!");
                    }
                }catch (Exception e){
                    System.out.println("Invalid Input! The max velocity is 300Km/h!");
                    continue;
                }
                trainOne.setvalueVelocityTrain(valueVelocityA);

                // Validation of Velocity Train B
                try {
                    System.out.println("Insert Velocity train B: "); // Improve the code in While back in the wrong input user
                    valueVelocityB = scan.nextDouble();
                    if (valueVelocityB > 0 || valueVelocityB < -300) {
                        throw new Exception("Invalid Input!");
                    }
                }catch (Exception e){
                    System.out.println("Invalid Input! The minimum velocity is 0 and the max is -300Km/h!");
                    continue;
                }
                trainSecond.setvalueVelocityTrain(valueVelocityB);
                velocityTrain = false;
            }
            // Validation Train position
            while (positionTrain) {
                try {
                    System.out.println("Insert the position train A: ");
                    valuePositionA = scan.nextDouble();
                    if (valuePositionA < 0 || valuePositionA > 10_000) {
                        throw new Exception("Invalid Input");
                    }
                }catch (Exception e){
                    System.out.println("Invalid Input!The max position is Km10.000 and the minimum is 0!");
                    continue;
                }
                trainOne.setValuePositionTrain(valuePositionA);

                try{
                    System.out.println("Insert the position train B: ");
                    valuePositionB = scan.nextDouble();
                    if (valuePositionB < 0 || valuePositionB > 10_000) {
                        throw new Exception("Invalid Input!");
                    }
                }catch (Exception e){
                    System.out.println("Invalid Input!Invalid Input!The max position is Km10.000 and the minimum is 0!");
                }
                trainSecond.setValuePositionTrain(valuePositionB);
                positionTrain = false;
            }
            // Logic Train Collision

            // Calculate the time of collision
            time = (trainOne.getValuePositionTrain() - trainSecond.getValuePositionTrain()) / (trainSecond.getValueVelocityTrain() - trainOne.getValueVelocityTrain());
            double timeSeconds = time * 60 * 60;

            // The KM Train A - Final position
            finalPositionA = trainOne.getValuePositionTrain() + trainOne.getValueVelocityTrain() * time;
            // The KM Train B - Final position
            finalPositionB = trainSecond.getValuePositionTrain() + trainSecond.getValueVelocityTrain() * time;


            System.out.printf("The collision of trains will happen in KM %.1f e will occur after %.0f seconds.\n", finalPositionA, timeSeconds);

            System.out.println("Try Again? [y/n]");
            scan.nextLine();
            String answerUser = scan.nextLine();
            if(answerUser.equalsIgnoreCase("y")){
                velocityTrain = true;
                positionTrain = true;
            } else if (answerUser.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}