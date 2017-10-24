/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 *
 * @author jmche
 */
public class Client {

	private int noClient;
	private String nom;
	private String email;

	public String getMdp() {
		return mdp;
	}
	private String mdp;

	public Client(int noClient, String nom, String email, String mdp) {
		this.noClient = noClient;
		this.nom = nom;
		this.email = email;
		this.mdp = mdp;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 97 * hash + this.noClient;
		hash = 97 * hash + Objects.hashCode(this.nom);
		hash = 97 * hash + Objects.hashCode(this.email);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Client other = (Client) obj;
		if (this.noClient != other.noClient) {
			return false;
		}
		if (!Objects.equals(this.nom, other.nom)) {
			return false;
		}
		if (!Objects.equals(this.email, other.email)) {
			return false;
		}
		return true;
	}

	public static Client getClient(int noClient) throws SQLException {
		Client result = null;
		Connection connexion = Database.getConnection();
		Statement ordre = connexion.createStatement();
		String sql = " SELECT * FROM client WHERE no_client = " + noClient;
		ResultSet rs = ordre.executeQuery(sql);
		if (rs.next()) {
			result = new Client(rs.getInt("no_client"),
					  rs.getString("nom"),
					  rs.getString("email"), 
					  rs.getString("mdp"));
			rs.close();
			ordre.close();
			connexion.close();
		}
		return result;
	}
	
	public static Client getByEmailMpd(String email, String mdp) throws SQLException{
		Client result = null;
		Connection connexion = Database.getConnection();
		Statement ordre = connexion.createStatement();
		String sql = " SELECT * FROM client WHERE email = '"+email+"' AND mdp = '"+mdp+"';";
		ResultSet rs = ordre.executeQuery(sql);
		if (rs.next()) {
			result = new Client(rs.getInt("no_client"),
					  rs.getString("nom"),
					  rs.getString("email"),
					  rs.getString("mdp"));
			rs.close();
			ordre.close();
			connexion.close();
		}
		return result;
	}
	
	public int getNoClient() {
		return noClient;
	}

	public String getNom() {
		return nom;
	}

	public String getEmail() {
		return email;
	}
}
