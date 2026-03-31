# Spring AI + DeepSeek 示例项目

基于 Spring Boot 与 Spring AI 的入门示例，演示如何通过 DeepSeek 模型快速构建对话 API（普通响应 + 流式响应）。

## 项目特性

- 集成 `spring-ai-starter-model-openai`，对接 DeepSeek OpenAI 兼容接口
- 提供同步对话接口：`GET /deepseek/chat`
- 提供流式对话接口（SSE）：`GET /deepseek/stream`
- 代码结构清晰，适合学习 Spring AI 最小可运行实践

## 技术栈

- Java 17
- Spring Boot 3.5.13
- Spring AI 1.1.4
- Maven

## 项目结构

```text
src/main/java/spring/ai/example/spring_ai_first_blood
├── SpringAiFirstBloodApplication.java
├── controller
│   └── DeepSeekController.java
└── service
    └── DeepSeekService.java
```

## 快速开始

### 1. 环境准备

- JDK 17+
- Maven 3.6+
- DeepSeek API Key（[申请地址](https://platform.deepseek.com/)）

### 2. 配置 API Key

编辑 `src/main/resources/application.properties`：

```properties
spring.application.name=spring-ai-first-blood
spring.ai.openai.base-url=https://api.deepseek.com/
spring.ai.openai.api-key=YOUR_DEEPSEEK_API_KEY
spring.ai.openai.chat.options.model=deepseek-chat
```

### 3. 启动项目

```bash
./mvnw spring-boot:run
```

## API 使用示例

应用默认启动后地址：`http://localhost:8080`

### 同步对话

```bash
curl "http://localhost:8080/deepseek/chat?message=你好，请介绍一下你自己"
```

### 流式对话（SSE）

```bash
curl -N "http://localhost:8080/deepseek/stream?message=请分3点介绍Spring%20AI"
```

## 代码说明

- `DeepSeekController`：对外暴露 HTTP 接口
- `DeepSeekService`：封装 `ChatClient` 调用逻辑
- `application.properties`：模型、网关地址与密钥配置

## 常见问题

### 1) 返回 401 / 认证失败

- 检查 `spring.ai.openai.api-key` 是否正确
- 确认 Key 已开通并可访问 DeepSeek 接口

### 2) 流式接口没有持续输出

- 请使用支持流输出的客户端（如 `curl -N`）
- 确认请求的是 `/deepseek/stream` 而非 `/deepseek/chat`
