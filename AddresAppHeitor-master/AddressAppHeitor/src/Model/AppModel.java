package Model;

import java.util.ArrayList;

public class AppModel {
    private String Open;

    public AppModel() {
    }

    public AppModel(String Model, String Nome) {
        this.Model = Model;
        this.Nome = Nome;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    
}
