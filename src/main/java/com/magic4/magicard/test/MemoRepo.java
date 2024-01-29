package com.magic4.magicard.test;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface MemoRepo extends CrudRepository<Memo, UUID> {

}