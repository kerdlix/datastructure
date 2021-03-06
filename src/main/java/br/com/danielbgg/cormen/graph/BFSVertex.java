package br.com.danielbgg.cormen.graph;

/**
 * Decorator class to encapsulate and to extand some behavior of Vertices in use
 * for BFS.
 */
public class BFSVertex {

	public static int COLOR_WHITE = 10;
	public static int COLOR_GRAY = 20;
	public static int COLOR_BLACK = 30;

	private Vertex vertex;
	private int color;
	private int d;
	private BFSVertex parent;

	public BFSVertex(Vertex vertex) {
		this.vertex = vertex;
	}

	public Vertex getVertex() {
		return vertex;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public BFSVertex getParent() {
		return parent;
	}

	public void setParent(BFSVertex parent) {
		this.parent = parent;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("- This is vertex: " + vertex.getDescription());
		sb.append("  - Color: " + color);
		sb.append("  - Dimension: " + d);
		sb.append("  - Parent: " + (parent == null ? null : parent.getVertex().getDescription()));
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vertex.getDescription() == null) ? 0 : vertex.getDescription().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BFSVertex other = (BFSVertex) obj;
		if (vertex.getDescription() == null) {
			if (other.vertex.getDescription() != null)
				return false;
		} else if (!vertex.getDescription().equals(other.vertex.getDescription()))
			return false;
		return true;
	}

}
