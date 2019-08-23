package com.imti.springbasics;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by imteyaza-1lm on 2019-08-22
 **/
public interface StudentRepo extends JpaRepository<Student, Long> {

}
