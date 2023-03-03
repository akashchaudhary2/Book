package com.akash.BookUser;

import com.akash.BookUser.model.BookUser;
import com.akash.BookUser.repo.BookUserRepo;
import com.akash.BookUser.service.BookUserService;
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
class BookUserApplicationTests {
	@Autowired
	BookUserService service;
	@MockBean
	BookUserRepo repo;
	@Test
	void getBookOwnedTest() {
		BookUser user = new BookUser("1","Akash","Chaudhary","1 2 3");
		when(repo.findById("1")).thenReturn(Optional.of(user));
		List list = Arrays.asList("1","2","3");
		assertEquals(service.getBookOwned("1"),list);
	}

}
