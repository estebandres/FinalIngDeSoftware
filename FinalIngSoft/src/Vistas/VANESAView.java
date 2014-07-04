package Vistas;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

import Modelos.BeatModelInterface;

public class VANESAView extends JFrame implements BeatObserver, BPMObserver{
		BeatModelInterface model;
		JProgressBar jp;
		JLabel etiqueta;

		public VANESAView(BeatModelInterface model) {
			this.model = model;
			model.registerObserver((BeatObserver)this);
			model.registerObserver((BPMObserver)this);
			try {
				UIManager
						.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (Exception e) {
			}
			setTitle("VANESA View");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLayout(new GridLayout(2,1));
			setLocationRelativeTo(null);
			setVisible(true);
			// Create a progress bar
			jp = new JProgressBar();
			etiqueta=new JLabel("Volúmen Mic: 20");
			// Paint the percent complete on progress bar
			jp.setStringPainted(true);
			// Set a size (optional)
			jp.setPreferredSize(new Dimension(500, 30));
			// Start at 0
			jp.setMinimum(0);
			// End at 1000
			jp.setMaximum(100);
			jp.setValue(20);
			add(jp);
			add(etiqueta);
			pack();
		}


		@Override
		public void updateBPM() {
			// TODO Auto-generated method stub
			if (model != null) {
				int bpm = model.getBPM();
				if (bpm == 0) {
					if (etiqueta != null) {
	        			etiqueta.setText("Fuera de Rango");
					}
				} else {
					if (etiqueta != null) {
	        			etiqueta.setText("Volumen Mic: " + model.getBPM());
					}
				}
			}
			//etiqueta.setText("Volúmen Mic: "+model.getBPM());
			
		}

		@Override
		public void updateBeat() {
			// TODO Auto-generated method stub
			if (jp != null) {
				jp.setValue(model.getBPM());
			}
		}
}