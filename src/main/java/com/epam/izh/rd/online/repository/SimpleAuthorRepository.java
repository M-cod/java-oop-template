package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

import java.util.Arrays;
import java.util.Objects;

public class SimpleAuthorRepository implements AuthorRepository {
    private Author[] authors = new Author[]{};

    @Override
    public boolean save(Author author) {
        Author authorNotNull = findByFullName(author.getName(), author.getLastName());
        if (authorNotNull == null) {
            if (authors.length == 0) {
                authors = new Author[]{author};
            } else {
                authors = Arrays.copyOf(authors, authors.length + 1);
                authors[authors.length - 1] = author;
            }
            return true;
        }
        return false;
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for (Author author : authors) {
            if ((author.getName() == name) && (author.getLastName() == lastname)) {
                return author;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {
        Author authorNotNull = findByFullName(author.getName(), author.getLastName());
        if (authorNotNull != null) {
            for (int i = 0; i < authors.length; i++) {
                if (authors[i].equals(author)) {
                    authors = Arrays.copyOfRange(authors, i, authors.length);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int count() {
        return authors.length;
    }
}
