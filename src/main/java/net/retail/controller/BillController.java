package net.retail.controller;

import net.retail.model.Request;
import net.retail.model.Response;
import net.retail.util.BillUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillController {

    @Autowired
    BillUtil billUtil;

    @RequestMapping(value = "/getNetAmount", method = RequestMethod.POST)
    public Response getNetAmount(@RequestBody Request request){
        System.out.println(request.getCustomer().getCustomerName());
        return billUtil.getNetAmount(request);

    }

}
