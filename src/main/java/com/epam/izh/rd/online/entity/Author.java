package com.epam.izh.rd.online.entity;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Класс содержащий информацию об авторе.
 *
 * Необходимо:
 * 1) Создать список полей с указанными типами ровно в этом порядке:
 * - name с типом String и приватным модификатором доступа
 * - lastName с типом String и приватным модификатором доступа
 * - birthdate с типом LocalDate и приватным модификатором доступа
 * - country с типом String и приватным модификатором доступа
 * 2) Создать дефолтный конструктор (без параметров) (не забывайте alt+inset)
 * 3) Создать конструктор со всеми параметрами (в том порядке в котором перечислены) (не забывайте alt+inset)
 * 4) Создать геттеры и сеттеры (не забывайте alt+inset)
 * 5) Переопределить методы equals и hashCode - используйте генерацию (не забывайте alt+inset)
 * 6) Переопределить метод toString с выводом всех полей (не забывайте alt+inset)
 */
public class Author {
    private String name;
    private String lastName;
    private LocalDate birthdate;
    private String country;

    public Author() {
    }

    public Author(String name, String lastName, LocalDate birthdate, String country) {
        this.name = name;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(lastName, author.lastName) && Objects.equals(birthdate, author.birthdate) && Objects.equals(country, author.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, birthdate, country);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", country='" + country + '\'' +
                '}';
    }
}
