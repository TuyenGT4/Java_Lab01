package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model_Controller.controller;

public class Interface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel_nhapInf, panel_Button;
	private JButton btnThem, btnXoa, btnSua, btnLuu, btnKLuu, btnThoat;
	private JLabel lblTenLoai, lblMaLoai;
	private JTextField textField_MaLoai, textField_TenLoai;
	private JScrollPane scroll_HienThiDanhSach;
	private JTable table;
	private DefaultTableModel tableModel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					controller Controller = new controller(frame);
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
		
		
		panel_Button = new JPanel();
		panel_Button.setBounds(10, 149, 566, 29);
		panel_Button.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 0));
		getContentPane().add(panel_Button);
		
		btnThem = new JButton("Thêm");
		btnThem.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Button.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Button.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		btnSua.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Button.add(btnSua);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Button.add(btnLuu);
		
		btnKLuu = new JButton("K.Lưu");
		btnKLuu.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Button.add(btnKLuu);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setHorizontalAlignment(SwingConstants.LEFT);
		panel_Button.add(btnThoat);
		
		scroll_HienThiDanhSach = new JScrollPane();
		scroll_HienThiDanhSach.setBounds(10, 189, 566, 163);
		getContentPane().add(scroll_HienThiDanhSach);
		
		String[] columnName = {"Mã loại", "Tên loại"};
		// Tạo model cho bảng
        tableModel = new DefaultTableModel(columnName, 0);
		// gán table với model trên
        table = new JTable(tableModel);
		scroll_HienThiDanhSach.setViewportView(table);
		
		// Khởi tạo các trường nhập liệu ban đầu là disable
        textField_MaLoai.setEnabled(false);
        textField_TenLoai.setEnabled(false);

        // Khởi tạo các nút điều khiển ban đầu
        btnLuu.setEnabled(false);
        btnKLuu.setEnabled(false);
		
        
	}
	// các phương thức getter để controller có thể truy xuất vào interface
	public JTextField getTextFieldMaLoai() {
		return textField_MaLoai;
	}

	public JTextField getTextFieldTenLoai() {
		return textField_TenLoai;
	}


	public JButton getBtnThem() {
		return btnThem;
	}

	public JButton getBtnXoa() {
		return btnXoa;
	}

	public JButton getBtnSua() {
		return btnSua;
	}

	public JButton getBtnLuu() {
		return btnLuu;
	}

	public JButton getBtnKLuu() {
		return btnKLuu;
	}

	public JButton getBtnThoat() {
		return btnThoat;
	}

	public JTable getTable() {
		return table;
	}
}
