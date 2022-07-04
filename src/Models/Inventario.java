package Models;

import java.util.Scanner;

public class Inventario {
    int vez;
    int item1, item2, item3, item4, item5, item6, item7, item8, item9, item10 = 0;

    

    public Inventario() {
        
    }

    public int selecionarItem(BibliotecaItens biblioteca) {
        Scanner teclado = new Scanner(System.in);
        int cont = 1;
        int contShow = 0;
        while(true){
            System.out.println("Você abre sua mochila \n Escolha um item:");
            System.out.println("0. SAIR DO INVENTARIO");
            while(cont<=10){
            System.out.print((contShow+1) +". ");
            switch(cont){
                case 1: 
                    if(item1==0){break;}
                    System.out.print(biblioteca.getItem(item1));
                    contShow++;
                    if(contShow==1 || (contShow%2)==1){
                        System.out.print(" ");
                    }else{
                        System.out.println();
                    }
                    break;
                case 2:
                    if(item2==0){break;}
                    System.out.print(biblioteca.getItem(item2));
                    contShow++;
                    if(contShow==1 || (contShow%2)==1){
                        System.out.print(" ");
                    }else{
                        System.out.println();
                    }
                    break;
                case 3: 
                    if(item3==0){break;}
                    System.out.print(biblioteca.getItem(item3));
                    contShow++;
                    if(contShow==1 || (contShow%2)==1){
                        System.out.print(" ");
                    }else{
                        System.out.println();
                    }
                    break;
                case 4: 
                    if(item4==0){break;}
                    System.out.print(biblioteca.getItem(item4));
                    contShow++;
                    if(contShow==1 || (contShow%2)==1){
                        System.out.print(" ");
                    }else{
                        System.out.println();
                    }
                    break;
                case 5: 
                    if(item5==0){break;}
                    System.out.print(biblioteca.getItem(item5));
                    contShow++;
                    if(contShow==1 || (contShow%2)==1){
                        System.out.print(" ");
                    }else{
                        System.out.println();
                    }
                    break;
                case 6: 
                    if(item6==0){break;}
                    System.out.print(biblioteca.getItem(item6));
                    contShow++;
                    if(contShow==1 || (contShow%2)==1){
                        System.out.print(" ");
                    }else{
                        System.out.println();
                    }
                    break;
                case 7: 
                    if(item7==0){break;}
                    System.out.print(biblioteca.getItem(item7));
                    contShow++;
                    if(contShow==1 || (contShow%2)==1){
                        System.out.print(" ");
                    }else{
                        System.out.println();
                    }
                    break;
                case 8: 
                    if(item8==0){break;}
                    System.out.print(biblioteca.getItem(item8));
                    contShow++;
                    if(contShow==1 || (contShow%2)==1){
                        System.out.print(" ");
                    }else{
                        System.out.println();
                    }
                    break;
                case 9: 
                    if(item9==0){break;}
                    System.out.print(biblioteca.getItem(item9));
                    contShow++;
                    if(contShow==1 || (contShow%2)==1){
                        System.out.print(" ");
                    }else{
                        System.out.println();
                    }
                    break;
                case 10: 
                    if(item10==0){break;}
                    System.out.print(biblioteca.getItem(item10));
                    contShow++;
                    break;
            }
            cont++;
        }
            cont = 1;
            contShow = 0;
            int itemSelected = teclado.nextInt();  
            switch(itemSelected){
                case 0:
                    return 0;
                case 1: 
                    vez = itemSelected;
                    return item1;
                case 2:
                    vez = itemSelected;
                    return item2;
                case 3: 
                    vez = itemSelected;
                    return item3;
                case 4: 
                    vez = itemSelected;
                    return item4;
                case 5: 
                    vez = itemSelected;
                    return item5;
                case 6: 
                    vez = itemSelected;
                    return item6;
                case 7: 
                    vez = itemSelected;
                    return item7;
                case 8: 
                    vez = itemSelected;
                    return item8;
                case 9: 
                    vez = itemSelected;
                    return item9;
                case 10: 
                    vez = itemSelected;
                    return item10;
            }
        }

    }


    
}
