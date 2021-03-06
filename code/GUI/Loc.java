package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import filtersPack.Filter;
import filtersPack.filter_id;
import filtersPack.filter_location;
import objects.hash;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class Loc extends JPanel {
	private JTextField lat;
	private JTextField lon;
	private JTextField rad;

	/**
	 * Create the panel.
	 */
	public Loc(Filter []filters,Connect c) {
		setLayout(null);

		JLabel lblNewLabel = new JLabel(" Write Lat");
		lblNewLabel.setBounds(25, 35, 144, 40);
		lblNewLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		add(lblNewLabel);

		JLabel lblWriteLon = new JLabel(" Write Lon");
		lblWriteLon.setBounds(25, 102, 144, 40);
		lblWriteLon.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		add(lblWriteLon);

		JLabel lblWriteRadious = new JLabel(" Write Radious");
		lblWriteRadious.setBounds(25, 169, 210, 40);
		lblWriteRadious.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		add(lblWriteRadious);

		lat = new JTextField();
		lat.setBounds(207, 42, 231, 40);
		add(lat);
		lat.setColumns(10);

		lon = new JTextField();
		lon.setBounds(207, 95, 231, 40);
		lon.setColumns(10);
		add(lon);

		rad = new JTextField();
		rad.setBounds(247, 169, 191, 40);
		rad.setColumns(10);
		add(rad);

		JButton btnNewButton = new JButton(" Enter");
		btnNewButton.setBounds(121, 235, 191, 40);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String lat1 = lat.getText();
					String lon1 = lon.getText();
					String rad1 = rad.getText();
					Filter ft = new filter_location(lat1, lon1, Double.parseDouble(rad1));
					if (!(""+filters[1]).equals("null") && !(""+filters[0]).equals("null")) {
						filters[2] = ft;
						if (filters[1].getClass().getName().contains("AND_filter")) {
							c.and_filter(filters[0], filters[2]);
							JOptionPane.showMessageDialog(new JFrame(), "Filters got finished");
							JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
							filters_writeAndRead.write_filter("matala two\\filter that have been choose.txt", filters);
							JOptionPane.showMessageDialog(new JFrame(), "Information file about filters saved as 'filter that have been choose.txt' in this project in 'matala two' folder.");

						} else if (filters[1].getClass().getName().contains("OR_filter")) {
							c.OR_filter(filters[0], filters[2]);
							JOptionPane.showMessageDialog(new JFrame(), "Filters got finished");
							JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
							filters_writeAndRead.write_filter("matala two\\filter that have been choose.txt", filters);
							JOptionPane.showMessageDialog(new JFrame(), "Information file about filters saved as 'filter that have been choose.txt' in this project in 'matala two' folder.");

						}
					} else if (!(""+filters[1]).equals("null") && (""+filters[0]).equals("null")) {
						filters[0] = ft;
						JOptionPane.showMessageDialog(new JFrame(), "Filter eccepted");

					}

					else if ((""+filters[0]).equals("null") && (""+filters[1]).equals("null")) {
						filters[0] = ft;
						c.addfilter_LOC(lat1, lon1, Double.parseDouble(rad1));
						JOptionPane.showMessageDialog(new JFrame(), "Filter by location got finished");
						JOptionPane.showMessageDialog(new JFrame(), hash.HowMacAndRow(c.macs));
						filters_writeAndRead.write_filter("matala two\\filter that have been choose.txt", filters);
						JOptionPane.showMessageDialog(new JFrame(), "Information file about filters saved as 'filter that have been choose.txt' in this project in 'matala two' folder.");
					} 
					

				} catch (Exception e) {
					JOptionPane.showMessageDialog(new JFrame(), "Filter by location failed");

				}


			}
		});
		btnNewButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 33));
		add(btnNewButton);

	}

}
