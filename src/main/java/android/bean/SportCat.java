package android.bean;

import java.io.Serializable;

public class SportCat implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer sc_id;
	private Integer sb_cat;
	private String sc_name;
	
	public String getSc_name() {
		return sc_name;
	}
	public void setSc_name(String sc_name) {
		this.sc_name = sc_name;
	}
	public Integer getSb_cat() {
		return sb_cat;
	}
	public void setSb_cat(Integer sb_cat) {
		this.sb_cat = sb_cat;
	}
	public Integer getSc_id() {
		return sc_id;
	}
	public void setSc_id(Integer sc_id) {
		this.sc_id = sc_id;
	}
	
}
