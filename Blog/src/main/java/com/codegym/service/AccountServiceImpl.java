package com.codegym.service;

import com.codegym.model.Account;
import com.codegym.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findOne(id);
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void remove(Long id) {
        accountRepository.delete(id);
    }
}
