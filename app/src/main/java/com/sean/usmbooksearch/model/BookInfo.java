package com.sean.usmbooksearch.model;

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


    public BookInfo(String title, String usmNewPrice, String usmUsedPrice, String amazonNewPrice, String amazonUsedPrice, String ISBN, String thumbNailURL, String affiliateLinkURL, List<String> authors){
        this.title = title;
        this.usmNewPrice = usmNewPrice;
        this.usmUsedPrice = usmUsedPrice;
        this.amazonNewPrice = amazonNewPrice;
        this.amazonUsedPrice = amazonUsedPrice;
        this.ISBN = ISBN;
        this.authors = authors;
        this.thumbNailURL = thumbNailURL;
        this.affiliateLinkURL = affiliateLinkURL;
    }


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

    public String getAuthors() {

        if (authors == null || authors.size() == 0){
            return null;
        }else if (authors.size() == 1){
            return authors.get(0);
        }else{
            StringBuilder tempAuthorString = new StringBuilder();
            tempAuthorString.append(authors.get(0));
            for (int i = 1; i < authors.size(); i++){
                tempAuthorString.append(", ").append(authors.get(i));
            }
            return tempAuthorString.toString();
        }
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

        if (usmNewPrice == null || usmNewPrice.equals("0.00")) {
            return "N/A";
        }

        return "$" + usmNewPrice;
    }

    public void setUsmNewPrice(String usmNewPrice) {


        this.usmNewPrice = usmNewPrice;
    }

    public String getUsmUsedPrice() {

        if (usmUsedPrice == null || usmUsedPrice.equals("0.00")) {
            return "N/A";
        }

        return "$" + usmUsedPrice;
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
