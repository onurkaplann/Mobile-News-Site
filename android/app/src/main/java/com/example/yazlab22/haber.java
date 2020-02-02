package com.example.yazlab22;

public class haber {

    String id;
    String url;
    String haberbaslik;
    String habericerik;
    String haberturu;
    String yayintarihi;
    String goruntusayisi;

    /*public haber(String id,String url,String haberbaslik,String habericerik,String haberturu,String yayintarihi){

        this.id = id;
        this.url = url;
        this.haberbaslik = haberbaslik;
        this.habericerik = habericerik;
        this.haberturu = haberturu;
        this.yayintarihi = yayintarihi;

    }*/

    public String getId(){ return id; }
    public void setId(String id){ this.id = id; }

    public String getUrl(){ return url; }
    public void setUrl(String url){ this.url = url; }

    public String getHaberbaslik(){ return haberbaslik; }
    public void setHaberbaslik(String haberbaslik){ this.haberbaslik = haberbaslik; }

    public String getHabericerik(){ return habericerik; }
    public void setHabericerik(String habericerik){ this.habericerik = habericerik; }

    public String getHaberturu(){ return haberturu; }
    public void setHaberturu(String haberturu){ this.haberturu = haberturu; }

    public String getYayintarihi(){ return yayintarihi; }
    public void setYayintarihi(String yayintarihi){ this.yayintarihi = yayintarihi; }

    public String getGoruntusayisi(){ return goruntusayisi; }
    public void setGoruntusayisi(String goruntusayisi) { this.goruntusayisi = goruntusayisi; }


}
