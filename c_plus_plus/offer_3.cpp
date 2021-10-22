#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> ret = {0};
        vector<int> bit(17);
        int c = 0;
        for(int i =0; i < n; i ++) {
            for(int j = 16; j >=0; j --) {
                if(bit[j] == 0) {
                    bit[j] = 1;
                    c += 1;
                    ret.push_back(c);
                    break;
                } else {
                    bit[j] = 0;
                    c -= 1;
                }
            }
        }
        return ret;
    }
};

int main() {
    Solution* s = new Solution();
    vector<int> ret = s->countBits(5);
    string r_str = "";
    for(int e: ret){
        r_str = r_str + to_string(e) + " ";
    }
    cout << r_str <<endl;
}
