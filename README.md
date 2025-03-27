<!-- title -->
<h1 align="center">
    <span>Gestão de shows e envio de ingressos</span>
</h1>

<br>

<!-- badges -->
<div align="left">
    <img src="https://img.shields.io/badge/license-MIT-yellow" alt="badge icon"></img>
    <img src="https://img.shields.io/badge/version-1.0-green" alt="badge icon"></img>
    <img src="https://img.shields.io/badge/repo size-199 MB-orange" alt="badge icon"></img>
</div>

<br>

<!-- About -->
## <img src="https://cdn2.iconfinder.com/data/icons/flat-pack-1/64/Computer-512.png" alt="image icon" width="40px" align="center"> Sobre o Projeto

Grandes shows e eventos precisam de um sistema ágil e eficiente para gerenciar ingressos e garantir que o público os receba sem dificuldades. Para tornar esse processo simples, foi desenvolvida uma solução que cuida de tudo, desde a organização dos eventos até o envio dos ingressos por e-mail.

A solução é composta por dois microserviços:

- **Microserviço de Gestão de Eventos e Ingressos**

    Responsável por toda a administração dos shows e ingressos, desde a criação e atualização dos eventos até a geração dos ingressos em PDF. Após isso, encaminha os ingressos para o serviço de envio de e-mails.

<br>

- **Microserviço de Envio de E-mails**
    
    Focado exclusivamente no envio dos ingressos para o público, garantindo que cada cliente receba seu ingresso de forma rápida e segura. Utiliza JavaMailSender para um envio confiável.

<br>

<div align="center">
    <img src="readme_images\email_enviado_image.png" alt="mobile mockup image" width="650px" align="center">
</div>




<br>
<br>

ℹ️ *O microserviço de Pagamento ainda não foi criado. Será implementado em uma versão futura do projeto.*

ℹ️ *O arquivo .pdf enviado ainda não foi editado. Será implementado em uma versão futura do projeto.*

<hr>
<br>


<!-- Technologies e dependencias -->
## <img src="https://cdn4.iconfinder.com/data/icons/general-office/91/General_Office_48-256.png" alt="todo list image icon" width="40px" align="center"> Tecnologias e dependencias
- Java 17
- Spring Boot 3.4.3
- Spring Web
- Spring Data JPA
- OpenFeign
- JavaMailSender
- PostgreSQL
- Docker
- OpenAPI (Swagger)


<hr>
<br>

<!-- Diagram -->
### <img src="https://cdn3.iconfinder.com/data/icons/web-design-development-flat-colors/48/flow_chart-512.png" alt ="image icon" width="40px" align="center"> Diagrama de relacionamento

A aplicação trabalha com 2 entidades:

- Concert
- Ticket

<br>

![](./readme_images/diagrama.png)


> ℹ️ A entidade **Email** ainda não foi criada. Será implementada em uma versão futura do projeto.

<hr>
<br>






<!-- Validations -->
## <img src="https://cdn4.iconfinder.com/data/icons/rating-validation-3/128/validation_stamp_approval_approve_check-512.png" alt ="image icon" width="40px" align="center"> Validações

### Criação de concerts/shows

*Exempo do Objeto JSON enviado na requisicao*


```json
{
    "title": "Show tal tal tal",
    "description": "Show do artista tal",
    "city": "São Paulo - SP",
    "date": "09-09-2099", // Padrão BR --> dd-MM-yyyy
    "maxParticipants": 9000
}
```

Esses campos seguem as seguintes validações:

- **title**
    - Não pode ser null
    - Máximo 100 characters
    - Deve ser Único

    <br>

- **description**
    - Não pode ser null
    - Máximo 100 characters

    <br>

- **city**
    - Não pode ser null
    - Máximo 100 character

    <br>

- **date**
    - Não pode ser null
	- A data deve estar no formato br --> "dd-MM-yyyy"
	- Deve ser uma data posterior ao dia atual. Não pode ser data antiga

    <br>

- **maxParticipants**
    - Não pode ser null
    - Não pode ser String
    - Máximo 10.000 participantes

<br>
<br>

### Criação de tickets

*Exempo do Objeto JSON enviado na requisicao*

```json
{
  "email": "email_tal@gmail.com",
  "concertId":1
}
```


Esses campos seguem as seguintes validações:

- **email**
    - Não pode ser null
    - Máximo 100 characters
    - Deve possuir apenas um `@`
	- Deve ter algo antes e depois do `@`
	- Deve finalizar com `.com` ou `.br`

    <br>

- **concert_id**
    - Não pode ser null
	- Não pode ser String
	- concertId deve ser válido
	- Não pode ultrapassar o limite de participantes
	- O mesmo email não pode ser cadastrado duas vezes no mesmo show

<hr>
<br>

<!-- Custom Exception Handler -->
## <img src="https://cdn4.iconfinder.com/data/icons/common-app-symbols-round-colored/1024/caveat_proviso_disclaimer_exception_app_round_colored-512.png" alt ="image icon" width="40px" align="center"> Lançamento de exceções customizadas

Todas as exceções foram personalizadas para um melhor entendimento do usuário

<br>

**Exemplo 1**

![exception example 1](./readme_images/exception_max_participants.png)	
	
<br>

**Exemplo 2**

![exception example 2](./readme_images/exception_date_is_wrong.png)	

<hr>
<br>

## Documentação no Swagger

<br>

![swagger image example](./readme_images/swagger_example.png)	

<hr>
<br>

## <img src="https://cdn1.iconfinder.com/data/icons/internet-45/64/http-link-internet-domain-1024.png" alt ="image icon" width="40px" align="center"> Endpoints

### Concert Controller
| Método Http    | URI                                           | Descrição                         | Status Code esperado |
| :---:          | :---                                          |  :---                             |  :---:  | 
| POST           | `http://localhost:8080/concert`               | Cria um show                      | 201     |
| GET            | `http://localhost:8080/concert`               | Lista todos os shows              | 200     |
| GET            | `http://localhost:8080/concert/{id}`          | Retorna um show através do #ID    | 200     |


<br>

### Ticket Controller
| Método Http    | URI                                           | Descrição                          | Status Code esperado |
| :---:          | :---                                          |  :---                              |  :---:  | 
| POST           | `http://localhost:8080/ticket`                | Cria um ticket                     | 201     |
| GET            | `http://localhost:8080/ticket`                | Lista todos os tickets             | 200     |
| GET            | `http://localhost:8080/ticket/{id}`           | Retorna um ticket através do #ID   | 200     |

<hr>
<br>

<!-- Build and run -->
## <img src="https://cdn3.iconfinder.com/data/icons/start-up-4/44/rocket-256.png" alt="todo list image icon" width="40px" align="center"> Rodando a aplicação

### Requisitos

- Docker 27.0.3
- Gmail account
- Gmail app password

<br>

### Passo a passo


1. Gerar sua senha app google

    ![swagger image example](./readme_images/google_app_password_example.png)	

    Siga as instruções para gerar sua senha de aplicativo --> <a href="https://support.google.com/mail/answer/185833?hl=en">google app password</a>

    <br>

    ℹ️ *imagem retirada do blog https://blog.rebex.net/gmail-using-app-passwords*

<br>
<br>


2. Clone esse repositório
    ```bash
    git clone https://github.com/lGabrielDev/microservices_concert_email
    ```

<br>
<br>

3. Vá para o diretório do projeto

    ```bash
    cd microservices_concert_email
    ```

<br>
<br>

4. Atribua os valores nas variables do arquivo **.env**

    <img alt="environment variables image example" src="./readme_images\env_file_variables.png" width="340px">

    <br>

    - **gmail_password** --> Google app password que geramos anteriormente

    <br>

    ⚠️ Somente contas Gmail são suportadas. Outros provedores de e-mail não funcionam.


<br>
<br>

5.  Iniciar a aplicação com o Docker

    Após configurar o arquivo `.env`, basta rodar o comando abaixo para iniciar os containers da aplicação:
    
    ```bash
    docker compose up;
    ```

<br>
<br>

6. Acessar o Swagger para interagir com a API

    http://localhost:8080/swagger-ui.html`

<hr>
<br>

<!-- Credits -->
<h2>
    <img src="https://cdn4.iconfinder.com/data/icons/thank-you/256/Artboard_4_copy-512.png" alt="thumbs up icon image" width="40px" align="center">
    <span>Créditos</span>
</h2>

<p>As imagens usadas nesse projeto foram retiradas dos seguintes sites:</p>

- [shields.io](https://shields.io/)
- [iconfinder](https://www.iconfinder.com/)
- [storyset](https://storyset.com/)
- [blog.rebex](https://blog.rebex.net/)

<br>

<span>Thanks!</span>

<hr>
<br>

<!-- License -->
## <img src="https://cdn4.iconfinder.com/data/icons/jetflat-2-multimedia-vol-3/60/0042_049_license_agreement_file_document_paper_page_sheet-512.png" alt="todo list image icon" width="40px" align="center"> Licença MIT

O projeto está sob a licença do [MIT](./LICENSE).

<hr>
<br>

<!-- Author -->
## <img src="https://cdn1.iconfinder.com/data/icons/office-work-3/200/copywriting-512.png" alt="todo list image icon" width="40px" align="center"> Autor

<br>

<div align="center">
    <img src="./readme_images/avatar_circular.png" alt="profile avatar" width="150px">
    <p> <a href="https://github.com/lGabrielDev">Gabriel Freitas</a> 😎 </p>
</div>