# Challenge-JAVA
## OdontoPrev - Sistema de Gestão Odontológica

## Sobre o Projeto
O OdontoPrev é um sistema web desenvolvido para facilitar o gerenciamento de clínicas odontológicas, permitindo o controle eficiente de pacientes, tratamentos e auditorias. O sistema foi criado como parte de um desafio acadêmico, visando o aprimoramento das habilidades em desenvolvimento backend com Spring Boot e a construção de uma interface dinâmica com Thymeleaf.

Além de oferecer uma plataforma organizada e intuitiva para gestão odontológica, o OdontoPrev também incorpora recursos de segurança, auditoria e geração de relatórios, garantindo maior transparência e confiabilidade nos processos no geral.

Com foco em segurança e eficiência, o sistema oferece:

Autenticação e autorização via Spring Security

Gerenciamento de pacientes e tratamentos odontológicos

Registros de auditoria para controle de alterações no banco de dados

Relatórios detalhados de gastos e tratamentos de cada paciente

Banco de Dados Oracle com Procedures e Triggers para segurança e auditoria


## Equipe de Desenvolvimento

Giovanna Lima | RM553369

Rebeca Lopes | RM553764

Felipe Arcanjo | RM554018

## LINK DO VÍDEO

https://youtu.be/XJyyjwjjNSs

## Tecnologias Utilizadas

### Backend:

Java 17

Spring Boot 3.4.3

Spring Security (Autenticação e Autorização)

Spring Data JPA (Persistência de dados)

Spring Boot Actuator (Monitoramento e métricas)


### Frontend:

Thymeleaf (Template Engine para renderização de páginas dinâmicas)
Bootstrap & CSS (Estilização da interface)

### Banco de Dados:

Oracle Database

Stored Procedures e Triggers (Gerenciamento de auditoria e relatórios)

### Ferramentas Auxiliares:

GitHub

Maven

## Como Clonar e Executar o Projeto

### Clonar o repositório

Abra o terminal ou Git Bash e execute:

git clone https://github.com/GiovannaGiantomaso/CHALLENGE-4-JAVA.git

cd CHALLENGE-4-JAVA

### Comece iniciando a aplicação com:
http://localhost:8080

### Rotas da Aplicação:

Login: http://localhost:8080/login

Registrar:http://localhost:8080/register

Página principal: http://localhost:8080/principal

### Gerenciamento de Pacientes

Página de gerenciamento: http://localhost:8080/pacientes

Cadastrar paciente: http://localhost:8080/pacientes/cadastrar

Listar pacientes: http://localhost:8080/pacientes/listar

Editar paciente: http://localhost:8080/pacientes/editar/{id}

### Gerenciamento de Tratamentos

Página de Tratamentos: http://localhost:8080/tratamentos

Cadastrar tratamento: http://localhost:8080/tratamentos/cadastrar

Listar tratamento: http://localhost:8080/tratamentos/listar

Editar tratamento: http://localhost:8080/tratamentos/editar/{id}

### Relatórios

Relatorio dos pacientes e seus tratamentos: http://localhost:8080/relatorios/pacientes-tratamentos

Relatorio dos pacientes e seus gastos: http://localhost:8080/relatorios/gastos-pacientes

### Auditoria

Registros da tabela Auditoria: http://localhost:8080/auditoria

## Monitoramento com Spring Boot Actuator

O projeto implementa monitoramento interno utilizando o **Spring Boot Actuator**, que expõe diversos endpoints úteis para acompanhar o estado da aplicação, métricas de uso, logs, propriedades de ambiente e muito mais.

### Endpoints Disponíveis para o Spring Boot Actuator

> Base padrão: `http://localhost:8080/actuator`

| Endpoint                          | Descrição                                                                 |
|----------------------------------|---------------------------------------------------------------------------|
| `/actuator`                      | Lista todos os endpoints do Actuator.                                     |
| `/actuator/health`               | Verifica se a aplicação está saudável (`UP`, `DOWN`, etc).                |
| `/actuator/info`                 | Exibe informações da aplicação (nome, descrição, versão).                 |
| `/actuator/metrics`             | Lista todas as métricas disponíveis.                                      |
| `/actuator/metrics/{nome}`       | Detalha a métrica especificada (ex: `jvm.memory.used`).                  |
| `/actuator/env`                  | Mostra todas as variáveis de ambiente da aplicação.                      |
| `/actuator/env/{nome}`           | Exibe o valor de uma propriedade específica.                             |
| `/actuator/beans`                | Lista todos os beans do contexto Spring.                                 |
| `/actuator/loggers`              | Permite alterar níveis de log em tempo de execução.                      |
| `/actuator/threaddump`           | Exibe o dump atual das threads da JVM.                                   |
| `/actuator/mappings`             | Lista todos os endpoints da aplicação e seus mapeamentos.                |
| `/actuator/scheduledtasks`       | Exibe tarefas agendadas via `@Scheduled` (se houver).                    |
| `/actuator/conditions`           | Mostra os beans ativados/desativados pela auto-configuração.             |
| `/actuator/configprops`          | Exibe propriedades configuradas agrupadas por classe.                    |

### Configuração no `application.properties`

```properties
# Identidade da aplicação
spring.application.name=OdontoPrev
info.app.name=OdontoPrev
info.app.description=Sistema de Gerenciamento Odontológico
info.app.version=1.0.0

# Exposição dos endpoints
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always
management.info.env.enabled=true
management.endpoint.info.enabled=true


###  Configuração do Banco de Dados

spring.application.name=Odontoprev

spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl

spring.datasource.username=rm553369

spring.datasource.password=120505

spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.database-platform=org.hibernate.dialect.OracleDialect

spring.jpa.hibernate.ddl-auto=none

spring.jpa.show-sql=true

spring.sql.init.mode=always

spring.mvc.hiddenmethod.filter.enabled=true

management.endpoints.web.exposure.include=*

spring.thymeleaf.cache=false

spring.jpa.properties.hibernate.format_sql=true

logging.level.org.hibernate.SQL=DEBUG

logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE

### DIAGRAMA (DAR ZOOM PARA VISUALIZAR):

![diagrama-javaa](https://github.com/user-attachments/assets/4de52fbe-006d-4bf5-a670-36ab18f634ff)

