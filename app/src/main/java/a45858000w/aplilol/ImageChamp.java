package a45858000w.aplilol;

/**
 * Created by 45858000w on 09/12/16.
 */

public class ImageChamp {
    private String full;
    private String sprite;

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    @Override
    public String toString() {
        return "ImageChamp{" +
                "full='" + full + '\'' +
                ", sprite='" + sprite + '\'' +
                '}';
    }
}
