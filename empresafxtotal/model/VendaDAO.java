package empresafxtotal.model;


import empresafxtotal.controller.Cliente;
import empresafxtotal.controller.Funcionario;
import empresafxtotal.controller.VendaItem;
import empresafxtotal.controller.Venda;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VendaDAO {
    
    private VendaDAO() {
    }

    public static boolean create(Venda v) throws Exception {
        Statement stm =  BancoDados.createConnection().createStatement();

            String sql = "INSERT INTO vendas (fk_cliente, fk_vendedor, numero, datas) VALUES ("+v.getCliente().getPk_cliente()+", " +
                    v.getVendedor().getPk_funcionario()+", "+(retreaveNumeroVenda()+1)+", '"+v.getData()+"')";
            System.out.printf(sql);
        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
            v.setPkVenda(key);

                ArrayList<VendaItem> vis = v.getItens();
                for (VendaItem vi : vis) {
                    vi.setFkVenda(key);
                    VendaItemDAO.create(vi);
                }
                return true;

 
    }

    public static Venda retreave(int pk_venda) {
        try {
            Statement stm =
                    BancoDados.createConnection().
                            createStatement();

            String sql = "select * from vendas where pk_venda =" + pk_venda;

            ResultSet rs = stm.executeQuery(sql);
            rs.next();

            ArrayList<VendaItem> i = VendaItemDAO.retreaveByPkVenda(rs.getInt("pk_venda"));

            Cliente c = ClienteDAO.retreave(rs.getInt("fk_cliente"));

            Funcionario f = FuncionarioDAO.retreave(rs.getInt("fk_vendedor"));

            return new Venda(rs.getInt("pk_venda"), rs.getInt("numero"),
                    rs.getString("datas"), c, f, i);
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


        return null;
    }

    public static ArrayList<Venda> retreaveAll() {
        try {
            Statement stm =
                    BancoDados.createConnection().
                            createStatement();

            String sql = "SELECT * FROM vendas";

            ResultSet rs = stm.executeQuery(sql);
            ArrayList<Venda> cs = new ArrayList<>();
            while (rs.next()) {
                ArrayList<VendaItem> i = VendaItemDAO.retreaveByPkVenda(rs.getInt("pk_venda"));

                Cliente c = ClienteDAO.retreave(rs.getInt("fk_cliente"));

                Funcionario f = FuncionarioDAO.retreave(rs.getInt("fk_vendedor"));

                cs.add(new Venda(rs.getInt("pk_venda"), rs.getInt("numero"),
                        (rs.getString("datas")), c, f, i));
            }

            return cs;
        } catch (SQLException ex) {
            Logger.getLogger(VendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }


        return null;
    }

//    public static boolean update(Venda v) throws SQLException {
//        try {
//            Statement stm = BancoDados.createConnection().createStatement();
//            String sql = "update clientes set nome='" + c.getNome() + "'," +
//                    "cpf ='" + c.getCpf() + "' where pk_cliente = " + c.getPk_cliente();
//            EnderecoDAO.update(c.getEndereco(), "clientes_enderecos", "pk_endereco");
//            stm.execute(sql);
//            return true;
//        } catch (SQLException e) {
//            throw new SQLException("Erro ao executar query: ", e.getCause());
//        }
//    }
//
//    public static boolean delete(Venda v) throws SQLException {
//        Statement stm = BancoDados.createConnection().createStatement();
//        String sql = "delete from clientes where pk_cliente =" + c.getPk_cliente();
//        stm.execute(sql);
//        EnderecoDAO.delete(c.getEndereco(), "clientes_enderecos", "pk_endereco");
//        return true;
//    }

    public static int retreaveNumeroVenda() throws SQLException {
        Statement stm = BancoDados.createConnection().createStatement();
        String sql = "SELECT * FROM vendas ORDER BY numero DESC LIMIT 1";

        ResultSet rs = stm.executeQuery(sql);
        if(rs.next()){

            return rs.getInt("numero");
        }else{
            return 0;
        }
    }

    public static boolean delete(Venda v) throws SQLException {
            Statement stm = BancoDados.createConnection().createStatement();
            String sql = "delete from vendas where pk_venda = " + v.getPkVenda();
            stm.execute(sql);
            return true;
    }

}