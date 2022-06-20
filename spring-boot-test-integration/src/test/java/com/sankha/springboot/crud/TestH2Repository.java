package com.sankha.springboot.crud;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sankha.springboot.crud.entity.Product;

public interface TestH2Repository extends JpaRepository<Product, Long> {

}
