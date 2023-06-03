package scraping.repository.rekrute;

import scraping.module.rekrute.Rekrute;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class ExtractPostInfo implements PostInfo{
    Set<String> postsLinks = ExtractPostsLinks.postsLinks;
    Rekrute rekrute;
    public ExtractPostInfo() {
        new ExtractPostsLinks();
        getPostInfo();
    }

    public void getPostInfo(){
        int j =0;
        System.out.println(postsLinks.size());
        System.out.println(j);
        for (String post:postsLinks){
            System.out.println(j);
            j++;
           System.out.println(j);
            rekrute = new Rekrute();
           try {
               Document postDoc= Jsoup.connect(post).get();
               address(postDoc);
               url(post);
               datePublicationPostuler(postDoc);
               title(postDoc);
               secteurActivite(postDoc);
               nomEntreprise(postDoc);
               info5(postDoc);//+4+diplome
               traitsPersonnalite(postDoc);
               descriptionEntreprise(postDoc);
               postDesc(postDoc);
               profilRecherche(postDoc);
//               ===========16=====================

//------------------------------------------------------------------------------------------
//               competenceRequises(postDoc);=> dans profilRecherche
//               competenceRecommandees(postDoc);=> dans profilRecherche
//               langues(postDoc);//doesn't exist


               System.out.println(rekrute);
//               Main.saveRekrutePostInfo(rekrute);
//               Main.saveData(null,rekrute);

           } catch (IOException e) {
               System.out.println("------error------------");
               throw new RuntimeException(e);
           }

       }



   }

   //----------------------------------------------------------------------------------------
   public void address(Document post){
       String address ;
             address  = post.select("div.col-md-12 span#address").text();
       if (address.equals("")){
           address  = post.select("div.col-md-12 ul.featureInfo li[title=Région]").text();
       }
//       System.out.println(address);
       rekrute.setAddress(address);
   }
   public void url(String post){
//       System.out.println(post);
        rekrute.setUrlPost(post);
   }
   public void datePublicationPostuler(Document post){
       String datesPP = post.select("span.newjob").text();
         SplitDates.splitPublicationPostuler(datesPP,rekrute);
       }
   public void title(Document postDoc){
       Elements titles = postDoc.select("meta[property=og:title]");
       String title = titles.attr("content");
       rekrute.setTitle(title);
   }
   public void traitsPersonnalite(Document postDoc){
        Set<String> traitsPersonnaliteSet= new HashSet<>();
       Elements traitsPersonnaliteEl = postDoc.select("div.col-md-12.blc p span");
       for (Element element : traitsPersonnaliteEl) {
           traitsPersonnaliteSet.add(element.text());
       }
       rekrute.setTraitsPersonnalite(traitsPersonnaliteSet);
   }

   public void competenceRequises(Document postDoc){
       Set<String> competenceRequisesSet= new HashSet<>();
       Elements competenceRequisesEl = postDoc.select("div.col-md-12.blc  ul").eq(3);
       for(Element element: competenceRequisesEl){
           for (Element el : element.children()) {
               competenceRequisesSet.add(el.text());
           }
       }
       System.out.println(competenceRequisesSet);
   }

   public void competenceRecommandees(Document postDoc){
       Set<String> competenceRecommandeesSet= new HashSet<>();
       Elements competenceRecommandeesEl = postDoc.select("div.col-md-12.blc  ul").eq(4);
       for(Element element: competenceRecommandeesEl){
           for (Element el : element.children()) {
               competenceRecommandeesSet.add(el.text());
           }

       }
       System.out.println(competenceRecommandeesSet);
   }


   public void secteurActivite(Document postDoc){
       Element secActi = postDoc.select("div.contentbloc h2").first();
//       System.out.println(secActi.text());
       rekrute.setSecteurActivite(secActi.text());
   }

   public void descriptionEntreprise(Document postDoc){
       String description;
       try {
           description= postDoc.select("div#recruiterDescription p").text();
           rekrute.setDescriptionEntreprise(description);
       }catch (Exception e){
           rekrute.setDescriptionEntreprise("description");
           System.out.println("++++++description++++++");
       }
    }

   public void nomEntreprise(Document postDoc){
       String nomEntreprise;
       try {
           nomEntreprise= postDoc.select("div#recruiterDescription > p > strong").first().text();
           rekrute.setNomEntreprise(nomEntreprise);
       }catch (Exception e){
           //si c'est pas une entreprise set ""
           rekrute.setNomEntreprise("");
//           System.out.println("++++++++name++++++OFPPT++++");
       }

   }
   public void profilRecherche(Document postDoc){
//       String profilRecherche = postDoc.select("div.col-md-12.blc h2 ").first().text();
       try{
           Elements profilRechercheEls = postDoc.select(" div.col-md-12.blc h2:contains(Profil recherché :)");
             String s="";
           for(Element element: profilRechercheEls){
               for (Element el : element.nextElementSiblings()) {
                   s = s.concat(el.text()).concat(" ");
               }
               rekrute.setProfilRecherche(s);


           }
       }catch (Exception e){
           System.out.println("profilRecherche");
       }

   }
   public void langues(Document postDoc){

   }
   public void info5(Document postDoc){
       //{Télétravail / contrat/Niveau d'étude / Région/ Expérience requise}
       Map<String,String> info= new HashMap<>();
       Elements featureInfo = postDoc.select("ul.featureInfo li");
       for (Element element : featureInfo) {
           info.put(element.attr("title"),element.text());
       }
       Split5Info.splitInfo(info,rekrute);
       Split5Info.diplome(info,rekrute);
   }

   public void postDesc(Document postDoc){
       Elements postDescEls = postDoc.select(" div.col-md-12.blc h2:contains(Poste :)");
       String s="";
       for(Element element: postDescEls){
           Elements li = element.nextElementSiblings();
           for (Element e:li){
               s = s.concat(e.text()).concat(" ");
           }

       }
       rekrute.setPostDesc(s);
   }



}
