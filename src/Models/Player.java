package Models;

import java.util.Scanner;

public abstract class Player{
    public String nome;
    public int pontosSaude;
    public int pontosSaudeMax;
    public int classeArmadura = 10;
    public long pontosExperiencia = 0;
    public int level = 1;
    public Item armaduraEquip = null;
    public Item armaEquip = null;
    public Inventario inventario;
    public int inventario2[] = {0,0,0,0,0,0,0,0,0,0};
    public int pontosExperienciaMax = 50;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";


    public abstract void setValues();
    public abstract int turno(Npc npc);
    public abstract void subirNivel();
    public abstract int atacar(int ca);
    public abstract void mostraPlayer();
    public abstract String toString();

    public void curarTotal(){
        pontosSaude = pontosSaudeMax;
    }
    
    public static boolean batalha(Npc npc, Player player){
        System.out.println("Voce inicia uma batalha com " + npc + "!!!");
        while(true){
            npc.pontosSaude = npc.pontosSaude - player.turno(npc);
            if(npc.pontosSaude<=0) {
                System.out.println("- Voce venceu!!");
                player.adicionarXp(npc.xp);
                return true;
            }
            player.pontosSaude = player.pontosSaude - npc.turno(player);
            if(player.pontosSaude<=0){
                System.out.println("- Voce Morreu!!");
                return false;
            }
        }
    }

    public void adicionarXp(int xp){
        System.out.println("Voce ganhou "+xp+" pontos de expeiencia");
        pontosExperiencia = pontosExperiencia+xp;
        while(true){
            if(pontosExperiencia>pontosExperienciaMax){
                level++;
                pontosExperienciaMax = pontosExperienciaMax*2;
                setValues();
                System.out.println("Voce subiu de nivel!!");
            }else{
                break;
            }
        }
    }

    public void usarItem(BibliotecaItens biblioteca){
        Scanner teclado = new Scanner(System.in);
        Item item;
        int itemId;
        int input;
        while(true){
            itemId = inventario.selecionarItem(biblioteca);
            if(itemId==0){
                break;
            }else{
                item = biblioteca.getItem(itemId);
                if(item.bonusCa==null && item.dano==null){
                System.out.println("  O que deseja fazer com " + item + "?");
                while(true){
                    System.out.println("0. NADA (Voltar)");
                    System.out.println("1. Jogar fora");
                    input = teclado.nextInt();
                    if(input==0){
                        break;
                    }else if (input == 1){
                        System.out.println("Voce jogou fora " + item);
                        switch(inventario.vez){
                            case 1: 
                                inventario.item1 = 0;
                                break;
                            case 2:
                                inventario.item2 = 0;
                                break;
                            case 3: 
                                inventario.item3 = 0;
                                break;
                            case 4: 
                                inventario.item4 = 0;
                                break;
                            case 5: 
                                inventario.item5 = 0;
                                break;
                            case 6: 
                                inventario.item6 = 0;
                                break;
                            case 7: 
                                inventario.item7 = 0;
                                break;
                            case 8: 
                                inventario.item8 = 0;
                                break;
                            case 9: 
                                inventario.item9 = 0;
                                break;
                            case 10: 
                                inventario.item10 = 0;
                                break;
                        }
                        break;
                    }
                }
                }else if(item.bonusCa==null){
                System.out.println("  O que deseja fazer com " + item + "?");
                while(true){
                    System.out.println("0. NADA (Voltar)");
                    System.out.println("1. Equipar");
                    System.out.println("2. Jogar fora");
                    input = teclado.nextInt();
                    if(input==0){
                        break;
                    }
                    if(input ==1){
                        if(armaEquip==null){
                            armaEquip = item;
                            System.out.println("Voce equipou " + item);
                            break;
                        }else{
                            switch(inventario.vez){
                                case 1: 
                                    inventario.item1 = armaEquip.id;
                                    break;
                                case 2:
                                    inventario.item2 = armaEquip.id;
                                    break;
                                case 3: 
                                    inventario.item3 = armaEquip.id;
                                    break;
                                case 4: 
                                    inventario.item4 = armaEquip.id;
                                    break;
                                case 5: 
                                    inventario.item5 = armaEquip.id;
                                    break;
                                case 6: 
                                    inventario.item6 = armaEquip.id;
                                    break;
                                case 7: 
                                    inventario.item7 = armaEquip.id;
                                    break;
                                case 8: 
                                    inventario.item8 = armaEquip.id;
                                    break;
                                case 9: 
                                    inventario.item9 = armaEquip.id;
                                    break;
                                case 10: 
                                    inventario.item10 = armaEquip.id;
                                    break;
                            }
                            armaEquip = item;
                            System.out.println("Voce equipou " + item);
                            System.out.println(item + " foi adicionado ao seu inventario");
                            break;
                        }
                    }
    
    
                    if (input == 2){
                        System.out.println("Voce jogou fora " + item);
                        switch(inventario.vez){
                            case 1: 
                                inventario.item1 = 0;
                                break;
                            case 2:
                                inventario.item2 = 0;
                                break;
                            case 3: 
                                inventario.item3 = 0;
                                break;
                            case 4: 
                                inventario.item4 = 0;
                                break;
                            case 5: 
                                inventario.item5 = 0;
                                break;
                            case 6: 
                                inventario.item6 = 0;
                                break;
                            case 7: 
                                inventario.item7 = 0;
                                break;
                            case 8: 
                                inventario.item8 = 0;
                                break;
                            case 9: 
                                inventario.item9 = 0;
                                break;
                            case 10: 
                                inventario.item10 = 0;
                                break;
                        }
                        break;
                    }
                }
                }else if(item.dano==null){
                System.out.println("  O que deseja fazer com " + item + "?");
                while(true){
                    System.out.println("0. NADA (Voltar)");
                    System.out.println("1. Equipar");
                    System.out.println("2. Jogar fora");
                    input = teclado.nextInt();
                    if(input==0){
                        break;
                    }
                    if(input ==1){
                        if(armaduraEquip==null){
                            armaduraEquip = item;
                            classeArmadura = 10 + armaduraEquip.bonusCa;
                            System.out.println("Voce equipou " + item);
                            break;
                        }else{
                            switch(inventario.vez){
                                case 1: 
                                    inventario.item1 = armaduraEquip.id;
                                    break;
                                case 2:
                                    inventario.item2 = armaduraEquip.id;
                                    break;
                                case 3: 
                                    inventario.item3 = armaduraEquip.id;
                                    break;
                                case 4: 
                                    inventario.item4 = armaduraEquip.id;
                                    break;
                                case 5: 
                                    inventario.item5 = armaduraEquip.id;
                                    break;
                                case 6: 
                                    inventario.item6 = armaduraEquip.id;
                                    break;
                                case 7: 
                                    inventario.item7 = armaduraEquip.id;
                                    break;
                                case 8: 
                                    inventario.item8 = armaduraEquip.id;
                                    break;
                                case 9: 
                                    inventario.item9 = armaduraEquip.id;
                                    break;
                                case 10: 
                                    inventario.item10 = armaduraEquip.id;
                                    break;
                            }
                            armaduraEquip = item;
                            classeArmadura = 10 + armaduraEquip.bonusCa;
                            System.out.println("Voce equipou " + item);
                            System.out.println(item + " foi adicionado ao seu inventario");
                            break;
                        }
                    }
    
    
                    if (input == 2){
                        System.out.println("Voce jogou fora " + item);
                        switch(inventario.vez){
                            case 1: 
                                inventario.item1 = 0;
                                break;
                            case 2:
                                inventario.item2 = 0;
                                break;
                            case 3: 
                                inventario.item3 = 0;
                                break;
                            case 4: 
                                inventario.item4 = 0;
                                break;
                            case 5: 
                                inventario.item5 = 0;
                                break;
                            case 6: 
                                inventario.item6 = 0;
                                break;
                            case 7: 
                                inventario.item7 = 0;
                                break;
                            case 8: 
                                inventario.item8 = 0;
                                break;
                            case 9: 
                                inventario.item9 = 0;
                                break;
                            case 10: 
                                inventario.item10 = 0;
                                break;
                        }
                        break;
                    }
                }
            }
            
            }
        }
    }

    public void adicionarItem(BibliotecaItens biblioteca, int itemId){
        int itemSelected = 0;
        while(true){
            if(inventario.item1 == 0) {
                inventario.item1 = itemId;
                break;
            }else if(inventario.item2 == 0) {
                inventario.item2 = itemId;
                break;
            }else if(inventario.item3 == 0) {
                inventario.item3 = itemId;
                break;
            }else if(inventario.item4 == 0) {
                inventario.item4 = itemId;
                break;
            }else if(inventario.item5 == 0) {
                inventario.item5 = itemId;
                break;
            }else if(inventario.item6 == 0) {
                inventario.item6 = itemId;
                break;
            }else if(inventario.item7 == 0) {
                inventario.item7 = itemId;
                break;
            }else if(inventario.item8 == 0) {
                inventario.item8 = itemId;
                break;
            }else if(inventario.item9 == 0) {
                inventario.item9 = itemId;
                break;
            }else if(inventario.item10 == 0) {
                inventario.item10 = itemId;
                break;
            }else{
                System.out.println("para adiconar este item, \n voce precisa remover outro de sua mochila!");
                while(itemSelected == 0){
                    System.out.println("voce precisa remover algum item!!!!!");
                    itemSelected = inventario.selecionarItem(biblioteca);
                }
                removerItem(itemSelected);
            }
        }
    }
    public boolean removerItem(int itemId){
        while(true){
            if(inventario.item1 == itemId) {
                inventario.item1 = 0;
                return true;
            }else if(inventario.item2 == itemId) {
                inventario.item2 = 0;
                return true;
            }else if(inventario.item3 == itemId) {
                inventario.item3 = 0;
                return true;
            }else if(inventario.item4 == itemId) {
                inventario.item4 = 0;
                return true;
            }else if(inventario.item5 == itemId) {
                inventario.item5 = 0;
                return true;
            }else if(inventario.item6 == itemId) {
                inventario.item6 = 0;
                return true;
            }else if(inventario.item7 == itemId) {
                inventario.item7 = 0;
                return true;
            }else if(inventario.item8 == itemId) {
                inventario.item8 = 0;
                return true;
            }else if(inventario.item9 == itemId) {
                inventario.item9 = 0;
                return true;
            }else if(inventario.item10 == 0) {
                inventario.item10 = 0;
                return true;
            }else{
                System.out.println("Voce nao possui este item !");
                return false;
            }
        }
    }
    
    public String getNome() {
        return nome;
    }


    public Long getExperiencePoints() {
        return pontosExperiencia;
    }

    public void setExperiencePoints(Long experiencePoints) {
        this.pontosExperiencia = experiencePoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    public Integer getHealthPoints() {
        return pontosSaude;
    }
    public void setHealthPoints(Integer healthPoints) {
        this.pontosSaude = healthPoints;
    }
    public Integer getClasseArmadura() {
        return classeArmadura;
    }

}
