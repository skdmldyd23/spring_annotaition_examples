package no_05_spring_dda_ra_ha_gi_up;

@Controller
public class SignController {
	@RequestMapping("login")
	public String func1() {
		return "login";
	}
	
	@RequestMapping("logout")
	public String func2() {
		return "logout";
	}
}
