package com.thoughtworks.tdd;

public class Car {
    private String  id;

    public Car(){ }
    public Car(String  _id) {
        id = _id;
    }

    public String getCarid(){
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
