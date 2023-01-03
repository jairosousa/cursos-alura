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

#### **As fases do Maven**

Em um processo de _build_, o primeiro passo é criar os diretórios que armazenarão os arquivos do projeto. A segunda etapa é compilar os conteúdos, depois os _testes_, e então efetivá-lo de fato. O _build_ possui várias fases que são executadas ordenadamente.

Na [documentação do Maven](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html) encontraremos as fases que um ciclo de vida build apresenta:


>1. **Validação**: verificamos se projeto possui todas as informações necessárias
>2. **Compilação**: compilar os conteúdos
>3. **Teste**: realizar testes diferentes no projeto
>4. **Pacote**: geração de um pacote do projeto
>5. **Teste de integração**: realizar testes de integração
>6. **Verificação**: checagem do pacote gerado
>7. **Instalação**: realizar a instalação do pacote no repositório local
>8. **Implantação**: realizar a implantação no ambiente adequado

Quando acionamos o seguinte comando no terminal estamos executando duas fases do ciclo: **validação** e **compilação**.

```
cd Documents/guilherme/workspace/produtos
mvn compile
```

Para executarmos a fase de teste `(mvn test)`, devemos realizar as duas que a antecedem, isto é, validação e compilação, como dito anteriormente. Precisamos fazer o processo na ordem correta, e não podemos gerar um _package_ sem a compilação prévia, por exemplo.

Podemos forçar a ordem de etapas com opções da linha de comando, como não gerar testes, por meio do comando `-DskipTests=true`:

```
mvn -DskipTests=true package
```

Por padrão, o ciclo de vida de _build_ respeita a ordem que apresentamos, portanto primeiro ocorre a validação dos arquivos do projeto, a verificação do ambiente, e assim por diante. Em seguida teremos a compilação dos arquivos e a possibilidade de executarmos testes. Na fase de pacote, geraremos os arquivos `.jar`, `.war` ou quaisquer outros que serão usados para a implementação do projeto.

Em seguida, há a fase de verificação dos resultados dos testes e o controle de qualidade da aplicação. Finalmente, passamos para as duas últimas etapas: a instalação no local e a implementação no remoto.

Agora que conhecemos melhor os processos de _build_, iremos estudar alguns relatórios que o _Maven_ pode gerar.


#### **Utilizando o plugin PMD**

O [PMD é um analisador de código-fonte](https://pmd.github.io/) que consegue encontrar algumas falhas no nosso código, como por exemplo, variáveis que não estão sendo utilizadas.

Utilize o plugin PMD do Maven para gerar um relatório da análise do código-fonte do seu projeto. Após executar o comando, você encontrará o relatório dentro do diretório `target/site`, no arquivo `pmd.html`.

O relatório irá indicar que a classe Produto possui campos que não estão sendo utilizados.

Você pode encontrar mais informações sobre o plugin PMD [aqui](https://maven.apache.org/plugins/maven-pmd-plugin/).

A primeira coisa a se fazer é adicionar o plugin do PMD ao `pom.xml`. Nós adicionamos depedências na tag `<dependencies>`, mas como aqui queremos alterar o _build_ do projeto, os plugins ficam dentro da tag `build`:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <!-- informações sobre o projeto -->
    <dependencies>
        <!-- dependências do junit e xstream -->
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-pmd-plugin</artifactId>
                <version>3.6</version>
                <executions>
                    <execution>
                        <phase>verify</phase>
                        <goals>
                            <goal>check</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

Para gerar o relatório, você deve utilizar o comando `mvn pmd:pmd`. Caso existam violações no código-fonte, o arquivo `pmd.html` será criado em `target/site`, indicando quais são as violações.

#### **Utilizando o plugin do JaCoCo**

Adicione o plugin do JaCoCo ao projeto para que seja possível gerar relatórios sobre a cobertura de testes do projeto. Esse tipo de relatório é interessante pois é possível ver de uma forma fácil o que não testamos em nossa aplicação.

Lembre-se que para adicionar o plugin, basta fazer uma busca no Google. No caso do JaCoCo, você pode obter informações [aqui](https://www.eclemma.org/jacoco/trunk/doc/maven.html).

Faça com que os _goals_ `prepare-agent` e `report` sejam adicionados ao ciclo de vida. Mantenha a execução do goal na fase padrão do plugin, não é necessário deixar a fase explícita no `pom.xml`.

Execute o comando `mvn verify`, e no diretório `target/site/jacoco` você encontrará a página HTML `index.html`. Abra o arquivo e veja o relatório detalhado sobre o código não coberto por testes. No momento, nenhum código do nosso projeto está testado.





















