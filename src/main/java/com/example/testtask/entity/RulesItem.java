package com.example.testtask.entity;

public class RulesItem {
    private String contentType = "";
    private String feedTag = "";
    private String feedClass = "";
    private String linkAttr = "";
    private String linkClass = "";
    private String imgAttr = "";
    private String imgClass = "";
    private String timeClass = "";
    private String headerClass = "";

    public RulesItem(String contentType, String feedTag, String feedClass, String linkAttr,
                     String linkClass, String imgAttr, String imgClass, String timeClass, String headerClass) {
        this.contentType = contentType;
        this.feedTag = feedTag;
        this.feedClass = feedClass;
        this.linkAttr = linkAttr;
        this.linkClass = linkClass;
        this.imgAttr = imgAttr;
        this.imgClass = imgClass;
        this.timeClass = timeClass;
        this.headerClass = headerClass;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFeedTag() {
        return feedTag;
    }

    public void setFeedTag(String feedTag) {
        this.feedTag = feedTag;
    }

    public String getFeedClass() {
        return feedClass;
    }

    public void setFeedClass(String feedClass) {
        this.feedClass = feedClass;
    }

    public String getLinkAttr() {
        return linkAttr;
    }

    public void setLinkAttr(String linkAttr) {
        this.linkAttr = linkAttr;
    }

    public String getLinkClass() {
        return linkClass;
    }

    public void setLinkClass(String linkClass) {
        this.linkClass = linkClass;
    }

    public String getImgAttr() {
        return imgAttr;
    }

    public void setImgAttr(String imgAttr) {
        this.imgAttr = imgAttr;
    }

    public String getImgClass() {
        return imgClass;
    }

    public void setImgClass(String imgClass) {
        this.imgClass = imgClass;
    }

    public String getTimeClass() {
        return timeClass;
    }

    public void setTimeClass(String timeClass) {
        this.timeClass = timeClass;
    }

    public String getHeaderClass() {
        return headerClass;
    }

    public void setHeaderClass(String headerClass) {
        this.headerClass = headerClass;
    }

    @Override
    public String toString() {
        return "RulesItem{" +
                "contentType='" + contentType + '\'' +
                ", feedTag='" + feedTag + '\'' +
                ", feedClass='" + feedClass + '\'' +
                ", linkAttr='" + linkAttr + '\'' +
                ", linkClass='" + linkClass + '\'' +
                ", imgAttr='" + imgAttr + '\'' +
                ", imgClass='" + imgClass + '\'' +
                ", timeClass='" + timeClass + '\'' +
                ", headerClass='" + headerClass + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RulesItem)) return false;

        RulesItem rulesItem = (RulesItem) o;

        if (contentType != null ? !contentType.equals(rulesItem.contentType) : rulesItem.contentType != null)
            return false;
        if (feedTag != null ? !feedTag.equals(rulesItem.feedTag) : rulesItem.feedTag != null) return false;
        if (feedClass != null ? !feedClass.equals(rulesItem.feedClass) : rulesItem.feedClass != null) return false;
        if (linkAttr != null ? !linkAttr.equals(rulesItem.linkAttr) : rulesItem.linkAttr != null) return false;
        if (linkClass != null ? !linkClass.equals(rulesItem.linkClass) : rulesItem.linkClass != null) return false;
        if (imgAttr != null ? !imgAttr.equals(rulesItem.imgAttr) : rulesItem.imgAttr != null) return false;
        if (imgClass != null ? !imgClass.equals(rulesItem.imgClass) : rulesItem.imgClass != null) return false;
        if (timeClass != null ? !timeClass.equals(rulesItem.timeClass) : rulesItem.timeClass != null) return false;
        return headerClass != null ? headerClass.equals(rulesItem.headerClass) : rulesItem.headerClass == null;
    }

    @Override
    public int hashCode() {
        int result = contentType != null ? contentType.hashCode() : 0;
        result = 31 * result + (feedTag != null ? feedTag.hashCode() : 0);
        result = 31 * result + (feedClass != null ? feedClass.hashCode() : 0);
        result = 31 * result + (linkAttr != null ? linkAttr.hashCode() : 0);
        result = 31 * result + (linkClass != null ? linkClass.hashCode() : 0);
        result = 31 * result + (imgAttr != null ? imgAttr.hashCode() : 0);
        result = 31 * result + (imgClass != null ? imgClass.hashCode() : 0);
        result = 31 * result + (timeClass != null ? timeClass.hashCode() : 0);
        result = 31 * result + (headerClass != null ? headerClass.hashCode() : 0);
        return result;
    }
}
