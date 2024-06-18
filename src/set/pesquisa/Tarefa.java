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

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa tarefa)) return false;
        return Objects.equals(getDescricaoTarefa(), tarefa.getDescricaoTarefa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescricaoTarefa());
    }

    @Override
    public String toString() {
        return "{Descrição: " + descricaoTarefa + ", Status: " + status + "}";
    }
}
