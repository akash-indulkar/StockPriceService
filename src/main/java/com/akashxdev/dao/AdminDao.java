package com.akashxdev.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.akashxdev.model.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{

	Admin findByEmail(String username);

}
