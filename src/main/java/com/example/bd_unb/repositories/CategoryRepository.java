package com.example.bd_unb.repositories;//package com.example.bd_unb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.bd_unb.domain.Book;
import com.example.bd_unb.domain.Category;

import javax.transaction.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{


	Category buscaById(Integer id);

	Category findByBooks(Book obj);

	@Modifying
	@Query(
			value =
					"insert into Category (id, name) values ( null , :name)",
			nativeQuery = true)
	void create(@Param("name") String name);
}
