package com.bank.security;

import com.bank.model.entity.CustomUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserService {
    void addUser(CustomUser customUser);
    void updateUser(CustomUser customUser);
    boolean isUserExist(String login);
    CustomUser getUserByLogin(String login);
}
