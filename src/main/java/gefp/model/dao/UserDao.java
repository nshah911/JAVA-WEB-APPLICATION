package gefp.model.dao;

import java.util.List;

import gefp.model.Checkpoint;
import gefp.model.Department;
import gefp.model.Plan;
import gefp.model.Runway;
import gefp.model.Stage;
import gefp.model.User;

public interface UserDao {

    User getUser( Integer id );

    Department getDepaerment( Integer id );
    
    List<User> getUsersHavingName(String name);
    
    List<User> getUsers();
   
    List<Department> getDepartments();

    User getUsers( String name );

    User checkUser(String usname, String pswd);
    
    User saveUser(User user);
    
    Plan savePlan(Plan plan);
    
    List<Plan> getPlans(Integer deptId);
    
    boolean logoutuser(User u);
    
    Runway saveRunway(Runway runway);
    
    List<Runway> getRunways(Integer planId);
    
    Stage saveStage(Stage stage);
    
    List<Stage> getStages(Integer planId);
 
    Checkpoint saveCheckpoint(Checkpoint checkpoint);
    
   List<Checkpoint> getCheckpoints();

   Stage getStage(Integer id);

   Runway getRunway(Integer id);

   Checkpoint getCheckpoint(Integer chkid);

Plan getPlan(Integer id);

Department getDepartment(Integer id);





}