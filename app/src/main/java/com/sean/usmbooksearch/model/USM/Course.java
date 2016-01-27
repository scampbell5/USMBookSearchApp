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
    "count",
    "courseAcdept",
    "courseAcdeptcode",
    "courseCampus",
    "courseCampusName",
    "courseClass",
    "courseInstructor",
    "courseSection",
    "courseTerm",
    "index.max",
    "index.min",
    "totalCount",
    "uniqueid",
    "USMBookInfos",
    "courseName"
})
public class Course {

    @JsonProperty("count")
    private String count;
    @JsonProperty("courseAcdept")
    private String courseAcdept;
    @JsonProperty("courseAcdeptcode")
    private String courseAcdeptcode;
    @JsonProperty("courseCampus")
    private String courseCampus;
    @JsonProperty("courseCampusName")
    private String courseCampusName;
    @JsonProperty("courseClass")
    private String courseClass;
    @JsonProperty("courseInstructor")
    private String courseInstructor;
    @JsonProperty("courseSection")
    private String courseSection;
    @JsonProperty("courseTerm")
    private String courseTerm;
    @JsonProperty("index.max")
    private String indexMax;
    @JsonProperty("index.min")
    private String indexMin;
    @JsonProperty("totalCount")
    private String totalCount;
    @JsonProperty("uniqueid")
    private String uniqueid;
    @JsonProperty("USMBookInfos")
    private List<USMBookInfo> USMBookInfos = new ArrayList<>();
    @JsonProperty("courseName")
    private String courseName;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();


    /**
     * 
     * @return
     *     The count
     */
    @JsonProperty("count")
    public String getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    @JsonProperty("count")
    public void setCount(String count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The courseAcdept
     */
    @JsonProperty("courseAcdept")
    public String getCourseAcdept() {
        return courseAcdept;
    }

    /**
     * 
     * @param courseAcdept
     *     The courseAcdept
     */
    @JsonProperty("courseAcdept")
    public void setCourseAcdept(String courseAcdept) {
        this.courseAcdept = courseAcdept;
    }

    /**
     * 
     * @return
     *     The courseAcdeptcode
     */
    @JsonProperty("courseAcdeptcode")
    public String getCourseAcdeptcode() {
        return courseAcdeptcode;
    }

    /**
     * 
     * @param courseAcdeptcode
     *     The courseAcdeptcode
     */
    @JsonProperty("courseAcdeptcode")
    public void setCourseAcdeptcode(String courseAcdeptcode) {
        this.courseAcdeptcode = courseAcdeptcode;
    }

    /**
     * 
     * @return
     *     The courseCampus
     */
    @JsonProperty("courseCampus")
    public String getCourseCampus() {
        return courseCampus;
    }

    /**
     * 
     * @param courseCampus
     *     The courseCampus
     */
    @JsonProperty("courseCampus")
    public void setCourseCampus(String courseCampus) {
        this.courseCampus = courseCampus;
    }

    /**
     * 
     * @return
     *     The courseCampusName
     */
    @JsonProperty("courseCampusName")
    public String getCourseCampusName() {
        return courseCampusName;
    }

    /**
     * 
     * @param courseCampusName
     *     The courseCampusName
     */
    @JsonProperty("courseCampusName")
    public void setCourseCampusName(String courseCampusName) {
        this.courseCampusName = courseCampusName;
    }

    /**
     * 
     * @return
     *     The courseClass
     */
    @JsonProperty("courseClass")
    public String getCourseClass() {
        return courseClass;
    }

    /**
     * 
     * @param courseClass
     *     The courseClass
     */
    @JsonProperty("courseClass")
    public void setCourseClass(String courseClass) {
        this.courseClass = courseClass;
    }

    /**
     * 
     * @return
     *     The courseInstructor
     */
    @JsonProperty("courseInstructor")
    public String getCourseInstructor() {
        return courseInstructor;
    }

    /**
     * 
     * @param courseInstructor
     *     The courseInstructor
     */
    @JsonProperty("courseInstructor")
    public void setCourseInstructor(String courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    /**
     * 
     * @return
     *     The courseSection
     */
    @JsonProperty("courseSection")
    public String getCourseSection() {
        return courseSection;
    }

    /**
     * 
     * @param courseSection
     *     The courseSection
     */
    @JsonProperty("courseSection")
    public void setCourseSection(String courseSection) {
        this.courseSection = courseSection;
    }

    /**
     * 
     * @return
     *     The courseTerm
     */
    @JsonProperty("courseTerm")
    public String getCourseTerm() {
        return courseTerm;
    }

    /**
     * 
     * @param courseTerm
     *     The courseTerm
     */
    @JsonProperty("courseTerm")
    public void setCourseTerm(String courseTerm) {
        this.courseTerm = courseTerm;
    }

    /**
     * 
     * @return
     *     The indexMax
     */
    @JsonProperty("index.max")
    public String getIndexMax() {
        return indexMax;
    }

    /**
     * 
     * @param indexMax
     *     The index.max
     */
    @JsonProperty("index.max")
    public void setIndexMax(String indexMax) {
        this.indexMax = indexMax;
    }

    /**
     * 
     * @return
     *     The indexMin
     */
    @JsonProperty("index.min")
    public String getIndexMin() {
        return indexMin;
    }

    /**
     * 
     * @param indexMin
     *     The index.min
     */
    @JsonProperty("index.min")
    public void setIndexMin(String indexMin) {
        this.indexMin = indexMin;
    }

    /**
     * 
     * @return
     *     The totalCount
     */
    @JsonProperty("totalCount")
    public String getTotalCount() {
        return totalCount;
    }

    /**
     * 
     * @param totalCount
     *     The totalCount
     */
    @JsonProperty("totalCount")
    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 
     * @return
     *     The uniqueid
     */
    @JsonProperty("uniqueid")
    public String getUniqueid() {
        return uniqueid;
    }

    /**
     * 
     * @param uniqueid
     *     The uniqueid
     */
    @JsonProperty("uniqueid")
    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }

    /**
     * 
     * @return
     *     The USMBookInfos
     */
    @JsonProperty("books")
    public List<USMBookInfo> getUSMBookInfos() {
        return USMBookInfos;
    }

    /**
     * 
     * @param USMBookInfos
     *     The USMBookInfos
     */
    @JsonProperty("books")
    public void setUSMBookInfos(List<USMBookInfo> USMBookInfos) {
        this.USMBookInfos = USMBookInfos;
    }

    /**
     * 
     * @return
     *     The courseName
     */
    @JsonProperty("courseName")
    public String getCourseName() {
        return courseName;
    }

    /**
     * 
     * @param courseName
     *     The courseName
     */
    @JsonProperty("courseName")
    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
