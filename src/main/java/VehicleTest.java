public class VehicleTest {
    public static void main(String[] args) {
        //Zaimplementować inne pojazdy (wstępnie zrobione, jeżeli coś Wam nie pasuje to feel free żeby zmienić/poprawić (pamiętajcie o dziedziczeniu!!!!))
        //Przygotować exceptions (np. wypożyczenie pojazdu który jest już wypożyczony, zły type pojazdu, ujemna cena za godzinę itp.)
        //Zaimplementować sposób na wyszukiwanie pojazdów (dobrze byłoby mieć wstępną logikę tutaj, do FXa później się to podepnie)
        //Zmienić Arraye na listy - Imo to dosyć niezły pomysł, bo listy nie mają fixed pojemności, ale nie lubię się za mocno z listami - ktoś chętny się tym zająć?
        //Przygotować rysunek i zamysł do JavyFX (łatwiejsza opcja)
        //Przygotować JavęFX (trudniejsza opcja, o wiele łatwiej będzie z rysunkiem i pomysłem jak to ma wyglądać i działać)
        Car car1 = new Car("ICE", "Toyota", "crimson", "AB 12345", true, 150, 50);
        Car car2 = new Car("BEV", "Tesla", "black", "CD 67890", false, 0, 100);
        Car car3 = new Car("hybrid", "Toyota", "yellow", "EF 24680", false, 0, 75);
        Other motor1 = new Other("BEV", "Volkswagen", "black", "GH 13579", false, 0, 100, "motorcycle");
        Vehicle[] all = {car1, car2, car3, motor1};
    }
}
