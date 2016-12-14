package empresafxtotal.model;

import empresafxtotal.controller.Cliente;
import empresafxtotal.controller.Endereco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    private ClienteDAO() {

    }

    public static int create(Cliente c) throws SQLException {
        Statement stm = BancoDados.createConnection().createStatement();

        String sql = "insert into clientes (nome,cpf) values('" + c.getNome() + "','" + c.getCpf() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        c.setPk_cliente(key);
        System.out.println(key);
        EnderecoDAO.create(c.getEndereco());

        return key;
    }

    public static Cliente retreave(int pk_cliente) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                createStatement();

        String sql = "Select * from clientes where pk_cliente=" + pk_cliente;

        ResultSet rs = stm.executeQuery(sql);
        rs.next();

        Endereco e = EnderecoDAO.retreaveByCliente(pk_cliente);
        return new Cliente(rs.getInt("pk_cliente"), rs.getString("nome"), rs.getString("cpf"), e);
    }

    public static ArrayList<Cliente> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                createStatement();
        String sql = "Select * from clientes";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Cliente> cs = new ArrayList<>();
        while (rs.next()) {
            Endereco e = EnderecoDAO.retreaveByCliente(rs.getInt("pk_cliente"));
            cs.add(new Cliente(
                    rs.getInt("pk_cliente"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    e));
        }

        return cs;
    }

    public static Cliente retreaveByClienteEnde(int fk_cliente) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                createStatement();

        String sql = "Select * from clientes where pk_cliente=" + fk_cliente;

        ResultSet rs = stm.executeQuery(sql);
        rs.next();

        Endereco e = EnderecoDAO.retreaveByCliente(fk_cliente);
        return new Cliente(rs.getInt("pk_cliente"), rs.getString("nome"), rs.getString("cpf"), e);

    }

    public static void delete(Cliente c) throws SQLException {

        Statement stm
                = BancoDados.createConnection().
                createStatement();
        String sql = "delete from clientes where pk_cliente=" + c.getPk_cliente();
        System.out.println(sql);
        stm.execute(sql);

    }

    public static void update(Cliente c) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                createStatement();
        String sql = "update  clientes set " + "nome='" + c.getNome() + "',cpf='" + c.getCpf() + "'where pk_Cliente=" + c.getPk_cliente();
        EnderecoDAO.update(c.getEndereco());
        System.out.println(sql);
        stm.execute(sql);

    }

}
