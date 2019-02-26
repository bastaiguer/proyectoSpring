<%@page import="org.springframework.web.util.HtmlUtils"%>
<%@page import="ejemplo03.dominio.Estaciones"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Estaciones> estaciones = (List<Estaciones>) request.getAttribute("estaciones");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estacion</title>
        <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/css/bootstrap-responsive.css" rel="stylesheet">
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery-1.9.0.js"></script>
        <script type="text/javascript"  src="<%=request.getContextPath()%>/js/bootstrap.js" ></script>
    </head>
    <body style="background:#FDFDFD">
        <div class="row-fluid">
            <div class="span12">&nbsp;</div>
        </div>
        <div class="row-fluid">
            <div class="offset1  span10">
                <div class="row-fluid">
                    <div class="span12">
                        <a id="btnNuevo" class="btn btn-primary" href="<%=request.getContextPath()%>/estaciones/newForInsert.html">Nueva Estacion</a>
                    </div>
                </div>
                <div class="row-fluid">


                    <div class="span12">



                        <table class="table table-bordered table-hover table-condensed">
                            <thead>
                                <tr>
                                    <th>Código</th>
                                    <th>Nombre</th>
                                    <th>Zona</th>
                                    <th>Código Provincia</th>
                                    <th>Nombre Provincia</th>
                                    <th>Código Municipio</th>
                                    <th>Descripción Municipio</th>
                                    <th>Latitud</th>
                                    <th>Longitud</th>
                                    <th>Altitud</th>
                                    <th>#</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    for (Estaciones estacion : estaciones) {
                                %>
                                <tr>
                                    <td><a href="<%=request.getContextPath()%>/estaciones/readForUpdate.html?codigo=<%=estacion.getCodigo()%>" title="Editar" ><%=estacion.getCodigo()%></a></td>
                                    <td><%=HtmlUtils.htmlEscape(estacion.getNombre())%></td>
                                    <td><%=HtmlUtils.htmlEscape(estacion.getZona())%></td>
                                    <td><%=HtmlUtils.htmlEscape(""+estacion.getCodProvincia())%></td>
                                    <td><%=HtmlUtils.htmlEscape(estacion.getNomProvincia())%></td>
                                    <td><%=HtmlUtils.htmlEscape(""+estacion.getCodMunicipio())%></td>
                                    <td><%=HtmlUtils.htmlEscape(estacion.getDescMunicipio())%></td>
                                    <td><%=HtmlUtils.htmlEscape(""+estacion.getLatitud())%></td>
                                    <td><%=HtmlUtils.htmlEscape(""+estacion.getLongitud())%></td>
                                    <td><%=HtmlUtils.htmlEscape(""+estacion.getAltitud())%></td>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/estaciones/readForDelete.html?codigo=<%=estacion.getCodigo()%>" title="Borrar" ><i class="icon-trash"></i></a>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                            </tbody>
                        </table>


                    </div>
                </div>
            </div>
            <div class="span1"></div>
        </div>
    </body>
</html>