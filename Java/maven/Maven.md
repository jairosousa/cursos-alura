# Maven

#### **Criando um projeto com Maven**
Vamos criar um projeto simples com o Maven. O nome do projeto será produtos e o pacote principal será br.com.alura.maven.

Para isso você deve executar o seguinte comando no diretório em que deseja que o projeto seja criado:

```
mvn archetype:generate -DartifactId=produtos -DgroupId=br.com.alura.maven -DinteractiveMode=false -DarchetypeArtifactId=maven-archetype-quickstart
```

**Observação:** No Windows, talvez seja necessário utilizar aspas duplas (" ") nos parâmetros -D:

```
mvn archetype:generate -DartifactId="produtos" -DgroupId="br.com.alura.maven" -DinteractiveMode="false" -DarchetypeArtifactId="maven-archetype-quickstart"
```

Após realizar download de bastante coisa, caso seja a primeira vez que você executou o comando, o maven deve mostrar uma mensagem indicando que o projeto foi criado com sucesso.


>**Opinião do instrutor**

O comando executado irá gerar um projeto baseado no archetype do Maven que gera um projeto simples, mas que já cria um classe com método `main()` e um arquivo de teste.

Abra o diretório do projeto em um editor de texto de sua preferência.

#### **Executando alguns comandos básicos**

Como foi visto nas aulas, o processo de _build_ da nossa aplicação pode se tornar cada vez mais complexo. Por esse motivo, é interessante utilizar uma ferramenta que o automatize, como o Maven.

O comando utilizado para compilar nossas classes para um diretório que não é o mesmo do fonte é mais complexo.

No lugar de executar o `javac`, vamos utilizar o Maven para compilar a classe `App.java` que o projeto `produtos` contém. Para isto, execute `mvn compile`. Verifique se dentro do diretório `target/classes`, o arquivo class foi devidamente gerado.

Utilize o Maven para rodar os testes do projeto. Para isto execute o comando `mvn test`. Além de verificar a saída do comando no terminal, verifique dentro do diretório `target` quais diretórios foram gerados e seus conteúdos.

Para finalizar, utilize o comando `mvn clean` para limpar o diretório `target` e manter apenas os arquivos fonte.

>**Opinião do instrutor**

Os comandos do Maven devem ser executados na raiz do diretório do projeto. Portanto não se esqueça de acessar o diretório:

```
cd produtos
```

Para compilar o código-fonte do nosso projeto, o comando utilizado é mvn compile. As classes serão geradas no diretório `target/classes`.

Para rodar os testes, utilizamos `mvn test`. No terminal, o comando nos mostra o resultado da execução de cada um dos arquivos de teste, bem como um resumo geral: quantos testes foram executados, quantos falharam, etc.

Além disso, o `mvn test` gera dois diretórios dentro de `target`: o `test-classes`, que contém os arquivos `class` dos arquivos de teste, e o `surefire-reports` onde podemos ver arquivos com o resultado da execução dos testes nos arquivos de teste.

Para limpar o diretório target, utilizamos o comando mvn `clean`.

#### **Relatório e arquivo .jar**

Gere o pacote do projeto no formato `.jar`.

Execute o programa através do `.jar` que foi gerado. Você pode usar os seguintes comandos para entrar no diretório `target`, executar o programa, e retornar ao diretório `produtos`:

```
cd target/
java -cp produtos-1.0-SNAPSHOT.jar br.com.alura.maven.App
cd ..
``` 

Como o Maven sabe que deve gerar um arquivo no formato `.jar` e não `.war`, por exemplo? O pacote gerado estará com o nome `produtos-1.0-SNAPSHOT.jar`. De onde o Maven tira as informações para gerar o arquivo com esse nome?

Reflita antes de ver nossa resposta!

>**Opinião do instrutor**

Para gerar um relatório em formato `.html`, utilizamos o plugin _Surefire Report_. O _goal_ que utilizamos é o _report_:

```
mvn surefire-report:report
```

Dentro do diretório `target/site` será possível encontrar o relatório no arquivo `surefire-report.html`.

Para gerar o arquivo `.jar` do nosso projeto executamos:

```
mvn package
```

O Maven busca as informações sobre o tipo de pacote que deve gerar, bem como o nome do pacote e versão, no arquivo `pom.xml`. É nesse arquivo que concentramos as configurações sobre o _build_ do nosso projeto, assim como as bibliotecas (dependências) necessárias para o projeto funcionar.

#### **Executar uma ação de maneira offline**

Sendo assim, podemos solicitar que o Maven execute uma ação de maneira offline por meio do comando -o no terminal:

```
mvn -o test
```
Contudo, se o Maven necessitar de algum arquivo novo para executar a ação solicitada, ele não poderá realizar o download de dependências, uma vez que estamos trabalhando no modo offline. Por isso, é importante que tenhamos certeza de que temos todos os elementos necessários antes de operarmos nesse modo.

Quando dizemos que o Maven busca na internet as dependências necessárias, estamos nos referindo ao repositório central da ferramenta. Considerando a imensidão da internet, uma busca completa seria praticamente impossível.

Atualmente, o repositório central do Maven está hospedado em [maven repositório](http://repo.maven.apache.org/maven2/). 


Vamos acessá-lo e clicar em `"br/ > com/ > caelum/ > vraptor/"`, e encontraremos diferentes versões de ***VRaptor***. Clicaremos sobre a versão `4.2.0-RC3/`, e encontraremos códigos fonte em formato `.jar`, Javadocs que podem ser descompactados, e assim por diante.

```
No repositório central armazenamos as bibliotecas a serem compartilhadas com o mundo do Maven.
```































