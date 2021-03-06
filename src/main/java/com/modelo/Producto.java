package com.modelo;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.*;

public class Producto extends RecursiveTreeObject<Producto> {

    private StringProperty cod_barra,nombre,observaciones;
    private FloatProperty precio_compra,precio_venta;
    private IntegerProperty existencia,cantidad_defectuoso;

    public Producto(String cod_barra, String nombre, String observaciones, float precio_compra, float precio_venta, int existencia, int cantidad_defectuoso) {
        this.cod_barra = new SimpleStringProperty(cod_barra);
        this.nombre = new SimpleStringProperty(nombre);
        this.observaciones = new SimpleStringProperty(observaciones);
        this.precio_compra = new SimpleFloatProperty(precio_compra);
        this.precio_venta = new SimpleFloatProperty(precio_venta);
        this.existencia = new SimpleIntegerProperty(existencia);
        this.cantidad_defectuoso = new SimpleIntegerProperty(cantidad_defectuoso);
    }

    public String getCod_barra() {
        return cod_barra.get();
    }

    public StringProperty cod_barraProperty() {
        return cod_barra;
    }

    public void setCod_barra(String cod_barra) {
        this.cod_barra.set(cod_barra);
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getObservaciones() {
        return observaciones.get();
    }

    public StringProperty observacionesProperty() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones.set(observaciones);
    }

    public float getPrecio_compra() {
        return precio_compra.get();
    }

    public FloatProperty precio_compraProperty() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra.set(precio_compra);
    }

    public float getPrecio_venta() {
        return precio_venta.get();
    }

    public FloatProperty precio_ventaProperty() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta.set(precio_venta);
    }

    public int getExistencia() {
        return existencia.get();
    }

    public IntegerProperty existenciaProperty() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia.set(existencia);
    }

    public int getCantidad_defectuoso() {
        return cantidad_defectuoso.get();
    }

    public IntegerProperty cantidad_defectuosoProperty() {
        return cantidad_defectuoso;
    }

    public void setCantidad_defectuoso(int cantidad_defectuoso) {
        this.cantidad_defectuoso.set(cantidad_defectuoso);
    }
}
