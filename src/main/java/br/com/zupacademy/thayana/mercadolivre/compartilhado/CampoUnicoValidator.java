package br.com.zupacademy.thayana.mercadolivre.compartilhado;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class CampoUnicoValidator implements ConstraintValidator<CampoUnico, Object>{

	private String palavra;
	private Class<?> classe;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override 
	public void initialize(CampoUnico constraintAnnotation) { 
		  palavra = constraintAnnotation.nomeAtributo(); 
		  classe = constraintAnnotation.classe();
	  }
	 
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = entityManager.createQuery("select 1 from "+classe.getName()+" where "+palavra+"=:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		
		return list.isEmpty();
	}

}
