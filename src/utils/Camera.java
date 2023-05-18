package utils;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Camera {
    int cameraId;
    String brand;
    String model;
    double price;
    boolean status;

    public Camera() {
    }

    public Camera(String brand, String model, double price, boolean status) {
        this.cameraId = (int) (Math.random() * 100);
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.status = status;
    }

    public int getCameraId() {
        return cameraId;
    }

    public void setCameraId(int cameraId) {
        this.cameraId = cameraId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public String getStatus() {
        return status ? "AVAILABLE" : "RENTED";
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.brand + " " + this.model;
    }

    public static ArrayList<Camera> getAvailablCameras(ArrayList<Camera> cameras) {
        return (ArrayList<Camera>) cameras.stream().filter(cameraItem -> cameraItem.status)
                .collect(Collectors.toList());

    }

    public static String getColumn(String text) {
        int spaces = 15 - text.length();
        for (int i = 0; i < spaces; i++) {
            text += " ";
        }
        return text;
    }

    public static String getColumn(double text) {

        String numberText = Double.toString(text);
        int spaces = 20 - numberText.length();
        for (int i = 0; i < spaces; i++) {
            numberText += " ";
        }
        return numberText;
    }

    public static ArrayList<Camera> deleteCamera(ArrayList<Camera> cameras, int id) {
        return (ArrayList<Camera>) cameras.stream().filter(cameraItem -> cameraItem.getCameraId() != id)
                .collect(Collectors.toList());

    }

    public static ArrayList<Camera> updateStatus(ArrayList<Camera> cameras, int id) {
        return (ArrayList<Camera>) cameras.stream().map(cameraItem -> {
            if (cameraItem.getCameraId() == id) {
                cameraItem.setStatus(false);
            }
            return cameraItem;
        })
                .collect(Collectors.toList());

    }

    public static Camera getCameraDetail(ArrayList<Camera> cameras, int id) {
        return (Camera) cameras.stream().filter(cameraItem -> cameraItem.getCameraId() == id)
                .collect(Collectors.toList()).get(0);

    }

    public static void displayCameras(ArrayList<Camera> cameras) {

        System.out.println(
                "==================================================================================================");
        System.out.println(
                "CAMERAID          BRAND          MODEL          PRICE(PER DAY)         STATUS     ");
        System.out.println(
                "==================================================================================================");

        cameras.stream().forEach(cameraItem -> {
            System.out.println(cameraItem.getCameraId() + "\t\t" + Camera.getColumn(cameraItem.getBrand())
                    + Camera.getColumn(cameraItem.getModel()) + Camera.getColumn(cameraItem.getPrice())
                    + cameraItem.getStatus());
        });

    }

}
