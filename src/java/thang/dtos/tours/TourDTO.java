/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thang.dtos.tours;

import java.io.Serializable;

/**
 *
 * @author Thang
 */
public class TourDTO implements Serializable {

    private String tourName, tourOrigin, tourDes, description, imgUrl;
    private int tourDuration, tourId;

    public TourDTO() {
    }

    public TourDTO(int tourId, String tourName, String tourOrigin, String tourDes, int tourDuration, String description, String imgUrl) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.tourOrigin = tourOrigin;
        this.tourDes = tourDes;
        this.tourDuration = tourDuration;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public TourDTO(String tourName, String tourOrigin, String tourDes, int tourDuration, String description, String imgUrl) {
        this.tourName = tourName;
        this.tourOrigin = tourOrigin;
        this.tourDes = tourDes;
        this.tourDuration = tourDuration;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getTourOrigin() {
        return tourOrigin;
    }

    public void setTourOrigin(String tourOrigin) {
        this.tourOrigin = tourOrigin;
    }

    public String getTourDes() {
        return tourDes;
    }

    public void setTourDes(String tourDes) {
        this.tourDes = tourDes;
    }

    public int getTourDuration() {
        return tourDuration;
    }

    public void setTourDuration(int tourDuration) {
        this.tourDuration = tourDuration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
