# Challenge-JAVA
## OdontoPrev - Sistema de Gestão Odontológica

## Sobre o Projeto
O OdontoPrev é um sistema web desenvolvido para facilitar o gerenciamento de clínicas odontológicas, permitindo o controle eficiente de pacientes, tratamentos e auditorias. O sistema foi criado como parte de um desafio acadêmico, visando o aprimoramento das habilidades em desenvolvimento backend com Spring Boot e a construção de uma interface dinâmica com Thymeleaf.

Além de oferecer uma plataforma organizada e intuitiva para gestão odontológica, o OdontoPrev também incorpora recursos de segurança, auditoria e geração de relatórios, garantindo maior transparência e confiabilidade nos processos da clínica.

Com foco em segurança e eficiência, o sistema oferece:

Autenticação e autorização via Spring Security

Gerenciamento de pacientes e tratamentos odontológicos

Registros de auditoria para controle de alterações no banco de dados

Relatórios detalhados de gastos e tratamentos de cada paciente

Banco de Dados Oracle com Procedures e Triggers para segurança e auditoria


## Equipe de Desenvolvimento

Giovanna Lima | RM553369

Rebeca Lopes | RM553764

Lorenzo Augusto | RM553941

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

git clone https://github.com/GiovannaGiantomaso/CHALLENGE-3-JAVA.git

cd CHALLENGE-3-JAVA

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

