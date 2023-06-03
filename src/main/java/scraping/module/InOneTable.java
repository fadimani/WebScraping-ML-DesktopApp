package scraping.module;

import scraping.module.emploi.EmploiModule;
import scraping.module.rekrute.Rekrute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InOneTable {
    public static final String SAVE_REKRUTE_SQL =
            "INSERT INTO DATA (NOM_ENT,CITY,COUNTRY" +
                        ",DESCRIPTION_ENT,NIVEAU,CONTRAT ," +
                        "DATE_PUBLICATION,SECTEUR,TELETRAVAIL,METIER_TITLE,PROFIL_RECH," +
                        "EXPERIENCE,LANGUES,COMPETENCES,POST_DESC," +
                        "TRAIS_PERSONNALITE,POSTE_PROPSE,CMP_WEB_SITE,MISSION," +
                        "DIPLOME,DATE_POSTLUER)" +
                        " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String  url = "jdbc:mysql://localhost:3306/rekrute";
    String user = "root";
    String password = "";

    private Connection connection;
    public void myConnect(EmploiModule emploi, Rekrute rekrute){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("connection successful to the data base");
        } catch (
                SQLException e) {
            if(connection == null){
                System.out.println("-----------------error------------------");

            }
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            PreparedStatement ps = connection.prepareStatement(SAVE_REKRUTE_SQL);

            if (rekrute == null){
                ps.setString(1,emploi.getCompanyName());
                ps.setString(2,emploi.getCity());
                ps.setString(3,emploi.getCountry());
                ps.setString(4,emploi.getCompDesc());
                ps.setString(5,emploi.getNiveau());
                ps.setString(6,emploi.getContrat());
                ps.setString(7,emploi.getDatePublication());
                ps.setString(8,emploi.getSecteurActivite());
                ps.setString(9,"");
                ps.setString(10,emploi.getMetier());
                ps.setString(11,emploi.getProfilReche());
                ps.setString(12,emploi.getExperience());
                ps.setString(13,emploi.getLangues());
                ps.setString(14,emploi.getCompetences());
                ps.setString(15,"");
                ps.setString(16,"");
                ps.setString(17,emploi.getPostePropse());
                ps.setString(18,emploi.getWebSite());
                ps.setString(19,emploi.getMission());
                ps.setString(20,"");
                ps.setString(21,"");


            }
            if (emploi == null){
                ps.setString(1,rekrute.getNomEntreprise());
                ps.setString(2,rekrute.getCity());
                ps.setString(3,rekrute.getCountry());
                ps.setString(4,rekrute.getDescriptionEntreprise());
                ps.setString(5,rekrute.getNiveau());
                ps.setString(6,rekrute.getContrat());
                ps.setString(7,rekrute.getDatePublication());
                ps.setString(8,rekrute.getSecteurActivite());
                ps.setString(9,rekrute.getTeletravail());
                ps.setString(10,rekrute.getTitle());
                ps.setString(11,rekrute.getProfilRecherche());
                ps.setString(12,rekrute.getExpRequise());
                ps.setString(13,"");
                ps.setString(14,"");
                ps.setString(15,rekrute.getPostDesc());
                ps.setString(16,rekrute.getTraitsPersonnalite());
                ps.setString(17,"");
                ps.setString(18,"");
                ps.setString(19,"");

                ps.setString(20,rekrute.getDiplome());
                ps.setString(21,rekrute.getDatePostuler());
            }




            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
