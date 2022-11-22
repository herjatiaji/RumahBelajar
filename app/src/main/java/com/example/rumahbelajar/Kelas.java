package com.example.rumahbelajar;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Kelas {

    @SerializedName("id")
    private int id;

    @SerializedName("namaKls")
    private String namaKls;

    @SerializedName("namaMapel")
    private String namaMapel;

    @SerializedName("ikon")
    private String ikon;

    public int getId() {
        return id;
    }

    public String getNamaKls() {
        return namaKls;
    }

    public String getNamaMapel() {
        return namaMapel;
    }

    public String getIkon() {
        return ikon;
    }


    // Coba
    @SerializedName("results")

    private List<Kelas> results = null;

    public List<Kelas> getResults() {
        return results;
    }

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("title")
    private String title;

    @SerializedName("overview")
    private String overview;

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

}
