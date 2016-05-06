package gefp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "plan")
public class Plan implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	private String name;
	@OneToOne
	private Department department;
		
	@ManyToMany
	List<Checkpoint> checkpoint;
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public List<Checkpoint> getCheckpoint() {
		return checkpoint;
	}
	public void setCheckpoint(List<Checkpoint> checkpoint) {
		this.checkpoint = checkpoint;
	}

}
