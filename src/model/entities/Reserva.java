package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva { //Nome da classe ----------.----------.----------

	private Integer roomNumber; //Atributos:
	private Date checkIn;
	private Date checkOut;
	
private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //Vari�vel de m�scara da data
	
	public Reserva(Integer roomNumber, Date checkIn, Date checkOut) { //M�todo reserva
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	//Getters e Setters com alguns Setters removidos:
	
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

	public long duracao() { //M�todo para calcular a dura��o
		long diferenca = checkOut.getTime() - checkIn.getTime(); //diferenca � a vari�vel, getTime � a fun��o
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS); //TimeUnit � um tipo enumerado
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room "
			+ roomNumber
			+ ", check-in: "
			+ sdf.format(checkIn)
			+ ", check-out: "
			+ sdf.format(checkOut)
			+ ", "
			+ duracao()
			+ " nights";
	}
}