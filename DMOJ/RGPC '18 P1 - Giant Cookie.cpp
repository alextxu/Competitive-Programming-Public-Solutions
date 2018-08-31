#include <bits/stdc++.h>
// RGPC '18 P1 - Giant Cookie

using namespace std;

int main()
{
    int N,M,i;

    scanf("%d%d",&N,&M);

    if (N % M) {
        for (i = M + 1;i <= N;i++) {
            if (!(N % i)) {
                printf("no %d\n",i - M);
                break;
            }
        }
    }
    else {
        printf("yes %d\n",N / M);
    }

    return 0;
}
