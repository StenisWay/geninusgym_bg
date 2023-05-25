package android.bean;

import java.io.Serializable;

public class SportCat implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer sc_id;
	private String sc_name;
	public Integer getSc_id() {
		return sc_id;
	}
	public void setSc_id(Integer sc_id) {
		this.sc_id = sc_id;
	}
	public String getSc_name() {
		return sc_name;
	}
	public void setSc_name(String sc_name) {
		this.sc_name = sc_name;
	}
	
}
