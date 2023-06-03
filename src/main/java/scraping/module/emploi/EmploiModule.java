package scraping.module.emploi;

public class EmploiModule {
    String companyName;
    String city;
    String country;
    String compDesc;
    String WebSite;
    String mission;
    String postePropse;//Description du poste
    String profilReche;
    String datePublication;
    String SecteurActivite;
    String metier;
    String contrat;
    String region;
    String niveau;//Niveau d'études
    String experience;
    String langues;
    String competences;

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompDesc() {
        return compDesc;
    }

    public void setCompDesc(String compDesc) {
        this.compDesc = compDesc;
    }

    public String getWebSite() {
        return WebSite;
    }

    public void setWebSite(String webSite) {
        WebSite = webSite;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getPostePropse() {
        return postePropse;
    }

    public void setPostePropse(String postePropse) {
        this.postePropse = postePropse;
    }

    public String getProfilReche() {
        return profilReche;
    }

    public void setProfilReche(String profilReche) {
        this.profilReche = profilReche;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public String getSecteurActivite() {
        return SecteurActivite;
    }

    public void setSecteurActivite(String secteurActivite) {
        SecteurActivite = secteurActivite;
    }

    public String getMetier() {
        return metier;
    }

    public void setMetier(String metier) {
        this.metier = metier;
    }

    public String getContrat() {
        return contrat;
    }

    public void setContrat(String contrat) {
        this.contrat = contrat;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLangues() {
        return langues;
    }

    public void setLangues(String langues) {
        this.langues = langues;
    }


    @Override
    public String toString() {
        return "EmploiModule{" +
                "companyName='" + companyName + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", compDesc='" + compDesc + '\'' +
                ", WebSite='" + WebSite + '\'' +
                ", mission='" + mission + '\'' +
                ", postePropse='" + postePropse + '\'' +
                ", profilReche='" + profilReche + '\'' +
                ", datePublication='" + datePublication + '\'' +
                ", SecteurActivite='" + SecteurActivite + '\'' +
                ", metier='" + metier + '\'' +
                ", contrat='" + contrat + '\'' +
                ", region='" + region + '\'' +
                ", niveau='" + niveau + '\'' +
                ", experience='" + experience + '\'' +
                ", langues='" + langues + '\'' +
                ", competences='" + competences + '\'' +
                '}';
    }


}
