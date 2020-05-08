# Classes abertas, Open Closed e Dependency Inversion Principles

O primeiro conceito que eu quero passar pra vocês é a ideia de que as classes têm que ser abertas. Mas como assim **“aberta”**, o que que é uma classe aberta? Eu coloquei aí até a sigla **OCP (Open Closed Principle)**, que é o princípio que fala disso. Mas que raio que é esse negócio de princípio do aberto e fechado, o que são classes abertas?

A ideia é que as suas classes sejam **abertas** para extensão. Ou seja, eu tenho que conseguir estendê-la, ou seja, mudar o comportamento dela, de maneira fácil. Mas ela tem que estar **fechada** para alteração. Ou seja, eu não tenho que ficar o tempo inteiro indo nela pra mexer um if a mais, para fazer uma modificação ou coisa do tipo. Então, de novo, fechada para modificação, ou seja, eu não quero ter que o tempo inteiro entrar nela e sair escrevendo código, mas ela tem que estar aberta para extensão, ou seja, eu tenho que conseguir mudar a execução dela ao longo do tempo.

Mas a gente precisa mudar o comportamento, e é isso que vai acontecer no mundo real. Então, a primeira coisa que eu vou fazer é pensar numa **abstração**. Já que eu tenho diferentes tabelas de preço, eu preciso pensar numa **abstração** comum entre todas elas. E, por enquanto, vai ser o próprio método que eu tenho aqui, esse `double descontoPara(double valor)`.

Isso é o tal do **OCP**, o Princípio do Aberto e Fechado. E veja só como eu usei, como eu lidei com ele, como que eu joguei com esse problema aí do acoplamento/ coesão. Criei uma interface, que é estável, recebi pelo construtor, e isso fez agora com que eu possa mudar o comportamento da minha classe principal simplesmente mudando a implementação que eu estou passando pra essa classe `CalculadoraDePrecos`.

Isso é programar orientado a objetos. É pensar em abstração. Quando eu tenho uma boa abstração, eu consigo simplesmente evoluir o meu sistema criando novas implementações das abstrações em que eu já pensei antes. Agora meu sistema está lindo e maravilhoso. Ele evolui facilmente, basta eu criar novas implementações, as classes são todas coesas, são simples, são fáceis de serem testadas de maneira automatizada.

Mas e esse tal do **DIP**, o *Princípio da Inversão de Dependências*? Isso você já sabe o que é, eu só não tinha dado o nome. Sabe essa ideia maluca de você sempre depender de classes que são estáveis? Dá pra generalizar esse conceito.

A ideia é: sempre que você for depender, depende de alguém mais estável. Então, A* depende de *B, a ideia é que B* seja mais estável que *A. Mas B* depende de *C. Então, a ideia e que C* seja mais estável que *B. A ideia é que você sempre passe a depender de modos mais estáveis que você.

E mais do que isso, esse princípio vai mais longe. Ele fala o seguinte: “Olha, se você está numa classe, tenta depender de abstração. Você não pode depender de implementação. Dependa sempre de abstrações.”

E a abstração, por sua vez, ela só pode conhecer outras abstrações. A ideia é que ela não conheça detalhes de implementação. Isso é o que nós chamamos de *Dependency Inversion Principle*, o Princípio de Inversão de Dependência. Não confunda isso com “injeção” de dependência. Injeção de dependência é aquela ideia de você ter os parâmetros no construtor, e alguém magicamente injetar essas dependências pra você. O nome é parecido. Aqui é o princípio da **inversão** de dependência. A ideia é que você está invertendo a maneira de você depender das coisas. Passa a depender agora de abstrações.

Isso é **OCP** e isso é **DIP**. Eu deixei pra falar dele só agora, porque agora você entende bem o que é coesão, entende bem o que é acoplamento, e entende estabilidade. Agora você tem ferramenta suficiente pra jogar e entender essa ideia aí do OCP.