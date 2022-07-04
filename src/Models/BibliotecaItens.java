package Models;
import java.util.ArrayList;

public class BibliotecaItens {
    public static ArrayList<Item> items;

    public BibliotecaItens() {
        Item vazio = new Item(0,"vazio");
        items.add(vazio);
    }

    public void addItem(Item item) { 
        items.add(item);
    }

    public Item getItem(int itemId) {
        for (Item item : items) {
            if(item.getId() == itemId){
                return item;
            }
        }
        return null;
    }
}


