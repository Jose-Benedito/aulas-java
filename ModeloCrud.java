/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrosvendas;

/**
 *
 * @author bene
 */
public abstract class ModeloCrud {
    protected String InsertPadrao;
    protected String UpDatePadrao;
    protected String deletePadrao;
    protected String SelectPadrao;
    protected String insert;
    protected String update;
    protected String delete;
    public Banco Banco;


    public String getInsertPadrao() {
        return InsertPadrao;
    }

    public void setInsertPadrao(String InsertPadrao) {
        this.InsertPadrao = InsertPadrao;
    }

    public String getUpDatePadrao() {
        return UpDatePadrao;
    }

    public void setUpDatePadrao(String UpDatePadrao) {
        this.UpDatePadrao = UpDatePadrao;
    }

    public String getDeletePadrao() {
        return deletePadrao;
    }

    public void setDeletePadrao(String deletePadrao) {
        this.deletePadrao = deletePadrao;
    }

    public String getSelectPadrao() {
        return SelectPadrao;
    }

    public void setSelectPadrao(String SelectPadrao) {
        this.SelectPadrao = SelectPadrao;
    }

    public String getInsert() {
        return insert;
    }

    public void setInsert(String insert) {
        this.insert = insert;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public Banco getBanco() {
        return Banco;
    }

    public void setBanco(Banco Banco) {
        this.Banco = Banco;
    }
    
    
    
    public  abstract salvar();
    public abstract alterar();
    public abstract excluir();
    public abstract recuperar();
}
