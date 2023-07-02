package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book headFirst = new Book();
        headFirst.setName("Head First Java");
        headFirst.setNubmerOfPages(720);

        Book effectiveJava = new Book();
        effectiveJava.setName("Effective Java");
        effectiveJava.setNubmerOfPages(466);

        Book designPattern = new Book();
        designPattern.setName("Design Patterns");
        designPattern.setNubmerOfPages(657);

        Book cleanCode = new Book();
        cleanCode.setName("Clean Code");
        cleanCode.setNubmerOfPages(464);

        Book[] books = new Book[4];
        books[0] = headFirst;
        books[1] = effectiveJava;
        books[2] = designPattern;
        books[3] = cleanCode;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " " + books[i].getNubmerOfPages());
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " " + books[i].getNubmerOfPages());
        }

        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean Code")) {
                System.out.println(books[i].getName() + " " + books[i].getNubmerOfPages());
            }
        }
    }
}
