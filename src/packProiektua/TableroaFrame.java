package packProiektua;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;


public class TableroaFrame extends JFrame implements Observer{
	private JPanel contentPane;
	private JPanel paneKamalehoia;
	private JPanel paneEskua;
	private JPanel paneKola;
	private JPanel paneKola1;
	private JPanel paneKanguroa;
	private JPanel paneLoroa;
	private JPanel paneKanguroaKamalehoia;
	private JPanel paneMenu;
	private JPanel paneLogin;
	//private JPanel pane3;
	private JPanel paneTitulua;
	private JPanel botoiak;
	private JPanel botoiak2;
	private JPanel paneRanking;
	private JLabel bar;
	private JPanel erabilAldatu;
	private JPanel baneatu;
	private JPanel kartaSortu;
	private JButton btnKarta_0;
	private JButton btnKarta_1;
	private JButton btnKarta_2;
	private JButton btnKarta_3;
	private JButton btnKama1;
	private JButton btnKama2;
	private JButton btnKama3;
	private JButton btnKama4;
	private JButton btnKama5;
	private JButton btnMenu;
	private JButton btnMenu2;
	private JButton btnMenu3;
	private JButton btnMenu4;
	private JButton btnMenu5;
	private JButton btnMenu6;
	private JButton btnMenu7;
	private JButton btnMenu8;
	private JButton btnLogin;
	private JButton btnLogin2;
	private JButton btnErre;
	private JLabel loginLabel;
	private JLabel loginLabel2;
	private JLabel kolabel1;
	private JLabel kolabel2;
	private JLabel kolabel3;
	private JLabel kolabel4;
	private JLabel kolabel5;
	private JLabel titulua;
	private JLabel zenbat;
	private JLabel zenbat2;
	private JLabel erabiltzaile;
	private JLabel pasahitza;
	private JLabel pasahitza2;
	private JLabel izena;
	private JLabel abizena;
	private JLabel jaio;
	private JLabel hilabeteJaio;
	private JLabel egunaJaio;
	private JLabel mota;
	private JLabel email;
	private JComboBox jaio2;
	private JComboBox hilabeteJaio2;
	private JComboBox egunaJaio2;
	private JButton btnKanguro1;
	private JButton btnKanguro2;
	private JButton btnKanguro3;
	private JButton btnKanguro4;
	private JButton btnLoro1;
	private JButton btnLoro2;
	private JButton btnLoro3;
	private JButton btnLoro4;
	private JButton btnLoro5;
	private JButton btnErre2;
	private JLabel irabazi;
	private JLabel atea;
	private JLabel patada;
	private TextField tf;
	private TextField izenaTF;
	private TextField abizenaTF;
	private TextField emailTF;
	private JPasswordField tf2;
	private JPasswordField tf3;
	private JComboBox mota2;
	private String erabiltzailea;
	private ZonedDateTime hOrdua;
	
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
		
		if(eskua.size()>=1){
			btnKarta_0.setVisible(true);
			btnKarta_0.setIcon(new ImageIcon(eskua.get(0)));
			if(eskua.size()>=2){
				btnKarta_1.setVisible(true);
				btnKarta_1.setIcon(new ImageIcon(eskua.get(1)));
				if(eskua.size()>=3){
					btnKarta_2.setVisible(true);
					btnKarta_2.setIcon(new ImageIcon(eskua.get(2)));
					if(eskua.size()==4){
						btnKarta_3.setVisible(true);
						btnKarta_3.setIcon(new ImageIcon(eskua.get(3)));
					}else{
						btnKarta_3.setVisible(false);
					}
				}else{
					btnKarta_3.setVisible(false);
					btnKarta_2.setVisible(false);
				}
			}else{
				btnKarta_3.setVisible(false);
				btnKarta_2.setVisible(false);
				btnKarta_1.setVisible(false);
			}
		}else{
			btnKarta_3.setVisible(false);
			btnKarta_2.setVisible(false);
			btnKarta_1.setVisible(false);
			btnKarta_0.setVisible(false);
		}
		
		
		
		//kola
		
		
		if(kola.size()>0){
			kolabel1.setVisible(true);
			kolabel1.setIcon(new ImageIcon(kola.get(0)));
			if(kola.size()>1){
				kolabel2.setVisible(true);
				kolabel2.setIcon(new ImageIcon(kola.get(1)));
				if(kola.size()>2){
					kolabel3.setVisible(true);
					kolabel3.setIcon(new ImageIcon(kola.get(2)));
					if(kola.size()>3){
						kolabel4.setVisible(true);
						kolabel4.setIcon(new ImageIcon(kola.get(3)));
						if(kola.size()>4){
							kolabel5.setVisible(true);
							kolabel5.setIcon(new ImageIcon(kola.get(4)));
						}else{
							kolabel5.setVisible(false);
						}
					}else{
						kolabel4.setVisible(false);
						kolabel5.setVisible(false);
					}
				}else{
					kolabel3.setVisible(false);
					kolabel4.setVisible(false);
					kolabel5.setVisible(false);
				}
			}else{
				kolabel2.setVisible(false);
				kolabel3.setVisible(false);
				kolabel4.setVisible(false);
				kolabel5.setVisible(false);
			}
		}else{
			kolabel1.setVisible(false);
			kolabel2.setVisible(false);
			kolabel3.setVisible(false);
			kolabel4.setVisible(false);
			kolabel5.setVisible(false);
		}			
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
		
		paneKanguroaKamalehoia=new JPanel();
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
		paneKanguroaKamalehoia.setVisible(false);
		//pane3= new JPanel();
		paneTitulua= new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	
        btnKarta_0 = new JButton();
		
		btnKarta_0.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKarta_0.setBounds(new Rectangle(100, 100, 100, 5000));
		btnKarta_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((!paneKanguroa.isVisible())&&(!paneLoroa.isVisible())&&(!paneKamalehoia.isVisible())&&(!paneKanguroaKamalehoia.isVisible())){
					botoiPultsatu(0);
				}
			}
		});
		
		btnKarta_1 = new JButton();
		btnKarta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((!paneKanguroa.isVisible())&&(!paneLoroa.isVisible())&&(!paneKamalehoia.isVisible())&&(!paneKanguroaKamalehoia.isVisible())){
					botoiPultsatu(1);
				}
			}
		});
		
		btnKarta_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		btnKarta_2 = new JButton();
		btnKarta_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((!paneKanguroa.isVisible())&&(!paneLoroa.isVisible())&&(!paneKamalehoia.isVisible())&&(!paneKanguroaKamalehoia.isVisible())){
					botoiPultsatu(2);
				}
			}
		});
		btnKarta_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		btnKarta_3 = new JButton();	
		btnKarta_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if((!paneKanguroa.isVisible())&&(!paneLoroa.isVisible())&&(!paneKamalehoia.isVisible())&&(!paneKanguroaKamalehoia.isVisible())){
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
				
				atea=new JLabel(new ImageIcon("C:/Kartak/atea.png"));
				
				patada=new JLabel(new ImageIcon("C:/Kartak/patada.png"));
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
				paneKola.setLayout(new BorderLayout());
				paneKola.add(atea, BorderLayout.WEST);
				paneKola1=new JPanel();
				paneKola1.setBackground(Color.green);
				paneKola1.add(kolabel1);
				paneKola1.add(kolabel2);
				paneKola1.add(kolabel3);
				paneKola1.add(kolabel4);
				paneKola1.add(kolabel5);
				paneKola.add(paneKola1, BorderLayout.CENTER);
				paneKola.add(patada, BorderLayout.EAST);
				paneKola.setBackground(Color.green);
				contentPane.add(paneKola, BorderLayout.CENTER);
				paneKola.setBorder(BorderFactory.createLineBorder(Color.black));
				paneKola.setVisible(false);
				paneEskua.setVisible(false);
				paneMenu=new JPanel();
				btnMenu=new JButton("Partida Berria");
				btnMenu.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btnMenu2=new JButton("Ranking");
				btnMenu2.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btnMenu3=new JButton("Ranking2");
				btnMenu3.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btnMenu4=new JButton("Ranking3");
				btnMenu4.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btnMenu5=new JButton("Ranking4");
				btnMenu5.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btnMenu6=new JButton("Administratzailea Aldatu");
				btnMenu6.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btnMenu7=new JButton("Erabiltzaile Bat Baneatu");
				btnMenu7.setFont(new Font("Tahoma", Font.PLAIN, 50));
				btnMenu8=new JButton("Karta sortu");
				btnMenu8.setFont(new Font("Tahoma", Font.PLAIN, 50));
				paneMenu.setLayout(null);
				paneMenu.add(btnMenu);
				btnMenu.setSize(btnMenu6.getPreferredSize());
				btnMenu.setLocation(700, 200);
				btnMenu2.setSize(btnMenu6.getPreferredSize());
				btnMenu2.setLocation(700, 300);
				btnMenu3.setSize(btnMenu6.getPreferredSize());
				btnMenu3.setLocation(700, 400);
				btnMenu4.setSize(btnMenu6.getPreferredSize());
				btnMenu4.setLocation(700, 500);
				btnMenu5.setSize(btnMenu6.getPreferredSize());
				btnMenu5.setLocation(700, 600);
				btnMenu6.setSize(btnMenu6.getPreferredSize());
				btnMenu6.setLocation(700, 700);
				btnMenu7.setSize(btnMenu6.getPreferredSize());
				btnMenu7.setLocation(700, 800);
				btnMenu8.setSize(btnMenu6.getPreferredSize());
				btnMenu8.setLocation(700, 900);
				paneMenu.add(btnMenu2);
				paneMenu.add(btnMenu3);
				paneMenu.add(btnMenu4);
				paneMenu.add(btnMenu5);
				
				paneMenu.setVisible(true);
				paneLogin=new JPanel();
				loginLabel=new JLabel("Erabiltzailea: ");
				tf=new TextField();
				loginLabel2=new JLabel("Pasahitza: ");
				tf2=new JPasswordField();
				btnLogin=new JButton("Sartu");
				btnLogin2=new JButton("Erabiltzaile berria");
				btnLogin2.setSize(btnMenu.getPreferredSize());
				btnLogin2.setLocation(750, 700);
				
				erabiltzaile=new JLabel("Erabiltzailea: ");
				izena=new JLabel("Izena: ");
				abizena= new JLabel("Abizena: ");
				jaio= new JLabel("Jaiotze-urtea: ");
				hilabeteJaio=new JLabel("Jaiotze-hilabetea: ");
				egunaJaio=new JLabel("Jaiotze-eguna: ");
				mota=new JLabel("Mota: ");
				email=new JLabel("Email: ");
				pasahitza=new JLabel("Pasahitza: ");
				
				mota2=new JComboBox();
				jaio2=new JComboBox();
				hilabeteJaio2=new JComboBox();
				egunaJaio2=new JComboBox();
				for(int i=2018;i>=1800;i--) {
		            jaio2.addItem(String.valueOf(i));
		        }
				for(int i=1;i<=12;i++) {
		            hilabeteJaio2.addItem(String.valueOf(i));
		        }
				for(int i=1;i<=31;i++) {
		            egunaJaio2.addItem(String.valueOf(i));
		        }
				emailTF=new TextField();
				izenaTF=new TextField();
				abizenaTF=new TextField();
				btnErre=new JButton("Sortu");
				paneLogin.setLayout(new GridLayout(5,2,8,8));
				paneLogin.add(loginLabel);
				paneLogin.add(tf);
				paneLogin.add(loginLabel2);
				paneLogin.add(tf2);
				paneLogin.add(btnLogin);
				paneLogin.add(btnLogin2);
				
				setContentPane(paneLogin);
				btnLogin.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						Tableroa t=Tableroa.getNireTableroa();
						try {
							if(t.ondoDago(tf.getText(),new String(tf2.getPassword()))){
								erabiltzailea=tf.getText();
								paneLogin.setVisible(false);
								setContentPane(paneMenu);
								try {
									if(t.administratzaileaDa(erabiltzailea)){
										paneMenu.add(btnMenu6);
										paneMenu.add(btnMenu7);
										paneMenu.add(btnMenu8);
										
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								paneMenu.setVisible(true);
								erabiltzailea=tf.getText();
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
				});
				btnLogin2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						paneLogin.setLayout(new GridLayout(9,2,8,8));
						paneLogin.remove(btnLogin);
						paneLogin.remove(btnLogin2);
						paneLogin.remove(loginLabel2);
						paneLogin.remove(tf2);
						paneLogin.add(izena);
						paneLogin.add(izenaTF);
						paneLogin.add(abizena);
						paneLogin.add(abizenaTF);
						paneLogin.add(email);
						paneLogin.add(emailTF);
						paneLogin.add(jaio);
						paneLogin.add(jaio2);
						paneLogin.add(hilabeteJaio);
						paneLogin.add(hilabeteJaio2);
						paneLogin.add(egunaJaio);
						paneLogin.add(egunaJaio2);
						
						paneLogin.add(loginLabel2);
						paneLogin.add(tf2);
						
						btnErre=new JButton("Sortu");
						paneLogin.add(btnErre);
					
						paneLogin.updateUI();
						btnErre.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent arg0){
								try {
									if((!t.existitzenDa(tf.getText()))&&(tf.getText().length()!=0)&&(izenaTF.getText().length()!=0)&&(abizenaTF.getText().length()!=0)&&(new String(tf2.getPassword()).length()!=0)&&(emailTF.getText().length()!=0)){
										String s=tf.getText();
										erabiltzailea=s;
										String s1=izenaTF.getText();
										String s2=abizenaTF.getText();
										String s3=emailTF.getText();
										String s4=(String) jaio2.getSelectedItem();
										String s5=(String) hilabeteJaio2.getSelectedItem();
										String s6=(String) egunaJaio2.getSelectedItem();
										String s7=new String(tf2.getPassword());
										t.erabiltzaileBerria(s,s1,s2,s3,s4,s5,s6,s7);
										paneLogin.setVisible(false);
									    setContentPane(paneMenu);
									    paneMenu.setVisible(true);
									
									}
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						});	
					}
				});
				btnMenu.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						paneMenu.setVisible(false);
						setContentPane(contentPane);
						paneKola.setVisible(true);
						paneEskua.setVisible(true);
						contentPane.setVisible(true);
						t.jokoaHasieratu();
						contentPane.updateUI();
						hOrdua=ZonedDateTime.now();
						
					}
				});
				paneRanking=new JPanel();
				
				btnMenu2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						
						paneRanking.setVisible(true);
						setContentPane(paneRanking);
						paneMenu.setVisible(false);
						ArrayList<String> z=new ArrayList<String>();
						try {
							z=t.ranking(erabiltzailea);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						int ind=0;
						
						while((ind<z.size())){
							
							String s=z.get(ind);
							JLabel jl=new JLabel(s);
							paneRanking.add(jl);
							ind++;
						}
						paneRanking.updateUI();
					}
				});
				btnMenu3.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						
						paneRanking.setVisible(true);
						setContentPane(paneRanking);
						paneMenu.setVisible(false);
						ArrayList<String> z=new ArrayList<String>();
						try {
							z=t.ranking2(erabiltzailea);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						int ind=0;
						
						while((ind<z.size())){
							
							String s=z.get(ind);
							JLabel jl=new JLabel(s);
							paneRanking.add(jl);
							ind++;
						}
					
						
						paneRanking.updateUI();
					}
				});
				btnMenu4.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						
						paneRanking.setVisible(true);
						setContentPane(paneRanking);
						paneMenu.setVisible(false);
						ArrayList<String> z=new ArrayList<String>();
						try {
							z=t.ranking3(erabiltzailea);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						int ind=0;
						
						while((ind<z.size())){
							
							String s=z.get(ind);
							JLabel jl=new JLabel(s);
							paneRanking.add(jl);
							ind++;
						}
					
						
						paneRanking.updateUI();
					}
				});
				btnMenu5.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						
						paneRanking.setVisible(true);
						setContentPane(paneRanking);
						paneMenu.setVisible(false);
						ArrayList<String> z=new ArrayList<String>();
						try {
							z=t.ranking4(erabiltzailea);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						int ind=0;
						
						while((ind<z.size())){
							
							String s=z.get(ind);
							JLabel jl=new JLabel(s);
							paneRanking.add(jl);
							ind++;
						}
					
						
						paneRanking.updateUI();
					}
				});
				btnMenu6.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						erabilAldatu=new JPanel();
						erabilAldatu.setVisible(true);
						setContentPane(erabilAldatu);
						paneMenu.setVisible(false);
						JLabel izena=new JLabel("Erabiltzaile izena: ");
						TextField izen=new TextField();
						JLabel adminMota=new JLabel("Ze mota jarri nahi diozu?");
						JComboBox admin=new JComboBox();
						admin.addItem("ADMINISTRATZAILEA");
						admin.addItem("ERABILTZAILEA");
						JButton aldatu=new JButton("Aldatu");
						
						erabilAldatu.setLayout(new GridLayout(3,2));
						erabilAldatu.add(izena);
						erabilAldatu.add(izen);
						erabilAldatu.add(adminMota);
						erabilAldatu.add(admin);
						erabilAldatu.add(aldatu);
						erabilAldatu.updateUI();
						
						aldatu.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent arg0){
								try {
									if(t.existitzenDa(izen.getText())&&(izen.getText().length()!=0)){
										t.administratzaileaAldatu(izen.getText(), (String) admin.getSelectedItem());
										paneMenu.setVisible(true);
										setContentPane(paneMenu);
									}
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						});
					}
				});
				btnMenu7.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						baneatu=new JPanel();
						baneatu.setVisible(true);
						setContentPane(baneatu);
						baneatu.updateUI();
						JLabel izena=new JLabel("Erabiltzaile izena: ");
						TextField izen=new TextField();
						JButton aldatu2=new JButton("Aldatu");
						baneatu.setLayout(new GridLayout(2,2));
						baneatu.add(izena);
						baneatu.add(izen);
						baneatu.add(aldatu2);
						aldatu2.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent arg0){
								try {
									if(t.existitzenDa(izen.getText())&&(izen.getText().length()!=0)){
										t.baneatu(izen.getText());
										paneMenu.setVisible(true);
										setContentPane(paneMenu);
									}
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						});

					}
				});
	btnMenu8.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						
						kartaSortu=new JPanel();
						kartaSortu.setVisible(true);
						setContentPane(kartaSortu);
						paneMenu.setVisible(false);
						JLabel izena=new JLabel("Karta izena: ");
						TextField izen=new TextField();
						JLabel zenbaki=new JLabel("Ze zenbaki jarri nahi diozu?");
						JComboBox zenb=new JComboBox();
						for(int i=1;i<=12;i++) {
				            zenb.addItem(String.valueOf(i));
				        }
						JLabel azalpena=new JLabel("Azalpena: ");
						TextField azalpen=new TextField();
						JLabel puntuazioa=new JLabel("Ze zenbaki jarri nahi diozu?");
						JComboBox punt=new JComboBox();
						for(int i=1;i<=12;i++) {
				            punt.addItem(String.valueOf(i));
				        }
						JLabel originala=new JLabel("Originala da? ");
						JComboBox orig=new JComboBox();
						orig.addItem("BAI");
						orig.addItem("EZ");
						JButton aldatu3=new JButton("Aldatu");
						
						kartaSortu.setLayout(new GridLayout(6,2));
						kartaSortu.add(izena);
						kartaSortu.add(izen);
						kartaSortu.add(zenbaki);
						kartaSortu.add(zenb);
						kartaSortu.add(azalpena);
						kartaSortu.add(azalpen);
						kartaSortu.add(puntuazioa);
						kartaSortu.add(punt);
						kartaSortu.add(originala);
						kartaSortu.add(orig);
						kartaSortu.add(aldatu3);
						kartaSortu.updateUI();
					
						aldatu3.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent arg0){
								try {
									if((izen.getText().length()!=0)&&(azalpen.getText().length()!=0)){
										String s;
										if(orig.getSelectedItem()=="BAI"){
											s="1";
										}else{
											s="0";
										}
										t.kartaSortu(izen.getText(), (String) zenb.getSelectedItem(), azalpen.getText(), (String) punt.getSelectedItem(), s);
										paneMenu.setVisible(true);
										setContentPane(paneMenu);
									}
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
						});
						

					}
				});	
	}
	
	public void kamalehoiaAtxitu(int aux){
		Tableroa t=Tableroa.getNireTableroa();
		paneKola.setVisible(false);
		paneKamalehoia.setVisible(true);
		contentPane.add(paneKamalehoia, BorderLayout.CENTER);
		paneKamalehoia.setBackground(Color.green);
		if(kolabel1.isVisible()){
			btnKama1=new JButton(kolabel1.getIcon());
			paneKamalehoia.add(btnKama1);
		}
		if(kolabel2.isVisible()){
			btnKama2=new JButton(kolabel2.getIcon());
			paneKamalehoia.add(btnKama2);
		}
		if(kolabel3.isVisible()){
			btnKama3=new JButton(kolabel3.getIcon());
			paneKamalehoia.add(btnKama3);
		}
		if(kolabel4.isVisible()){
			btnKama4=new JButton(kolabel4.getIcon());
			paneKamalehoia.add(btnKama4);
		}
		if(kolabel5.isVisible()){
			btnKama5=new JButton(kolabel5.getIcon());
			paneKamalehoia.add(btnKama5);
		}

		
		btnKama1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				if(t.loroaDaKolan(0)){
					loroaAtxituKamalehoia(aux,0);
				}else{
					if(t.kanguroaDaKolan(0)){
						kanguroaAtxituKamalehoia(aux,0);
					}else{
						
						t.txandaJokatu(aux, 0,0);
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
					loroaAtxituKamalehoia(aux,1);
				}else{
					if(t.kanguroaDaKolan(1)){
						kanguroaAtxituKamalehoia(aux,1);
					}else{
						t.txandaJokatu(aux, 1,0);
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
					loroaAtxituKamalehoia(aux,2);
				}else{
					if(t.kanguroaDaKolan(2)){
						kanguroaAtxituKamalehoia(aux,2);
					}else{
						t.txandaJokatu(aux, 2,0);
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
					loroaAtxituKamalehoia(aux,3);
				}else{
					if(t.kanguroaDaKolan(3)){
						kanguroaAtxituKamalehoia(aux,3);
					}else{
						t.txandaJokatu(aux, 3,0);
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
		
					loroaAtxituKamalehoia(aux,4);
				}else{
					if(t.kanguroaDaKolan(4)){
						
						kanguroaAtxituKamalehoia(aux,4);
					}else{
						t.txandaJokatu(aux, 4,0);
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
		paneKanguroa.setVisible(true);
		paneEskua.add(paneKanguroa);
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
				t.txandaJokatu(aux, 0,1);
				paneKanguroa.setVisible(false);
				bukatutaAhalDago();
			}
		});
		btnKanguro2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux, 0,2);
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
		if(kolabel1.isVisible()){
			btnLoro1=new JButton(kolabel1.getIcon());
			paneLoroa.add(btnLoro1);
		}
		if(kolabel2.isVisible()){
			btnLoro2=new JButton(kolabel2.getIcon());
			paneLoroa.add(btnLoro2);
		}
		if(kolabel3.isVisible()){
			btnLoro3=new JButton(kolabel3.getIcon());
			paneLoroa.add(btnLoro3);
		}
		if(kolabel4.isVisible()){
			btnLoro4=new JButton(kolabel4.getIcon());
			paneLoroa.add(btnLoro4);
		}
		if(kolabel5.isVisible()){
			btnLoro5=new JButton(kolabel5.getIcon());
			paneLoroa.add(btnLoro5);
		}

		contentPane.updateUI();
		btnLoro1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux, 0,0);
				paneLoroa.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
			}
		});
		btnLoro2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux, 0,1);
				paneLoroa.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
			}
		});
		btnLoro3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux, 0,2);
				paneLoroa.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
			}
		});
		btnLoro4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux, 0,3);
				paneLoroa.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
			}
		});
		btnLoro5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux, 0,4);
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
						t.txandaJokatu(i, 0,0);
					}
				}
			}
		}else{
			t.txandaJokatu(i, 0,0);
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
			
			irabazi.setText("                   "+t.irabazleaLortu());
			irabazi.setFont(new Font("Tahoma", Font.PLAIN, 75));
			irabazi.setVisible(true);
			contentPane.updateUI();
			try {
				t.partidaGorde(hOrdua.toString(), t.puntuazioaJ(), t.puntuazioaCPU(), erabiltzailea);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	public void loroaAtxituKamalehoia(int aux, int pos){
		Tableroa t=Tableroa.getNireTableroa();
		btnKama1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux, pos,0);
				paneKamalehoia.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
				contentPane.updateUI();
			}
		});
		btnKama2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux,pos, 1);
				paneKamalehoia.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
				contentPane.updateUI();
			}
		});
		btnKama3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux,pos, 2);
				paneKamalehoia.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
				contentPane.updateUI();
			}
		});
		btnKama4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux,pos, 3);
				paneKamalehoia.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
				contentPane.updateUI();
			}
		});
		btnKama5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux,pos, 4);
				paneKamalehoia.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
				contentPane.updateUI();
			}
		});
	}
	
	public void kanguroaAtxituKamalehoia(int aux, int pos){
		Tableroa t=Tableroa.getNireTableroa();
		paneKanguroaKamalehoia.setVisible(true);
		contentPane.add(paneKanguroaKamalehoia, BorderLayout.AFTER_LINE_ENDS);
		btnKanguro3=new JButton("1");
		btnKanguro4=new JButton ("2");
		btnKanguro3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnKanguro4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		paneKanguroaKamalehoia.add(btnKanguro3);
		paneKanguroaKamalehoia.add(btnKanguro4);
		
		paneKanguroaKamalehoia.updateUI();
		btnKanguro3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux,pos,1);
				paneKanguroaKamalehoia.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
				contentPane.updateUI();
			}
		});
		
		btnKanguro4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				t.txandaJokatu(aux,pos,2);
				paneKanguroaKamalehoia.setVisible(false);
				paneKola.setVisible(true);
				bukatutaAhalDago();
				contentPane.updateUI();
			}
		});
	
	}
}
