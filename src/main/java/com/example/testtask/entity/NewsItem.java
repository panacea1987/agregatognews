package com.example.testtask.entity;

import javax.persistence.*;

@Entity
@Table(name = "NEWS")
public class NewsItem {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "url", length = 1000)
    private String urlNews;
    @Column(name = "news_header", length = 1000)
    private String headerNews;
    @Column(name = "news_link", length = 1000)
    private String linkNews;
    @Column(name = "news_img_link", length = 1000)
    private String linkImgNews;
    @Column(name = "news_datetime")
    private String dateTimeNews;

    public NewsItem(String urlNews, String headerNews, String linkNews, String linkImgNews, String dateTimeNews) {
        this.urlNews = urlNews;
        this.headerNews = headerNews;
        this.linkNews = linkNews;
        this.linkImgNews = linkImgNews;
        this.dateTimeNews = dateTimeNews;
    }

    public NewsItem() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrlNews() {
        return urlNews;
    }

    public void setUrlNews(String urlNews) {
        this.urlNews = urlNews;
    }

    public String getHeaderNews() {
        return headerNews;
    }

    public void setHeaderNews(String headerNews) {
        this.headerNews = headerNews;
    }

    public String getLinkNews() {
        return linkNews;
    }

    public void setLinkNews(String linkNews) {
        this.linkNews = linkNews;
    }

    public String getLinkImgNews() {
        return linkImgNews;
    }

    public void setLinkImgNews(String linkImgNews) {
        this.linkImgNews = linkImgNews;
    }

    public String getDateTimeNews() {
        return dateTimeNews;
    }

    public void setDateTimeNews(String dateTimeNews) {
        this.dateTimeNews = dateTimeNews;
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "urlNews='" + urlNews + '\'' +
                ", headerNews='" + headerNews + '\'' +
                ", linkNews='" + linkNews + '\'' +
                ", linkImgNews='" + linkImgNews + '\'' +
                ", dateTimeNews='" + dateTimeNews + '\'' +
                '}';
    }
}
