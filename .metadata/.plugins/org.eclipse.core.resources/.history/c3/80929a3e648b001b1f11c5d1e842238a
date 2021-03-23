package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Palindrome;

@Repository
public interface PalindromeRepository extends JpaRepository<Palindrome,Long> {
	List<Palindrome> findAll();
	Optional<Palindrome> findByOriginal(String original);
}
