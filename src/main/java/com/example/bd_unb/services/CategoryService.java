package com.example.bd_unb.services;//package com.example.bd_unb.services;

import  java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bd_unb.domain.Category;
import com.example.bd_unb.dtos.CategoryDTO;
import com.example.bd_unb.repositories.CategoryRepository;
import com.example.bd_unb.services.exceptions.DataIntegrityViolationException;
import com.example.bd_unb.services.exceptions.ObjectNotFoundExcpetion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

@Service
public class  CategoryService {

	private static final String INSERT_USERS_SQL = "insert \n" +
			"    into\n" +
			"        category\n" +
			"        (id, name) \n" +
			"    values\n" +
			"        (null, :name)";

	@Autowired
	private CategoryRepository repository;

	@PersistenceContext
	private EntityManager entityManager;

	public List<Category> findAll() {
		return repository.findAll();
	}

	public Category findById(Integer id) {
		Optional<Category> obj = Optional.ofNullable(repository.buscaById(id));
		return obj.orElseThrow(() -> new ObjectNotFoundExcpetion(
				"Object not found! Id: " + id + ", Type: " + CategoryService.class.getName()));
	}

	@Transactional
	public Category create(Category category) {
		try{
			repository.create(category.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	public Category updateAll(CategoryDTO objDto) {
		Category newObj = new Category(objDto.getId(), objDto.getName());
		return repository.save(newObj);
	}

	public void deleteById(Integer id) {
		repository.findById(id);

		try {
			repository.deleteById(id);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(
					"Object has associations and cannot be deleted! Id: " + id + ", Type: " + Category.class.getName());
		}
	}

	public CategoryDTO fromDTO(Category obj) {
		return new CategoryDTO(obj);
	}

}
