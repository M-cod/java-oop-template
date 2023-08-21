package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;

import java.util.Arrays;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {
    private SchoolBook[] schoolBooks = new SchoolBook[]{};

    @Override
    public boolean save(SchoolBook book) {
        if (count() == 0) {
            schoolBooks = new SchoolBook[]{book};
        } else {
            schoolBooks = Arrays.copyOf(schoolBooks, count() + 1);
            schoolBooks[count() - 1] = book;
        }
        return true;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        boolean flag = false;
        SchoolBook[] newSchoolBook = new SchoolBook[count()];
        for (int i = 0, j = 0; i < count(); i++) {
            if (schoolBooks[i].getName() == name) {
                newSchoolBook[j] = schoolBooks[i];
                j++;
                flag = true;
            }
        }
        return flag ? newSchoolBook : new SchoolBook[]{};
    }

    @Override
    public boolean removeByName(String name) {
        if (findByName(name).length != 0) {
            SchoolBook[] newSchoolBook = Arrays.copyOf(schoolBooks, count());
            int count = 0;
            for (int i = 0; i < newSchoolBook.length; i++) {
                if (newSchoolBook[i].getName() == name) {
                    newSchoolBook[i] = null;
                    count++;
                }
            }
            schoolBooks = new SchoolBook[count() - count];
            for (int i = 0, j = 0; i < newSchoolBook.length; i++) {
                if (newSchoolBook[i] != null) {
                    schoolBooks[j] = newSchoolBook[i];
                    j++;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}
