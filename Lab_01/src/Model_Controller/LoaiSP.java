package Model_Controller;

public class LoaiSP {
	private String maLoai, tenLoai;
	private long donGia;
	public LoaiSP(String maLoai, String tenLoai, long donGia) {
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
		this.donGia = donGia;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public long getDonGia() {
		return donGia;
	}
	public void setDonGia(long donGia) {
		this.donGia = donGia;
	}
	
	
}
