package gefp.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = "UserDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    UserDao userDao;
    
    @Autowired
    PlanDao planDao;

//    @Test
//    public void getCheckPointOfUser1()
//    {
//        assert userDao.getUser( 3 ).getCheckpoint().size() == 1;
//    }
//
//    @Test
//    public void getCheckPointOfUser2()
//    {
//        assert userDao.getUser( 4 ).getCheckpoint().size() == planDao.getPlanCheckpoint(1).size();
//    }
//    
//    @Test
//    public void bothUserExists()
//    {
//        assert userDao.getUsersHavingName( "jdoe1" ).size() == 1 && userDao.getUsersHavingName( "jdoe2" ).size() == 1;
//    }

    
//    @Test
//    public void getUsers()
//    {
//        assert userDao.getUsers().size() == 4;
//    }

}