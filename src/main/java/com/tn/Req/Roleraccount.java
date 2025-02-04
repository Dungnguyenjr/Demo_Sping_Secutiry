package com.tn.Req;

import com.tn.Entity.Role;
import lombok.Data;

import java.util.List;
@Data
public class Roleraccount {
    private Role role;

    private List<Long> user;
}
