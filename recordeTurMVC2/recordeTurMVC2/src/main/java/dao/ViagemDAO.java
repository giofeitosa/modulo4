package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import connection.ConnectionMySQL;

import model.Viagem;

public class ViagemDAO {
	
public void save(Viagem viagem) {
		
		String sql = "INSERT INTO viagem(destino, descricao, preco)"
		+ " VALUES( ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			

			pstm.setString(1, viagem.getDestino());
			pstm.setString(2, viagem.getDescricao());
			pstm.setDouble(3, viagem.getPreco());
			
			
			
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
	
	public List<Viagem> read(){
		System.out.println("read");
		List<Viagem>  viagens = new ArrayList<Viagem>();
		String sql = "select * from viagem";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Viagem viagem = new Viagem();
				
				

				viagem.setId_viagem(rset.getInt("id_viagem"));
				viagem.setDestino(rset.getString("destino"));
				viagem.setDescricao(rset.getString("descricao"));
				viagem.setPreco(rset.getDouble("preco"));
				

				viagens.add(viagem);
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
		
			return viagens;
	
	}
	
	// update
	
	public void update(Viagem viagem) {
		
		System.out.println("read");
		
		String sql = "UPDATE viagem SET destino = ?, descricao = ?, preco = ?, WHERE id_viagem = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, viagem.getDestino());
			pstm.setString(2, viagem.getDescricao());
			pstm.setDouble(3, viagem.getPreco());
			

			pstm.setInt(4, viagem.getId_viagem());
			
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
	
	public void delete(int id_viagem) {
		
	
		String sql = "DELETE FROM viagem WHERE id_viagem = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id_viagem);
			
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
	
	public Viagem readById(int id_viagem) {
		
		Viagem viagem = new Viagem();
		String sql = "select * from viagem WHERE id_viagem = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id_viagem);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			viagem.setId_viagem(rset.getInt("id_viagem"));
			viagem.setDestino(rset.getString("destino"));
			viagem.setDescricao(rset.getString("descricao"));
			viagem.setPreco(rset.getDouble("preco"));
			
			
			
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
		return viagem;
	
		}

	


}
