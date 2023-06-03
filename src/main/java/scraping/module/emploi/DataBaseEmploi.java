package scraping.module.emploi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseEmploi {
    public static final String SAVE_REKRUTE_SQL =
            "INSERT INTO POST_INFO_EMP (companyName,city,country" +
                    ",compDesc,WebSite,mission,profilReche,datePublication,SecteurActivite,metier,contrat," +
                    "region,niveau,experience,langues,competences,postePropse)" +
                    " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String  url = "jdbc:mysql://localhost:3306/rekrute";
    String user = "root";
    String password = "";

    private Connection connection;
    public void myConnect(EmploiModule emploi){
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
            //PreparedStatement we can bind values to thes question mark
            PreparedStatement ps = connection.prepareStatement(SAVE_REKRUTE_SQL);
            //setString take two parameters index 1 => means first question mark
            ps.setString(1,emploi.getCompanyName());
            ps.setString(2,emploi.getCity());
            ps.setString(3,emploi.getCountry());
            ps.setString(4,emploi.getCompDesc());
            ps.setString(5,emploi.getWebSite());
            ps.setString(6,emploi.getMission());
            ps.setString(7,emploi.getProfilReche());
            ps.setString(8,emploi.getDatePublication());
            ps.setString(9,emploi.getSecteurActivite());
            ps.setString(10,emploi.getMetier());
            ps.setString(11,emploi.getContrat());
            ps.setString(12,emploi.getRegion());
            ps.setString(13,emploi.getNiveau());
            ps.setString(14,emploi.getExperience());
            ps.setString(15,emploi.getLangues());
            ps.setString(16,emploi.getCompetences());
            ps.setString(17,emploi.getPostePropse());


            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


