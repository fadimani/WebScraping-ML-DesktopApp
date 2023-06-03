package scraping.repository.emploi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class PostsUrls {
    public static List<String> postsLinks = new ArrayList<>();

    public static void  getPostsLinks(){
        int i=1;
        for (i = 1;i<2;i++){
            try {
                String pageUrl = "https://www.emploi.ma/recherche-jobs-maroc?page="+i;
                Document doc = Jsoup.connect(pageUrl).get();
                Elements posts = doc.select("h5 a");
                for(Element p : posts){
                    String u = p.attr("href");
                    String link = "https://www.emploi.ma".concat(u);
//                    System.out.println(link);
                    postsLinks.add(link);

                }
            } catch (IOException e) {
                System.out.println("we can't get page "+i+"%n");
                throw new RuntimeException(e);
            }
        }


        System.out.println(postsLinks.size());

    }
}
