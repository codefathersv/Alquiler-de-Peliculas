<%-- 
    Document   : historial
    Created on : 06-19-2019, 11:01:09 PM
    Author     : Ulises Alexis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link href="css/alertify.css">
        <link href="css/default.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/all.js"></script>
        <script src="js/alertify.js"></script>

    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <a class="navbar-brand" href="inicio.jsp">prPeliculas.free</a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navClie">
                <a class="navbar-toggler-icon"></a>
            </button>

            <div class="collapse navbar-collapse justify-content-end" id="navClie">
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

        <div class="card border-dark ml-2 mr-2 mt-3">
            <div class="card-header bg-transparent text-center border-dark">
                <h4>Historial de Préstamos</h4>
                <p>Registros y estados de alquiler.</p>
            </div>
            <div class="card-body">
                <table class="table table-responsive-md table-striped table-hover text-center">
                    <thead class="bg-danger text-white">
                        <tr>
                            <td>Cod</td>
                            <td>Título de Película</td>
                            <td>Cliente</td>
                            <td>Descripción</td>
                            <td>Fecha Contrato</td>
                            <td>Fecha Entrega</td>
                            <td>Costo</td>
                            <td>Estado</td>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${alquiler}" var="a">
                            <tr>
                                <td><c:out value="${a.id_alquiler}"/></td>
                                <td><c:out value="${a.pelicula.nombre_pelicula}"/></td>
                                <td><c:out value="${a.cliente.nombre_cliente}"/> <c:out value="${a.cliente.apellido_cliente}"/></td>
                                <td><c:out value="${a.descripcion}"/></td>
                                <td><c:out value="${a.fecha_alquiler}"/></td>
                                <td><c:out value="${a.fecha_entrega}"/></td>
                                <td>$ <c:out value="${a.costo}"/></td>
                                <td class="bg-warning"><c:out value="${a.estado.estado}"/></td>
                                <td>
                                    <a class="btn btn-outline-danger btn-sm" href="control?action=eliminarH&id=<c:out value="${a.id_alquiler}"/>">
                                        <i class="fas fa-trash-alt"></i>
                                    </a>
                                    <a class="btn btn-outline-success btn-sm ml-1" href="control?action=actualizarH&id=<c:out value="${a.id_alquiler}"/>">
                                        <i class="fas fa-pen"></i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <a class="btn btn-danger" href="control?action=alquilar">Alquilar Nueva Pelicula
                    <i class="fas fa-compact-disc"></i>
                </a>
            </div>
        </div>
    </body>
</html>
