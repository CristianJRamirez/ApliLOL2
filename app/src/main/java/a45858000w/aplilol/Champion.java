package a45858000w.aplilol;

import java.io.Serializable;
import java.util.ArrayList;

import a45858000w.aplilol.DatosSecundarios.Habilidades;

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

    private String tipoChamp;

    private int attack ;
    private int defense;
    private int magic;
    private int difficulty;

    private String namePassive;
    private String descriptionPassive;

    private String allytipsFuncionalidad;
    private String enemytipsAnulacion;

    ///private ArrayList<Habilidades> habilidades;

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

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getTipoChamp() {
        return tipoChamp;
    }

    public void setTipoChamp(String tipoChamp) {
        this.tipoChamp = tipoChamp;
    }

    public String getDescriptionPassive() {
        return descriptionPassive;
    }

    public void setDescriptionPassive(String descriptionPassive) {
        this.descriptionPassive = descriptionPassive;
    }

    public String getNamePassive() {
        return namePassive;
    }

    public void setNamePassive(String namePassive) {
        this.namePassive = namePassive;
    }

    /*public ArrayList<Habilidades> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidades> habilidades) {
        this.habilidades = habilidades;
    }
*/
    public String getAllytipsFuncionalidad() {
        return allytipsFuncionalidad;
    }

    public void setAllytipsFuncionalidad(String allytipsFuncionalidad) {
        this.allytipsFuncionalidad = allytipsFuncionalidad;
    }

    public String getEnemytipsAnulacion() {
        return enemytipsAnulacion;
    }

    public void setEnemytipsAnulacion(String enemytipsAnulacion) {
        this.enemytipsAnulacion = enemytipsAnulacion;
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
                ", tipoChamp='" + tipoChamp + '\'' +
                ", attack=" + attack +
                ", defense=" + defense +
                ", magic=" + magic +
                ", difficulty=" + difficulty +
                ", PassiveName=" + namePassive +
                ", PassiveDescripcion=" + descriptionPassive +
                '}';
    }
}
