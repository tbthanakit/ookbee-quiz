package com.sgt.it.ookbeequiz.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookRequest {

    @SerializedName("bookId")
    @Expose
    Integer bookId;
    @SerializedName("bookName")
    @Expose
    String bookName;
    @SerializedName("bookAuthor")
    @Expose
    String bookAuthor;
    @SerializedName("bookPrice")
    @Expose
    Double bookPrice;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }
}
