<%-- 
    Document   : agregarC
    Created on : 06-18-2019, 07:26:46 PM
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

    <div class="container mt-3">
        <div class="card border border-success">
            <div class="card-title text-center mt-3">
                <h4>Registro de Nuevo Cliente</h4>
                <p>Rellena todos los campos.</p>
            </div>
            <hr class="bg-success">
            <div class="card-body">
                <form action="control?action=formC" method="post">
                    <input type="hidden" name="idd" value="<c:out value="${upd.id_cliente}"/>">
                    <div class="row">
                        <div class="form-group col-xl-6 col-lg-6 col-md-12 col-sm-12">
                            <label>Nombres:</label>
                            <input type="text" class="form-control" name="nombre" required="" value="<c:out value="${upd.nombre_cliente}"/>">
                        </div>
                        <div class="form-group col-xl-6 col-lg-6 col-md-12 col-sm-12">
                            <label>Apellidos:</label>
                            <input type="text" class="form-control" name="apellido" required="" value="<c:out value="${upd.apellido_cliente}"/>">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-xl-6 col-lg-6 col-md-12 col-sm-12">
                            <label>Direccion:</label>
                            <input type="text" class="form-control" name="direccion" required="" value="<c:out value="${upd.direccion}"/>">
                        </div>
                        <div class="form-group col-xl-6 col-lg-6 col-md-12 col-sm-12">
                            <label>Correo Electrónico:</label>
                            <input type="email" class="form-control" name="correo" required="" value="<c:out value="${upd.correo}"/>">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-xl-6 col-lg-6 col-md-12 col-sm-12">
                            <label>Numero de Contacto:</label>
                            <input type="text" class="form-control" name="num_celular" placeholder="####-####" required="" value="<c:out value="${upd.num_celular}"/>">
                        </div>
                    </div>

                    <div class="btn-group">
                        <button class="btn btn-success" type="submit">Guardar
                            <i class="fas fa-user-check"></i>
                        </button>
                        <a class="btn btn-info" href="control?action=clientes">Ver Clientes
                            <i class="fas fa-address-card"></i>
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
