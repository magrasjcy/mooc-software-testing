package tudelft.discount;

import tudelft.discountmocked.ProductDao;
public class DiscountApplier {

    private tudelft.discountmocked.ProductDao dao;

    public DiscountApplier (ProductDao dao) {
        this.dao = dao;
    }

    public void setNewPrices() {

        for(tudelft.discountmocked.Product product : dao.all()) {
            if(product.getCategory().equals("BUSINESS")) {
                product.setPrice(product.getPrice() * 0.9);
            }
            if(product.getCategory().equals("HOME")) {
                product.setPrice(product.getPrice() * 1.1);
            }
        }

    }
}
