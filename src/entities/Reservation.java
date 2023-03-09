package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkOut;
    private Date checkIn;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
	public Reservation(Integer roomNumber, Date checkOut, Date checkIn) {
		
		this.roomNumber = roomNumber;
		this.checkOut = checkOut;
		this.checkIn = checkIn;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckOut() {
		return checkOut;
	}



	public Date getCheckIn() {
		return checkIn;
	}


	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	
	public String updateDate(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if(checkIn.before(now) || checkIn.before(now)) {
			return "reservation: dates for updates must be future dates";
		}
		if(!checkOut.after(checkIn))  {
			return "reservation: Check-out date must be after check-in date";
			
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
    @Override
    public String toString() {
    	return "Room "
    			+ roomNumber
    			+ ", Check-in "
    			+ sdf.format(checkIn)
    			+ ", Check-out "
    			+ sdf.format(checkOut)
    			+ ", "
    			+ duration()
    			+ " nights";
    }
    
}
