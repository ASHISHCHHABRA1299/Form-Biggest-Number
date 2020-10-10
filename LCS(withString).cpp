#include<iostream>
#include<string>
using namespace std;
void print(string s,string t,int** a){
    int m=s.size();
    int n=t.size();
    if(m==0 ||n==0)
        return ;
    if(s[0]==t[0]){
        cout<<s[0];
        print(s.substr(1),t.substr(1),a);
    }
    else {
        if(a[m-1][n]> a[m-1][n-1] && a[m-1][n]>a[m][n-1] )
            print(s.substr(1),t,a);
        else if(a[m-1][n-1]> a[m-1][n] && a[m-1][n-1]>a[m][n-1])
            print(s.substr(1),t.substr(1),a);
        else
            print(s,t.substr(1),a);
    }

}

int main()
{   string s,t;
    cin>>s>>t;

	int m = s.size();
	int n = t.size();
	int **output = new int*[m+1];

	for(int i = 0; i <= m; i++) {
		output[i] = new int[n+1];
	}

	// Fill 1st row
	for(int j = 0; j <= n; j++) {
		output[0][j] = 0;
	}

	// Fill 1st col
	for(int i = 1; i <= m; i++) {
		output[i][0] = 0;
	}

	for(int i = 1; i <= m; i++) {
		for(int j = 1; j <= n; j++) {
			// Check if 1st char matches
			if(s[m-i] == t[n-j]) {
				output[i][j] = 1 + output[i-1][j-1];
			}
			else {
				int a = output[i-1][j];
				int b = output[i][j-1];
				int c = output[i-1][j-1];
				output[i][j] = max(a, max(b, c));
			}
		}
	}
	cout<<output[m][n]<<endl;
	print(s,t,output);

	return 0;
}


