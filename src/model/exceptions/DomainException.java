package model.exceptions;

public class DomainException extends RuntimeException { //Essa classe particular 'extends' a classe RuntimeException
	private static final long serialVersionUID = 1L;

	public DomainException(String msg) { /*Aqui temos um método que tem como argumento "msg" e que conclama "msg"
										 da classe superior */
		super(msg);
	}
}