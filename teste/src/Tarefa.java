public class Tarefa {
    private String descricao;
    private String Status;
    private int id;


    public Tarefa(){

    }
    public Tarefa(String descricao, String status, int id) {
        this.descricao = descricao;
        Status = status;
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
