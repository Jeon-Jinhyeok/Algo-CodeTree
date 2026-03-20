import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static List<List<int[]>> graph; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		graph = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(new int[] {v, cost});
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		pq.offer(new int[] {0, 0, 0});
		
		int[][] dist = new int[N][2];
		for(int i = 0; i < N; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0] = 0;
		
		int shortest = Integer.MAX_VALUE;
		int doubleShorest = Integer.MAX_VALUE;
		while(!pq.isEmpty()) {
			
			int[] cur = pq.poll();
			int node = cur[0];
			int cost = cur[1];
			int isDouble = cur[2];
			
			if(node == N-1) {
				if(isDouble == 0) shortest = Math.min(shortest, cost);
				else doubleShorest = Math.min(doubleShorest, cost);
			}
			
			if(dist[node][isDouble] < cost) continue;
			
			for(int[] neighbor : graph.get(node)) {
				int next = neighbor[0];
				int newCost = cost + neighbor[1];
				int newDoubleCost = cost + neighbor[1] * 2;
				
				if(isDouble == 0) {
					if(dist[next][0] > newCost) {
						dist[next][0] = newCost;
						pq.offer(new int[] {next, newCost, 0});
					}
					
					if(dist[next][1] > newCost) {
						dist[next][1] = newCost;
						pq.offer(new int[] {next, newDoubleCost, 1});
					}
					
				} else {
					if(dist[next][1] > newCost) {
						dist[next][1] = newCost;
						pq.offer(new int[] {next, newCost, 1});
					}
				}
			}
		}
		
		System.out.println(doubleShorest - shortest);
		br.close();
	}

}
