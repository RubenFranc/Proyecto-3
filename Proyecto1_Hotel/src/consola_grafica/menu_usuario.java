package consola_grafica;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Model.Hotel;

public class menu_usuario extends JFrame implements ActionListener {
    
    public menu_usuario(Hotel hotel) {
        JFrame frame = new JFrame("Menu Usuario");
        JPanel encabezado = new JPanel();
        JPanel cuerpo = new JPanel();
        JPanel pieDePagina = new JPanel();
        JPanel izquierda = new JPanel();
        JPanel derecha = new JPanel();
        
        // Colores
        Color colorCuerpo = parametros.getColorCuerpo();
        Color colorColumna = parametros.getColorColumna();
    	Color colorDerecha = parametros.getColorDerecha();
        Color colorIzquierda = parametros.getColorIzquierda();
        Color colorTitulo = parametros.getColorTitulo();
        Color colorSubtitulo = parametros.getColorSubtitulo();
        
        // Dimensiones
        Dimension dimensionVentana = parametros.getDimensionVentana();
    	Dimension dimensionCuerpo = parametros.getDimensionCuerpo();
    	Dimension dimensionColumna = parametros.getDimensionColumna();
    	Dimension dimensionDerecha = parametros.getDimensionDerecha();
        Dimension dimensionIzquierda = parametros.getDimensionIzquierda(); 
        Dimension dimensionTitulo = parametros.getDimensionTitulo();
        Dimension dimensionSubtitulo = parametros.getDimensionSubtitulo();
        Dimension dimensionBotonBarra = parametros.getDimensionBotonBarra();
        Dimension dimensionBotonArriba = parametros.getDimensionBotonArriba();
        
        // Fuentes
        Font fuenteTitulo = parametros.getFuenteTitulo();
    	Font fuenteBotonBarra = parametros.getFuenteTitulo();
    	Font fuenteGeneral = parametros.getFuenteTitulo();
    	
    	// Set Ventana
        frame.setSize(dimensionVentana);
        frame.setLocationRelativeTo(null);
        
        // Contenido

        // Layout
        cuerpo.setLayout(new BorderLayout());
        frame.setLayout(new BorderLayout());
        
        // Botones Varios
        JButton botonAtras = new JButton("<- Atrás");
        botonAtras.setPreferredSize(dimensionBotonArriba);
        botonAtras.addActionListener(event -> {
        	
        	cuerpo.removeAll();
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
         });
        JButton botonLogout = new JButton("Logout");
        botonLogout.setPreferredSize(dimensionBotonArriba);
        botonLogout.addActionListener(event -> {
        	
        	cuerpo.removeAll();
        	frame.removeAll();
        	frame.dispose();
        	JFrame login= new loginUsuario(hotel);
        	login.setVisible(true);
        	
            
         });
        JButton botonConfirmar = new JButton("Confirmar");   
        botonConfirmar.setPreferredSize(dimensionBotonArriba);
        
        JPanel atrasPanel = new JPanel();
        atrasPanel.setLayout(new BoxLayout(atrasPanel, BoxLayout.X_AXIS));
        atrasPanel.setPreferredSize(dimensionBotonArriba);
        atrasPanel.setBackground(colorTitulo);
        atrasPanel.add(botonAtras);
        JPanel logoutPanel = new JPanel();
        logoutPanel.setLayout(new BoxLayout(logoutPanel, BoxLayout.X_AXIS));
        logoutPanel.setPreferredSize(dimensionBotonArriba);
        logoutPanel.setBackground(colorTitulo);
        logoutPanel.add(botonLogout);
        JPanel confirmarPanel = new JPanel();
        confirmarPanel.setLayout(new BoxLayout(confirmarPanel, BoxLayout.X_AXIS));
        confirmarPanel.setPreferredSize(dimensionBotonBarra);
        confirmarPanel.setBackground(colorCuerpo);
        confirmarPanel.add(Box.createVerticalGlue());
        confirmarPanel.add(Box.createHorizontalGlue());
        confirmarPanel.add(botonConfirmar);
        confirmarPanel.add(Box.createVerticalGlue());
        confirmarPanel.add(Box.createHorizontalGlue());
                
        
        // Encabezado
        encabezado.setLayout(new BorderLayout());
        JLabel titulo = new JLabel("MENÚ USUARIO", SwingConstants.CENTER);
        titulo.setFont(fuenteTitulo);
        titulo.setPreferredSize(dimensionTitulo);
        encabezado.add(titulo, BorderLayout.CENTER);
        encabezado.add(atrasPanel, BorderLayout.WEST);
        encabezado.add(logoutPanel, BorderLayout.EAST);
        encabezado.setBackground(colorTitulo);
        encabezado.setPreferredSize(dimensionTitulo);
        
        
        // Pie de Página
        pieDePagina.setBackground(colorSubtitulo);
        pieDePagina.setPreferredSize(dimensionSubtitulo);
        
        // Barra Iquierda
        
        //Pestañas
        JButton botonPestaniaHabitacionesDisponibles = new JButton("Habitaciones Diponibles");
        botonPestaniaHabitacionesDisponibles.addActionListener(event -> {
        	JPanel pestaniaHabitacionesDisponibles= usuarioPestaniaHabitacionesDisponiblesPorFecha.getPestania(hotel);
        	//pestaniaHotel.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaHotel.setLocation(0,0);
        	//pestaniaHotel.setSize(500, 400);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaHabitacionesDisponibles, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
         });
        JButton botonPestaniaCrearReserva = new JButton("Crear Reserva");
        botonPestaniaCrearReserva.addActionListener(event -> {
        	JPanel pestaniaCrearReserva= usuarioPestaniaCrearReserva.getPestania(hotel);
        	//pestaniaCrearReserva.add(confirmarPanel, BorderLayout.SOUTH);
        	//pestaniaCrearReserva.setLocation(0,0);
        	//pestaniaCrearReserva.setSize(500, 400);
        	cuerpo.removeAll();
        	cuerpo.add(pestaniaCrearReserva, BorderLayout.CENTER);
        	cuerpo.revalidate();
        	cuerpo.repaint();
            
         });
        
        botonPestaniaHabitacionesDisponibles.setPreferredSize(dimensionBotonBarra);
        botonPestaniaCrearReserva.setPreferredSize(dimensionBotonBarra);
        
        //Izquierda
        izquierda.setLayout(new FlowLayout());
        izquierda.setBackground(colorIzquierda);
        izquierda.setPreferredSize(dimensionIzquierda);
        
        izquierda.add(botonPestaniaHabitacionesDisponibles);     
        izquierda.add(botonPestaniaCrearReserva);
           
        
        // Derecha
         
        derecha.setBackground(colorDerecha);
        derecha.setPreferredSize(dimensionDerecha);
        
        // Cuerpo
        cuerpo.setBackground(colorCuerpo);
        cuerpo.setPreferredSize(dimensionCuerpo);
        cuerpo.setLayout(new BorderLayout());
        
        // Frame
        frame.add(encabezado, BorderLayout.NORTH);
        frame.add(cuerpo, BorderLayout.CENTER);
        frame.add(pieDePagina, BorderLayout.SOUTH);
        frame.add(izquierda, BorderLayout.WEST);
        frame.add(derecha, BorderLayout.EAST);

        // Set Close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Make visible
        frame.setVisible(true);
    }
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
