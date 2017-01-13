package a45858000w.aplilol.DatosSecundarios;

/**
 * Created by 45858000w on 13/01/17.
 */

public class InfoPassive {
    private String name;
    private String description;

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

    @Override
    public String toString() {
        return "InfoPassive{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
