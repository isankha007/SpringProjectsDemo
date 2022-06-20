package com.sankha.springboot.crud;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import com.sankha.springboot.crud.entity.Product;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootTestIntegrationApplicationTests {
	
	@LocalServerPort
	private int port;
	
	private String baseUrl = "http://localhost";
	
	
	private static RestTemplate restTemplate;
	
	@Autowired
	private TestH2Repository testH2Repository;
	
	@BeforeAll
	public static void init() {
		
		restTemplate= new RestTemplate();
	}
	
	@BeforeEach
	public void setup() {
		baseUrl = baseUrl.concat(":").concat(port+"").concat("/products");
	}
	
	@Test
	public void testAddProduct() {
		Product product = new Product("Headset",2,200);
		Product response =restTemplate.postForObject(baseUrl, product, Product.class);
		assertEquals("Headset", response.getName());
		assertEquals(1,testH2Repository.findAll().size());
	}
	
	@Test
	@Sql(statements = "INSERT INTO PRODUCT_TBL(id,name,quantity,price) VALUES(4,'AC',1,34000)",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM PRODUCT_TBL WHERE id='AC'", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testGetProduct() {
		List<Product> products= restTemplate.getForObject(baseUrl, List.class);
		assertEquals(1, products.size());
		assertEquals(1,testH2Repository.findAll().size());
	}
	
	@Test
	@Sql(statements = "INSERT INTO PRODUCT_TBL(id,name,quantity,price) VALUES(1,'CAR',1,34000)",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM PRODUCT_TBL WHERE id=1", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testFindProductbyId() {
		Product product= restTemplate.getForObject(baseUrl+ "/{id}",Product.class,1);
		assertAll(
				()->assertNotNull(product),
				()->assertEquals(1, product.getId()),
				()->assertEquals("CAR", product.getName())
				);
		assertEquals(1,testH2Repository.findAll().size());
	}
	
    @Test
    @Sql(statements = "INSERT INTO PRODUCT_TBL (id,name, quantity, price) VALUES (2,'shoes', 1, 999)", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements = "DELETE FROM PRODUCT_TBL WHERE id=1", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testUpdateProduct() {
    	Product product = new Product("shoes",2,1999);
    	restTemplate.put(baseUrl+"/update/{id}", product, 2);
    	Product productFromDB= testH2Repository.findById(2L).get();
    	assertAll(
				()->assertNotNull(productFromDB),
				()->assertEquals(2, productFromDB.getId()),
				()->assertEquals(1999, productFromDB.getPrice())
				);
		assertEquals(1,testH2Repository.findAll().size());
	}
    
    @Test
    @Sql(statements = "INSERT INTO PRODUCT_TBL (id,name, quantity, price) VALUES (8,'books', 5, 1499)", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    public void testDeleteProduct(){
        int recordCount=testH2Repository.findAll().size();
        assertEquals(1, recordCount);
        restTemplate.delete(baseUrl+"/delete/{id}", 8);
        assertEquals(0, testH2Repository.findAll().size());

    }
//	@Test
//	void contextLoads() {
//	}

}
