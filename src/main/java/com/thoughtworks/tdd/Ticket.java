package com.thoughtworks.tdd;

import java.util.UUID;

public class Ticket {
    private UUID uuid;

    public Ticket(){
        uuid = UUID.randomUUID();
    }
    public Ticket(String uuidString){
        try{
            uuid = UUID.fromString(uuidString);
        }catch(IllegalArgumentException ilegalArgumentException){}
    }

    public String getUUID(){
        if(uuid != null)
            return uuid.toString();
        return "not valid uuid";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Ticket){
            Ticket ticket = (Ticket)obj;
            return  getUUID().equals(ticket.getUUID());
        }
        return super.equals(obj);
    }
}
