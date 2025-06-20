package com.example.juan;

import com.example.juan.config.SalesforceProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Map;

@Component
public class SalesforceAuthUtil {

    private final SalesforceProperties props;

    public SalesforceAuthUtil(SalesforceProperties props) {
        this.props = props;
    }

    public String getAccessToken() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String body = "grant_type=password"
                + "&client_id=" + props.getClientId()
                + "&client_secret=" + props.getClientSecret()
                + "&username=" + props.getUsername()
                + "&password=" + props.getPassword();

        HttpEntity<String> request = new HttpEntity<>(body, headers);
        ResponseEntity<Map> response = restTemplate.exchange(props.getTokenUrl(), HttpMethod.POST, request, Map.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return (String) response.getBody().get("access_token");
        } else {
            throw new RuntimeException("Error al autenticar con Salesforce: " + response.getStatusCode());
        }
    }
}
