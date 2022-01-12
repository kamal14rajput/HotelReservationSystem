package com.bridgelabz;

import java.util.ArrayList;

public class HotelReservation implements IHotelReservation{
	ArrayList<HotelDetails> hotelList = new ArrayList<>();
	public void addHotelDetails() {
		
		hotelList.add(new HotelDetails("Lakewood", 110));
        hotelList.add(new HotelDetails("Bridgewood", 150));
        hotelList.add(new HotelDetails("Ridgewood", 220));
	}
	
	
}
