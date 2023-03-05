package com.akash.BookUser;

import com.akash.BookUser.model.User;
import com.akash.BookUser.interfae.BookUserRepo;
import com.akash.BookUser.interfae.BookUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@SpringBootTest
class UserApplicationTests {
	@Autowired
	BookUserService service;
	@MockBean
	BookUserRepo repo;
	@Test
	void getBookOwnedTest() {
		User user = new User("1","Akash","Chaudhary","1 2 3");
		when(repo.findById("1")).thenReturn(Optional.of(user));
		List list = Arrays.asList("1","2","3");
		assertEquals(service.getBookOwned("1"),list);
	}

}
