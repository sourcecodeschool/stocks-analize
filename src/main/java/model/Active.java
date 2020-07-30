package model;

import java.io.Serializable;
import java.util.HashMap;

public abstract class Active implements Serializable {

    private String fund; //фонд
    private Long id; // id нашего фонда
    private String sum; // сумма
    private Double rate = 0d; //ставка
    private Integer period;

    private HashMap<Long, Double> actives = new HashMap<>();

    public Active(String fund, Long id, String name, Double rate, Integer period) {
        this.fund = fund;
        this.id = id;
        this.sum = name;
        this.rate = rate;
        this.period = period;
        this.actives = actives;
    }

    public static void getSelectionModel() {

    }

    public String getFund() {
        return fund;
    }

    public Long getId() {
        return id;
    }

    public String getSum() {
        return sum;
    }

    public Double getRate() {
        return rate;
    }

    public Integer getPeriod() {
        return period;
    }

    public HashMap<Long, Double> getActives() {
        return actives;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Active)) return false;

        Active active = (Active) o;

        return this.id.equals(((Active) o).id);

    }

    @Override
    public int hashCode() {
        Integer result;
        Long temp;
        result = fund != null ? fund.hashCode() : 0;
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        temp = Double.doubleToLongBits(rate);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + period;
        return result;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public void setActives(HashMap<Long, Double> actives) {
        this.actives = actives;
    }

    @Override
    public String toString() {
        return "Active{" +
                "fund='" + fund + '\'' +
                ", id=" + id +
                ", name='" + sum + '\'' +
                ", rate=" + rate +
                ", period=" + period +
                ", actives=" + actives +
                '}';
    }

}

