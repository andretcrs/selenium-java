# Projeto de Automação de Testes com Selenium e Java

## 📚 Sobre o Projeto
Este repositório contém um **projeto de estudos** de **automação de testes com Selenium WebDriver e Java**, desenvolvido como parte de um **curso da plataforma Alura**.

⚠️ **Atenção:** Este projeto **não é um projeto produtivo**. Ele foi criado exclusivamente para fins educacionais, com foco no aprendizado de automação de testes, boas práticas de código e organização de projetos Java.

---

## 🎯 Objetivos de Aprendizado
- Utilizar Selenium WebDriver para automação de testes web
- Estruturar um projeto de automação em Java
- Aplicar o padrão **Page Object Model (POM)**
- Centralizar configuração de navegador e ambiente
- Executar testes automatizados com Maven
- Gerar **relatórios de execução com Allure**
- Entender a base de um framework simples de automação

---

## 🛠️ Tecnologias Utilizadas
- **Java**
- **Selenium WebDriver**
- **JUnit**
- **Maven**
- **Google Chrome**
- **Selenium Manager**
- **Allure Reports**
- **IntelliJ IDEA**

---

## 📁 Estrutura do Projeto
A estrutura do projeto segue uma separação clara de responsabilidades:

```
src
├── test
│   ├── java
│   │   └── br.com.automacao
│   │       ├── config
│   │       │   └── ConfigManager.java      # Gerenciamento de configurações
│   │       ├── core
│   │       │   ├── BaseTest.java            # Classe base para os testes
│   │       │   └── DriverFactory.java       # Criação e controle do WebDriver
│   │       ├── pages
│   │       │   ├── LeilaoPage.java          # Page Object de Leilão
│   │       │   └── LoginPage.java           # Page Object de Login
│   │       ├── tests
│   │       │   ├── LeilaoTest.java          # Testes de Leilão
│   │       │   └── LoginTest.java           # Testes de Login
│   │       └── utils                        # Classes utilitárias
│   └── resources
│       └── config.properties                # Configurações do projeto
├── pom.xml
└── README.md
```

---

## ⚙️ Arquivo de Configuração
O arquivo `config.properties` é utilizado para centralizar configurações como:

- URL base da aplicação
- Navegador utilizado
- Timeouts

Exemplo:
```properties
base.url=http://localhost:8080/login
browser=chrome
timeout=10
```

---

## ▶️ Pré-requisitos
- Java instalado e configurado
- Maven instalado
- Google Chrome atualizado
- IntelliJ IDEA (recomendado)
- Allure Commandline instalado

---

## 🚀 Executando os Testes
1. Clone o repositório:
```bash
git clone <https://github.com/andretcrs/selenium-java.git>
```

2. Acesse a pasta do projeto:
```bash
cd nome-do-projeto
```

3. Execute os testes:
```bash
mvn clean test
```

---

## 📊 Relatórios com Allure
O projeto **já está configurado para gerar relatórios com Allure**.

Após executar os testes, utilize:

```bash
allure serve target/allure-results
```

Ou:

```bash
allure generate target/allure-results -o target/allure-report
allure open target/allure-report
```

---

## 🧪 Exemplos de Testes Automatizados
- Login com dados válidos e inválidos
- Criação e edição de leilões
- Validação de mensagens exibidas na interface
- Navegação entre páginas

---

## 📌 Boas Práticas Aplicadas
- Page Object Model (POM)
- Driver centralizado via Factory
- Classe base para reaproveitamento de setup/teardown
- Configurações externalizadas
- Relatórios automatizados

---

## 📖 Observação Final
Este projeto faz parte do meu processo de aprendizado em automação de testes, baseado nos cursos realizados na **Alura**, servindo como base para evolução em frameworks de testes automatizados.

---

✍️ **Autor:** Projeto de estudos – Curso Alura | Selenium com Java