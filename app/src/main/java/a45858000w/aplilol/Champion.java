package a45858000w.aplilol;

import java.io.Serializable;

/**
 * Created by 45858000w on 02/12/16.
 */

public class Champion implements Serializable {

    private String ImageChampionSquare="http://ddragon.leagueoflegends.com/cdn/6.23.1/img/champion/";//Aatrox.png";
    private String ImageChampionLarge="http://ddragon.leagueoflegends.com/cdn/img/champion/loading/";//Aatrox_0.jpg";
    private String ImageChampionFondo="http://ddragon.leagueoflegends.com/cdn/img/champion/splash/";//Aatrox_0.jpg";

    private String name;
    private String id;
    private String title;
    private String key;

    private String ImageW;
    private String ImageH;
    private String ImageSquareFull;
    private String ImageSprite;
    private String ImageY;
    private String ImageX;
    private String lore;
    private String blurb;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String titulo) {
        this.title = titulo;
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
        ImageSquareFull = ImageChampionSquare+imageSquareFull;
    }

    public String getImageSprite() {
        return ImageSprite;
    }

    public void setImageSprite(String imageSprite) {
        ImageSprite = ImageChampionLarge+imageSprite;
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

    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", key='" + key + '\'' +
                ", ImageSquareFull='" + ImageSquareFull + '\'' +
                ", ImageSprite='" + ImageSprite + '\'' +
                ", lore='" + lore + '\'' +
                ", blurb='" + blurb + '\'' +
                '}';
    }
}
