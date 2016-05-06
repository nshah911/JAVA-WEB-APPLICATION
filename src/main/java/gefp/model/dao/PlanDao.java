package gefp.model.dao;

import gefp.model.Checkpoint;
import gefp.model.Plan;
import gefp.model.Runway;

import java.util.List;

public interface PlanDao {
	
	List<Checkpoint> getPlanCheckpoint(Integer id);
	
	Plan getPlan( Integer id );


}
