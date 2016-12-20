package a45858000w.aplilol.DatosSecundarios;

/**
 * Created by 45858000w on 20/12/16.
 */

public class InfoEstadisticas {
    private int attack ;
    private int defense;
    private int magic;
    private int difficulty;

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

    @Override
    public String toString() {
        return "InfoEstadisticas{" +
                "attack=" + attack +
                ", defense=" + defense +
                ", magic=" + magic +
                ", difficulty=" + difficulty +
                '}';
    }
}
