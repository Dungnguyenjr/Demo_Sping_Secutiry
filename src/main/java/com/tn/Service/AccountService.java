package com.tn.Service;

import com.tn.Entity.account;
import com.tn.Req.Roleraccount;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface AccountService extends UserDetailsService {
//    void setRoleraccount(Roleraccount roleraccount);
        account createUser(account user);
        account updateUser(Long id, account user);
        void deleteUser(Long id);
        account getUserById(Long id);
        List<account> getAllUsers();
}
