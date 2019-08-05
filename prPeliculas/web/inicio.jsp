<%-- 
    Document   : inicio
    Created on : 06-16-2019, 05:08:50 PM
    Author     : Ulises Alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="ja/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/all.js"></script>
    </head>
    <body>

        

        <div class="container-fluid text-center">

            <div class="row justify-content-center">
                <h2 class="display-4 text-dark mt-3">prPeliculas.free</h2>
                <img src="img/logo22.png">
            </div>
            <p class="text-info">
                ¡Tu sitio web favorito donde encontraras variedad de peliculas de todo genero,<br>
                encontraras peliculas de buena calidad y las ultimas peliculas en estreno!
            </p>

        </div>

        <nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top mt-auto">
            <a class="navbar-brand" href="inicio.jsp">
                prPeliculas.free
            </a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="inicio.jsp">Inicio<i class="fas fa-home ml-1"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="control?action=clientes">Clientes<i class="fas fa-users ml-1"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="control?action=peliculas">Peliculas<i class="fas fa-compact-disc ml-1"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="control?action=historial">Historial<i class="fas fa-clipboard-list ml-1"></i></a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container mt-3 mb-3">
            <div class="card-deck">
                <div class="card border-primary">
                    <div class="card-header bg-transparent border-primary">
                        <h4>Cartera de Clientes</h4>
                    </div>
                    <div class="card-body">
                        <p>
                            Agregar nuevo cliente,
                            Ver listado de Clientes,
                            Actualizar datos de Clientes,
                            Eliminar Cliente inactivo.
                        </p>
                    </div>
                    <div class="card-footer bg-transparent border-primary">
                        <a class="btn btn-primary btn-sm" href="control?action=clientes">
                            Click Aqui
                        </a>
                    </div>
                </div>

                <div class="card border border-success">
                    <div class="card-header bg-transparent border-success">
                        <h4>Listado de Peliculas</h4>
                    </div>
                    <div class="card-body">
                        <p>
                            Peliculas disponibles,
                            Informacion de peliculas,
                            Añadir nueva pelicula,
                            Actualizar datos de peliculas,
                            Eliminar peliculas.
                        </p>
                    </div>
                    <div class="card-footer bg-transparent border-success">
                        <a class="btn btn-success btn-sm" href="control?action=peliculas">
                            Click aqui
                        </a>
                    </div>
                </div>
            </div>

            <div class="card-deck mt-3">
                <div class="card border border-danger">
                    <div class="card-header bg-transparent border-danger">
                        <h4>Alquilar Pelicula</h4>
                    </div>
                    <div class="card-body">
                        <p>
                            Aqui encontraras el listado de nuestras peliculas,
                            aqui podras seleccionar la pelicula que quieres alquilar.
                        </p>
                    </div>
                    <div class="card-footer bg-transparent border-danger">
                        <a class="btn btn-danger btn-sm" href="control?action=alquilar">
                            Click Aqui
                        </a>
                    </div>
                </div>

                <div class="card border border-warning">
                    <div class="card-header bg-transparent border-warning">
                        <h4>Historial Préstamos</h4>
                    </div>
                    <div class="card-body">
                        <p>
                            Aqui podras ver el historial de préstamos de los
                            clientes activos.
                            Actualizar estado de préstamos.
                        </p>
                    </div>
                    <div class="card-footer bg-transparent border-warning">
                        <a class="btn btn-warning btn-sm" href="control?action=historial">
                            Click Aqui
                        </a>
                    </div>
                </div>

            </div>
        </div>        
    </body>
</html>
