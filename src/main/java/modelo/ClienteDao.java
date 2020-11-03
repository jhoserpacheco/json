package modelo;

import database.MysqlDbAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ClienteDao implements crud {

    private final ArrayList<ClienteDto> clientes = new ArrayList<>();
    private MysqlDbAdapter mod = new MysqlDbAdapter();

    @Override
    public boolean agregar(Object a) {
        ClienteDto cliente = (ClienteDto) (a);
        MysqlDbAdapter mod = new MysqlDbAdapter();
        Connection connection = mod.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO cliente (nombre,cedula,telefono,correo,direccion,fecha_nacimiento) VALUES (?,?,?,?,?,?)");
            statement.setString(1, cliente.getNombre());
            statement.setDouble(2, cliente.getCedula());
            statement.setInt(3, cliente.getTelefono());
            statement.setString(4, cliente.getCorreo());
            statement.setString(5, cliente.getDireccion());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public List<ClienteDto> consultar() {
        mod = new MysqlDbAdapter();
        Connection connection = mod.getConnection();
        List<ClienteDto> productList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cliente");
            ResultSet results = statement.executeQuery();

            while (results.next()) {
                productList.add(new ClienteDto(results.getString(1), results.getInt(2), results.getInt(3), results.getString(4), results.getString(5)));
            }
            return productList;
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }

    }

    @Override
    public boolean eliminar(long cedula) {
        Connection connection = mod.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM cliente WHERE cedula =?");
            statement.setLong(1, cedula);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public boolean actualizar(Object a) {
        ClienteDto cedula = (ClienteDto) (a);
        MysqlDbAdapter mod = new MysqlDbAdapter();
        Connection connection = mod.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE cliente SET nombre='" + cedula.getNombre() + "',telefono='" + cedula.getTelefono() + "',correo='" + cedula.getCorreo() + "',direccion='" + cedula.getDireccion() + "'  WHERE cedula =" + cedula.getCedula());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }
}
