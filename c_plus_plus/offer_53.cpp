#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        int miss = (nums.size() + 1) * nums.size() / 2 - sum;
        return miss;
    }
};

int main() {
    Solution s;
    vector<int> nums{0,1,2,3,4,5,6,7,9};
    int miss = s.missingNumber(nums);
    cout << miss << endl;
}
