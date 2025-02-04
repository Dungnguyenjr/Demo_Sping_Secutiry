package com.tn.Repository;

import com.tn.Entity.Role;
import com.tn.Entity.accountrole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

//    Optional<Role> findById(Integer id);
        Role findByName(accountrole role);
//    @Transactional
//    @Modifying
//    @Query(value = "insert into role_per values (:roleId, :permissionId)", nativeQuery = true)
//    Integer insert(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId);

}
