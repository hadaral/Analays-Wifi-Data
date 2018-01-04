package GUI;

import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;

import filtersPack.Filter;
import filtersPack.NOT_filter;
import filtersPack.filter_location;
import filtersPack.filter_time;
import objects.hash;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class withoutTime extends JPanel {
	JPanel OrA;

	/**
	 * Create the panel.
	 */
	public withoutTime(Filter[] filters,Connect c) {
		String min_sec [] = new String [60];
		min_sec[0]="00";
		min_sec[1]="01";
		min_sec[2]="02";
		min_sec[3]="03";
		min_sec[4]="04";
		min_sec[5]="05";
		min_sec[6]="06";
		min_sec[7]="07";
		min_sec[8]="08";
		min_sec[9]="09";

		for (int i = 10; i < min_sec.length; i++) {
			min_sec[i]=""+i;
		}

		String hour [] = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16",
				"17","18","19","20","21","22","23","24"};
		setLayout(null);
		setLayout(null);

		
		
//		JDateChooser dateChooser = new JDateChooser();
//		springLayout.putConstraint(SpringLayout.NORTH, dateChooser, 6, SpringLayout.SOUTH, lblStart);
//		springLayout.putConstraint(SpringLayout.EAST, dateChooser, 0, SpringLayout.EAST, date1);
//		add(dateChooser);
		
		

		JLabel lblNewLabel = new JLabel(" Choose date and Time");
		lblNewLabel.setBounds(62, 10, 312, 37);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		add(lblNewLabel);
		
		JDateChooser date1 = new JDateChooser();
		date1.setBounds(12, 115, 157, 37);
		add(date1);

		JLabel lblEnd = new JLabel("End date");
		lblEnd.setBounds(286, 75, 124, 37);
		lblEnd.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		add(lblEnd);

		JDateChooser date2 = new JDateChooser();
		date2.setBounds(249, 115, 172, 37);
		add(date2);

		JLabel lblStartTime = new JLabel(" Start time");
		lblStartTime.setBounds(50, 146, 126, 32);
		lblStartTime.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		add(lblStartTime);

		JLabel lblEndTime = new JLabel(" End time");
		lblEndTime.setBounds(286, 146, 114, 32);
		lblEndTime.setFont(new Font("Berlin Sans FB", Font.PLAIN, 28));
		add(lblEndTime);

		JComboBox min1 = new JComboBox(min_sec);
		min1.setBounds(87, 184, 41, 22);
		add(min1);
		
		JComboBox sec1 = new JComboBox(min_sec);
		sec1.setBounds(135, 184, 41, 22);
		add(sec1);
		
		JComboBox hur1= new JComboBox(hour);
		hur1.setBounds(39, 184, 41, 22);
		add(hur1);
		
		JComboBox min2 = new JComboBox(min_sec);
		min2.setBounds(333, 184, 41, 22);
		add(min2);
		
		JComboBox sec2 = new JComboBox(min_sec);
		sec2.setBounds(380, 184, 41, 22);
		add(sec2);
		
		JComboBox hur2 = new JComboBox(hour);
		hur2.setBounds(286, 184, 41, 22);
		add(hur2);
		
		JButton btnNewButton = new JButton(" Enter");
		btnNewButton.setBounds(164, 279, 114, 45);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String date_min = date1.getDate().toLocaleString();
					String datte1 = date_min.substring(9, date_min.length());
					String date_max = date1.getDate().toLocaleString();
					String datte2 = date_max.substring(9, date_max.length());
					String tim1 = "" + hur1.getSelectedItem() + ":" + "" + min1.getSelectedItem() + ":" + ""
							+ sec1.getSelectedItem();
					String tim2 = "" + hur2.getSelectedItem() + ":" + "" + min2.getSelectedItem() + ":" + ""
							+ sec2.getSelectedItem();
					String timme1 = datte1 + " " + tim1;
					String timme2 = datte2 + " " + tim2;
					Filter ft = new filter_time(timme1, timme2);
					Filter filter = new NOT_filter(ft);
					if (!(""+filters[1]).equals("null") && !(""+filters[0]).equals("null")) {
						filters[2] = filter;
						if (filters[1].getClass().getName().contains("AND_filter")) {
							c.and_filter(filters[0], filters[2]);
							JOptionPane.showMessageDialog(new JFrame(), "Filters got finished");
							JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
							filters_writeAndRead.write_filter("matala two\\filter that have been choose.txt", filters);
						} else if (filters[1].getClass().getName().contains("OR_filter")) {
							c.OR_filter(filters[0], filters[2]);
							JOptionPane.showMessageDialog(new JFrame(), "Filters got finished");
							JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
							filters_writeAndRead.write_filter("matala two\\filter that have been choose.txt", filters);
						}
					} else if (!(""+filters[1]).equals("null") && (""+filters[0]).equals("null")) {
						filters[0] = filter;
						JOptionPane.showMessageDialog(new JFrame(), "Filter eccepted");

					}

					else if ((""+filters[0]).equals("null") && (""+filters[1]).equals("null")) {
						filters[0] = filter;
						c.addfilter_TIME(timme1, timme2);
						JOptionPane.showMessageDialog(new JFrame(), "Filter by time got finished");
						JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
						filters_writeAndRead.write_filter("matala two\\filter that have been choose.txt", filters);

					} 
					

				} 
				catch (Exception e2) {
					JOptionPane.showMessageDialog(new JFrame(), "Filter by time failed");
				}
			}
		});
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
		add(btnNewButton);
		
		JLabel lblStartDate = new JLabel("Start date");
		lblStartDate.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		lblStartDate.setBounds(32, 75, 154, 37);
		add(lblStartDate);
	}
}


//		
//		JButton button = new JButton(" Enter");
//		button.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String datte1 = date1.getDateFormatString();
//				String datte2 = date2.getDateFormatString();
//				String timme1 = datte1 +" "+time1.getText();
//				String timme2 = datte2 +" "+time2.getText();
//				Filter ft = new filter_time(timme1,timme2);
//				Filter filter = new NOT_filter(ft);
//				
//				if(filters[1]!=null && filters[0]!=null){
//					filters[2]= ft;
//					if(filters[1].getClass().getName().contains("AND_filter")){
//						c.and_filter(filters[0], filters[2]);
//					}
//					else if(filters[1].getClass().getName().contains("OR_filter")){
//						c.OR_filter(filters[0], filters[2]);
//					}
//				}
//				else if(filters[1]!=null && filters[0]==null){
//					filters[0]= ft;
//				}
//				
//
//				else if(filters[0]==null&&filters[1]==null){
//					filters[0]=ft;
//					c.NOT_filter_TIME(timme1,timme2);
//				}
//				
//				JOptionPane.showMessageDialog(new JFrame(), "Filter by NOT-time got finished");
//			}
//		});
//		button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 25));
//		button.setBounds(146, 246, 124, 41);
//		add(button);
//		
//		time2 = new JTextField();
//		time2.setColumns(10);
//		time2.setBounds(250, 213, 165, 31);
//		add(time2);
//		
//		time1 = new JTextField();
//		time1.setColumns(10);
//		time1.setBounds(33, 213, 165, 31);
//		add(time1);
//		
//		JLabel label_6 = new JLabel(" NOT");
//		label_6.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
//		label_6.setBounds(173, 0, 56, 28);
//		add(label_6);
//
//	}
//}
