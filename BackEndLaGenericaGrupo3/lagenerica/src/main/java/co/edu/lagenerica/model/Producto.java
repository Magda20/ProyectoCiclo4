package co.edu.lagenerica.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.Size;


@Document(collection = "db_productos")
public class Producto {

	@Id
	@Size(min = 1, max = 20)
	private long codigo_producto;

	@Size(min = 1, max = 50)
	private String nombre_producto;
	
	@Size(min = 1, max = 20)
	private long nit_proveedor;
	
	private double precio_compra;
	
	private double iva_compra;
	
	private double precio_venta;
	
	
	
	public long getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public double getIva_compra() {
		return iva_compra;
	}
	public void setIva_compra(double iva_compra) {
		this.iva_compra = iva_compra;
	}
	public long getNit_proveedor() {
		return nit_proveedor;
	}
	public void setNit_proveedor(long nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public double getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	
	
	
}
