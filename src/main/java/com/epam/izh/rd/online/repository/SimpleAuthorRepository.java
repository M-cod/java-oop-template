package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;

import java.util.Arrays;
import java.util.Objects;

public class SimpleAuthorRepository implements AuthorRepository {
    private Author[] authors = new Author[]{};

    @Override
    public boolean save(Author author) {
        if (findByFullName(author.getName(), author.getLastName()) == null) {
            if (count() == 0) {
                authors = new Author[]{author};
            } else {
                authors = Arrays.copyOf(authors, count() + 1);
                authors[count() - 1] = author;
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
        if (findByFullName(author.getName(), author.getLastName()) != null) {
            Author[] newAutor = Arrays.copyOf(authors, count());
            for (int i = 0; i < newAutor.length; i++) {
                if (newAutor[i].equals(author)) {
                    newAutor[i] = null;
                    break;
                }
            }
            authors = new Author[count() - 1];
            for (int i = 0, j = 0; i < newAutor.length; i++){
                if (newAutor[i] != null){
                    authors[j] = newAutor[i];
                    j++;
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
