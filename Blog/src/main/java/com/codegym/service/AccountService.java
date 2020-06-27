package com.codegym.service;

import com.codegym.model.Account;

public interface AccountService {
    Iterable<Account> findAll();

    Account findById(Long id);

    void save(Account account);

    void remove(Long id);
}
