package br.com.mobhub.jasper.controller;

import br.com.mobhub.jasper.dao.ClienteDao;
import br.com.mobhub.jasper.model.Cliente;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Inject private ClienteDao clienteDao;

    @RequestMapping(value = "/clientes.pdf")
    public String clientesPdf(Model model) {
        List<Cliente> clientes = clienteDao.listaDeClientes();
        JRDataSource datasource = new JRBeanCollectionDataSource(clientes);
        model.addAttribute("datasource", datasource);
        return "clientePdfReport";
    }

    @RequestMapping(value = "/clientes.xls")
    public String clientesXls(Model model) {
        List<Cliente> clientes = clienteDao.listaDeClientes();
        JRDataSource datasource = new JRBeanCollectionDataSource(clientes);
        model.addAttribute("datasource", datasource);
        return "clienteXlsReport";
    }

    @RequestMapping(value = "/clientes.html")
    public String clientesHtml(Model model) {
        List<Cliente> clientes = clienteDao.listaDeClientes();
        JRDataSource datasource = new JRBeanCollectionDataSource(clientes);
        model.addAttribute("datasource", datasource);
        return "clienteHtmlReport";
    }

    @RequestMapping(value = "/clientes.csv")
    public String clientesCsv(Model model) {
        List<Cliente> clientes = clienteDao.listaDeClientes();
        JRDataSource datasource = new JRBeanCollectionDataSource(clientes);
        model.addAttribute("datasource", datasource);
        return "clienteCsvReport";
    }

}
