package com.smarvel.springboot.backend;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.smarvel.springboot.backend.dao.ICategoryDao;
import com.smarvel.springboot.backend.entities.Category;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoriaRepositoryTest {
	
	@Autowired
	private ICategoryDao categoryDao;
	
	@Test
	public void testCreateCategory() {
		Category categorySave = categoryDao.save(new Category("Electrónicos"));
		assertThat(categorySave.getId()).isGreaterThan(0);
	}
	
	

}
