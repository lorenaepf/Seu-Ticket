package br.ufc.quixada.app;

public class Model {

    private int imageview;
    private String text1;
    private String text2;

    public Model(int imageview, String text1, String text2) {
        this.imageview = imageview;
        this.text1 = text1;
        this.text2 = text2;
    }

    public int getImageview() {
        return imageview;
    }

    public String getText1() {
        return text1;
    }

    public String getText2() {
        return text2;
    }
}
