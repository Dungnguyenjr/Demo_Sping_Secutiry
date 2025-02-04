package com.tn.Service;

import com.tn.Entity.Permission;
import com.tn.Entity.Role;
import com.tn.Repository.PermissionRepository;
import com.tn.Repository.RoleRepository;
import com.tn.Req.Permissionreq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void Perrequeq(Permissionreq permissionreq) {
        Permission permission = permissionRepository.findById(permissionreq.getPermission().getId())
                .orElseThrow(() -> new EntityNotFoundException("Role not found"));

        List<Long> roleIds = permissionreq.getRole();

        for (Long Id : roleIds) {

            Role role = roleRepository.findById(Id)
                    .orElseThrow(() -> new EntityNotFoundException("User not found"));

            Set<Permission> permissions = role.getPermissions();
            if (permissions == null) {
                permissions = new HashSet<>();
            }
            if (!permissions.contains(permission)) {
                permissions.add(permission);
                role.setPermissions(permissions);
                roleRepository.save(role);
            }

        }
    }

    @Override
    public void Req(Permissionreq rolereq) {

    }
}
