package empresafxtotal.model;

import empresafxtotal.controller.Cargo;

import empresafxtotal.controller.Funcionario;
import empresafxtotal.controller.FuncionarioEndereco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FuncionarioDAO {

    public static int create(Funcionario func) throws SQLException {
        Statement stm = BancoDados.createConnection().createStatement();

        String sql = "insert into funcionarios (nome,cpf,fk_cargo) values('" + func.getNome() + "','" + func.getCpf() + "','"
                + func.getFk_cargo() + "')";

        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        System.out.println(sql);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        func.setPk_funcionario(key);

        FuncionarioEnderecoDAO.create(func.getFuncEndereco());

        return key;

    }

    public static Funcionario retreave(int pk_funcionario) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                createStatement();

        String sql = "Select * from funcionarios where pk_funcionario=" + pk_funcionario;

        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        Cargo c = CargoDAO.retreave(rs.getInt("fk_cargo"));
        FuncionarioEndereco e = FuncionarioEnderecoDAO.retreaveByFuncionario(pk_funcionario);
        return new Funcionario(rs.getInt("pk_funcionario"), rs.getInt("fk_cargo"), rs.getString("nome"), rs.getString("cpf"), c, e);

    }

    public static ArrayList<Funcionario> retreaveAll() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                createStatement();
        String sql = "Select * from funcionarios";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Funcionario> cs = new ArrayList<>();
        while (rs.next()) {
            Cargo c = CargoDAO.retreave(rs.getInt("fk_cargo"));
            FuncionarioEndereco e = FuncionarioEnderecoDAO.retreaveByFuncionario(rs.getInt("pk_funcionario"));

            cs.add(new Funcionario(
                    rs.getInt("pk_funcionario"),
                    rs.getInt("fk_cargo"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    c,
                    e));
        }

        return cs;
    }

    public static ArrayList<Funcionario> retreaveAllVendedores() throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                createStatement();
        String sql = "Select * from funcionarios where fk_cargo = 1";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Funcionario> cs = new ArrayList<>();
        while (rs.next()) {
            Cargo c = CargoDAO.retreave(rs.getInt("fk_cargo"));
            FuncionarioEndereco e = FuncionarioEnderecoDAO.retreaveByFuncionario(rs.getInt("pk_funcionario"));

            cs.add(new Funcionario(
                    rs.getInt("pk_funcionario"),
                    rs.getInt("fk_cargo"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    c,
                    e));
        }

        return cs;
    }

    public static void delete(Funcionario f) throws SQLException {
        Statement stm
                = BancoDados.createConnection().
                createStatement();
        String sql = "delete from funcionarios where pk_funcionario=" + f.getPk_funcionario();
        System.out.println(sql);

        stm.execute(sql);

    }

    public static void update(Funcionario f) throws SQLException {

        Statement stm
                = BancoDados.createConnection().
                createStatement();
        String sql = "update  funcionarios set " + "nome='" + f.getNome() + "',cpf='" + f.getCpf() + "'where pk_funcionario =" + f.getPk_funcionario();
        FuncionarioEnderecoDAO.update(f.getFuncEndereco());
        System.out.println(sql);
        stm.execute(sql);

    }

}
