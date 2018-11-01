public class graphColour {

	public static void main(String[] args) {
		int[][] E = new int[][]{{1,1,1,0}, {1,1,1,1}, {1,1,1,1}, {0,1,1,1}};
		int n = E.length;
		String[] colours = new String[]{"Red", "Green", "Blue"};
 		int k = colours.length;

 		int[] c = new int[n];

		public void color(int[] c, int j, int k, int n) {
			for(int i=0; i<k; i++) {
				c[j] = i;
				if(valid(c,j,n)) 
					color(c, j+1, k, n)
				}
			}
		}

		public void getNeighbours(int x) {
			int[] nbrs = new int[n];

			for(int i=0; i<n; i++) {
				if(E[x][i] == 1)
					nbrs.append(i);
			}
			return nbrs;
		}

		public void valid(int[] c, int j, int n) {

		}
}