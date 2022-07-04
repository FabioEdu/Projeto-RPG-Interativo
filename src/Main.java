import java.util.Scanner;

import Database.Personagens;
import Models.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("BEM VINDO!");
        Player player;
        while(true){
            player = menuPrincipal();
            if(player == null){
                System.out.println("FIM");
                break;
            }else{
                menuPersonagem(player);
            }

        }

    }

    public static Player menuPrincipal(){
        Scanner teclado = new Scanner(System.in);
        String nome;
        int opcao;
        int classe;
        int opcPersonagem;
        Player player;
        while(true){
            System.out.print("##--     Menu Personagem   --##\n\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| Opção 1 - Novo Personagem   |\n");
            System.out.print("| Opção 2 - Carregar          |\n");
            System.out.print("| Opção 0 - Sair              |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");

            opcao = teclado.nextInt();
            System.out.println();
            if(opcao == 0){
                return null;
            }else if(opcao==1){
                System.out.print("Primeiro, digite o nome de seu personagem ");
                nome = teclado.next();
                System.out.println();
                while(true){
                    System.out.println("Agora escolha sua classe!\n");
                    System.out.print("|-----------------------------|\n");
                    System.out.print("| Opção 1 - Guerreiro         |\n");
                    System.out.print("| Opção 2 - Mago              |\n");
                    System.out.print("| Opção 3 - Assassino         |\n");
                    System.out.print("| Opção 0 - Voltar Menu       |\n");
                    System.out.print("|-----------------------------|\n\n");
                    classe = teclado.nextInt();
                    System.out.println();
                    if(classe==1||classe==0||classe==2||classe==3){
                        break;
                    }else{
                        System.out.println("Digite uma opção válida!!!\n\n");
                    }
                }
                if(classe==1){
                    player = new Guerreiro(nome);
                    Personagens.players.add(player); 
                    System.out.println("Parabens, o personagem " + player + " foi criado!\n");
                }else if(classe==2){
                    player = new Mago(nome);
                    Personagens.players.add(player);
                    System.out.println("Parabens, o personagem " + player + " foi criado!\n");
                }else if(classe==2){
                    player = new Assassino(nome);
                    Personagens.players.add(player);
                    System.out.println("Parabens, o personagem " + player + " foi criado!\n");
                }
                
            }
            else if(opcao==2){
                System.out.println("\nEscolha seu personagem:\n");
                System.out.println("(Digite o numero referente a ordem)\n");
                System.out.println(Personagens.players + "\n");
                opcPersonagem = teclado.nextInt() - 1;
                return Personagens.players.get(opcPersonagem);
            }
        }
        
    }

    public static void menuPersonagem(Player player){
        int opcao, opcCenario;
        Scanner teclado = new Scanner(System.in);
        while(true){
            System.out.print("##--          Menu        --##\n\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| Opção 1 - Cenarios          |\n");
            System.out.print("| Opção 2 - Ver Personagem    |\n");
            System.out.print("| Opção 3 - Como jogar?       |\n");
            System.out.print("| Opção 0 - Sair              |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: \n\n");
            opcao = teclado.nextInt();
            if(opcao==0){
                break;
            }else if (opcao==1){
                while(true){
                    System.out.print("##--        Cenarios       --##\n\n");
                    System.out.print("|-----------------------------|\n");
                    System.out.print("| Opção 1 - Batalha Teste     |\n");
                    System.out.print("| Opção 2 - Floresta Negra    |\n");
                    System.out.print("| Opção 0 - Sair              |\n");
                    System.out.print("|-----------------------------|\n");
                    System.out.print("Digite uma opção: \n\n");
                    System.out.println();
                    opcCenario = teclado.nextInt();
                    if(opcCenario==0){
                        break;
                    }else if(opcCenario==1){
                        Cenario1.capitulo1(player);
                        player.curarTotal();
                        System.out.println("Selecione um novo cenario para jogar:");
                    }else{
                        System.out.println("Digite uma opcao valida!!!");
                    }
                }
            }else if(opcao==2){
                player.mostraPlayer();
                System.out.println();
            }else if(opcao==3){
                System.out.println("Para jogar, voce precisa primeiro selecionar um cenario.\nUm cenario e uma historia ou uma batalha para seu personagem passar.\nCaso voce morra ou falhe o cenario, nao tem problema, seu personagem se cura e voce pode tentar novamente!");
                System.out.println();
            }else{
                System.out.println("Digite uma opcao valida!!!\n");
            }
        }
    }
}

