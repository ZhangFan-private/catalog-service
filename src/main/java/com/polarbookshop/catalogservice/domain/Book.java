package com.polarbookshop.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record Book(
        @NotBlank(message = "The Book ISBN must be defined")
        @Pattern(regexp = "^([0-9]{10}|[0-9]{13})$", message = "ISBN格式不正确")
        String isbn,
        @NotBlank(message = "书籍标题不能为空")
        String title,
        @NotBlank(message = "作者信息不能为空")
        String author,
        @NotNull(message = "书籍价格不能为空")
        @Positive(message = "价格必须大于零")
        Double price) {
}
