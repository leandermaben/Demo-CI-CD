package com.db.batch10;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;




public interface StudentRepository extends CrudRepository<Student, Integer> {

}
