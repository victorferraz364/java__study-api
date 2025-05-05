package victordev.studiapi.modules.nutrition.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import victordev.studiapi.global.exceptions.regras.NegocioException;
import victordev.studiapi.modules.leitura.exceptions.LivroNaoEncontradoException;
import victordev.studiapi.modules.nutrition.model.Meals;
import victordev.studiapi.modules.nutrition.repository.MealsRepository;
import victordev.studiapi.modules.nutrition.service.MealsService;

@RestController
@RequestMapping(value = "/meals")
public class MealsController {

	@Autowired
	private MealsRepository mealsRepository;
	
	@Autowired
	private MealsService mealsService;
	
	
	@GetMapping
	public List<Meals> listar() {
		return mealsRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Meals adicionar(@Valid @RequestBody Meals meal) {
		
		try {
			return mealsService.registerMeal(meal);
		}catch(LivroNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
		
	}
	
	@PutMapping("/{mealRegisterID}")
	public Meals atualizar(@PathVariable Long mealRegisterID, @RequestBody Meals meal) {
		Meals registroAtual = mealsService.findMealRegister(mealRegisterID);
		BeanUtils.copyProperties(meal, registroAtual, "id");
		try {
			return mealsService.registerMeal(registroAtual);
		} catch(LivroNaoEncontradoException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	@DeleteMapping("/{mealRegisterID}")
	public void deletarRegistroAgua(@PathVariable Long mealRegisterID) {
		mealsService.excluir(mealRegisterID);
	}
	
}
