package gabywald.global.dialog.controller;

import gabywald.global.view.dialog.GenericAskingDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * 
 * @author Gabriel Chandesris (2011)
 */
public class GenericAskingDialogListener implements ActionListener {
	private GenericAskingDialog dlg;
	
	public GenericAskingDialogListener(GenericAskingDialog dlg) 
		{ this.dlg = dlg; }

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button			= (JButton)e.getSource();
		// SkillAskingDialog dlg	= new SkillAskingDialog.getInstance();
		if (button == this.dlg.getRecordButton()) {
			this.dlg.setAnswer(0);
			this.dlg.setVisible(false);
		} else if (button == this.dlg.getNoRecoButton()) {
			this.dlg.setAnswer(1);
			this.dlg.setVisible(false);
		} else if (button == this.dlg.getCancelButton()) {
			this.dlg.setAnswer(2);
			this.dlg.setVisible(false);
		} 
	}

}
