package com.tn.Req;

import com.tn.Entity.Permission;
import lombok.Data;

import java.util.List;
@Data
public class Permissionreq {

        private Permission permission;

        private List<Long> role;
}
