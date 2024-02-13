package com.magic4.magicard.sg.repository_sg;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.magic4.magicard.vo.IssuedCard;

public interface IssuedCardRepo extends CrudRepository<IssuedCard, UUID> {

}
