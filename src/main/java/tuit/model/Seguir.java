package tuit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Seguir")
public class Seguir implements Serializable{
	@Id
	@SequenceGenerator(sequenceName = "seq_seguir", name = "seq_seguir", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_seguir")
	private Long id;
	@Column
	private Long id_user;
	@Column
	private Long id_seguindo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public Long getId_seguindo() {
		return id_seguindo;
	}

	public void setId_seguindo(Long id_seguindo) {
		this.id_seguindo = id_seguindo;
	}

	@Override
	public String toString() {
		return "Seguir [id=" + id + ", id_user=" + id_user + ", id_seguindo=" + id_seguindo + "]";
	}

}
