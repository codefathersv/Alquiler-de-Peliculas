<%-- 
    Document   : alquilar
    Created on : 06-19-2019, 08:30:19 PM
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

        <div class="container mt-3 mb-3">
            <div class="card border-danger">
                <div class="card-header bg-transparent text-center border-danger">
                    <h4>Selecciona el cliente y la pelicula que desea alquilar.</h4>
                    <p>Rellena los campos con la información necesaria.</p>
                </div>
                <div class="card-body">
                    <form action="control?action=formA" method="post">
                        <input type="hidden" name="idd3" value="<c:out value="${fila.id_alquiler}"/>">
                        <div class="row">
                            <div class="form-group col-xl-6 col-lg-6 col-md-12 col-sm-12">
                                <label>Selecciona una pelicula:</label>
                                <select class="custom-select" name="pelicula">
                                    <c:forEach items="${mostrarpeli}" var="mp">
                                        <c:choose>
                                            <c:when test="${mp.id_pelicula == fila.pelicula.id_pelicula}">

                                                <option value="<c:out value="${mp.id_pelicula}"/>" selected="">
                                                    <c:out value="${mp.nombre_pelicula}"/>

                                                </option>

                                            </c:when>
                                            <c:otherwise>

                                                <option value="<c:out value="${mp.id_pelicula}"/>">
                                                    <c:out value="${mp.nombre_pelicula}"/>
                                                </option>
                                            </c:otherwise>
                                        </c:choose>

                                    </c:forEach>
                                </select>

                            </div>
                        </div>

                        <div class="row">
                            <div class="btn-group ml-3 mb-3">
                                <a class="btn btn-warning btn-sm" href="control?action=peliculas">Ver Peliculas Disponibles
                                    <i class="fas fa-compact-disc"></i>
                                </a>
                                <a class="btn btn-warning btn-sm" href="control?action=clientes">Agregar Nuevo Cliente
                                    <i class="fas fa-user-check"></i>
                                </a>
                            </div> 
                        </div>

                        <div class="row">
                            <div class="form-group col-xl-6 col-lg-6 col-md-12 col-sm-12">
                                <label>Seleccion el cliente:</label>
                                <select class="custom-select" name="cliente">
                                    <c:forEach items="${mostrarclie}" var="mc">
                                        <c:choose>
                                            <c:when test="${mc.id_cliente == fila.cliente.id_cliente}">

                                                <option value="<c:out value="${mc.id_cliente}"/>" selected="">     
                                                    <c:out value="${mc.nombre_cliente}"/> <c:out value="${mc.apellido_cliente}"/>
                                                </option>
                                            </c:when>
                                            <c:otherwise>

                                                <option value="<c:out value="${mc.id_cliente}"/>">     
                                                    <c:out value="${mc.nombre_cliente}"/> <c:out value="${mc.apellido_cliente}"/>
                                                </option>
                                            </c:otherwise>
                                        </c:choose>

                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form group col-xl-12 col-lg-12 col-md-12 col-sm-12">
                                <label>Descripcion de Alquiler:</label>
                                <textarea class="form-control" name="descripcion" required=""><c:out value="${fila.descripcion}"/></textarea>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-xl-4 col-lg-4 col-md-12 col-sm-12">
                                <label>Fecha inicial:</label>
                                <input type="date" class="form-control" name="fecha_inicio" required="" value="<c:out value="${fila.fecha_alquiler}"/>">
                            </div>
                            <div class="form-group col-xl-4 col-lg-4 col-md-12 col-sm-12">
                                <label>Fecha de Entrega:</label>
                                <input type="date" class="form-control" name="fecha_entrega" required="" value="<c:out value="${fila.fecha_entrega}"/>">
                            </div>
                            <div class="form-group col-xl-4 col-lg-4 col-md-12 col-sm-12">
                                <label>Costo:</label>
                                <input class="form-control" type="text" name="costo" placeholder="Ej: 1.50" required="" value="<c:out value="${fila.costo}"/>">
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-xl-6 col-lg-6 col-md-12 col-sm-12">
                                <label>Estado:</label>
                                <select class="custom-select" name="estado">
                                    <c:forEach items="${mostrarE}" var="me">
                                        <c:choose>
                                            <c:when test="${me.id_estado == fila.estado.id_estado}">

                                                <option value="<c:out value="${me.id_estado}"/>" selected="">
                                                    <c:out value="${me.estado}"/>
                                                </option>
                                            </c:when>
                                            <c:otherwise>

                                                <option value="<c:out value="${me.id_estado}"/>">
                                                    <c:out value="${me.estado}"/>
                                                </option>
                                            </c:otherwise>
                                        </c:choose>

                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="btn-group">
                            <button class="btn btn-success" type="submit">Enviar
                                <i class="fas fa-shopping-bag"></i>
                            </button>
                            <a class="btn btn-dark" href="control?action=historial">Ver Historial
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
