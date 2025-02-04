package com.tn.Service;

import com.tn.Req.Permissionreq;
import org.springframework.transaction.annotation.Transactional;

public interface RolePermissionService {
    @Transactional
    void Perrequeq(Permissionreq permissionreq);

    void Req(Permissionreq rolereq);
}
