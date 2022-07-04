package Models;
import java.util.Random;
import java.util.Scanner;

public class Assassino extends Player{

    public Assassino(String nome) {
        this.nome = nome;
        armaEquip = new Item(80, "Espada Curta", 6, 0);
        armaduraEquip = new Item(81, "Armadura de Peles", 1);
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
          pontosSaudeMax = 8;
        }else{
          pontosSaudeMax = pontosSaudeMax + (aleatorio.nextInt(8)) + 1;
        }
    }

    public int atacar(int ca) {
        Random aleatorio = new Random();
        int ataque = aleatorio.nextInt(20) + level;
        int dano = aleatorio.nextInt(armaEquip.dano) + level;
        if(ataque>ca){
            if(ataque>=19){
                System.out.println("Voce ataca com " + armaEquip);
                System.out.println("DANO CRITICO, inflingiu " + (dano*2) + " de dano ");
                return (dano*2);
            }else{
                System.out.println("Voce ataca com " + armaEquip + " causando " + dano + " de dano");
                return dano;
            }
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
          System.out.println("1. Ataque físico ---  2. Habilidades --- 0. Nao Fazer Nada '-' ");
          input = scan.nextInt();
          if(input==1){
            return atacar(npc.classeDeArmadura);
          }else if (input==2){
            return 0;
          }else if(input==0)
            System.out.println("Voce fica imovel");
            return 0;
        }
    }

    public void subirNivel() {
      
    }

    @Override
    public String toString() {
      return "[ " + nome + " - Assasino ]";
    }

    public int skillGolpeLetal(int ca){
      int dano;
      if(level<4){
        System.out.println(ANSI_YELLOW +"Voce se concentra e tenta acertar um ponto vital do inimigo"+ ANSI_RESET);
        dano = atacar(ca+3);
        return dano*2;
      }else if(level >= 5 && level <=8){
        System.out.println(ANSI_YELLOW +"Voce se concentra bastante e tenta acertar um golpe fatal no inimigo"+ ANSI_RESET);
        dano = atacar(ca+6);
        return (dano*2)+3;
      }else{
        System.out.println(ANSI_YELLOW +"Voce se concentra e tenta acertar um golpe capaz de matar o inimigo"+ ANSI_RESET);
        dano = atacar(ca+8);
        return (dano*2)+15;
      }
    }
}
