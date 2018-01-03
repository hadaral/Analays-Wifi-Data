package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import filtersPack.Filter;
import filtersPack.NOT_filter;
import filtersPack.filter_id;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class withoutID extends JPanel {
	private JTextField id;

	/**
	 * Create the panel.
	 */
	public withoutID(Filter[] filters,Connect c) {
		setLayout(null);
		
		JLabel label = new JLabel(" Please enter ID display");
		label.setFont(new Font("Berlin Sans FB", Font.PLAIN, 43));
		label.setBounds(12, 37, 426, 60);
		add(label);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(33, 129, 386, 46);
		add(id);
		
		JButton button = new JButton("Enter");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id1 = id.getText();
				Filter ft = new filter_id(id1);
				Filter filter = new NOT_filter(ft);
				
				if(filters[1]!=null && filters[0]!=null){
					filters[2]= ft;
					
					if(filters[1].getClass().getName().contains("AND_filter")){
						
						c.and_filter(filters[0], filters[2]);
					}
					else if(filters[1].getClass().getName().contains("OR_filter")){
						c.OR_filter(filters[0], filters[2]);
					}
				}
				else if(filters[1]!=null && filters[0]==null){
					filters[0]= ft;
				}
				

				else if(filters[0]==null&&filters[1]==null){
					filters[0]=ft;
					c.NOT_filter_ID(id1);
				}

				JOptionPane.showMessageDialog(new JFrame(), "Filter by NOT-ID got finished");
			}
		});
		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 41));
		button.setBounds(123, 207, 191, 46);
		add(button);
		
		JLabel label_1 = new JLabel(" NOT");
		label_1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		label_1.setBounds(188, 0, 56, 28);
		add(label_1);

	}

}
