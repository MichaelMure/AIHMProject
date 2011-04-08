package mvc;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class ImageListModel extends DefaultListModel {

	private static final long serialVersionUID = 7177550027633559866L;

	public int getIndexFrom(ImagePanel panel) {
		for(int i = 0; i < this.getSize(); i++) {
			if(this.getElementAt(i).equals(panel))
				return i;
		}
		return -1;
	}
	
	public ImagePanel getElementAt(int index) {
		return (ImagePanel) super.getElementAt(index);
	}

	public ArrayList<ImagePanel> getPanels() {
		ArrayList<ImagePanel> panels = new ArrayList<ImagePanel>();
		for(int i = 0; i < this.getSize(); i++)
			panels.add(this.getElementAt(i));
		
		return panels;
	}
	
	public int[] getSelectedIndices() {
		ArrayList<Integer> indices = new ArrayList<Integer>();
		for(int i = 0; i < this.getSize(); i++) {
	        if (this.getElementAt(i).isSelected()) {
	        	indices.add(i);
	        }
		}
		return this.toIntArray(indices);
	}
	
	private int[] toIntArray(ArrayList<Integer> list)  {
	    int[] ret = new int[list.size()];
	    int i = 0;
	    for (Integer e : list)  
	        ret[i++] = e.intValue();
	    return ret;
	}
}
