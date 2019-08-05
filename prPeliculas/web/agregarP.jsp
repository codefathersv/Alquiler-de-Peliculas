<%-- 
    Document   : agregarP
    Created on : 06-19-2019, 02:41:12 PM
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

        <div class="container mt-3 mb-3">
            <div class="card border-success">
                <div class="card-header bg-transparent border-success text-center">
                    <h4>Añade una nueva pelicula</h4>
                    <p>Rellena todos los campos.</p>
                </div>
                <div class="card-body">
                    <form action="control?action=formP" method="post">
                        <input type="hidden" name="idd2" value="<c:out value="${updpeli.id_pelicula}"/>">
                        <div class="row">
                            <div class="form-group col-xl-6 col-lg-12 col-md-12 col-sm-12">
                                <label>Título:</label>
                                <input type="text" class="form-control" name="titulo" required="" value="<c:out value="${updpeli.nombre_pelicula}"/>">
                            </div>                            
                        </div>
                        <div class="row">
                            <div class="form-group col-xl-12 col-lg-12 col-md-12 col-sm-12">
                                <label>Sinópsis:</label>
                                <textarea class="form-control" rows="4" name="sinopsis" required=""><c:out value="${updpeli.sinopsis}"/>
                                </textarea>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-xl-4 col-lg-4 col-md-6 col-sm-12">
                                <label>Clasificación:</label>
                                <select class="custom-select" name="clasificacion">
                                    <c:forEach items="${clasi}" var="cl">
                                        <c:choose>
                                            <c:when test="${cl.id_clasificacion == updpeli.clasificacion.id_clasificacion}">
                                                <option value="<c:out value="${cl.id_clasificacion}"/>" selected="">
                                                    <c:out value="${cl.clasificacion}"/>
                                                </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="<c:out value="${cl.id_clasificacion}"/>">
                                                    <c:out value="${cl.clasificacion}"/>
                                                </option>
                                            </c:otherwise>
                                        </c:choose>

                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-xl-4 col-lg-4 col-md-6 col-sm-12">
                                <label>Categoría:</label>
                                <select class="custom-select" name="categoria">
                                    <c:forEach items="${cate}" var="ca">
                                        <c:choose>
                                            <c:when test="${ca.id_categoria == updpeli.categoria.id_categoria}">
                                                <option value="<c:out value="${ca.id_categoria}"/>" selected="">
                                                    <c:out value="${ca.categoria}"/>
                                                </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="<c:out value="${ca.id_categoria}"/>">
                                                    <c:out value="${ca.categoria}"/>
                                                </option>
                                            </c:otherwise>
                                        </c:choose>

                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group col-xl-4 col-lg-4 col-md-6 col-sm-12">
                                <label>Año de Estreno:</label>
                                <input type="text" class="form-control" name="age" placeholder="Ej: 2010" required="" value="<c:out value="${updpeli.age_estreno}"/>">
                            </div>
                        </div>
                        <div class="btn-group">
                            <button class="btn btn-success" type="submit">Guardar
                                <i class="fas fa-compact-disc"></i>
                            </button>
                            <a class="btn btn-info" href="control?action=peliculas">Ver Listado
                                <i class="fas fa-list-alt"></i>
                            </a>
                            <a class="btn btn-danger" href="inicio.jsp">Cancelar
                                <i class="fas fa-window-close"></i>
                            </a>
                        </div>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
