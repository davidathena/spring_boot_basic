package com.richway.basic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.richway.basic.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	
	Role findByRoleName(String roleName);

	/*Role findRoleByWhere(String roleName, Integer sortId); */

	@Query("from Role r where r.roleName=:name")
	Role findRole(@Param("name") String roleName);
}
