package com.codegym.service;

import com.codegym.model.Account;
import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    Iterable<Blog> findAllByAccount(Account account) ;

    Page<Blog> findAllByTitle(String title, Pageable pageable);
}
