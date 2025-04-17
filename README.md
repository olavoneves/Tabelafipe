# Projeto Tabela Fipe - Consulta de Veículos no Console

## 📌 Visão Geral
O Projeto Tabela FIPE é uma aplicação Java que permite consultar valores e informações de veículos diretamente pelo console. <br>
Desenvolvido com Spring Boot (sem camada web), este projeto aplica conceitos de POO para oferecer uma experiência prática em linha de comando.

### ✨ Funcionalidades

🚗 Consulta de marcas de veículos <br>
� Filtro de modelos por marca selecionada <br>
🔍 Busca detalhada por ano/modelo específico <br>
💰 Visualização de valor FIPE e especificações técnicas <br>

### 🛠 Tecnologias Utilizadas

<strong> -> </strong> Java 17+ - Linguagem base do projeto <br>
<strong> -> </strong> Spring Boot - Para injeção de dependência <br>
<strong> -> </strong> Records - Para modelagem de dados imutáveis <br>
<strong> -> </strong> Collections Framework - Para manipulação eficiente de dados <br>
<strong> -> </strong> Streams API & Lambdas - Para operações funcionais e concisas <br>
<strong> -> </strong> Console UI - Interface simples no terminal <br>

### 🎯 Arquitetura Simplificada

    📦 projeto-tabela-fipe
    ├── 📂 src/main/java
    │   ├── 📂 br/com/tabelafipe
    │   │   ├── 📂 application
    │   │   │   ├── TabelaFipeApplication.java    # Classe principal (main)
    │   │   │   └── ConsoleService.java           # Lógica de interação com usuário
    │   │   ├── 📂 model
    │   │   │   ├── Carro.java                    # Record com dados do veículo
    │   │   │   ├── Marca.java                    # Record com dados da marca
    │   │   │   ├── Modelo.java                   # Record com dados do modelo
    │   │   │   └── Ano.java                      # Record com dados do ano
    │   │   └── 📂 service
    │   │       ├── FipeService.java              # Implementação do serviço
    │   │       └── IFipeService.java             # Interface do serviço
    └── 📂 src/main/resources
        └── application.yml                       # Configurações básicas

### 📋 Exemplo dos Records (Model)

    // Marca.java
    public record Marca(String codigo, String nome) {}
    
    // Modelo.java
    public record Modelo(String codigo, String nome) {}
    
    // Ano.java
    public record Ano(String codigo, String nome) {}

    // Carro.java
    public record Carro(
        String valor,
        String marca,
        String modelo,
        String ano,
        String combustivel,
        String codigoFipe,
        String mesReferencia
    ) {}

### 📋 Exemplo da Interface de Serviço

    // IFipeService.java
    public interface IFipeService {
        List<Marca> listarMarcas();
        List<Modelo> listarModelos(String codigoMarca);
        List<Ano> listarAnos(String codigoMarca, String codigoModelo);
        Carro consultarValor(String codigoMarca, String codigoModelo, String codigoAno);
    }

## 📋 Exemplo da Classe de Aplicação

    // TabelaFipeApplication.java
    @SpringBootApplication
    public class TabelaFipeApplication implements CommandLineRunner {
    
        private final ConsoleService consoleService;
    
        // Injeção de dependência via construtor
        public TabelaFipeApplication(ConsoleService consoleService) {
            this.consoleService = consoleService;
        }
    
        public static void main(String[] args) {
            SpringApplication.run(TabelaFipeApplication.class, args);
        }
    
        @Override
        public void run(String... args) {
            consoleService.iniciar();
        }
    }

### 🚀 Como Executar

<strong> 1 </strong> - Clone o repositório <br>
<strong> 2 </strong> - Execute com Maven: <br>
bash Copy:  ./mvnw spring-boot:run <br>
 <strong> 3 </strong> - Siga as instruções no console

### 📜 Licença
MIT License - veja o arquivo LICENSE para detalhes. <br>

Desenvolvido com ❤️ por Olavo Neves, para aprendizado de Java e Spring Boot! <br>
Uma ferramenta poderosa para amantes de automóveis! 🚘💨
