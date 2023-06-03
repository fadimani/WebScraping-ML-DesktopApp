package scraping.repository.rekrute;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ExtractPostsLinks {
    public static Set<String> postsLinks = new HashSet<>();
    public ExtractPostsLinks() {
            getPostsLinks();
    }
    public void  getPostsLinks(){
        int i;
        for(i=1;i<2;i++){
            try {
                String pageUrl = "https://www.rekrute.com/offres.html?p="+i+"&s=1&o=1";
                Document doc = Jsoup.connect(pageUrl).get();
                Elements posts = doc.getElementsByClass("titreJob");
                for(Element p : posts){
                    String u = p.attr("href");
                   postsLinks.add("https://www.rekrute.com".concat(u));
                }
            } catch (IOException e) {
                System.out.println("we can't get page "+i+"%n");
                throw new RuntimeException(e);
            }
        }

    }
}
