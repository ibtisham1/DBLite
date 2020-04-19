import java.util.Scanner;

public class DBLite {
	
	private static final String HELP =
		"BYE   clear database and exit\n"+
		"HELP  display this help message\n"+
		"\n"+
		"LIST KEYS       displays all keys in current state\n"+
		"LIST ENTRIES    displays all entries in current state\n"+
		"LIST SNAPSHOTS  displays all snapshots in the database\n"+
		"\n"+
		"GET <key>    displays entry values\n"+
		"DEL <key>    deletes entry from current state\n"+
		"PURGE <key>  deletes entry from current state and snapshots\n"+
		"\n"+
		"SET <key> <value ...>     sets entry values\n"+
		"PUSH <key> <value ...>    pushes values to the front\n"+
		"APPEND <key> <value ...>  appends values to the back\n"+
		"\n"+
		"PICK <key> <index>   displays value at index\n"+
		"PLUCK <key> <index>  displays and removes value at index\n"+
		"POP <key>            displays and removes the front value\n"+
		"\n"+
		"DROP <id>      deletes snapshot\n"+
		"ROLLBACK <id>  restores to snapshot and deletes newer snapshots\n"+
		"CHECKOUT <id>  replaces current state with a copy of snapshot\n"+
		"SNAPSHOT       saves the current state as a snapshot\n"+
		"\n"+
		"MIN <key>  displays minimum value\n"+
		"MAX <key>  displays maximum value\n"+
		"SUM <key>  displays sum of values\n"+
		"LEN <key>  displays number of values\n"+
		"\n"+
		"REV <key>   reverses order of values\n"+
		"UNIQ <key>  removes repeated adjacent values\n"+
		"SORT <key>  sorts values in ascending order\n"+
		"\n"+
		"DIFF <key> <key ...>   displays set difference of values in keys\n"+
		"INTER <key> <key ...>  displays set intersection of values in keys\n"+
		"UNION <key> <key ...>  displays set union of values in keys";
	
	
	public static void bye() {
		System.out.println("bye");
	}
	
	public static void help() {
		System.out.println(HELP);
	}
	
	
	public static void main(String[] args) {
		
		Entry e = new Entry();
		Snapshot s = new Snapshot();
		boolean answer=true;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("> ");
		while (scan.hasNextLine()){			
			
			String scan_2= scan.nextLine();
			String[] array= scan_2.split(" ");						
			if (array[0].equalsIgnoreCase("BYE")){
				bye();
				System.exit(0);
				
			}
			else if(array[0].equalsIgnoreCase("HELP")){
				help();				
			}
			
			else if(array[0].equalsIgnoreCase("SET")){
				e.setter(array);
			}
			
			else if (array[0].equalsIgnoreCase("GET")){
				e.getter(array);
			}
			
			else if ((array[0].equalsIgnoreCase("list")) &&(array[1].equalsIgnoreCase("keys"))){
				e.list_keys(array);
			}
			
			else if ((array[0].equalsIgnoreCase("list")) &&(array[1].equalsIgnoreCase("entries"))){
				e.list_entries(array);
			}
			
			else if(array[0].equalsIgnoreCase("SUM")){
				e.get_sum(array);
			}
			
			else if(array[0].equalsIgnoreCase("MAX")){
				e.get_max(array);
			}
			
			else if(array[0].equalsIgnoreCase("MIN")){
				e.get_min(array);
			}
			
			else if(array[0].equalsIgnoreCase("DEL")){
				e.remover(array);
			}
			
			else if(array[0].equalsIgnoreCase("PICK")){
				e.picker(array);
			}
			
			else if(array[0].equalsIgnoreCase("POP")){
				e.popper(array);
			}
			
			else if(array[0].equalsIgnoreCase("PLUCK")){
				e.plucker(array);
			}
			
			else if(array[0].equalsIgnoreCase("REV")){
				e.reverser(array);
			}
			
			else if(array[0].equalsIgnoreCase("SORT")){
				e.sorter(array);
			}
			
			else if(array[0].equalsIgnoreCase("LEN")){
				e.lengther(array);
			}
			
			else if(array[0].equalsIgnoreCase("APPEND")){
				e.appender(array);
			}
			
			else if(array[0].equalsIgnoreCase("PUSH")){
				e.pusher(array);
			}
			
			else if(array[0].equalsIgnoreCase("UNIQ")){
				e.uniquer(array);
			}
			
			else if ((array[0].equalsIgnoreCase("list")) &&(array[1].equalsIgnoreCase("snapshots"))){
				e.list_snaps(array);
			}
			
			else if(array[0].equalsIgnoreCase("SNAPSHOT")){
				e.snapshotter(array);
			}
			
			else if(array[0].equalsIgnoreCase("UNION")){
				e.unioner(array);
			}
			
			else if(array[0].equalsIgnoreCase("INTER")){
				e.interer(array);
			}
			
			else if(array[0].equalsIgnoreCase("DIFF")){
				e.differ(array);
			}
			
			else if(array[0].equalsIgnoreCase("show")){
				e.show_er(array);
			}
			
			else if(array[0].equalsIgnoreCase("purge")){
				e.purger(array);
			}
			
			else if(array[0].equalsIgnoreCase("rollback")){
				e.rollbacker(array);
			}
			
			else if(array[0].equalsIgnoreCase("drop")){
				e.dropper(array);
			}
						
			System.out.println();
			System.out.print("> ");
			
		}
	}
}
