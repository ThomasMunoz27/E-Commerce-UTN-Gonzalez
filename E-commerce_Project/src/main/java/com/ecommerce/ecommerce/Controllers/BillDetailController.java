package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.BillDetail;
import com.ecommerce.ecommerce.Services.BaseService;
import com.ecommerce.ecommerce.Services.BillDetailService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bill-detail")
public class BillDetailController extends BaseController<BillDetail>{

    public BillDetailController(BillDetailService billDetailService) {
        super(billDetailService);
    }
}
