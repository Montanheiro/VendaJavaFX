package empresafxtotal.model;

import empresafxtotal.controller.VendaItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VendaItemDAO {

    VendaItemDAO() {
    }

    public static int create(VendaItem vi) throws Exception {
        Statement stm = BancoDados.createConnection().createStatement();

        String sql = "insert into vendas_itens (fk_venda, fk_produto, qtd, valor_unitario)"
                + "VALUES (" + vi.getFkVenda() + ", " + vi.getProduto().getPk_produto() + ", " + vi.getQtd() + ", " + vi.getValorUnitario() + ")";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        vi.setPkVendaItem(key);

        return key;
    }

    public static ArrayList<VendaItem> retreaveByPkVenda(int pkVenda) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                createStatement();

        String sql = "SELECT * FROM vendas_itens WHERE pk_Venda =  " + pkVenda;

        ResultSet rs = stm.executeQuery(sql);
        ArrayList<VendaItem> cs = new ArrayList<>();
        while (rs.next()) {
            cs.add(new VendaItem(rs.getInt("fk_venda"), rs.getInt("qtd"), rs.getFloat("valor_unitario"),
                    ProdutoDAO.retreave(rs.getInt("fk_produto")), rs.getInt("fk_venda")));
        }

        return cs;
    }

    public static ArrayList<VendaItem> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                createStatement();

        String sql = "SELECT * FROM vendas_itens";

        ResultSet rs = stm.executeQuery(sql);
        ArrayList<VendaItem> cs = new ArrayList<>();
        while (rs.next()) {
            cs.add(new VendaItem(rs.getInt("pk_venda"), rs.getInt("qtd"), rs.getFloat("valor_unitario"),
                    ProdutoDAO.retreave(rs.getInt("fk_produto")), rs.getInt("fk_venda")));
        }

        return cs;
    }

}
