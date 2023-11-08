package model;


public class Cliente {

	private int id_cliente;
	private String cpf;
    private String nome_cliente;
    private String email_cliente;
    private String telefone_cliente;
    
    

    
    public Cliente() {
	}

	public Cliente(int id_cliente, String cpf, String nome_cliente, String email_cliente, String telefone_cliente) {
        this.id_cliente = id_cliente ;
    	this.cpf = cpf;
        this.nome_cliente = nome_cliente;
        this.email_cliente = email_cliente;
        this.telefone_cliente = telefone_cliente;
              
    }
    
    

    public Cliente(String cpf, String nome_cliente, String email_cliente, String telefone_cliente) {
		this.cpf = cpf;
		this.nome_cliente = nome_cliente;
		this.email_cliente = email_cliente;
		this.telefone_cliente = telefone_cliente;
		
	}

	
	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getTelefone_cliente() {
        return telefone_cliente;
    }

    public void setTelefone_cliente(String telefone_cliente) {
        this.telefone_cliente = telefone_cliente;
    }

    

	@Override
	public String toString() {
		return "\n ====Cliente==== \n" + 
				" identificador=  " + id_cliente +  "\n" + 
				" cpf=  " + cpf + "\n" +
				" nome=  " + nome_cliente + "\n" + 
				" e-mail=  " + email_cliente + "\n"+
				" telefone=  " + telefone_cliente + "\n";
	}
    
     

}
