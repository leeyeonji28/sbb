package com.mysite.sbb.User.dao;

import com.mysite.sbb.User.domain.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
}