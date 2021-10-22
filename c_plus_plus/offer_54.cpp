#include <iostream>
using namespace std;

// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    int kthLargest(TreeNode* root, int k) {
        int k_num, k_counter = 0;
        do_kthLargest(root, k, k_counter, k_num);
        return k_num;
    }
    
    void do_kthLargest(TreeNode* root, int k, int& k_counter, int& k_num) {
        if (!root || k_counter >= k) {
            return; 
        }
        if(root->right) {
            do_kthLargest(root->right, k, k_counter, k_num);
        }
        k_counter += 1;
        if (k == k_counter) {
            k_num = root->val;
        }
        if(root->left) {
            do_kthLargest(root->left, k, k_counter, k_num);
        }

    }
};

int main() {
    TreeNode t1(1);
    TreeNode t2(2);
    TreeNode t4(4);
    TreeNode t3(3);
    TreeNode t6(6);
    TreeNode t5(5);
    t5.right = &t6;
    t5.left = &t3;
    t3.right = &t4;
    t3.left = &t2;
    t2.left = &t1;
    Solution s;
    int r = s.kthLargest(&t5, 3);
    cout << r << endl;
}

