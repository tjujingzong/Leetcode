#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main() {
    int n, k;
    cin >> n >> k;
    vector<int> a(n);
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
    }
    int x=0,y=0;
    int i=0,maxx=0;
    int cnt=0;
    while(n-i>=k){
        if(cnt%2==0){
            int j=0;
            maxx=0;
            for(int jj=i;jj<i+2*k;jj+=1){
                if(a[jj]>maxx){
                    maxx=a[jj];
                    j=jj;
                }
            }
            x+=maxx;
            
        }
    }

    return 0;
}
