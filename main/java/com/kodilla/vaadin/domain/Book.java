package com.kodilla.vaadin.domain;

import com.vaadin.flow.data.binder.Binder;

public class Book {
    private String title;
    private String author;
    private String publicationYear;
    private BookType type;

    public Book() {
    }

    public Book(String title, String author, String publicationYear, BookType type) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public BookType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!title.equals(book.title)) return false;
        if (!author.equals(book.author)) return false;
        if (!publicationYear.equals(book.publicationYear)) return false;
        return type.equals(book.type);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + publicationYear.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setType(BookType type) {
        this.type = type;
    }
}
