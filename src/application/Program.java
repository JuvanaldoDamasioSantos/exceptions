package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args)  {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	try {
		System.out.println("Room number: ");
		int number = sc.nextInt();
		System.out.println("Check-in date (dd/mm/yyyy)");
		Date checkIn = sdf.parse(sc.next());
			
		System.out.println("Check-out date (dd/mm/yyyy)");
		Date checkOut = sdf.parse(sc.next());
		
	
		Reservation reservation = new Reservation(number, checkIn, checkOut);
		System.out.println("Reservation: " + reservation);
		
		System.out.println();
		System.out.println("Enter date to update the reservation: ");
		System.out.println("Check-in date (dd/mm/yyyy)");
		checkIn = sdf.parse(sc.next());
			
		System.out.println("Check-out date (dd/mm/yyyy)");
		checkOut = sdf.parse(sc.next());
		
		
			
		
			
		
		reservation.updateDate(checkIn, checkOut);		
		System.out.println("Reservation: " + reservation);
		
	}
	catch(ParseException e) {
		System.out.println("Invalid date format");
	}
	catch (DomainExceptions e) {
		System.out.println("Error in reservation: " + e.getMessage());
		
	}
	
	catch (RuntimeException e) {
		System.out.println("Unexpected error");
		
	}
	

		
		
		sc.close();
	}

}
