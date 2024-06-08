package com.example.rentalsoftware;

import java.util.LinkedList;
import java.util.List;
public class VehicleTest {
    public static void main(String[] args) {
        //Zaimplementować inne pojazdy (wstępnie zrobione, jeżeli coś Wam nie pasuje to feel free żeby zmienić/poprawić (pamiętajcie o dziedziczeniu!!!!))
        //Przygotować exceptions (np. wypożyczenie pojazdu który jest już wypożyczony, zły type pojazdu, ujemna cena za godzinę itp.)
        //Zaimplementować sposób na wyszukiwanie pojazdów (dobrze byłoby mieć wstępną logikę tutaj, do FXa później się to podepnie)
        //Zmienić Arraye na listy - Imo to dosyć niezły pomysł, bo listy nie mają fixed pojemności, ale nie lubię się za mocno z listami - ktoś chętny się tym zająć?
        //Przygotować rysunek i zamysł do JavyFX (łatwiejsza opcja)
        //Przygotować JavęFX (trudniejsza opcja, o wiele łatwiej będzie z rysunkiem i pomysłem jak to ma wyglądać i działać)
        Car car1 = new Car("ICE", "Toyota", "crimson", "AB 12345", true, 1, 10);
        Car car2 = new Car("BEV", "Tesla", "black", "CD 67890", true, 4, 15);
        Car car3 = new Car("hybrid", "Toyota", "yellow", "EF 24680", false, 0, 7);
        OtherVehicles motor1 = new OtherVehicles("BEV", "Volkswagen", "black", "GH 13579", false, 0, 10, "motorcycle");
        Vehicle[] all = {car1, car2, car3, motor1};


        User user1 = new User("Jacek", "Bębniarz", List.of(car1, car2));
        user1.getVehicles().get(0).setRented(true);
        user1.getVehicles().get(1).setRented(true);
        System.out.println(invoiceGenerator(returnList(user1.getVehicles().toArray(new Vehicle[0])), user1.getName(), user1.getSurname()));
    }
    public static void printAll(Vehicle[] all) {
        for (Vehicle vehicle : all) {
            System.out.println(vehicle);
        }
    }

    //INVOICE
    /// W tej części plan jest taki żeby można było zwracać samochody - z obiektów typu return będzie można stworzyć Invoice
    public static List<Return> returnList(Vehicle[] all) {
        List<Return> returns = new LinkedList<>();
        for (Vehicle vehicle : all) {
            if (vehicle.isRented()) {
                returns.add(vehicle.invoice());
            }
        }
        return returns;
    }
    public static String invoiceGenerator(List<Return> returns, String name, String surname){
        StringBuilder invoice = new StringBuilder();
        double total = 0;
        for (Return aReturn : returns) {
            total += aReturn.getTotalAmount();
            invoice.append(aReturn);
            invoice.append("\n");
        }
        return "Invoice for " + name + " " + surname + " is: \n"+ invoice.toString() + "Total amount: " + total + "PLN";
    }
}
