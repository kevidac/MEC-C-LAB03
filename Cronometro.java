import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Cronometro extends JFrame implements ActionListener {
    
    private JLabel labelHora;
    private Timer timer;
    private int tiempoAlarma;
    private int tiempoRestante;
    
    public Cronometro() {
        labelHora = new JLabel();
        add(labelHora);
        
        timer = new Timer(1000, this);
        timer.start();
        
        tiempoAlarma = Integer.parseInt(JOptionPane.showInputDialog("escriba tiempo en el que suene la alarma (en segundos):"));
        tiempoRestante = tiempoAlarma;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Date horaActual = new Date();
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        String horaActualString = formatoHora.format(horaActual);
        labelHora.setText(horaActualString);
        
        tiempoRestante--;
        if (tiempoRestante == 0) {
            JOptionPane.showMessageDialog(null, "ALARMA!");
            tiempoRestante = 10;
        }
    }
    
    public static void main(String[] args) {
        Cronometro cronometro = new Cronometro();
        cronometro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cronometro.setSize(200, 100);
        cronometro.setVisible(true);
    }
}