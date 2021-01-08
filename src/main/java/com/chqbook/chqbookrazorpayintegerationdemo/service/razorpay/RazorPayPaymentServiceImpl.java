package com.chqbook.chqbookrazorpayintegerationdemo.service.razorpay;

import com.chqbook.chqbookrazorpayintegerationdemo.dto.OrderDto;
import com.chqbook.chqbookrazorpayintegerationdemo.dto.RazorPayPaymentDto;
import com.chqbook.chqbookrazorpayintegerationdemo.exception.RazorPayException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RazorPayPaymentServiceImpl implements RazorPayPaymentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RazorPayPaymentServiceImpl.class);

    private RestApiHelper restApiHelper;

    @Autowired
    public RazorPayPaymentServiceImpl(RestApiHelper restApiHelper) {
        this.restApiHelper = restApiHelper;

    }

    @Override
    public RazorPayPaymentDto fetchPaymentById(String paymentId) {

        try {
            String url = restApiHelper.getBaseUrl()+"/payments/" + paymentId;

            HttpEntity<OrderDto> request = new HttpEntity<OrderDto>(restApiHelper.getHeaders(
                    restApiHelper.getApiKey(), restApiHelper.getApiKeySecret()));

            ResponseEntity<RazorPayPaymentDto> response = restApiHelper.getRestTemplate().exchange(
                    url, HttpMethod.GET, request, RazorPayPaymentDto.class);

            return response.getBody();
        } catch (Exception e) {
            LOGGER.error("Error while calling RazorPay Payment Fetch API for id : {}", paymentId, e);
            throw new RazorPayException("Error while calling RazorPay order create API", e);

        }

    }


}
