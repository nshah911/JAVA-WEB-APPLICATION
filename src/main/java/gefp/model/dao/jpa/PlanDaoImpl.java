package gefp.model.dao.jpa;

import gefp.model.Checkpoint;
import gefp.model.Plan;
import gefp.model.User;
import gefp.model.dao.PlanDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class PlanDaoImpl implements PlanDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Checkpoint> getPlanCheckpoint(Integer id)
    {
        Plan p = entityManager.find( Plan.class, id );
        return p.getCheckpoint();
    }

    @Override
    public Plan getPlan( Integer id )
    {
        return entityManager.find( Plan.class, id );
    }

    
}