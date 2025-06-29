package com.example.demo.application.third_party;

import com.example.demo.application.third_party.simplize_service.response.SimplizeResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public abstract class BaseThirdPartyService {

    /* ────────────────────────────────────────────────────────────────────────── */
    /* ⬇︎ Configuration                                                         */
    /* ────────────────────────────────────────────────────────────────────────── */

    protected static final String HEADER_API_KEY    = "X_API_KEY";
    protected static final String HEADER_API_SECRET = "X_API_SECRET";
    protected static final String HEADER_REQUEST_ID = "X-Request-ID";

    protected final String baseUrl = "https://api2.simplize.vn";
    protected final String apiKey = "api-key";
    protected final String apiSecret =  "api-secret";

    protected final RestTemplate restTemplate;
    protected final ObjectMapper objectMapper;

    protected BaseThirdPartyService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    /* ────────────────────────────────────────────────────────────────────────── */
    /* ⬇︎ Generic REST helpers                                                  */
    /* ────────────────────────────────────────────────────────────────────────── */

    protected <R> Optional<R> get(String url, ParameterizedTypeReference<SimplizeResponse<R>> typeRef) {
        return exchange(url, HttpMethod.GET, null, typeRef);
    }

    protected <B, R> Optional<R> post(String url, B body, ParameterizedTypeReference<SimplizeResponse<R>> typeRef) {
        return exchange(url, HttpMethod.POST, body, typeRef);
    }

    protected <B, R> Optional<R> put(String url, B body, ParameterizedTypeReference<SimplizeResponse<R>> typeRef) {
        return exchange(url, HttpMethod.PUT, body, typeRef);
    }

    protected <R> Optional<R> delete(String url, ParameterizedTypeReference<SimplizeResponse<R>> typeRef) {
        return exchange(url, HttpMethod.DELETE, null, typeRef);
    }

    private <B, R> Optional<R> exchange(String url,
                                        HttpMethod method,
                                        B body,
                                        ParameterizedTypeReference<SimplizeResponse<R>> typeRef) {
        HttpEntity<B> entity = new HttpEntity<>(body, buildHeaders());
        try {
            ResponseEntity<SimplizeResponse<R>> response = restTemplate.exchange(url, method, entity, typeRef);
            return Optional.ofNullable(response.getBody()).map(SimplizeResponse::getData);
        } catch (HttpStatusCodeException ex) {
            handleError(ex);
            return Optional.empty();
        }
    }

    /* ────────────────────────────────────────────────────────────────────────── */
    /* ⬇︎ Error handling & headers                                             */
    /* ────────────────────────────────────────────────────────────────────────── */

    private HttpHeaders buildHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HEADER_REQUEST_ID, UUID.randomUUID().toString());
        headers.set(HEADER_API_KEY, apiKey);
        headers.set(HEADER_API_SECRET, apiSecret);
        return headers;
    }

    private void handleError(HttpStatusCodeException ex) {
        HttpStatus status = ex.getStatusCode();
        String body = ex.getResponseBodyAsString();
        log.warn("Simplize API -> {} {}\n{}", status.value(), status.getReasonPhrase(), body);

        if (status == HttpStatus.NOT_FOUND) {
            throw new ResourceNotFoundException("Simplize resource not found");
        }
        try {
            HashMap<?, ?> err = objectMapper.readValue(body, HashMap.class);
            log.debug("Simplize error payload parsed: {}", err);
        } catch (JsonProcessingException ignored) {
            // non‑critical – raw body already logged
        }
    }

    /* ────────────────────────────────────────────────────────────────────────── */
    /* ⬇︎ Domain‑specific exceptions                                            */
    /* ────────────────────────────────────────────────────────────────────────── */

    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

}
