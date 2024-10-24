package entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class PhongBan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maPhongBan;
	private String tenPhongBan;
	@OneToMany(mappedBy = "phongBan")
	private List<NhanVien> listNhanVien;
	
	public PhongBan() {
		super();
	}

	public PhongBan(int maPhongBan, String tenPhongBan, List<NhanVien> listNhanVien) {
		super();
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.listNhanVien = listNhanVien;
	}

	public PhongBan(String tenPhongBan) {
		super();
		this.tenPhongBan = tenPhongBan;
	}

	public int getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(int maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public List<NhanVien> getListNhanVien() {
		return listNhanVien;
	}

	public void setListNhanVien(List<NhanVien> listNhanVien) {
		this.listNhanVien = listNhanVien;
	}

	@Override
	public String toString() {
		return "PhongBan [maPhongBan=" + maPhongBan + ", tenPhongBan=" + tenPhongBan + "]";
	}
	
	
}
