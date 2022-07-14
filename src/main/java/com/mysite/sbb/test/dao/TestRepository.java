package com.mysite.sbb.test.dao;

import com.mysite.sbb.test.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Integer> {
}