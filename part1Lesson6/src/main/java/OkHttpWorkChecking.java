import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class OkHttpWorkChecking {
    final private static String PATH_PROP_CONFIG = "src/main/resources/prop/sitePropWeather.cnf";
    private static String citiForecast = "Moscow";

    static Properties prop = new Properties();

    public static void main(String[] args) throws IOException {

        loadConstantProp();
        //http://api.weatherapi.com/v1/current.json?key=cccd18d18493496c98682612220603&q=Moscow&aqi=no

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(prop.getProperty("BASE_HOST")) //
                .addPathSegment(prop.getProperty("API_VERSION")) // v1
                .addPathSegment(prop.getProperty("CURRENT_TYPE"))
                .addQueryParameter("key", prop.getProperty("COMPANIES_API")) // companies
                .addQueryParameter("q", "Moscow")
                .addQueryParameter("aqi", "no")

                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        System.out.println("1 day "+request);


        // Экземпляр класса OkHttpClient выполняет всю работу по созданию и отправке запросов
        OkHttpClient client = new OkHttpClient();
        // Получение объекта ответа от сервера
        Response response = client.newCall(request).execute();

        // Тело сообщения возвращается методом body объекта Response
        String body = Objects.requireNonNull(response.body()).string();


        //http://api.weatherapi.com/v1/forecast.json?key=cccd18d18493496c98682612220603&q=Moscow&days=5&aqi=no&alerts=no

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

        System.out.println("5 day "+request5);

        // Получение объекта ответа от сервера
        Response response5 = client.newCall(request5).execute();

        // Тело сообщения возвращается методом body объекта Response
        String body5 = Objects.requireNonNull(response5.body()).string();

        printWeather("5 day\n" + body5);
        printWeather("1 day\n" + body);
    }

    private static void printWeather(String body) {
        System.out.println("body\n" + body);
        
    }

    private static void loadConstantProp() throws IOException {
        try (FileInputStream configFile = new FileInputStream(PATH_PROP_CONFIG)) {
        prop.load(configFile);

        } catch (IOException e) {

            System.out.println("ErrorFileFind\n"+e.getMessage());
        }
    }
}



