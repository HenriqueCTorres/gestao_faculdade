package br.com.fiap.gestao_faculdade.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.gestao_faculdade.model.Discente;
import br.com.fiap.gestao_faculdade.model.EnumNacionalidade;
import br.com.fiap.gestao_faculdade.model.EnumNivel;
import br.com.fiap.gestao_faculdade.model.EnumStatus;
import br.com.fiap.gestao_faculdade.model.Pessoa;
import br.com.fiap.gestao_faculdade.repository.DiscenteRepository;
import br.com.fiap.gestao_faculdade.repository.PessoaRepository;
import jakarta.validation.Valid;

@Controller
public class PessoaController {

	@Autowired
	private PessoaRepository repP;

	@Autowired
	private DiscenteRepository repD;

	@GetMapping("/pessoa/nova")
	public ModelAndView popularFormPessoa() {
		ModelAndView mv = new ModelAndView("/pessoa/nova");
		mv.addObject("pessoa", new Pessoa());
		mv.addObject("nacionalidades", EnumNacionalidade.values());
		return mv;
	}

	@PostMapping("/cadastrar_pessoa")
	public ModelAndView cadastrarPessoa(@Valid Pessoa pessoa, BindingResult bd) {

		if (bd.hasErrors()) {
			ModelAndView mv = new ModelAndView("/pessoa/nova");
			mv.addObject("pessoa", pessoa);
			mv.addObject("nacionalidades", EnumNacionalidade.values());
			return mv;
		} else {
			Pessoa pes = new Pessoa();
			pes.setCpf(pessoa.getCpf());
			pes.setDataNascimento(pessoa.getDataNascimento());
			pes.setEmail(pessoa.getEmail());
			pes.setNacionalidade(pessoa.getNacionalidade());
			pes.setNome(pessoa.getNome());
			pes.setTelefone(pessoa.getTelefone());

			repP.save(pes);

			Discente dis = new Discente();
			dis.setPessoa(pes);
			dis.setEmailInstitucional("À Definir");
			dis.setNivel(EnumNivel.A_DEFINIR);
			dis.setStatus(EnumStatus.A_DEFINIR);
			dis.setRm("A Definir");

			repD.save(dis);

			return new ModelAndView("redirect:/home");

		}
	}

}
