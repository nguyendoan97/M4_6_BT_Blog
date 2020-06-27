package com.codegym.model;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String title;
    private long datecreate = System.currentTimeMillis();
    private String content;
    private String author;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(long datecreate) {
        this.datecreate = datecreate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
