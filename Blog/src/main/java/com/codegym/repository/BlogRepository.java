package com.codegym.repository;

import com.codegym.model.Account;
import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {

    Iterable<Blog> findAllByAccount(Account account);

    Page<Blog> findAllByTitle(String title, Pageable pageable);
}
