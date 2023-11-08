package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ViagemDAO;
import model.Viagem;


@WebServlet(urlPatterns = {"/viagem", "/viagem-save", "/viagem-delete", "/viagem-edit", "/viagem-update"})
public class ViagemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	ViagemDAO vdao = new ViagemDAO();

    public ViagemServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String route = request.getServletPath();
        switch (route) {
        case "/viagem":
            read(request,response);
            break;
        case "/viagem-save":
            save(request,response);
            break;
        case "/viagem-delete":
            delete(request,response);
            break;
       case "/viagem-edit":
			edit(request, response);
			break;
		case "/viagem-update":
			update(request, response);
			break;
        default:

            break;
        }

    }
 
    protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Viagem viagem = new Viagem();
        viagem.setDestino(request.getParameter("destino"));
        viagem.setDescricao(request.getParameter("descricao"));
        viagem.setPreco(request.getParameter("preco"));
        
        if(request.getParameter("id_viagem")!=null){
        	viagem.setId_viagem(Integer.parseInt(request.getParameter("id_viagem")));
            vdao.update(viagem);

        }else {
            vdao.save(viagem);
        }
        response.sendRedirect("viagem");
    }
    protected void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Viagem>viagens = vdao.read();
        request.setAttribute("viagens", viagens);
        RequestDispatcher rd=request.getRequestDispatcher("./create.jsp");
        rd.forward(request, response);
        }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id_viagem"));
        vdao.delete(id);
        response.sendRedirect("viagem");
    }


	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_viagem"));
		
		Viagem viagem = vdao.readById(id);
		
		request.setAttribute("viagem", viagem);

		RequestDispatcher rd = request.getRequestDispatcher("./create.jsp");
		rd.forward(request, response);
	
	}
	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Viagem viagem = new Viagem();
        viagem.setDestino(request.getParameter("destino"));
        viagem.setDescricao(request.getParameter("descricao"));
        viagem.setPreco(request.getParameter("preco"));
        
		vdao.update(viagem);
		response.sendRedirect("viagem");
	}
	
	}
