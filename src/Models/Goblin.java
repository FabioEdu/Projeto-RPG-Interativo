package Models;

import java.util.Random;

public class Goblin extends Npc {
    public static int level = 1;
    public static Random aleatorio = new Random();

    public Goblin() {
        this.nome = toString();
        this.pontosSaude = 4 + aleatorio.nextInt(3) ;
        this.classeDeArmadura = 10+level;
        this.dano = 6;
        this.xp = 10;
    }

    public int turno(Player player){
        System.out.println();
        System.out.println("- TURNO -  \n");
        System.out.println("O Goblin te ataca com uma pequena adaga");
        Random aleatorio = new Random();
        int ataque = aleatorio.nextInt(20) + level;
        int danoAtaque = aleatorio.nextInt(dano) + level;
        if(ataque>player.classeArmadura){
            System.out.println("Ele te acerta causando " + danoAtaque + " de dano");
            return danoAtaque;
        }else{
            System.out.println("Porem erra miseravelmente :(\n");
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Goblin";
    }

    
}
