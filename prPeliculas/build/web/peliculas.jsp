
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/all.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <a class="navbar-brand" href="inicio.jsp">prPeliculas.free</a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navpeli">
                <a class="navbar-toggler-icon"></a>
            </button>

            <div class="collapse navbar-collapse justify-content-end" id="navpeli">
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


        <h6 class="display-4 text-center text-info">Peliculas Disponibles</h6>
        <div class="card border-info mt-4 ml-2 mr-2 mb-3 mt-4">
            <div class="card-header bg-transparent border-info">
                <a class="btn btn-success" href="control?action=agregarP">Nuevo Registro<i class="fas fa-plus-square ml-3"></i></a>
            </div>
            <div class="card-body">
                <table class="table table-responsive table-hover text-center">
                    <thead class="bg-light">
                        <tr>
                            <td>Cod</td>
                            <td>Titulo</td>
                            <td>Sinopsis</td>                        
                            <td>Clasificación</td>
                            <td>Categoría</td>
                            <td>Año</td>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${mostrarP}" var="p">
                            <tr>
                                <td><c:out value="${p.id_pelicula}"/></td>
                                <td><c:out value="${p.nombre_pelicula}"/></td>
                                <td><c:out value="${p.sinopsis}"/></td>                                                              
                                <td><c:out value="${p.clasificacion.clasificacion}"/></td>
                                <td><c:out value="${p.categoria.categoria}"/></td>
                                <td><c:out value="${p.age_estreno}"/></td>
                                <td>
                                    <a class="btn btn-outline-danger btn-sm" href="control?action=eliminarP&id=<c:out value="${p.id_pelicula}"/>">
                                        <i class="fas fa-trash"></i>
                                    </a>                                    
                                    <a class="btn btn-outline-success btn-sm" href="control?action=actualizarP&id=<c:out value="${p.id_pelicula}"/>">
                                        <i class="fas fa-pen"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a class="btn btn-danger" href="control?action=alquilar">Alquilar una Película
                    <i class="fas fa-compact-disc"></i>
                </a>
            </div>
        </div>

    </body>
</html>
