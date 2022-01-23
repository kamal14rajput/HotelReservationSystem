package com.bridgelabz;

import java.util.ArrayList;

public interface IHotelReservation {
	public void addHotel(String hotelName,int rating, double weekDayRate,double weekendRate);
	public int getHotelListSize();
	public void printHotelList();
	public ArrayList<HotelDetails> getHotelList();
}
