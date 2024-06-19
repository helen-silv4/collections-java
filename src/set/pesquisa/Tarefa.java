package set.pesquisa;

import java.util.Objects;

public class Tarefa {
    private String descricaoTarefa;
    private boolean status;

    public Tarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
        this.status = false;
    }

    public String getDescricaoTarefa() {
        return descricaoTarefa;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{Descrição: " + descricaoTarefa + ", Status: " + status + "}";
    }
}
