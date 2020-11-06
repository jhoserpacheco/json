package modelo;

import database.MysqlDbAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    private final ArrayList<ProductoDTO> productos = new ArrayList<>();

    public boolean deleteProduct(Long idProduct) {

        MysqlDbAdapter mod = new MysqlDbAdapter();
        Connection connection = mod.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM producto WHERE id =?");
            statement.setLong(1, idProduct);
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

    public boolean saveProduct(ProductoDTO product) {
        MysqlDbAdapter mod = new MysqlDbAdapter();
        Connection connection = mod.getConnection();
        try {
            /*String descripcion, String nombre, String modelo, byte departamento, int cantidad, double precio*/
            PreparedStatement statement = connection.prepareStatement("INSERT INTO producto(id," + "nombre, precio,img,infoNutricional,cantidad) VALUES (NULL,?,?,?,?,?)");
            statement.setString(1, product.getDescripcion());
            statement.setString(2, product.getNombre());
            statement.setString(3, product.getModelo());
            statement.setByte(4, product.getDepartamento());
            statement.setInt(5, product.getCantidad());
            statement.setDouble(5, product.getPrecio());
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

    public List<ProductoDTO> findAllProducts() {
        MysqlDbAdapter mod = new MysqlDbAdapter();
        Connection connection = mod.getConnection();
        List<ProductoDTO> productList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM producto");
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                /*String descripcion, String nombre, String modelo, byte departamento, int cantidad, double precio*/
                productList.add(new ProductoDTO(results.getString(1), results.getString(2), results.getString(3), results.getByte(4), Integer.parseInt(results.getString(5)), results.getDouble(6)));
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

    public boolean actualizar(ProductoDTO id) {
        MysqlDbAdapter mod = new MysqlDbAdapter();
        Connection connection = mod.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE producto SET nombre='" + id.getNombre() + "' ,precio=" + id.getPrecio() + ",cantidad='" + id.getCantidad() + "'  WHERE id =");
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
