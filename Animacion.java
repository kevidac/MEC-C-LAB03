import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Animacion extends JFrame implements ActionListener, ChangeListener {
    private JLabel imagenLabel;
    private ImageIcon[] imagenes;
    private int indiceImagen;
    private Timer temporizador;
    private JSlider velocidadSlider;

    public Animacion() {
        // Inicializar arreglo de imágenes
        imagenes = new ImageIcon[5];
        for (int i = 0; i < imagenes.length; i++) {
            imagenes[i] = new ImageIcon("imagenes/imagen" + (i + 1) + ".jpg");
        }

       
        imagenLabel = new JLabel(imagenes[0]);
        imagenLabel.setHorizontalAlignment(JLabel.CENTER);

     
        temporizador = new Timer(1000, this);

        // Configurar control deslizante de velocidad
        velocidadSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        velocidadSlider.setMajorTickSpacing(10);
        velocidadSlider.setMinorTickSpacing(1);
        velocidadSlider.setPaintTicks(true);
        velocidadSlider.setPaintLabels(true);
        velocidadSlider.addChangeListener(this);

        
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        contenedor.add(imagenLabel, BorderLayout.CENTER);
        contenedor.add(velocidadSlider, BorderLayout.SOUTH);

      
        setTitle("Animacion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);

       
        temporizador.start();
    }
 //parte tomada de chat gpt :)
    public void actionPerformed(ActionEvent e) {
        // Cambiar imagen
        indiceImagen++;
        if (indiceImagen == imagenes.length) {
            indiceImagen = 0;
        }
        imagenLabel.setIcon(imagenes[indiceImagen]);

        
        temporizador.setDelay(1000 / velocidadSlider.getValue());
    }

    public void stateChanged(ChangeEvent e) {
        // Actualizar velocidad del temporizador
        temporizador.setDelay(1000 / velocidadSlider.getValue());
    }

    public static void main(String[] args) {
        Animacion animacion = new Animacion();
    }
}
