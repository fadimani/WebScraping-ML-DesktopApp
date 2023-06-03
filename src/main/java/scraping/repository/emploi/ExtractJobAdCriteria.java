package scraping.repository.emploi;

import scraping.module.emploi.EmploiModule;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

public class ExtractJobAdCriteria {
//    Métier-Secteur d´activité-Type de contrat-Région-Niveau d'expérience-Niveau d'études-Langues exigées
//    Compétences clés-Nombre de poste(s)
//    8

    Map<String ,String> mapCriteria = new HashMap<>();
    public void criteria(Elements els, EmploiModule emploi){
        Elements tbody = els.select("tbody");
        for (Element tr:tbody) {
            for (Element el:tr.children()) {
                String[] sp = el.text().split(":");
                mapCriteria.put(sp[0].trim(),sp[1].trim());
            }
        }
//        System.out.println(mapCriteria);


        mapCriteria.entrySet().stream().forEach( e -> {
            if (e.getKey().equals("Type de contrat")){
                emploi.setContrat(e.getValue());
            }
            if (e.getKey().equals("Niveau d'études")){
                emploi.setNiveau(e.getValue());
            }
            if (e.getKey().equals("Région")){
                emploi.setRegion(e.getValue());
            }
            if (e.getKey().equals("Niveau d'expérience")){
                emploi.setExperience(e.getValue());
            }
            if (e.getKey().equals("Langues exigées")){
                emploi.setLangues(e.getValue());
            }
            if (e.getKey().equals("Métier")){
                emploi.setMetier(e.getValue());
            }
            if (e.getKey().equals("Compétences clés")){
                emploi.setCompetences(e.getValue());
            }
            if (e.getKey().equals("Secteur d´activité")){
                emploi.setSecteurActivite(e.getValue());
            }


        });
    }



}
