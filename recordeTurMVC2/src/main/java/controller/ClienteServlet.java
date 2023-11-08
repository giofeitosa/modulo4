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
import model.Cliente;


@WebServlet(urlPatterns = {"/cliente", "/cliente-save", "/cliente-delete", "/cliente-edit", "/cliente-update"})
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	ClienteDAO cdao = new ClienteDAO();

    public ClienteServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String route = request.getServletPath();
        switch (route) {
        case "/cliente":
            read(request,response);
            break;
        case "/cliente-save":
            save(request,response);
            break;
        case "/cliente-delete":
            delete(request,response);
            break;
       case "/cliente-edit":
			edit(request, response);
			break;
		case "/cliente-update":
			update(request, response);
			break;
        default:

            break;
        }

    }
 
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cliente cliente = new Cliente();
        cliente.setId_cliente(Integer.parseInt(request.getParameter("id_cliente")));
        cliente.setCpf(request.getParameter("cpf"));
		cliente.setNome_cliente(request.getParameter("nome_cliente"));
		cliente.setEmail_cliente(request.getParameter("email_cliente"));
		cliente.setTelefone_cliente(request.getParameter("telefone_cliente"));
        
        if(request.getParameter("id_cliente")!=null){
        	 cliente.setId_cliente(Integer.parseInt(request.getParameter("id_cliente")));
            cdao.update(cliente);

        }else {
            cdao.save(cliente);
        }
        response.sendRedirect("cliente");
    }
    protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Cliente>clientes = cdao.read();
        request.setAttribute("clientes", clientes);
        RequestDispatcher rd=request.getRequestDispatcher("./views/clientes/cliente.jsp");
        rd.forward(request, response);
        }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id_cliente"));
        cdao.delete(id);
        response.sendRedirect("cliente");
    }


	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_cliente"));
		
		Cliente cliente = cdao.readById(id);
		
		request.setAttribute("cliente", cliente);

		RequestDispatcher rd = request.getRequestDispatcher("./views/clientes/editCliente.jsp");
		rd.forward(request, response);
	
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Cliente cliente = null;
		cliente.setId_cliente(Integer.parseInt(request.getParameter("id_cliente")));
		cliente.setNome_cliente(request.getParameter("nome_cliente"));
		cliente.setEmail_cliente(request.getParameter("email_cliente"));
		cliente.setTelefone_cliente(request.getParameter("telefone_cliente"));
		cliente.setCpf(request.getParameter("cpf"));
		
		cdao.update(cliente);
		response.sendRedirect("cliente");
	}
	
	}
