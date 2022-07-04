package Models;
public class Cenario1 {
    
    public  static void capitulo1(Player player){
        System.out.println("BATALHA TESTE");
        Goblin goblin = new Goblin();
        boolean batalha1;
        batalha1 = Player.batalha(goblin, player);
        if(batalha1){
            System.out.println("Parabéns! Voce terminou o cenario de batalha teste\n");
            player.adicionarXp(10);
        }else{
            System.out.println("Voce falhou esse cenario!");
            return;
        }
    }
}
