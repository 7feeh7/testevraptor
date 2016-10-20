package tuit.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;



public class TwitterVO implements Serializable{
	@Transient
	private Long id_user;
	@Transient
	private Long id_twit;
	@Transient
	private String name;
	@Transient
	private String Twit;
	@Transient
	private Calendar data;
	@Transient
	private String dataformat;
	@Transient
	private Long id_seguindo;
	
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	public Long getId_twit() {
		return id_twit;
	}
	public void setId_twit(Long id_twit) {
		this.id_twit = id_twit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTwit() {
		return Twit;
	}
	public void setTwit(String twit) {
		Twit = twit;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getDataformat() {
		return dataformat;
	}
	public void setDataformat(String dataformat) {
		this.dataformat = dataformat;
	}
	
	@Override
	public String toString() {
		return "TwitterVO [id_user=" + id_user + ", id_twit=" + id_twit + ", name=" + name + ", Twit=" + Twit
				+ ", data=" + data + ", dataformat=" + dataformat + "]";
	}
	
		
	
	
	
	

}
