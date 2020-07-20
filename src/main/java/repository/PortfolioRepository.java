package repository;

import model.Portfolio;
import java.io.*;

public interface PortfolioRepository {
    void create(Portfolio portfolioList) throws IOException;
    Portfolio get(Long id) throws IOException, ClassNotFoundException;
    void update(Portfolio portfolioList) throws IOException;
    void delete(Portfolio portfilio) throws IOException;
}
