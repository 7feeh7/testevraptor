package tuit.model;

import java.util.Calendar;

/*
 * @author:Felipe Pires;
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "twit")
public class Twit {

	@Id
	@SequenceGenerator(sequenceName = "seq_twit", name = "seq_twit", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_twit")
	private Long id_twit;
	@Column
	private Long id;
	@Column
	private String twit;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	@Transient
	private String dataformat;	
	
	public Long getId_twit() {
		return id_twit;
	}
	public void setId_twit(Long id_twit) {
		this.id_twit = id_twit;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTwit() {
		return twit;
	}
	public void setTwit(String twit) {
		this.twit = twit;
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
		return "Twit [id_twit=" + id_twit + ", id=" + id + ", twit=" + twit + ", data=" + data + ", dataformat="
				+ dataformat + "]";
	}

	


	
	

}
