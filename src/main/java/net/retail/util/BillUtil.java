package net.retail.util;

import net.retail.model.Customer;
import net.retail.model.Product;
import net.retail.model.Request;
import net.retail.model.Response;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BillUtil {

    public Response getNetAmount(Request request){
        Response response = new Response();
        List<Product> products = request.getProducts();
        Customer customer = request.getCustomer();
        double netAmount=0;

        for(Product product: products){
            boolean discountApplied=false;
            double productTotal=product.getUnitPrice()*product.getUnits();
            if(!product.isGroceries()){
                if(customer.getIsEmployee() || customer.getIsAffliate()){
                    if(customer.getIsEmployee()){
                        productTotal-=getPercentage(productTotal,30.0f);
                    }
                    else {
                        productTotal-=getPercentage(productTotal,10.0f);
                    }
                    discountApplied = true;
                }
                else if(!discountApplied){
                    LocalDate currentDate = LocalDate.now();
                    Date twoYearsOldDate = Date.from(currentDate.minusYears(2).atStartOfDay(ZoneId.systemDefault()).toInstant());
                    if(customer.getCustomerSince().before(twoYearsOldDate)){
                        productTotal-=getPercentage(productTotal,5.0f);
                    }
                }

            }
            netAmount+=productTotal;
        }

        int hunderds=(int)netAmount/100;
        if(hunderds>1)
        netAmount-=hunderds*5;

        response.setBillTotal((double) Math.round(netAmount * 100) / 100);
        response.setDate(new Date());
        return response;
    }

    private double getPercentage(double value, float percentage){
        return (value*(percentage/100.0f));
    }
}
