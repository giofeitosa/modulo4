package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.util.List;

import connection.ConnectionMySQL;
import model.Cliente;

//create

public class ClienteDAO {
	public void save(Cliente cliente) {
		
		String sql = "INSERT INTO cliente(cpf, nome_cliente,email_cliente, telefone_cliente)"
		+ " VALUES( ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			

			pstm.setString(1, cliente.getCpf());
			pstm.setString(2, cliente.getNome_cliente());
			pstm.setString(3, cliente.getEmail_cliente());
			pstm.setString(4, cliente.getTelefone_cliente());
			
			
			pstm.execute();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			
			try {
			if (pstm != null) {
				pstm.close();
				
			}
			
			if (conn != null) {
				conn.close();
				
			}
			
			}catch (Exception e) {
				
				e.printStackTrace();
			}
			}
		}
	

	// read
	
	public List<Cliente> read(){
		System.out.println("read");
		List<Cliente>  clientes = new ArrayList<Cliente>();
		String sql = "select * from cliente";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Cliente cliente = new Cliente();
				
				

				cliente.setId_cliente(rset.getInt("id_cliente"));
				cliente.setCpf(rset.getString("cpf"));
				cliente.setNome_cliente(rset.getString("nome_cliente"));
				cliente.setEmail_cliente(rset.getString("email_cliente"));
				cliente.setTelefone_cliente(rset.getString("telefone_cliente"));

				clientes.add(cliente);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
			return clientes;
	
	}
	
	// update
	
	public void update(Cliente cliente) {
		
		
		String sql = "UPDATE cliente SET cpf = ?, nome_cliente = ?,"
				+ " email_cliente =?, telefone_cliente = ? WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getCpf());
			pstm.setString(2, cliente.getNome_cliente());
			pstm.setString(3, cliente.getEmail_cliente());
			pstm.setString(4, cliente.getTelefone_cliente());

			pstm.setInt(5, cliente.getId_cliente());
			
			pstm.execute();
				
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
			
	}
	
	// delete
	
	public void delete(int id_cliente) {
		
	
		String sql = "DELETE FROM cliente WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id_cliente);
			
			pstm.execute();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}	


		
	
	
	//redabyId
	
	public Cliente readById(int id_cliente) {
		
		Cliente cliente = new Cliente();
		String sql = "select * from cliente WHERE id_cliente = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id_cliente);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			cliente.setId_cliente(rset.getInt("id_cliente"));
			cliente.setCpf(rset.getString("cpf"));
			cliente.setNome_cliente(rset.getString("nome_cliente"));
			cliente.setEmail_cliente(rset.getString("email_cliente"));
			cliente.setTelefone_cliente(rset.getString("telefone_cliente"));
			
			} catch (Exception e) {
				e.printStackTrace();
				} finally {
					try {
						if (pstm != null) {
							pstm.close();
							}
						if (conn != null) {
							conn.close();
							}
						} catch (Exception e) {
							e.printStackTrace();
							}
					}
		return cliente;
		}
	}
	
		
	
	



