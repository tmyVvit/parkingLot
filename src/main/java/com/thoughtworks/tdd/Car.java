package com.thoughtworks.tdd;

public class Car {
    private int id;

    public Car(int _id) {
        id = _id;
    }

    public int getCarid(){
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Car){
            Car car = (Car) obj;
            return car.id == id;
        }
        return super.equals(obj);
    }
}
