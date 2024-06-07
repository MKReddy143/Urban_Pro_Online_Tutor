package com.java.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.Model.BookClass;

@Repository
public interface BookClassRepository extends JpaRepository<BookClass, Long> {

}
