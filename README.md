# raspberryawards
Teste de requisitos backend

# Instruções para rodar o projeto
## 1- Baixe e instale uma IDE Java
### 1.1- Recomendado Eclipse, pelo link: [https://www.eclipse.org/downloads/](https://www.eclipse.org/downloads/packages/release/2022-03/r/eclipse-ide-java-developers)
## 2- Habilite o Lombok na sua IDE
### 2.1- Baixar o lombok, e instalar ele na sua IDE, pelo link: https://projectlombok.org/download
## 3- Baixar projeto e abrir na sua IDE
### 3.1- Crie uma pasta para baixar o projeto [comando git clone <enderço reste repositório>]
#### ![image](https://user-images.githubusercontent.com/2281527/169886855-a48a27ea-4729-49cf-ace9-c07a58bf5bfb.png)
### 3.2- No Eclipse, vá para a opção File -> Import -> Existing Maven Project, depois selecione a pasta baixada.
#### ![image](https://user-images.githubusercontent.com/2281527/169887236-9dfa50fa-803e-47cd-aba9-8c1214acf350.png)
### 3.3- Para rodar o projeto, selecione-o e depois clique em Run:
#### ![image](https://user-images.githubusercontent.com/2281527/169887598-2691a8c5-cab0-4283-9b2d-2810b07c8b6c.png)
## 4- Testar chamada do serviço REST
### 4.1- Baixe algum client de serviço REST, como no caso o POSTMAN
#### https://www.postman.com/downloads/
### 4.2- Crie uma requisição GET para o seguinte caminho http://localhost:8080/movies/intervalawards
#### ![image](https://user-images.githubusercontent.com/2281527/169896554-59e01bb5-0871-4818-b01c-e2c256d299d2.png)
## 5- Rodar testes unitários 
### 5.1- Selecione o projeto [sendo IDE Eclipse] -> botão direito -> Run As -> JUnit Tests
#### ![image](https://user-images.githubusercontent.com/2281527/169889971-87cc6342-96a2-4f05-afa2-46242a41e396.png)
#### ![image](https://user-images.githubusercontent.com/2281527/169890080-a6eb1f48-a832-4907-954a-477e896e798e.png)
### 5.2- Rodar testes pelo comando Maven [mvn test] ou opção Maven da IDE
#### Eclipse -> Botão direito no projeto -> Run As -> Maven Test
#### ![image](https://user-images.githubusercontent.com/2281527/169890585-8db60569-15f9-4543-8a0b-2e94ebdf1e21.png)
#### ![image](https://user-images.githubusercontent.com/2281527/169890652-d15cd50a-82eb-4c0e-bcaa-060569d17467.png)
## 6- Dados a serem trabalhados
### 6.1- Para testes foi utilizado o .csv passado no desafio.
### 6.2- Para alterá-lo ou utilizar outra massa de dados, basta substituir as informações do arquivo em .csv [...\raspberryawards\src\main\resources\movielist.csv]
#### ![image](https://user-images.githubusercontent.com/2281527/169891214-9fcae0a5-ff2d-4ba1-a860-d8354ba00081.png)

# Obrigado!
