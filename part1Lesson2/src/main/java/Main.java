

public class Main {
    private static final int SIZE_OF_ARRAY=4;
    private static int summaArrayForTask=0;
    public static void main(String[] args) throws MyArraySizeException {


        String[][] arrayForTask =  new String[][]{{"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"-1", "-2", "-3", "-4"},
                {"0", "5", "6:", "7"}};


        if (!arrayCheckSize(arrayForTask)){
            generationException();
        }

        try {
            System.out.println("Проверяем массив:"+executionOfArray(arrayForTask));

        }
        catch (MyArraySizeException | MyArrayDataException e){
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Переделанный массив имеет сумму ="+ summaArrayForTask);
        }
    }

    private static boolean arrayCheckSize(String[][] array) {
        int MaxIndexArray = array.length;
        int indexArray=0;
        while (indexArray < MaxIndexArray) {

            if (array[indexArray].length!= SIZE_OF_ARRAY||indexArray > SIZE_OF_ARRAY) {
                return false;
            }
            indexArray++;
        }
        return indexArray == SIZE_OF_ARRAY;
    }

    private static void generationException () throws MyArraySizeException{
        throw new MyArraySizeException("Error size Array");
    }
    private static int [][] executionOfArray (String[][] array) throws NumberFormatException,  MyArrayDataException, MyArraySizeException {

        int [][] result = new int[SIZE_OF_ARRAY][SIZE_OF_ARRAY];
        for (int i =0;i<SIZE_OF_ARRAY;i++){
            for (int j =0;j<SIZE_OF_ARRAY;j++) {
                try {
                    result[i][j]= Integer.parseInt(array[i][j]);
                    summaArrayForTask+=result[i][j];
                } catch (NumberFormatException e) {
                    String message = "Error Data for i="+i+" j="+j+" ->"+"\""+array[i][j]+"\"";
                    throw new MyArrayDataException(message,e);
                } catch (IndexOutOfBoundsException e) {
                    String message = "Error Size of Array i="+i+" j="+j;
                    throw new MyArraySizeException(message,e);
                }


            }
        }
        return result;
    }
}