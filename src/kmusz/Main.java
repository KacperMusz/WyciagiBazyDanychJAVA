package kmusz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Wyciag wyciag = new Wyciag();
////        Scanner scanner = new Scanner(System.in);
////
////        System.out.println("Wpisz numer biura:");
////        String numer = scanner.nextLine();
////
////        System.out.println("Wpisz job title:");
////        String zawod = scanner.nextLine();
////
////        wyciag.wykonajWyciag(numer, zawod);
////
////        scanner.close();

        WyciagCustomers customers = new WyciagCustomers();
        Scanner scanner = new Scanner(System.in);
        System.out.println("***CUSTOMER***");
        System.out.println("Podaj wyszukiwaną frazę (np. customerName, customerNumber, contactLastName lub contactFirstName):");
        String wyraz = scanner.nextLine();
        customers.wykonajWyciag(wyraz);

        WyciagEmployes employes = new WyciagEmployes();
        System.out.println("***EMPLOYES***");
        System.out.println("Podaj wyszukiwaną frazę (np. firstName, lastName, email lub employeeNumber):");
        String wyraz1 = scanner.nextLine();
        employes.wykonajWyciag(wyraz1);

        WyciagOffices offices = new WyciagOffices();
        System.out.println("***OFFICES***");
        System.out.println("Podaj wyszukiwaną frazę (np. city, country, officecode lub territory):");
        String wyraz2 = scanner.nextLine();
        offices.wykonajWyciag(wyraz2);



    }
}
