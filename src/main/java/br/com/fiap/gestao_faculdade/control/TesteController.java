package br.com.fiap.gestao_faculdade.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class TesteController {

	@GetMapping("/nivel1")
	public String testarNivel1() {
		return "/teste/exemplo";
	}

	@GetMapping("/nivel2")
	public String testarNivel2(HttpServletRequest req) {
		req.setAttribute("var", "FIAP");
		return "/teste/exemplo";
	}

	@GetMapping("/nivel3")
	public String testarNivel3(Model md) {
		Auxiliar aux = new Auxiliar("Fulano","DeTal");
		md.addAttribute("var", aux);
		return "/teste/exemplo2";
	}
	
	@GetMapping("/nivel4")
	public ModelAndView testarNivel4(){
		ModelAndView mv = new ModelAndView("/teste/exemplo2");
		Auxiliar aux = new Auxiliar("Beltrano","DeTal");
		mv.addObject("var", aux);
		return mv;
	}

	class Auxiliar {

		private String nome;
		private String sobrenome;

		public Auxiliar() {

		}

		public Auxiliar(String nome, String sobrenome) {
			super();
			this.nome = nome;
			this.sobrenome = sobrenome;
		}

		public String getNome() {
			return this.nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getSobrenome() {
			return sobrenome;
		}

		public void setSobrenome(String sobrenome) {
			this.sobrenome = sobrenome;
		}

	}

}
