package com.lsalmeida.springshellgpt.config;

import com.lsalmeida.springshellgpt.client.GptClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public GptClient gptClient() {
        WebClient client = WebClient.builder()
                .baseUrl("https://url.com.gpt")
                .defaultHeader("Accept", "application/json")
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client))
                .build();

        return factory.createClient(GptClient.class);
    }
}
