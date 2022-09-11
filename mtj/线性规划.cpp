
#include<iostream>   
#include<cmath>  
#include"stdio.h"
using namespace std;
#define M 10000   
//全局变量   
float kernel[110][310];//核心矩阵表   
int m = 0, n = 0, t = 0;
//m:约束不等式个数  
//n:结构向量的个数   
//t:目标函数类型：－1代表求求最小值，1代表求最大值   
//输入接口函数   
void input()
{
	//读入所求问题的基本条件   
	cout << "－－－－－－－－－－参 数 输 入－－－－－－－－－－－" << endl;
	cout << "请按提示输入下列参数：" << endl << endl;
	cout << "  结构向量数n:  " << "   n=  ";
	//cin>>n;
	n = 6;
	cout << endl << "  约束不等式数m:" << "   m=  ";
	//cin>>m;
	m = 5;
 
 
	int i, j;
	//初始化核心向量   
	for (i = 0; i <= m + 1; i++)
		for (j = 0; j <= n + m + m; j++)
			kernel[i][j] = 0;
	//读入约束条件   
	cout << endl << "  约束方程矩阵的系数及不等式方向（1代表<=,-1代表>=）:" << endl << endl << "          ";
	for (i = 1; i <= n; i++)
		cout << "   x" << i;
	cout << "  不等式方向 " << " 常数项" << endl;
	//for (i=1;i<=m;i++)    
	//{    
		//cout<<"    不等式"<<i<<"  ";   
		//for (j=1;j<=n+2;j++)      
			//cin>>kernel [i][j];   
	//}   
	i = 1;
	kernel[i][1] = 4;
	kernel[i][2] = 1;
	kernel[i][3] = 0;
	kernel[i][4] = 1;
	kernel[i][5] = 0;
	kernel[i][6] = 0;
	kernel[i][7] = 1;
	kernel[i][8] = 325;
 
	float(*c)[310] = kernel;
 
	i = 2;
	c[i][1] = 0;
	c[i][2] = 1;
	c[i][3] = 0;
	c[i][4] = 0;
	c[i][5] = 1;
	c[i][6] = 0;
	c[i][7] = 1;
	c[i][8] = 300;
 
	i = 3;
	c[i][1] = 0;
	c[i][2] = 0;
	c[i][3] = 1;
	c[i][4] = 0;
	c[i][5] = 0;
	c[i][6] = 1;
	c[i][7] = 1;
	c[i][8] = 275;
 
	i = 4;
	c[i][1] = 1;
	c[i][2] = 1;
	c[i][3] = 1;
	c[i][4] = 0;
	c[i][5] = 0;
	c[i][6] = 0;
	c[i][7] = 1;
	c[i][8] = 350;
 
	i = 5;
 
	c[i][1] = 0;
	c[i][2] = 0;
	c[i][3] = 0;
	c[i][4] = 12;
	c[i][5] = 1;
	c[i][6] = 1;
	c[i][7] = 1;
	c[i][8] = 600;
 
	for (i = 1; i <= m; i++)
	{
		kernel[i][0] = kernel[i][n + 2];
		kernel[i][n + 2] = 0;
	}
	//读入目标条件   
	cout << endl << endl << " 目标函数的系数及类型（求最小值:1；求最大值:-1）:" << endl << endl << "                ";
	for (i = 1; i <= n; i++)
		cout << "x" << i << "   ";
	cout << "类型" << endl << "  \n";
	cout << "  目标函数:   ";
	//for (i=1;i<=n;i++)   
		//cin>>kernel [0][i];   
	//cin>>t;   
	i = -1;
	kernel[0][1] = 2.5;
	kernel[0][2] = 1.7;
	kernel[0][3] = 1.8;
	kernel[0][4] = 2.5;
	kernel[0][5] = 1.8;
	kernel[0][6] = 1.4;
	t = -1;
	//矩阵调整   
	if (t == -1)
		for (i = 1; i <= n; i++)
			kernel[0][i] = (-1)*kernel[0][i];
	for (i = 1; i <= m; i++)
	{
		kernel[i][n + i] = kernel[i][n + 1];
		if (i != 1)
			kernel[i][n + 1] = 0;
	}
}
 
//算法函数   
void comput()
{
	int i, j, flag, temp1, temp2, h, k = 0, temp3[100];
	float a, b[110], temp, temp4[110], temp5[110], f = 0, aa, d, c;
	//初始化   
	for (i = 1; i <= m; i++)
		temp3[i] = 0;
	for (i = 0; i < 11; i++)
	{
		temp4[i] = 0;
		temp5[i] = 0;
	}
	for (i = 1; i <= m; i++)
	{
		if (kernel[i][n + i] == -1)
		{
			kernel[i][n + m + i] = 1;
			kernel[0][n + m + i] = M;
			temp3[i] = n + m + i;
		}
		else
			temp3[i] = n + i;
	}
	for (i = 1; i <= m; i++)
		temp4[i] = kernel[0][temp3[i]];
 
	//循环求解   
	do {
		for (i = 1; i <= n + m + m; i++)
		{
			a = 0;
			for (j = 1; j <= m; j++)
				a += kernel[j][i] * temp4[j];
			kernel[m + 1][i] = kernel[0][i] - a;
		}
		for (i = 1; i <= n + m + m; i++)
		{
			if (kernel[m + 1][i] >= 0) flag = 1;
			else
			{
				flag = -1;
				break;
			}
		}
		if (flag == 1)
		{
			for (i = 1; i <= m; i++)
			{
				if (temp3[i] <= n + m) temp1 = 1;
				else
				{
					temp1 = -1;
					break;
				}
			}
			//输出结果   
			cout << endl << endl;
			cout << "－－－－－－－－－－结 果 输 出－－－－－－－－－－－" << endl << endl;
			if (temp1 == 1)
			{
				cout << " 此线性规划的最优解存在!" << endl << endl << "  最优解为：" << endl << endl << "     ";
				for (i = 1; i <= m; i++)
					temp5[temp3[i]] = kernel[i][0];
				for (i = 1; i <= n; i++)
					f += t * kernel[0][i] * temp5[i];
 
				for (i = 1; i <= n; i++)
				{
					cout << "x" << i << " = " << temp5[i];
					if (i != n)
						cout << "， ";
				}
				cout << " ;" << endl << endl << "     最优目标函数值f= " << f << endl << endl;
				return;
			}
			else
			{
				cout << " 此线性规划无解" << endl << endl;
				return;
			}
		}
		if (flag == -1)
		{
			temp = 100000;
			for (i = 1; i <= n + m + m; i++)
				if (kernel[m + 1][i] < temp)
				{
					temp = kernel[m + 1][i];
					h = i;
				}
 
			for (i = 1; i <= m; i++)
			{
				if (kernel[i][h] <= 0) temp2 = 1;
				else {
					temp2 = -1;
					break;
				}
			}
		}
		if (temp2 == 1)
		{
			cout << "此线性规划无约束";
			return;
		}
		if (temp2 == -1)
		{
			c = 100000;
			for (i = 1; i <= m; i++)
			{
				if (kernel[i][h] != 0)  b[i] = kernel[i][0] / kernel[i][h];
				if (kernel[i][h] == 0)  b[i] = 100000;
				if (b[i] < 0)     b[i] = 100000;
				if (b[i] < c)
				{
					c = b[i];
					k = i;
				}
			}
			temp3[k] = h;
			temp4[k] = kernel[0][h];
			d = kernel[k][h];
			for (i = 0; i <= n + m + m; i++)
				kernel[k][i] = kernel[k][i] / d;
			for (i = 1; i <= m; i++)
			{
				if (i == k)
					continue;
				aa = kernel[i][h];
				for (j = 0; j <= n + m + m; j++)
					kernel[i][j] = kernel[i][j] - aa * kernel[k][j];
			}
		}
 
	} while (1);
	return;
}
 
//主函数   
int main()
{
	cout << "-------------------单纯形算法程序----------------------" << endl << endl;
	input();
	printf("\n----------------------------\n----------------------------\n----------------------------\n");
	comput();
	int a = 0;
	scanf("%d", &a);
	return 1;
}