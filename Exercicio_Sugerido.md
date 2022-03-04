# Exercicio Sugerido

### Lembrando que os Opcionais são um desafio a mais

- CRUD de Usuário
    - Implementar os principais verbos Http (POST / GET / PUT / DELETE)
    - Atributos:
        - **_nome_**:
            - Não deve ser nulo nem em braco.
            - Deve ter o limite de 50 caracteres.
        - **_login_**:
            - Não deve ser nulo nem em braco.
            - Deve ser unico no sistema.
            - Deve possuir entre 5 a 20 caractes de tamanho.
        - **_email_**:
            - Não deve ser nulo nem em braco.
            - Deve possuir no minimo 10 caracteres.
            - Deve ser um e-mail valido.
        - **_senha_**:
            - Não deve ser nulo nem em braco.
            - Deve ser criptografada (Minimo base64).
            - Deve possuir entre 4 a 10 caractes de tamanho.
            - _Opcional_:
                - Possuir uma letra ou mais maiuscula.
                - Possuir uma letra ou mais minuscula.
                - Possuir um numero ou mais.
                - Possuir um caracter ou mais especial.
        - **_Data de Nascimento_**:
            - Permite ser nulo ou em braco.
            - Se preenchido deve ser uma data valida sem hora.
    - Atributos _Opcionais_:
        - **_Data de Criação_**:
            - Não deve ser nulo nem em braco.
            - Se preenchido deve ser uma data valida com hora.
        - **_Data de Atualização_**:
            - Permite ser nulo ou em braco.
            - Se preenchido deve ser uma data valida com hora.

- End-Points obrigatórios:
    - Listar os aniversariantes do mês
    - Listar todos os provedores de e-mails dos usuarios
        - Ex: gmail.com / yahoo.com.br / outlook.com

- End-Points opcionais:
    - Listar usuarios com a inicial enviada
        - Ex: Se for enviado a letra "L" retorna todo mundo com a incial "L" (Lorena, Lorrane, Lucas)
- Usar o arquivo _"carga-inicial.sql"_ para inserir 5 usuarios teste assim que terminar a implementação.
