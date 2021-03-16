#include <iostream>
#include <vector>
#include <algorithm>
#include <stdlib.h>
using namespace std;
int main(){
    vector<int> coins{1,3,5};
    int target = 5;
    int n = coins.size();
    int m = target;
    vector<vector<int>> M(n+1,vector<int>(m+1));
    for(int i=0;i<=n;i++){
        M[i][0] = 1;
    }
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(coins[i-1]>j){
                M[i][j] = M[i-1][j];
            }else{
                M[i][j] = (M[i][j-coins[i-1]])+(M[i-1][j]);
            }
        }
    }
    cout<<M[n][m]<<endl;
    for(int i=0;i<=n;i++){
        for(int j=0;j<=m;j++){
            cout<<M[i][j]<<" ";
        }
        cout<<endl;
    }
    return 0;
}
