Projeto: Trabalho 1 - Experimentos em Complexidade

Este repositório contém um pequeno programa Java para realizar experimentos de complexidade de tempo, medindo:
- quantidade de operações elementares executadas por um algoritmo (cont_op);
- tempo de execução em milissegundos (tempo_ms) para diferentes tamanhos de entrada (n).

Como funciona (visão geral):
- A classe App coordena a execução. Para cada algoritmo (alg1..alg5) e para uma lista de valores de n, ela mede o número de operações e o tempo, imprimindo no formato CSV: "algoritmo,n,cont_op,tempo_ms".
- Cada algoritmo é implementado como um método estático run(int n) em seu respectivo arquivo em src/br/com/experimentos/alg.
- Um contrato funcional (interface) AlgFn é usado para permitir passar referências de método (AlgX::run) de forma genérica.
- A classe Resultado encapsula os dados de uma medição e fornece o método toCsv() para formatação.

Estrutura do projeto (com explicação):

Trabalho 1 - Experimentos em Complexidade.iml
- Arquivo de configuração/projeto do IntelliJ IDEA.

out\production\Trabalho 1 - Experimentos em Complexidade\...
- Saída de build (classes compiladas). Não precisa ser editada manualmente.

src\br\com\experimentos\App.java
- Ponto de entrada do programa. Define listas de n por algoritmo, cria o mapeamento de algoritmos, mede e imprime resultados.

src\br\com\experimentos\core\AlgFn.java
- Interface funcional (um único método long run(int n)). Permite referenciar métodos estáticos dos algoritmos.

src\br\com\experimentos\models\Resultado.java
- Modelo para guardar uma medição (algoritmo, n, contagem de operações e tempo). Fornece toCsv().

src\br\com\experimentos\alg\Alg1.java
src\br\com\experimentos\alg\Alg2.java
src\br\com\experimentos\alg\Alg3.java
src\br\com\experimentos\alg\Alg4.java
src\br\com\experimentos\alg\Alg5.java
- Conjunto de algoritmos de exemplo. Cada arquivo expõe um método estático run(int n) que executa o algoritmo e retorna a contagem de operações (long). O tempo é medido externamente por App.

Como executar (resumo):
- Compile o projeto (por exemplo, via IntelliJ ou javac) e execute a classe br.com.experimentos.App.
- A saída no console será um CSV com cabeçalho "algoritmo,n,cont_op,tempo_ms".
- Para gerar um arquivo CSV automaticamente, execute passando o argumento --out:
  - java -cp out br.com.experimentos.App --out resultados.csv
  - ou, se estiver usando o .jar: java -jar "Trabalho 1 - Experimentos em Complexidade.jar" --out resultados.csv
- Ajuste as listas nsAlg1..nsAlg5 dentro de App.java para testar outros tamanhos de entrada.


para rodar e colocar o arquivo csv numa pasta diferente da pasta do projeto utilize o comando abaixo e substitua o caminho pelo seu.
run 
```shell
java -cp "out\production\Trabalho 1 - Experimentos em Complexidade" br.com.experimentos.App --out "D:\Projetos\PUCRS\ALEST\resultados.csv"
```
