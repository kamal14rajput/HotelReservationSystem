package com.bridgelabz;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class HotelReservation implements IHotelReservation {
	ArrayList<HotelDetails> hotelList = new ArrayList<HotelDetails>();
	HotelDetails hotel;

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

	public ArrayList<HotelDetails> getHotelList() {
		return hotelList;
	}

	public String getCheapestHotel(LocalDate startDate, LocalDate endDate) {

		int numberOfDays = (int) ChronoUnit.DAYS.between(startDate, endDate);
		int weekends = 0;

		while (startDate.compareTo(endDate) != 0) {
			switch (DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK))) {
			case SATURDAY:
				++weekends;
				break;
			case SUNDAY:
				++weekends;
				break;
			}
			startDate = startDate.plusDays(1);
		}

		final int weekdaysNumber = numberOfDays - weekends;
		final int weekendsNumber = weekends;
		
		int cheapestRate = (int) (hotelList.get(0).getWeekDayRate() + hotelList.get(0).getWeekendRate());
		String cheapestHotel=hotelList.get(0).getHotelName();
		int maxRating = hotelList.get(0).getRating();
		for (HotelDetails hotel : hotelList) {
		            int rateForHotel = (int) ((weekdaysNumber * hotel.getWeekDayRate())
		                    + (weekendsNumber * hotel.getWeekendRate()));
		            int ratingForHotel=hotel.getRating();
		            if (rateForHotel < cheapestRate){
		                cheapestRate = rateForHotel;
		                cheapestHotel = hotel.getHotelName();
		                maxRating=ratingForHotel;
		            } else if (rateForHotel == cheapestRate) {
		                if(hotel.getRating()>maxRating) {
		                    cheapestHotel = hotel.getHotelName();
		                    maxRating=ratingForHotel;
		                }
		            }
		 }

		System.out.println("Cheapest Hotel : \n" + cheapestHotel + ", Total Rates: " + cheapestRate);
		return cheapestHotel;

	}

}
