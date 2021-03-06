package com.modelo;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DetalleCompra extends RecursiveTreeObject<DetalleCompra> {
    private StringProperty codBarra;
    private StringProperty nombreProducto;
    private DoubleProperty precioProducto;
    private IntegerProperty cantidadProducto;
    private IntegerProperty idTransaccion;

    public DetalleCompra(String codBarra, String nombreProducto, Double precioProducto, Integer cantidadProducto, int idTransaccion) {
        this.codBarra = new SimpleStringProperty(codBarra);
        this.nombreProducto = new SimpleStringProperty(nombreProducto);
        this.precioProducto = new SimpleDoubleProperty(precioProducto);
        this.cantidadProducto = new SimpleIntegerProperty(cantidadProducto);
        this.idTransaccion = new SimpleIntegerProperty(idTransaccion);
    }

    public String getCodBarra() {
        return codBarra.get();
    }

    public StringProperty codBarraProperty() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra.set(codBarra);
    }

    public String getNombreProducto() {
        return nombreProducto.get();
    }

    public StringProperty nombreProductoProperty() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto.set(nombreProducto);
    }

    public double getPrecioProducto() {
        return precioProducto.get();
    }

    public DoubleProperty precioProductoProperty() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto.set(precioProducto);
    }

    public int getCantidadProducto() {
        return cantidadProducto.get();
    }

    public IntegerProperty cantidadProductoProperty() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto.set(cantidadProducto);
    }

    public int getIdTransaccion() {
        return idTransaccion.get();
    }

    public IntegerProperty idTransaccionProperty() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion.set(idTransaccion);
    }

    //

    public static void llenarDatos(Connection connection, ObservableList<DetalleCompra> list) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT d.cod_barra, p.nombre, p.precio_compra, d.cantidad, d.id_transaccion \n" +
                    "FROM detalle_transaccion AS d INNER JOIN producto AS p ON p.cod_barra = d.cod_barra "
            );
            while(resultSet.next())
                list.add(new DetalleCompra(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5)
                ));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
