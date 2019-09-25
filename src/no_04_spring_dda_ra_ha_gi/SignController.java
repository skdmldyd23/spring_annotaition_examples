package no_04_spring_dda_ra_ha_gi;

@Controller
public class SignController {
	//@RequestMapping("login")
	public String func1() {
		return "login";
	}
	
	//@RequestMapping("logout")
	public String func2() {
		return "logout";
	}
}
