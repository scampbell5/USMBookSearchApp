
package com.sean.usmbooksearch.model.USM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "author",
    "isText",
    "isSuggested",
    "bookstatus",
    "bookstatusCode",
    "ebookId",
    "ebookSystem",
    "index",
    "isEbook",
    "isbn",
    "location",
    "sku",
    "source",
    "details",
    "hasDescription",
    "isRental",
    "isPartnerRental",
    "isOnlyPartnerRental",
    "idDetail"
})
public class USMBookInfo {

    @JsonProperty("title")
    private String title;
    @JsonProperty("author")
    private String author;
    @JsonProperty("isText")
    private String isText;
    @JsonProperty("isSuggested")
    private String isSuggested;
    @JsonProperty("bookstatus")
    private String bookstatus;
    @JsonProperty("bookstatusCode")
    private String bookstatusCode;
    @JsonProperty("ebookId")
    private String ebookId;
    @JsonProperty("ebookSystem")
    private String ebookSystem;
    @JsonProperty("index")
    private String index;
    @JsonProperty("isEbook")
    private String isEbook;
    @JsonProperty("isbn")
    private String isbn;
    @JsonProperty("location")
    private String location;
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("source")
    private String source;
    @JsonProperty("details")
    private List<Detail> details = new ArrayList<>();
    @JsonProperty("hasDescription")
    private String hasDescription;
    @JsonProperty("isRental")
    private String isRental;
    @JsonProperty("isPartnerRental")
    private String isPartnerRental;
    @JsonProperty("isOnlyPartnerRental")
    private String isOnlyPartnerRental;
    @JsonProperty("idDetail")
    private String idDetail;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
    private String thumbnailURL;
    private List<String> authors;
    private String subtitle;
    private boolean gBookInfoAvailable;
    private String gBookURL;

    public String getNewPrice() {

        for (Detail detail : details){
            if (detail.getAttributeDescr() != null && detail.getAttributeDescr().equalsIgnoreCase("new")){
                return detail.getSalePrice();
            }
        }

        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    private String newPrice;

    public String getUsedPrice() {

        for (Detail detail : details){
            if (detail.getAttributeDescr() != null && detail.getAttributeDescr().equalsIgnoreCase("used")){
                return detail.getSalePrice();
            }
        }

        return usedPrice;
    }

    public void setUsedPrice(String usedPrice) {
        this.usedPrice = usedPrice;
    }

    private String usedPrice;

    public String getgBookURL() {
        return gBookURL;
    }

    public void setgBookURL(String gBookURL) {
        this.gBookURL = gBookURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public boolean isgBookInfoAvailable() {
        return gBookInfoAvailable;
    }

    public void setgBookInfoAvailable(boolean gBookInfoAvailable) {
        this.gBookInfoAvailable = gBookInfoAvailable;
    }

    /**
     *
     * @return
     *     The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     *     The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     *     The author
     */
    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     *     The author
     */
    @JsonProperty("author")
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @return
     *     The isText
     */
    @JsonProperty("isText")
    public String getIsText() {
        return isText;
    }

    /**
     *
     * @param isText
     *     The isText
     */
    @JsonProperty("isText")
    public void setIsText(String isText) {
        this.isText = isText;
    }

    /**
     *
     * @return
     *     The isSuggested
     */
    @JsonProperty("isSuggested")
    public String getIsSuggested() {
        return isSuggested;
    }

    /**
     *
     * @param isSuggested
     *     The isSuggested
     */
    @JsonProperty("isSuggested")
    public void setIsSuggested(String isSuggested) {
        this.isSuggested = isSuggested;
    }

    /**
     *
     * @return
     *     The bookstatus
     */
    @JsonProperty("bookstatus")
    public String getBookstatus() {
        return bookstatus;
    }

    /**
     *
     * @param bookstatus
     *     The bookstatus
     */
    @JsonProperty("bookstatus")
    public void setBookstatus(String bookstatus) {
        this.bookstatus = bookstatus;
    }

    /**
     *
     * @return
     *     The bookstatusCode
     */
    @JsonProperty("bookstatusCode")
    public String getBookstatusCode() {
        return bookstatusCode;
    }

    /**
     *
     * @param bookstatusCode
     *     The bookstatusCode
     */
    @JsonProperty("bookstatusCode")
    public void setBookstatusCode(String bookstatusCode) {
        this.bookstatusCode = bookstatusCode;
    }

    /**
     *
     * @return
     *     The ebookId
     */
    @JsonProperty("ebookId")
    public String getEbookId() {
        return ebookId;
    }

    /**
     *
     * @param ebookId
     *     The ebookId
     */
    @JsonProperty("ebookId")
    public void setEbookId(String ebookId) {
        this.ebookId = ebookId;
    }

    /**
     *
     * @return
     *     The ebookSystem
     */
    @JsonProperty("ebookSystem")
    public String getEbookSystem() {
        return ebookSystem;
    }

    /**
     *
     * @param ebookSystem
     *     The ebookSystem
     */
    @JsonProperty("ebookSystem")
    public void setEbookSystem(String ebookSystem) {
        this.ebookSystem = ebookSystem;
    }

    /**
     *
     * @return
     *     The index
     */
    @JsonProperty("index")
    public String getIndex() {
        return index;
    }

    /**
     *
     * @param index
     *     The index
     */
    @JsonProperty("index")
    public void setIndex(String index) {
        this.index = index;
    }

    /**
     *
     * @return
     *     The isEbook
     */
    @JsonProperty("isEbook")
    public String getIsEbook() {
        return isEbook;
    }

    /**
     *
     * @param isEbook
     *     The isEbook
     */
    @JsonProperty("isEbook")
    public void setIsEbook(String isEbook) {
        this.isEbook = isEbook;
    }

    /**
     *
     * @return
     *     The isbn
     */
    @JsonProperty("isbn")
    public String getIsbn() {
        return isbn;
    }

    /**
     *
     * @param isbn
     *     The isbn
     */
    @JsonProperty("isbn")
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     *
     * @return
     *     The location
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location
     *     The location
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return
     *     The sku
     */
    @JsonProperty("sku")
    public String getSku() {
        return sku;
    }

    /**
     *
     * @param sku
     *     The sku
     */
    @JsonProperty("sku")
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     *
     * @return
     *     The source
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     *
     * @param source
     *     The source
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    /**
     *
     * @return
     *     The details
     */
    @JsonProperty("details")
    public List<Detail> getDetails() {
        return details;
    }

    /**
     *
     * @param details
     *     The details
     */
    @JsonProperty("details")
    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    /**
     *
     * @return
     *     The hasDescription
     */
    @JsonProperty("hasDescription")
    public String getHasDescription() {
        return hasDescription;
    }

    /**
     *
     * @param hasDescription
     *     The hasDescription
     */
    @JsonProperty("hasDescription")
    public void setHasDescription(String hasDescription) {
        this.hasDescription = hasDescription;
    }

    /**
     *
     * @return
     *     The isRental
     */
    @JsonProperty("isRental")
    public String getIsRental() {
        return isRental;
    }

    /**
     *
     * @param isRental
     *     The isRental
     */
    @JsonProperty("isRental")
    public void setIsRental(String isRental) {
        this.isRental = isRental;
    }

    /**
     *
     * @return
     *     The isPartnerRental
     */
    @JsonProperty("isPartnerRental")
    public String getIsPartnerRental() {
        return isPartnerRental;
    }

    /**
     *
     * @param isPartnerRental
     *     The isPartnerRental
     */
    @JsonProperty("isPartnerRental")
    public void setIsPartnerRental(String isPartnerRental) {
        this.isPartnerRental = isPartnerRental;
    }

    /**
     *
     * @return
     *     The isOnlyPartnerRental
     */
    @JsonProperty("isOnlyPartnerRental")
    public String getIsOnlyPartnerRental() {
        return isOnlyPartnerRental;
    }

    /**
     *
     * @param isOnlyPartnerRental
     *     The isOnlyPartnerRental
     */
    @JsonProperty("isOnlyPartnerRental")
    public void setIsOnlyPartnerRental(String isOnlyPartnerRental) {
        this.isOnlyPartnerRental = isOnlyPartnerRental;
    }

    /**
     *
     * @return
     *     The idDetail
     */
    @JsonProperty("idDetail")
    public String getIdDetail() {
        return idDetail;
    }

    /**
     *
     * @param idDetail
     *     The idDetail
     */
    @JsonProperty("idDetail")
    public void setIdDetail(String idDetail) {
        this.idDetail = idDetail;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
