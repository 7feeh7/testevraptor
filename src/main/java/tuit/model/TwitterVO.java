package tuit.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



public class TwitterVO implements Serializable{
	
	private User user;
	private Twit twit;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Twit getTwit() {
		return twit;
	}
	public void setTwit(Twit twit) {
		this.twit = twit;
	}
	
	
	
	
	
	
//	@Transient
//	private Long id_user;
//	@Transient
//	private Long id_twit;
//	@Transient
//	private String name;
//	@Transient
//	private String Twit;
//	@Transient
//	private Calendar data;
//	@Transient
//	private String dataformat;
//	@Transient
//	private Long id_seguindo;
//	@Transient
//	private String  password;
//	@Transient
//    private String fone;
//	@Transient
//    private String data_nasc;
	
	
}
