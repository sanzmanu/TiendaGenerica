package Modelo;

public class ProductosDTO {

	private int codigo_producto;
	private double ivacompra;
	private int nitproveedor;
	private String nombre_producto;
	private double precio_compra;
	private double precio_venta;
	
	public ProductosDTO (int codigoProd,String nombreProducto,int nitProveedor,double precioCompra,double ivaCompra,double precioVenta) {
		
		codigo_producto=codigoProd;
		nombre_producto=nombreProducto;
		nitproveedor=nitProveedor;
		precio_compra=precioCompra;
		ivacompra=ivaCompra;
		precio_venta=precioVenta;		
	}

	public int getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public double getIvacompra() {
		return ivacompra;
	}

	public void setIvacompra(double ivacompra) {
		this.ivacompra = ivacompra;
	}

	public int getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(int nitproveedor) {
		this.nitproveedor = nitproveedor;
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
