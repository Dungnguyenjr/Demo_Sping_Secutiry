package com.tn.Service;

import com.tn.Entity.Permission;
import com.tn.Repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {
    @Autowired
    PermissionRepository permissionRepository;

    public void save(Permission permission) {
        permissionRepository.save(permission);
    }

    public void delete(Integer id) {
        permissionRepository.deleteById(id);
    }
}
