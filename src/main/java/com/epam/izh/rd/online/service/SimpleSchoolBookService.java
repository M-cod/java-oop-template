package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.entity.Author;
import com.epam.izh.rd.online.entity.Book;
import com.epam.izh.rd.online.entity.SchoolBook;
import com.epam.izh.rd.online.repository.BookRepository;

public class SimpleSchoolBookService implements BookService<SchoolBook>{

    private BookRepository<SchoolBook> schoolBookBookRepository;
    private AuthorService authorService;

    public SimpleSchoolBookService() {
    }

    public SimpleSchoolBookService(BookRepository<SchoolBook> schoolBookBookRepository, AuthorService authorService) {
        this.schoolBookBookRepository = schoolBookBookRepository;
        this.authorService = authorService;
    }

    @Override
    public boolean save(SchoolBook book) {
        Author author = authorService.findByFullName(book.getAuthorName(), book.getAuthorLastName());
        if (author != null){
            schoolBookBookRepository.save(book);
            return true;
        }
        return false;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        return new SchoolBook[0];
    }

    @Override
    public int getNumberOfBooksByName(String name) {
        return schoolBookBookRepository.findByName(name).length;
    }

    @Override
    public boolean removeByName(String name) {
        return schoolBookBookRepository.removeByName(name);
    }

    @Override
    public int count() {
        return schoolBookBookRepository.count();
    }

    @Override
    public Author findAuthorByBookName(String name) {
        SchoolBook[] schoolBooks = schoolBookBookRepository.findByName(name);
        if (schoolBooks.length == 0) {
            return null;
        }
        return authorService.findByFullName(schoolBooks[0].getAuthorName(), schoolBooks[0].getAuthorLastName());
    }

}
