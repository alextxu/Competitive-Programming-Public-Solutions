#include <bits/stdc++.h>
// DMOPC '17 Contest 1 P4 - Quests

#define INF 0x3f3f3f3f

using namespace std;

long long dp[5001][2];
bool go[5001];
int g[5001],h[5001],q[5001],t[5001];

int main()
{
    int N,H,i,j;
    long long ans;

    scanf("%d%d",&N,&H);

    for (i = 1;i <= N;i++)
        scanf("%d%d%d%d",&g[i],&h[i],&q[i],&t[i]);

    for (i = 1;i <= N;i++) {
        for (j = 0;j <= H;j++)
            dp[j][1] = -INFINITY;
        for (j = 0;j <= H;j++) {
            if (j >= h[i])
                dp[j][1] = max(dp[j][1],dp[j - h[i]][0] + g[i]);
            if (j >= t[i])
                dp[j][1] = max(dp[j][1],dp[j - t[i]][1] + q[i]);
        }
        for (j = 0;j <= H;j++)
            dp[j][0] = max(dp[j][0],dp[j][1]);
    }

    ans = 0;
    for (i = 0;i <= H;i++)
        ans = max(ans,dp[i][0]);
    printf("%lld\n",ans);

    return 0;
}
