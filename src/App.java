import java.util.ArrayList;
import java.util.Scanner;

import utils.Camera;
import utils.Wallet;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            ArrayList<Camera> cameras = new ArrayList<Camera>();
            cameras.add(new Camera("Something", "some", 200.0, false));
            cameras.add(new Camera("Some", "Another", 100.0, true));
            cameras.add(new Camera("Nikon", "DSLR-D7500", 500.0, true));
            cameras.add(new Camera("Sony", "DSLR12", 600.0, true));
            cameras.add(new Camera("Something", "some", 200.0, true));

            Wallet wallet = new Wallet(1, 2430473.00);

            String userName, password;

            System.out.println("\n+----------------------------------------+");
            System.out.println("|   Welcome to Camera Rental App         |");
            System.out.println("+----------------------------------------+\n");
            System.out.println("PLEASE LOGIN TO CONTINUE");
            System.out.print("USERNAME - ");
            userName = sc.nextLine();
            System.out.print("PASSWORD - ");
            password = sc.nextLine();
            System.out.println("1.MY CAMERA \n2.RENT A CAMERA \n3.VIEW ALL CAMERAS \n4.MY WALLET \n5.EXIT");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1.ADD \n2.REMOVE \n3.VIEW MY CAMERAS \n4.GO TO PREVIOUS MENU ");
                    int myCameraChoice = sc.nextInt();
                    sc.nextLine();
                    switch (myCameraChoice) {
                        case 1:
                            Camera newCamera = new Camera();
                            System.out.print("ENTER THE CAMERA BRAND - ");
                            newCamera.setBrand(sc.nextLine());

                            System.out.print("ENTER THE MODEL - ");
                            newCamera.setModel(sc.nextLine());
                            System.out.print("ENTER THE PER DAY PRICE (INR) - ");
                            newCamera.setPrice(sc.nextDouble());
                            cameras.add(newCamera);
                            System.out.print("YOUR CAMERA HAS BEEN SUCCESSFULY ADDED TO THE LIST");

                            break;

                        default:
                            break;
                    }

                    break;

                default:
                    break;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
