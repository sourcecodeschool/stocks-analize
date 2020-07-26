package model;

public class Active {
   private String fund; //фонд
   private long id = System.currentTimeMillis(); // id нашего фонда
   private String name; // имя
   private double rate = 0; //ставка
   private int period;

    public Active(String fund, long id, String name, double rate, int period) {
        this.fund = fund;
        this.id = id;
        this.name = name;
        this.rate = rate;
        this.period = period;
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

    public int getPeriod() {
        return period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Active active = (Active) o;

        if (id != active.id) return false;
        if (Double.compare(active.rate, rate) != 0) return false;
        if (period != active.period) return false;
        if (!fund.equals(active.fund)) return false;
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
        result = 31 * result + period;
        return result;
    }


}
