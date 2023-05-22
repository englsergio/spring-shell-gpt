package com.lsalmeida.springshellgpt.commands;

import com.lsalmeida.springshellgpt.client.GptClient;
import com.lsalmeida.springshellgpt.model.GptResponse;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class GptCommand {

    private final GptClient gptClient;

    public GptCommand(GptClient gptClient) {
        this.gptClient = gptClient;
    }

    @ShellMethod(key = "gpt", value = "ask a question...")
    public String askGpt(@ShellOption String question) {
        GptResponse response = gptClient.sendPrompt();
        return "your question was: " + question + response;
    }
}
