package com.polarbookshop.catalogservice.web;

import com.polarbookshop.catalogservice.domain.Book;
import com.polarbookshop.catalogservice.domain.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    /**
     * 查询出所有book
     * @return
     */
    @GetMapping()
    public Iterable<Book> get() {
        return bookService.viewBookList();
    }

    /**
     * 根据isbn编码查询book
     * @param isbn
     * @return
     */
    @GetMapping("/{isbn}")
    public Book getByIsbn(@PathVariable String isbn) {
        return bookService.viewBookDetail(isbn);
    }

    /**
     * 增加book
     * @param book
     * @return
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Book post(@Valid @RequestBody Book book) {
        return bookService.addBookToCatalog(book);
    }

    /**
     * 根据isbn删除book
     * @param isbn
     */
    @DeleteMapping("{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String isbn) {
        bookService.removeBookFromCatalog(isbn);
    }

    /**
     * 根据isbn号编辑book
     * @param isbn
     * @param book
     * @return
     */
    @PutMapping("{isbn}")
    public Book put(@PathVariable String isbn, @Valid @RequestBody Book book) {
        return bookService.addBookToCatalog(book);
    }
}
