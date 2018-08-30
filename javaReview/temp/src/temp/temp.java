package temp;

import java.awt.*; //GUI ��ü�� ����ϱ� ���� ��Ű��
import java.awt.event.*; //�̺�Ʈ �߻��� ���� ��Ű��
import javax.swing.*; //swing������Ʈ�� ����ϱ� ���� ��Ű��   
import java.util.Calendar; //��¥ ����� ���� ��Ű��

public class temp extends JFrame implements ItemListener, ActionListener { // JFrame��ӹް�
																				// ItemListener,ActionListener
																				// �������̽�
																				// ���
	public static byte[] bytecounter; // ���ڼ� ����� ���� bytecounter ����

	private boolean isButton = false; // �۲�Ȯ�ι�ư����
	private String name = "����"; // �⺻ �۲�
	private int style = 0; // �⺻ ��Ʈ
	private int fontsize = 12; // �⺻ ��Ʈ ������

	// font ������Ʈ
	// ����-----------------------------------------------------------------------------
	JPanel fontPanel1, fontPanel2; // Panel ����
	Choice fontCombo1, fontCombo2, fontCombo3; // Choice ����
	JButton fontConfim, fontCancel; // Button ����
	String[] fontList = { "����", "����ü", "�ü�", "�ü�ü", "�߰��", "���ü", "verdana" }; // fontCombo1��
																				// ��
																				// ����Ʈ
	String[] fontStyleList = { "����", "�����", "����" }; // fontCombo2�� �� ����Ʈ
	String[] fontSizeList = { "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", // fontCombo3��
																											// ��
																											// ����Ʈ
			"30", "40", "60", "72" };
	JTextField txtFont, txtFontStyle, txtFontSize; // JTextField 3�� ����
	JFrame fontFrame; // �۲�â �����ӻ���
	// -------------------------------------------------------------------------------------------

	JMenuBar menuBar = new JMenuBar(); // �޴��� ����

	JMenu mnFile = new JMenu("����(F)"); // ���� �޴�
	JMenu mnEdit = new JMenu("����(E)"); // ���� �޴�
	JMenu mnForm = new JMenu("����(O)"); // ���� �޴�
	JMenu mnHelp = new JMenu("����(H)"); // ���� �޴�

	JMenuItem new_m = new JMenuItem("���� �����(N)"); // ���θ���� �׸� ����
	JMenuItem open_m = new JMenuItem("�� ��(O)"); // ���� �׸� ����
	JMenuItem save_m = new JMenuItem("�� ��(S)"); // ���� �׸� ����
	JMenuItem exit_m = new JMenuItem("�� ��(X)"); // ���� �׸� ����

	JMenuItem cut_m = new JMenuItem("�߶󳻱�(T)"); // �߶󳻱� �׸� ����
	JMenuItem copy_m = new JMenuItem("�����ϱ�(C)"); // �����ϱ� �׸� ����
	JMenuItem paste_m = new JMenuItem("�ٿ��ֱ�(P)"); // �ٿ��ֱ� �׸� ����
	JMenuItem allsel_m = new JMenuItem("��� ����(A)"); // ��ü���� �׸� ����
	JMenuItem del_m = new JMenuItem("����(L)"); // ���� �׸� ����

	JMenuItem font_m = new JMenuItem("�۲�(F)..."); // �۲� �׸� ����

	JMenuItem info_m = new JMenuItem("�޸��� ����(A)"); // �޸��� ���� �׸� ����
	JMenuItem time_m = new JMenuItem("�ð�����"); // �ð� ���� �׸� ����

	JFileChooser jfc = new JFileChooser(); // ���̾�α� â ���� Ŭ���� ����

	JTextArea txtArea = null; // txtArea Ŭ���� ����
	JScrollPane scrollPane = null; // scrollPane Ŭ���� ����
	JTextField txtField = new JTextField(); // txtField Ŭ���� ����

	public NotePad() {
		super("�޸���-�������");
		/// NotePad ������Ʈ
		/// ����-------------------------------------------------------------
		add(menuBar, "North");
		menuBar.add(mnFile);
		menuBar.add(mnEdit);
		menuBar.add(mnForm);
		menuBar.add(mnHelp); // �޴��� ����
		mnFile.add(new_m);
		mnFile.add(open_m);
		mnFile.add(save_m);
		mnFile.addSeparator();
		mnFile.add(exit_m); // ���� �޴� ����
		mnEdit.add(cut_m);
		mnEdit.add(copy_m);
		mnEdit.add(paste_m);
		mnEdit.add(del_m);
		mnEdit.addSeparator();
		mnEdit.add(allsel_m);
		mnEdit.add(time_m); // ���� �޴� ����
		mnForm.add(font_m);// ���� �޴� ����
		mnHelp.add(info_m); // ���� �޴� ����
		scrollPane = new JScrollPane(txtArea = new JTextArea()); // scrollPane��
																	// txtArea
																	// ����
		add(scrollPane, "Center"); // scrollPane ������Ʈ�� �����ӿ� �߰��ϰ� ��ġ ����
		add(txtField, "South"); // txtField ������Ʈ�� �����ӿ� �߰��ϰ� ��ġ ����
		scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum()); // ��ũ����
																									// ���ϴ�����
																									// ����
		validate();
		// ---------------------------------------------------------------------------------

		// font ������Ʈ
		// ����------------------------------------------------------------------
		fontFrame = new JFrame("�۲�");// ������ ����
		fontPanel1 = new JPanel(); // fontpanel1 ����
		fontPanel2 = new JPanel(); // fontpanel2 ����

		txtFont = new JTextField(10); // �۲�
		txtFontStyle = new JTextField(8);// �۲ý�Ÿ��
		txtFontSize = new JTextField(5); // ũ��
		fontConfim = new JButton("Ȯ��"); // Ȯ�ι��v
		fontCancel = new JButton("���"); // ��ҹ�ư

		// Choice ��ü ����
		fontCombo1 = new Choice();
		fontCombo2 = new Choice();
		fontCombo3 = new Choice();

		// �޺����ڿ� ����Ʈ�� ���
		for (int i = 0; i < fontList.length; i++) {
			fontCombo1.add(fontList[i]);
		}
		for (int i = 0; i < fontStyleList.length; i++) {
			fontCombo2.add(fontStyleList[i]);
		}
		for (int i = 0; i < fontSizeList.length; i++) {
			fontCombo3.add(fontSizeList[i]);
		}

		// choice �ʱ� ���ð�
		fontCombo1.select(0);
		fontCombo2.select(0);
		fontCombo3.select(4);

		// fontPanel1�� lable,JTextField, Choice �߰�
		fontPanel1.setLayout(new GridLayout(3, 3)); // GridLayout ����
		fontPanel1.add(new Label("�۲� "));
		fontPanel1.add(new Label("�۲ý�Ÿ�� "));
		fontPanel1.add(new Label("ũ��"));
		fontPanel1.add(txtFont);
		fontPanel1.add(txtFontStyle);
		fontPanel1.add(txtFontSize);
		fontPanel1.add(fontCombo1);
		fontPanel1.add(fontCombo2);
		fontPanel1.add(fontCombo3);

		// fontPanel2�� Ȯ�ΰ� ��ҹ�ư �߰�
		fontPanel2.setLayout(new GridLayout(3, 1)); // GridLayout ����
		fontPanel2.add(fontConfim);
		fontPanel2.add(fontCancel);

		// fontFrame�� fontPanel1,2�� ����
		fontFrame.add(fontPanel2, BorderLayout.EAST);
		fontFrame.add(fontPanel1, BorderLayout.CENTER);

		// fontFrame������ �̺�Ʈ�ڵ鷯
		fontFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				fontFrame.setVisible(false);
			}
		});

		fontConfim.addActionListener(this); // Ȯ�� �׼� �̺�Ʈ �ڵ鷯
		fontCancel.addActionListener(this); // ��� �׼� �̺�Ʈ �ڵ鷯
		fontCombo1.addItemListener(this); // Combo1 Choice �̺�Ʈ �ڵ鷯
		fontCombo2.addItemListener(this); // Combo2 Choice �̺�Ʈ �ڵ鷯
		fontCombo3.addItemListener(this); // Combo3 Choice �̺�Ʈ �ڵ鷯

		fontFrame.setBounds(300, 300, 300, 100);
		// ---------------------------------------------------------------------------------

		// �̺�Ʈ
		// ���---------------------------------------------------------------------
		// ���ϸ޴� �̺�Ʈ
		new_m.addActionListener(this); // ���θ���� �׼��̺�Ʈ�ڵ鷯
		new_m.setAccelerator(KeyStroke.getKeyStroke('N', Event.CTRL_MASK)); // ���θ����
																			// ����Ű
																			// ����
																			// Ctrl+N
		open_m.addActionListener(this); // ���� �׼��̺�Ʈ�ڵ鷯
		open_m.setAccelerator(KeyStroke.getKeyStroke('O', Event.CTRL_MASK)); // ����
																				// ����Ű
																				// ����
																				// Ctrl+O
		save_m.addActionListener(this); // ���� �׼��̺�Ʈ�ڵ鷯
		save_m.setAccelerator(KeyStroke.getKeyStroke('S', Event.CTRL_MASK)); // ����
																				// ����Ű
																				// ����
																				// Ctrl+S
		exit_m.addActionListener(this); // ���� �׼��̺�Ʈ�ڵ鷯
		exit_m.setAccelerator(KeyStroke.getKeyStroke('Q', Event.CTRL_MASK)); // ����
																				// ����Ű
																				// ����
																				// Ctrl+Q

		// �����޴� �̺�Ʈ
		cut_m.addActionListener(this); // �߶󳻱� �׼��̺�Ʈ�ڵ鷯
		cut_m.setAccelerator(KeyStroke.getKeyStroke('X', Event.CTRL_MASK)); // �߶󳻱�
																			// ����Ű
																			// ����
																			// Ctrl+X
		copy_m.addActionListener(this); // �����ϱ� �׼��̺�Ʈ�ڵ鷯
		copy_m.setAccelerator(KeyStroke.getKeyStroke('C', Event.CTRL_MASK)); // �����ϱ�
																				// ����Ű
																				// ����Ctrl+C
		paste_m.addActionListener(this); // �ٿ��ֱ� �׼��̺�Ʈ�ڵ鷯
		paste_m.setAccelerator(KeyStroke.getKeyStroke('V', Event.CTRL_MASK)); // �ٿ��ֱ�
																				// ����Ű
																				// ����
																				// Ctrl+V
		allsel_m.addActionListener(this); // ��ü���� �׼��̺�Ʈ�ڵ鷯
		allsel_m.setAccelerator(KeyStroke.getKeyStroke('A', Event.CTRL_MASK));// ��ü����
																				// ����Ű
																				// ����
																				// Ctrl+A
		del_m.addActionListener(this); // ���� �׼��̺�Ʈ�ڵ鷯
		del_m.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0)); // ����
																				// ����Ű
																				// ����
																				// Delete

		// �ð���Ÿ����------------------------------------------------------------------------
		time_m.addActionListener(new ActionListener() // �ð����� �׼��̺�Ʈ �ڵ鷯
		{
			public void actionPerformed(ActionEvent e) {
				Calendar cal = Calendar.getInstance(); // ����ð��� ����ϱ� ���Ͽ�
														// getInstance()�޼��� ���
				int year = cal.get(Calendar.YEAR); // Calendar ��ü���� �ش� �⵵���� ����
				int month = cal.get(Calendar.MONTH); // Calendar ��ü���� �ش� ������ ����
				int day = cal.get(Calendar.DAY_OF_MONTH); // Calendar ��ü���� �ش�
															// �ϰ��� ����
				int hour = cal.get(Calendar.HOUR); // Calendar ��ü���� �ð����� ����
				int minutes = cal.get(Calendar.MINUTE); // Calendar ��ü���� �а��� ����
				int second = cal.get(Calendar.SECOND); // Calendar ��ü���� �ʰ��� ����

				txtArea.setText(txtArea.getText() + year + "��" + month + "��" + day + "��" + hour + "��" // txtArea��
																										// ����
						+ minutes + "��" + second + "��");
			}
		});
		time_m.setAccelerator(KeyStroke.getKeyStroke("F5")); // �ð� ���� ����Ű ���� F5
		// -------------------------------------------------------------------------------------

		font_m.addActionListener(this);// �۲� �׼��̺�Ʈ �ڵ鷯

		// ���򸻸޴�
		// �̺�Ʈ--------------------------------------------------------------------
		info_m.addActionListener(new ActionListener() // �޸��� ���� �׼� �̺�Ʈ �ڵ鷯
		{
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "������"); // ������ �����ִ� ���̾�α׸�
															// ����
			}
		});

		// -------------------------------------------------------------------------------------

		// TextFiled��
		// ���ڼ�(byte)��Ÿ����--------------------------------------------------------
		txtArea.addKeyListener(new KeyListener() // Ű �׼� �̺�Ʈ �ڵ鷯
		{
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			public void keyReleased(KeyEvent e) // Ű�� ������ �������� �̺�Ʈ �߻�
			{
				// TODO Auto-generated method stub
				String text; // text
				int length; // length
				text = txtArea.getText(); // txtArea�� ���ڿ� ��ȯ
				bytecounter = text.getBytes(); // bytecounter�� text����Ʈ ��ȯ
				length = bytecounter.length; // bytecounter�� �̿��� ���ڱ��� ���
				txtField.setText((length) + "byte(s)"); // txtField�� ���ڿ� ����
				txtField.setHorizontalAlignment(JTextField.RIGHT); // txtField��
																	// �Է°� ��ġ����
			}

			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});

		setSize(800, 500);
		setVisible(true); // ������ ����
	}
	// ---------------------------------------------------------------------------------------

	// ---------------------------------------------------------------------------------------
	// �� �� �� �� Ʈ �� �� ��
	// ---------------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e) {

		String itemPressed = e.getActionCommand();

		if (itemPressed.equals("�� ��(O)")) { // ���� ���ý� �̺�Ʈ
			jfc.showOpenDialog(this); // ����Dialogâ ����
		}

		if (itemPressed.equals("�� ��(S)")) { // ���� ���ý� �̺�Ʈ
			jfc.showSaveDialog(this); // ����Dialogâ ����
		}

		if (itemPressed.equals("���� �����(N)")) { // ���θ���� ���ý� �̺�Ʈ
			int r = JOptionPane.showConfirmDialog(this, "�����Ͻðڽ��ϱ�?", "Confirm Dialog", JOptionPane.YES_NO_OPTION); // Ȯ��â
																													// ����
			txtArea.setText("");
			if (r == 0) { // �� ���� ��� ����
				jfc.showSaveDialog(this); // ����Dialogâ ����
			}
		}

		if (itemPressed.equals("�� ��(X)")) { // ���� ���ý� �̺�Ʈ
			int r = JOptionPane.showConfirmDialog(this, "�����Ͻðڽ��ϱ�?", "Confirm Dialog", JOptionPane.YES_NO_OPTION); // Ȯ��â
																													// ����
			if (r == 0) { // �� ���� ��� ����
				jfc.showSaveDialog(this); // ����Dialogâ ����
			}
			System.exit(0); // â ����
		}

		if (itemPressed.equals("�߶󳻱�(T)")) { // �߶󳻱� ���
			txtArea.cut();
		}

		if (itemPressed.equals("�����ϱ�(C)")) { // ���� ���
			txtArea.copy();
		}

		if (itemPressed.equals("�ٿ��ֱ�(P)")) { // �ٿ��ֱ� ���
			txtArea.paste();
		}

		if (itemPressed.equals("��� ����(A)")) { // ��ü���� ���
			txtArea.selectAll();
		}

		if (itemPressed.equals("����(L)")) { // ���� ���

			txtArea.replaceSelection("");
		}

		if (e.getSource().equals(font_m)) { // �۲� ���
			fontFrame.setVisible(true);
		}
		if (e.getSource().equals(fontConfim)) { // Ȯ�ι�ư
			isButton = true;
			fontFrame.setVisible(false);
			txtArea.setFont(new Font(name, style, fontsize));// ����ü, ��Ÿ��, size
																// ����
		} else if (e.getSource().equals(fontCancel)) { // ��ҹ�ư
			isButton = false;
			fontFrame.setVisible(false);
		}

	}

	// font ����
	// �޼���--------------------------------------------------------------------------
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource().equals(fontCombo1)) { // �۲� ��Ʈ Choice ����
			name = fontCombo1.getSelectedItem(); // �۲� ����
			txtFont.setText(name); // �۲� ����
		}
		if (e.getSource().equals(fontCombo2)) { // �۲� ��Ÿ�� Choice ����
			String style1 = fontCombo2.getSelectedItem();
			if (style1 == "����") {
				style = 0;
			} else if (style1 == "�����") {
				style = Font.ITALIC;
			} else if (style1 == "����") {
				style = Font.BOLD;// ��Ÿ�� ����
			}
			txtFontStyle.setText(style1); // �۲� ��Ÿ�� ����
		}

		if (!fontCombo3.getSelectedItem().equals("���������")) { // �۲� ũ�� Choice ����
			fontsize = Integer.parseInt(fontCombo3.getSelectedItem());// �۲� ������
																		// ����
			txtFontSize.setText(fontCombo3.getSelectedItem()); // �۲� ������ ����
		}
		if (isButton) {
			txtArea.setFont(new Font(name, style, fontsize)); // txtArea�� ��Ʈ ����
																// ����
		}
	}

	// ------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		new NotePad();
	}// main
}// class
