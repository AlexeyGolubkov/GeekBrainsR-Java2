import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppData {
    private String[] header;
    private int[][] data;


    AppData() throws IOException, ClassCastException {
        List<String> inputRec = new ArrayList<>();
        // List<Integer> inputRecInt = new ArrayList<>();
        header = new String[Main.SIZE_HEADER];
        data = new int[Main.NUMBER_STR][Main.SIZE_HEADER];
        FileReader dataRecordFromFile = new FileReader(Main.NEW_FILE_CSV);
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(dataRecordFromFile);
            String strInputRec = bufferedReader.readLine();

            inputRec.addAll(List.of((strInputRec.split(Main.SPACER_SYMBOL))));
            System.out.println(inputRec.toString());
            //         this.header = (String[]) inputRec.toArray();


            strInputRec = bufferedReader.readLine();
            int j = 0;
            while (strInputRec != null) {
                inputRec.clear();
                inputRec.addAll(List.of((strInputRec.split(Main.SPACER_SYMBOL))));
                System.out.println(inputRec);
                // Integer[] rowData = (inputRec.toArray(new Integer[0]));


                for (int i = 0; i < inputRec.size(); i++) {
                    data[j][i] = Integer.parseInt(inputRec.get(i));

                }
                this.data[j] = data[j];
                j++;
                strInputRec = bufferedReader.readLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            //System.out.println(InputRec);
            e.printStackTrace();
        } finally {
            bufferedReader.close();

        }

    }

    public int[][] getData() {
        return data;
    }

    public void save() throws IOException {
        Main.createRecordStrNewFile(false, data);
        System.out.println("Проверьте изменения значений data AppDAta (see in NewFile.csv)");
    }



}