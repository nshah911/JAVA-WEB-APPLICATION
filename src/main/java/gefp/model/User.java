package gefp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String password;
    
    
    @OneToMany
    Set<Authority> authorities;
    
	@OneToOne
	private Plan plan;

    @ManyToOne
    private Department department;
      
    @OneToMany
    List<Checkpoint> checkpoint;

    public User()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }
    


    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getPassword()
    {
        return password;
    }

    public void setPassword( String password )
    {
        this.password = password;
    }

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public List<Checkpoint> getCheckpoint() {
		return checkpoint;
	}

	public void setCheckpoint(List<Checkpoint> checkpoint) {
		this.checkpoint = checkpoint;
	}

	
}