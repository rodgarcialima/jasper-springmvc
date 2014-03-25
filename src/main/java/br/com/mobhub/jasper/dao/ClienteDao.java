package br.com.mobhub.jasper.dao;

import br.com.mobhub.jasper.model.Cliente;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClienteDao {

    @Inject private JdbcTemplate db;

    public List<Cliente> listaDeClientes() {
        return db.query("select * from CLIENTE", mapper);
    }

    private RowMapper<Cliente> mapper = new RowMapper<Cliente>() {
        @Override
        public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
            Cliente c = new Cliente();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            return c;
        }
    };

}