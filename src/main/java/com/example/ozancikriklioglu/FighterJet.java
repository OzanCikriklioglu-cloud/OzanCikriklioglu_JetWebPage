package com.example.ozancikriklioglu;


public class FighterJet {
    private int id;
    private String jetName;
    private String codeName;
    private String countryOfOrigin;
    private String type;
    private String armamentConfigurations;
    private String picture;

    public FighterJet() {
    }

    public FighterJet(int id, String jetName, String codeName, String countryOfOrigin, String type, String armamentConfigurations, String picture) {
        this.id = id;
        this.jetName = jetName;
        this.codeName = codeName;
        this.countryOfOrigin = countryOfOrigin;
        this.type = type;
        this.armamentConfigurations = armamentConfigurations;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJetName() {
        return jetName;
    }

    public void setJetName(String jetName) {
        this.jetName = jetName;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArmamentConfigurations() {
        return armamentConfigurations;
    }

    public void setArmamentConfigurations(String armamentConfigurations) {
        this.armamentConfigurations = armamentConfigurations;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
