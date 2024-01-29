package com.magic4.magicard.test;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@Log4j2
public class MemoController {
    @Autowired
    private MemoRepo memoRepo;

    @GetMapping("/test/list")
    public List<Memo> getMethodName() {
        return (List<Memo>) memoRepo.findAll();
    }

    @PostMapping("/test/post")
    public boolean insertItem(@RequestBody Memo memo) {
        memoRepo.save(memo);
        return true;
    }

    @DeleteMapping("/test/delete/{id}")
    public void deleteItem(@PathVariable(name = "id") UUID id) {
        log.info(id);
        memoRepo.deleteById(id);
    }

}