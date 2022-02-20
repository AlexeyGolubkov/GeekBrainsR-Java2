import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayBox<BoxForFruits> {
    public  List<BoxForFruits> listOfBoxForFruits =  Collections.synchronizedList(new ArrayList<>());

    public static int number=0;
    public static int numberOfBoxInArrayBox=0;

    public ArrayBox(){
        if (number==0) {
            List<BoxForFruits> b = new ArrayList<>();
            this.listOfBoxForFruits = b;
        } else {
            this.listOfBoxForFruits=getArrayBox();
        }
        number++;

    }
    protected synchronized void addArrayBox(BoxForFruits box){

        List<BoxForFruits> b;
        b= getArrayBox();
        b.add (box);
        this.listOfBoxForFruits = b;
        numberOfBoxInArrayBox++;

    }

    protected synchronized List<BoxForFruits> getArrayBox() {

        return listOfBoxForFruits;
    }

    protected void setArrayBox(List<BoxForFruits> list) {
        this.listOfBoxForFruits=list;
    }

    protected  int getNumber() {
        return number;
    }
}
