package brian_background.model;

import java.io.Serializable;

public class HomeMessage implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
