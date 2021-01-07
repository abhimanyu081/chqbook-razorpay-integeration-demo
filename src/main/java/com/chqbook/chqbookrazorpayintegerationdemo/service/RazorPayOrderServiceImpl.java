package com.chqbook.chqbookrazorpayintegerationdemo.service;

import com.chqbook.chqbookrazorpayintegerationdemo.dto.RazorPayOrderDto;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class RazorPayOrderServiceImpl implements RazorPayOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RazorPayOrderServiceImpl.class);

    @Value("${RAZORPAY_BASE_URL}")
    private String baseUrl;

    @Value("${RAZORPAY_API_KEY_ID}")
    private String apiKey;

    @Value("${RAZORPAY_API_KEY_SECRET}")
    private  String apiKeySecret;

    private RestTemplate restTemplate;


    @Autowired
    public RazorPayOrderServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    public static HttpHeaders getHeaders(String userName, String password) {
        String plainCreds = userName + ":" + password;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        // headers.add("X-Shopify-Access-Token", "55bfd0cabc651f2b64d20a974d8aab36");
        return headers;
    }

    @Override
    public RazorPayOrderDto create(RazorPayOrderDto razorPayOrderDto) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(getBaseUrl() + "orders");

        HttpEntity<RazorPayOrderDto> request = new HttpEntity<RazorPayOrderDto>(razorPayOrderDto,getHeaders(
                getApiKey(), getApiKeySecret()));

        RazorPayOrderDto apiResponse = restTemplate.postForObject(builder.toUriString(),
                request, RazorPayOrderDto.class);


        LOGGER.info(apiResponse.toString());
        return apiResponse;
    }



    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKeySecret() {
        return apiKeySecret;
    }

    public void setApiKeySecret(String apiKeySecret) {
        this.apiKeySecret = apiKeySecret;
    }
}
