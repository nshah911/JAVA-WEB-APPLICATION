package gefp.web.controller;

import gefp.model.Authority;
import gefp.model.Checkpoint;
import gefp.model.Department;
import gefp.model.Plan;
import gefp.model.Runway;
import gefp.model.Stage;
import gefp.model.User;
import gefp.model.dao.PlanDao;
import gefp.model.dao.UserDao;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({ "checkpoint" })
public class UserController {

	@Autowired
	private UserDao userDao;
	@Autowired
	private PlanDao planDao;

	@RequestMapping("/users.html")
	public String users(ModelMap models) {
		models.put("users", userDao.getUsers());
		return "users";
	}

	@RequestMapping("/Departments.html")
	public String departments(ModelMap models) {
		// List<Department> alldepts = userDao.getDepartments();
		models.put("alldepts", userDao.getDepartments());
		return "displayDept";
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.put("User", new User());
		return "login";

	}

	@RequestMapping(value = "/login.html", method = RequestMethod.POST)
	public String login(@ModelAttribute User u, HttpSession session) {
		try {
			User sessionUser = userDao.checkUser(u.getName(), u.getPassword());
			if (sessionUser != null) {
				session.setAttribute("uname", sessionUser.getName());

				Set<Authority> currAuth = sessionUser.getAuthorities();
				boolean isAdministratorUser = false;
				boolean isAdvisorUser = false;
				boolean isStudentUser = false;

				for (Authority auth : currAuth) {
					switch (auth.getId()) {
					case 1:
						isAdministratorUser = true;
						break;
					case 2:
						isAdvisorUser = true;
						break;
					case 3:
						isStudentUser = true;
						break;
					default:

					}
				}
				System.out.println(isStudentUser);
				session.setAttribute("pro", sessionUser);
				if (isStudentUser == true) {
					return "redirect:/Layout.html?id="
							+ sessionUser.getPlan().getId();
				}

				else if (isAdvisorUser) {
					return "redirect:/Departments.html";
				} else if (isAdministratorUser) {
					return "redirect:/Departments.html";
				}
			} else {
				return "redirect:/login.html";
			}
		} catch (NoResultException e) {
			return "redirect:/login.html";
		}
		return "redirect:/login.html";
	}

	@RequestMapping(value = "/logout.html", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpSession session) {

		session.invalidate();
		return "redirect:/login.html";

	}

	@RequestMapping("/Plan.html")
	public String plans(@RequestParam Integer id, ModelMap models,HttpSession pl) {
		// List<Department> alldepts = userDao.getDepartments();
		models.put("allplan", userDao.getPlans(id));
		pl.setAttribute("d_id", id);
		return "listplan";
	}

	@RequestMapping("/Layout.html")
	public String layout(@RequestParam Integer id, ModelMap models, HttpSession session) {

		User u = (User) session.getAttribute("pro");
		models.put("users", userDao.getUser(u.getId()));
		models.put("runways", userDao.getRunways(id));
		models.put("stages", userDao.getStages(id));
		models.put("checkpoints", userDao.getCheckpoints());
		models.put("plan", planDao.getPlan(id));
		return "layout";
	}
	@RequestMapping(value= "/Layout.html", method = RequestMethod.POST)
	public String layout1(ModelMap models,@RequestParam Integer id, HttpServletRequest request,HttpSession session) {
		
		String[] chek=request.getParameterValues("check");
//		List<Checkpoint> chk= (List<Checkpoint>)Arrays.asList(chek);
		User u = (User) session.getAttribute("pro");
		models.put("users", userDao.getUser(u.getId()));
		planDao.getPlan(id);
       int uid=u.getId();
       System.out.println("userid="+uid);
       

       
		for(String s:chek)
		{
			System.out.println(s);
//			u.setCheckpoint(chk);
			//System.out.println(ch);
		
			}
		
		return "redirect:Layout.html?id=" + id;
	}

	
	@RequestMapping(value = "/addrunway.html", method = RequestMethod.GET)
	public String addrunway(@RequestParam Integer id, ModelMap models) {

		return "addrunway";
	}

	@RequestMapping(value = "/addrunway.html", method = RequestMethod.POST)
	public String addrunway(@RequestParam Integer id, ModelMap models,
			HttpServletRequest request) {

		String runway_name = request.getParameter("runway_name");
		Plan p = planDao.getPlan(id);
		Runway runway = new Runway();
		runway.setPlan(p);
		runway.setName(runway_name);
		userDao.saveRunway(runway);
		return "redirect:Layout.html?id=" + id;
	}
	
	@RequestMapping(value = "/addplan.html", method = RequestMethod.GET)
	public String addplan(ModelMap models) {

		return "addplan";
	}
	@RequestMapping(value = "/addplan.html", method = RequestMethod.POST)
	public String addplan(ModelMap models, HttpServletRequest request,HttpSession pl) {
		String plan_name = request.getParameter("plan_name");
		int dept_id = (int) pl.getAttribute("d_id");
		Department de = userDao.getDepaerment(dept_id);
		Plan plan = new Plan();
		plan.setName(plan_name);
		plan.setDepartment(de);

		userDao.savePlan(plan);
	return"redirect:Plan.html?id="+dept_id;
	}
	
	
	

	@RequestMapping(value = "/addstage.html", method = RequestMethod.GET)
	public String addstage(@RequestParam Integer id, ModelMap models) {
		// models.put("stageq", new Stage());
		return "addstage";
	}

	@RequestMapping(value = "/addstage.html", method = RequestMethod.POST)
	public String addstage(@RequestParam Integer id, ModelMap models,
			HttpServletRequest request) {

		String stage_name = request.getParameter("stage_name");
		Plan p = planDao.getPlan(id);
		Stage stage = new Stage();
		stage.setPlan(p);
		stage.setName(stage_name);
		userDao.saveStage(stage);
		return "redirect:Layout.html?id=" + id;
	}

	@RequestMapping(value = "/addcheckpoint.html", method = RequestMethod.GET)
	public String addcheckpoint(@RequestParam Integer id, ModelMap models,
			HttpSession pl) {

		models.put("runways", userDao.getRunways(id));
		models.put("stages", userDao.getStages(id));
		models.put("checkpoint", new Checkpoint());
		return "addcheckpoint";
	}

	@RequestMapping(value = "/addcheckpoint.html", method = RequestMethod.POST)
	public String addcheckpoint(@RequestParam Integer id, ModelMap models,
			HttpServletRequest request) {

		String checkpoint_name = request.getParameter("checkpoint_name");
		Integer stage = Integer.parseInt(request.getParameter("sid"));
		Integer runway = Integer.parseInt(request.getParameter("rid"));
		Checkpoint checkpoint = new Checkpoint();
		System.out.println(checkpoint_name);
		checkpoint.setRunway(userDao.getRunway(runway));
		checkpoint.setStage(userDao.getStage(stage));
		checkpoint.setName(checkpoint_name);
		userDao.saveCheckpoint(checkpoint);
		return "redirect:Layout.html?id=" + id;
	}

	@RequestMapping(value = "/editcheckpoint.html", method = RequestMethod.GET)
	public String editcheckpoint(@RequestParam Integer chkid,
			@RequestParam Integer id, ModelMap models, HttpSession pl) {

		models.put("runways", userDao.getRunways(id));
		models.put("stages", userDao.getStages(id));
		models.put("plan", userDao.getPlan(id));
		models.put("checkpoint", userDao.getCheckpoint(chkid));
		return "Edit_";
	}

	@RequestMapping(value = "/editcheckpoint.html", method = RequestMethod.POST)
	public String editcheckpoint(@RequestParam Integer id,
			@ModelAttribute("checkpoint") Checkpoint checkpoint,
			ModelMap models, HttpServletRequest request, SessionStatus status) {

		Integer stage = Integer.parseInt(request.getParameter("sid"));
		Integer runway = Integer.parseInt(request.getParameter("rid"));
		Integer cid = Integer.parseInt(request.getParameter("cid"));
		checkpoint.setId(cid);
		checkpoint.setRunway(userDao.getRunway(runway));
		checkpoint.setStage(userDao.getStage(stage));
		userDao.saveCheckpoint(checkpoint);
		status.setComplete();
		return "redirect:Layout.html?id=" + id;
	}

	@RequestMapping(value = "/profile.html", method = RequestMethod.GET)
	public String profile(@RequestParam Integer id, ModelMap models,
			HttpSession session) {
		User u = (User) session.getAttribute("pro");
		models.put("users", userDao.getUser(u.getId()));
		models.put("alldepts", userDao.getDepartments());
		return "profile";
	}

	@RequestMapping(value = "/profile.html", method = RequestMethod.POST)
	public String profile1(@RequestParam Integer id,
			@ModelAttribute("user") User user, HttpSession session,
			ModelMap models, HttpServletRequest request) {

		User u = (User) session.getAttribute("pro");
		// u=user;
		String pwd = request.getParameter("passw");
		Integer dept_id = Integer.parseInt(request.getParameter("dept"));
		// String uname = (String) session.getAttribute("uname");

		Department de = userDao.getDepaerment(dept_id);
		int p = 1;
		if (dept_id == 1) {
			p = 1;
		} else {
			p = 2;
		}
		Plan pl = userDao.getPlan(p);
		int i = pl.getId();
		System.out.println(pwd.length());

		if (pwd.length() > 3) {
			if (pwd.contains("0") || pwd.contains("1") || pwd.contains("2")
					|| pwd.contains("3") || pwd.contains("4")
					|| pwd.contains("5") || pwd.contains("6")
					|| pwd.contains("7") || pwd.contains("8")
					|| pwd.contains("9"))
				u.setPassword(pwd);
		}

		u.setDepartment(de);
		u.setPlan(pl);

		userDao.saveUser(u);
		return "redirect:Layout.html?id=" + i;
	}

}
