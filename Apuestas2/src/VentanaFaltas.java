import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaFaltas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Faltas faltas;
	private boolean modifica;
	private JComboBox jFaltas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFaltas frame = new VentanaFaltas();
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
	public VentanaFaltas() {
		
		
		//Asignacion del equipo
				faltas=equipoAModificar;
				this.jLiga=jLiga;
				this.modifica=modifica;
				
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNombreJugador = new JLabel("Nombre Jugador");
		lblNombreJugador.setBounds(43, 26, 109, 14);
		
		JLabel lblTarjetasAmarillas = new JLabel("Tarjetas amarillas");
		lblTarjetasAmarillas.setBounds(43, 64, 125, 14);
		
		JLabel lblTarjetasRojas = new JLabel("Tarjetas rojas");
		lblTarjetasRojas.setBounds(43, 102, 109, 14);
		
		JLabel lblFaltas = new JLabel("Faltas");
		lblFaltas.setBounds(43, 137, 98, 14);
		
		textField = new JTextField();
		textField.setBounds(193, 23, 86, 20);
		textField.setColumns(10);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(193, 61, 86, 20);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(193, 99, 86, 20);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(193, 137, 86, 20);
		textField_3.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarFaltas();
			}
		});
		btnGuardar.setBounds(132, 204, 109, 23);
		contentPane.setLayout(null);
		contentPane.add(lblNombreJugador);
		contentPane.add(lblTarjetasAmarillas);
		contentPane.add(lblTarjetasRojas);
		contentPane.add(lblFaltas);
		contentPane.add(textField);
		contentPane.add(textField_1);
		contentPane.add(textField_2);
		contentPane.add(textField_3);
		contentPane.add(btnGuardar);
		
		//Rellenar datos del equipo al abrir la ventana
				//leerEquipo();
	}
	
	//Metodo que guarda datos en el objeto equipo
		private void guardarFaltas(){
			faltas.setNombre(textField.getText());
			faltas.setNumAmarilla(Integer.valueOf(textField_1.getText()));
			faltas.setNumRoja(Integer.valueOf(textField_2.getText()));
			faltas.setNumFaltas(Integer.valueOf(textField_3.getText()));
			if(!modifica)
				jFaltas.addItem(faltas);
			else
			{
				Faltas faltasElegidas=(Faltas)jFaltas.getSelectedItem();
				faltasElegidas.setNombre(faltas.getNombre());
			}

		}
	
	
	//Metodo que pone datos desde objeto equipo
		private void leerEquipo(){
			textField.setText(String.valueOf(faltas.getNombre()));
			textField_1.setText(String.valueOf(faltas.getNumAmarilla()));
			textField_2.setText(String.valueOf(faltas.getNumRoja()));
			textField_3.setText(String.valueOf(faltas.getNumFaltas()));

		}
}
