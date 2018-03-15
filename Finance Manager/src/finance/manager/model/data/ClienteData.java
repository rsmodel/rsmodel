/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finance.manager.model.data;

/**
 *
 * @author User
 */
public class ClienteData {

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getRazao_social() {
        return _razao_social;
    }

    public ClienteData(int _id, String _razao_social, String _nome_fantasia) {
        this._id = _id;
        this._razao_social = _razao_social;
        this._nome_fantasia = _nome_fantasia;
    }

    public void setRazao_social(String _razao_social) {
        this._razao_social = _razao_social;
    }

    public String getNome_fantasia() {
        return _nome_fantasia;
    }

    public void setNome_fantasia(String _nome_fantasia) {
        this._nome_fantasia = _nome_fantasia;
    }

    public String getF_j() {
        return _f_j;
    }

    public void setF_j(String _f_j) {
        this._f_j = _f_j;
    }

    public String getCPF_CNPJ() {
        return _CPF_CNPJ;
    }

    public void setCPF_CNPJ(String _CPF_CNPJ) {
        this._CPF_CNPJ = _CPF_CNPJ;
    }

    public String getInscrição_estadual() {
        return _inscrição_estadual;
    }

    public void setInscrição_estadual(String _inscrição_estadual) {
        this._inscrição_estadual = _inscrição_estadual;
    }

    public String getFone() {
        return _fone;
    }

    public void setFone(String _fone) {
        this._fone = _fone;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getEndereco() {
        return _endereco;
    }

    public void setEndereco(String _endereco) {
        this._endereco = _endereco;
    }

    public String getComplemento() {
        return _complemento;
    }

    public void setComplemento(String _complemento) {
        this._complemento = _complemento;
    }

    public String getCEP() {
        return _CEP;
    }

    public void setCEP(String _CEP) {
        this._CEP = _CEP;
    }

    public String getCidade() {
        return _cidade;
    }

    public void setCidade(String _cidade) {
        this._cidade = _cidade;
    }

    public String getUf() {
        return _uf;
    }

    public void setUf(String _uf) {
        this._uf = _uf;
    }

    public String getBairro() {
        return _bairro;
    }

    public void setBairro(String _bairro) {
        this._bairro = _bairro;
    }

    public String getNum_endereco() {
        return _num_endereco;
    }

    public void setNum_endereco(String _num_endereco) {
        this._num_endereco = _num_endereco;
    }

    public int getVendedor() {
        return _vendedor;
    }

    public void setVendedor(int _vendedor) {
        this._vendedor = _vendedor;
    }

    public int getTransportador() {
        return _transportador;
    }

    public void setTransportador(int _transportador) {
        this._transportador = _transportador;
    }
    private int _id;
    private String _razao_social;
    private String _nome_fantasia;
    private String _f_j;
    private String _CPF_CNPJ;
    private String _inscrição_estadual;
    private String _fone;
    private String _email;
    private String _endereco;
    private String _complemento;
    private String _CEP;
    private String _cidade;
    private String _uf;
    private String _bairro;
    private String _num_endereco;
    private int _vendedor;
    private int _transportador;
}
