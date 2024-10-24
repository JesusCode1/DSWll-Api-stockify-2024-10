package pe.ciberted.edu.stockify.stockify.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Provedor {
	
	@JsonProperty("provedor_id")
    private int provedorId;
    @JsonProperty("provedor_name")
    private String nombre;
    private String email;
    @JsonProperty("phone_number")
    private String phone;
    private String website;
    
    
	public int getProvedorId() {
		return provedorId;
	}
	public void setProvedorId(int provedorId) {
		this.provedorId = provedorId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
    
    
}
