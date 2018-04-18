package com.richway.basic.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.richway.basic.domain.Role;
import com.richway.basic.service.RoleService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRepositoryTests {
	
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private RoleService roleService;
	
	@Before
	public void setUp() {
		//roleService.createRoleTable();
	}
	
	@Test
	public void test() {
		roleRepository.save(new Role("system",1));
		roleRepository.save(new Role("application",2));
		Role role=roleRepository.findRole("system");
		System.out.println(role.getRoleName()+":id--"+role.getId()+":sort--"+role.getSortId());
		List<Role> listRole=roleRepository.findAll();
		for(Role r:listRole) {
			System.out.println(r.getRoleName());
		}
		Assert.assertEquals(2, roleRepository.findAll().size());
		
	}
}
