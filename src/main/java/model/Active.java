package model;

import java.time.Month;
import java.time.Year;

public class Active {
    private String fund; //фонд
    private Long id = System.currentTimeMillis(); // id нашего фонда
    private String name; // имя
    private Double rate = 0d; //ставка

    enum duration {Month, Year}

    public Active(String fund, long id, String name, double rate, int period) {
        this.fund = fund;
        this.id = id;
        this.name = name;
        this.rate = rate;
    }


    public String getFund() {
        return fund;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Active active = (Active) o;

        return name.equals(active.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = fund.hashCode();
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        temp = Double.doubleToLongBits(rate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Active{" +
                "fund='" + fund + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }
}
