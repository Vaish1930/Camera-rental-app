package utils;

import java.util.Arrays;

public class Camera {
    int cameraId;
    String brand;
    String model;
    double price;
    boolean status;

    public Camera() {
    }

    public Camera(String brand, String model, double price, boolean status) {
        this.cameraId = (int) Math.random() * 100;
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

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.brand + " " + this.model;
    }

    public Camera[] getAvailablCameras(Camera[] cameras) {
        return Arrays.stream(cameras).filter(cameraItem -> cameraItem.status == true).toArray(Camera[]::new);

    }
}
