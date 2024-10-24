package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class NhanVien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maNhanVien;
	@NotBlank(message = "Tên nhân viên không được để trống")
	@Size(max = 50, message = "Tên nhân viên không được quá 50 ký tự.")
	private String tenNhanVien;
	@NotBlank(message = "Email không được để trống")
	@Email(message = "Email không hợp lệ.")
	private String email;
	@NotBlank(message = "Địa chỉ không được để trống")
	private String diaChi;
	@NotBlank(message = "Điện thoại không được để trống")
	private String dienThoai;
	@ManyToOne
	@JoinColumn(name = "maPhongBan")
	private PhongBan phongBan;
	
	public NhanVien() {
		super();
	}

	public NhanVien(int maNhanVien, String tenNhanVien, String email, String diaChi, String dienThoai,
			PhongBan phongBan) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.email = email;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.phongBan = phongBan;
	}

	public NhanVien(String tenNhanVien, String email, String diaChi, String dienThoai, PhongBan phongBan) {
		super();
		this.tenNhanVien = tenNhanVien;
		this.email = email;
		this.diaChi = diaChi;
		this.dienThoai = dienThoai;
		this.phongBan = phongBan;
	}

	public int getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(int maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", email=" + email + ", diaChi="
				+ diaChi + ", dienThoai=" + dienThoai + ", phongBan=" + phongBan + "]";
	}
	
}
