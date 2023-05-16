//  Version 1.0.0

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

            boolean showMenu = true;
            while (showMenu) {

                System.out.println("1.MY CAMERA \n2.RENT A CAMERA \n3.VIEW ALL CAMERAS \n4.MY WALLET \n5.EXIT");
                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        boolean choice1 = true;
                        while (choice1) {

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
                                case 2:
                                    Camera.displayCameras(cameras);
                                    System.out.print("ENTER THE CAMERA ID TO REMOVE - ");
                                    int cameraId = sc.nextInt();
                                    cameras = Camera.deleteCamera(cameras, cameraId);
                                    System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST.");
                                    break;

                                case 3:
                                    Camera.displayCameras(cameras);
                                    break;

                                case 4:
                                    choice1 = false;
                                    break;

                                default:
                                    break;
                            }
                        }

                        break;

                    case 2:
                        System.out.println("FOLLOWING IS THE LIST OF AVAILABLE CAMERA(S) - ");
                        Camera.displayCameras(Camera.getAvailablCameras(cameras));
                        System.out.print("ENTER THE CAMERA ID YOU WANT TO RENT - ");
                        int cameraId = sc.nextInt();

                        Camera rentedCamera = Camera.getCameraDetail(cameras, cameraId);
                        double newBalance = wallet.getBalance() - rentedCamera.getPrice();
                        if (newBalance >= 0) {

                            cameras = Camera.updateStatus(cameras, cameraId);
                            System.out
                                    .println("YOUR TRANSACTION - " + rentedCamera.getBrand() + " "
                                            + rentedCamera.getModel()
                                            + " with rent INR." + rentedCamera.getPrice()
                                            + " HAS SUCCESSFULLY COMPLETED.");

                        } else {
                            System.out.println(
                                    "ERROR : TRANSACTION FAILED DUE TO INSUFFICIENT WALLET BALANCE. PLEASE DEPOSIT THE AMOUNT TO YOUR WALLET");
                        }
                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:
                        showMenu = false;
                        break;

                    default:
                        break;
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
