package main;
import model.Bags;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EntityManager implements Serializable {
    //список портфелей

    public void GetBagsList() {

// Попытка работать с файлом данных как с текстовым файлом
//    Bags.Bags bagList[] = new Bags.Bags[3];{
//        try {
//            InputStream is = new FileInputStream(Bags.Bags.pathPrefix + Bags.Bags.pathTo);
//            BufferedInputStream bis = new BufferedInputStream(is, 100_000);
//            ObjectInputStream ois = new ObjectInputStream(bis);
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 4; j++) {
//                    String line = Files.readAllLines(Paths.get(Bags.Bags.pathPrefix + Bags.Bags.pathTo)).get(j);
//                    Files.readAllLines(Paths.get(Bags.Bags.pathPrefix + Bags.Bags.pathTo)).get(j);
//                }
//                bagList[i] = (Bags.Bags) ois.readObject();
//                System.out.println(bagList[i].getPortfolioName().toString());
//            };}
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }}}
//список активов
//нужен для сохранения в репозиторий
    }
}