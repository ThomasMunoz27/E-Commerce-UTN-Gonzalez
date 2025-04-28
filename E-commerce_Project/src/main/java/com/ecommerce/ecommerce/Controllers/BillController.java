package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Bill;
import com.ecommerce.ecommerce.Services.BillService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bill")
public class BillController extends BaseController<Bill>{

    public BillController(BillService billService){
        super(billService);
    }
}
