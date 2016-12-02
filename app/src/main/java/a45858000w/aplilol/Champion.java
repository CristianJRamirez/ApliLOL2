package a45858000w.aplilol;

/**
 * Created by 45858000w on 02/12/16.
 */

public class Champion {

    private String ImageChampionSquare="http://ddragon.leagueoflegends.com/cdn/6.23.1/img/champion/Aatrox.png";
    private String ImageChampionLarge="http://ddragon.leagueoflegends.com/cdn/img/champion/loading/Aatrox_0.jpg";
    private String ImageChampionFondo="http://ddragon.leagueoflegends.com/cdn/img/champion/splash/Aatrox_0.jpg";

    private String name;
    private String id;
    private String titulo;
    private String key;

    private String ImageW;
    private String ImageH;
    private String ImageSquareFull;
    private String ImageSprite;
    private String ImageY;
    private String ImageX;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImageW() {
        return ImageW;
    }

    public void setImageW(String imageW) {
        ImageW = imageW;
    }

    public String getImageH() {
        return ImageH;
    }

    public void setImageH(String imageH) {
        ImageH = imageH;
    }

    public String getImageSquareFull() {
        return ImageSquareFull;
    }

    public void setImageSquareFull(String imageSquareFull) {
        ImageSquareFull = imageSquareFull;
    }

    public String getImageSprite() {
        return ImageSprite;
    }

    public void setImageSprite(String imageSprite) {
        ImageSprite = imageSprite;
    }

    public String getImageY() {
        return ImageY;
    }

    public void setImageY(String imageY) {
        ImageY = imageY;
    }

    public String getImageX() {
        return ImageX;
    }

    public void setImageX(String imageX) {
        ImageX = imageX;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", titulo='" + titulo + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
