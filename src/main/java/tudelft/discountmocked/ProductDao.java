package tudelft.discountmocked;

import tudelft.discountmocked.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private static Connection c;

    public ProductDao() {
        try {
            if (c != null) return;

            c = DriverManager.getConnection("jdbc:hsqldb:file:mymemdb.db", "SA", "");
            c.prepareStatement("create table product (name varchar(100), price double), category varchar(24))").execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> all() {

        List<Product> allProducts = new ArrayList<>();

        try {
            PreparedStatement ps = c.prepareStatement("select * from product");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                double value = rs.getDouble("value");
                String category = rs.getString("category");
                allProducts.add(new Product(name, value, category));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            return allProducts;
        }

    }

    public void save(Product inv) {
        try {
            PreparedStatement ps = c.prepareStatement("insert into product (name, value, category) values (?,?)");
            ps.setString(1, inv.getName());
            ps.setDouble(2, inv.getPrice());
            ps.setString(3, inv.getCategory());
            ps.execute();

            c.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            c.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
