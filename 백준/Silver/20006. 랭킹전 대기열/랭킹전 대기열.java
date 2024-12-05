import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken()); //플레이어의 수
		int m = Integer.parseInt(st.nextToken()); //방 한개의 정원
		
		ArrayList<Room> rooms = new ArrayList<>();
		
		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()); //레벨
			String n = st.nextToken(); //닉네임
			
			Player player = new Player(l,n);
			boolean joined = false;
			
			for(Room room : rooms) {
				if(room.canJoin(player, m)) {
					room.players.add(player);
					joined = true;
					break;
				}
			}
			
			if(!joined) {
				Room newRoom = new Room(l,m);
				newRoom.players.add(player);
				rooms.add(newRoom);
			}
			
		}
		
		for(Room room : rooms) {
			Collections.sort(room.players);
			if(room.players.size() == m) {
				sb.append("Started!").append("\n");
			} else {
				sb.append("Waiting!").append("\n");
			}
			
			for(Player player : room.players) {
				sb.append(player.level).append(" ").append(player.name).append("\n");
			}
		}
		
		System.out.println(sb);
		
	}
	
	
	 public static class Player implements Comparable<Player> {
	        int level;
	        String name;

	        Player(int level, String name) {
	            this.level = level;
	            this.name = name;
	        }

	        @Override
	        public int compareTo(Player p1) {
	            return name.compareTo(p1.name);
	        }
	    }

	    public static class Room {
	        int minLevel;
	        int maxLevel;
	        ArrayList<Player> players;

	        Room(int level, int maxPlayers) {
	            this.minLevel = level - 10;
	            this.maxLevel = level + 10;
	            this.players = new ArrayList<>();
	        }

	        boolean canJoin(Player player, int maxPlayers) {
	            return players.size() < maxPlayers && player.level >= minLevel && player.level <= maxLevel;
	        }
	    }
}

//입장 신청 시 매칭 가능한 방이 없다면 새로운방 생성. (방 생성한 플레이어 기준 -10 ~ +10 레벨 만 입장가능)
//입장 가능한 방 있으면 입장 후 가득 찰때까지 대기. 이때 입장 가능이 여러개면 먼저 생성된 방 먼저.
//정원 다 차면 시작

//플레이어의 수 p, 플레이어의 닉네임 n, 플레이어의 레벨 l, 방 한개의 정원 m