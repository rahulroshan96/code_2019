#include <iostream>
#include <vector>
#include <algorithm>
#include <stdlib.h>
using namespace std;
int getWays(vector<int> coins, int target, int x){
    if(target == 0){
        return 1;
    };
    if(target<0) return 0;
    int sum = 0;
    for(int i=x;i<coins.size();i++){
        sum += (getWays(coins, target-coins[i], i));
    }
    return sum;
}

int main(){
    vector<int> coins{1,3,5};
    int target = 4;
    int n = coins.size();
    int m = target;
    vector<vector<int>> M(n+1,vector<int>(m+1));
    cout<<getWays(coins,target, 0);
    return 0;
}
