package com.example.juan.service;

import com.example.juan.SalesforceAuthUtil;
import com.example.juan.dto.ClienteRequest;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService {

    private final SalesforceAuthUtil authUtil;

    public ClienteService(SalesforceAuthUtil authUtil) {
        this.authUtil = authUtil;
    }

    private static final String INSTANCE_URL = "INSTANCE_URL";
    private static final String CLIENTE_ENDPOINT = "CLIENTE_ENDPOINT";
    private static final String QUERY_ENDPOINT = "QUERY_ENDPOINT";

    // Crear cliente
    public String crearCliente(ClienteRequest cliente) {
        String token = authUtil.getAccessToken();
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> body = new HashMap<>();
        body.put("Name", cliente.getNombre());
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(INSTANCE_URL + CLIENTE_ENDPOINT, request,
                String.class);

        return response.getBody();
    }

    // Consultar Clientes
    public String consultarClientes() {
        String token = authUtil.getAccessToken();
        RestTemplate restTemplate = new RestTemplate();
        String soql = "SELECT Id, Name FROM Cliente__c";
        String url = INSTANCE_URL + QUERY_ENDPOINT + soql;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        return response.getBody();
    }
}
