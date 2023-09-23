package com.weimin.dao;

import com.weimin.pojo.Account;

public interface AccountDao {
    int insertAccount(Account account);

    Account getAccountById(int id);
}
