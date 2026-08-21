package br.com.fiap.gestao_faculdade.control;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.gestao_faculdade.model.Discente;
import br.com.fiap.gestao_faculdade.model.EnumNacionalidade;
import br.com.fiap.gestao_faculdade.model.EnumNivel;
import br.com.fiap.gestao_faculdade.model.EnumStatus;
import br.com.fiap.gestao_faculdade.repository.DiscenteRepository;
import jakarta.validation.Valid;

@Controller
public class DiscenteController {

	@Autowired
	private DiscenteRepository repD;

	@GetMapping("/home")
	public ModelAndView popularHomePage() {
		ModelAndView mv = new ModelAndView("/home/index");
		mv.addObject("discentes", repD.findAll());
		return mv;
	}

	@GetMapping("/discente/detalhes/{id}")
	public ModelAndView exibirDetalhesDiscente(@PathVariable Long id) {

		Optional<Discente> op = repD.findById(id);

		if (op.isPresent()) {
			ModelAndView mv = new ModelAndView("/discente/detalhes");
			mv.addObject("discente", op.get());
			return mv;
		} else {
			return new ModelAndView("redirect:/home");
		}

	}

	@GetMapping("/discente/remover/{id}")
	public ModelAndView removerDiscente(@PathVariable Long id) {

		Optional<Discente> op = repD.findById(id);

		if (op.isPresent()) {
			repD.deleteById(id);
			return new ModelAndView("redirect:/home");
		} else {
			return new ModelAndView("redirect:/home");
		}

	}

	@GetMapping("/discente/editar/{id}")
	public ModelAndView retornarPaginaEdicao(@PathVariable Long id) {

		Optional<Discente> op = repD.findById(id);

		if (op.isPresent()) {
			ModelAndView mv = new ModelAndView("/discente/edicao");
			mv.addObject("discente", op.get());
			mv.addObject("lista_nacionalidades", EnumNacionalidade.values());
			mv.addObject("lista_status", EnumStatus.values());
			mv.addObject("lista_niveis", EnumNivel.values());
			return mv;

		} else {
			return new ModelAndView("redirect:/home");
		}

	}

	@PostMapping("/discente/atualizar/{id}")
	public ModelAndView atualizarDiscente(@PathVariable Long id,
			@Valid Discente discente, BindingResult bd) {
		if(bd.hasErrors()) {
			ModelAndView mv = new ModelAndView("/discente/edicao");
			mv.addObject("discente", discente);
			mv.addObject("lista_nacionalidades", EnumNacionalidade.values());
			mv.addObject("lista_status", EnumStatus.values());
			mv.addObject("lista_niveis", EnumNivel.values());
			return mv;
		} else {
			Optional<Discente> op = repD.findById(id);

			if (op.isPresent()) {

				Discente discente_banco = op.get();
				discente_banco.transferirDiscente(discente);
				repD.save(discente_banco);

			}

			return new ModelAndView("redirect:/home");
		}

	}

}
