package repository;

import model.Portfolio;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public interface PortfolioRepository {
    void create(Portfolio portfolioList) throws IOException, ClassNotFoundException;
    Portfolio get(Long id) throws IOException, ClassNotFoundException;
    void update(Portfolio portfolioList) throws IOException;
    void delete(Portfolio portfilio) throws IOException;
    List<Portfolio> getPortfolioList() throws IOException;
}
