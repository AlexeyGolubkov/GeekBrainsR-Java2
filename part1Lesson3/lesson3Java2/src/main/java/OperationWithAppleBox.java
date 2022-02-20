import java.util.ArrayList;

public class OperationWithAppleBox implements Runnable {
    public ArrayBox arrayBoxApple=new ArrayBox();
    public void run() {

       ArrayList<Apple> arrayApple = new ArrayList<>();
        for (int i = 0; i < Main.NUMBERS_APPLE; i++) {

            arrayApple.add(new Apple());

        }

            //Кладем яблоки в ящики пока яблоки не закончаться(из-за ArrayBox ящики не кончаться никогда)
            while (arrayApple.size()>0)  {


                BoxForFruits boxForFruits = new BoxForFruits();

                // Заполняем новый ящик яблоками, пока не заполнится
                while (boxForFruits.isNotFulling()) {
                    if (arrayApple.size() < 1) {
                        break;
                    }
                    Apple one = arrayApple.remove(arrayApple.size() - 1);

                    boxForFruits.addFruit(one);

                }
                arrayBoxApple.addArrayBox (boxForFruits);

            }
        Main.addArrayBoxMain(arrayBoxApple);
            System.out.println("\n"+"Сделано и заполнено ящиков Apple: "+arrayBoxApple.getArrayBox().size());

    }
}
