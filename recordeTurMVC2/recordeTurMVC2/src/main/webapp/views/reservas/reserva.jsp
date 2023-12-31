<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="logotipo" href="../../assets/img/recordetur_logo.png"
	type="image/png" />
<link rel="stylesheet" href="../../assets/css/style.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<title>RecordeTur | Criar Reserva</title>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-lg  fixed-top bg">
			<div id="nav-container" class="container-fluid col-11 me-auto">
				<a class="navbar-brand" id="logotipo" href=""><img
					src="/recordeTurMVC2/src/main/webapp/assets/img/recordetur_logo.png"
					alt="logotipo"></a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class=" collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="INDEX.HTML">Home</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page"
							href="/recordeTurMVC2/src/main/webapp/views/clientes/cliente.jsp">Clientes</a>
						</li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page"
							href="/recordeTurMVC2/src/main/webapp/views/viagens/viagem.jsp">Viagens</a>
						</li>
						<li class="nav-item"><a class="nav-link"
							href="/recordeTurMVC2/src/main/webapp/views/reservas/reserva.jsp">Reservas</a>
						</li>
						<li></li>
					</ul>


				</div>
			</div>
		</nav>
	</header>

	<main>
		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Reservas</th>
						<th scope="col">Código</th>
						<th scope="col">Data</th>
						<th scope="col">Destino</th>
						<th scope="col">Cliente</th>
						<th scope="col">Ações</th>
					</tr>
				</thead>

				<tbody>
					<jstl:forEach items="${reserva}" var="r">
					


						<tr>
							<td>${r.id_reserva}</td>
							<td>${r.data_reserva}</td>
							<td>${r.viagem}</td>
							<td>${r.cliente}</td>


							<td><a href="cliente-edit?id=${r.id_reserva}"
								class="btn btn-primary mb-1">Editar</a> <a
								href="cliente-delete?id=${r.id_reserva}"
								onclick="return confirm('Deseja excluir ${r.id_reserva}?')"
								class="btn btn-danger mb-1">Excluir</a></td>

						</tr>
					</jstl:forEach>

				</tbody>
			</table>
		</div>
	</main>
	<footer>
		<div class="container">
			<div class="row " id="contact-area">
				<div class="col-md-12 d-flex">
					<div class="col-md-4 contact-box">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-whatsapp" viewBox="0 0 16 16">
              <path
								d="M13.601 2.326A7.854 7.854 0 0 0 7.994 0C3.627 0 .068 3.558.064 7.926c0 1.399.366 2.76 1.057 3.965L0 16l4.204-1.102a7.933 7.933 0 0 0 3.79.965h.004c4.368 0 7.926-3.558 7.93-7.93A7.898 7.898 0 0 0 13.6 2.326zM7.994 14.521a6.573 6.573 0 0 1-3.356-.92l-.24-.144-2.494.654.666-2.433-.156-.251a6.56 6.56 0 0 1-1.007-3.505c0-3.626 2.957-6.584 6.591-6.584a6.56 6.56 0 0 1 4.66 1.931 6.557 6.557 0 0 1 1.928 4.66c-.004 3.639-2.961 6.592-6.592 6.592zm3.615-4.934c-.197-.099-1.17-.578-1.353-.646-.182-.065-.315-.099-.445.099-.133.197-.513.646-.627.775-.114.133-.232.148-.43.05-.197-.1-.836-.308-1.592-.985-.59-.525-.985-1.175-1.103-1.372-.114-.198-.011-.304.088-.403.087-.088.197-.232.296-.346.1-.114.133-.198.198-.33.065-.134.034-.248-.015-.347-.05-.099-.445-1.076-.612-1.47-.16-.389-.323-.335-.445-.34-.114-.007-.247-.007-.38-.007a.729.729 0 0 0-.529.247c-.182.198-.691.677-.691 1.654 0 .977.71 1.916.81 2.049.098.133 1.394 2.132 3.383 2.992.47.205.84.326 1.129.418.475.152.904.129 1.246.08.38-.058 1.171-.48 1.338-.943.164-.464.164-.86.114-.943-.049-.084-.182-.133-.38-.232z" />
            </svg>
						<p>
							<span class="contact-title">Tel:</span> 81 99999-8888
						</p>
					</div>
					<div class="col-md-4 contact-box">
						<i class="bi bi-whatsapp"></i>
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-instagram" viewBox="0 0 16 16">
              <path
								d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z" />
            </svg>
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
              <path
								d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z" />
            </svg>
						<p>contato@recordetur.com</p>
					</div>
					<div class="col-md-4 contact-box " id="adress">
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-geo-alt-fill"
							viewBox="0 0 16 16">
              <path
								d="M8 16s6-5.686 6-10A6 6 0 0 0 2 6c0 4.314 6 10 6 10zm0-7a3 3 0 1 1 0-6 3 3 0 0 1 0 6z" />
            </svg>
						<p>
							rua do riacho - 1020 <br> Recife - PE/Brasil
						</p>
					</div>
				</div>
				<div id="copy-area">
					<div class="container">
						<div class="row">
							<div class="col-md-12">
								<p>
									Desenvolvido por <a href="">Recorde.tur</a> &copy; 2023
								</p>
							</div>
						</div>
					</div>
				</div>

			</div>
	</footer>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>

</body>
</html>