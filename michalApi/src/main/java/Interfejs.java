import org.json.simple.parser.ParseException;

import java.util.Scanner;

public class Interfejs {
    private final Pobieranie pobieranie = new Pobieranie();
    private final Scanner skaner = new Scanner(System.in);

    public Interfejs() throws ParseException {
        start();
    }

    public void start() throws ParseException {
        while (true) {
            System.out.println("""
                    Walutometr:
                    Opcje:
                    1.Pobierz informacje
                    2.Obsługiwane waluty
                    3.Zestawienie
                    Inna cyfra. Wyjście
                    _________________________________
                    """);
            int wybor = skaner.nextInt();
            if(wybor == 1){
                opcja1();
            }
            else if(wybor == 2){
                opcja2();
            }
            else if(wybor == 3){
                opcja3();
            }
            else{
                break;
            }
        }
    }
    public void opcja1() throws ParseException {
        while (true) {
            System.out.println("""
                    Opcje:
                    1.Pobierz aktualne informacje
                    2.Pobierz informacje po dacie
                    3.Cofnij
                    _________________________________
                    """);
            int wybor = skaner.nextInt();
            if(wybor == 1){
                System.out.print("""
                    Wpisz kod waluty: 
                    """);
                String waluta = skaner.next();
                Waluta nazwa = pobieranie.pobierz(waluta);
                System.out.printf("""
                        Informacje o walucie: %s
                        Kod: %s
                        Data: %s
                        Cena kupna: %s
                        Cena sprzedaży: %s
                        Średnia cena: %s
                        _________________________________
                        """,
                        nazwa.getNazwa(), nazwa.getCode(), nazwa.getData(), nazwa.getBid(), nazwa.getAsk(), nazwa.getMid()
                        );
                break;
            }
            else if(wybor == 2) {
                System.out.print("""
                        Wpisz kod waluty: 
                        """);
                String waluta = skaner.next();
                System.out.print("""
                        Wpisz datę (format: rok-miesiąc-dzień): 
                        """);
                String data = skaner.next();

                Waluta nazwa = pobieranie.pobierz(waluta, data);
                System.out.printf("""
                                Informacje o walucie: %s
                                Kod: %s
                                Data: %s
                                Cena kupna: %s
                                Cena sprzedaży: %s
                                Średnia cena: %s
                                _________________________________
                                """,
                        nazwa.getNazwa(), nazwa.getCode(), nazwa.getData(), nazwa.getBid(), nazwa.getAsk(), nazwa.getMid()
                );
                break;
            }
            else if(wybor == 3){
                break;
            }
        }
    }
    public void opcja2(){
        System.out.println("""
                Obsługiwane waluty:
                GBP - Funt brytyjski
                EUR - Euro
                USD - US Dollar
                """);
    }
    public void opcja3() throws ParseException {
        while (true) {
            System.out.println("""
                    Opcje:
                    1.Pobierz aktualne informacje o zestawieniu
                    2.Pobierz informacje o zestawieniu po dacie
                    3.Cofnij
                    _________________________________
                    """);
            int wybor = skaner.nextInt();
            if(wybor == 1){
                System.out.print("""
                    Wpisz kod pierwszej waluty: 
                    """);
                String waluta = skaner.next();
                Waluta nazwa = pobieranie.pobierz(waluta);
                System.out.print("""
                    Wpisz kod drugiej waluty: 
                    """);
                String waluta2 = skaner.next();
                Waluta nazwa2 = pobieranie.pobierz(waluta2);
                System.out.printf("""
                        Porównanie walut: %s i %s
                        Kod: %s | %s
                        Data: %s 
                        Cena kupna: %s | %s
                        Cena sprzedaży: %s | %s
                        Średnia cena: %s | %s
                        _________________________________
                        """,
                        nazwa.getNazwa(), nazwa2.getNazwa(),
                        nazwa.getCode(), nazwa2.getCode(),
                        nazwa.getData(),
                        nazwa.getBid(), nazwa2.getBid(),
                        nazwa.getAsk(), nazwa2.getAsk(),
                        nazwa.getMid(), nazwa2.getMid()
                );
                break;
            }
            else if(wybor == 2) {
                System.out.print("""
                    Wpisz kod pierwszej waluty: 
                    """);
                String waluta = skaner.next();

                System.out.print("""
                    Wpisz kod drugiej waluty: 
                    """);
                String waluta2 = skaner.next();

                System.out.print("""
                        Wpisz datę (format: rok-miesiąc-dzień): 
                        """);
                String data = skaner.next();

                Waluta nazwa = pobieranie.pobierz(waluta, data);
                Waluta nazwa2 = pobieranie.pobierz(waluta2, data);
                System.out.printf("""
                        Porównanie walut: %s i %s
                        Kod: %s | %s
                        Data: %s 
                        Cena kupna: %s | %s
                        Cena sprzedaży: %s | %s
                        Średnia cena: %s | %s
                        _________________________________
                        """,
                        nazwa.getNazwa(), nazwa2.getNazwa(),
                        nazwa.getCode(), nazwa2.getCode(),
                        nazwa.getData(),
                        nazwa.getBid(), nazwa2.getBid(),
                        nazwa.getAsk(), nazwa2.getAsk(),
                        nazwa.getMid(), nazwa2.getMid()
                );
                break;
            }
            else if(wybor == 3){
                break;
            }
        }
    }

}
