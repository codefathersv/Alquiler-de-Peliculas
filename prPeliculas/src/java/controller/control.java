package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.*;
import model.*;

@WebServlet(name = "control", urlPatterns = {"/control"})
public class control extends HttpServlet {

    alquilerDAO alquiler;
    mostrarCliente listclie;
    mostrarPelicula listpeli;
    categoriaDAO categoria;
    clasificacionDAO clasificacion;
    ClienteDAO cliente;
    peliculaDAO pelicula;
    mostrarEstado listest;

    public control() {
        super();
        cliente = new ClienteDAO();
        pelicula = new peliculaDAO();
        clasificacion = new clasificacionDAO();
        categoria = new categoriaDAO();
        listpeli = new mostrarPelicula();
        listclie = new mostrarCliente();
        alquiler = new alquilerDAO();
        listest = new mostrarEstado();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ruta = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("inicio")) {
            ruta = "inicio.jsp";
        } else if (action.equalsIgnoreCase("clientes") || action.equalsIgnoreCase("formC")) {
            ruta = "clientes.jsp";
            try {
                request.setAttribute("mostrarC", cliente.mostrarClientes());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (action.equalsIgnoreCase("agregarC")) {
            ruta = "agregarC.jsp";

        } else if (action.equalsIgnoreCase("eliminar")) {
            ruta = "clientes.jsp";
            int id_Dlt = Integer.parseInt(request.getParameter("id"));
            try {
                cliente.eliminarCliente(id_Dlt);
                request.setAttribute("mostrarC", cliente.mostrarClientes());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("actualizar")) {
            ruta = "agregarC.jsp";
            try {
                int idUpdate = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("upd", cliente.filaCliente(idUpdate));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("peliculas") || action.equalsIgnoreCase("formP")) {
            ruta = "peliculas.jsp";
            try {

                request.setAttribute("mostrarP", pelicula.mostrarPeliculas());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("agregarP")) {
            ruta = "agregarP.jsp";
            try {
                request.setAttribute("clasi", clasificacion.mostrarClasificacion());
                request.setAttribute("cate", categoria.mostrarCategoria());
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (action.equalsIgnoreCase("eliminarP")) {
            ruta = "peliculas.jsp";
            int idelim = Integer.parseInt(request.getParameter("id"));
            try {
                pelicula.eliminarPelicula(idelim);
                request.setAttribute("mostrarP", pelicula.mostrarPeliculas());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("actualizarP")) {
            ruta = "agregarP.jsp";
            try {
                int idupdPeli = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("updpeli", pelicula.filaPelicula(idupdPeli));
                request.setAttribute("clasi", clasificacion.mostrarClasificacion());
                request.setAttribute("cate", categoria.mostrarCategoria());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("alquilar")) {
            ruta = "alquilar.jsp";
            try {
                request.setAttribute("mostrarpeli", listpeli.mostraPelicula());
                request.setAttribute("mostrarclie", listclie.mostrarCliente());
                request.setAttribute("mostrarE", listest.mostrarEstado());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("historial")) {
            ruta = "historial.jsp";
            try {
                request.setAttribute("alquiler", alquiler.mostrarHistorial());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("eliminarH")) {
            ruta = "historial.jsp";
            try {
                int dele = Integer.parseInt(request.getParameter("id"));
                alquiler.eliminarHistorial(dele);
                request.setAttribute("alquiler", alquiler.mostrarHistorial());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (action.equalsIgnoreCase("actualizarH")) {
            ruta = "alquilar.jsp";
            int idupdE = Integer.parseInt(request.getParameter("id"));
            try {
                request.setAttribute("mostrarpeli", listpeli.mostraPelicula());
                request.setAttribute("mostrarclie", listclie.mostrarCliente());
                request.setAttribute("mostrarE", listest.mostrarEstado());
                request.setAttribute("fila", alquiler.selectFila(idupdE));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher(ruta);
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String formC = request.getParameter("action");

        dbo_clientes c = new dbo_clientes();
        dbo_peliculas p = new dbo_peliculas();
        dbo_clasificacion cl = new dbo_clasificacion();
        dbo_categoria ca = new dbo_categoria();
        dbo_estado es = new dbo_estado();
        dbo_alquiler a = new dbo_alquiler();

        if (formC.equalsIgnoreCase("formC")) {
            //obteniendo valores del formulario para agregar clientes
            String update = request.getParameter("idd");
            c.setNombre_cliente(request.getParameter("nombre"));
            c.setApellido_cliente(request.getParameter("apellido"));
            c.setDireccion(request.getParameter("direccion"));
            c.setCorreo(request.getParameter("correo"));
            c.setNum_celular(request.getParameter("num_celular"));

            //agregar clientes
            if (update == null || update.isEmpty()) {
                try {
                    cliente.agregarCliente(c);
                    request.setAttribute("mostrarC", cliente.mostrarClientes());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                request.getRequestDispatcher("/clientes.jsp").forward(request, response);
            } else {
                try {
                    int update2 = Integer.parseInt(update);
                    c.setId_cliente(update2);
                    cliente.actualizarCliente(c);
                    request.setAttribute("mostrarC", cliente.mostrarClientes());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                request.getRequestDispatcher("/clientes.jsp").forward(request, response);
            }

        } else if (formC.equalsIgnoreCase("formP")) {

            //obteniendo valores del formulario para agregar peliculas
            String updP = request.getParameter("idd2");
            p.setNombre_pelicula(request.getParameter("titulo"));
            p.setSinopsis(request.getParameter("sinopsis"));
            cl.setId_clasificacion(Integer.parseInt(request.getParameter("clasificacion")));
            p.setClasificacion(cl);
            ca.setId_categoria(Integer.parseInt(request.getParameter("categoria")));
            p.setCategoria(ca);
            p.setAge_estreno(Integer.parseInt(request.getParameter("age")));

            //agregar peliculas
            if (updP == null || updP.isEmpty()) {
                try {
                    pelicula.agregarPelicula(p);
                    request.setAttribute("mostrarP", pelicula.mostrarPeliculas());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                request.getRequestDispatcher("/peliculas.jsp").forward(request, response);
            } else {
                try {
                    int updPeli = Integer.parseInt(updP);
                    p.setId_pelicula(updPeli);
                    pelicula.actualizarPelicula(p);
                    request.setAttribute("mostrarP", pelicula.mostrarPeliculas());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                request.getRequestDispatcher("/peliculas.jsp").forward(request, response);
            }
        } else if (formC.equalsIgnoreCase("formA")) {

            //agregar historial
            String hiddenAlqui = request.getParameter("idd3");
            
            p.setId_pelicula(Integer.parseInt(request.getParameter("pelicula")));
            a.setPelicula(p);
            c.setId_cliente(Integer.parseInt(request.getParameter("cliente")));
            a.setCliente(c);
            a.setDescripcion(request.getParameter("descripcion"));
            a.setFecha_alquiler(request.getParameter("fecha_inicio"));
            a.setFecha_entrega(request.getParameter("fecha_entrega"));
            a.setCosto(Double.parseDouble(request.getParameter("costo")));
            es.setId_estado(Integer.parseInt(request.getParameter("estado")));
            a.setEstado(es);
            
            if (hiddenAlqui == null || hiddenAlqui.isEmpty()) {

                try {
                    alquiler.agregarAlquiler(a);
                    request.setAttribute("alquiler", alquiler.mostrarHistorial());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                request.getRequestDispatcher("/historial.jsp").forward(request, response);
            } else {

                try {
                    int hidAlq = Integer.parseInt(hiddenAlqui);
                    a.setId_alquiler(hidAlq);
                    alquiler.actualizarEstado(a);
                    request.setAttribute("alquiler", alquiler.mostrarHistorial());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                request.getRequestDispatcher("/historial.jsp").forward(request, response);
            }

        }

    }

}
