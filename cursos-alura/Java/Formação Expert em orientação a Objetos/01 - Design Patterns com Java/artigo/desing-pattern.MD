# O que é um padrão de projeto?

Um padrão de projeto é uma solução elegante para um problema que é recorrente no dia-a-dia do desenvolvedor.

Ou seja, por mais que desenvolvamos projetos diferentes, muitos dos problemas se repetem. Padrões de projeto são soluções elegantes e flexíveis para esses problemas.

# Design Patterns em Java
Classes e métodos gigantes? Cinco minutos para entender o que aquele método faz ou onde está o código que faz uma alteração simples? Diversas variáveis e diversos ifs e fors no mesmo método? Código complexo e obscuro? Toda vez que uma alteração aparece, você precisa mudar em 20 classes diferentes? Sim, problemas muito comuns do nosso dia-a-dia. Mas por que isso acontece?

Um fato que é conhecido sobre todo software é que ele, mais cedo ou mais tarde, vai mudar: novas funcionalidades aparecerão, outras deverão ser alteradas etc. O problema é que, geralmente, essas mudanças não são feitas de forma muito planejada. Por esse motivo, durante o desenvolvimento de um projeto de software, é bem comum a criação de código onde as responsabilidades se misturam e espalham por várias classes, fazendo com que a manutenção do código fique cada vez mais difícil, já que uma simples mudança pode obrigar o desenvolvedor a alterar diversas classes. Nesse cenário, temos uma situação onde o 'Design' das classes não está bom e é possível melhorá-lo.

Para atingir o objetivo da melhora do 'Design' e diminuir o custo de manutenção, existem algumas técnicas, onde podemos aplicar a orientação a objetos de uma maneira a simplificar o código escrito.

Resolveremos diversos dos problemas que vemos em códigos, como classes e métodos gigantes que fazem muita coisa, classes que precisam conhecer mais 10 outras classes para fazer seu trabalho, métodos complicados com muitos ifs e condições, mudanças que se propagam por várias classes e assim por diante.

Algumas das principais técnicas para atingir um bom 'Design' são tão comuns que foram catalogadas em um conjunto de alternativas para solucionar problemas de Design de código, chamados de Design Patterns, mais conhecido em português como os Padrões de Projetos, os quais, durante esse curso, aprenderemos a utilizar em um projeto. Um padrão de projeto nada mais é do que uma solução elegante para um problema que é muito recorrente em nosso dia-a-dia.

Mais importante do que entender como é a implementação de um padrão de projeto, é entender a motivação do padrão: em quais casos ele faz sentido e deve ser aplicado. Durante os próximos capítulos, observe o cenário do exemplo dado com atenção e o leve para o seu mundo e para o contexto de sua aplicação. Aquele cenário acontece? Se sim, então talvez o padrão de projeto ensinado naquele capítulo seja uma boa saída para controlar a crescente complexidade daquele código.

Durante todos os outros capítulos, faremos muitos exercícios. Todas as explicações serão baseadas em problemas do mundo real e você, ao final, utilizará os conhecimentos adquiridos para resolver os exercícios, que são desafiadores! Não se esqueça de prestar muita atenção ao cenário e ao problema proposto. Entenda a motivação de cada padrão para que você consiga levá-lo para os problemas do seu mundo!

Muitas regras e código complexo
Tomando como exemplo uma aplicação cujo objetivo é a criação de orçamentos, temos uma regra de negócio na qual os valores dos orçamentos podem ser submetidos à alguns impostos, como ISS, ICMS e assim por diante. Com isso, temos a simples classe que representa o orçamento, recebendo via construtor o seu valor: 

```java
public class Orcamento { 
    private double valor; public Orcamento(double valor) {
         this.valor = valor; 
    }
    public double getValor() { 
         return valor; 
    } 
}
```
Com isso, podemos criar novos orçamentos, instanciando objetos do respectivo tipo e caso queiramos calcular um imposto sobre seu valor, basta utilizarmos o atributo valor para isso. Assim, podemos estipular que o ICMS valha 10% e precisamos calculá-lo, baseado no valor do orçamento. Para isso, podemos ter a seguinte classe com um simples método para realizar o cálculo:
```java
public class CalculadorDeImpostos { 
    public void realizaCalculo(Orcamento orcamento) { 
        double icms = orcamento.getValor() * 0.1; 
        System.out.println(icms); // imprimirá 50.0 
    }
}
```
Podemos ainda querer calcular outro imposto, como o ISS, que é 6% do valor do orçamento. Com isso, adicionamos a nova regra ao código anterior. Mas devemos escolher qual o imposto que será calculado. Portanto, o método realizaCalculo deverá receber uma informação, indicando qual o imposto terá o cálculo realizado:
```java
public class CalculadorDeImpostos { 
    public void realizaCalculo(Orcamento orcamento, String imposto) { 
        if( "ICMS".equals(imposto) ) { 
            double icms = orcamento.getValor() * 0.1; 
            System.out.println(icms); // imprimirá 50.0 
        } else if( "ISS".equals(imposto) ) { 
            double iss = orcamento.getValor() * 0.06; 
            System.out.println(iss); // imprimirá 30.0 
        } 
    } 
}
```
Note que uma das consequências do código que acabamos de criar, é que espalhamos os cálculos e nossas regras de negócio. Dessa maneira, não temos nenhum encapsulamento de nossas regras de negócio e elas se tornam bastante suscetíveis a serem replicadas em outros pontos do código da aplicação. Por que não encapsulamos as regras dos cálculos em uma classe especializada para cada imposto?

## Encapsulando o comportamento

Ao invés de mantermos as regras espalhadas pela nossa aplicação, podemos encapsulá-las em classes cujas responsabilidades sejam realizar os cálculos. Para isso, podemos criar as classes ICMS e ISS cada um com seu respectivo método para calcular o valor do imposto de acordo com o orçamento.

```java
public class ICMS {
    public double calculaICMS(Orcamento orcamento) {
        return orcamento.getValor() * 0.1;
    }

}
```
```java
public class ISS {
    public double calculaISS(Orcamento orcamento) {
        return orcamento.getValor() * 0.06;
    }
}
```
Agora temos as duas classes que separam a responsabilidade dos cálculos de impostos, com isso, podemos utilizá-las na classe CalculadorDeImpostos da seguinte maneira:

```java
public class CalculadorDeImpostos {
    public void realizaCalculo(Orcamento orcamento, String imposto) {
        if( "ICMS".equals(imposto) ) {
            double icms = new ICMS().calculaICMS(orcamento);
            System.out.println(icms); // imprimirá 50.0

        } else if( "ISS".equals(imposto) ) {
            double iss = new ISS().calculaISS(orcamento);
            System.out.println(iss); // imprimirá 30.0
        }
    }
}
```
Agora o código está melhor, mas não significa que esteja bom. Um ponto extremamente crítico desse código é o fato de que quando quisermos adicionar mais um tipo diferente de cálculo de imposto em nosso calculador, teremos que alterar essa classe adicionando mais um bloco de if, além de criarmos a classe que encapsulará o cálculo do novo imposto. Parece bastante trabalho.

## Eliminando os condicionais com polimorfismo e o pattern Strategy

O que queremos em nosso código é não realizar nenhum condicional, ou seja, não termos mais que fazer `if`s dentro do `CalculadorDeImpostos`. Dessa forma, não devemos mais receber a `String` com o nome do imposto, no qual realizamos os `if`s. Mas como escolheremos qual o imposto que deve ser calculado?

Uma primeira possibilidade é criar dois métodos separados na classe CalculadorDeImpostos. Um para o ICMS e outro para o ISS, dessa forma teremos:

```java
public class CalculadorDeImpostos {
    public void realizaCalculoICMS(Orcamento orcamento) {
        double icms = new ICMS().calculaICMS(orcamento);
            System.out.println(icms);

    }

    public void realizaCalculoISS(Orcamento orcamento) {
        double iss = new ISS().calculaISS(orcamento);
            System.out.println(iss);
    }
}
```
No entanto, agora só transferimos o problema dos vários `if`s para vários métodos. O que não resolve o problema. O próximo passo para conseguirmos melhorar essa solução é termos um único método, genérico, que consegue realizar o cálculo para qualquer imposto, sem fazer nenhum if dentro dele.

```java
public class CalculadorDeImpostos {
    public void realizaCalculo(Orcamento orcamento) {
        double icms = new ICMS().calculaICMS(orcamento); // Mas e se quisermos outro imposto?
        System.out.println(icms);
    }
}
```
Agora estamos presos ao ICMS. Precisamos que nosso código fique flexível o bastante para utilizarmos diferentes impostos na realização do cálculo. Uma possibilidade para resolvermos esse problema é, ao invés de instanciarmos o imposto que desejamos dentro do método, recebermos uma instância do Imposto que queremos utilizar, como no código seguinte:

```java
public class CalculadorDeImpostos {
    public void realizaCalculo(Orcamento orcamento, Imposto imposto) {
        double valor = imposto.calcula(orcamento); 
        System.out.println(valor);
    }
}
```

No entanto, não temos o tipo `Imposto` em nossa aplicação e além disso, nesse tipo precisamos passar uma instância de `ISS` e `ICMS`. Para isso, podemos criar uma interface chamada `Imposto` e fazermos as classes `ISS` e `ICMS` a implementar.

```java
public interface Imposto {
    double calcula(Orcamento orcamento);
}

public class ICMS implements Imposto {
    public double calcula(Orcamento orcamento) {
        return orcamento.getValor() * 0.1;
    }
}

public class ISS implements Imposto {
    public double calcula(Orcamento orcamento) {
        return orcamento.getValor() * 0.06;
    }
}
```
E agora o nosso `CalculadorDeImpostos` está pronto para ser utilizado e flexível o bastante para receber diferentes tipos (ou "estratégias") de impostos. Um código que demonstra essa flexibilidade é o seguinte:

```java
public class TesteDeImpostos {
    public static void main(String[] args) {
        Imposto iss = new ISS();
        Imposto icms = new ICMS();
    
        Orcamento orcamento = new Orcamento(500.0);
    
        CalculadorDeImpostos calculador = new CalculadorDeImpostos();
    
        // Calculando o ISS
        calculador.realizaCalculo(orcamento, iss);
    
        // Calculando o ICMS        
        calculador.realizaCalculo(orcamento, icms);
    }
}
```
Agora, com um único método em nosso `CalculadorDeImpostos`, podemos realizar o cálculo de diferentes tipos de impostos, apenas recebendo a estratégia do tipo do imposto que desejamos utilizar no cálculo.

Quando utilizamos uma hierarquia, como fizemos com a interface `Imposto` e as implementações `ICMS` e `ISS`, e recebemos o tipo mais genérico como parâmetro, para ganharmos o polimorfismo na regra que será executada, simplificando o código e sua evolução, estamos usando o Design Pattern chamado Strategy.

Repare que a criação de uma nova estratégia de cálculo de imposto não implica em mudanças no código escrito acima! Basta criarmos uma nova classe que implementa a interface `Imposto`, que nosso `CalculadorDeImpostos conseguirá calculá-lo sem precisar de nenhuma alteração!

## Quando usar o Strategy?

O padrão Strategy é muito útil quando temos um conjunto de algoritmos similares, e precisamos alternar entre eles em diferentes pedaços da aplicação. No exemplo do vídeo, temos diferentes maneiras de calcular o imposto, e precisamos alternar entre elas.

O Strategy nos oferece uma maneira flexível para escrever diversos algoritmos diferentes, e de passar esses algoritmos para classes clientes que precisam deles. Esses clientes desconhecem qual é o algoritmo "real" que está sendo executado, e apenas mandam o algoritmo rodar. Isso faz com que o código da classe cliente fique bastante desacoplado das implementações concretas de algoritmos, possibilitando assim com que esse cliente consiga trabalhar com N diferentes algoritmos sem precisar alterar o seu código.

## Chain of Responsibility

### Quando usar o Chain of Responsibility?
O padrão Chain of Responsibility cai como uma luva quando temos uma lista de comandos a serem executados de acordo com algum cenário em específico, e sabemos também qual o próximo cenário que deve ser validado, caso o anterior não satisfaça a condição.

Nesses casos, o Chain of Responsibility nos possibilita a separação de responsabilidades em classes pequenas e enxutas, e ainda provê uma maneira flexível e desacoplada de juntar esses comportamentos novamente.


##  Template Method

### Quando usar?

Quando temos diferentes algoritmos que possuem estruturas parecidas, o Template Method é uma boa solução. Com ele, conseguimos definir, em um nível mais macro, a estrutura do algoritmo e deixar "buracos", que serão implementados de maneira diferente por cada uma das implementações específicas.

Dessa forma, reutilizamos ao invés de repetirmos código, e facilitamos possíveis evoluções, tanto do algoritmo em sua estrutura macro, quanto dos detalhes do algoritmo, já que cada classe tem sua responsabilidade bem separada.

Cenário: Imagine que temos uma série de algoritmos matemáticos a serem implementados. Todos eles são bem parecidos, possuem a mesma estrutura. As variações são mínimas, por exemplo, um deles deve iterar até o fim da lista, enquanto o outro deve iterar até a metade dela.

Uma implementação procedural possuíria uma alta repetição de código, já que os algoritmos são muito parecidos.

O Template Method cairia como uma luva, já que ele possibilita que o desenvolvedor escreva a "estrutura" do algoritmo apenas uma vez, e a reutilize nas implementações específicas de cada um dos algoritmos.

Isso faz com o que o código fique mais simples, possibilita que mudanças na estrutura desses algoritmos sejam facilmente modificadas, e que novos algoritmos sejam criados de forma simples.

## Quando usar o Decorator?
Sempre que percebemos que temos comportamentos que podem ser compostos por comportamentos de outras classes envolvidas em uma mesma hierarquia, como foi o caso dos impostos, que podem ser composto por outros impostos. O Decorator introduz a flexibilidade na composição desses comportamentos, bastando escolher no momento da instanciação, quais instancias serão utilizadas para realizar o trabalho.

exemplo:
Imagine que estamos implementando uma sequência de filtros. Esses filtros precisam eliminar diversas faturas de uma lista, de acordo com algumas regras de negócio: faturas menores que 2000 devem ser eliminadas, faturas maiores do que 8000 devem ser eliminadas, faturas entre 3000 e 4500 que foram emitidas no estado de São Paulo devem ser eliminadas, e assim por diante.

Uma implementação procedural produziria uma sequência de ifs enorme para verificar todas essas condições.

O Decorator se encaixaria bem nesse problema. Poderíamos fazer com que cada filtro seja um "Decorator", e vamos decorando a lista com todos os filtros existentes. Cada filtro teria sua própria classe, simples e fácil de ser compreendida e mantida.

O Chain of Responsibility poderia ser uma alternativa também. Mas idealmente, em um "chain", assim que encontra-se um nó da corrente que atende aquele problema, os outros não são executados. Uma comum implementação do padrão são filtros, iguais os usados em aplicações web Java e etc, e neles os filtros se combinam e muitos podem ser executados ao mesmo tempo.

Os outros padrões não fazem sentido para o problema dado. State serve para gerenciar estados de um objeto; builder para criar objetos complexos, e strategy para possibilitar a flexibilização de um algoritmo, trocando partes do mesmo.

## Quando usar o State?
A principal situação que faz emergir o Design Pattern State é a necessidade de implementação de uma máquina de estados. Geralmente, o controle das possíveis transições são vários e complexos, fazendo com que a implementação não seja simples. O State auxilia a manter o controle dos estados simples e organizados através da criação de classes que representem cada estado e saiba controlar as transições.

Cenário: Um Contrato pode sofrer tipos de alterações, descontos, ajustes enquanto está EM ANDAMENTO. O mesmo pode acontecer quando ele está FALTANDO ASSINATURA DO CLIENTE. Mas, após ASSINADO, o contrato não pode mais sofrer alterações.

Um código procedural muito provavelmente conteria um conjunto enorme de ifs, um para cada possível estado do Contrato e ação a ser executada, tornando o código desnecessariamente complexo e difícil de ser mantido.

O State facilitaria o trabalho do desenvolvedor, já que ele possibilitaria que as ações de cada estado fiquem centralizadas em classes específicas, evitando a possível bagunça de um código procedural cheio de ifs.

Além disso, criar novos estados para esse contrato também seria fácil.

## Quando usar o Builder?
Sempre que tivermos um objeto complexo de ser criado, que possui diversos atributos, ou que possui uma lógica de criação complicada, podemos esconder tudo isso em um Builder.

Além de centralizar o código de criação e facilitar a manutenção, ainda facilitamos a vida das classes que precisam criar essa classe complexa, afinal a interface do Builder tende a ser mais clara e fácil de ser usada.


## Quando usar o Observer?

Quando o acoplamento da nossa classe está crescendo, ou quando temos diversas ações diferentes a serem executadas após um determinado processo, podemos implementar o Observer.

Ele permite que diversas ações sejam executadas de forma transparente à classe principal, reduzindo o acoplamento entre essas ações, facilitando a manutenção e evolução do código.

Cenário: Imagina que você precise avisar 3 sistemas externos (auditoria, financeiro, e agências), assim que uma conta bancária receber um depósito.

Em uma implementação procedural, todas essas atividades seriam invocadas logo após a operação de depósito, fazendo com que essa classe perca coesão, e fique complicada de ser entendida e mantida.

O Observer se encaixaria muito bem. Ele permite que você notifique e execute ações após algum acontecimento no seu sistema. E faz isso de tal forma que o acoplamento entre classes continue baixo, e flexível para adicionar novas ações quando necessário.

## Quais os benefícios que padrões de projeto trazem a um sistema OO?

Padrões de projeto são alternativas para que o desenvolvedor consiga escrever código com responsabilidades mais bem definidas, com um baixo acoplamento, e que evolua de maneira natural. Características essas que não são encontrados em sistemas procedurais, que tipicamente apresentam código complexo, cheio de `ifs`, e que fazem muita coisa, tornando a manutenção custosa.

Códigos que fazem bom uso de OO evoluem geralmente não pela adição de mais um `if`, mas sim pela criação de mais uma estratégia, mais um observador, mais um estado, e assim por diante.

Padrões de projeto no fim apenas fazem bom uso da orientação a objetos, e seus conceitos e mecânismos, como encapsulamento, abstrações, interfaces, polimorfismo, e etc.

## O que voce pensa sobre Padroes de Projeto?
Muitos desenvolvedores tentam forçar ao máximo o uso de padrões nos códigos. O que você pensa sobre isso? Usar padrões 100% do tempo é o ideal? Quais são as vantagens e desvantagens?

Não. Padrões de projeto trazem grande flexibilidade ao seu código, mas isso tem um preço: complexidade. Naturalmente um código que faz uso de padrões de projeto é, do ponto de vista de implementação, mais complexo do que um código que não os utiliza. Afinal, como tudo está desacoplado, o desenvolvedor precisa entender melhor a solução para entender o que o código faz como um todo.

Um bom desenvolvedor sabe fazer essa avaliação e entender quais os ganhos e perdas da utilização de um padrão. Em um problema simples de resolver, talvez o uso de um padrão de projeto não faça sentido; o código vai apenas ficar mais complicado. Agora, em problemas que são por natureza complexos, ou que demandam flexibilidade, pois mudam o tempo todo, talvez a utilização de um padrão de projeto traga benefícios, já que todos os padrões sempre agregam flexibilidade ao código gerado.

Nunca se esqueça: a sua experiência é fundamental! Padrões de projeto são mais uma ferramenta. Eles devem ser um meio para se chegar à solução final, e não o "fim", ou seja, o seu objetivo principal.