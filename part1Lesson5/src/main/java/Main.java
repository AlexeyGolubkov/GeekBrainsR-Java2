import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static final int SIZE_HEADER=10;
    public static final int NUMBER_STR=20;
    public static final String SPACER_SYMBOL=";";
    public static final String NEW_FILE_CSV = "NewFile.csv";
    public static void main(String[] args) throws IOException {
        createRecordStrNewFile(true,null);
        AppData appData = new AppData();

        appData.save();


    }


    protected static void createRecordStrNewFile(boolean fileCreatorFlag, int [][] appData) throws IOException, FileNotFoundException {

        boolean flagFileWasOpen=false;
        FileWriter fileForCreateRecordStr = null;

        String strValue = "Value ";

        try {File dataRecordInFile = new File(NEW_FILE_CSV);

            fileForCreateRecordStr = new FileWriter(dataRecordInFile);

            fileForCreateRecordStr.write(strValue(strValue, true) + "\n");


                for (int i = 0; i < NUMBER_STR; i++) {
                    if (fileCreatorFlag) {
                        fileForCreateRecordStr.write(strValue(strValue, false) + "\n");

                    } else {
                        fileForCreateRecordStr.write(appData(appData[i]) + "\n");
                    }
                }
            flagFileWasOpen=true;
        } catch (IOException e){
            System.out.println(NEW_FILE_CSV+" занят другим процессом, не изменяем");

        }
        finally {
            if (flagFileWasOpen) {
                fileForCreateRecordStr.close();}

        }
    }

    private static String appData(int[] data) {
        String str = "";
        for (int i=data.length-1;i>=0;i--) {
            str += data[i] + Main.SPACER_SYMBOL;
        }
        return str;

    }

    private static String strValue(String strValue, boolean headerFlag) {
        String stringFulling="";
        int j;
        for (int i=0;i<SIZE_HEADER;i++) {
            if (headerFlag) {stringFulling+=(strValue+i)+SPACER_SYMBOL;}
            else {
                j=(int) ((i+1) *100000*Math.random());
                //stringFulling+=(""+ j).substring(0,4)+SPACER_SYMBOL;}
                stringFulling+=""+ j+SPACER_SYMBOL;}
        }
        return  stringFulling;
    }

}

