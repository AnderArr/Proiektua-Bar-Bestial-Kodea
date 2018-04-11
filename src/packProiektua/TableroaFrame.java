package packProiektua;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TableroaFrame extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableroaFrame frame = new TableroaFrame();
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
	public TableroaFrame() {
		this.setTitle("Bar Bestial");
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setBackground(Color.GREEN);
		Tableroa t=Tableroa.getNireTableroa();
		t.jokoaHasieratu();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 300);
		contentPane = new JPanel();
		JPanel pane= new JPanel();
		JPanel pane2= new JPanel();
		JPanel pane3= new JPanel();
		JPanel pane4= new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		KartaZerrenda kz=t.getEskuanJ1();
		KartaZerrenda kz1=t.getKola();
		KartaZerrenda kz2=t.getJ1();
		String s6,s7,s8,s9;
		if(kz.luzera()>=1){
			s6="<html>"+kz.getKarta(0).getZenbakia()+"<br>"+kz.getKarta(0).getIzena()+"<br>"+kz.getKarta(0).getKolorea()+"<br>"+kz.getKarta(0).getDeskribapena()+"</html>";
			if(kz.luzera()>=2){
				s7="<html>"+kz.getKarta(1).getZenbakia()+"<br>"+kz.getKarta(1).getIzena()+"<br>"+kz.getKarta(1).getKolorea()+"<br>"+kz.getKarta(1).getDeskribapena()+"</html>";
				if(kz.luzera()>=3){
					s8="<html>"+kz.getKarta(2).getZenbakia()+"<br>"+kz.getKarta(2).getIzena()+"<br>"+kz.getKarta(2).getKolorea()+"<br>"+kz.getKarta(2).getDeskribapena()+"</html>";
					if(kz.luzera()==4){
						s9="<html>"+kz.getKarta(3).getZenbakia()+"<br>"+kz.getKarta(3).getIzena()+"<br>"+kz.getKarta(3).getKolorea()+"<br>"+kz.getKarta(3).getDeskribapena()+"</html>";
					}else{
						s9="Ez dago.";
					}
				}else{
					s8="Ez dago.";
					s9="Ez dago.";
				}
			}else{
				s7="Ez dago.";
				s8="Ez dago.";
				s9="Ez dago.";
			}
		}else{
			s6="Ez dago.";
			s7="Ez dago.";
			s8="Ez dago.";
			s9="Ez dago.";
		}
							
		JButton btnKarta_0 = new JButton(s6);
		btnKarta_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnKarta_0.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKarta_0.setBounds(new Rectangle(100, 100, 100, 5000));
		
		JButton btnKarta_1 = new JButton(s7);
		btnKarta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
				
		btnKarta_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnKarta_2 = new JButton(s8);
		btnKarta_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnKarta_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		JButton btnKarta_3 = new JButton(s9);	
		btnKarta_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnKarta_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(btnKarta_0);
		grupo.add(btnKarta_1);
		grupo.add(btnKarta_2);
		grupo.add(btnKarta_3);
		
		contentPane.setLayout(new BorderLayout(0, 0));
		pane.setLayout(new FlowLayout());
		contentPane.add(pane, BorderLayout.SOUTH);
		contentPane.add(pane3, BorderLayout.EAST);
		contentPane.add(pane4, BorderLayout.NORTH);
		
		String gelditu = String.valueOf(kz2.luzera());
		JLabel jl5=new JLabel("<html>Geratzen zaizkizun<br> kartak: "+gelditu+"</html>");
		jl5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pane3.add(jl5);
		
		pane.add(btnKarta_0);	
		pane.add(btnKarta_1);
		pane.add(btnKarta_2);
		pane.add(btnKarta_3);
		contentPane.add(pane2, BorderLayout.CENTER);
	
		String s1,s2,s3,s4,s5;
		
		if(kz1.luzera()==0){
			s1="Ez dago.";
			s2="Ez dago.";
			s3="Ez dago.";
			s4="Ez dago.";
			s5="Ez dago.";
		}else if(kz1.luzera()==1){
			s1="<html>"+kz1.getKarta(0).getZenbakia()+"<br>"+kz.getKarta(0).getIzena()+"<br>"+kz.getKarta(0).getKolorea()+"<br>"+"</html>";
			s2="Ez dago.";
			s3="Ez dago.";
			s4="Ez dago.";
			s5="Ez dago.";
		}else  if(kz1.luzera()==2){
			s1="<html>"+kz1.getKarta(0).getZenbakia()+"<br>"+kz.getKarta(0).getIzena()+"<br>"+kz.getKarta(0).getKolorea()+"<br>"+"</html>";
			s2="<html>"+kz1.getKarta(1).getZenbakia()+"<br>"+kz.getKarta(1).getIzena()+"<br>"+kz.getKarta(1).getKolorea()+"<br>"+"</html>";
			s3="Ez dago.";
			s4="Ez dago.";
			s5="Ez dago.";
		}else  if(kz1.luzera()==3){
			s1="<html>"+kz1.getKarta(0).getZenbakia()+"<br>"+kz.getKarta(0).getIzena()+"<br>"+kz.getKarta(0).getKolorea()+"<br>"+"</html>";
			s2="<html>"+kz1.getKarta(1).getZenbakia()+"<br>"+kz.getKarta(1).getIzena()+"<br>"+kz.getKarta(1).getKolorea()+"<br>"+"</html>";
			s3="<html>"+kz1.getKarta(2).getZenbakia()+"<br>"+kz.getKarta(2).getIzena()+"<br>"+kz.getKarta(2).getKolorea()+"<br>"+"</html>";
			s4="Ez dago.";
			s5="Ez dago.";
		}else if(kz1.luzera()==4){
			s1="<html>"+kz1.getKarta(0).getZenbakia()+"<br>"+kz.getKarta(0).getIzena()+"<br>"+kz.getKarta(0).getKolorea()+"<br>"+"</html>";
			s2="<html>"+kz1.getKarta(1).getZenbakia()+"<br>"+kz.getKarta(1).getIzena()+"<br>"+kz.getKarta(1).getKolorea()+"<br>"+"</html>";
			s3="<html>"+kz1.getKarta(2).getZenbakia()+"<br>"+kz.getKarta(2).getIzena()+"<br>"+kz.getKarta(2).getKolorea()+"<br>"+"</html>";
			s4="<html>"+kz1.getKarta(3).getZenbakia()+"<br>"+kz.getKarta(3).getIzena()+"<br>"+kz.getKarta(3).getKolorea()+"<br>"+"</html>";
			s5="Ez dago.";
		}else {
			s1="<html>"+kz1.getKarta(0).getZenbakia()+"<br>"+kz.getKarta(0).getIzena()+"<br>"+kz.getKarta(0).getKolorea()+"<br>"+"</html>";
			s2="<html>"+kz1.getKarta(1).getZenbakia()+"<br>"+kz.getKarta(1).getIzena()+"<br>"+kz.getKarta(1).getKolorea()+"<br>"+"</html>";
			s3="<html>"+kz1.getKarta(2).getZenbakia()+"<br>"+kz.getKarta(2).getIzena()+"<br>"+kz.getKarta(2).getKolorea()+"<br>"+"</html>";
			s4="<html>"+kz1.getKarta(3).getZenbakia()+"<br>"+kz.getKarta(3).getIzena()+"<br>"+kz.getKarta(3).getKolorea()+"<br>"+"</html>";
			s5="<html>"+kz1.getKarta(4).getZenbakia()+"<br>"+kz.getKarta(4).getIzena()+"<br>"+kz.getKarta(4).getKolorea()+"<br>"+"</html>";
		}
		
		JLabel jl1=new JLabel(s1);
		
		jl1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel jl2=new JLabel(s2);
		jl2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel jl3=new JLabel(s3);
		jl3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel jl4=new JLabel(s4);
		jl4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel jl6=new JLabel(s5);
		jl6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pane2.add(jl1);
		pane2.add(jl2);
		pane2.add(jl3);
		pane2.add(jl4);
		pane2.add(jl6);
		pane2.setBackground(Color.green);
		
		pane2.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JLabel jl7=new JLabel ("<html>BAR BESTIAL<br></html>");
		jl7.setFont(new Font("Tahoma", Font.PLAIN, 75));
		pane4.add(jl7);
		
	}
}