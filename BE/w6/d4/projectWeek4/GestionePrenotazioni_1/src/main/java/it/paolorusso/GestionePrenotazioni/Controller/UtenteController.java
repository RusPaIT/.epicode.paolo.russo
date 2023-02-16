package it.paolorusso.GestionePrenotazioni.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UtenteController {

	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "home page";
	}
	
	@GetMapping("/page1")
	@ResponseBody
	public String page1() {
		return "page 1";
	}
	
	@GetMapping("/page2")
	@ResponseBody
	public String page2() {
		return "page 2";
	}
	
	@PostMapping("/login_success")
	@ResponseBody
	public String login_success() {
		return "login success";
	}
	
	@GetMapping("/page3")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public String page3() {
		return "page 3";
	}
	
}
