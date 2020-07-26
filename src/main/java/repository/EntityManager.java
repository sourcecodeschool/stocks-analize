package repository;

import model.Portfolio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EntityManager implements Serializable {
    private static EntityManager entityManager;
    public static EntityManager getInstance() {
        if (entityManager == null) {
            entityManager = new EntityManager();
        }
        return entityManager;
    }

    public EntityManager() {
        portfolioRepository = PortfolioRepositoryImpl.getInstance();
    }
    static PortfolioRepository portfolioRepository;

    public void createPortfolio(Portfolio portfolio) {
        try {
            portfolioRepository.create(portfolio);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Portfolio get (Long portfolioId){
        Portfolio portfolio = null;
        try {
            portfolio = portfolioRepository.get(portfolioId);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return portfolio;
    }

    public List<Portfolio> getPortfolioList (){
        List<Portfolio> portfolioList = new ArrayList<>();
        try {
            portfolioList = portfolioRepository.getPortfolioList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return portfolioList;
    }
    public void update(Portfolio portfolio){
        try {
            portfolioRepository.update(portfolio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(Portfolio portfolio){
        try {
            portfolioRepository.delete(portfolio);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}