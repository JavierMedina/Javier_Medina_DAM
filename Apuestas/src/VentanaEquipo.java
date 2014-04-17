import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaEquipo extends JFrame {

	private JPanel contentPane;
	private Equipo equipo;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	ObjectOutputStream salida;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEquipo frame = new VentanaEquipo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VentanaEquipo(Equipo equipoAModificar) {
		
		//Asignación del equipo
		equipo=equipoAModificar;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre del equipo");
		lblNombre.setBounds(21, 27, 109, 14);
		contentPane.add(lblNombre);
		
		JLabel lblGolesAFavor = new JLabel("Goles a favor");
		lblGolesAFavor.setBounds(21, 67, 109, 14);
		contentPane.add(lblGolesAFavor);
		
		JLabel lblGolesEnContra = new JLabel("Goles en contra");
		lblGolesEnContra.setBounds(21, 104, 109, 14);
		contentPane.add(lblGolesEnContra);
		
		JLabel lblPartidosGanados = new JLabel("Partidos ganados");
		lblPartidosGanados.setBounds(21, 148, 109, 14);
		contentPane.add(lblPartidosGanados);
		
		JLabel lblPartidosPerdidos = new JLabel("Partidos perdidos");
		lblPartidosPerdidos.setBounds(21, 192, 109, 14);
		contentPane.add(lblPartidosPerdidos);
		
		textField = new JTextField();
		textField.setBounds(167, 24, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 64, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(167, 104, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(167, 145, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(167, 189, 86, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton guardarEnFichero = new JButton("Guardar");
		guardarEnFichero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				equipo.setNombre(textField.getText());
				equipo.setGolesContra(Integer.valueOf(textField_2.getText()));
				equipo.setGolesFavor(Integer.valueOf(textField_1.getText()));
				equipo.setPartidosGanados(Integer.valueOf(textField_3.getText()));
				equipo.setPartidosPerdidos(Integer.valueOf(textField_4.getText()));
				guardarEnFichero();
			}
		});
		guardarEnFichero.setBounds(164, 228, 89, 23);
		contentPane.add(guardarEnFichero);
	}
	
	private void guardarEnFichero(){
		try// abre el fichero
		{
			salida = new ObjectOutputStream(new FileOutputStream( "equipo.ser") );
			salida.writeObject( equipo ); //envía el regsitro como salida
			if( salida != null)
				salida.close();
		}//fin de try
		catch( IOException oiException )
		{
			System.err.println("Error al abrir el archivo.");
		}// fin de catch
	}//fin del método guardarEnFichero

}
