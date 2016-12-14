package empresafxtotal.model;

import empresafxtotal.controller.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdutoDAO {

    private ProdutoDAO() {

    }

    public static int create(Produto produto) throws SQLException {
        Statement stm = BancoDados.createConnection().createStatement();

        String sql = "insert into produtos (nome,estoque_minimo, qtd_estoque) values('" + produto.getNome() + "','" + produto.getEstoqueMinino() + "','"
                + produto.getQtdEstoque() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        produto.setPk_produto(key);

        return key;

    }

    public static Produto retreave(int pk_produto) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                createStatement();

        String sql = "Select * from produtos where pk_produto=" + pk_produto;

        ResultSet rs = stm.executeQuery(sql);
        rs.next();

        return new Produto(rs.getInt("pk_produto"), rs.getString("nome"), rs.getInt("estoque_minimo"), rs.getInt("qtd_estoque"));
    }

    public static void delete(Produto p) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                createStatement();
        String sql = "delete from produtos where pk_enderenco=" + p.getPk_produto();

        stm.execute(sql);

    }

    public static ArrayList<Produto> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                createStatement();
        String sql = "Select * from produtos";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Produto> cs = new ArrayList<>();
        while (rs.next()) {

            cs.add(new Produto(
                    rs.getInt("pk_produto"),
                    rs.getString("nome"),
                    rs.getInt("estoque_minimo"),
                    rs.getInt("qtd_estoque")));
        }

        return cs;
    }

    public static void update(Produto p) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                createStatement();
        String sql = "update  produtos set " + "nome='" + p.getNome() + "',estoque_minimo='" + p.getEstoqueMinino()
                + "',qtd_estoque='" + p.getQtdEstoque() + "'where pk_produto =" + p.getPk_produto();

        stm.execute(sql);

    }

}
