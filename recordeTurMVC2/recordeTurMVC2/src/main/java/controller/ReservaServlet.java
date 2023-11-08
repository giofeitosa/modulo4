package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.ReservaDAO;
import dao.ViagemDAO;
import model.Cliente;
import model.Reserva;
import model.Viagem;

@WebServlet(urlPatterns = { "/reserva", "/reserva-save", "/reserva-delete", "/reserva-edit" })
public class ReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ReservaDAO rdao = new ReservaDAO();
	Cliente cliente = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    ViagemDAO vdao = new ViagemDAO();
    Viagem viagem = new Viagem();

	public ReservaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List <Viagem> viagens = vdao.read();
		request.setAttribute("listaViagens", viagens);
		List <Cliente> clientes = cdao.read();
		request.setAttribute("listaClientes", clientes);

		String route = request.getServletPath();
		switch (route) {
		case "/reserva":
			read(request, response);
			break;
		case "/reserva-save":
			save(request, response);
			break;
		case "/reserva-delete":
			delete(request, response);
			break;
		case "/reserva-edit":
			edit(request, response);
			break;
		
		default:

			break;
		}

	}

	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Reserva reserva = new Reserva();

		int idcliente = Integer.parseInt(request.getParameter("cliente"));
		int iddestino = Integer.parseInt(request.getParameter("viagem"));
		reserva.setCliente(rdao.readById(idcliente));
		reserva.setViagem(rdao.readById(iddestino));

		reserva.setData_reserva(request.getParameter("data_reserva"));
		reserva.setValor_reserva(Double.parseDouble(request.getParameter("valor_reserva")));

		if (request.getParameter("id_reserva") != null) {
			reserva.setId_reserva(Integer.parseInt(request.getParameter("id_reserva")));
			rdao.update(reserva);

		} else {
			rdao.save(reserva);
		}
		response.sendRedirect("reserva");
	}

	protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Reserva> reservas = rdao.read();
		request.setAttribute("reservas", reservas);
		RequestDispatcher rd = request.getRequestDispatcher("./views/reservas/reserva.jsp");
		rd.forward(request, response);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id_reserva"));
		rdao.delete(id);
		response.sendRedirect("reserva");
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_reserva"));

		Reserva reserva = rdao.readById(id);

		request.setAttribute("reserva", reserva);

		RequestDispatcher rd = request.getRequestDispatcher("./reserva.jsp");
		rd.forward(request, response);

	}

	

}
