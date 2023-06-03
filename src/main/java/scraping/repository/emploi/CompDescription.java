package scraping.repository.emploi;

import scraping.module.emploi.EmploiModule;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class CompDescription {
    Document postDoc;
    public CompDescription(String cmpDescClassLink, EmploiModule emploi) {
        String link = "https://www.emploi.ma/".concat(cmpDescClassLink);
        try {
            postDoc= Jsoup.connect(link).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        companyName(emploi);
        compDescAndWebSite(emploi);
        city(emploi);
        country(emploi);
    }



    public  void compDescAndWebSite(EmploiModule emploi){
        String companyWebSite = postDoc.select("td#company-profile-site").nextAll("td").last().text();
//            System.out.println(companyWebSite);
        String compDesc = postDoc.select("div.company-profile-description ").text();
//        System.out.println(compDesc);
        emploi.setWebSite(companyWebSite);
        emploi.setCompDesc(compDesc);

    }

    public  void  companyName(EmploiModule emploi){
        String compName = postDoc.select("td#company-profile-name").nextAll("td").last().text();
//        System.out.println(compName);
        emploi.setCompanyName(compName);

    }
    public void city(EmploiModule emploi){
        String cityName = postDoc.select("td#company-profile-city").nextAll("td").last().text();
//        System.out.println(cityName);
        emploi.setCity(cityName);

    }
    public void country(EmploiModule emploi){
        String countryName = postDoc.select("td#company-profile-country").nextAll("td").last().text();
//        System.out.println(countryName);
        emploi.setCountry(countryName);

    }
}
