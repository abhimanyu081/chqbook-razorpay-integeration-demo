package com.chqbook.chqbookrazorpayintegerationdemo.service.razorpay;

import com.chqbook.chqbookrazorpayintegerationdemo.dto.OrderDto;
import com.chqbook.chqbookrazorpayintegerationdemo.exception.RazorPayException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

/****
 *
 *
 * @author - Abhimanyu
 *
 * This class interacts with the RazorPay Rest APIs
 *
 *
 */
@Service
public class RazorPayOrderServiceImpl implements RazorPayOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RazorPayOrderServiceImpl.class);

    private RestApiHelper restApiHelper;

    @Autowired
    public RazorPayOrderServiceImpl(RestApiHelper restApiHelper) {
        this.restApiHelper = restApiHelper;

    }

    @Override
    public OrderDto create(OrderDto orderDto) {
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(restApiHelper.getBaseUrl() + "orders");

            HttpEntity<OrderDto> request = new HttpEntity<OrderDto>(orderDto, restApiHelper.getHeaders(
                    restApiHelper.getApiKey(), restApiHelper.getApiKeySecret()));

            OrderDto apiResponse = restApiHelper.getRestTemplate().postForObject(builder.toUriString(),
                    request, OrderDto.class);

            LOGGER.info(apiResponse.toString());
            return apiResponse;


        } catch (RestClientException e) {
            LOGGER.error("Error while calling RazorPay order create API", e);
            throw new RazorPayException("Error while calling RazorPay order create API", e);
        }


    }


}
