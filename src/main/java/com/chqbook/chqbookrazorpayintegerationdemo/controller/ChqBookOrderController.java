package com.chqbook.chqbookrazorpayintegerationdemo.controller;

import com.chqbook.chqbookrazorpayintegerationdemo.dto.OrderDto;
import com.chqbook.chqbookrazorpayintegerationdemo.entity.ChqBookOrder;
import com.chqbook.chqbookrazorpayintegerationdemo.service.ChqBookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class ChqBookOrderController {

    private ChqBookOrderService chqBookOrderService;

    @Autowired
    public ChqBookOrderController(ChqBookOrderService chqBookOrderService) {
        this.chqBookOrderService = chqBookOrderService;
    }

    @PostMapping
    public ChqBookOrder create(@RequestBody OrderDto chqBookOrderDto) {
        // throw new RuntimeException("API ERROR");

        return chqBookOrderService.create(chqBookOrderDto);
    }


    /***
     *
     * @param razorpayOrderId
     * @param razorpayPaymentId
     * @return
     */
    @PutMapping(path="/{razorpayorderid}/payment/{razorpaypaymentid}")
    public ChqBookOrder updatePayment(@PathVariable("razorpayorderid") String razorpayOrderId,
                                      @PathVariable("razorpaypaymentid") String razorpayPaymentId) {
        // throw new RuntimeException("API ERROR");
        //TODO check api in postman, then call in JS code
        //if all done check refund code
        //simulate double payment
        return chqBookOrderService.updatePayment(razorpayOrderId,razorpayPaymentId);
    }

    @GetMapping("/{id}")
    public ChqBookOrder findById(@PathVariable Long id) {
        return chqBookOrderService.findById(id);
    }

}
