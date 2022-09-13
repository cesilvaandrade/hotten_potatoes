package com.example.bd_unb.services;//package com.example.bd_unb.services;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.stereotype.Service;
//
//import com.example.bd_unb.domain.Book;
//import com.example.bd_unb.domain.Category;
//import com.example.bd_unb.dtos.BookDTO;
//import com.example.bd_unb.repositories.BookRepository;
//import com.example.bd_unb.repositories.CategoryRepository;
//import com.example.bd_unb.services.exceptions.ObjectNotFoundExcpetion;
//
//@Service
//public class BookService {
//
//	/*@Autowired
//	private BookRepository repository;
//
//	@Autowired
//	private CategoryService categoryService;
//	@Autowired
//	private CategoryRepository categoryRepo;
//
//	public Book insert(Integer id, BookDTO obj) {
//		Category category = categoryService.findById(id);
//		Book newObj = new Book(null, obj.getTitle(), obj.getDescription());
//		newObj.getCategories().add(category);
//		category.getBooks().add(newObj);
//		return repository.save(newObj);
//	}
//
//	public List<Book> findAllByCategory(Integer id) {
//		return repository.findByCategories(categoryService.findById(id));
//	}
//
//	public Book findById(Integer id) {
//		Optional<Book> obj = repository.findById(id);
//		return obj.orElseThrow(() -> new ObjectNotFoundExcpetion(
//				"Object not found! Id: " + id + ", Type: " + Book.class.getName()));
//	}
//
//	public void deleteById(Integer id) {
//		try {
//			repository.deleteById(id);
//		} catch (DataIntegrityViolationException e) {
//			throw new com.example.bd_unb.services.exceptions.DataIntegrityViolationException("Error to delete Book");
//		}
//	}
//
//	public Book update(Integer id, BookDTO obj) {
//		obj.setId(id);
//		Book newObj = new Book(obj.getId(), obj.getTitle(), obj.getDescription());
//		Category cat = categoryRepo.findByBooks(newObj);
//		newObj.getCategories().add(cat);
//		return repository.save(newObj);
//	}*/
//}
