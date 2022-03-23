import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
        import okhttp3.OkHttpClient;
        import okhttp3.Request;
        import okhttp3.Response;

        import java.io.FileInputStream;
        import java.io.IOException;

import java.sql.*;
import java.util.Objects;
        import java.util.Properties;

public class Main  {
    final private static String PATH_PROP_CONFIG = "src/main/resources/prop/sitePropWeather.cnf";
    private static String citiForecast = "Samara";
    private static WeatherResponse weatherResponse;
    static Properties prop = new Properties();


    public static void main(String[] args) throws IOException, SQLException {

        loadConstantProp();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(prop.getProperty("BASE_HOST")) //
                .addPathSegment(prop.getProperty("API_VERSION")) // v1
                .addPathSegment(prop.getProperty("CURRENT_TYPE"))
                .addQueryParameter("key", prop.getProperty("COMPANIES_API")) // companies
                .addQueryParameter("q", citiForecast)
                .addQueryParameter("aqi", "no")

                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        System.out.println("1 day " + request);


        // Экземпляр класса OkHttpClient выполняет всю работу по созданию и отправке запросов
        OkHttpClient client = new OkHttpClient();
        // Получение объекта ответа от сервера
        Response response = client.newCall(request).execute();

        // Тело сообщения возвращается методом body объекта Response
        String body = Objects.requireNonNull(response.body()).string();


        HttpUrl url5 = new HttpUrl.Builder()
                .scheme("http")
                .host(prop.getProperty("BASE_HOST")) //
                .addPathSegment(prop.getProperty("API_VERSION")) // v1
                .addPathSegment(prop.getProperty("FORECAST_TYPE"))
                .addQueryParameter("key", prop.getProperty("COMPANIES_API")) // companies
                .addQueryParameter("q", citiForecast)
                .addQueryParameter("days", "5")
                .addQueryParameter("aqi", "no")
                .addQueryParameter("alerts", "no")
                .build();

        Request request5 = new Request.Builder()
                .url(url5)
                .build();

        System.out.println("5 day " + request5);

        // Получение объекта ответа от сервера
        Response response5 = client.newCall(request5).execute();

        // Тело сообщения возвращается методом body объекта Response
        String body5 = Objects.requireNonNull(response5.body()).string();

        printWeather("5 day\n" + body5);
        printWeather("1 day\n" + body);
        ObjectMapper mapper5 = new ObjectMapper();

        weatherResponse = mapper5.readValue(body5, WeatherResponse.class);
        System.out.printf("\nСейчас погода: в области %s, температура %s C.\n",
                weatherResponse.getLocation().getRegion(), weatherResponse.getCurrent().getTemp_c());
        for (Forecastday forecastday : weatherResponse.getForecast().getForecastday()) {
            System.out.println("\nПрогноз на дату " + forecastday.getDate());
            for (Hour hour : forecastday.getHour()) {
                System.out.printf("\t Время %4s, температура %4s C, условия %4s ;", hour.getTime(), hour.getTemp_c(),
                        hour.getCondition().getText());
            }
        }
        System.out.println("\n\n P.S. Бесплатно только на три дня, хоть сколько запрашивай");
        System.out.println("Дата и время: "+weatherResponse.getLocation().getLocaltime());
        // load JDBC driver

              try {
        Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
        try ( Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/lesson8_weather.db");

              Statement statement = connection.createStatement()) {


            performCreateDB(statement);
            connection.setAutoCommit(false);
            performInsertData(statement);
            connection.commit();
            readWeather(statement);

/*          statement.close();
            connection.close();*/

        }
    }



    private static void readWeather(Statement statement) throws SQLException {
        String command="SELECT * FROM weather ORDER BY temperature DESC";
        ResultSet readLine=statement.executeQuery(command);
        while(readLine.next()){
            System.out.printf("In the city of %s on %s it was %s temperature %s °C\n", readLine.getString(2),readLine.getString(3),readLine.getString(4),readLine.getString(5));

}

    }

    private static void performInsertData(Statement statement) throws SQLException {

        String command = ("INSERT INTO weather (city,localDate,weatherText,temperature) VALUES ('" +
                weatherResponse.getLocation().getRegion()+"','"+
                weatherResponse.getLocation().getLocaltime()+"','"+
                weatherResponse.getCurrent().getCondition().getText()+"',"+
                weatherResponse.getCurrent().getTemp_c()+");");
        System.out.println(command);
            statement.executeUpdate(command);

    }

    private static void performCreateDB(Statement statement) throws SQLException {
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS weather (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "city String NOT NULL, localDate String NOT NULL, weatherText String , temperature Real );");
    }

    private static void printWeather(String body) {
        System.out.println("JSON\n" + body);

    }

    private static void loadConstantProp() throws IOException {
        try (FileInputStream configFile = new FileInputStream(PATH_PROP_CONFIG)) {
            prop.load(configFile);

        } catch (IOException e) {

            System.out.println("ErrorFileFind\n" + e.getMessage());
        }
    }





}



