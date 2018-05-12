#include <bits/stdc++.h>
// ECOO '17 R3 P1 - Baker Brie

using namespace std;

int goods[4751][131];

int main() {
    int F,D,i,j,temp,ans;

    for (int tc = 0;tc < 10;tc++) {
        scanf("%d%d",&F,&D);
        for (i = 0;i < D;i++) {
            for (j = 0;j < F;j++) {
                scanf("%d",&goods[i][j]);
            }
        }

        ans = 0;
        for (i = 0;i < D;i++) {
            temp = 0;
            for (j = 0;j < F;j++) {
                temp += goods[i][j];
            }
            if (temp % 13 == 0)
                ans += temp / 13;
        }

        for (j = 0;j < F;j++) {
            temp = 0;
            for (i = 0;i < D;i++) {
                temp += goods[i][j];
            }
            if (temp % 13 == 0)
                ans += temp / 13;
        }

        printf("%d\n",ans);
    }

    return 0;
}
