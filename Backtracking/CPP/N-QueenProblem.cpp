

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <set>
#define PB push_back;
typedef long long ll;
using namespace std;
int a[11][11];
int c = 0;
int isPossible(int row, int col, int n)
{
    // same column
    for (int i = row - 1; i >= 0; i--)
        if (a[i][col] == 1)
            return 0;
    //left dia
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
        if (a[i][j] == 1)
            return 0;

    for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
        if (a[i][j] == 1)
            return 0;
    return 1;
}
void f(int x, int y, int n)
{
    if (x == n)
    {
        c++;
        int x = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
                cout << a[i][j] << " ";
        }
        cout << "\n";
    }

    for (int j = 0; j < n; j++)
    {
        if (isPossible(x, j, n) == 1)
        {

            a[x][j] = 1;
            f(x + 1, j, n);
            a[x][j] = 0;
        }
    }
    return;
}

int main()
{
    f(0, 0, 100 );
    cout << c;
    return 0;
}
