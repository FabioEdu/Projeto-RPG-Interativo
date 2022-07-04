package Models;
import java.util.Random;
import java.util.Scanner;

public class Mago extends Player{

    public Mago(String nome) {
      this.nome = nome;
      armaEquip = new Item(76, "Cajado", 4, 0);
      armaduraEquip = new Item(77, "robe", 0);
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
        pontosSaudeMax = 6;
      }else{
        pontosSaudeMax = pontosSaudeMax + (aleatorio.nextInt(6)) + 1;
      }
    }

    public int atacar(int ca) {
      Random aleatorio = new Random();
      int ataque = aleatorio.nextInt(20) + level;
      int dano = aleatorio.nextInt(armaEquip.dano) + 1;
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
        int input;
        System.out.println();
        mostraPlayer();
        System.out.println("- TURNO -  \n o que quer fazer?");
        System.out.println("1. Ataque físico ---  2. Magias/Habilidades --- 0. Nao Fazer Nada '-' ");
        input = scan.nextInt();
        if(input==1){
          return atacar(npc.classeDeArmadura);
        }else if (input==2){
          return magiaX();
        }else if(input==0)
          System.out.println("Voce fica imovel");
          return 0;
      }
    }

    public void subirNivel() {
      
    }

    public int magiaX() {
        Random aleatorio = new Random();
        if(level < 4){
          System.out.println(ANSI_YELLOW +"Voce dispara uma pequena esfera de energia flamejante."+ ANSI_RESET);
          int valor = aleatorio.nextInt(10) + level;
          System.out.println(ANSI_YELLOW + "Você causou "+ valor + " de dano ao seu inimigo!\n" + ANSI_RESET);
          return valor;
        }else if(level >= 5 && level <= 8){
          System.out.println(ANSI_YELLOW +"Voce dispara uma bola de fogo!!!"+ ANSI_RESET);
          int valor = aleatorio.nextInt(15) + level;
          System.out.println(ANSI_YELLOW + "Você causou "+ valor + " de dano no seu inimigo!\n" + ANSI_RESET);
          return valor;
        }else{
          System.out.println(ANSI_YELLOW +"Voce invoca uma enorme e incandescente esfera de fogo!!!");
          int valor = aleatorio.nextInt(30) + level;
          System.out.println(ANSI_YELLOW + "Você causou "+ valor + " de dano no seu inimigo!\n" + ANSI_RESET);
          return valor;
        }
      }

    @Override
    public String toString() {
      return "[ " + nome + " - Mago ]";
    }

}


