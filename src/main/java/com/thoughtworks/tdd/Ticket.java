package com.thoughtworks.tdd;

import java.util.UUID;

public class Ticket {
    private UUID uuid;

    public Ticket(){
        uuid = UUID.randomUUID();
    }
    public Ticket(String uuidString){
        uuid = UUID.fromString(uuidString);
    }

    public String getUUID(){
        return uuid.toString();
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
