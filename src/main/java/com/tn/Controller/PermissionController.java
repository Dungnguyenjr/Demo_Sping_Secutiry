package com.tn.Controller;

import com.tn.Entity.Permission;
import com.tn.Req.Permissionreq;
import com.tn.Service.PermissionService;
import com.tn.Service.RolePermissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RolePermissionServiceImpl rolePermissionService;

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping()
    public void create(@RequestBody Permission permission) {
        permissionService.save(permission);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        permissionService.delete(id);
    }

//    @PostMapping("/role")
//    public void perForRole(@RequestBody Permissionreq rolePermissionReq){
//        RolePermission rolePermission = new RolePermission();
//        rolePermission.setRoleId(rolePermissionReq.getRoleId());
//        rolePermission.setPermissionIds(rolePermissionReq.getPermissionIds());
//
//        rolePermissionService.save(rolePermission);
//    }
}

//    @PostMapping
//    public void permission(@RequestBody Rolereq rolePermissionReq){
//        RolePermission rolePermission = new RolePermission();
//        rolePermission.setRoleId(rolePermissionReq.getRoleId());
//        rolePermission.setPermissionIds(rolePermissionReq.getPermissionIds());
//
//        RolePermissionService.save(rolePermission);
//    }