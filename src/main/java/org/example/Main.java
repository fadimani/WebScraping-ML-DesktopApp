package org.example;


import scraping.module.InOneTable;
import scraping.module.emploi.DataBaseEmploi;
import scraping.module.emploi.EmploiModule;
import scraping.module.rekrute.Rekrute;
import scraping.module.rekrute.SqlDataBase;
import scraping.repository.emploi.ExtractPostInfoEmp;
import scraping.repository.rekrute.ExtractPostInfo;

public class Main {
    public static void main(String[] args) {
        getDataFromEmp();
        getDataFromRecr();


    }
    public static void saveRekrutePostInfo(Rekrute rekrute1){
        SqlDataBase sqlDataBase = new SqlDataBase();
        sqlDataBase.myConnect(rekrute1);
    }
    public static void saveEmploiPostInfo(EmploiModule emploiModule1){
        DataBaseEmploi dataBaseEmploi = new DataBaseEmploi();
        dataBaseEmploi.myConnect(emploiModule1);
    }
    public static  void saveData(EmploiModule emploiModule,Rekrute rekrute){
        InOneTable inOneTable = new InOneTable();
        inOneTable.myConnect(emploiModule,rekrute);
    }
    public static void getDataFromEmp(){
       new ExtractPostInfoEmp();

    }
    public static void getDataFromRecr(){
        new ExtractPostInfo();
    }




}