import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;

/* The class which contains all the methods for the database*/
public class Entry {
	
	private int keylength;
	private Map<String, ArrayList<Integer>> map;
	private ArrayList<String> keys;
	public Entry(){
		map = new HashMap<String, ArrayList<Integer>>();
		keys= new ArrayList<>();
	}
	
	
	/*The set function, which creates a keys list and a hashmap*/
	public void setter(String[] set_array){
		
		if( set_array.length>=2){		
			ArrayList<Integer> copyList= new ArrayList<Integer>(); //makes a list of the set given
			for(int i=2;i<set_array.length;i++){
				copyList.add(Integer.parseInt(set_array[i]));
			}
			if(! keys.contains(set_array[1])){ //checks, if the key is present, if it is, it won't be taken
				keys.add(set_array[1]);
				}
			map.put(set_array[1],copyList); // puts the key and the list into the hashmap
			System.out.println("ok");			
			}
		else{
			System.out.println("try again");			
		}		
	}
	
	
	/* Creates a String output from a list, e.g- [1, 2]=[1 2]*/
	public void stringMaker(ArrayList<Integer> new_list){
		
		String values="";				
			for(int i=0;i<new_list.size();i++){
				values+=Integer.toString(new_list.get(i));
				values+=" ";
				}
			int length=values.length();
			keylength=length;				
			if (length>0){
				values = values.substring(0,length-1); // removes the last element(space)
				}
			System.out.println("["+values+"]");		
	}
	
	
	/*The get function, which creates a string of the ouput of the list wanted, by removing commas*/
	public void getter(String[] get_array){
		
		if(get_array.length>=2){
			if ((! map.isEmpty())&&(keys.contains(get_array[1]))){ //checks if the key is present
				ArrayList<Integer> new_list= new ArrayList<>();
				new_list=map.get(get_array[1]);			
				stringMaker(new_list);
			}
			else{
				System.out.println("no such key");
				}
			}
		else{
			System.out.println("try again");
			}
	}
	
	
	/*The list keys function, which iterates through the keys list and prints it in reverse*/
	public void list_keys(String[] list_array){
		
		if(! keys.isEmpty()){			//checks if the key list is empty or not
			for(int i=keys.size()-1;i>=0;i--){
				System.out.println(keys.get(i));
			}
		}
		else{
			System.out.println("no keys");
			}
	}
	
	
	/*The list_entries function, which lists down the keys and its linked list*/
	public void list_entries(String[] get_array){
		
		if (! keys.isEmpty()){		//checks if the key list is empty or not
			for(int j=map.size()-1;j>=0;j--){				
				ArrayList<Integer> new_list= new ArrayList<>();
				new_list=map.get(keys.get(j)); //gets the lists from te hashmap, and puts it into the new_list
				
				System.out.print(keys.get(j));
				System.out.print(" ");
				stringMaker(new_list);			
			}
		} 
		else{
			System.out.println("no entries");
			}
		}
	
	
	/*The sum fuction, which outpurs the sum of the key wanted*/
	public void get_sum(String[] sum_array){
		
		if(sum_array.length>1){			
			if((! keys.isEmpty())&&(keys.contains(sum_array[1]))){	//checks if the key exists			
				int sum=0;
				ArrayList<Integer> sumlist= new ArrayList<>();
				sumlist=map.get(sum_array[1]);				//copies list into sumlist
				for(int i=0;i<sumlist.size();i++){
					sum+=(sumlist.get(i));
				}
				System.out.println(sum);
			}
			else{
				System.out.println("no such key");
				}
			}
		else{
			System.out.println("try again");
			}
		}
	
	
	/*The max function, which outputs the maximum value of the list given by the key*/
	public void get_max(String[] max_array){
		
		if(max_array.length>1){			
			if((! keys.isEmpty())&&(keys.contains(max_array[1]))){	//checks if the key exists	
				ArrayList<Integer> maxlist= new ArrayList<>();
				maxlist=map.get(max_array[1]); //copies list into maxlist
				int maxi=maxlist.get(0);				
				for(int i=0;i<maxlist.size();i++){					
					if (maxlist.get(i)>=maxi){
						maxi=maxlist.get(i);
					}
				}
				System.out.println(maxi);
				}
			else{
				System.out.println("no such key");
				}
			}
		else{
			System.out.println("try again");
			}
	}
	
	
	/*The minimum function, which outputs the minimum value of the list given by the key*/
	public void get_min(String[] min_array){
		
		if(min_array.length>1){			
			if((! keys.isEmpty()) &&(keys.contains(min_array[1]))){		//checks if the key exists		
				ArrayList<Integer> minList= new ArrayList<>();
				minList=map.get(min_array[1]); //copies list into minlist
				int mini=minList.get(0);				
				for(int i=0;i<minList.size();i++){					
					if (minList.get(i)<=mini){
						mini=minList.get(i);
					}
				}
				System.out.println(mini);
			}
			else{
				System.out.println("no such key");
				}
			}
		else{
			System.out.println("try again");
			}
	}
	
	/*The remove function, which removes the key and its corresponding sets from the key list and the hashmap*/
	public void remover(String[] remove_array){
		
		if(remove_array.length>1){
			if(keys.contains(remove_array[1])){ //checks if the key exists
				String key=remove_array[1];
				map.remove(key);
				keys.remove(key);
				System.out.println("ok");
			}
			else{
				System.out.println("no such key");
				}
			}
		else{
			System.out.println("try again");
		}
	}
	
	/*The pick function, which outputs the value of the given index of the given key*/
	public void picker(String[] pick_array){
		
		if(pick_array.length>2){			
			int index=Integer.parseInt(pick_array[2]);
			ArrayList<Integer> pickList= new ArrayList<>();
			pickList=map.get(pick_array[1]);			
			if (keys.contains(pick_array[1])){				//checks if the key exists
				if(index>0 && index<=pickList.size()){ //checks if index is within bounds
					pickList= map.get(pick_array[1]); //copies list into pickList
					System.out.println(pickList.get(index-1));
				}
				else{
					System.out.println("index out of range");
				}
			}
			else{
				System.out.println("no such key");
			}
		}
		else{
			System.out.println("try again");
			
		}
	}
	
	/*The pop function, which outputs the value of the first index and removes it from the set formed*/
	public void popper(String[] pop_array){
		
		if(pop_array.length>1){		
			ArrayList<Integer>popList= new ArrayList<>();
			String key1=pop_array[1];
			popList=map.get(key1); // copies list into popList
			if (keys.contains(key1)){				//checks if the key exists
				if(popList.size()>0){
					popList=map.get(key1);
					System.out.println(popList.get(0));
					popList.remove(0);
				}
				else{
					System.out.println("nil");
				}
			}
			else{
				System.out.println("no such key");
			}
		}
		else{
			System.out.println("try again");
		}
	}
	
	/*The pluck function, which outputs the value of the given index of the given key, and removes it from the list*/
	public void plucker(String[] plucker_array){
		
		if(plucker_array.length>2){			
			ArrayList<Integer>pluckList= new ArrayList<>();
			String key1=plucker_array[1];
			int index= Integer.parseInt(plucker_array[2]);
			pluckList=map.get(key1);			//copies list into pluckList
			if(keys.contains(key1)){				//checks if the key exists
				if((index<=pluckList.size()) &&(index>0)){
					System.out.println(pluckList.get(index-1));
					pluckList.remove(index-1);
				}
				else{
					System.out.println("index out of range");
				}
			}
			else{
				System.out.println("no such key");
			}
		}
		else{
			System.out.println("try again");
		}
	}
	
	
	/*The reverse function, which reverse the list of the key given*/
	public void reverser(String[] reverse_array){
		
		if(reverse_array.length>1){
			ArrayList<Integer>reverseList= new ArrayList<>();
			String key3=reverse_array[1];
			reverseList=map.get(key3);			//copies list into reverseList
			if ((!keys.isEmpty())&&(keys.contains(key3))){ //checks if the key exists
				Collections.reverse(reverseList);
				System.out.println("ok");
			}
			else{
				System.out.println("no such key");
			}
		}
		else{
			System.out.println("try again");
		}
	}
	
	/*The sort function, which sorts the list of the key given*/
	public void sorter(String[] sort_array){
		
		if(sort_array.length>1){			
			ArrayList<Integer>sortList= new ArrayList<>();
			String key3=sort_array[1];
			sortList=map.get(key3);			//copies list into sortList
			if ((!keys.isEmpty())&&(keys.contains(key3))){ //checks if the key exists
				Collections.sort(sortList);
				System.out.println("ok");
			}
			else{
				System.out.println("no such key");
			}
		}
		else{
			System.out.println("try again");
		}
	}
	
	/*The length function, which outputs the length of the list for the key given*/
	public void lengther(String[] len_array){
		
		if(len_array.length>1){			
			ArrayList<Integer>lengthList= new ArrayList<>();
			String key3=len_array[1];
			lengthList=map.get(key3);			//copies list into lengthList
			if ((!keys.isEmpty())&&(keys.contains(key3))){ //checks if the key exists
				int lengi=lengthList.size();
				System.out.println(lengi);
			}
			else{
				System.out.println("no such key");
		}
			}
		else{
			System.out.println("try again");
		}
	}
	
	/*The append function, which puts in the values given at the last of the list for the key given*/
	public void appender(String[] append_array){
		
		if(append_array.length>2){			
			ArrayList<Integer> appendValues= new ArrayList<>();			//gets the integers given in the input and puts it into a list
			for(int i=2;i<append_array.length;i++){				
				appendValues.add(Integer.parseInt(append_array[i]));
			}
			ArrayList<Integer>appendList= new ArrayList<>();
			String key3=append_array[1]; 
			appendList=map.get(key3);		// copies list into apendList	
			if ((!keys.isEmpty())&&(keys.contains(key3))){		//checks if the key exists		
				for(int i=0;i<appendValues.size();i++){
					appendList.add(appendValues.get(i));
				}
				System.out.println("ok");
			}
			else{
				System.out.println("no such key");
			}
		}
		else{
			System.out.println("try again");
		}
	}
	
	/*The push function, which pushes the values given to the start of the list for the given key*/
	public void pusher(String[] push_array){
		
		if(push_array.length>2){			
			ArrayList<Integer> pushValues= new ArrayList<>();		//creates a list with all the values given in the push input	
			for(int i=push_array.length-1;i>=2;i--){				
				pushValues.add(Integer.parseInt(push_array[i]));
			}
			ArrayList<Integer>pushList= new ArrayList<>();
			String key3=push_array[1];
			pushList=map.get(key3);
			if ((!keys.isEmpty())&&(keys.contains(key3))){		//checks if the key exists		
				for(int i=pushValues.size()-1;i>=0;i--){
					pushList.add(0,pushValues.get(i)); //appends values to the start
				}
				System.out.println("ok");
			}
			else{
				System.out.println("no such key");
			}
		}
		else{
			System.out.println("try again");
		}
	}
	
	/*The unique function, which removes adjacent similar elements from the list of the given key*/
	public void uniquer(String[] uniq_array){
		
		if(uniq_array.length>1){			
			ArrayList<Integer>list= new ArrayList<>();
			String key1=uniq_array[1];
			list=map.get(key1); //copies list into the new list
			ArrayList<Integer> newList= new ArrayList<>();			
			if ((!keys.isEmpty())&&(keys.contains(key1))){		//checks if the key exists		
				if(list.size()!=0){									
					if(list.size()>1){ //checks if the list contains more than one element
						if(list.get(0)==list.get(1)){
							newList.add(list.get(0)); //adds the first element into the new list if the previous condition is met
						}
						for(int i=0;i<list.size();i++){                                 //the following loop checks if the next element is same within 1 to the one before the last element
							if (((i+1)!=list.size())&&(list.get(i)==list.get(i+1))){
								if (!((i-1)<0)){
									if(list.get(i)!=list.get(i-1)){
										newList.add(list.get(i));
										}
									}
							}
							else if(!((i-1)<0)){
								if (list.get(i)!=list.get(i-1)){   //checks if the previous element is the same as the element that it is about to put in
									newList.add(list.get(i));
								}
							}
							else{
								newList.add(list.get(i));
								}
						}
					}
					else{
						newList.add(list.get(0));
					}
				map.put(key1,newList);	//puts the newly edited list into the hashmap, replacing the old list
				System.out.println("ok");
				}				
				else{
					System.out.println("ok");
				}
			}
			else{
				System.out.println("no such key");
			}		
		}
		else{
			System.out.println("try again");
		}
	}
	
	
	/* Creates a union list of all the elements in each set without any repeats*/
	public void unioner(String[] get_array){
		
		boolean keys_exist=true;
		for(int i=1;i<get_array.length;i++){			
			if (!keys.contains(get_array[i])){ //checks if the key exists
				keys_exist=false;
				break;
			}
		}
		if (keys_exist){			
			ArrayList<Integer>unionValues= new ArrayList<>();  //gets all the values of the union keys given, and creates a huge list our of it
			for(int i=1;i<get_array.length;i++){
				for(int j=0;j<(map.get(get_array[i])).size();j++){
					unionValues.add((map.get(get_array[i])).get(j));
				}
			}
			ArrayList<Integer>unionList= new ArrayList<>(); //only adds one number of each element from the unionvalues list to the unionlist list
			for(int i=0;i<unionValues.size();i++){
				if(! unionList.contains(unionValues.get(i))){
					unionList.add(unionValues.get(i));
				}		
			}
			Collections.sort(unionList);
			stringMaker(unionList);	
			}
		else{
			System.out.println("no such key");
		}		
	}
	
	
	
	/* Creates a list of the common elements between sets without any repeats*/
	public void interer(String[] get_array){
		
		boolean keys_exist=true;
		for(int i=1;i<get_array.length;i++){			//checks if the key exists
			if (!keys.contains(get_array[i])){
				keys_exist=false;
				break;
			}
		}
		if (keys_exist){		
			ArrayList<ArrayList<Integer>>resultCopy= new ArrayList<>(); //copies the cvalues of the kyes given to one huge 2d arraylist
			for(int i=1;i<get_array.length;i++){
				resultCopy.add(map.get(get_array[i]));
			}
			ArrayList<ArrayList<Integer>> deepCopy = new ArrayList<>(); // deep copies the 2d arraylist
			for(int i=0;i<resultCopy.size();i++){
				ArrayList<Integer> list = new ArrayList<>();
				for(int j=0;j<resultCopy.get(i).size();j++){
					list.add(resultCopy.get(i).get(j));
				}
				deepCopy.add(list);
			}			
			for(int i=0;i<deepCopy.size();i++){ //removes any repeated values in individual lists inside the 2d list
				for( int j=0;j<deepCopy.get(i).size();j++){
					for( int k=j+1;k<deepCopy.get(i).size();k++){
						if (deepCopy.get(i).get(j)==deepCopy.get(i).get(k)){
							deepCopy.get(i).remove(k);	
						}	
					}
				}
			}
			ArrayList<Integer>oneDList= new ArrayList<>(); // brings all the elements of the lists inside the 2d list into one 1d list
			for(int i=0;i<deepCopy.size();i++){
				for( int j=0;j<deepCopy.get(i).size();j++){
					oneDList.add(deepCopy.get(i).get(j));
				}
					   }
			ArrayList<Integer>interList= new ArrayList<>(); // adds elements from the previous list inot the new list if there are as many of them as the number of keys given.
			for(int i=0;i<oneDList.size();i++){             // e.g- inter a b c, means the elements with count 3 will be added only.
				int count =0;
				for(int j=i+1;j<oneDList.size();j++){
					if(oneDList.get(i)==oneDList.get(j)){
						count++;
						if(count==get_array.length-2){
							interList.add(oneDList.get(j));	
						}	
					}
				}
			}			
			Collections.sort(interList);
			stringMaker(interList);	
			}		
		else{
			System.out.println("no such key");
		}
	}
	
	
	
	/* Creates a list containing the the elements that do not belong in all sets in an ascending order without any repeats*/
	public void differ(String[] get_array){
		
		boolean keys_exist=true;
		for(int i=1;i<get_array.length;i++){			
			if (!keys.contains(get_array[i])){ //checks if the key exists
				keys_exist=false;
				break;
			}
		}
		if(keys_exist){
			ArrayList<ArrayList<Integer>>resultCopy= new ArrayList<>(); // copies the lists into the resultCopy 2d list
			for(int i=1;i<get_array.length;i++){
				resultCopy.add(map.get(get_array[i]));
			}
			ArrayList<ArrayList<Integer>> deepCopy = new ArrayList<>(); //deepcopies the 2dlist, so that the original one doesnt get edited
				for(int i=0;i<resultCopy.size();i++){
					ArrayList<Integer> array_2 = new ArrayList<>();
					for(int j=0;j<resultCopy.get(i).size();j++){
						array_2.add(resultCopy.get(i).get(j));
					}
					deepCopy.add(array_2);
				}				
			for(int i=0;i<deepCopy.size();i++){  //removes all repeatd elements in the 1d lists in the 2d list
				for( int j=0;j<deepCopy.get(i).size();j++){
					for( int k=j+1;k<deepCopy.get(i).size();k++){
						if (deepCopy.get(i).get(j)==deepCopy.get(i).get(k)){
							(deepCopy.get(i)).remove(k);						
						}					
					}
				}
			}
			ArrayList<Integer>countList= new ArrayList<>();    //this list contains elements that are "inter" in each set
			ArrayList<Integer>diffList= new ArrayList<>();		//this list contains the main list which shows only the diff between sets
			ArrayList<Integer>oneDList= new ArrayList<>();    //this lsit turns the 2d list into a 1d list
			for(int i=0;i<2;i++){
				for( int j=0;j<deepCopy.get(i).size();j++){
						oneDList.add(deepCopy.get(i).get(j));
				}
			}
			for(int i=0;i<oneDList.size();i++){
				int count =0;
				for(int j=i+1;j<oneDList.size();j++){
					if(oneDList.get(i)==oneDList.get(j)){
						count++;
						if(count==1){
							countList.add(oneDList.get(j));
						}
					}	
				}			
			}
			for(int i=0;i<oneDList.size();i++){
				if(! countList.contains(oneDList.get(i))){ // the element which isnt in the countlist, is added to the difflist
					diffList.add(oneDList.get(i));
				}
			}
			for( int j=0;j<diffList.size();j++){ //removes all repeated elements in the list
					for( int k=j+1;k<diffList.size();k++){
						if (diffList.get(j)==diffList.get(k)){
							diffList.remove(j);
						}					
					}
				}
				for(int i=2;i<deepCopy.size();i++){  //once after creating the initial diff list out the 2 sets given, it loops around and edits with the follwoing sets given in input
					ArrayList<Integer> list= new ArrayList<>();
					for( int j=0;j<deepCopy.get(i).size();j++){
						list.add(deepCopy.get(i).get(j));
					}
					for(int k=0;k<list.size();k++){
						if(diffList.contains(list.get(k))){
							diffList.remove(list.get(k));
						}
						else {
							diffList.add(list.get(k));
						}
					}	
				}
			Collections.sort(diffList);
			stringMaker(diffList);		
			}
		else{
			System.out.println("no such key");
		}
		
	}
	
	
	
	
	
	
	/* SNAPSHOTTTTSSS*/
	
	
	ArrayList<Integer> snaps= new ArrayList<>(); //contains all the snapshot ids
	ArrayList<String> snap_keys= new ArrayList<>(); //contains the keys from the sets
	Map<String, ArrayList<Integer>> map_2=new HashMap<String, ArrayList<Integer>>();
	Map<Integer, ArrayList<String>> map_3=new HashMap<Integer, ArrayList<String>>();//hashmap that contains the snapshot id and the follwoing snap_keys list
	int ind=1;
	
	
	/* This method lists down the ids of the snapshots taken*/
	public void list_snaps(String[] snap_array){
		
		if (snaps.isEmpty()){
			System.out.println("no snapshots");			
		}
		else{
			for(int i=snaps.size()-1;i>=0;i--){  //iterates the list in reverse order
				System.out.println(snaps.get(i));
			}			
		}		
	}
	
	
	/* This method prints the snapshot id taken, and sets the keys list into the snap_keys list, and calls the snapsaver*/
	public void snapshotter(String[] snap_array){
		
		System.out.println("saved as snapshot "+ind);
		snaps.add(ind);		
		ind++;
		snap_keys=keys;		
		map_2=map;
		snap_saver();
	}
	
	/* This method puts the snap id and the keys it contains into the hashmap map_3*/
	public void snap_saver(){
		ArrayList<String> copylist= new ArrayList<>(); //copies the snap keys list into the copyList
		for(int i=0;i<snap_keys.size();i++){
			copylist.add(snap_keys.get(i));
		}
						
		ArrayList<String> repeat= new ArrayList<>();
		for(int j=0;j<copylist.size();j++){
			repeat.add(copylist.get(j));
			for(int i=0;i<snaps.size();i++){
				if (!map_3.containsKey(snaps.get(i))){ //puts the snap id and its keys associated into the hashmap
				map_3.put(snaps.get(i),repeat);
				}			
			}
		}	
	}	
	
	
	/* This method is just for personal use to see the snapshots snap_key list*/
	public void show_er(String[] get_array){
		
		System.out.println(map_3.get(Integer.parseInt(get_array[1])));
	}
	
	 
	/* This method deletes the key gvien, from the orignal hasmap, the snap_keys and the map_3 hahsmap*/
	public void purger(String[] get_array){
		
		String remove_key=get_array[1];						
		String[] arry= new String[]{"del",remove_key};
		map.remove(get_array[1]); //deletes from original hashmap
		keys.remove(get_array[1]); //deleted from original key list
		for(int i=0;i<snaps.size();i++){			//deletes from the newly made hashmap map_3
			if((map_3.get(snaps.get(i))).contains(remove_key)){
					map_3.get(snaps.get(i)).remove(remove_key);
			}
		}
		System.out.println("ok");				
	}
	
	
	/*This method deletes the new snapshots after the snap id that has been given*/
	public void rollbacker(String[] get_array){
		int roll = Integer.parseInt(get_array[1]);
		int max=snaps.size();
		if(snaps.size()>roll){
			for(int i=roll;i<max;i++){
				snaps.remove(i-1);
			}
		}
		System.out.println("ok");
		
	}
	
	
	/* this method deleted the snap id*/
	public void dropper(String[] get_array){
		int drop= Integer.parseInt(get_array[1]);
		if(snaps.contains(drop)){
			snaps.remove((Integer) drop);
			System.out.println("ok");
		}
		else{
			System.out.println("no such snapshot");
		}
	}
	
	
}

	

