package repository;

import model.Portfolio;
import java.io.*;

public interface PortfolioRepository {
    void create(Portfolio portfolio) throws IOException;
    Portfolio get(Long id) throws IOException, ClassNotFoundException;
    void update(Portfolio portfolio) throws IOException;
    void delete(Portfolio portfolio) throws IOException;
}
