package Models;

public class Item {
    int id;
    String nome;
    Integer dano = null;
    int enchant;
    Integer bonusCa = null;

    //Item Normal
    public Item(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    //Armadura
    public Item(int id, String nome, int bonusCa) {
        this.id = id;
        this.nome = nome;
        this.bonusCa = bonusCa;
    }

    //Arma
    public Item(int id, String nome, int dano, int enchant) {
        this.id = id;
        this.nome = nome;
        this.dano = dano;
        this.enchant = enchant;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return this.nome;
    }

}
