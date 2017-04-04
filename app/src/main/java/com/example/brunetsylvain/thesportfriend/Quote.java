package com.example.brunetsylvain.thesportfriend;

import java.util.Date;

/**
 * Created by jeanbaptiste.ledig on 04/04/2017.
 */

public class Quote {
    private String strQuote;
    private Integer rating;
    private Date creationDate;

    public Quote(String quote) {
        this.strQuote = quote;
        this.rating = 0;
        this.creationDate = new Date();
    }

    public String getStrQuote() {
        return strQuote;
    }

    public void setStrQuote(String strQuote) {
        this.strQuote = strQuote;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
