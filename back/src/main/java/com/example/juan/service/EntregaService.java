package com.example.juan.service;

import com.example.juan.SalesforceAuthUtil;
import com.example.juan.dto.EntregaRequest;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class EntregaService {

    private final SalesforceAuthUtil authUtil;

    public EntregaService(SalesforceAuthUtil authUtil) {
        this.authUtil = authUtil;
    }

    private static final String INSTANCE_URL = "INSTANCE_URL";
    private static final String ENTREGA_ENDPOINT = "ENTREGA_ENDPOINT";
    private static final String QUERY_ENDPOINT = "QUERY_ENDPOINT";

    // Crear Entrega
    public String crearEntrega(EntregaRequest entrega) {
        String token = authUtil.getAccessToken();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("Cliente__c", entrega.getClienteId());
        body.put("Estado__c", entrega.getEstado());
        body.put("Fecha_de_entrega__c", entrega.getFechaEntrega());

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(INSTANCE_URL + ENTREGA_ENDPOINT, request,
                String.class);

        return response.getBody();
    }

    // Consultar Entregas De Un Cliente Especifico
    public String consultarEntregasPorCliente(String clienteId) {
        String token = authUtil.getAccessToken();
        RestTemplate restTemplate = new RestTemplate();
        String soql = String.format(
                "SELECT Id, Name, Estado__c, Fecha_de_entrega__c FROM Entrega__c WHERE Cliente__c = '%s'",
                clienteId);

        String url = INSTANCE_URL + QUERY_ENDPOINT + soql;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);

        return response.getBody();
    }

    // Actualizar Estado Entrega
    public String actualizarEstadoEntrega(String entregaId, EntregaRequest entrega) {
        String token = authUtil.getAccessToken();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory(httpClient));

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = new HashMap<>();
        body.put("Estado__c", entrega.getEstado());

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        String url = INSTANCE_URL + ENTREGA_ENDPOINT + "/" + entregaId;
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.PATCH,
                request,
                String.class);

        return response.getBody();
    }

}