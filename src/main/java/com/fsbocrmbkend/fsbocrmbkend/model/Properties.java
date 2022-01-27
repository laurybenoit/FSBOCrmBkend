package com.fsbocrmbkend.fsbocrmbkend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="properties")
public class Properties {

    @Id
    @Column
    public Long id;

    @Column
    public String homeType;

    @Column
    public String styleType;

    @Column
    public String address;

    @Column
    public int bed;

    @Column
    public int bath;

    @Column
    public int level;

    @Column
    public int lotZize;

    @Column
    public String communityFeatures;

    @Column
    public boolean hoa;

    @Column
    public boolean roof;

    @Column
    public boolean basement;

    @Column
    public boolean heat;

    @Column
    public boolean cooling;

    @Column
    public boolean sewer;

    @Column
    public int garage;

    @Column
    public String propertyFeatures;

    public Properties(Long id, String homeType, String styleType, String address, int bed, int bath, int level, int lotZize, String communityFeatures, boolean hoa, boolean roof, boolean basement, boolean heat, boolean cooling, boolean sewer, int garage, String propertyFeatures) {
        this.id = id;
        this.homeType = homeType;
        this.styleType = styleType;
        this.address = address;
        this.bed = bed;
        this.bath = bath;
        this.level = level;
        this.lotZize = lotZize;
        this.communityFeatures = communityFeatures;
        this.hoa = hoa;
        this.roof = roof;
        this.basement = basement;
        this.heat = heat;
        this.cooling = cooling;
        this.sewer = sewer;
        this.garage = garage;
        this.propertyFeatures = propertyFeatures;
    }

    public Properties() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHomeType() {
        return homeType;
    }

    public void setHomeType(String homeType) {
        this.homeType = homeType;
    }

    public String getStyleType() {
        return styleType;
    }

    public void setStyleType(String styleType) {
        this.styleType = styleType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    public int getBath() {
        return bath;
    }

    public void setBath(int bath) {
        this.bath = bath;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLotZize() {
        return lotZize;
    }

    public void setLotZize(int lotZize) {
        this.lotZize = lotZize;
    }

    public String getCommunityFeatures() {
        return communityFeatures;
    }

    public void setCommunityFeatures(String communityFeatures) {
        this.communityFeatures = communityFeatures;
    }

    public boolean isHoa() {
        return hoa;
    }

    public void setHoa(boolean hoa) {
        this.hoa = hoa;
    }

    public boolean isRoof() {
        return roof;
    }

    public void setRoof(boolean roof) {
        this.roof = roof;
    }

    public boolean isBasement() {
        return basement;
    }

    public void setBasement(boolean basement) {
        this.basement = basement;
    }

    public boolean isHeat() {
        return heat;
    }

    public void setHeat(boolean heat) {
        this.heat = heat;
    }

    public boolean isCooling() {
        return cooling;
    }

    public void setCooling(boolean cooling) {
        this.cooling = cooling;
    }

    public boolean isSewer() {
        return sewer;
    }

    public void setSewer(boolean sewer) {
        this.sewer = sewer;
    }

    public int getGarage() {
        return garage;
    }

    public void setGarage(int garage) {
        this.garage = garage;
    }

    public String getPropertyFeatures() {
        return propertyFeatures;
    }

    public void setPropertyFeatures(String propertyFeatures) {
        this.propertyFeatures = propertyFeatures;
    }
}
