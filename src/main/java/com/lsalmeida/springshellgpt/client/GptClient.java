package com.lsalmeida.springshellgpt.client;

import com.lsalmeida.springshellgpt.model.GptResponse;
import org.springframework.web.service.annotation.GetExchange;

public interface GptClient {

    @GetExchange("/")
    GptResponse sendPrompt();
}
