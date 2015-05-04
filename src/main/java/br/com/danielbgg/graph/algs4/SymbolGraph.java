package br.com.danielbgg.graph.algs4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolGraph {

	// String -> index
	private ST<String, Integer> st;

	// index -> String
	private String[] keys;

	private Graph G;

	public SymbolGraph(String stream, String sp) {
		st = new ST<String, Integer>();

		// First pass builds the index by reading strings to associate each
		// distinct string with an index
		In in = new In(stream);
		while (in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			for (int i = 0; i < a.length; i++)
				if (!st.contains(a[i]))
					st.put(a[i], st.size());
		}

		// Inverted index to get string keys is an array.
		keys = new String[st.size()];
		for (String name : st.keys())
			keys[st.get(name)] = name;

		// Second pass builds the graph by connecting the first vertex on each
		// line to all the others.
		G = new Graph(st.size());
		in = new In(stream);
		while (in.hasNextLine()) {
			String[] a = in.readLine().split(sp);
			int v = st.get(a[0]);
			for (int i = 1; i < a.length; i++)
				G.addEdge(v, st.get(a[i]));
		}
	}

	public boolean contains(String s) {
		return st.contains(s);
	}

	public int index(String s) {
		return st.get(s);
	}

	public String name(int v) {
		return keys[v];
	}

	public Graph G() {
		return G;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		s.append(keys.length + " vertices" + NEWLINE);
		for (int v = 0; v < keys.length; v++) {
			s.append(keys[v] + " ");
		}
		return s.toString();
	}

}