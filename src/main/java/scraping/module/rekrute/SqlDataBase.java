package scraping.module.rekrute;

import java.sql.*;

public class SqlDataBase {
    public static final String SAVE_REKRUTE_SQL =
            "INSERT INTO POST_INFO_REKRUTE (URL_POST,DATE_PUBLICATION,DATE_POSTLUER" +
                    ",TITLE,SECTEUR,NOM_ENT,TELETRAVAIL,CONTRAT,NIVEAU,REGION,EXP_REQUISE," +
                    "TRAIS_PERSONNALITE,DESCRIPTION_ENT,POST_DESC,PROFIL_RECH,ADDRESS,DIPLOME,CITY,COUNTRY)" +
                    " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String  url = "jdbc:mysql://localhost:3306/rekrute";
    String user = "root";
    String password = "";

    private Connection connection;
    public void myConnect(Rekrute rekrute){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);//don't register this changes in database

//            System.out.println("connection successful to the data base");
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
            //PreparedStatement we can bind values to thes question mark
            PreparedStatement ps = connection.prepareStatement(SAVE_REKRUTE_SQL);
            //setString take two parameters index 1 => means first question mark
            ps.setString(1,rekrute.getUrlPost());
            ps.setString(2,rekrute.getDatePublication());
            ps.setString(3,rekrute.getDatePostuler());
            ps.setString(4,rekrute.getTitle());
            ps.setString(5,rekrute.getSecteurActivite());
            ps.setString(6,rekrute.getNomEntreprise());
            ps.setString(7,rekrute.getTeletravail());
            ps.setString(8,rekrute.getContrat());
            ps.setString(9,rekrute.getNiveau());
            ps.setString(10,rekrute.getRegion());
            ps.setString(11,rekrute.getExpRequise());
            ps.setString(12,rekrute.getTraitsPersonnalite());
            ps.setString(13,rekrute.getDescriptionEntreprise());
            ps.setString(14,rekrute.getPostDesc());
            ps.setString(15,rekrute.getProfilRecherche());
            ps.setString(16,rekrute.getAddress());
            ps.setString(17,rekrute.getDiplome());
            ps.setString(18,rekrute.getCity());
            ps.setString(19,rekrute.getCountry());


            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
