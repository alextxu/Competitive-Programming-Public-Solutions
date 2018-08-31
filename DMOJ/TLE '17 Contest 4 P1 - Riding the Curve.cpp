#include <bits/stdc++.h>
// TLE '17 Contest 4 P1 - Riding the Curve

using namespace std;

int main()
{
    int M,K,N,minRaw;

    // Read the line of input
    scanf("%d %d %d\n",&M,&K,&N);

    // Calculate the minimum raw mark to pass
    minRaw = max(0,((int) ceil(0.595 * N - K)));

    // Output
    if (minRaw > M)
        printf("have mercy snew\n");
    else
        printf("%d\n",minRaw);

    // Return
    return 0;
}
