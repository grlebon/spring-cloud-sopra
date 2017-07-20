package com.sopra.cloud.erp.reception.controller;

import com.sopra.cloud.erp.reception.model.Reception;
import com.sopra.cloud.erp.reception.service.ServiceReception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reception")
public class ReceptionController {

    @Autowired
    private ServiceReception serviceReception;

    @GetMapping(value = "/{receptionId}")
    @ResponseBody
    public Reception getReception(@PathVariable long receptionId) {
        return serviceReception.getReception(receptionId);
    }

    @GetMapping
    @ResponseBody
    public List<Reception> getReceptions()
    {
        return serviceReception.getAllReceptions();
    }

    @PostMapping
    @ResponseBody
    public Reception newReception(@RequestParam(value = "purchaseOrderId") long purchaseOrderId, @RequestParam(value = "productId") long productId) {
        return serviceReception.newReceptionForPurshaseOrder(purchaseOrderId,productId);
    }

}
