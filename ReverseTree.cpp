// ReverseTree.cpp : Defines the entry point for the console application.
//

#include <vector>
#include <iostream>
using namespace std;

struct Node
{
	Node *parent;
	Node *left;
	Node *right;

	int value;
};

class InvertTree
{
public:

	void printTree(Node *root)
	{
		if (root == NULL)
			return;
		
		printTree(root->left);
		cout << root->value << "\n";
		printTree(root->right);
	}

	void buildTree(vector<int> arr, Node *root)
	{
		for (int i = 0; i < arr.size(); i++)
		{
			insertBST(root, arr.at(i));
		}
	}

	void insertBST(Node *root, int val)
	{
		if (root->value == NULL)
		{
			root->value = val;
		}
		if (val < root->value)
		{
			if (root->left == NULL)
				root->left = new Node();
			insertBST(root->left, val);
		}
		else if (val > root->value)
		{
			if (root->right == NULL)
				root->right = new Node();
			insertBST(root->right, val);
		}
	}

	Node* reverseTree(Node *root, Node *reversed)
	{
		if (reversed == NULL) //This is simply a safety measure
			reversed = new Node();
		if (root == NULL)
			return reversed;

		reversed->value = root->value;
		if (root->left != NULL)
		{
			reversed->right = new Node();
			reverseTree(root->left, reversed->right);
		}
		if (root->right != NULL)
		{
			reversed->left = new Node();
			reverseTree(root->right, reversed->left);
		}
		return reversed;
	}
};