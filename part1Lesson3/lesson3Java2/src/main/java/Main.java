import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
public class Main {
    public final static int HEIGHT_BOX = 10;
    public final static int WIDTH_BOX = 30;
    public final static int LONG_BOX = 10;
    public final static int NUMBERS_BOX_FOR_HOME_TASK_1_ONLY = 5;
    public final static int NUMBERS_ORANGE = 9800;
    public final static int NUMBERS_APPLE = 9900;
    public static double coifFullingBox = 0.6;
    public static double ADD_PERCENT_FOR_FULLING = 5;
    private static final Logger logger = Logger.getLogger("data.log");
    // DELTA_OF_UNCERTAINTY was input for calculate a weight of equal boxes
    public final static double DELTA_OF_UNCERTAINTY = 10;
    public static List<ArrayBox> arrayArrayBox =  Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws NullPointerException, MyArraySizeException {

        BoxForFruits[] boxForTask1=new BoxForFruits[NUMBERS_BOX_FOR_HOME_TASK_1_ONLY];


       Thread sortApple = new Thread(new OperationWithAppleBox());
       Thread sortOrange = new Thread(new OperationWithOrangeBox());

        sortOrange.start();
        sortApple.start();

        try {
            sortApple.join();
            sortOrange.join();
        } catch(InterruptedException exc) {
            System.out.println(exc.getMessage());
        }
/*        sortOrange.stop();
        sortApple.stop();*/

// For Exercise 1 of Home Task

    ArrayBox lastArrayBox = arrayArrayBox.get(1);
    ArrayBox firstArrayBox = arrayArrayBox.get(0);

int numberLastBoxLastArrayBox=lastArrayBox.getArrayBox().size()-1;
int numberFirstBoxFirstArrayBox=firstArrayBox.getArrayBox().size()-1;

BoxForFruits lastBoxForFruits =  (BoxForFruits) lastArrayBox.getArrayBox().get(numberLastBoxLastArrayBox);
BoxForFruits firstBoxForFruits= (BoxForFruits) lastArrayBox.getArrayBox().get(0);
        System.out.println("Сравниваем два ящика:");
boolean flagEqualOfFruitInBox = compare(firstBoxForFruits,lastBoxForFruits );
        System.out.println("compare(firstBoxForFruits,lastBoxForFruits) = " + flagEqualOfFruitInBox);
        System.out.println("firstBoxForFruits" + firstBoxForFruits);
        System.out.println("lastBoxForFruits" + lastBoxForFruits);
        boxForTask1[0]=firstBoxForFruits;
        boxForTask1[1]=firstBoxForFruits;
        lastBoxForFruits =  (BoxForFruits) firstArrayBox.getArrayBox().get(numberFirstBoxFirstArrayBox-1);
        firstBoxForFruits= (BoxForFruits) firstArrayBox.getArrayBox().get(numberFirstBoxFirstArrayBox-2);
        System.out.println("Сравниваем ещё два ящика:");
        flagEqualOfFruitInBox = compare(firstBoxForFruits,lastBoxForFruits );
        System.out.println("compare(preLastBoxForFruits,lastBoxForFruits) = " + flagEqualOfFruitInBox);
        System.out.println("preLastBoxForFruits" + firstBoxForFruits);
        System.out.println("prePrelastBoxForFruits" + lastBoxForFruits);
        boxForTask1[2]=firstBoxForFruits;
        boxForTask1[3]=firstBoxForFruits;


// обнаруживаем, что в ящике можно использовать еще addPercentForFulling% свободного объема
        recordAndOutDataAboutBox(ADD_PERCENT_FOR_FULLING);


        Thread emptyApple = new Thread(new EmptyAppleBox());
        Thread emptyOrange = new Thread(new EmptyOrangeBox());

        emptyApple.start();
        emptyOrange.start();


        try {
        emptyOrange.join();
        emptyApple.join();
        } catch(InterruptedException exc) {
            System.out.println(exc.getMessage());
        }
/*        recordAndOutDataAboutBox("Orange");
        recordAndOutDataAboutBox("Apple");*/
        recordAndOutDataAboutBox(0);
        System.out.println("Exercise 1 from Home Task\n До замены:");
        for (int i=0;i<NUMBERS_BOX_FOR_HOME_TASK_1_ONLY-1;i++){

            System.out.println(i+" Box from Home Task"+boxForTask1[i].getArrayFruitInBox());
        }

        boxForTask1=changing (boxForTask1,0, NUMBERS_BOX_FOR_HOME_TASK_1_ONLY-2);

        System.out.println("После замены:");
        for (int i=0;i<NUMBERS_BOX_FOR_HOME_TASK_1_ONLY-1;i++){

            System.out.println(i+" Box from Home Task"+boxForTask1[i].getArrayFruitInBox());
        }

    }

    public static boolean compare (BoxForFruits Box1, BoxForFruits Box2 ) throws NullPointerException {
        try {
            System.out.println(("Weight netto:"+Box1.getResultWeight()) + " V:" + Box1.getResultV());
            System.out.println(("Weight netto:"+Box2.getResultWeight()) + " V:" + Box2.getResultV());
            return Math.abs((Box1.getResultWeight()) - (Box2.getResultWeight())) < DELTA_OF_UNCERTAINTY;

        } catch (NullPointerException e) {
            logger.severe(new Date() + "<NullPointerException_compare>" + e);
            BoxForFruits box = new BoxForFruits();
            Box2 = box;
            Box1 = box;
            System.out.println(("Interruption: "+Box1.getResultWeight()) + " V:" + Box1.getResultV() + ">" + Box1.getFruit());
            System.out.println(("Interruption: "+Box2.getResultWeight()) + " V:" + Box2.getResultV() + ">" + Box2.getFruit());

        }

        return Math.abs((Box1.getResultWeight()) - (Box2.getResultWeight())) < DELTA_OF_UNCERTAINTY;


    }
    public static void addArrayBoxMain(ArrayBox arrayBox) {
        arrayArrayBox.add(arrayBox);

    }
    public static void recordAndOutDataAboutBox (double percent) { //for future optimization String typeFruitOfBox
        boolean flagAddVolume=false;


        int sizeOfArrayArrayBox=arrayArrayBox.size();
        if (percent == ADD_PERCENT_FOR_FULLING) {
            coifFullingBox = coifFullingBox * (100 + ADD_PERCENT_FOR_FULLING) / 100;
            flagAddVolume=true;
        }
        for (int j = 0; j < sizeOfArrayArrayBox; j++) {
            ArrayBox currentArrayBox = arrayArrayBox.get(j);

            List<BoxForFruits> arrayBoxNew = new ArrayList<>();
            for (int i = 0; i < currentArrayBox.getArrayBox().size(); i++) {
// for checking IndexOutOfBoundsException - threads was reasons ))
                if (percent<0) {
                    System.out.println("DEBUGGER_IndexOutOfBoundsException"+currentArrayBox.getArrayBox().get(i));
                }
                BoxForFruits box = (BoxForFruits) currentArrayBox.getArrayBox().get(i);

               if (flagAddVolume) {
                   // ставим пометку, что ящик не до конца наполнен
                   box.setFreePlaceForFulling();
               }

                arrayBoxNew.add(box);

               // if (percent>0) {System.out.println("Main Box->"+ box.getArrayFruitInBox());}
            }

            arrayArrayBox.get(j).setArrayBox(arrayBoxNew);
        }

    }
    public static synchronized void recordAndOutDataAboutBox (String typeFruitOfBox) {
        int sizeOfArrayArrayBox=arrayArrayBox.size();
        int sizeOfArrayBox;
        for (int j=0;j<sizeOfArrayArrayBox;j++) {
            ArrayBox currentArrayBox=Main.arrayArrayBox.get(j);
            sizeOfArrayBox=currentArrayBox.getArrayBox().size()-1;

            BoxForFruits boxForEmpty= (BoxForFruits) currentArrayBox.getArrayBox().get(sizeOfArrayBox);




            List<BoxForFruits> arrayBoxNew = new ArrayList<>();
            boolean flagAction=false;
      for (int i = 0; i <sizeOfArrayBox-1; i++){
          if(!boxForEmpty.getFruit().equals(typeFruitOfBox)) {
              arrayBoxNew.addAll(currentArrayBox.getArrayBox());
              break;
          }

                BoxForFruits box= (BoxForFruits) currentArrayBox.getArrayBox().get(i);
                // пересыпаем ящики

                while ( (boxForEmpty.getArrayFruitInBox().size()>0)&&(box.isNotFulling())){
                    Fruit one = (Fruit) boxForEmpty.getArrayFruitInBox().remove(0);
                    box.addFruit(one);
                }
                arrayBoxNew.add(box);
                System.out.println(""+typeFruitOfBox+" boxForEmpty->"+boxForEmpty.getArrayFruitInBox());
                System.out.println(""+typeFruitOfBox+" newLastBox->"+ box.getArrayFruitInBox());
                if (boxForEmpty.getArrayFruitInBox().size()==0){
                    boxForEmpty.setFruit("empty");
                    System.out.println(""+typeFruitOfBox+" box is empty");
                    flagAction=true;
                    break;
                }

            }
            if(flagAction){
            arrayBoxNew.add(boxForEmpty);
            arrayArrayBox.get(j).setArrayBox(arrayBoxNew);}
        }
    }
        // method of changing for Exercise 1:

    private static BoxForFruits[] changing (BoxForFruits[]array,int index1, int index2) throws MyArraySizeException
    {
        if (index1 >= array.length || index2 >= array.length || index1 < 0 || index2 < 0) {
            generationException();
            System.out.println("Изменение не возможны! Массив меньше, чем индексы ящиков для перестановки");
        }
        BoxForFruits accumulator;
        accumulator = array[index1];
        array[index1] = array[index2];
        array[index2] = accumulator;
        return array;
    }




    private static void generationException () throws MyArraySizeException {
        throw new MyArraySizeException("Error size Array or Indexes of changing");


    }

}


