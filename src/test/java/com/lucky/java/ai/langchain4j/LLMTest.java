package com.lucky.java.ai.langchain4j;

import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LLMTest {
    /**
     * gpt-4o-mini接入测试
     */
    @Test
    public void testGPTDemo(){
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();
        String answer = model.chat("你好，你是？");
        System.out.println(answer);
    }

    /**
     * springboot
     */
    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testSpringBoot(){
        String answer = openAiChatModel.chat("你好，我是谁");
        System.out.println(answer);
    }

    /**
     * ollama接入
     */
    @Autowired
    private OllamaChatModel ollamaChatModel;
    @Test
    public void testOllama() {
        //向模型提问
        String answer = ollamaChatModel.chat("你是谁啊");
        //输出结果
        System.out.println(answer);
    }
}
