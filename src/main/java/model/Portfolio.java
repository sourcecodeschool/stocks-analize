package model;

import repository.EntityManager;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Portfolio  implements java.io.Serializable {

    private Long portfolioId;
    private String portfolioName;
    private Long date;
    private Map<Long, Double> investment;

    public Portfolio() {
        date = System.currentTimeMillis();
        investment = new HashMap<>();
    }

    public Portfolio(Long portfolioId, String portfolioName, Long date) {
        this.portfolioId = portfolioId;
        this.portfolioName = portfolioName;
        this.date = date;
    }

    public Long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getPortfolioName() {
        return portfolioName;
    }

    public void setPortfolioName(String portfolioName) {
        this.portfolioName = portfolioName;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Map<Long, Double> getInvestment() {
        return this.investment;
    }

    public void setInvestment(Long ActiveId, Double sum) {
        this.investment.put(ActiveId, sum);
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "portfolioId=" + portfolioId +
                ", portfolioName='" + portfolioName + '\'' +
                ", date=" + date +
                ", investment=" + investment +
                '}';
    }
}
