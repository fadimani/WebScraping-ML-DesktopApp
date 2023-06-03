package scraping.repository.rekrute;

import org.jsoup.nodes.Document;

import javax.print.Doc;

public interface PostInfo {
     void address(Document postPage);
     void url(String url);
     void datePublicationPostuler(Document d);
     void title(Document d);
     void traitsPersonnalite(Document d);
     void competenceRequises(Document d);
     public void secteurActivite(Document d);
     void descriptionEntreprise(Document d);
     void nomEntreprise(Document d);
     void profilRecherche(Document d);
     void postDesc(Document d);
     void info5(Document d);

}
