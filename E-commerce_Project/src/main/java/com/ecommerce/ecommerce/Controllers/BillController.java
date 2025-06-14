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

    @PutMapping("/confirm/{preferenceId}")
    public ResponseEntity<?> confirmBill(@PathVariable String preferenceId){
        Bill bill = billRepository.findByPreferenceId(preferenceId);

        if (bill == null){
            return ResponseEntity.status(404).body("Factura no encontrada");
        }

        bill.setConfirmed(true);
        billRepository.save(bill);

        return ResponseEntity.ok("Factura Confirmada");
    }

    @GetMapping("/confirm/{preferenceId}")
    public ResponseEntity<Bill> getBillByPreferenceId(@PathVariable String preferenceId){
        Bill bill = billRepository.findByPreferenceId(preferenceId);
        if (bill == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bill);
    }
}
