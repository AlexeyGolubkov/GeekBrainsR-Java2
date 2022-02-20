import java.util.ArrayList;

public class OperationWithOrangeBox implements Runnable {
    public ArrayBox arrayBoxOrange=new ArrayBox();
    public void run() {

        ArrayList<Orange> arrayOrange = new ArrayList<>();
        for (int i = 0; i < Main.NUMBERS_ORANGE; i++) {

            arrayOrange.add(new Orange());

        }

        //Кладем апельсины в ящики пока апельсины не закончаться (из-за ArrayBox ящики не кончаться никогда)
        while (arrayOrange.size()>0)  {

            BoxForFruits boxForFruits = new BoxForFruits();

            // Заполняем новый ящик яблоками, пока не заполнится
            while (boxForFruits.isNotFulling()) {
                if (arrayOrange.size() < 1) {
                    break;
                }
                Orange one = arrayOrange.remove(arrayOrange.size() - 1);

                boxForFruits.addFruit(one);

            }

            arrayBoxOrange.addArrayBox(boxForFruits);

        }
        Main.addArrayBoxMain(arrayBoxOrange);
        System.out.println("\n"+"Сделано и заполнено ящиков Orange: "+ arrayBoxOrange.getArrayBox().size());

    }
}