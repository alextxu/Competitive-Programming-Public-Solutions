#include <bits/stdc++.h>

using namespace std;

unordered_map<int,int> location;

int main()
{
    int S,K;
    int i,temp,previous;
    long long dist;

    // Read the first line of input
    scanf("%d %d\n",&S,&K);

    // Read the sector numbers and put them in a map
    for (i = 1;i <= S;i++) {
        scanf("%d\n",&temp);
        location[temp] = i;
    }

    // Read the sectors to be visited and calculate the distance to that sector
    scanf("%d\n",&temp);
    previous = location[temp];
    dist = 1;
    for (i = 1;i < K;i++) {
        scanf("%d\n",&temp);
        temp = location[temp];
        dist += (abs(temp - previous));
        previous = temp;
    }

    // Output
    printf("%lld\n",dist);

    // Return
    return 0;
}
