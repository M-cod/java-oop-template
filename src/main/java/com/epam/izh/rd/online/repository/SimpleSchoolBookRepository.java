package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;

import java.util.Arrays;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook>{
    private SchoolBook[] schoolBooks = new SchoolBook[]{};

    @Override
    public boolean save(SchoolBook book) {
        if (schoolBooks.length == 0){
            schoolBooks = new SchoolBook[]{book};
        } else {
            schoolBooks = Arrays.copyOf(schoolBooks, schoolBooks.length + 1);
            schoolBooks[schoolBooks.length - 1] = book;
        }
        return true;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        SchoolBook[] newSchoolBook = new SchoolBook[schoolBooks.length];
        for (int i = 0, j = 0; i < schoolBooks.length; i++){
            if (schoolBooks[i].getName() == name){
                newSchoolBook[j] = schoolBooks[i];
                j++;
            }
        }
        return newSchoolBook.length != 0 ? newSchoolBook : new SchoolBook[]{};
    }

    @Override
    public boolean removeByName(String name) {
        return false;
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}
