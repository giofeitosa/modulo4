package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Cliente;
import model.Reserva;
import model.Viagem;

public class ReservaDAO {

	public void save(Reserva reserva) {

		String sql = "INSERT INTO reserva(data_reserva, valor_reserva, id_cliente, id_viagem)" + " VALUES( ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, reserva.getData_reserva());
			pstm.setDouble(2, reserva.getValor_reserva());
			pstm.setInt(3, reserva.getCliente().getId_cliente());
			pstm.setInt(4, reserva.getViagem().getId_viagem());

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

	// read

	public List<Reserva> read() {

		List<Reserva> reservas = new ArrayList<Reserva>();
		String sql = "select * from cliente_viagem order by id_reserva";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				Reserva reserva = new Reserva();
				Cliente cliente = new Cliente();
				Viagem viagem = new Viagem();

				reserva.setId_reserva(rset.getInt("id_reserva"));
				reserva.setData_reserva(rset.getString("data_reserva"));
				reserva.setValor_reserva(rset.getDouble("valor_reserva"));

				viagem.setId_viagem(rset.getInt("id_viagem"));
				viagem.setDestino(rset.getString("destino"));
				viagem.setDescricao(rset.getString("descricao"));
				viagem.setPreco(rset.getDouble("preco"));

				cliente.setId_cliente(rset.getInt("id_cliente"));
				cliente.setCpf(rset.getString("cpf"));
				cliente.setNome_cliente(rset.getString("nome_cliente"));
				cliente.setEmail_cliente(rset.getString("email_cliente"));
				cliente.setTelefone_cliente(rset.getString("telefone_cliente"));

				reserva.setCliente(cliente);
				reserva.setViagem(viagem);

				reservas.add(reserva);
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

		return reservas;

	}

	// update

	public void update(Reserva reserva) {
		String sql = "UPDATE reserva SET data_reserva = ?, valor_reserva = ?,  id_cliente = ?, id_viagem = ? WHERE id_reserva = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, reserva.getData_reserva());
			pstm.setDouble(2, reserva.getValor_reserva());
			pstm.setInt(3, reserva.getCliente().getId_cliente());
			pstm.setInt(4, reserva.getViagem().getId_viagem());
			pstm.setInt(5, reserva.getId_reserva());

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

	public void delete(int id_reserva) {

		String sql = "DELETE FROM reserva WHERE id_reserva = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id_reserva);

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

	// redabyId

	public Reserva readById(int id_reserva) {

		Reserva reserva = new Reserva();
		String sql = "select * from viagem_cliente WHERE id_reserva = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {

			conn = ConnectionMySQL.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id_reserva);

			rset = pstm.executeQuery();

			rset.next();

			Cliente cliente = new Cliente();
			Viagem viagem = new Viagem();

			reserva.setId_reserva(rset.getInt("id_reserva"));
			reserva.setData_reserva(rset.getString("data_reserva"));
			reserva.setValor_reserva(rset.getDouble("valor_reserva"));

			viagem.setId_viagem(rset.getInt("id_viagem"));
			viagem.setDestino(rset.getString("destino"));
			viagem.setDescricao(rset.getString("descricao"));
			viagem.setPreco(rset.getDouble("preco"));

			cliente.setId_cliente(rset.getInt("id_cliente"));
			cliente.setCpf(rset.getString("cpf"));
			cliente.setNome_cliente(rset.getString("nome_cliente"));
			cliente.setEmail_cliente(rset.getString("email_cliente"));
			cliente.setTelefone_cliente(rset.getString("telefone_cliente"));

			reserva.setCliente(cliente);
			reserva.setViagem(viagem);

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
		return reserva;
	}

}
