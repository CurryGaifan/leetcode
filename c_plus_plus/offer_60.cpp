#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<double> dicesProbability(int n) {
        if (n ==0 ) {
            return {};
        }
        double p = 1.0 / 6;
        vector<double> ret(6, p);
        cout << p << endl;
        for (int i = 2 ; i <= n; i ++){
            for (int k = 0; k < ret.size(); k ++) {
                ret[k] *= p;
            }
            vector<double> n_ret(5 * i+1);
            for(int j = 0 ; j < 6; j ++){
                for (int l =0; l < ret.size(); l ++) {
                    n_ret[l+j] += ret[l];
                }

            }
            ret = n_ret;
        }
        return ret;
    }
};

int main() {
    Solution s;
    vector<double> ret = s.dicesProbability(10);
    string ret_str = "";
    for(double d : ret) {
        ret_str += to_string(d) + " ";
    }
    cout << ret_str << endl;
}
