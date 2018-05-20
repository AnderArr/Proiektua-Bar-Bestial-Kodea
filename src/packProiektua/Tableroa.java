package packProiektua;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Observable;
import java.sql.*;
import java.util.Date;

public class Tableroa extends Observable{
	private JokalariErreala J1;
	private CPUJokalaria CPU;
	private KartaZerrenda kola;
	private KartaZerrenda sartuakJ1;
	private KartaZerrenda sartuakCPU;
	private static Tableroa nireTableroa;
	private Connection konexioa;
	
	private Tableroa() {
		J1=new JokalariErreala();
		CPU=new CPUJokalaria();
		kola=new KartaZerrenda();
		sartuakJ1=new KartaZerrenda();
		sartuakCPU=new KartaZerrenda();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String zerbitzaria = "jdbc:mysql://localhost:3306/proiektua";
		 String erabiltzailea = "root";
		 String pasahitza = "";
		 try {
			this.konexioa =(Connection) DriverManager.getConnection(zerbitzaria, erabiltzailea, pasahitza);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}
	
	public JokalariErreala get(){
		return this.J1;
	}
	public KartaZerrenda getJ1(){
		return this.J1.getBaraja();
	}
	public KartaZerrenda getEskuanJ1(){
		return this.J1.getEskuan();
	}
	public KartaZerrenda getCPU(){
		return this.CPU.getBaraja();
	}
	public KartaZerrenda getEskuanCPU(){
		return this.CPU.getEskuan();
	}
	public KartaZerrenda getSartuakJ1(){
		return this.sartuakJ1;
	}
	public KartaZerrenda getSartuakCPU(){
		return this.sartuakCPU;
	}
	public KartaZerrenda getKola(){
		return this.kola;
	}
	public static Tableroa getNireTableroa() {
		if(nireTableroa==null){
			nireTableroa=new Tableroa();
		}
		return nireTableroa;
	}
	
	public boolean daudeKartak(){
		if(this.kola.luzera()==0){
			return false;
		}else{
			return true;
		}
	}
	
	public void txandaJokatu(int pos,int aux,int aux2){
	    J1.kartaMahairaBota(pos,aux,aux2);
	    J1.kartaBarajatikHartu();
	    animaladaRekurrenteak();
	    if(this.kola.luzera()==5){
	    	this.kolaEguneratu();
	    }
		CPU.kartaMahairaBota();
		CPU.kartaBarajatikHartu();
		animaladaRekurrenteak();
		if(this.kola.luzera()==5){
	    	this.kolaEguneratu();
	    }
		ArrayList<String> bz=new ArrayList<String>();
		for(int i=0;i<this.kola.luzera();i++){
			bz.add(this.kola.getKarta(i).getKarta());
		}
		bz.add("/");
		for(int ind=0;ind<this.J1.getEskuan().luzera();ind++){
			bz.add(this.J1.getEskuan().getKarta(ind).getKarta());
		}
		setChanged();
		notifyObservers(bz);
	}

	public boolean kamalehoiaDa(int pPos){
		return this.getEskuanJ1().kamalehoiaDa(pPos);
	}
	
	public boolean loroaDaKolan(int pPos){
		return this.kola.loroaDa(pPos);
	}
	
	public boolean kanguroaDaKolan(int pPos){
		return this.kola.kanguroaDa(pPos);
	}
	
	public boolean loroaDa(int pPos){
		return this.getEskuanJ1().loroaDa(pPos);
	}
	
	public boolean kartakGeratuEskuan(){
		return this.getEskuanJ1().luzera()!=0;
	}
	
	public boolean kartakGeratuBarajan(){
		return this.J1.kartakGeratuBarajan();
	}
	
	public boolean kanguroaDa(int pPos){
		return this.getEskuanJ1().kanguroaDa(pPos);
	}

	public void animaladaRekurrenteak(){
		int ind=0;
		KartaZerrenda kZ=this.kola;
		Karta aux;
		while(ind<kZ.luzera()){
			Karta k=kZ.getKarta(ind);
			aux=null;
			if((k.getErrepikatu())&&(kZ.luzera()>1)){
				if ((kZ.luzera()-1)!=kZ.posizioaLortu(k)){
					aux=kZ.getKarta(ind+1);
				}
				k.gaitasunaBurutu(0, 0, k);
			}
			if(aux!=null){
				ind=kZ.posizioaLortu(aux);	
			} else {
				ind++;
			}
		}
	}

	public boolean bukatuta(){
		return ((this.J1.getEskuan().luzera()==0)&&(this.CPU.getEskuan().luzera()==0));
	}

	public void kolaEguneratu(){
		this.kola.kartaKendu(4);
		Karta k1= this.kola.kartaHartu();
		Karta k2= this.kola.kartaHartu();
		this.sartuBereLekuan(k1);
		this.sartuBereLekuan(k2);
	}

	public void erabiltzaileBerria(String erabilId, String pIzena, String pAbizena, String pEmail, String pUrtea, String pHilabetea, String pEguna, String pPasahitza) throws SQLException {
		Statement st = konexioa.createStatement();
		st.executeUpdate("INSERT INTO JOKALARIA VALUES ('"+erabilId+"','"+pIzena+"','"+pAbizena+"','ERABILTZAILEA','"+pPasahitza+"','"+pEmail+"',CURRENT_DATE,'"+pUrtea+"-"+pHilabetea+"-"+pEguna+"');");
	}

	public ArrayList<String> ranking(String pIzena) throws SQLException{
		PreparedStatement st1=konexioa.prepareStatement("SELECT JOKALARIA_ID, PUNT_JOKALARIA, PUNT_AURKARIA, DATA, HORDUA, B_ORDUA FROM PARTIDA WHERE IRABAZI=1 AND JOKALARIA_ID='"+pIzena+"' ORDER BY PUNT_JOKALARIA DESC;");
		ResultSet rs=st1.executeQuery();
	
		ResultSetMetaData rsmd=rs.getMetaData();
		ArrayList<String> z=new ArrayList<String>();
		int columnsNumber = rsmd.getColumnCount();
	   	while (rs.next()) {
	       		for (int o = 0; o <= columnsNumber; o++) {
	           		if (o > 0){
	           		String columnValue = rs.getString(o);
	           		z.add(columnValue);
				}
	       		}
		}
	   	return z;
	}

	public ArrayList<String> ranking2(String pIzena) throws SQLException{
		PreparedStatement st1=konexioa.prepareStatement("SELECT JOKALARIA_ID, PUNT_JOKALARIA, PUNT_AURKARIA, DATA, HORDUA, B_ORDUA FROM PARTIDA WHERE IRABAZI=1 AND DATA=CURRENT_DATE ORDER BY PUNT_JOKALARIA DESC;");
		ResultSet rs=st1.executeQuery();
	
		ResultSetMetaData rsmd=rs.getMetaData();
		ArrayList<String> z=new ArrayList<String>();
		int columnsNumber = rsmd.getColumnCount();
	   	while (rs.next()) {
	       		for (int o = 0; o <= columnsNumber; o++) {
	           		if (o > 0){
	           			String columnValue = rs.getString(o);
	           			z.add(columnValue);
				}
	       		}
		}
	   	return z;
	}

	public ArrayList<String> ranking3(String pIzena) throws SQLException{
		PreparedStatement st1=konexioa.prepareStatement("SELECT JOKALARIA_ID, PUNT_JOKALARIA, PUNT_AURKARIA, DATA, HORDUA, B_ORDUA FROM PARTIDA WHERE IRABAZI=1 ORDER BY PUNT_JOKALARIA DESC;");
		ResultSet rs=st1.executeQuery();
	
		ResultSetMetaData rsmd=rs.getMetaData();
		ArrayList<String> z=new ArrayList<String>();
		int columnsNumber = rsmd.getColumnCount();
	   	while (rs.next()) {
	       		for (int o = 0; o <= columnsNumber; o++) {
	           		if (o > 0){
	           			String columnValue = rs.getString(o);
	           			z.add(columnValue);
				}
	       		}
		}
	   	return z;
	}

	public ArrayList<String> ranking4(String pIzena) throws SQLException{
		PreparedStatement st1=konexioa.prepareStatement("SELECT JOKALARIA_ID, AVG(PUNT_JOKALARIA) FROM PARTIDA WHERE IRABAZI=1  GROUP BY JOKALARIA_ID ORDER BY AVG(PUNT_JOKALARIA) DESC;");
		ResultSet rs=st1.executeQuery();
	
		ResultSetMetaData rsmd=rs.getMetaData();
		ArrayList<String> z=new ArrayList<String>();
		int columnsNumber = rsmd.getColumnCount();
	  	while (rs.next()) {
	       		for (int o = 0; o <= columnsNumber; o++) {
	           		if (o > 0){
	          	 		String columnValue = rs.getString(o);
	           			z.add(columnValue);
				}
	       		}
		}
	   return z;
	}

	public boolean ondoDago(String erabiltzailea,String pasahitza) throws SQLException{
		PreparedStatement st1=konexioa.prepareStatement("SELECT ERABILTZAILE_IZENA FROM JOKALARIA WHERE ERABILTZAILE_IZENA='"+erabiltzailea+"' AND PASAHITZA='"+pasahitza+"';");
		ResultSet rs=st1.executeQuery();
	
		ResultSetMetaData rsmd=rs.getMetaData();
		ArrayList<String> z=new ArrayList<String>();
		int columnsNumber = rsmd.getColumnCount();
	   	while (rs.next()) {
	       		for (int o = 0; o <= columnsNumber; o++) {
	          		if (o > 0){
	           			String columnValue = rs.getString(o);
	          			 z.add(columnValue);
				}
	       		}
		}
	 	if(z.size()==0){
			return false;
		} else {
		 	return true;
	 	}
	}

	public boolean existitzenDa(String erabiltzailea) throws SQLException{
		PreparedStatement st1=konexioa.prepareStatement("SELECT ERABILTZAILE_IZENA FROM JOKALARIA WHERE ERABILTZAILE_IZENA='"+erabiltzailea+"';");
		ResultSet rs=st1.executeQuery();
	
		ResultSetMetaData rsmd=rs.getMetaData();
		ArrayList<String> z=new ArrayList<String>();
		int columnsNumber = rsmd.getColumnCount();
	   	while (rs.next()) {
	       		for (int o = 0; o <= columnsNumber; o++) {
	           		if (o > 0){
	           			String columnValue = rs.getString(o);
	           			z.add(columnValue);
				}
	       		}
		}
		if(z.size()==0){
			return false;
	 	} else {
		 	return true;
		}
	}

	public void administratzaileaAldatu(String erabiltzailea, String pMota) throws SQLException{
		Statement st1=konexioa.createStatement();
		st1.executeUpdate("UPDATE JOKALARIA SET ERABILTZAILE_MOTA='"+pMota+"' WHERE ERABILTZAILE_IZENA = '"+erabiltzailea+"';");
	}

	public boolean administratzaileaDa(String erabiltzailea) throws SQLException{
		PreparedStatement st1=konexioa.prepareStatement("SELECT ERABILTZAILE_IZENA FROM JOKALARIA WHERE ERABILTZAILE_IZENA='"+erabiltzailea+"' AND ERABILTZAILE_MOTA='ADMINISTRATZAILEA';");
		ResultSet rs=st1.executeQuery();
	
		ResultSetMetaData rsmd=rs.getMetaData();
		ArrayList<String> z=new ArrayList<String>();
		int columnsNumber = rsmd.getColumnCount();
	 	while (rs.next()) {
	      	for (int o = 0; o <= columnsNumber; o++) {
	        	if (o > 0){
	          		String columnValue = rs.getString(o);
	           		z.add(columnValue);}
	       		}
		}
	 	if(z.size()==0){
			return false;
		} else {
			return true;
		 }
	}

	public void baneatu(String izena) throws SQLException{
		Statement st1=konexioa.createStatement();
		st1.executeUpdate("DELETE FROM PARTIDA WHERE JOKALARIA_ID = '"+izena+"';");
		st1.executeUpdate("DELETE FROM JOKALARIA WHERE ERABILTZAILE_IZENA = '"+izena+"';");	
	}

	public void partidaGorde(String hOrdua, int puntuazioaJ, int puntuazioaCPU, String erabiltzailea) throws SQLException{
		Statement st1=konexioa.createStatement();
		int irabazi;
		if(puntuazioaJ>puntuazioaCPU){
			irabazi=1;
		} else {
			irabazi=0;
		}
		String s=new String();
		boolean aurkitua=false;
		for (int n = 0; n <hOrdua.length (); n++) { 
			char c = hOrdua.charAt (n);
			if(c=='.'){
				aurkitua=false;
			}
			if(aurkitua){
				s=s+c;
			}
			if(c=='T'){
				aurkitua=true;
			}
		}
		int a=(int) (Math.random()*1000000000)+1;
		st1.executeUpdate("INSERT INTO PARTIDA VALUES("+a+",'URDINA',CURRENT_DATE,'"+s+"',CURRENT_TIME,"+puntuazioaJ+","+puntuazioaCPU+",'"+erabiltzailea+"',"+irabazi+");");
	}

	public void kartaSortu(String izena, String zenbakia, String azalpena, String puntuazioa, String originala) throws SQLException{
		Statement st1=konexioa.createStatement();
		st1.executeUpdate("INSERT INTO KARTA VALUES('"+izena+"',"+zenbakia+",'"+azalpena+"',"+puntuazioa+","+originala+");");
	}


	public String irabazleaLortu(){
		int punt1=0;
		int punt2=0;
		for(int i=0;i<this.sartuakJ1.luzera();i++){
			punt1=punt1+this.sartuakJ1.getKarta(i).getBalioa();
		}
		for(int j=0;j<this.sartuakCPU.luzera();j++){
			punt2=punt2+this.sartuakCPU.getKarta(j).getBalioa();
		}
		if (punt1>punt2){
			return "J1 irabazi du   J1:"+punt1+"   CPU:"+punt2;
		} else {
			if(punt1<punt2){
				return "CPU irabazi du   J1:"+punt1+"   CPU:"+punt2;
			} else {
				return "Berdinketa egon da   J1:"+punt1+"   CPU:"+punt2;
			}
		}
	}

	public int puntuazioaJ(){
		int punt1=0;
		for(int i=0;i<this.sartuakJ1.luzera();i++){
			punt1=punt1+this.sartuakJ1.getKarta(i).getBalioa();
		}
		return punt1;
	}

	public int puntuazioaCPU(){
		int punt1=0;
		for(int j=0;j<this.sartuakCPU.luzera();j++){
			punt1=punt1+this.sartuakCPU.getKarta(j).getBalioa();
		}
		return punt1;
	}


	public void sartuBereLekuan(Karta k1){
		if(k1.getKolorea().equals("Urdina")){
			this.sartuakJ1.kartaGehitu(k1);
		}else{
			this.sartuakCPU.kartaGehitu(k1);
		}
	}

	public boolean kamalehoiaDa(String a){
		KamalehoiKarta k=new KamalehoiKarta("berdea");
		if(a.equals(k.getKartaIrudia())){
			return true;
		}else{
			return false;
		}
	}

	public void jokoaHasieratu(){
		J1.jokalariaHasieratu("Urdina");
		CPU.jokalariaHasieratu("Berdea");
		ArrayList<String> bz=new ArrayList<String>();
		for(int i=0;i<this.kola.luzera();i++){
			bz.add(this.kola.getKarta(i).getKarta());
		}
		bz.add("/");
		for(int ind=0;ind<this.J1.getEskuan().luzera();ind++){
			bz.add(this.J1.getEskuan().getKarta(ind).getKarta());
		}
		setChanged();
		notifyObservers(bz);	
	}	
}
