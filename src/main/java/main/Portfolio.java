package main;

public class Portfolio {
    private Long id;
    private String name;
    private int numberOfPortfolio;

    public int getNumberOfPortfolio() {
        return numberOfPortfolio;
    }

    public void setNumberOfPortfolio(int numberOfPortfolio) {
        this.numberOfPortfolio = numberOfPortfolio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
