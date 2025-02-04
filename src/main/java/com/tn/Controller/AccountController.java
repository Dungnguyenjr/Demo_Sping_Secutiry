package com.tn.Controller;

import com.tn.Entity.Role;
import com.tn.Entity.account;
import com.tn.Entity.accountrole;
import com.tn.Repository.RoleRepository;
import com.tn.Repository.AccountRepository;
import com.tn.Req.Userreq;
import com.tn.Service.AccountServiceImpl;
import dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class AccountController {


    @Autowired
    private AccountRepository userRepository;


    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private AccountServiceImpl accountRoleService;




    // Xử lý POST request để tạo mới một người dùng
    @PostMapping("/account")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
        account users = new account();
        users.setUsername(userDTO.getUsername());
        users.setPassword(userDTO.getPassword());
        account savedUser = userRepository.save(users);
        return ResponseEntity.ok(savedUser);
    }

    // Xử lý POST request để tạo Role
    @PostMapping("/role")
    public ResponseEntity<?> createRole(@RequestBody Role role){
        Role savedRole = roleRepository.save(role);
        return ResponseEntity.ok(savedRole);
    }

    // Xử lý DELETE request để xóa Role
    @DeleteMapping("/role/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Integer id){
        roleRepository.deleteById(id.longValue());
        return ResponseEntity.ok("Vai trò đã được xóa thành công");
    }

    //request cập nhật thông tin người dùng
    @PutMapping("{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody account userDetails){
        account user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng: " + id));
        user.setUsername(userDetails.getUsername());
        account updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

//    @PostMapping("accountrole")
//    public void addRoleToAccount(@RequestBody Userreq roleAccountReq
//
//    ) {
//        accountrole accountrole = new accountrole();
//        accountrole.setAccountId(roleAccountReq.getAccountId());
//        accountrole.setRoleIds(roleAccountReq.getRoleIds());
//        System.out.println(accountrole);
//        accountRoleService.save(accountrole);
//    }

}