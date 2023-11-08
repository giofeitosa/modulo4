package model;

public class Reserva {

    private int id_reserva;
    private String data_reserva;
    private Double valor_reserva;
    private Cliente cliente;
    private Viagem viagem;
    
    

    public Reserva() {
	}

	public Reserva(int id_reserva,String data_reserva, Double valor_reserva,  Cliente cliente, Viagem viagem) {
        this.id_reserva = id_reserva;
        this.data_reserva = data_reserva;
        this.valor_reserva = valor_reserva;
        this.cliente = cliente;
        this.viagem = viagem;
    }
	
	
    public Reserva( String data_reserva,Double valor_reserva, Cliente cliente, Viagem viagem) {
	
    	this.data_reserva = data_reserva;
		this.valor_reserva = valor_reserva;
		this.cliente = cliente;
		this.viagem = viagem;
	}

    
	public String getData_reserva() {
		return data_reserva;
	}

	public void setData_reserva(String data_reserva) {
		this.data_reserva = data_reserva;
	}

	public int getId_reserva() {
        return id_reserva;
    }
	

    public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}


    public Double getValor_reserva() {
        return valor_reserva;
    }

    public void setValor_reserva(Double valor_reserva) {
        this.valor_reserva = valor_reserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

	@Override
	public String toString() {
		return " ====Reserva====\n" 
				+ " Código da reserva= " + id_reserva
				+ "\n Data da reserva = " + data_reserva
				+ "\n valor_reserva=" + valor_reserva + "\n"
				+ cliente.toString() 
				+ viagem.toString();
	}
	
	
    
    
}
