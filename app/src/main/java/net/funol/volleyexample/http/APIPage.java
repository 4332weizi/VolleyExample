package net.funol.volleyexample.http;

import java.util.List;

/**
 * Created by zhaoweiwei on 15/4/20.
 */
public class APIPage<T>{

    private List<T> data;
    private int totalPages;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
