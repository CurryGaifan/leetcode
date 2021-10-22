#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int movingCount(int m, int n, int k) {
        vector<vector<int> > can_go(m);
        for(int i = 0; i < m; i ++) {
            vector<int> sub(n);
            can_go[i] = sub;
        }

        int r = movingCount(0, 0, k, can_go);
        // for(int i =0; i < m ; i ++) {
        //     string sub_str = "";
        //     for (int j = 0; j < n; j++) {
        //         sub_str = sub_str + to_string(can_go[i][j]) + " ";
        //     }
        //     cout << sub_str << endl;
        // }

        return r;

    }
    int movingCount(int m, int n, int k, vector<vector<int> >& can_go){
        if(can_go[m][n]) {
            return 0;
        }
        if (cal_add_bit(m, n) > k){
            return 0;
        }
        can_go[m][n] = 1;
        int go_cnt = 1;
        if (m + 1 < can_go.size()) {
            go_cnt += movingCount(m + 1, n, k, can_go);
        }
        if (m - 1 >= 0) {
            go_cnt += movingCount(m - 1, n, k, can_go);
        }
        if (n + 1 < can_go[0].size()) {
            go_cnt += movingCount(m , n + 1, k, can_go);
        }
        if (n - 1 >= 0) {
            go_cnt += movingCount(m, n - 1, k, can_go);
        }
        return go_cnt;

    }

    int cal_add_bit(int m, int n){
        int sum = 0;
        while (m > 0) {
            sum += m%10;
            m /= 10;
        }
        while (n > 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }

};

int main(){
    Solution *s = new Solution();
    cout << s->movingCount(2, 3,1) << endl;;
    cout << s->movingCount(3,1,0) << endl;
    cout << s->movingCount(3,2,17) << endl;
    cout << s->movingCount(38, 15, 9) << endl;
}
