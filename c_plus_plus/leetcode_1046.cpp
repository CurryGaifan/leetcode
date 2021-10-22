#include <iostream>
#include <queue>
using namespace std;

class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int> queue;
        for(auto s: stones) {
            queue.push(s);
        }
        while(queue.size() > 1){
            int a = queue.top();
            queue.pop();
            int b = queue.top();
            queue.pop();
            queue.push(abs(a - b));
        }

        if(queue.size() == 1) {
            return queue.top();
        } else {
            return 0;
        }
    }
};

int main() {
    Solution s = Solution();
    vector<int> stones = {2,7,4,1,8,1};
    int last_weight = s.lastStoneWeight(stones);
    cout << last_weight << endl;

}