<%@page import="java.util.Set"%>
<%@page import="org.springframework.web.util.HtmlUtils"%>
<%@page import="com.fpmislata.persistencia.dao.BussinessMessage"%>
<%@page import="ejemplo03.presentacion.FormOperation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    FormOperation formOperation = (FormOperation) request.getAttribute("formOperation");
    String labelButton = null;
    String urlAction;
    switch (formOperation) {
        case Insert:
            labelButton = "Insertar";
            urlAction = request.getContextPath() + "/estaciones/insert.html";
            break;
        case Update:
            labelButton = "Actualizar";
            urlAction = request.getContextPath() + "/estaciones/update.html";
            break;
        case Delete:
            labelButton = "Borrar";
            urlAction = request.getContextPath() + "/estaciones/delete.html";
            break;
        default:
            throw new RuntimeException("El valor de 'formOperation' no es válido" + formOperation);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estaciones</title>
        <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css" rel="stylesheet">
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery-1.9.0.js"></script>
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/bootstrap.js" ></script>
    </head>
    <body style="background:#FDFDFD">
        <div class="row">
            <div class="span12">&nbsp;</div>
        </div>
        <div class="row">
            <div class="offset1 span10 well">
                <h3>Estación</h3>
                <form action="<%=urlAction%>" method="post" >
                    <fieldset>
                        <label class="control-label" for="codigo">Código:</label>
                        <input class="input-large" id="codigo" name="codigo" type="text" value="${estaciones.codigo}">

                        <label class="control-label" for="nombre">Nombre:</label>
                        <input class="input-xlarge" id="nombre" type="text" name="nombre" value="${estaciones.nombre}" >

                        <label class="control-label" for="zona">Zona:</label>
                        <input class="input-xlarge" id="zona" type="text" name="zona" value="${estaciones.zona}" >

                        <label class="control-label" for="direccion">Dirección:</label>
                        <input class="input-xlarge" id="direccion" type="text" name="direccion" value="${estaciones.direccion}" >

                        <label class="control-label" for="codProvincia">Código provincia:</label>
                        <input class="input-xlarge" id="codProvincia" type="text" name="codProvincia" value="${estaciones.codProvincia}" >

                        <label class="control-label" for="nomProvincia">Nombre provincia:</label>
                        <input class="input-xlarge" id="nomProvincia" type="text" name="nomProvincia" value="${estaciones.nomProvincia}" >

                        <label class="control-label" for="codMunicipio">Código municipio:</label>
                        <input class="input-xlarge" id="codMunicipio" type="text" name="codMunicipio" value="${estaciones.codMunicipio}" >

                        <label class="control-label" for="descMunicipio">Descripción municipio:</label>
                        <input class="input-xlarge" id="descMunicipio" type="text" name="descMunicipio" value="${estaciones.descMunicipio}" >

                        <label class="control-label" for="latitud">Latitud:</label>
                        <input class="input-xlarge" id="latitud" type="text" name="latitud" value="${estaciones.latitud}" >

                        <label class="control-label" for="longitud">Longitud:</label>
                        <input class="input-xlarge" id="longitud" type="text" name="longitud" value="${estaciones.longitud}" >

                        <label class="control-label" for="altitud">Altitud:</label>
                        <input class="input-xlarge" id="altitud" type="text" name="altitud" value="${estaciones.altitud}" >
                    </fieldset>
                    <% if (request.getAttribute("bussinessMessages") != null) {%>
                    <div class="alert alert-error alert-block">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <ul>
                            <%for (BussinessMessage bussinessMessage : (Set<BussinessMessage>) request.getAttribute("bussinessMessages")) {%>
                            <li>
                                <%if (bussinessMessage.getFieldName() != null) {
                                        out.print("<strong>" + HtmlUtils.htmlEscape(bussinessMessage.getFieldName()) + "</strong>");
                                    }
                                %>
                                <%=HtmlUtils.htmlEscape(bussinessMessage.getMessage())%>
                            </li>
                            <%} %>
                        </ul>
                    </div>
                    <%} %>
                    <div class="form-actions">
                        <button id="aceptarBtn" class="btn btn-primary" type="submit"><%=labelButton%></button>
                        <a class="btn" href="<%=request.getContextPath()%>/index.html" >Cancelar</a>
                    </div>
                </form>
            </div>
        </div>
        <script>

        </script>
    </body>
</html>