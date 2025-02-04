package com.tn.Repository;


import com.tn.Entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    @Modifying
    @Query(value = "insert into user_roles (user_id, role_id) VALUES (:user_id,:role_id)", nativeQuery = true)
    @Transactional
    void createUserRole(@RequestBody List<Long> user_id, @Param("role_id") Long role_id);

}
