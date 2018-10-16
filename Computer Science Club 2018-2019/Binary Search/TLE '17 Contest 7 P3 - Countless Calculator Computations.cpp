#include <bits/stdc++.h>
// TLE '17 Contest 7 P3 - Countless Calculator Computations

using namespace std;

int main() {
    int Q,Y,Z,i;
    double X,lo,hi,tmp;

    scanf("%d",&Q);
    for (int tc = 0;tc < Q;tc++) {
        scanf("%d%d",&Y,&Z);
        lo = 1; hi = 65537;
        while ((hi - lo) > 10e-7) {
            X = (lo + hi) / 2.0;
            tmp = X;
            for (i = 1;i < Y;i++)
                tmp = pow(X,tmp);
            if (tmp < Z)
                lo = X;
            else
                hi = X;
        }
        printf("%f\n",lo);
    }

    return 0;
}
