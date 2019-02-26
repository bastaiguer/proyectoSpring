/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo03.presentacion;

import com.fpmislata.persistencia.dao.BussinessException;
import com.fpmislata.persistencia.dao.BussinessMessage;
import ejemplo03.dominio.Estaciones;
import ejemplo03.persistencia.dao.EstacionesDAO;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Lorenzo González
 */
@Controller
public class EstacionesController {

    @Autowired
    private EstacionesDAO estacionesDAO;
    
    @RequestMapping({"/index.html"})
    public ModelAndView listarEstaciones(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            List<Estaciones> estaciones = estacionesDAO.findAll();
            model.put("estaciones",estaciones);
            viewName = "estacionesLista";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("backURL", request.getContextPath() + "/index.html");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }
    @RequestMapping({"/estaciones/newForInsert"})
    public ModelAndView newForInsert(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            Estaciones estaciones = estacionesDAO.create();
            model.put("formOperation", FormOperation.Insert);
            model.put("estaciones", estaciones);
            viewName = "estaciones";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("backURL", request.getContextPath() + "/index.html");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/estaciones/readForUpdate"})
    public ModelAndView readForUpdate(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            int id;
            try {
                id = Integer.parseInt(request.getParameter("codigo"));
            } catch (NumberFormatException nfe) {
                throw new BussinessException(new BussinessMessage(null,"Se debe escribir un Id válido"));
            }

            Estaciones estaciones = estacionesDAO.get(id);
            if (estaciones == null) {
                throw new BussinessException(new BussinessMessage(null, "No existe la estación con id=" + id));
            }
            model.put("formOperation", FormOperation.Update);
            model.put("estaciones", estaciones);
            viewName = "estaciones";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("backURL", request.getContextPath() + "/index.html");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/estaciones/readForDelete"})
    public ModelAndView readForDelete(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;
        try {
            int id;
            try {
                id = Integer.parseInt(request.getParameter("codigo"));
            } catch (NumberFormatException nfe) {
                throw new BussinessException(new BussinessMessage(null,"Se debe escribir un Id válido"));
            }

            Estaciones estaciones = estacionesDAO.get(id);
            if (estaciones == null) {
                throw new BussinessException(new BussinessMessage(null, "No existe la estación con id=" + id));
            }
            model.put("formOperation", FormOperation.Delete);
            model.put("estaciones", estaciones);
            viewName = "estaciones";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("backURL", request.getContextPath() + "/index.html");
            viewName = "error";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/estaciones/insert.html"})
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }

        Estaciones estaciones = null;
        try {
            estaciones = estacionesDAO.create();

            estaciones.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            estaciones.setNombre(request.getParameter("nombre"));
            estaciones.setZona(request.getParameter("zona"));
            estaciones.setDireccion(request.getParameter("direccion"));
            estaciones.setCodProvincia(Integer.parseInt(request.getParameter("codProvincia")));
            estaciones.setNomProvincia(request.getParameter("nomProvincia"));
            estaciones.setCodMunicipio(Integer.parseInt(request.getParameter("codMunicipio")));
            estaciones.setDescMunicipio(request.getParameter("descMunicipio"));
            estaciones.setLatitud(Float.parseFloat(request.getParameter("latitud")));
            estaciones.setLongitud(Float.parseFloat(request.getParameter("longitud")));
            estaciones.setAltitud(Integer.parseInt(request.getParameter("altitud")));

            estacionesDAO.saveOrUpdate(estaciones);

            viewName = "redirect:/index.html";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            if (estaciones!=null) {
                estaciones.setCodigo(0);
            }
            model.put("estaciones", estaciones);
            model.put("formOperation", FormOperation.Insert);
            viewName = "estaciones";
        }



        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/estaciones/update.html"})
    public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
        Estaciones estaciones = null;
        try {
            int id;
            try {
                id = Integer.parseInt(request.getParameter("codigo"));
            } catch (NumberFormatException nfe) {
                throw new BussinessException(new BussinessMessage(null,"Se debe escribir un Id válido"));
            }
            estaciones = estacionesDAO.get(id);
            if (estaciones == null) {
                throw new BussinessException(new BussinessMessage(null, "Ya no existe la estación."));
            }
            estaciones.setCodigo(id);
            estaciones.setNombre(request.getParameter("nombre"));
            estaciones.setZona(request.getParameter("zona"));
            estaciones.setDireccion(request.getParameter("direccion"));
            estaciones.setCodProvincia(Integer.parseInt(request.getParameter("codProvincia")));
            estaciones.setNomProvincia(request.getParameter("nomProvincia"));
            estaciones.setCodMunicipio(Integer.parseInt(request.getParameter("codMunicipio")));
            estaciones.setDescMunicipio(request.getParameter("descMunicipio"));
            estaciones.setLatitud(Float.parseFloat(request.getParameter("latitud")));
            estaciones.setLongitud(Float.parseFloat(request.getParameter("longitud")));
            estaciones.setAltitud(Integer.parseInt(request.getParameter("altitud")));

            estacionesDAO.saveOrUpdate(estaciones);

            viewName = "redirect:/index.html";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("estaciones", estaciones);
            model.put("formOperation", FormOperation.Update);
            viewName = "estaciones";
        }

        return new ModelAndView(viewName, model);
    }

    @RequestMapping({"/estaciones/delete.html"})
    public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = new HashMap<String, Object>();
        String viewName;

        Estaciones estaciones=null;
        try {
            int id;
            try {
                id = Integer.parseInt(request.getParameter("codigo"));
            } catch (NumberFormatException nfe) {
                throw new BussinessException(new BussinessMessage(null,"Se debe escribir un Id válido"));
            }
            estaciones = estacionesDAO.get(id);
            if (estaciones == null) {
                throw new BussinessException(new BussinessMessage(null, "Ya no existe la estación a borrar"));
            }

            estacionesDAO.delete(id);

            viewName = "redirect:/index.html";
        } catch (BussinessException ex) {
            model.put("bussinessMessages", ex.getBussinessMessages());
            model.put("estaciones", estaciones);
            model.put("formOperation", FormOperation.Delete);
            viewName = "estaciones";
        }

        return new ModelAndView(viewName, model);
    }

}
