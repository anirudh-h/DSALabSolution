import java.util.ArrayList;

class binaryTree{
	static class Tree
	{
		Tree left;
		Tree right;
		int data;
	};
	static Tree inputNode(int data)
	{
		Tree temp = new Tree();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}
	public static ArrayList<Integer> path(Tree root)
	{	
		if(root == null)
		{
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}
		ArrayList<Integer> right = path(root.right);
		ArrayList<Integer> left = path(root.left);

		if(right.size() < left.size())
		{
			left.add(root.data);
		}
		else
		{
			right.add(root.data);
		}
		return (left.size() > right.size() ? left :right);
	}
	public static void main(String[] args)
	{
		Tree root = inputNode(100); //level 0 -> root
		root.left = inputNode(20); //level 1
		root.right = inputNode(130); //level 1
		root.right.right = inputNode(140); //level 2
		root.right.left = inputNode(110); //level 2
		root.left.right = inputNode(50); //level 2
		root.left.left = inputNode(10); //level 2
		root.left.left.left = inputNode(5); //level 3
		
		ArrayList<Integer> output = path(root);
		int n = output.size();
		
		System.out.print(output.get(n - 1));
		for(int i = n - 2; i >= 0; i--)
		{
			System.out.print(" -> " + output.get(i));
		}
	}
}
