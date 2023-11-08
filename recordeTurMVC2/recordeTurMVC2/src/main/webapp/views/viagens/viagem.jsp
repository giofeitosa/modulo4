<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%-- <%@ page import="model.Cliente" %> --%>
<%-- <%@ page import="java.util.List" %> --%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Bootstrap demo</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
  <link rel="stylesheet" href="../exe.MOD2/ag.css">
    <style>

main {
    background-color:rgba(218, 213, 221, 0.897) ;
}

h1{
    margin-top: 10px;
   
}
h5{
    margin-top: 20px;

}
h4{
    margin-top: 50px;
}
.text{
    text-align: center;
    margin-bottom: 2%;
    
}

.form-container {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 5%; 
        }
        
        .form-section {
            flex: 1;
            padding: 30px;
        }

        .middle-divider {
            height: 100%;
            margin: 1 10px;
        }



    footer {
      background-color: rgb(63, 63, 63);
      padding: 10px;
    }

    .footer-info {
      display: flex;
      justify-content: space-between;
    }

    .contact-info {
      color: white;
      font-size: medium;
     }

    .end-info {
      color: white;
      font-size: medium;
    }
    
    .footer-text {
      text-align: center;
      color: white;

    }

    .img-footer {
      width: 250px;
    }
  
    .insta {
      background: radial-gradient(circle at 30% 107%, #fdf497 0%, #fdf497 5%, #fd5949 45%, #d6249f 60%, #285AEB 90%);
      -webkit-background-clip: text;

      background-clip: text;
      -webkit-text-fill-color: transparent;
      cursor: pointer;
    }

    .face {
      color: #3B5998;
      cursor: pointer;
    }

    .tw {
      color: #00acee;
      cursor: pointer;
    }

    .mess {
      color: #3B5998;
      cursor: pointer;

    }

    .whats {
      color: rgb(50, 192, 14);
      cursor: pointer;
    }


    @media screen and (max-width:600px) {
      footer .footer-info {
        display: flex;
        flex-direction: column;

      }
    }
    /*fim footer */ 

    </style>
  </head>
<body>
<nav class="navbar">
    <div class="container-fluid">
      <h1> Bora Agora?</h1>
      <a class="navbar-brand" href="#">Deixa conosco o planejamento!</a>

      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a href="index.html" class="nav-link active" aria-current="page">Home</a>
          </li>
          <li class="nav-item">
            <a href="promocao.html" class="nav-link" aria-current="page">Promoções</a>
          </li>
          <li class="nav-item">
            <a href="destino.html" class="nav-link" aria-current="page">Destinos</a>
          </li>
          <li class="nav-item">
            <a href="contato.html" class="nav-link" aria-current="page">Contato</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Login
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="entrar.html">Entrar</a></li>
              <li><a class="dropdown-item" href="cadastro.html">Cadastre-se</a></li>
             </ul>
          </li>
    </ul>
        
        <form class="d-flex" role="search">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success" type="submit">Pesquisar</button>
        </form>
      </div>
    </div>
  </nav>
 <div class= "container">
 
 <table class="table">
                  <thead>
                    <tr>
                    <th scope="col">Id Viagem</th>
                      <th scope="col">Destino</th>
                      <th scope="col">Descrição</th>
                      <th scope="col">Valor</th>
                      <th scope="col">Ações</th>
                    </tr>
                  </thead>
                  <tbody>
                     <jstl:forEach items="${viagem}" var="d"> 


                    <tr>
                        <td>${d.id_viagem}</td>
                        <td>${d.destino}</td>
                        <td>${d.descricao}</td>
                        <td>${d.preco}</td>

                        <td>
                            <a href="destinos-edit?id=${d.id_viagem}" class="btn btn-primary mb-1" >Editar</a>

                            <a href="destinos-delete?id=${d.id_viagem}" onclick="return confirm('Deseja excluir ${d.destino}?')" class="btn btn-danger mb-1">Excluir</a>
                        </td>

                    </tr>
                </jstl:forEach> 
               
                  </tbody>
                </table>
                
      </div>           
  
<footer>
    <div class="footer-info">
      <div class="contact-info">

        <h5>Telefone para contato</h5>
        </p>
        <p> (11) 3452-0777 </p>
        <p> (11) 96378-3952</p>
      </div>
      <div class="end-info">
        <h5>Endereço</h5>
        <p>Rua Tupinambá, 125 - Bairro Jaguaré</p>
        <p> São Paulo - SP</p>
      </div>
      <div class="social-media text-white">
        <h5> Nossas mídias sociais</h5>
        <i class="bi bi-instagram insta fs-4" onclick="window.open('https://www.instagram.com/', '_blank')"></i>
        <i class="bi bi-facebook face fs-4" onclick="window.open('https://www.facebook.com/', '_blank')"></i>
        <i class="bi bi-twitter tw fs-4" onclick="window.open('https://www.twitter.com/', '_blank')"></i>
        <i class="bi bi-messenger mess fs-4" onclick="window.open('https://www.messenger.com/', '_blank')"></i>
        <i class="bi bi-whatsapp whats fs-4 " onclick="window.open('https://web.whatsapp.com/', '_blank')"></i>
      </div>
    </div>
    <div class="footer-text">
      <p>&copy; 2023 Agência de Viagens. Todos os direitos reservados.</p>
      <img class="img-footer" src="footer3.png" alt="Bandeiras Cartoes">
    </div>
  </footer>


  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
    crossorigin="anonymous"></script>
</body>
</html>