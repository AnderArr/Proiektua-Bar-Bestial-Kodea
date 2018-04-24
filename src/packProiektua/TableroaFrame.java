package packProiektua;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TableroaFrame extends JFrame implements Observer{

	private JPanel contentPane;
	private JPanel paneKamalehoia;
	private JPanel paneEskua;
	private JPanel paneKola;
	private JPanel paneKanguroa;
	private JPanel paneLoroa;
	//private JPanel pane3;
	private JPanel paneTitulua;
	private JPanel botoiak;
	private JButton btnKarta_0;
	private JButton btnKarta_1;
	private JButton btnKarta_2;
	private JButton btnKarta_3;
	private JButton btnKama1;
	private JButton btnKama2;
	private JButton btnKama3;
	private JButton btnKama4;
	private JButton btnKama5;
	private JLabel kolabel1;
	private JLabel kolabel2;
	private JLabel kolabel3;
	private JLabel kolabel4;
	private JLabel kolabel5;
	private JLabel titulua;
	private JLabel zenbat;
	private JButton btnKanguro1;
	private JButton btnKanguro2;
	private JButton btnLoro1;
	private JButton btnLoro2;
	private JButton btnLoro3;
	private JButton btnLoro4;
	private JButton btnLoro5;
	private JLabel irabazi;
	
	private static TableroaFrame frame;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new TableroaFrame();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public void update(Observable o, Object arg) {
		//arg
		ArrayList<String> bz=((ArrayList<String>) arg);
		ArrayList<String> kola=new ArrayList<String>();
		ArrayList<String> eskua=new ArrayList<String>();
		int i=0;
		while((i<bz.size())&&(!bz.get(i).equals("/"))){
			kola.add(bz.get(i));
			i++;
		}
		i++;
		while(i<bz.size()){
			eskua.add(bz.get(i));
			i++;
		}
		
		//eskua
		String s6,s7,s8,s9;
		if(eskua.size()>=1){
			s6=eskua.get(0);
			if(eskua.size()>=2){
				s7=eskua.get(1);
				if(eskua.size()>=3){
					s8=eskua.get(2);
					if(eskua.size()==4){
						s9=eskua.get(3);
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
		
		btnKarta_0.setText(s6);
		btnKarta_1.setText(s7);
		btnKarta_2.setText(s8);
		btnKarta_3.setText(s9);
		
		//kola
		
		String s1,s2,s3,s4,s5;
		if(kola.size()>0){
			s1=kola.get(0);
			if(kola.size()>1){
				s2=kola.get(1);
				if(kola.size()>2){
					s3=kola.get(2);
					if(kola.size()>3){
						s4=kola.get(3);
						if(kola.size()>4){
							s5=kola.get(4);
						}else{
							s5="Ez dago.";
						}
					}else{
						s4="Ez dago.";
						s5="Ez dago.";
					}
				}else{
					s3="Ez dago.";
					s4="Ez dago.";
					s5="Ez dago.";
				}
			}else{
				s2="Ez dago.";
				s3="Ez dago.";
				s4="Ez dago.";
				s5="Ez dago.";
			}
		}else{
			s1="Ez dago.";
			s2="Ez dago.";
			s3="Ez dago.";
			s4="Ez dago.";
			s5="Ez dago.";
		}
		kolabel1.setText(s1);
		kolabel2.setText(s2);
		kolabel3.setText(s3);
		kolabel4.setText(s4);
		kolabel5.setText(s5);		
				
						
						
					    
						
						
						
						
				
    }

	/**
	 * Create the frame.
	 */
	public TableroaFrame() {
		
		this.setTitle("Bar Bestial");
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setBackground(Color.GREEN);
		Tableroa t=Tableroa.getNireTableroa();
		t.addObserver(this);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 300);
		
		contentPane = new JPanel();
		contentPane.setVisible(false);
		paneEskua= new JPanel();
		paneKola= new JPanel();
		paneKanguroa=new JPanel();
		paneKanguroa.setVisible(false);
		paneKamalehoia=new JPanel();
		paneKamalehoia.setVisible(false);
		paneLoroa=new JPanel();
		paneLoroa.setVisible(false);
		//pane3= new JPanel();
		paneTitulua= new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
		
        btnKarta_0 = new JButton();
		
		btnKarta_0.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKarta_0.setBounds(new Rectangle(100, 100, 100, 5000));
		btnKarta_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((!paneKanguroa.isVisible())&&(!paneLoroa.isVisible())&&(!paneKamalehoia.isVisible())){
					botoiPultsatu(0);
				}
			}
		});
		
		
		
		
		btnKarta_1 = new JButton();
		btnKarta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((!paneKanguroa.isVisible())&&(!paneLoroa.isVisible())&&(!paneKamalehoia.isVisible())){
					botoiPultsatu(1);
				}
			}
		});
		
		
		
		
		
		
		
		btnKarta_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		btnKarta_2 = new JButton();
		btnKarta_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((!paneKanguroa.isVisible())&&(!paneLoroa.isVisible())&&(!paneKamalehoia.isVisible())){
					botoiPultsatu(2);
				}
			}
		});
		btnKarta_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		btnKarta_3 = new JButton();	
		btnKarta_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((!paneKanguroa.isVisible())&&(!paneLoroa.isVisible())&&(!paneKamalehoia.isVisible())){
					botoiPultsatu(3);
				}
			}
		});
		btnKarta_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		
				

				//panela
				
				contentPane.setLayout(new BorderLayout(0, 0));
				paneEskua.setLayout(new FlowLayout());
				contentPane.add(paneEskua, BorderLayout.SOUTH);
				//contentPane.add(pane3, BorderLayout.EAST);
				contentPane.add(paneTitulua, BorderLayout.NORTH);
				
				/*String gelditu = String.valueOf(kz2.luzera());
				JLabel jl5=new JLabel("<html>Geratzen zaizkizun<br> kartak: "+gelditu+"</html>");
				jl5.setFont(new Font("Tahoma", Font.PLAIN, 20));
				
				pane3.add(jl5);*/
				
				paneEskua.add(btnKarta_0);	
				paneEskua.add(btnKarta_1);
				paneEskua.add(btnKarta_2);
				paneEskua.add(btnKarta_3);
				
				
				
				
				
				titulua=new JLabel ("<html>BAR BESTIAL<br></html>");
				titulua.setFont(new Font("Tahoma", Font.PLAIN, 75));
				paneTitulua.add(titulua);
				contentPane.add(paneKola, BorderLayout.CENTER);
				contentPane.setVisible(true);
				
				kolabel1=new JLabel();
				kolabel1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				kolabel1.setBorder(BorderFactory.createLineBorder(Color.black));
				kolabel2=new JLabel();
				kolabel2.setFont(new Font("Tahoma", Font.PLAIN, 20));
				kolabel2.setBorder(BorderFactory.createLineBorder(Color.black));
				kolabel3=new JLabel();
				kolabel3.setFont(new Font("Tahoma", Font.PLAIN, 20));
				kolabel3.setBorder(BorderFactory.createLineBorder(Color.black));
				kolabel4=new JLabel();
				kolabel4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				kolabel4.setBorder(BorderFactory.createLineBorder(Color.black));
				kolabel5=new JLabel();
				kolabel5.setFont(new Font("Tahoma", Font.PLAIN, 20));
				kolabel5.setBorder(BorderFactory.createLineBorder(Color.black));
				paneKola.add(kolabel1);
				paneKola.add(kolabel2);
				paneKola.add(kolabel3);
				paneKola.add(kolabel4);
				paneKola.add(kolabel5);
				paneKola.setBackground(Color.green);
				
				paneKola.setBorder(BorderFactory.createLineBorder(Color.black));
				t.jokoaHasieratu();
			
					
				
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public void kamalehoiaAtxitu(int aux){
		Tableroa t=Tableroa.getNireTableroa();
		paneKola.setVisible(false);
		paneKamalehoia.setVisible(true);
		contentPane.add(paneKamalehoia, BorderLayout.CENTER);
		paneKamalehoia.setBackground(Color.green);
		if(!kolabel1.getText().equals("Ez dago.")&&(!t.kamalehoiaDa(kolabel1.getText()))){
			btnKama1=new JButton(kolabel1.getText());
			btnKama1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			paneKamalehoia.add(btnKama1);
		}
		if(!kolabel2.getText().equals("Ez dago.")&&(!t.kamalehoiaDa(kolabel2.getText()))){
			btnKama2=new JButton(kolabel2.getText());
			btnKama2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			paneKamalehoia.add(btnKama2);
		}
		if(!kolabel3.getText().equals("Ez dago.")&&(!t.kamalehoiaDa(kolabel3.getText()))){
			btnKama3=new JButton(kolabel3.getText());
			btnKama3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			paneKamalehoia.add(btnKama3);
		}
		if(!kolabel4.getText().equals("Ez dago.")&&(!t.kamalehoiaDa(kolabel4.getText()))){
			btnKama4=new JButton(kolabel4.getText());
			btnKama4.setFont(new Font("Tahoma", Font.PLAIN, 20));
			paneKamalehoia.add(btnKama4);
		}
		if(!kolabel5.getText().equals("Ez dago.")&&(!t.kamalehoiaDa(kolabel5.getText()))){
			btnKama5=new JButton(kolabel5.getText());
			btnKama5.setFont(new Font("Tahoma", Font.PLAIN, 20));
			paneKamalehoia.add(btnKama5);
		}
		
		btnKama1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(t.loroaDaKolan(0)){
					loroaAtxitu(aux);
				}else{
					if(t.kanguroaDaKolan(0)){
						kanguroaAtxitu(aux);
					}else{
						t.txandaJokatu(aux, 0);
					}
				}
				paneKamalehoia.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
			}
		});
		btnKama2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(t.loroaDaKolan(1)){
					loroaAtxitu(aux);
				}else{
					if(t.kanguroaDaKolan(1)){
						kanguroaAtxitu(aux);
					}else{
						t.txandaJokatu(aux, 1);
					}
				}
				paneKamalehoia.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
			}
		});
		btnKama3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(t.loroaDaKolan(2)){
					loroaAtxitu(aux);
				}else{
					if(t.kanguroaDaKolan(2)){
						kanguroaAtxitu(aux);
					}else{
						t.txandaJokatu(aux, 2);
					}
				}
				paneKamalehoia.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
			}
		});
		btnKama4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(t.loroaDaKolan(3)){
					loroaAtxitu(aux);
				}else{
					if(t.kanguroaDaKolan(3)){
						kanguroaAtxitu(aux);
					}else{
						t.txandaJokatu(aux, 3);
					}
				}
				paneKamalehoia.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
			}
		});
		btnKama5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(t.loroaDaKolan(4)){
					paneKamalehoia.setVisible(false);
					loroaAtxitu(aux);
				}else{
					if(t.kanguroaDaKolan(4)){
						paneKamalehoia.setVisible(false);
						kanguroaAtxitu(aux);
					}else{
						t.txandaJokatu(aux, 4);
					}
				}
				paneKamalehoia.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
			}
		});
		
	}
	
	public void kanguroaAtxitu(int aux){
		Tableroa t=Tableroa.getNireTableroa();
		paneKamalehoia.setVisible(false);
		paneKamalehoia.updateUI();
		paneKanguroa.setVisible(true);
		contentPane.add(paneKanguroa, BorderLayout.EAST);
		paneKanguroa.setLayout(new BorderLayout());
		zenbat=new JLabel("Zenbat salto nahi dituzu?");
		zenbat.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnKanguro1=new JButton ("1");
		btnKanguro1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnKanguro2=new JButton("2");
		btnKanguro2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		botoiak=new JPanel();
		botoiak.add(btnKanguro1);
		botoiak.add(btnKanguro2);
		paneKanguroa.add(zenbat,BorderLayout.NORTH);
		paneKanguroa.add(botoiak,BorderLayout.CENTER);
		paneKanguroa.updateUI();
		btnKanguro1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux, 1);
				paneKanguroa.setVisible(false);
				bukatutaAhalDago();
			}
		});
		btnKanguro2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux, 2);
				paneKanguroa.setVisible(false);
				bukatutaAhalDago();
			}
		});
		
	}
	
	public void loroaAtxitu(int aux){
		Tableroa t=Tableroa.getNireTableroa();
		
		paneKola.setVisible(false);
		paneLoroa.setVisible(true);
		contentPane.add(paneLoroa, BorderLayout.CENTER);
		paneLoroa.setBackground(Color.green);
		if(!kolabel1.getText().equals("Ez dago.")){
			btnLoro1=new JButton(kolabel1.getText());
			btnLoro1.setFont(new Font("Tahoma", Font.PLAIN, 20));
			paneLoroa.add(btnLoro1);
		}
		if(!kolabel2.getText().equals("Ez dago.")){
			btnLoro2=new JButton(kolabel2.getText());
			btnLoro2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			paneLoroa.add(btnLoro2);
		}
		if(!kolabel3.getText().equals("Ez dago.")){
			btnLoro3=new JButton(kolabel3.getText());
			btnLoro3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			paneLoroa.add(btnLoro3);
		}
		if(!kolabel4.getText().equals("Ez dago.")){
			btnLoro4=new JButton(kolabel4.getText());
			btnLoro4.setFont(new Font("Tahoma", Font.PLAIN, 20));
			paneLoroa.add(btnLoro4);
		}
		if(!kolabel5.getText().equals("Ez dago.")){
			btnLoro5=new JButton(kolabel5.getText());
			btnLoro5.setFont(new Font("Tahoma", Font.PLAIN, 20));
			paneLoroa.add(btnLoro5);
		}
		btnLoro1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux, 0);
				paneLoroa.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
			}
		});
		btnLoro2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux, 1);
				paneLoroa.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
			}
		});
		btnLoro3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux, 2);
				paneLoroa.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
			}
		});
		btnLoro4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux, 3);
				paneLoroa.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
			}
		});
		btnLoro5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux, 4);
				paneLoroa.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
			}
		});
		
	}
	
	public void botoiPultsatu(int i){
		Tableroa t=Tableroa.getNireTableroa();
		if(t.daudeKartak()){
			if(t.kamalehoiaDa(i)){
		
				kamalehoiaAtxitu(i);
			}else{
				if(t.loroaDa(i)){
					loroaAtxitu(i);
				}else{
					if(t.kanguroaDa(i)){
						kanguroaAtxitu(i);
					}else{
						t.txandaJokatu(i, 0);
					}
				}
			}
		}else{
			t.txandaJokatu(i, 0);
		}
		if(!t.kartakGeratuEskuan()){
			paneKola.setVisible(false);
			paneEskua.setVisible(false);
			irabazi=new JLabel();
			contentPane.add(irabazi,BorderLayout.CENTER);
			irabazi.setText("                                       "+t.irabazleaLortu());
			irabazi.setFont(new Font("Tahoma", Font.PLAIN, 75));
			irabazi.setVisible(true);
			contentPane.updateUI();
		}
		bukatutaAhalDago();
	}
	
	public void bukatutaAhalDago(){
		Tableroa t=Tableroa.getNireTableroa();
		if(!t.kartakGeratuEskuan()){
			paneKola.setVisible(false);
			paneEskua.setVisible(false);
			irabazi=new JLabel();
			contentPane.add(irabazi,BorderLayout.CENTER);
			irabazi.setText("                               "+t.irabazleaLortu());
			irabazi.setFont(new Font("Tahoma", Font.PLAIN, 75));
			irabazi.setVisible(true);
			contentPane.updateUI();
		}
	}
	
	

}
