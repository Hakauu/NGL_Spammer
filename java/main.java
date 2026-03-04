import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nazwa uzytkownika: ");
        String nazwa = scanner.nextLine();

        System.out.println("Tresc Wiadomosci: ");
        String tresc = scanner.nextLine();

        System.out.println("Ilosc: ");
        int ilosc = scanner.nextInt();

        System.out.println("Przerwa miedzy wiadomosciami (w ms): ");
        int p = scanner.nextInt();

        int i = 0;


        //System.out.println(ilosc);
        //System.out.println(nazwa);
        //System.out.println(tresc);





        HttpClient client = HttpClient.newHttpClient();
        String ew = URLEncoder.encode(tresc, StandardCharsets.UTF_8);
        while (ilosc > i) {
            System.out.println("Wysylanie");
            //Generowanie UUID
            String id = java.util.UUID.randomUUID().toString();




            String body =
                    "username=" + nazwa + "&question=" + ew + "&deviceId=" + id + "&gameSlug=" + "&referrer=nic.pl";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://ngl.link/api/submit"))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            try {
                client.send(request, HttpResponse.BodyHandlers.discarding());
                System.out.println("Wyslano");
            } catch (IOException | InterruptedException e) {
                System.out.println("Nie wyslano");
            }











            i++;
            try {
                Thread.sleep(p);
            } catch (InterruptedException b) {
                b.printStackTrace();
            }

        }

    }
}
