package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import controladores.ControladorContacto;
import controladores.ControladorCuentaxCobrar;
import controladores.ControladorCuentaxPagar;
import controladores.ControladorParqueadero;
import controladores.ControladorProveedor;
import controladores.ControladorUnidad;
import controladores.ProcesadorArchivos;
import entidades.Contacto;
import entidades.CuentaPorCobrar;
import entidades.CuentaPorPagar;
import entidades.ParqueaderoBodega;
import entidades.Proveedor;
import entidades.UnidadHabitacional;
import validadores.ValidadorContacto;
import validadores.ValidadorCuentasPorCobrar;
import validadores.ValidadorCuentasPorPagar;
import validadores.ValidadorParqueaderoBodega;
import validadores.ValidadorProveedor;
import validadores.ValidadorUnidad;

import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class principal extends JFrame {

	private JPanel contentPane;
	JTextPane txtpnListo = new JTextPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JToggleButton btnEscojerArchivo = new JToggleButton("Seleccionar archivo");
		btnEscojerArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				procesar();
			}
		});
		contentPane.add(btnEscojerArchivo, BorderLayout.NORTH);


		txtpnListo.setText("Listo...");
		contentPane.add(txtpnListo, BorderLayout.CENTER);
	}

	public void procesar() {
		ProcesadorArchivos procesador = new ProcesadorArchivos();
		ControladorUnidad procesadorUnidad= new ControladorUnidad();
		ControladorContacto procesadorContacto = new ControladorContacto();
		ControladorParqueadero procesadorParqueadero = new ControladorParqueadero();
		ControladorCuentaxCobrar procesadorCobrar = new ControladorCuentaxCobrar();
		ControladorProveedor procesadorProveedor = new ControladorProveedor();
		ControladorCuentaxPagar procesadorPagar = new ControladorCuentaxPagar();
		
		ValidadorUnidad validaUnidad = new ValidadorUnidad();
		ValidadorProveedor validaroveedor = new ValidadorProveedor();
		ValidadorContacto validaContacto =new ValidadorContacto();
		ValidadorCuentasPorCobrar validaCobro= new ValidadorCuentasPorCobrar();
		ValidadorCuentasPorPagar validaPaga= new ValidadorCuentasPorPagar();
		ValidadorParqueaderoBodega validaParqueadero= new ValidadorParqueaderoBodega();
		
		
		
		
		File archivo = procesador.abrirArchivo("Excel", "xlsx");

		//System.out.println(archivo.getName());

		txtpnListo.setText(txtpnListo.getText()+"\n"+"Archivo abierto: "+archivo.getAbsolutePath());

		String ruta= archivo.getAbsolutePath();


		XSSFWorkbook excel= procesador.leerExcel(ruta);
		txtpnListo.setText(txtpnListo.getText()+"\n"+"Hojas por procesar: "+excel.getNumberOfSheets());
		
		List<Contacto> contactos=procesadorContacto.extraerContacto(excel);
		List<UnidadHabitacional> unidades=procesadorUnidad.extraerUnidades(excel);
		List<Proveedor> proveedor=procesadorProveedor.extraerProveedor(excel);
		List<CuentaPorCobrar> cuentaxCobrar=procesadorCobrar.extraerCuentaCobrar(excel);
		List<CuentaPorPagar> cuentaxPagar= procesadorPagar.extraerCuentaPagar(excel);
		List<ParqueaderoBodega> parqueo= procesadorParqueadero.extraerParqueaderoBodega(excel);
		
		 //imprime datos de CONTACTO
		
	/*	for (CuentaPorCobrar cobrando : cuentaxCobrar) {
			System.out.println(validaCobro.existeUnidad(cobrando, unidades));
		}
		System.out.println("--");*/
		
		for (ParqueaderoBodega parquederoBogega : parqueo) {
			System.out.println(validaParqueadero.existeUnidad(parquederoBogega, unidades));
		}
		System.out.println("--");
		
		/*for (UnidadHabitacional unidadHabitacional : unidades) {
			System.out.println(validaUnidad.comprobarSiSeRepiteUnidad(unidadHabitacional, unidades));;
		}*/
		
		for (Proveedor proveedores : proveedor) {
		System.out.println(validaroveedor.comprobarSiSeRepiteProveedor(proveedores, proveedor));;
	}
		

		
	/*List<Contacto> contacto=procesadorContacto.extraerContacto(excel);
		 //imprime datos de CONTACTO
		for (int i = 0; i < contacto.size(); i++) {
			System.out.println(contacto.get(i).getUnidadHabitacional().getId());
			System.out.println(contacto.get(i).getIdentificacion());
			System.out.println(contacto.get(i).getRelacion());
			System.out.println(contacto.get(i).getNombre());
			System.out.println(contacto.get(i).getApellido());
			System.out.println(contacto.get(i).getEmal1());
			System.out.println(contacto.get(i).getEmail2());
			System.out.println(contacto.get(i).getCelular());
			System.out.println(contacto.get(i).getTelefono());
			System.out.println(contacto.get(i).getViveEnUnidad());
			System.out.println(contacto.get(i).getEsRepresentante());
		
		}
		*/
		
		/*
		 List<UnidadHabitacional> unidadesSoloIds = new ArrayList<UnidadHabitacional>();
		 for (int i = 0; i < unidades.size(); i++) {
			UnidadHabitacional nuevaUnidad = new UnidadHabitacional(unidades.get(i).getId());
		
			System.out.println(nuevaUnidad.getId());
			unidadesSoloIds.add(nuevaUnidad);
		}*/
	
		
		
	
		
	
	/* 
	 List<ParqueaderoBodega> parqueadroBodega =procesadorParqueadero.extraerParqueaderoBodega(excel);
	 //imprime datos de PARQUEADERO-BODEGA
		for (int i = 0; i < parqueadroBodega.size(); i++) {
			System.out.println(parqueadroBodega.get(i).getUnidadHabitacional().getId());
			System.out.println(parqueadroBodega.get(i).getId());		
			System.out.println(parqueadroBodega.get(i).getEstaArrendada());
			System.out.println(parqueadroBodega.get(i).getUbicacion());
		
		
			//System.out.println(procesador.comprobarSiExisteUnidad(parqueadroBodega.get(i).getUnidadHabitacional(), unidadesSoloIds));
			}
		*/
		
		
		/*List<CuentaPorCobrar> cuentaxCobrar = procesadorCobrar.extraerCuentaCobrar(excel);
			//imprime datos de CUENTAS POR COBRAR
		for (int i = 0; i < cuentaxCobrar.size(); i++) {
			System.out.println(cuentaxCobrar.get(i).getUnidadHabitacional().getId());
			System.out.println(cuentaxCobrar.get(i).getRubro());
			System.out.println(cuentaxCobrar.get(i).getFechaEmision());
			System.out.println(cuentaxCobrar.get(i).getFechaVencimiento());
			System.out.println(cuentaxCobrar.get(i).getNumeroDocumento());
			System.out.println(cuentaxCobrar.get(i).getDetalle());
			System.out.println(cuentaxCobrar.get(i).getValor());
			System.out.println(cuentaxCobrar.get(i).getModo());
					}*/
		
	
		/*List<Proveedor> proveedores = procesadorProveedor.extraerProveedor(excel);
		 
		 	//imprime datos de PROVEEDOR
		for (int i = 0; i < proveedores.size(); i++) {
			System.out.println(proveedores.get(i).getIdentificacion());
			System.out.println(proveedores.get(i).getRazonSocial());
			System.out.println(proveedores.get(i).getEmal1() );
			System.out.println(proveedores.get(i).getTelefono() );
			System.out.println(proveedores.get(i).getNombre());
			System.out.println(proveedores.get(i).getApellido());
			System.out.println(proveedores.get(i).getEmail2() );
			System.out.println(proveedores.get(i).getCelular());
			System.out.println(proveedores.get(i).getDireccion());					
					} 
		*/
		/*List<CuentaPorPagar> cuentaxPagar=procesadorPagar.extraerCuentaPagar(excel);
		//imprime datos de CUENTAS XPAGAR
		for (int i = 0; i < cuentaxPagar.size(); i++) {
			System.out.println(cuentaxPagar.get(i).getProveedor().getIdentificacion());
		
			System.out.println(cuentaxPagar.get(i).getRubro());
			System.out.println(cuentaxPagar.get(i).getFechaFactura());
			System.out.println(cuentaxPagar.get(i).getFechaVencimiento());
			System.out.println(cuentaxPagar.get(i).getNumeroFactura());
			System.out.println(cuentaxPagar.get(i).getDetalle());
			System.out.println(cuentaxPagar.get(i).getValorPorPagar());
		
		}*/
		
	}

}
