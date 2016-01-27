package com.sean.usmbooksearch.model.Amazon;

import java.util.List;

public class BookInfo {

    private String title;
    private String usmNewPrice;
    private String usmUsedPrice;
    private String amazonNewPrice;
    private String amazonUsedPrice;
    private String ISBN;
    private List<String> authors;
    private String thumbNailURL;
    private String affiliateLinkURL;

    public String getThumbNailURL() {
        return thumbNailURL;
    }

    public void setThumbNailURL(String thumbNailURL) {
        this.thumbNailURL = thumbNailURL;
    }

    public String getAffiliateLinkURL() {
        return affiliateLinkURL;
    }

    public void setAffiliateLinkURL(String affiliateLinkURL) {
        this.affiliateLinkURL = affiliateLinkURL;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsmNewPrice() {

        if (usmNewPrice == null) {
            return "N/A";
        }

        return usmNewPrice;
    }

    public void setUsmNewPrice(String usmNewPrice) {
        this.usmNewPrice = usmNewPrice;
    }

    public String getUsmUsedPrice() {

        if (usmUsedPrice == null) {
            return "N/A";
        }

        return usmUsedPrice;
    }

    public void setUsmUsedPrice(String usmUsedPrice) {
        this.usmUsedPrice = usmUsedPrice;
    }

    public String getAmazonNewPrice() {

        if (amazonNewPrice == null) {
            return "N/A";
        }

        return amazonNewPrice;
    }

    public void setAmazonNewPrice(String amazonNewPrice) {
        this.amazonNewPrice = amazonNewPrice;
    }

    public String getAmazonUsedPrice() {

        if (amazonUsedPrice == null) {
            return "N/A";
        }

        return amazonUsedPrice;
    }

    public void setAmazonUsedPrice(String amazonUsedPrice) {

        this.amazonUsedPrice = amazonUsedPrice;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
