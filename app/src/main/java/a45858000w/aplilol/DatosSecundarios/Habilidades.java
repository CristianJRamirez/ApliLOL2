package a45858000w.aplilol.DatosSecundarios;

/**
 * Created by 45858000w on 13/01/17.
 */

public class Habilidades {
    private String name;
    private String description;
    private String costType;
    private String costBurn;
    private String cooldownBurn;
    private String rangeBurn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public String getCostBurn() {
        return costBurn;
    }

    public void setCostBurn(String costBurn) {
        this.costBurn = costBurn;
    }

    public String getCooldownBurn() {
        return cooldownBurn;
    }

    public void setCooldownBurn(String cooldownBurn) {
        this.cooldownBurn = cooldownBurn;
    }

    public String getRangeBurn() {
        return rangeBurn;
    }

    public void setRangeBurn(String rangeBurn) {
        this.rangeBurn = rangeBurn;
    }

    @Override
    public String toString() {
        return "Habilidades{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", costType='" + costType + '\'' +
                ", costBurn='" + costBurn + '\'' +
                ", cooldownBurn='" + cooldownBurn + '\'' +
                ", rangeBurn='" + rangeBurn + '\'' +
                '}';
    }
}
