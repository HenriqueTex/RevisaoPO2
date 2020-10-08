
package revisao2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;



public class Revisao2 {
    public static int somar(int array[], int tamArray) {    //Função somar da Questão 8
        if (tamArray > 0) {
            int soma = array[tamArray - 1] + somar(array, tamArray - 1);
            return soma;
        } else {
            return 0;
        }
    }
    public static int somatorio(int n) {    //Função somatorio da Questão 9
        int i=0;
        if (n > 0) {
            int soma = (n*(n+1))+ somatorio(n-1);
            return soma;
        } else {
            return 0;
        }
    }
    
    
    public static void main(String[] args) throws FileNotFoundException {
        
        //Questão 6
        System.out.println("Questão 6:\n");
        Scanner grafotxt = new Scanner(new FileReader("C:\\Users\\fdrew\\Desktop\\Faculdade\\Pesquisao Operacional\\GrafoRevisao\\Grafo.txt") );
        int linhas=grafotxt.nextInt();
        int colunas=grafotxt.nextInt();
        int qtd_vertice = grafotxt.nextInt();
        int[][] grafo = new int[linhas][colunas];
        int[][] adj = new int[linhas][linhas];
        int grau=0;
        
        for(int i=0;i<linhas ;i++){             //preenchendo uma matriz com as informações do grafo        
            for(int j=0;j<colunas;j++){
                grafo[i][j]= grafotxt.nextInt();
                
            }
        }
        
        System.out.println("Informações do Grafo:"); // print da matriz do grafo
        for(int i=0;i<linhas ;i++){
            System.out.println(" ");
            for(int j=0;j<colunas;j++){
                System.out.print(grafo[i][j]+ " ");
            }
        }
        
        for (int i=0;i<linhas;i++){                 //preenchendo a matriz de adjacencia          
            adj[grafo[i][0]][grafo[i][1]]= grafo[i][2];
            adj[grafo[i][1]][grafo[i][0]] = grafo[i][2];
        }
                    
        System.out.println("\nMatriz de adjencia:");    //print da matriz de adjacencia
        
        for (int i=0;i<qtd_vertice;i++){
            System.out.println(" ");
            for(int j=0;j<qtd_vertice;j++){
                System.out.print(adj[i][j]+" ");
            }
        }
        System.out.println("\n");
        for(int i=0;i<qtd_vertice;i++){    //contagem do grau de cada vertice
            grau=0;
            for(int j=0;j<qtd_vertice;j++){
                if (adj[i][j]!=0){
                    grau++;
                }
            }
            System.out.println("O grau do vertice "+i+ " é: "+grau);
        }
        
        //Questão 7
        System.out.println("\nQuestão 7:\n");
        int vert_in;
        Scanner sc= new Scanner(System.in);
        System.out.println("Digite o Vertice a ser consultado:");
        vert_in=sc.nextInt();
        
        if(vert_in >=0 && vert_in <=5){
            System.out.println("Os vertices adjacentes a "+ vert_in +" são:");
            for(int i=0;i<qtd_vertice;i++){
                if(adj[vert_in][i]!=0){
                    System.out.print(i+", ");
                }
                
            }
        }
        else{
            System.out.println("Vertice invalido");
        }
        
        //Questão 8
        System.out.println("\nQuestão 8:\n");
        int[] vals = {1, 2, 3, 4, 5};
        System.out.println(somar(vals, vals.length));
        
        //Questão 9
        System.out.println("\nQuestão 9:\n");
        Random rand = new Random();
        int n = rand.nextInt(99);
        System.out.println(" O resultado do somatorio é:");
        System.out.println(somatorio(n));
        
        //Questão Extra1
        System.out.println("\nQuestãoExtra 1:\n");
        
        Scanner matrizEx1 = new Scanner(new FileReader("C:\\Users\\fdrew\\Desktop\\Faculdade\\Pesquisao Operacional\\Matriz\\MatrizExtra1.txt") );
        int[][] matrizcustos = new int [4][4];
        int k;
        int custofinal=0;
       
        for(int i=0;i<4;i++){                   //preenchendo a matriz
            for(int j=0;j<4;j++){
                matrizcustos[i][j]= matrizEx1.nextInt();
                
            }
        }
        
        
        k=rand.nextInt(10);
        System.out.println("numero de cidades: "+k);
        
        int[] itinerario= new int[k+1];
        System.out.println("itinerario:");
        for(int i=0;i<k;i++){
            itinerario[i]= rand.nextInt(3);
            System.out.print(itinerario[i]+",");
        }
        
        for(int i=0;i<k-1;i++){
            custofinal= custofinal + matrizcustos[itinerario[i]][itinerario[i+1]];
        }
        
        System.out.println("\ncusto final é de: " + custofinal);
        
        
        
        //QuestãoExtra2
        System.out.println("\nQuestãoExtra 2.a:\n");
        final int dim =4;
      
       Scanner matrizextra2 = new Scanner(new FileReader("C:\\Users\\fdrew\\Desktop\\Faculdade\\Pesquisao Operacional\\Matriz questão extra 2.txt") );
       int [][]matriz= new int[dim][dim];
       int estradasin=0,estradasout=0,compare=0,marcador=0;
       
       for(int i=0;i<dim;i++){              //preenchendo a matriz
           for(int j=0;j<dim;j++){
               matriz[i][j]=matrizextra2.nextInt();
           }
       }
        for(int i=0;i<dim;i++){              //Print da matriz
            System.out.println(" ");
            for(int j=0;j<dim;j++){
               System.out.print(matriz[i][j]+ " ");
           }
       }
       
        //Exercicio 2.A
        
        
        System.out.println("\n Digite a cidade para consulta de numero de estradas: ");
        int x = sc.nextInt();
        
        for(int i=0;i<dim;i++){             //Contando estradas que chegam
            if(matriz[i][x]!=0)
                estradasin++;
        }
        for(int i=0;i<dim;i++){             //Contando estradas que saem 
            if(matriz[x][i]!=0)
                estradasout++;
        }
        System.out.println("O numero de estradas que chegam é: "+ (estradasin-1) + "\n" + "O numero de estradas que saem é: "+ (estradasout-1));
        estradasin=0;
        
        //Exercicio 2.B
        System.out.println("\nQuestãoExtra 2.b:\n");
        
        for(int i=0;i<dim;i++){
            
            estradasin=0;
            for(int j=0;j<dim;j++){
                if(matriz[j][i]!=0)
                    estradasin++;
                    if(compare<=estradasin){
                        compare=estradasin;
                        marcador=i;
                        }
                    //System.out.println( " " + marcador+(estradasin));
            }
        }
        System.out.println("A cidade em que chega o maior numero de estrada é a "+ marcador +" e o numero de estradas é "+(compare-1));
}
}
