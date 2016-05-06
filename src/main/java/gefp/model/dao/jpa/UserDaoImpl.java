package gefp.model.dao.jpa;

import gefp.model.Checkpoint;
import gefp.model.Department;
import gefp.model.Plan;
import gefp.model.Runway;
import gefp.model.Stage;
import gefp.model.User;
import gefp.model.dao.UserDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUser( Integer id )
    {
        return entityManager.find( User.class, id );
    }

    @Override
    public Stage getStage( Integer id )
    {
        return entityManager.find( Stage.class, id );
    }    

    @Override
    public Runway getRunway( Integer id )
    {
        return entityManager.find( Runway.class, id );
    }
    
    @Override
    public List<User> getUsers()
    {
        return entityManager.createQuery( "from User order by id", User.class )
            .getResultList();
    }
    
    
    
    @Override
    public List<User> getUsersHavingName(String name) {
    	
    	return entityManager.createQuery( "from User where name = '"+name+"' order by id", User.class )
                .getResultList();
    }

	@Override
	public User getUsers(String username) {
		
		return (User) entityManager.createQuery( "from User", User.class )
                .getResultList();
		// TODO Auto-generated method stub
	}

	@Override
	public User checkUser(String usname, String pswd) {
		try {
			User u = entityManager
					.createQuery(
							"from User where name = :u and password = :p",
							User.class).setParameter("u", usname)
					.setParameter("p", pswd).getSingleResult();
			if (u.getName() != null) {
				return u;
			} else {
				return null;
			}
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	@Override
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub

		return entityManager.createQuery( "from Department", Department.class )
                .getResultList();
	}


	@Override
	public List<Plan> getPlans(Integer deptId) {
		return entityManager.createQuery( "from Plan where department_id = "+deptId, Plan.class )
                .getResultList();
	}

	@Override
	public List<Runway> getRunways(Integer planId) {
		// TODO Auto-generated method stub
		return entityManager.createQuery( "from Runway where plan_id = "+planId, Runway.class )
                .getResultList();
	}

	@Override
	public List<Stage> getStages(Integer planId) {
		// TODO Auto-generated method stub
		return entityManager.createQuery( "from Stage where plan_id = "+planId, Stage.class )
                .getResultList();
	}
	
	@Override
	public List<Checkpoint> getCheckpoints() {
		// TODO Auto-generated method stub

		return entityManager.createQuery( "from Checkpoint", Checkpoint.class )
                .getResultList();
	}

	@Override
	public boolean logoutuser(User u) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@Transactional
	public Runway saveRunway(Runway runway) {
		// TODO Auto-generated method stub
		return entityManager.merge(runway);
	}

	@Override
	@Transactional
	public Stage saveStage(Stage stage) {
		// TODO Auto-generated method stub
		return entityManager.merge(stage);
	}

	@Override
	@Transactional
	public Checkpoint saveCheckpoint(Checkpoint checkpoint) {
		// TODO Auto-generated method stub
		return entityManager.merge(checkpoint);
	}

	@Override
	public Checkpoint getCheckpoint(Integer chkid) {
		// TODO Auto-generated method stub
		return entityManager.find( Checkpoint.class, chkid );
	}

	@Override
	public Plan getPlan(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find( Plan.class, id );
	}

	@Override
	@Transactional
	public Plan savePlan(Plan plan) {
		// TODO Auto-generated method stub
		return entityManager.merge(plan);
	}

	@Override
	public Department getDepaerment(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find( Department.class, id );
	}

	@Override
	public Department getDepartment(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.merge(getDepartment(id));
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return entityManager.merge(user);
	}

}