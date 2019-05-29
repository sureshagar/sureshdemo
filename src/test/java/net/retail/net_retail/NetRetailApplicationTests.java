package net.retail.net_retail;

import net.retail.model.Customer;
import net.retail.model.Product;
import net.retail.model.Request;
import net.retail.model.Response;
import net.retail.util.BillUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NetRetailApplicationTests {

	@Autowired
	private BillUtil billUtil;

	@Test
	public void getNetAmount() {

		Customer c = new Customer();
		Product p = new Product();
		Product p1 = new Product();

		Request rs = new Request();
		List<Product> products= new ArrayList<Product>();

		c.setCustomerName("suresh");
		c.setIsEmployee(false);
		c.setIsAffliate(true);
		c.setCustomerSince(new Date());


		p.setGroceries(true);
		p.setProductName("atta");
		p.setUnitPrice(1);
		p.setUnits(20);


		p1.setGroceries(true);
		p1.setProductName("atttatat");
		p1.setUnitPrice(1);
		p1.setUnits(20);

		products.add(p1);
		products.add(p);
		rs.setCustomer(c);
		rs.setProducts(products);
		Response testres = billUtil.getNetAmount(rs);

		assert (testres.getBillTotal() == 40);

	}


}
