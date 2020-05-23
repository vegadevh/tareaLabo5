package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Estudiante;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO{
	
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.estudiante");
		Query query = entityManager.createNativeQuery(sb.toString(),Estudiante.class);
		List<Estudiante> resultset = query.getResultList();
		
		return resultset;
	}

	@Override
	@Transactional
	public void insert(Estudiante estudiante) throws DataAccessException {
		entityManager.persist(estudiante);
		
	}

	@Override
	@Transactional
	public void delete(Integer code) throws DataAccessException {
		
		Estudiante estudiante = entityManager.find(Estudiante.class, code); //Identificar al estudiante con primaryKey code
		entityManager.remove(estudiante); //Remove estudiante
		
	}

	
}
