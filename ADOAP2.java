/*
Entrega a Atividade 1 - Algoritmos e Programação II

Nós,

Guilherme Henrique Veloso Santos
Levi Freitas da Silva
Pedro Henrique Melo da Silva
Rodrigo Eduardo Nogueira

declaramos que

todas as respostas são fruto de nosso próprio trabalho,
não copiamos respostas de colegas externos à equipe,
não disponibilizamos nossas respostas para colegas externos ao grupo e
não realizamos quaisquer outras atividades desonestas para nos beneficiar ou prejudicar outros.
*/

import java.util.Scanner;
import java.util.Random;

public class ADOAP2 {

    public static void main(String[] args) {
        // Sistem inicializa e informa o menu para o usuário
        imprimeMenu();
        // Usuário escolhe a opção
        Scanner leitor = new Scanner(System.in);
        int opcao = leitor.nextInt();
        int N = 0;
        int M = 0;
        int vetor[] = new int[N];

        if (opcao != 1) {
            while (opcao != 1) {
                System.out.println("Digite 1 para inicializar o vetor, ou 0 para encerrar o programa.");
                opcao = leitor.nextInt();
                if (opcao == 0) {
                    break;
                }
            }
        }
        switch (opcao) {
            case 1:

                System.out.println("Digite um valor N para determinar a quantidade de posições do vetor!");
                N = leitor.nextInt();
                System.out.println("Digite um valor para M para definir o limite dos números gerados");
                M = leitor.nextInt();
                vetor = inicializarVetor(N, M);
                System.out.println("O Vetor foi inicializado ");
                System.out.println("Seu vetor tem " + N + " posições.");
                System.out.println("Escolha outra opção");
                opcao = leitor.nextInt();
                if (opcao == 1) {
                    while (opcao == 1) {
                        System.out.println("O Vetor já foi inicializado, por favor digite outra opção");
                        System.out.println("Seu vetor tem " + N + " posições.");
                        opcao = leitor.nextInt();
                    }
                } else if (opcao == 0) {
                    break;
                }
        }

        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    System.out.println("O Vetor já foi inicializado, por favor digite outra opção");
                    opcao = leitor.nextInt();
                    break;
                case 2:

                    System.out.println("Opção 2!");
                    imprimir(vetor);

                    System.out.println("Digite uma nova opção");
                    opcao = leitor.nextInt();
                    break;

                case 3:

                    System.out.println("Opção 3!");
                    System.out.println("3. Verifica se existe determinado número no vetor. Digite um valor");
                    int numeroExiste = leitor.nextInt();

                    if (verificaNumero(vetor, numeroExiste) < 0) {
                        System.out.println("O número não foi encontrado");
                    } else {
                        System.out.println("O número foi encontrado na posição: ");
                        System.out.println(verificaNumero(vetor, numeroExiste));
                    }
                    System.out.println("Digite uma nova opção");
                    opcao = leitor.nextInt();
                    break;

                case 4:
                    System.out.println("Opção 4!");
                    System.out.println("4. Maior número no vetor. ");
                    System.out.println(maiorNumero(vetor));

                    System.out.println("Digite uma nova opção");
                    opcao = leitor.nextInt();
                    break;

                case 5:
                    System.out.println("Opção 5!");
                    System.out.println("5. Cálcula média. ");
                    System.out.println(calcMediaPares(vetor));

                    System.out.println("Digite uma nova opção");
                    opcao = leitor.nextInt();
                    break;

                case 6:
                    System.out.println("Opção 6!");
                    System.out.println("6. Percentual de números impares. ");
                    System.out.println(calcPercImpares(vetor) + "%");
                    System.out.println("Digite uma nova opção");
                    opcao = leitor.nextInt();
                    break;

                case 7:
                    System.out.println("Opção 7!");
                    System.out.println("7. Cálcula média centralizada. ");
                    System.out.println(calcMediaCentral(vetor));

                    System.out.println("Digite uma nova opção");
                    opcao = leitor.nextInt();
                    break;

                case 8:
                    System.out.println("Opção 8!");
                    System.out.println(
                            "8. Verificar se, dado um valor, existe dois números em posições distintas que somados é igual ao valor informado por parâmetro. ");
                    System.out.println("8. Digite um valor para verificação:");
                    int verificador = leitor.nextInt();
                    if (verificaValorSomado(vetor, verificador)) {
                        System.out.println("Sim, existe valores correspondentes para a soma de " + verificador);
                    } else {
                        System.out.println("Não, não existe varoles correspondentes para a soma de " + verificador);
                    }
                    System.out.println("Digite uma nova opção");
                    opcao = leitor.nextInt();
                    break;

                case 0:
                    System.out.println("0 dentro-------- Programa Encerrado --------");
                    opcao = leitor.nextInt();
                    break;

                default:
                    System.out.println("Opção invalida! Digite outra opção!");
                    imprimeMenu();
                    opcao = leitor.nextInt();
                    break;
            }
        }
        System.out.println("-------- Programa Encerrado --------");

    }
    // ------ Funções ------- //

    // Função que imprime menu de opções
    public static void imprimeMenu() {
        System.out.println("-------- Informe uma opção do menu --------");
        System.out.println("1. Inicialize o vetor. ");
        System.out.println("2. Imprima o vetor. ");
        System.out.println("3. Verifica se existe determinado número no vetor.");
        System.out.println("4. Maior número no vetor. ");
        System.out.println("5. Cálcula média. ");
        System.out.println("6. Percentual de números impares. ");
        System.out.println("7. Cálcula média centralizada. ");
        System.out.println(
                "8. Verificar se, dado um valor, existe dois números em posições distintas que somados é igual ao valor informado por parâmetro. ");
        System.out.println("0. Encerrar o programa. ");
    }

    // Função que inicializa o vetor (opção 1)
    public static int[] inicializarVetor(int N, int M) {
        Random aleatorio = new Random();
        int vetor[] = new int[N];
        for (int i = 0; i < N; i++) {
            vetor[i] = aleatorio.nextInt(M);
        }
        return vetor;
    }

    // Função que imprime vetor (opção 2)
    public static void imprimir(int[] v) {
        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);
        }

    }

    // Função verifica número dentro do vetor (opção 3)
    public static int verificaNumero(int[] v, int numExiste) {
        for (int i = 0; i < v.length; i++) {
            if (numExiste == v[i]) {
                return i;
            }
        }
        return -1;

    }

    // Função que retorna o maior número dentro do vetor (opção 4)
    public static int maiorNumero(int[] v) {
        int maior = v[0];
        for (int i = 0; i < v.length; i++) {
            maior = Math.max(maior, v[i]);
        }
        return maior;

    }

    // Função que calcula a média dos números pares armazenados no vetor; (opção 5)
    public static double calcMediaPares(int[] v) {
        double somaPares = 0;

        for (int i = 0; i < v.length; i++) {
            if (v[i] % 2 == 0) {
                somaPares += v[i];
            }

        }

        double media = somaPares / v.length;

        return media;

    }

    // Função que calcula o percentual dos números ímpares armazenados no
    // vetor;(opção 6)
    public static double calcPercImpares(int[] v) {
        double contador = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] % 2 != 0) {
                contador++;
            }
        }
        double percentual = contador / v.length * 100;

        return percentual;

    }

    // Função que calcula a média centralizada dos números armazenados no
    // vetor.(opção 7)
    public static double calcMediaCentral(int[] v) {
        double menor = v[0];
        double maior = v[0];
        double soma = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i] < menor) {
                menor = v[i];
            }
            if (v[i] > maior) {
                maior = v[i];
            }
            soma += v[i];
        }
        return (soma - menor - maior) / (v.length - 2);
    }

    // Função que Verificar se dado um valor existe dois números em posições
    // distintas que somados são iguais ao valor informado.(opção 8)
    public static boolean verificaValorSomado(int[] v, int valor) {
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                if (v[i] + v[j] == valor) {
                    return true;
                }
            }
        }
        return false;
    }
}
