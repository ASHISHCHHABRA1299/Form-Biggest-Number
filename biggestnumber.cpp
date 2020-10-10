#include <bits/stdc++.h>
using namespace std;

static bool cmp(string a, string b) {
	return a + b > b + a;
}

int main(int argc, char const *argv[]) {

	int n;
	cin >> n;

	vector<string> arr(n);
	for (int i = 0; i < n; i++)
		cin >> arr[i];

	sort(arr.begin(), arr.end(), cmp);

	for (auto i : arr) {
		cout << i;
	}

	return 0;
}