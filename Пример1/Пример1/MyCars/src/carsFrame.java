import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

public class carsFrame extends JFrame {
	
	Connection conn=null;
	PreparedStatement state=null;
	ResultSet result=null;
	// ������� ���������� �� ������������ �� id-���� �� ��������� ������������
	int id=-1;
	int idpr=-1;
	int idmash=-1;
	int idspr=-1;

	//��� ��� �����
	JTabbedPane tab=new JTabbedPane();

	//��� ��������
	//������� ����� �� ��������
	JPanel carPanel=new JPanel();
	
	//��������� �� ��������
	JPanel carPanel1=new JPanel();
	JPanel carPanel2=new JPanel();
	JPanel carPanel3=new JPanel();
		
	//�������
	JLabel carNameL=new JLabel("������������:");
	JLabel carProizvL=new JLabel("������������:");
	JLabel carML=new JLabel("�����:");
	JLabel carOpisL=new JLabel("��������:");
	JLabel carBrL=new JLabel("����:");
	JLabel carPriceL=new JLabel("����:");
	JLabel carYearL=new JLabel("������:");
	
	private static final long serialVersionUID = 4L;
	
	//�������� ������ �� ���������
	JTextField carNameTF=new JTextField();
	JTextField carProizvTF=new JTextField();
	JTextField carMTF=new JTextField();
	JTextField carOpisTF=new JTextField();
	JTextField carBrTF=new JTextField();
	JTextField carPriceTF=new JTextField();
	JTextField carYearTF=new JTextField();
	
	//��������� �� ��������������
	JComboBox<String> comboPr=new JComboBox<String>();
	JComboBox<String> comboM=new JComboBox<String>();
	
	//������ �� ������ ��������
	JButton BAdd=new JButton("������");
	JButton BDel=new JButton("������");
	JButton BEdit=new JButton("�������");
	
	//�������+������ �� ������������
	JTable carTable=new JTable();
	JScrollPane carScroll=new JScrollPane(carTable);

	//��� �����
	//������
	JLabel mashNameL=new JLabel("�����:");
	//�������� ����
	JTextField mashNameTF=new JTextField();

	//������� ����� �� �����
	JPanel mashPanel=new JPanel();
	//���������
	JPanel mashPanel1=new JPanel();
	JPanel mashPanel2=new JPanel();
	JPanel mashPanel3=new JPanel();

	//������ �� ������ ��������
	JButton MashAdd=new JButton("������");
	JButton MashDel=new JButton("������");
	JButton MashEdit=new JButton("�������");
	
	//�������+������ �� �����
	JTable mashTable=new JTable();
	JScrollPane mashScroll=new JScrollPane(mashTable);

	//��� ������������
	//������
	JLabel prNameL=new JLabel("������������:");
	//�������� ���� �� ���������
	JTextField prNameTF=new JTextField();

	//������� �����
	JPanel prPanel=new JPanel();
	//���������
	JPanel prPanel1=new JPanel();
	JPanel prPanel2=new JPanel();
	JPanel prPanel3=new JPanel();

	//������ �� ������������
	JButton PrAdd=new JButton("������");
	JButton PrDel=new JButton("������");
	JButton PrEdit=new JButton("�������");
	
	//�������+������ �� ������������
	JTable prTable=new JTable();
	JScrollPane prScroll=new JScrollPane(prTable);
	//��� �������: ��-����� ����
	//������
	JLabel sprCarPriceL=new JLabel("�������� ���������� ����:");
	//�������� ���� �� ���������
	JTextField sprCarPriceTF=new JTextField();

	//������� �����
	JPanel sprPanel=new JPanel();
	//���������
	JPanel sprPanel1=new JPanel();
	JPanel sprPanel2=new JPanel();
	JPanel sprPanel3=new JPanel();

	//������ �� ������������
	JButton sPrSearch=new JButton("�����");
	//JButton sPrDel=new JButton("������");
	//JButton sPrEdit=new JButton("�������");
	
	//�������+������ �� �� ���������
	JTable sprTable=new JTable();
	JScrollPane sprScroll=new JScrollPane(sprTable);

	public carsFrame() {
		
		conn=MyDBConnection.getConnection();

		this.setSize(600, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("�������������� ����������");
		
		// tab ��������
		tab.add(carPanel,"��������");
		carPanel.setLayout(new GridLayout(3,1));
		//����� ��������
		carPanel.add(carPanel1);

		carPanel1.setLayout(new GridLayout(7,2));
		carPanel1.add(carNameL);carPanel1.add(carNameTF);
		carPanel1.add(carProizvL);carPanel1.add(comboPr);
		carPanel1.add(carML);carPanel1.add(comboM);
		carPanel1.add(carOpisL);carPanel1.add(carOpisTF);
		carPanel1.add(carBrL);carPanel1.add(carBrTF);
		carPanel1.add(carPriceL);carPanel1.add(carPriceTF);
		carPanel1.add(carYearL);carPanel1.add(carYearTF);

		//����� �������� �� ��������
		carPanel.add(carPanel2);
		carPanel2.add(BAdd);carPanel2.add(BDel);carPanel2.add(BEdit);
		
		// ������ 
		BAdd.addActionListener(new AddCarDB());
		BDel.addActionListener(new DelCarDB());
		BEdit.addActionListener(new EditCarDB());
		
		carPanel.add(carPanel3);
		carScroll.setPreferredSize(new Dimension(550, 200));
		carPanel3.add(carScroll);
		
	
		//��� ������������  
		tab.add(prPanel,"������������");
		prPanel.setLayout(new GridLayout(3,1));
		prPanel.add(prPanel1);

		//prPanel1.setLayout(new GridLayout(1,2));
		//prPanel1.setLayout(new FlowLayout(FlowLayout.LEFT));
		prPanel1.add(prNameL);prPanel1.add(prNameTF);
		prNameTF.setPreferredSize(new Dimension(450,30));

		prPanel.add(prPanel2);
		prPanel2.add(PrAdd);prPanel2.add(PrDel);prPanel2.add(PrEdit);
		
		// ������ 
		PrAdd.addActionListener(new AddPrDB());
		PrDel.addActionListener(new DelPrDB());
		PrEdit.addActionListener(new EditPrDB());
		
		prPanel.add(prPanel3);
		prScroll.setPreferredSize(new Dimension(550, 200));
		prPanel3.add(prScroll);
		
		//��� �����  
		tab.add(mashPanel,"�����");
		mashPanel.setLayout(new GridLayout(3,1));
		mashPanel.add(mashPanel1);

		mashPanel1.add(mashNameL);mashPanel1.add(mashNameTF);
		mashNameTF.setPreferredSize(new Dimension(450,30));

		mashPanel.add(mashPanel2);
		mashPanel2.add(MashAdd);mashPanel2.add(MashDel);mashPanel2.add(MashEdit);
		
		// ������ 
		MashAdd.addActionListener(new AddMashDB());
		MashDel.addActionListener(new DelMashDB());
		MashEdit.addActionListener(new EditMashDB());
		
		mashPanel.add(mashPanel3);
		mashScroll.setPreferredSize(new Dimension(550, 200));
		mashPanel3.add(mashScroll);
		
		//��� �������  
		tab.add(sprPanel,"�������");
		sprPanel.setLayout(new GridLayout(3,1));
		sprPanel.add(sprPanel1);

		sprPanel1.add(sprCarPriceL);sprPanel1.add(sprCarPriceTF);
		sprCarPriceTF.setPreferredSize(new Dimension(450,30));

		sprPanel.add(sprPanel2);
		sprPanel2.add(sPrSearch);
		
		// ������ 
		sPrSearch.addActionListener(new SearchDB());
		
		sprPanel.add(sprPanel3);
		sprScroll.setPreferredSize(new Dimension(550, 200));
		sprPanel3.add(sprScroll);

		this.add(tab);
		this.setVisible(true);
		this.refreshArtTable(); // ������� ��� ���������
		this.refreshComboPr();
		this.refreshComboM();
		this.refreshPrTable("PRTABLE", prTable); // ������� � ���������
		this.refreshMTable("MTABLE", mashTable); // ������� � ���������
		
		//��������� �� ������� � ��������� �� ������������
		carTable.addMouseListener(new MouseActionCarTable());
		prTable.addMouseListener(new MouseActionPrTable());
		mashTable.addMouseListener(new MouseActionMashTable());
		
		comboPr.addActionListener(new ActionListener() {
			
			//��������� �������� ���������� �� ������������ ���� ��� � ������� ������ ���
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(idpr);
				if(tab.getSelectedIndex()==0 && idpr>0) {
					//if(idpr>0 || !comboPr.getSelectedItem().toString().isEmpty()) {
					String str="select * from prtable where proizvoditel='"+comboPr.getSelectedItem().toString()+"'";
					try {
						state=conn.prepareStatement(str);
						result=state.executeQuery();
						result.next();
						idpr=Integer.parseInt(result.getObject(1).toString());
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}

					System.out.println(comboPr.getSelectedItem().toString());
					System.out.println(str);
					System.out.println(idpr);
				}
			//	} 
			}
		});

		comboM.addActionListener(new ActionListener() {
			
			//��������� �������� ���������� �� ����� ���� ��� � ������� ������ ���
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(tab.getSelectedIndex()==0 && idmash>0) {
					
					String str="select * from mtable where mashtab='"+comboM.getSelectedItem().toString()+"'";
					try {
						state=conn.prepareStatement(str);
						result=state.executeQuery();
						result.next();
						idmash=Integer.parseInt(result.getObject(1).toString());
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					System.out.println(comboM.getSelectedItem().toString());
					System.out.println(str);
					System.out.println(idmash);
				}

			}
		});

	}
	// ����������� ������� � ��������� �� ������� ������ � ���������� ���
	public void refreshArtTable() {
		//conn=MyDBConnection.getConnection();
		String str="";
		str="select ARTTABLE.id, name, PRTABLE.proizvoditel,ARTTABLE.idproizvoditel, MTABLE.mashtab,ARTTABLE.idmashtab, opis, kol,cena,datein,year from ARTTABLE,MTABLE,PRTABLE where ARTTABLE.idmashtab=MTABLE.id and ARTTABLE.idproizvoditel=PRTABLE.id";
		try {
			state=conn.prepareStatement(str);
			result=state.executeQuery();
			carTable.setModel(new MyTModel(result));
			
			carTable.getColumnModel().getColumn(3).setMinWidth(0);
			carTable.getColumnModel().getColumn(3).setMaxWidth(0);
			carTable.getColumnModel().getColumn(3).setWidth(0);

			carTable.getColumnModel().getColumn(5).setMinWidth(0);
			carTable.getColumnModel().getColumn(5).setMaxWidth(0);
			carTable.getColumnModel().getColumn(5).setWidth(0);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// ����������� ������� � ��������� �� ������������ � ���������� ���
	public void refreshPrTable(String name, JTable table) {
		//conn=MyDBConnection.getConnection();
		String str="select * from "+name;
		try {
			state=conn.prepareStatement(str);
			result=state.executeQuery();
			table.setModel(new MyTModel(result));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// ����������� ������� � ��������� �� ����� � ���������� ���
	public void refreshMTable(String name, JTable table) {
		//conn=MyDBConnection.getConnection();
		String str="select * from "+name;
		try {
			state=conn.prepareStatement(str);
			result=state.executeQuery();
			table.setModel(new MyTModel(result));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// ���������� ����� ������� �� ��������� �� �������������
	public void refreshComboPr() {
		
		idpr=-1;
		comboPr.removeAllItems();
		
		String sql="select id, proizvoditel from prtable";
		//conn=DBConnection.getConnection();
		String item="";
		
		try {
			state=conn.prepareStatement(sql);
			result=state.executeQuery();
			if(result.next()) {
				idpr=Integer.parseInt(result.getObject(1).toString());
				do{
					item=result.getObject(2).toString();
					comboPr.addItem(item);
				}while(result.next());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// ���������� ����� ������� �� ��������� �� �����
	public void refreshComboM() {
		
		idmash=-1;

		comboM.removeAllItems();
		
		String sql="select id, mashtab from mtable";
		//conn=DBConnection.getConnection();
		String item="";
		
		try {
			state=conn.prepareStatement(sql);
			result=state.executeQuery();
			if(result.next()) {
				idmash=Integer.parseInt(result.getObject(1).toString());
				do {
					item=result.getObject(2).toString();
					comboM.addItem(item);
				}while(result.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// �������� ������ "��������" �� ������� �����
	class AddCarDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
//			conn=DBConnection.getConnection();
			if(!carNameTF.getText().isEmpty()) {
				String sql="insert into arttable values(null,?,?,?,?,?,?,CURDATE(),?)";
				try {
					state=conn.prepareStatement(sql);
					state.setString(1, carNameTF.getText());
					state.setInt(2, idpr);
					state.setInt(3, idmash);
					state.setString(4, carOpisTF.getText());
					state.setInt(5, Integer.parseInt(carBrTF.getText()));
					state.setDouble(6, Double.parseDouble(carPriceTF.getText()));
					state.setInt(7, Integer.parseInt(carYearTF.getText()));
					state.execute();
					refreshArtTable();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				carNameTF.setText("");
				carOpisTF.setText("");
				carYearTF.setText("");
				id=-1;
			}
		}
	}
	// �������� ������ "���������" �� ������� �����
	class DelCarDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
//			conn=DBConnection.getConnection();
			if (id>0) {
				String sql="delete from arttable where id=?";
				try {
					state=conn.prepareStatement(sql);
					state.setInt(1, id);
					state.execute();
					refreshArtTable();
				
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				carNameTF.setText("");
				carOpisTF.setText("");
				carYearTF.setText("");
				id=-1;
			}
		}
	}
	// �������� ������ "�������" �� ������� �����
	class EditCarDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
//			conn=DBConnection.getConnection();
			if(id>0) {
				String sql="update arttable set name=?, idproizvoditel=?, idmashtab=?, opis=?, kol=?, cena=?, year=? where id=?";
			
				try {
					state=conn.prepareStatement(sql);
					
					state.setString(1, carNameTF.getText());
					state.setInt(2, idpr);
					state.setInt(3, idmash);
					state.setString(4, carOpisTF.getText());
					state.setInt(5, Integer.parseInt(carBrTF.getText()));
					state.setDouble(6, Double.parseDouble(carPriceTF.getText()));
					state.setInt(7, Integer.parseInt(carYearTF.getText()));
					state.setInt(8, id);
					state.execute();
					
					refreshArtTable();
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				carNameTF.setText("");
				carOpisTF.setText("");
				carYearTF.setText("");
			}
			
		}
	}
	// �������� ������ "��������" �� ������������
	class AddPrDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
//			conn=DBConnection.getConnection();
			if(!prNameTF.getText().isEmpty()) {
				String sql="insert into prtable values(null,?)";
				try {
					state=conn.prepareStatement(sql);
					state.setString(1, prNameTF.getText());
					state.execute();
					
					refreshPrTable("PRTABLE", prTable);
					refreshComboPr();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				prNameTF.setText("");
			}
		}
	}
	// �������� ������ "���������" �� ������������
	class DelPrDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
//			conn=DBConnection.getConnection();
			if (idpr>0) {
				String sql="delete from prtable where id=?";
				try {
					state=conn.prepareStatement(sql);
					state.setInt(1, idpr);
					state.execute();
					refreshPrTable("PRTABLE", prTable);
					refreshComboPr();
					//idpr=-1;
				
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				prNameTF.setText("");
			}
		}
	}
	// �������� ������ "�������" �� ������������
	class EditPrDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
//			conn=DBConnection.getConnection();
			if(idpr>0) {
				String sql="update prtable set proizvoditel=? where id=?";
			
				try {
					state=conn.prepareStatement(sql);
					state.setString(1, prNameTF.getText());
					state.setInt(2, idpr);
					state.execute();
					refreshPrTable("PRTABLE", prTable);
					refreshComboPr();
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				prNameTF.setText("");
			}
			
		}
	}
	// �������� ������ "��������" �� �����
	class AddMashDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
//			conn=DBConnection.getConnection();
			if(!mashNameTF.getText().isEmpty()) {
				String sql="insert into mtable values(null,?)";
				try {
					state=conn.prepareStatement(sql);
					state.setString(1, mashNameTF.getText());
					state.execute();
					refreshMTable("MTABLE", mashTable);
					refreshComboM();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				mashNameTF.setText("");
			}
		}
	}
	// �������� ������ "���������" �� �����
	class DelMashDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
//			conn=DBConnection.getConnection();
			if (idmash>0) {
				String sql="delete from mtable where id=?";
				try {
					state=conn.prepareStatement(sql);
					state.setInt(1, idmash);
					state.execute();
					refreshMTable("MTABLE", mashTable);
					refreshComboM();
				
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				mashNameTF.setText("");
			}
		}
	}
	// �������� ������ "�������" �� �����
	class EditMashDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
//			conn=DBConnection.getConnection();
			if(idmash>0) {
				String sql="update mtable set mashtab=? where id=?";
			
				try {
					state=conn.prepareStatement(sql);
					state.setString(1, mashNameTF.getText());
					state.setInt(2, idmash);
					state.execute();
					refreshMTable("MTABLE", mashTable);
					refreshComboM();
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				mashNameTF.setText("");
			}
			
		}
	}
	class MouseActionCarTable implements MouseListener{

		// �������� ���������� ����� ��� �� ��������� � ���������� ������
		@Override
		public void mouseClicked(MouseEvent e) {
			
			int row=carTable.getSelectedRow();
			
			// ��������� �� ���������� id �� ������� ��������� 		
			id=Integer.parseInt(carTable.getValueAt(row, 0).toString());
			
			carNameTF.setText(carTable.getValueAt(row, 1).toString());
			carOpisTF.setText(carTable.getValueAt(row, 6).toString());
			carBrTF.setText(carTable.getValueAt(row, 7).toString());
			carPriceTF.setText(carTable.getValueAt(row, 8).toString());
			carYearTF.setText(carTable.getValueAt(row, 10).toString());
			
			// ��������� �� ��������� ����� � ���������� �� ������������
			comboPr.setSelectedItem(carTable.getValueAt(row, 2).toString());
			// ��������� �� ���������� id �� ������������
			idpr=Integer.parseInt(carTable.getValueAt(row, 3).toString());
			
			// ��������� �� ��������� ����� � ���������� �� �����
			comboM.setSelectedItem(carTable.getValueAt(row, 4).toString());
			// ��������� �� ���������� id �� �����
			idmash=Integer.parseInt(carTable.getValueAt(row, 5).toString());
		
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class MouseActionPrTable implements MouseListener{

		// �������� ���������� ����� ��� �� ��������� � �������������
		@Override
		public void mouseClicked(MouseEvent e) {
			int row=prTable.getSelectedRow();
			idpr=Integer.parseInt(prTable.getValueAt(row, 0).toString());
			
			prNameTF.setText(prTable.getValueAt(row, 1).toString());
		
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class MouseActionMashTable implements MouseListener{

		// �������� ���������� ����� ��� �� ��������� � ������
		@Override
		public void mouseClicked(MouseEvent e) {
			int row=mashTable.getSelectedRow();
			idmash=Integer.parseInt(mashTable.getValueAt(row, 0).toString());
			
			mashNameTF.setText(mashTable.getValueAt(row, 1).toString());
		
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	//���� �� ���������� �� ������ ������� �� ���������
	class SearchDB implements ActionListener {
		public void actionPerformed (ActionEvent arg0) {
//			conn=DBConnection.getConnection();
			// if ���������� � ��������� ������ �������� ����
			if(!sprCarPriceTF.getText().isEmpty()) {
				if(Double.parseDouble(sprCarPriceTF.getText())>0) {
			
					String str="select ARTTABLE.id, name, PRTABLE.proizvoditel,ARTTABLE.idproizvoditel, MTABLE.mashtab,ARTTABLE.idmashtab, opis, kol,cena,datein,year from ARTTABLE,MTABLE,PRTABLE where ARTTABLE.idmashtab=MTABLE.id and ARTTABLE.idproizvoditel=PRTABLE.id and ARTTABLE.cena<="+Double.parseDouble(sprCarPriceTF.getText());
					try {
						state=conn.prepareStatement(str);
						result=state.executeQuery();
						sprTable.setModel(new MyTModel(result));
				
						sprTable.getColumnModel().getColumn(3).setMinWidth(0);
						sprTable.getColumnModel().getColumn(3).setMaxWidth(0);
						sprTable.getColumnModel().getColumn(3).setWidth(0);

						sprTable.getColumnModel().getColumn(5).setMinWidth(0);
						sprTable.getColumnModel().getColumn(5).setMaxWidth(0);
						sprTable.getColumnModel().getColumn(5).setWidth(0);
			
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sprCarPriceTF.setText("");
				}
			}
		}

	}
}
