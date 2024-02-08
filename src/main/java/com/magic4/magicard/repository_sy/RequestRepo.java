package com.magic4.magicard.repository_sy;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magic4.magicard.vo.Request;

public interface RequestRepo extends JpaRepository<Request, UUID>{
  
}
