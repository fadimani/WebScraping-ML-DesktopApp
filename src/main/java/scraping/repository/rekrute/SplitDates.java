package scraping.repository.rekrute;

import scraping.module.rekrute.Rekrute;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitDates {
    public  static void splitPublicationPostuler(String text, Rekrute rekrute){
        String[] dt ={"",""} ;
        String datePostulerRegex ="\\w*[\\s*au\\s*](?<date>\\d{1,2}/\\d{1,2}/\\d{4})" ;
//        Publiée aujourd'hui sur ReKrute.com

//        String datePublicationRegex = "\\w*\\s*[Publiée]\\s*(?<datePub>\\w+)\\s*[sur]\\s*\\w*";
//        String datePublicationRegex = "\\w*[\\s*du\\s*](?<datePub>\\d{1,2}/\\d{1,2}/\\d{4})\\w*";

        String[] datesPP =text.split("-");
        String datePublication = datesPP[0];
        String datePostuler = datesPP[1];
        Pattern patternDatePos = Pattern.compile(datePostulerRegex);
        Matcher matcherDatePos = patternDatePos.matcher(datePostuler);

//        Pattern patternDatePub = Pattern.compile(datePublicationRegex);
//        Matcher matcherDatePub = patternDatePub.matcher(datePublication);
        boolean matchFoundPostuler = matcherDatePos.find();
//        boolean matchFoundPublication = matcherDatePub.find();
//        if (matchFoundPublication){
//            System.out.println(matcherDatePub.group("datePub"));
//        }
        if (matchFoundPostuler){
              dt[0] = matcherDatePos.group("date");
              dt[1]=datePublication;
        }
                rekrute.setDatePublication(dt[1]);
                rekrute.setDatePostuler(dt[0]);




    }
}
