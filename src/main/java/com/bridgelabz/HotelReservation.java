package com.bridgelabz;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class HotelReservation implements IHotelReservation{
	ArrayList<HotelDetails> hotelList = new ArrayList<HotelDetails>();
	HotelDetails hotel ;

	public void addHotel(String hotelName, int rating, double weekdayRate, double weekndRate) {
		hotel = new HotelDetails();
		hotel.setHotelName(hotelName);
		hotel.setRating(rating);
		hotel.setWeekDayRate(weekdayRate);
		hotel.setWeekendRate(weekndRate);
		hotelList.add(hotel);
	}
	
	public int getHotelListSize() {
		return hotelList.size();
	}
	
	public void printHotelList() {
		System.out.println(hotelList);
	}
	
	public ArrayList<HotelDetails> getHotelList(){
		return hotelList;
	}

	
}
