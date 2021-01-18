package majorandminor;

import java.util.ArrayList;

public class GetKeys {
	
	private int[] naturalminor = new int[] {2,1,2,2,1,2,2}; //molli
	private int[] harmonicminor = new int[] {2,1,2,2,1,3,1};
	private int[] melodicminor = new int[] {2,1,2,2,2,2,1};
	private int[] naturalmajor = new int[] {2,2,1,2,2,2,1}; //duuri
	private int[] harmonicmajor = new int[] {2,2,1,2,1,3,1};
	
	private ArrayList<int[]> minorsandmajors;
	
	private String[] keys = new String[] {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
	
	public GetKeys() {
		minorsandmajors = new ArrayList<int[]>();
		minorsandmajors.add(naturalminor);
		minorsandmajors.add(harmonicminor);
		minorsandmajors.add(melodicminor);
		minorsandmajors.add(naturalmajor);
		minorsandmajors.add(harmonicmajor);
	}
	
	public String[] getOctave(int startingFrom, int typeNM) {
		String[] returnable = new String[7];
		
		int a = startingFrom;
		
		for(int i = 0; i < 7; i++) {
			returnable[i] = keys[a];
			if(a + minorsandmajors.get(typeNM)[i] < 12) {
				a = a + minorsandmajors.get(typeNM)[i];
			}
			else {
				a = (a + minorsandmajors.get(typeNM)[i]) - 12;
			}
		}
		
		return returnable;
	}
	
	public String[] getAllKeys() {
		return keys;
	}
}
