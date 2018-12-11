package tudelft.discountmocked;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import tudelft.discountmocked.DiscountApplier;
import tudelft.discountmocked.ProductDao;
import tudelft.discountmocked.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiscountApplierTest {
    private static Connection c;
    @Test
    public void businessTest (){

        tudelft.discountmocked.ProductDao dao= new ProductDao();
        tudelft.discountmocked.DiscountApplier update ;
        List<Product> all=new ArrayList<>();
        tudelft.discountmocked.Product bluesuedeshoe = new Product("Blue shoe", 25.00, "BUSINESS");
        tudelft.discountmocked.Product redslippers   = new Product( "ruby slippers", 45.0, "BUSINESS");
        tudelft.discountmocked.Product reddress      = new Product( "red dress", 75.00, "HOME");

        dao.save(bluesuedeshoe);
        dao.save(redslippers);
        dao.save(reddress);
        try {
            PreparedStatement ps = c.prepareStatement("select * from products");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                String name = rs.getString("name");
                double value = rs.getDouble("value");
                String category = rs.getString("category");
                all.add(new Product(name, value,category));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        update=new DiscountApplier(dao);
        update.setNewPrices();

        dao.close();
        int i;
        for (i=0;i< all.size();i++) {
            Product x=all.get(i);

            if (x.getCategory() == "BUSINESS" && x.getName() == "ruby slippers") {
                Assertions.assertEquals(45 * 1.1, x.getPrice());
            }
            else if (x.getCategory() == "BUSINESS" && x.getName() == "Blue shoe") {
                Assertions.assertEquals(25 * 1.1, x.getPrice());
            } else if (x.getCategory() == "HOME" && x.getName() == "red dress") {
                Assertions.assertEquals(75 * 0.9, x.getPrice());
            }
        }

    }

}
