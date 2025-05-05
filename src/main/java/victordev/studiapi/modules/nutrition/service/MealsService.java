package victordev.studiapi.modules.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import victordev.studiapi.global.utils.MultiValidadorService;
import victordev.studiapi.modules.nutrition.exceptions.AguaNaoEncontradaException;
import victordev.studiapi.modules.nutrition.model.Meals;
import victordev.studiapi.modules.nutrition.repository.MealsRepository;

@Service
public class MealsService {

	@Autowired
	private MultiValidadorService<Meals> validadorService;
	
	@Autowired
	private MealsRepository mealsRepository;
	
	public Meals registerMeal(Meals meals) {
		
		validadorService.verificarIdnoPost(meals, Meals::getId);
		return mealsRepository.save(meals);
	}
	
	 public Meals findMealRegister(Long mealId) {
	        return mealsRepository.findById(mealId)
	                .orElseThrow(() -> new AguaNaoEncontradaException(mealId));
	 }
	
	 public void excluir (Long id) {
		 findMealRegister(id);
		 mealsRepository.deleteById(id);
	 }
}
