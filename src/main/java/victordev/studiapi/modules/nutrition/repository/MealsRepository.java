package victordev.studiapi.modules.nutrition.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import victordev.studiapi.modules.nutrition.model.Meals;

public interface MealsRepository extends JpaRepository<Meals, Long>{

}
