package com.example.agriculture.Controller;

import com.example.agriculture.Endpoint.CreateMemberPaymentRest;
import com.example.agriculture.Model.MemberPayment;
import com.example.agriculture.service.PaymentService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/members/{id}/payments")
    @ResponseStatus(HttpStatus.CREATED)
    public List<MemberPayment> createPayments(
            @PathVariable String id,
            @RequestBody List<CreateMemberPaymentRest> payments
    ) {
        return paymentService.createPayments(id, payments);
    }
}