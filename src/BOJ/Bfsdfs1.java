package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Bfsdfs1 {
	public static boolean adj[][];
	public static boolean visited[];
	public static int N;
	public static String Answer;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		BufferedWriter writer = new BufferedWriter( new OutputStreamWriter( System.out ) );
		StringTokenizer token = new StringTokenizer( reader.readLine() );
		
		int M, V;
		Answer = "";
		N = Integer.parseInt( token.nextToken() ) + 1;
		M = Integer.parseInt( token.nextToken() );
		V = Integer.parseInt( token.nextToken() );
		
		adj = new boolean[ N ][ N ];
		visited = new boolean[ N ];

		for ( int m = 0; m < M; m++ ) {
			token = new StringTokenizer( reader.readLine() );
			int here = Integer.parseInt( token.nextToken() );
			int there = Integer.parseInt( token.nextToken() );
			adj[ here ][ there ] = true;
			adj[ there ][ here ] = true;
		}
		
		dfs( V );
		writer.write( Answer.substring(0, Answer.length() - 1 ) + "\n" );
		Answer = "";
		
		bfs( V );
		writer.write( Answer.substring(0, Answer.length() - 1 ) );
		writer.close();
		
	}
	
	public static void dfs( int here ) {
		Answer += here + " ";
		visited[ here ] = true;
		for ( int i = 0; i < N; i++ ) {
			if ( adj[ here ][ i ] && !visited[ i ]) {
				dfs( i );
			}
		}
	}

	
	public static void bfs( int v ) {
		Queue< Integer > Q = new LinkedList<Integer>();
		Arrays.fill( visited, false );
		
		Q.add( v );
		visited[ v ] = true;
		while( !Q.isEmpty() ) {
			int here = Q.poll();
			Answer += here + " ";
			for ( int i = 0; i < N; i++ ) {
				if ( adj[ here ][ i ] && !visited[ i ]) {
					Q.add( i );
					visited[ i ] = true;
				}
			}
		}
	}
	
}
