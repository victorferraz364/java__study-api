package victordev.studiapi.modules.nutrition.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Meals {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	public String food;
	public Double quantity;
	public Double calories;
	private Date registrationDate;
	
	
}
