package com.ecommerce.ecommerce.Controllers;

import com.ecommerce.ecommerce.Entities.Bill;
import com.ecommerce.ecommerce.Entities.BillDetail;
import com.ecommerce.ecommerce.Repositories.BillRepository;
import com.ecommerce.ecommerce.Services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/bill")
public class BillController extends BaseController<Bill>{



    @Autowired
    private BillRepository billRepository;

    public BillController(BillService billService){
        super(billService);
    }

    @Override
    @PostMapping
    public ResponseEntity<Bill> create(@RequestBody Bill bill){
        if(bill.getDetails() != null){
            for (BillDetail detail : bill.getDetails()){
                detail.setBill(bill);
            }
        }
        Bill savedBill = billRepository.save(bill);
        return ResponseEntity.status(201).body(savedBill);
    }
}
