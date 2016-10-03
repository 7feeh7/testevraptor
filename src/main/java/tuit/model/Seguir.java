package tuit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Seguir")
public class Seguir {
	@Id
	@SequenceGenerator(sequenceName = "seq_seguir", name = "seq_seguir", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_seguir")
	private Long id_segue;
	@Column
	private Long id_user;
	
	public Long getId_segue() {
		return id_segue;
	}
	public void setId_segue(Long id_segue) {
		this.id_segue = id_segue;
	}
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	
	@Override
	public String toString() {
		return "Seguir [id_segue=" + id_segue + ", id_user=" + id_user + "]";
	}
	
	
}
