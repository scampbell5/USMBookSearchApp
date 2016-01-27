
package com.sean.usmbooksearch.model.USM;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonPropertyOrder({
    "attributeCode",
    "attributeDescr",
    "attributeName",
    "bookAttrLabel",
    "id",
    "isNew",
    "isRental",
    "isPartnerRental",
    "isUsed",
    "location",
    "onhand",
    "price",
    "salePrice",
    "sku",
    "rentDueDate",
    "rentDueDateDay",
    "rentDueDateMonth",
    "rentDueDateYear",
    "rentDuration",
    "rentDurationDays",
    "rentDurationUnit",
    "rentExtraFee",
    "rentId",
    "rentLabel",
    "rentLateFee",
    "rentReplacementPrice",
    "rentTermLabel",
    "rentVendor",
    "rentVendorId",
    "rentVendorUrl",
    "isEbook",
    "eBook",
    "source"
})
public class Detail {

    @JsonProperty("attributeCode")
    private String attributeCode;
    @JsonProperty("attributeDescr")
    private String attributeDescr;
    @JsonProperty("attributeName")
    private String attributeName;
    @JsonProperty("bookAttrLabel")
    private String bookAttrLabel;
    @JsonProperty("id")
    private String id;
    @JsonProperty("isNew")
    private String isNew;
    @JsonProperty("isRental")
    private String isRental;
    @JsonProperty("isPartnerRental")
    private String isPartnerRental;
    @JsonProperty("isUsed")
    private String isUsed;
    @JsonProperty("location")
    private String location;
    @JsonProperty("onhand")
    private String onhand;
    @JsonProperty("price")
    private String price;
    @JsonProperty("salePrice")
    private String salePrice;
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("rentDueDate")
    private String rentDueDate;
    @JsonProperty("rentDueDateDay")
    private String rentDueDateDay;
    @JsonProperty("rentDueDateMonth")
    private String rentDueDateMonth;
    @JsonProperty("rentDueDateYear")
    private String rentDueDateYear;
    @JsonProperty("rentDuration")
    private String rentDuration;
    @JsonProperty("rentDurationDays")
    private String rentDurationDays;
    @JsonProperty("rentDurationUnit")
    private String rentDurationUnit;
    @JsonProperty("rentExtraFee")
    private String rentExtraFee;
    @JsonProperty("rentId")
    private String rentId;
    @JsonProperty("rentLabel")
    private String rentLabel;
    @JsonProperty("rentLateFee")
    private String rentLateFee;
    @JsonProperty("rentReplacementPrice")
    private String rentReplacementPrice;
    @JsonProperty("rentTermLabel")
    private String rentTermLabel;
    @JsonProperty("rentVendor")
    private String rentVendor;
    @JsonProperty("rentVendorId")
    private String rentVendorId;
    @JsonProperty("rentVendorUrl")
    private String rentVendorUrl;
    @JsonProperty("isEbook")
    private String isEbook;
    @JsonProperty("eBook")
    private EBook eBook;
    @JsonProperty("source")
    private String source;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * 
     * @return
     *     The attributeCode
     */
    @JsonProperty("attributeCode")
    public String getAttributeCode() {
        return attributeCode;
    }

    /**
     * 
     * @param attributeCode
     *     The attributeCode
     */
    @JsonProperty("attributeCode")
    public void setAttributeCode(String attributeCode) {
        this.attributeCode = attributeCode;
    }

    /**
     * 
     * @return
     *     The attributeDescr
     */
    @JsonProperty("attributeDescr")
    public String getAttributeDescr() {
        return attributeDescr;
    }

    /**
     * 
     * @param attributeDescr
     *     The attributeDescr
     */
    @JsonProperty("attributeDescr")
    public void setAttributeDescr(String attributeDescr) {
        this.attributeDescr = attributeDescr;
    }

    /**
     * 
     * @return
     *     The attributeName
     */
    @JsonProperty("attributeName")
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * 
     * @param attributeName
     *     The attributeName
     */
    @JsonProperty("attributeName")
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    /**
     * 
     * @return
     *     The bookAttrLabel
     */
    @JsonProperty("bookAttrLabel")
    public String getBookAttrLabel() {
        return bookAttrLabel;
    }

    /**
     * 
     * @param bookAttrLabel
     *     The bookAttrLabel
     */
    @JsonProperty("bookAttrLabel")
    public void setBookAttrLabel(String bookAttrLabel) {
        this.bookAttrLabel = bookAttrLabel;
    }

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The isNew
     */
    @JsonProperty("isNew")
    public String getIsNew() {
        return isNew;
    }

    /**
     * 
     * @param isNew
     *     The isNew
     */
    @JsonProperty("isNew")
    public void setIsNew(String isNew) {
        this.isNew = isNew;
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
     *     The isUsed
     */
    @JsonProperty("isUsed")
    public String getIsUsed() {
        return isUsed;
    }

    /**
     * 
     * @param isUsed
     *     The isUsed
     */
    @JsonProperty("isUsed")
    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
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
     *     The onhand
     */
    @JsonProperty("onhand")
    public String getOnhand() {
        return onhand;
    }

    /**
     * 
     * @param onhand
     *     The onhand
     */
    @JsonProperty("onhand")
    public void setOnhand(String onhand) {
        this.onhand = onhand;
    }

    /**
     * 
     * @return
     *     The price
     */
    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 
     * @return
     *     The salePrice
     */
    @JsonProperty("salePrice")
    public String getSalePrice() {
        return salePrice;
    }

    /**
     * 
     * @param salePrice
     *     The salePrice
     */
    @JsonProperty("salePrice")
    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
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
     *     The rentDueDate
     */
    @JsonProperty("rentDueDate")
    public String getRentDueDate() {
        return rentDueDate;
    }

    /**
     * 
     * @param rentDueDate
     *     The rentDueDate
     */
    @JsonProperty("rentDueDate")
    public void setRentDueDate(String rentDueDate) {
        this.rentDueDate = rentDueDate;
    }

    /**
     * 
     * @return
     *     The rentDueDateDay
     */
    @JsonProperty("rentDueDateDay")
    public String getRentDueDateDay() {
        return rentDueDateDay;
    }

    /**
     * 
     * @param rentDueDateDay
     *     The rentDueDateDay
     */
    @JsonProperty("rentDueDateDay")
    public void setRentDueDateDay(String rentDueDateDay) {
        this.rentDueDateDay = rentDueDateDay;
    }

    /**
     * 
     * @return
     *     The rentDueDateMonth
     */
    @JsonProperty("rentDueDateMonth")
    public String getRentDueDateMonth() {
        return rentDueDateMonth;
    }

    /**
     * 
     * @param rentDueDateMonth
     *     The rentDueDateMonth
     */
    @JsonProperty("rentDueDateMonth")
    public void setRentDueDateMonth(String rentDueDateMonth) {
        this.rentDueDateMonth = rentDueDateMonth;
    }

    /**
     * 
     * @return
     *     The rentDueDateYear
     */
    @JsonProperty("rentDueDateYear")
    public String getRentDueDateYear() {
        return rentDueDateYear;
    }

    /**
     * 
     * @param rentDueDateYear
     *     The rentDueDateYear
     */
    @JsonProperty("rentDueDateYear")
    public void setRentDueDateYear(String rentDueDateYear) {
        this.rentDueDateYear = rentDueDateYear;
    }

    /**
     * 
     * @return
     *     The rentDuration
     */
    @JsonProperty("rentDuration")
    public String getRentDuration() {
        return rentDuration;
    }

    /**
     * 
     * @param rentDuration
     *     The rentDuration
     */
    @JsonProperty("rentDuration")
    public void setRentDuration(String rentDuration) {
        this.rentDuration = rentDuration;
    }

    /**
     * 
     * @return
     *     The rentDurationDays
     */
    @JsonProperty("rentDurationDays")
    public String getRentDurationDays() {
        return rentDurationDays;
    }

    /**
     * 
     * @param rentDurationDays
     *     The rentDurationDays
     */
    @JsonProperty("rentDurationDays")
    public void setRentDurationDays(String rentDurationDays) {
        this.rentDurationDays = rentDurationDays;
    }

    /**
     * 
     * @return
     *     The rentDurationUnit
     */
    @JsonProperty("rentDurationUnit")
    public String getRentDurationUnit() {
        return rentDurationUnit;
    }

    /**
     * 
     * @param rentDurationUnit
     *     The rentDurationUnit
     */
    @JsonProperty("rentDurationUnit")
    public void setRentDurationUnit(String rentDurationUnit) {
        this.rentDurationUnit = rentDurationUnit;
    }

    /**
     * 
     * @return
     *     The rentExtraFee
     */
    @JsonProperty("rentExtraFee")
    public String getRentExtraFee() {
        return rentExtraFee;
    }

    /**
     * 
     * @param rentExtraFee
     *     The rentExtraFee
     */
    @JsonProperty("rentExtraFee")
    public void setRentExtraFee(String rentExtraFee) {
        this.rentExtraFee = rentExtraFee;
    }

    /**
     * 
     * @return
     *     The rentId
     */
    @JsonProperty("rentId")
    public String getRentId() {
        return rentId;
    }

    /**
     * 
     * @param rentId
     *     The rentId
     */
    @JsonProperty("rentId")
    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    /**
     * 
     * @return
     *     The rentLabel
     */
    @JsonProperty("rentLabel")
    public String getRentLabel() {
        return rentLabel;
    }

    /**
     * 
     * @param rentLabel
     *     The rentLabel
     */
    @JsonProperty("rentLabel")
    public void setRentLabel(String rentLabel) {
        this.rentLabel = rentLabel;
    }

    /**
     * 
     * @return
     *     The rentLateFee
     */
    @JsonProperty("rentLateFee")
    public String getRentLateFee() {
        return rentLateFee;
    }

    /**
     * 
     * @param rentLateFee
     *     The rentLateFee
     */
    @JsonProperty("rentLateFee")
    public void setRentLateFee(String rentLateFee) {
        this.rentLateFee = rentLateFee;
    }

    /**
     * 
     * @return
     *     The rentReplacementPrice
     */
    @JsonProperty("rentReplacementPrice")
    public String getRentReplacementPrice() {
        return rentReplacementPrice;
    }

    /**
     * 
     * @param rentReplacementPrice
     *     The rentReplacementPrice
     */
    @JsonProperty("rentReplacementPrice")
    public void setRentReplacementPrice(String rentReplacementPrice) {
        this.rentReplacementPrice = rentReplacementPrice;
    }

    /**
     * 
     * @return
     *     The rentTermLabel
     */
    @JsonProperty("rentTermLabel")
    public String getRentTermLabel() {
        return rentTermLabel;
    }

    /**
     * 
     * @param rentTermLabel
     *     The rentTermLabel
     */
    @JsonProperty("rentTermLabel")
    public void setRentTermLabel(String rentTermLabel) {
        this.rentTermLabel = rentTermLabel;
    }

    /**
     * 
     * @return
     *     The rentVendor
     */
    @JsonProperty("rentVendor")
    public String getRentVendor() {
        return rentVendor;
    }

    /**
     * 
     * @param rentVendor
     *     The rentVendor
     */
    @JsonProperty("rentVendor")
    public void setRentVendor(String rentVendor) {
        this.rentVendor = rentVendor;
    }

    /**
     * 
     * @return
     *     The rentVendorId
     */
    @JsonProperty("rentVendorId")
    public String getRentVendorId() {
        return rentVendorId;
    }

    /**
     * 
     * @param rentVendorId
     *     The rentVendorId
     */
    @JsonProperty("rentVendorId")
    public void setRentVendorId(String rentVendorId) {
        this.rentVendorId = rentVendorId;
    }

    /**
     * 
     * @return
     *     The rentVendorUrl
     */
    @JsonProperty("rentVendorUrl")
    public String getRentVendorUrl() {
        return rentVendorUrl;
    }

    /**
     * 
     * @param rentVendorUrl
     *     The rentVendorUrl
     */
    @JsonProperty("rentVendorUrl")
    public void setRentVendorUrl(String rentVendorUrl) {
        this.rentVendorUrl = rentVendorUrl;
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
     *     The eBook
     */
    @JsonProperty("eBook")
    public EBook getEBook() {
        return eBook;
    }

    /**
     * 
     * @param eBook
     *     The eBook
     */
    @JsonProperty("eBook")
    public void setEBook(EBook eBook) {
        this.eBook = eBook;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
