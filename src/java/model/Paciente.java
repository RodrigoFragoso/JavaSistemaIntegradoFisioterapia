package model;
/**
 *
 * @author Rodrigo
 */
public class Paciente {
    public int idpacientes; 
    private int num_sus; 
    private String nome; 
    private String telefone; 
    private String dt_nasc; 
    private int idade; 
    private String sexo; 
    private int rg; 
    private String dt_emissao;
    private String org_emissor; 
    private String nome_pai; 
    private String nome_mae; 
    private String profissao; 
    private String raca_cor; 
    private String cep; 
    private String endereco; 
    private int numero_casa; 
    private String bairro; 
    private String uf; 
    private String cidade; 
    private String diag_clinico; 
    private String diag_fiso; 
    private String anamnese; 
    private String hma; 
    private String hmp; 
    private String ant_hereditario; 
    private int alg_cirurgia; 
    private String qual_cirurgia; 
    private int tabagista; 
    private String num_cigarros; 
    private int etilista; 
    private String qtd_etilista; 
    private int sedentario; 
    private String freq_sendentario; 
    private int medicamentos; 
    private String quais_medicamentos; 
    private String inicio_sintoma; 
    private String mecanismo_sintoma; 
    private int acomp_sintoma; 
    private String qual_sintoma; 
    private String localizacao_dor; 
    private String carater_dor; 
    private String irradiacao_dor; 
    private String local_dor; 
    private int movimento_dor; 
    private String qual_dor; 
    private int repouso_dor; 
    private int climatica_dor; 
    private int esforco_dor; 
    private String qual_esforco; 
    private int escala_eva; 
    private String inspecao_exame; 
    private String tonus_exame; 
    private String carac_exame; 
    private int qtd_sessoes;
    private String segunda; 
    private String quarta; 
    private String sexta; 
    private String hora_sessoes;
    private String data;
    private String status;
    private String[] inspecao;
    private String[] tonus;
    
    
    public int getIdpacientes() {
        return idpacientes;
    }

    public void setIdpacientes(int idpacientes) {
        this.idpacientes = idpacientes;
    }

    public int getNum_sus() {
        return num_sus;
    }

    public void setNum_sus(int num_sus) {
        this.num_sus = num_sus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(String dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }
    
        public String getDt_emissao() {
        return dt_emissao;
    }

    public void setDt_emissao(String dt_emissao) {
        this.dt_emissao = dt_emissao;
    }

    public String getOrg_emissor() {
        return org_emissor;
    }

    public void setOrg_emissor(String org_emissor) {
        this.org_emissor = org_emissor;
    }

    public String getNome_pai() {
        return nome_pai;
    }

    public void setNome_pai(String nome_pai) {
        this.nome_pai = nome_pai;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getRaca_cor() {
        return raca_cor;
    }

    public void setRaca_cor(String raca_cor) {
        this.raca_cor = raca_cor;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero_casa() {
        return numero_casa;
    }

    public void setNumero_casa(int numero_casa) {
        this.numero_casa = numero_casa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDiag_clinico() {
        return diag_clinico;
    }

    public void setDiag_clinico(String diag_clinico) {
        this.diag_clinico = diag_clinico;
    }

    public String getDiag_fiso() {
        return diag_fiso;
    }

    public void setDiag_fiso(String diag_fiso) {
        this.diag_fiso = diag_fiso;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public String getHma() {
        return hma;
    }

    public void setHma(String hma) {
        this.hma = hma;
    }

    public String getHmp() {
        return hmp;
    }

    public void setHmp(String hmp) {
        this.hmp = hmp;
    }

    public String getAnt_hereditario() {
        return ant_hereditario;
    }

    public void setAnt_hereditario(String ant_hereditario) {
        this.ant_hereditario = ant_hereditario;
    }

    public int getAlg_cirurgia() {
        return alg_cirurgia;
    }

    public void setAlg_cirurgia(int alg_cirurgia) {
        this.alg_cirurgia = alg_cirurgia;
    }

    public String getQual_cirurgia() {
        return qual_cirurgia;
    }

    public void setQual_cirurgia(String qual_cirurgia) {
        this.qual_cirurgia = qual_cirurgia;
    }

    public int getTabagista() {
        return tabagista;
    }

    public void setTabagista(int tabagista) {
        this.tabagista = tabagista;
    }

    public String getNum_cigarros() {
        return num_cigarros;
    }

    public void setNum_cigarros(String num_cigarros) {
        this.num_cigarros = num_cigarros;
    }

    public int getEtilista() {
        return etilista;
    }

    public void setEtilista(int etilista) {
        this.etilista = etilista;
    }

    public String getQtd_etilista() {
        return qtd_etilista;
    }

    public void setQtd_etilista(String qtd_etilista) {
        this.qtd_etilista = qtd_etilista;
    }

    public int getSedentario() {
        return sedentario;
    }

    public void setSedentario(int sedentario) {
        this.sedentario = sedentario;
    }

    public String getFreq_sendentario() {
        return freq_sendentario;
    }

    public void setFreq_sendentario(String freq_sendentario) {
        this.freq_sendentario = freq_sendentario;
    }

    public int getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(int medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getQuais_medicamentos() {
        return quais_medicamentos;
    }

    public void setQuais_medicamentos(String quais_medicamentos) {
        this.quais_medicamentos = quais_medicamentos;
    }

    public String getInicio_sintoma() {
        return inicio_sintoma;
    }

    public void setInicio_sintoma(String inicio_sintoma) {
        this.inicio_sintoma = inicio_sintoma;
    }

    public String getMecanismo_sintoma() {
        return mecanismo_sintoma;
    }

    public void setMecanismo_sintoma(String mecanismo_sintoma) {
        this.mecanismo_sintoma = mecanismo_sintoma;
    }

    public int getAcomp_sintoma() {
        return acomp_sintoma;
    }

    public void setAcomp_sintoma(int acomp_sintoma) {
        this.acomp_sintoma = acomp_sintoma;
    }

    public String getQual_sintoma() {
        return qual_sintoma;
    }

    public void setQual_sintoma(String qual_sintoma) {
        this.qual_sintoma = qual_sintoma;
    }

    public String getLocalizacao_dor() {
        return localizacao_dor;
    }

    public void setLocalizacao_dor(String localizacao_dor) {
        this.localizacao_dor = localizacao_dor;
    }

    public String getCarater_dor() {
        return carater_dor;
    }

    public void setCarater_dor(String carater_dor) {
        this.carater_dor = carater_dor;
    }

    public String getIrradiacao_dor() {
        return irradiacao_dor;
    }

    public void setIrradiacao_dor(String irradiacao_dor) {
        this.irradiacao_dor = irradiacao_dor;
    }

    public String getLocal_dor() {
        return local_dor;
    }

    public void setLocal_dor(String local_dor) {
        this.local_dor = local_dor;
    }

    public int getMovimento_dor() {
        return movimento_dor;
    }

    public void setMovimento_dor(int movimento_dor) {
        this.movimento_dor = movimento_dor;
    }

    public String getQual_dor() {
        return qual_dor;
    }

    public void setQual_dor(String qual_dor) {
        this.qual_dor = qual_dor;
    }

    public int getRepouso_dor() {
        return repouso_dor;
    }

    public void setRepouso_dor(int repouso_dor) {
        this.repouso_dor = repouso_dor;
    }

    public int getClimatica_dor() {
        return climatica_dor;
    }

    public void setClimatica_dor(int climatica_dor) {
        this.climatica_dor = climatica_dor;
    }

    public int getEsforco_dor() {
        return esforco_dor;
    }

    public void setEsforco_dor(int esforco_dor) {
        this.esforco_dor = esforco_dor;
    }

    public String getQual_esforco() {
        return qual_esforco;
    }

    public void setQual_esforco(String qual_esforco) {
        this.qual_esforco = qual_esforco;
    }

    public int getEscala_eva() {
        return escala_eva;
    }

    public void setEscala_eva(int escala_eva) {
        this.escala_eva = escala_eva;
    }

    public String getInspecao_exame() {
        return inspecao_exame;
    }

    public void setInspecao_exame(String inspecao_exame) {
        this.inspecao_exame = inspecao_exame;
        this.inspecao = inspecao_exame.split(";");
    }

    public String getTonus_exame() {
        return tonus_exame;
    }

    public void setTonus_exame(String tonus_exame) {
        this.tonus_exame = tonus_exame;
        this.tonus = tonus_exame.split(";");
    }

    public String getCarac_exame() {
        return carac_exame;
    }

    public void setCarac_exame(String carac_exame) {
        this.carac_exame = carac_exame;
    }
    
    public int getQtd_sessoes() {
        return qtd_sessoes;
    }

    public void setQtd_sessoes(int qtd_sessoes) {
        this.qtd_sessoes = qtd_sessoes;
    }

    public String getSegunda() {
        return segunda;
    }

    public void setSegunda(String segunda) {
        this.segunda = segunda;
    }

    public String getQuarta() {
        return quarta;
    }

    public void setQuarta(String quarta) {
        this.quarta = quarta;
    }

    public String getSexta() {
        return sexta;
    }

    public void setSexta(String sexta) {
        this.sexta = sexta;
    }

    public String getHora_sessoes() {
        return hora_sessoes;
    }

    public void setHora_sessoes(String hora_sessoes) {
        this.hora_sessoes = hora_sessoes;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getInspecao() {
        return inspecao;
    }

    public void setInspecao(String[] inspecao) {
        this.inspecao = inspecao;
    }

    public String[] getTonus() {
        return tonus;
    }

    public void setTonus(String[] tonus) {
        this.tonus = tonus;
    }
    
    
       
}