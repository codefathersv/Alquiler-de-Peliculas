<%-- 
    Document   : clientes
    Created on : 06-17-2019, 11:05:15 AM
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
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/all.js"></script>
    </head>
    <body>
        
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <a class="navbar-brand" href="inicio.jsp">
                prPeliculas.free
            </a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarcollapse">
                <a class="navbar-toggler-icon"></a>
            </button>

            <div class="collapse navbar-collapse justify-content-end" id="navbarcollapse">
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
            <h6 class="display-4 text-center text-info">Cartera de Clientes</h6>
            <div class="card border border-info mt-4">
                <div class="card-header bg-transparent border-info">
                    <a class="btn btn-success" href="control?action=agregarC">
                        Nuevo Cliente
                        <i class="fas fa-plus-square ml-3"></i>
                    </a>
                </div>
                
                <div class="card-body">
                    <table class="table table-responsive-md table-hover text-center">
                        <thead class="bg-light">
                            <tr>
                                <td>Cod</td>
                                <td>Nombres</td>
                                <td>Apellidos</td>
                                <td>Dirección</td>
                                <td>Correo Electrónico</td>
                                <td>Teléfono</td>
                                <td></td>
                            </tr>                            
                        </thead>
                        <c:forEach items="${mostrarC}" var="mc">
                            <tbody>
                                <tr>
                                    <td><c:out value="${mc.id_cliente}"/></td>
                                    <td><c:out value="${mc.nombre_cliente}"/></td>
                                    <td><c:out value="${mc.apellido_cliente}"/></td>
                                    <td><c:out value="${mc.direccion}"/></td>
                                    <td><c:out value="${mc.correo}"/></td>
                                    <td><c:out value="${mc.num_celular}"/></td>
                                    <td>
                                        <a class="btn btn-outline-danger btn-sm" href="control?action=eliminar&id=<c:out value="${mc.id_cliente}"/>">
                                            <i class="fas fa-user-slash"></i>
                                        </a>
                                        <a class="btn btn-outline-success btn-sm" href="control?action=actualizar&id=<c:out value="${mc.id_cliente}"/>">
                                            <i class="fas fa-user-edit"></i>
                                        </a>
                                    </td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
