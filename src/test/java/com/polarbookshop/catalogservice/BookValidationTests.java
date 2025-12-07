package com.polarbookshop.catalogservice;

import com.polarbookshop.catalogservice.domain.Book;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BookValidationTests {
    private static Validator validator;

    @BeforeAll
    static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void whenAllFieldsCorrectThenValidationSucceeds() {
        var book = new Book("1234567890","Title", "Author", 9.90);

        Set<ConstraintViolation<Book>> validate = validator.validate(book);
        assertThat(validate).isEmpty();

    }

    @Test
    void whenIsbnIsNotValidThenValidationFails() {
        var book = new Book("a1234567890","Title", "Author", 9.90);
        Set<ConstraintViolation<Book>> validate = validator.validate(book);
        assertThat(validate).hasSize(1);
        assertThat(validate.iterator().next().getMessage()).isEqualTo("ISBN格式不正确");
    }
}
