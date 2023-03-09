package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	System.out.println("Room number: ");
	int number = sc.nextInt();
	System.out.println("Check-in date (dd/mm/yyyy)");
	Date checkIn = sdf.parse(sc.next());
		
	System.out.println("Check-out date (dd/mm/yyyy)");
	Date checkOut = sdf.parse(sc.next());
		
	if(!checkOut.after(checkIn)) {
		System.out.println("Error in reservation: Check-out date must be after check-in date");
	}
	else {
		Reservation reservation = new Reservation(number, checkIn, checkOut);
		System.out.println("Reservation: " + reservation);
		
		System.out.println();
		System.out.println("Enter date to update the reservation: ");
		System.out.println("Check-in date (dd/mm/yyyy)");
		checkIn = sdf.parse(sc.next());
			
		System.out.println("Check-out date (dd/mm/yyyy)");
		checkOut = sdf.parse(sc.next());
		
		
			
		
			
		
		String error = reservation.updateDate(checkIn, checkOut);
		if (error != null) {
			System.out.println("Error in reservstion: " + error);
		}
		else {
		
			System.out.println("Reservation: " + reservation);
		}
	}

		
		
		sc.close();
	}

}
