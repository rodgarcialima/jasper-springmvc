package br.com.mobhub.jasper.controller;

import br.com.mobhub.jasper.dao.ClienteDao;
import br.com.mobhub.jasper.model.Cliente;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Inject private ClienteDao clienteDao;

    @RequestMapping(value = "/cliente/{format}")
    public String clientes(Model model, @PathVariable("format") String format) {
        List<Cliente> clientes = clienteDao.listaDeClientes();
        JRDataSource datasource = new JRBeanCollectionDataSource(clientes);
        model.addAttribute("datasource", datasource);
        model.addAttribute("format", format);
        return "clienteReport";
    }

}
