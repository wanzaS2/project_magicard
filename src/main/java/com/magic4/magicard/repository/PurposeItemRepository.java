package com.magic4.magicard.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.magic4.magicard.vo.PurposeItem;

public interface PurposeItemRepository extends JpaRepository<PurposeItem,UUID>{

    
} 