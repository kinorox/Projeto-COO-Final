Projeto de COO - 1ºsemestre/2014
Reorganização do código de um jogo
Descrição
Este projeto consiste na reorganização do código de um jogo, disponibilizado no arquivo 
ProjetoCOO.zip, de modo a aplicar diversos conceitos estudados na disciplina Computação Orientada 
a Objetos. O jogo, implementado na linguagem Java, trata-se de um shoot 'em up 
(http://en.wikipedia.org/wiki/Shoot_'em_up) vertical bastante simples, sem acabamento (não possuindo 
tela de título, placar, vidas, fases, chefes, power-ups, etc) e que roda de forma indefinida (até que o 
usuário o feche).
Embora funcione, seu código não foi elaborado seguindo bons princípios de orientação a objetos (na 
realidade, o código foi elaborado seguindo um estilo de programação estruturada, e mesmo assim não 
muito bem feito, com muita repetição de código), havendo enumeras oportunidades de melhoria. Há 
três principais aspectos do código que devem ser melhorados na realização deste projeto:
– Aplicação de princípios de orientação a objetos, através da definição de uma boa estrutura de 
classes, interfaces e hierarquia de classes/interfaces.
– Uso da API de coleções do Java ao invés de arrays para manter/gerenciar conjunto de 
informações relativas às entidades do jogo (inimigos, projéteis, etc).
– Aplicação de padrões de projeto, com o objetivo de tornar a extensão/manutenção do código 
mais fácil e flexível.
O código fonte do jogo é composto por dois arquivos fonte: Main.java e GameLib.java. No primeiro 
arquivo está implementada toda a lógica do jogo, enquanto o segundo implementa uma mini biblioteca 
com recursos úteis no desenvolvimento de jogos: inicialização da interface gráfica, desenho de figuras 
geométricas e verificação de entrada através do teclado. 
O foco da reorganização do código deve ser em relação à classe Main. Você pode assumir que a classe 
GameLib é uma caixa-preta à qual você não tem acesso ao fonte (como se realmente fosse uma 
biblioteca feita por terceiros) e portanto ela não precisa ser retrabalhada na reorganização do código do 
jogo, apenas utilizada. Contudo, se por algum motivo você desejar modificá-la, para melhorá-la ou 
aplicar algum padrão de projeto, fique à vontade também.
Além da reorganização do código, você também deve implementar um novo tipo de inimigo que deve 
apresentar comportamento de movimento e de disparo de tiros diferente dos comportamentos 
apresentados pelos dois tipos de inimigos já presentes no jogo.Fará parte ainda do trabalho a elaboração de um relatório onde devem ser documentadas:
– Suas críticas ao código original do jogo.
– Descrição e justificativa da nova estrutura de classes/interfaces adotada.
– Descrição de como a API de coleções foi utilizada.
– Descrição dos padrões de projetos adotados e justificativa para a aplicação dos mesmos.
Observações sobre o uso da API de coleções
Na versão original do código, é feito uso extensivo de arrays para gerenciar conjuntos de informações 
relacionados às diversas entidades do jogo (inimigos, projéteis, etc). Devido ao fato de arrays serem 
estruturas de armazenamento estáticas, todos os arrays são alocados com tamanhos fixos e suas 
posições são reutilizadas sempre que uma entidade relacionada a determinado índice torna-se inativa 
(quanto sai da tela, no caso dos inimigos e projéteis, ou quando é abatido pelo jogador, no caso dos 
inimigos). 
Ao usar a API de coleções do Java para armazenar e gerenciar os conjuntos de entidades, a reutilização 
de posições deixa de ser necessária pois todas as coleções implementadas pelo Java são dinâmicas. 
Contudo, não podemos esquecer de remover entidades que tornam-se inativas da coleção que as 
armazena, caso contrário se estará sujeito a vazamentos de memória.
Entrega
Este projeto pode ser feito em grupos de 4 a 5 pessoas. Deverá ser entregue:
– Código fonte reorganizado.
– Relatório (em formato PDF).
A entrega deverá ser feita pelo TIDIA-Ae, até o dia 31/07/2014. Entregue um arquivo .zip contendo 
tanto o código reorganizado quanto o relatório em formato PDF