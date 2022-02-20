
import java.util.*;

public class BoxForFruits<T> {
    private ArrayList<T> arrayFruitInBox;
    private String fruit;
    private boolean freePlaceForFulling;
    private static int number=0;

    private static int heightBox;
    private static int widthBox;
    private static int longBox;
    private int idBox;
    private double resultWeight=0;
    private double resultV=0;

    public void setFruit(String fruit) {
        this.fruit = fruit;
        if (fruit.equals("empty")){
            this.resultWeight=0;
            this.resultV=0;
            this.freePlaceForFulling=true;
        }
    }

    public BoxForFruits() {
        this.arrayFruitInBox = new ArrayList<>();
        this.freePlaceForFulling = true; // true = is not full
        this.fruit = "empty";
        this.heightBox = Main.HEIGHT_BOX;
        this.widthBox = Main.WIDTH_BOX;
        this.longBox = Main.LONG_BOX;

        this.idBox = ++number;
    }


    public void setArrayFruitInBox(ArrayList<T> arrayFruitInBox) {
        this.arrayFruitInBox = arrayFruitInBox;
    }

    public ArrayList<T> getArrayFruitInBox() {

        return arrayFruitInBox;
    }



    public boolean isNotFulling() {
        return freePlaceForFulling;
    }
public void setFreePlaceForFulling(){
    this.freePlaceForFulling = true;
}
    public double getResultWeight() {
        return resultWeight;
    }
    public double getResultV() {
        return resultV;
    }


    public String getFruit() {
        return fruit;
    }
    public int getNumber() {
        return number;
    }

    public void addFruit(Fruit one) {

// новый лист если в ящике ничего не лежит (can use method getFruit="empty") и передали Апельсин
        if (getArrayFruitInBox().isEmpty() && one instanceof Orange) {
            ArrayList<Orange> arrayFruits = new ArrayList(getArrayFruitInBox());

            arrayFruits.add((Orange) one);
            setArrayFruitInBox((ArrayList<T>) arrayFruits);
            setFruit("Orange");
        } else
// новый лист если в ящике ничего не лежит (can use method getFruit="empty") и передали Яблоко
        if (getArrayFruitInBox().isEmpty() && one instanceof Apple) {
            ArrayList<Apple> arrayFruits = new ArrayList(getArrayFruitInBox());

            arrayFruits.add((Apple) one);
            setArrayFruitInBox((ArrayList<T>) arrayFruits);
            setFruit("Apple");
        } else {

            getArrayFruitInBox().add((T) one);
            setArrayFruitInBox(getArrayFruitInBox());
        }


        resultWeight += one.getWeight();
        resultV += one.getRadiusSize() * one.getRadiusSize() * one.getRadiusSize() * (4 / 3) * Math.PI;
        // The approximate checking of max volume of Fruits in Box
        if (resultV >= (heightBox * widthBox * longBox * Main.coifFullingBox)) {
            freePlaceForFulling = false;
//            System.out.print("Заполнили ящик "+getFruit()+" номер: "+idBox+", netto: "+resultWeight+"\n");

        }
    }
    @Override
    public String toString () {
        String str="\"";
        String strFromFruit = "";
if(!getArrayFruitInBox().isEmpty())
{
     strFromFruit = "" + getArrayFruitInBox();
}
        str=str + strFromFruit+"<-\n";
        return str;
    }

}