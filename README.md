# LPO0504 - Island Defense 

Este trabalho tem como objetivo a criação dum jogo com base na junção de dois conceitos distintos, o de um Tower Defender e o de uma Batalha Naval. Sendo assim, o jogo tem como objetivo destruir barcos inimigos que se aproximam de uma ilha. É usado o terminal Lanterna em Java para efeitos de desenvolvimento do projeto. 

Este projeto foi desenvolvido por *Guilherme Valler Moreira* (up202007036@fe.up.pt), *Rui Brogueira Andrade* (up202007539@fe.up.pt) e *Manel (????) Moreira* (up201402718@fe.up.pt) para LDTS 2021-22.

## 1. Implemented Features

### 1.1 Features Implementadas

- **Terminal do jogo** - Usando o screen do Lanterna em Java representamos o mapa do jogo. Este mapa é constituído por uma ilha randomizada, dependendo do nível de dificuldade, ou costumizado, por barcos que se vão aproximando da ilha e por 'power-ups'. Todos estes elementos são apresentados como caracteres de terminal.

- **Movimento dos barcos** - Os barcos podem-se mover de duas maneiras diferentes, ou seguem a sua direção e avançam um espaço para a frente ou mudam a sua direção. Estes movimentos nunca podem ser no sentido de se afastarem da ilha. Os barcos movem-se logo a seguir ao jogador mandar um tiro. Cada um dos barcos tem movimentos independentes.

- **Movimento da mira** - O jogador pode movimentar a mira com as setas do teclado de acordo com o alvo que deseja acertar. Assim a mira movimenta-se em qualquer sentido ortogonal, desde que este não passe dos limites do mapa.

- **Níveis de dificuldade** - Com o aumento do número do nível, aumenta a dificuldade do mesmo. Isto é, o tamanho dos barcos, da ilha do jogador e o número de barcos aumentam.

- **Leitura de instruções** - No menu principal, ao entrar no sub-menu 2 (Instruções), lê um ficheiro de texto e projeta-o no ecrã.

### 1.2 Features a Implementar

- **Níveis de dificuldade** - Os níveis de dificuldade apresentados como fácil, médio ou difícil têm a ver com os tamanhos dos barcos que vão aparecendo no mapa, que aumentam quanto maior for o nível de dificuldade, e com o tamanho da ilha, que aumenta também com o aumento do nível de dificuldade.

- **Power-ups** - Quando o jogador mira e manda um tiro num quadrado onde está um power-up, é acionado o power-up. Estes podem ser de diversos tipos, tiros mais poderosos ou ganhar tempo fazendo com que os barcos não se mexam durante alguns turnos.

- **Modo infinito** - O modo infinito partilha as regras do modo normal, mas só acaba quando o jogador perder e vai aumento a dificuldade gradualmente.

- **Leaderboards** - Para manter o jogo competitivo, o modo infinito tem uma leaderboard onde os jogadores podem ver as melhores pontuações e quem as obteve.

- **Importe de mapas** - É possível o jogador iniciar um jogo com um mapa feito por si a partir dum ficheiro de texto.

- **Leitura dos leaderboards** - No fim do modo infinito é lido o leaderboard a partir dum ficheiro de texto e, caso seja uma ronda que mereça estar no leaderboard, é escrito o nome do jogador e a pontuação para esse ficheiro de texto.

- **Modo Sandbox** - O utilizador consegue escolher tudo acerca do seu nível: a localização da sua ilha, o seu tamanho e o número de barcos.

## 2. Design

### General Structure
#### O Problema em Contexto:


#### O Modelo (Pattern):


#### Implementação: 
No que toca à implementação, temos três tipos de classes com o propósito de guardar informação, controlar a lógica do jogo e organizar os efeitos visuais do jogo no ecrã, que são, respetivamente, as classes model, controllers e viewers. Estas classesmvc estão interligadas entre si da seguinte maneira: 

<p align="center" justify="center">
  <img src="imagens/mvc.png"/>
</p>
<p align="center">
  <b><i>Fig 1. Model, Controller and Viewer pattern design</i></b>
</p>

#### Consequências:
- Um código bem organizado de acordo com o *Single Responsibility Principle*.
- Facilidade em implementar novas features

### Observadores e Ouvintes

#### O Problema en Contexto:


#### O Modelo (Pattern):



#### Implementação:



#### Consequências: 



### Battlefield Builder

#### O Problema en Contexto:


#### O Modelo (Pattern):



#### Implementação:



#### Consequências: 



### Different type of commands

#### O Problema en Contexto:


#### O Modelo (Pattern):



#### Implementação:



#### Consequências: 



### GUI

#### O Problema en Contexto:


#### O Modelo (Pattern):



#### Implementação:



#### Consequências: 


## Known Code Smells And Refactoring Suggestions
#### **Large Class**
Some classes (e.g. Game, Battlefield, Player) contain many fields and others (e.g. GUI interface) contain many methods. In both cases, we find it justifiable as the classes require these fields, in one hand the Game class is the main class of the program and it needs to store a considerable amount of data, on the other hand various methods are needed for the interface and it wouldn't make sense to split it into two separate ones (extract method).

#### **Data Class**
All model classes are Data Classes, as they contain only fields, and no behavior (dumb classes). This is caused by the **MVC** (Model-View-Controller) architectural pattern which holds the responsibility to the controller to implement the logic functionalities of each model.
This is not a bad code smell because it only exits due to the chosen design pattern.

#### **Alternative classes with different interfaces and Lazy Classes**
When we conceived the project ideas, we aspired various enemy types with different behaviours. However, with the project development, we decided to generalize our **Enemy Class** and differenciate, the divergent characteristics, from contrasting enemies based on their fields. As this classes only differ in the values passed to the **Enemy Class** constructor and have no other significant functions they are an example of **Alternative Classes with different interfaces and Lazy Classes**.

#### **Refused bequest**
In an attempt to generalize and simplify our code, various abstract classes and interfaces were created. Nevertheless this resulted in the rising of the **Refused bequest** smell. As a result, some subclasses inherited methods from its parent classes which are neither defined nor used. For example, the [**SwapCommand Class**](../src/main/java/com/g57/model/item/command/SwapCommand.java#L31).

#### **Feature envy and message chains**
As the result of the **MVC** (Model-View-Controller) pattern some of the controllers use is narrowed to its model method calls. Our controller envies its model.
Also, in order to access a certain model's parameter it is mandatory to start by making a request to its controller.

## Testing

### Screenshot of coverage report
<p align="center" justify="center">
  <img src="images/screenshots/codeCoverage"/>
</p>
<p align="center">
  <b><i>Fig 6. Code coverage screenshot</i></b>
</p>

### Link to mutation testing report
[Mutation tests](../build/reports/pitest/202105302045/index.html)

## Self-evaluation

The work was divided in a mutual way and we all contributed with our best. It helped us to enrich our java and principle/pattern knwoledge, as well as our team work.

- Donal Knuth: 33.3%
- Timothy J. Berners-Lee: 33.3%
- Vinton G. Cerf: 33.3%


## 3. Game States

O Island Defense começa com o mapa ocupado por uma ilha e por um barco inimigo. Na ilha encontra-se o jogador cujo objetivo é não deixar os barcos chegarem à ilha.

### Modo Normal

No modo de jogo normal, o jogo termina quando todos os barcos previstos forem destruídos ou quando pelo menos um dos barcos consegue desembarcar na ilha. A ação do jogador que faz desenvolver os Game States é o tiro. Assim enquanto o jogador move a mira, os barcos inimigos não desenvolvem qualquer ação. Após o tiro acertar, num barco, água ou power-up, os barcos inimigos têm um turno para fazer um de dois movimentos permitidos, ou avançam um quadrado no sentido que se encontram ou mudam de direção. Estes dois movimentos têm como única condição serem todos no sentido de chegar à ilha, isto é, um barco que se encontr a ir em direção À ilha não pode mudar de direção no sentido de se afastar dela. Um barco inimigo desaparece quando todos os seus segmentos sofrem um tiro. O diagrama abaixo representa a lógica do jogo.

//////colocar imagem

### Modo infinito

No modo de jogo infinito, o jogo termina quando pelo menos um dos barcos consegue desembarcar na ilha. Os restantes game states são iguais ao do modo normal. O diagrama abaixo representa a lógica do jogo.

//////colocar imagem
