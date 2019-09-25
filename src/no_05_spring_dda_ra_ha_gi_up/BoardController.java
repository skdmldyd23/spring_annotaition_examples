package no_05_spring_dda_ra_ha_gi_up;

@Controller
public class BoardController {
	@RequestMapping("list")
	public String func1() {
		return "boadrList";
	}
	
	//@RequestMapping("write")
	public String func2() {
		return "boadrWrite";
	}
}
