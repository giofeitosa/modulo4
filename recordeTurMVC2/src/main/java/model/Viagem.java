package model;


public class Viagem {
   private int id_viagem;
   private  String destino;
   private String descricao;
   private double preco;
  
   
   

    public Viagem() {
	
}
    

	public Viagem(String destino, String descricao, double preco) {
		super();
		this.destino = destino;
		this.descricao = descricao;
		this.preco = preco;
	}


	public Viagem(int id_viagem, String destino, String descrcao, Double preco, String descricao) {
        this.id_viagem = id_viagem;
        this.destino = destino;
        this.descricao = descricao;
        this.preco = preco;
       
    }

	
	
    public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Viagem(String destino, double preco) {
		
		this.destino = destino;
		this.preco = preco;
		
	}

	public int getId_viagem() {
        return id_viagem;
    }

    public void setId_viagem(int id_viagem) {
        this.id_viagem = id_viagem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

   
    

	@Override
	public String toString() {
		return "\n ===Viagem=== " +
	"\n identificador= " + id_viagem + 
	"\n destino= " + destino +
	"\n descricao= " + descricao + 
	"\n preco= " + preco;
	}
    
    
}
