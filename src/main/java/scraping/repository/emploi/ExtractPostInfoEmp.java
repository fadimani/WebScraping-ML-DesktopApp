package scraping.repository.emploi;

import scraping.module.emploi.EmploiModule;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPostInfoEmp {
    List<String> postsLinks ;
    EmploiModule emploi = new EmploiModule();
    ExtractJobAdCriteria extractJobAdCriteria = new ExtractJobAdCriteria();
    public ExtractPostInfoEmp() {
        new PostsUrls().getPostsLinks();
        postsLinks = PostsUrls.postsLinks;
        getPostInfo();
    }

    public void getPostInfo(){
        for(String post:postsLinks){
            try {
//               String post = postsLinks.get(0);
                Document postDoc= Jsoup.connect(post).get();
                Elements jobAdCriteria = postDoc.getElementsByClass("job-ad-criteria");
                extractJobAdCriteria.criteria(jobAdCriteria,emploi);
                String cmpDescClassLink = postDoc.select("div.job-ad-company-description a").attr("href");
                new CompDescription(cmpDescClassLink,emploi);
                profilRecherche(postDoc);
                mission(postDoc);
                datePublica(postDoc);

                System.out.println(emploi.toString());
//                Main.saveEmploiPostInfo(emploi);
//                Main.saveData(emploi,null);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void profilRecherche(Document postDoc){
//        postePropse
//        profil reche
        String postePropose = postDoc.select("span.ad-ss-title").first().text();
        String profil = postDoc.select("div.inner.clearfix div.content.clearfix span.ad-ss-title").next("ul").text();
//        System.out.println(postePropose);
//        System.out.println(profil);
        emploi.setProfilReche(profil);
        emploi.setPostePropse(postePropose);

    }

    public void mission(Document postDoc){
        String missionCont;
        try {
            missionCont = postDoc.select("p:contains(Missions)").first().nextElementSiblings().text();
        }catch (Exception e){
            missionCont = "";
        }
//        System.out.println(missionCont);
        emploi.setMission(missionCont);
    }


    public void datePublica(Document postDoc ){
        String dateExtracted = postDoc.select("div.job-ad-publication-date").text();
        String datePostulerRegex ="\\w*[\\s*au\\s*](?<date>\\d{1,2}.\\d{1,2}.\\d{4})" ;
        Pattern patternDatePos = Pattern.compile(datePostulerRegex);
        Matcher matcherDatePos = patternDatePos.matcher(dateExtracted);
        boolean matchFoundPostuler = matcherDatePos.find();
        if (matchFoundPostuler){
            String date = matcherDatePos.group("date");
//            System.out.println(date);
            emploi.setDatePublication(date);
        }

    }





}
