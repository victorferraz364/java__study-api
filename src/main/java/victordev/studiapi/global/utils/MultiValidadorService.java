package victordev.studiapi.global.utils;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import victordev.studiapi.global.exceptions.regras.IdManualException;
import victordev.studiapi.modules.nutrition.model.Meals;

@Service
public class MultiValidadorService<T> {

    public void verificarIdnoPost(T entidade, Function<T, Long> getIdFunction) {
        if (getIdFunction.apply(entidade) != null) {
            throw new IdManualException();
        }
    }

	
	
}
