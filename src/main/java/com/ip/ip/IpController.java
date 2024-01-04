package com.ip.ip;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/get-ip")
public class IpController {

    private final WebClient webClient;

    public IpController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.ipify.org").build();
    }

    @GetMapping("/current")
    public Mono<IpResponse> getCurrentIp() {
        return webClient.get()
                .uri("/?format=json")
                .header("Accept", "application/json")  // Specify the Accept header
                .retrieve()
                .bodyToMono(IpResponse.class)
                .onErrorReturn(new IpResponse());  // Provide a default response in case of error
    }
}