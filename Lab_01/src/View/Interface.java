package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel_nhapInf, panel_Button;
	private JButton btnThem, btnXoa, btnSua, btnLuu, btnKLuu, btnThoat;
	private JLabel lblTenLoai, lblMaLoai;
	private JTextField textField_MaLoai, textField_TenLoai;
	private JScrollPane scroll_HienThiDanhSach;
	private JTable table;
	private JTextField textField_DonGia;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
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
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(null);
		
		JPanel panel_nhapInf = new JPanel();
		panel_nhapInf.setBounds(10, 11, 566, 127);
		getContentPane().add(panel_nhapInf);
		panel_nhapInf.setLayout(null);
		
		textField_TenLoai = new JTextField();
		textField_TenLoai.setBounds(83, 96, 174, 20);
		panel_nhapInf.add(textField_TenLoai);
		textField_TenLoai.setColumns(10);
		
		textField_MaLoai = new JTextField();
		textField_MaLoai.setBounds(83, 65, 109, 20);
		panel_nhapInf.add(textField_MaLoai);
		textField_MaLoai.setColumns(10);
		
		JLabel lblTittle = new JLabel("DANH MỤC LOẠI SẢN PHẨM");
		lblTittle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTittle.setBounds(188, 11, 210, 14);
		panel_nhapInf.add(lblTittle);
		
		JLabel lblTenLoai = new JLabel("Tên loại: ");
		lblTenLoai.setBounds(24, 99, 68, 14);
		panel_nhapInf.add(lblTenLoai);
		
		JLabel lblMaLoai = new JLabel("Mã loại: ");
		lblMaLoai.setBounds(24, 68, 49, 14);
		panel_nhapInf.add(lblMaLoai);
		
		textField_DonGia = new JTextField();
		textField_DonGia.setBounds(382, 96, 151, 20);
		panel_nhapInf.add(textField_DonGia);
		textField_DonGia.setColumns(10);
		
		JLabel lblDonGia = new JLabel("Đơn giá:");
		lblDonGia.setBounds(323, 99, 49, 14);
		panel_nhapInf.add(lblDonGia);
		
		panel_Button = new JPanel();
		panel_Button.setBounds(10, 149, 566, 29);
		panel_Button.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 0));
		getContentPane().add(panel_Button);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Button.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Button.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Button.add(btnSua);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Button.add(btnLuu);
		
		JButton btnKLuu = new JButton("K.Lưu");
		btnKLuu.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Button.add(btnKLuu);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Button.add(btnThoat);
		
		scroll_HienThiDanhSach = new JScrollPane();
		scroll_HienThiDanhSach.setBounds(10, 189, 566, 163);
		getContentPane().add(scroll_HienThiDanhSach);
		
		String[] columnName = {"Mã loại", "Tên loại", "Đơn giá"};
		// Tạo model cho bảng
        DefaultTableModel tableModel = new DefaultTableModel(columnName, 0);
        // Tạo JTable với model
        JTable table = new JTable(tableModel);
		scroll_HienThiDanhSach.setViewportView(table);
		
        
	}
}
