#include <bits/stdc++.h>

using namespace std;

int main()
{
    int N,i,x0,y0,xi,yi,k;

    // Read the resting location
    scanf("%d %d\n",&x0,&y0);

    // Read the number of poi
    scanf("%d\n",&N);

    // Read the poi and calculate k
    k = 0;
    for (i = 0;i < N;i++) {
        scanf("%d %d\n",&xi,&yi);
        k = max(k,abs(xi - x0) + abs(yi - y0));
    }

    // Output
    printf("%d\n",k * k * 2);

    // Return
    return 0;
}
