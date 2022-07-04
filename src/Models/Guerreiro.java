package Models;
import java.util.Random;
import java.util.Scanner;

public class Guerreiro extends Player {
    
    public Guerreiro(String nome) {
        this.nome = nome;
        armaEquip = new Item(78, "Espada", 8, 0);
        armaduraEquip = new Item(79, "Armadura de Couro", 2);
        setValues();
        pontosSaude = pontosSaudeMax;
      }
    
    public void mostraPlayer(){
        System.out.println(toString());
        System.out.println("Nivel: "+level+" -- HP: " + pontosSaude+"/"+pontosSaudeMax + " -- Armadura: "+classeArmadura+ " -- Equipado: " + armaEquip
        + "\nXP: "+ pontosExperiencia+"/"+pontosExperienciaMax);
    }  

    public void setValues() {
        Random aleatorio = new Random();
        if(level ==1){
          pontosSaudeMax = 10;
        }else{
          pontosSaudeMax = pontosSaudeMax + (aleatorio.nextInt(10)) + (level-1);
        }
    }

    public int atacar(int ca) {
        Random aleatorio = new Random();
        int ataque = aleatorio.nextInt(20) + level;
        int dano = aleatorio.nextInt(armaEquip.dano) + level;
        if(ataque>ca){
            System.out.println("Voce ataca com " + armaEquip + " causando " + dano + " de dano");
            return dano;
        }else{
            if(ataque<10){
              System.out.println("Voce tenta atacar porem erra !"); 
            }else{
              System.out.println("Voce tenta atacar porem seu ataque foi bloqueado !");
            }
            return 0;
        }
    }

    public int turno(Npc npc) {
        while(true){
          Scanner scan = new Scanner(System.in);
          int input, opc;
          System.out.println();
          mostraPlayer();
          System.out.println("- TURNO -  \n o que quer fazer?");
          System.out.println("1. Ataque físico ---  2. Habilidades --- 0. Nao Fazer Nada '-' \n");
          input = scan.nextInt();
          if(input==1){
            return atacar(npc.classeDeArmadura);
          }else if (input==2){
            while(true){
              System.out.println("Que habilidade deseja usar?\n");
              System.out.println("1. Voadora -- 0. SAIR");
              opc = scan.nextInt();
              if(opc==1){
                return skillVoadora();
              }else if(opc == 0){
                break;
              }else{
                System.out.println("Digite um comando valido");
              }
            }
          }else if(input==0){
            System.out.println("Voce fica imovel");
            return 0;
          }else{
            System.out.println("Digite um comando valido");
          }
        }
    }

    public void subirNivel() {
      
    }

    @Override
    public String toString() {
      return "[ " + nome + " - Guerreiro ]";
    }






    // Habilidades
    public int skillVoadora(){
      Random random = new Random();
      int dano;
      if(level<4){
        System.out.println("Voce pula e chuta com seus dois pes o inimigo");
        dano = (random.nextInt(12)+3);
        System.out.println(ANSI_YELLOW + "Você causou " + dano + " de dano no seu inimigo!" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Voce recebeu " + 3 + " de dano na queda" + ANSI_RESET);
        pontosSaude = pontosSaude-3;
        return dano;
      }else if(level >= 5 && level <=8){
        System.out.println("Voce pula e da uma voadora no inimigo");
        dano = (random.nextInt(25)+8);
        System.out.println(ANSI_YELLOW + "Você causou " + dano + " de dano no seu inimigo!" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Voce recebeu " + 8 + " de dano na queda" + ANSI_RESET);
        pontosSaude = pontosSaude-8;
        return dano;
      }else{
        System.out.println("Voce pula e da uma SUPER voadora no inimigo");
        dano = (random.nextInt(30)+15);
        System.out.println(ANSI_YELLOW + "Você causou " + dano + " de dano no seu inimigo!" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Voce recebeu " + 15 + " de dano na queda" + ANSI_RESET);
        pontosSaude = pontosSaude-15;
        return dano;
      }
    } 
    
}
