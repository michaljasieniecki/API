import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import java.io.IOException;
import java.util.Objects;

public class Pobieranie {
    public Pobieranie() {

    }
    public Waluta pobierz(String tag) throws ParseException {
        return pobierzData(tag,"");
    }
    public Waluta pobierz(String tag, String data) throws ParseException {
        return pobierzData(tag, data);
    }
    private Waluta pobierzData(String tag, String data) throws ParseException {
        double bid = 0;
        double ask = 0;
        double mid = 0;
        String nazwa = null;
        String date = null;
        String code = null;
        try {
            String url1 = "http://api.nbp.pl/api/exchangerates/rates/c/" + tag + "/" + data + "/?format=json";
            JSONObject objectC = parsownik(Objects.requireNonNull(pobierzStrone(url1)));
            JSONObject ratesC = parsownik(parsowniczek(objectC.get("rates").toString()).get(0).toString());
            bid = Double.parseDouble(ratesC.get("bid").toString());
            ask = Double.parseDouble(ratesC.get("ask").toString());
        } catch (ParseException e){
        }

        try {
            String url2 = "http://api.nbp.pl/api/exchangerates/rates/a/" + tag + "/" + data + "/?format=json";
            JSONObject objectA = parsownik(Objects.requireNonNull(pobierzStrone(url2)));
            JSONObject ratesA = parsownik(parsowniczek(objectA.get("rates").toString()).get(0).toString());
            mid = Double.parseDouble(ratesA.get("mid").toString());
            nazwa = objectA.get("currency").toString();
            date = ratesA.get("effectiveDate").toString();
            code = objectA.get("code").toString();
        }catch (ParseException e){
            try {
                String url2 = "http://api.nbp.pl/api/exchangerates/rates/b/" + tag + "/" + data + "/?format=json";
                JSONObject objectA = parsownik(Objects.requireNonNull(pobierzStrone(url2)));
                JSONObject ratesA = parsownik(parsowniczek(objectA.get("rates").toString()).get(0).toString());
                mid = Double.parseDouble(ratesA.get("mid").toString());
                nazwa = objectA.get("currency").toString();
                date = ratesA.get("effectiveDate").toString();
            } catch (ParseException i) {
                System.out.println("Błędna waluta");
                return null;
            }
        }

        return new Waluta(bid,ask,mid,
                date,
                nazwa,
               code
                );
    }
    private static String pobierzStrone(String url){
        try {
            return Jsoup.connect(url).ignoreContentType(true).get().text();
        }catch (NullPointerException | IOException e){
            e.printStackTrace();
        }
        return null;

    }
    private JSONObject parsownik(String s) throws ParseException {
        return(JSONObject) new JSONParser().parse(s);
    }
    private JSONArray parsowniczek(String s) throws ParseException {
        return(JSONArray) new JSONParser().parse(s);
    }
}
