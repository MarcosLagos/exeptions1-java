package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	// long no lugar do int, long eh um inteiro mais longo
	public long duration() {
		//metodo usado para ver diferença de dias em milessegundos
		long diff = checkOut.getTime() - checkIn.getTime();
		//metodo pra pegar a diferença em milessegundos e tranformar em dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkUot) {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for update must be future dates";
		}
		if(!checkOut.after(checkIn)) {
			return "Error in resevation: chec-out date must be after check-in date";
			//data de saida tem que ser depois da data de entrada
		}
		this.checkIn = checkIn;
		this.checkOut = checkUot;
		return null;
	}
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", checkIn "
				+ sdf.format(checkIn)
				+", checkOut "
				+sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
				
				
				
				
				
				

	}
	
	

}
