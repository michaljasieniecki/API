public class Waluta {

    public Waluta(double bid, double ask, double mid, String data, String nazwa, String code) {
        this.bid = bid;
        this.ask = ask;
        this.mid = mid;
        this.data = data;
        this.nazwa = nazwa;
        this.code = code;
    }

    private double bid;
    private double ask;
    private double mid;
    private String data;
    private String nazwa;
    private String code;

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }

    public double getMid() {
        return mid;
    }

    public String getData() {
        return data;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Waluta{" +
                "bid=" + bid +
                ", ask=" + ask +
                ", mid=" + mid +
                ", data='" + data + '\'' +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}

