package com.minh.flightservice.comand.comand;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class DeleteFlightComand {
	@TargetAggregateIdentifier
 	private String flightId;
	
    public String getFlightId() {
        return flightId;
    }
    
    public DeleteFlightComand(String flightId) {
		super();
		this.flightId = flightId;
	
	}

	public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

   
}
