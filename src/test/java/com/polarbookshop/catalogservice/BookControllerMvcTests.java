package com.polarbookshop.catalogservice;

import com.polarbookshop.catalogservice.domain.BookService;
import com.polarbookshop.catalogservice.persistence.BookNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class BookControllerMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void getBookById() throws Exception {
        String isbn = "1234567890";
        given(bookService.viewBookDetail(isbn)).willThrow(BookNotFoundException.class);

        mockMvc.perform(get("/books"+isbn)).andExpect(status().isNotFound());
    }
}
