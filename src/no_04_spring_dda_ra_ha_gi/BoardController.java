package no_04_spring_dda_ra_ha_gi;

@Controller
public class BoardController {
	//@RequestMapping("list")
	public String func1() {
		return "boadrList";
	}
	
	//@RequestMapping("write")
	public String func2() {
		return "boadrWrite";
	}
}
