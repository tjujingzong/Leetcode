/*
 * @Description: 词法分析器
 * @Solution:
 * @Version: 4.0
 * @Author: 王越 谢远峰 张一鸣
 * @Date: 2021-04-22
 * @LastEditors: happytraveller-alone
 * @LastEditTime: 2021-04-30 22:45:46
 */
#include "LexAnalysis.h"
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <fstream>
#include <iomanip>
#include <iostream>
#include <vector>

NormalNode* normalHead; //定义识别TOKEN表的首结点
IdentiferNode* idenHead; //首节点
ErrorNode* errorHead; //定义表头

int lineBra[6][1000] = {}; // 存储每一行的括号

std::vector<std::pair<const char*, int>> brace_count; // 存储不同括号类型的个数
std::vector<std::pair<const char*, int>> keyMap; //定义关键字表
std::vector<std::pair<const char*, int>> operMap; //定义数学运算符号表
std::vector<std::pair<const char*, int>> limitMap; //定义限界符号表
std::vector<std::pair<const char*, int>> AddMap; //定义后续添加的表

void initBraceMapping()
{
    brace_count.clear();
    brace_count.push_back(std::make_pair("leftSmall", 0));
    brace_count.push_back(std::make_pair("rightSmall", 0));
    brace_count.push_back(std::make_pair("leftMiddle", 0));
    brace_count.push_back(std::make_pair("rightMiddle", 0));
    brace_count.push_back(std::make_pair("leftBig", 0));
    brace_count.push_back(std::make_pair("rightBig", 0));
}
/*
 *函数名称：initKeyMapping
 *参数：无
 *实现功能：初始化关键字Map
 *最近更改时间：4/30
 *更改作者：谢远峰
 *完成情况：DONE
 */
void initKeyMapping()
{
    keyMap.clear();
    keyMap.push_back(std::make_pair("break", BREAK));
    keyMap.push_back(std::make_pair("char", CHAR));
    keyMap.push_back(std::make_pair("continue", CONTINUE));
    keyMap.push_back(std::make_pair("else", ELSE));
    keyMap.push_back(std::make_pair("float", FLOAT));
    keyMap.push_back(std::make_pair("for", FOR));
    keyMap.push_back(std::make_pair("if", IF));
    keyMap.push_back(std::make_pair("int", INT));
    keyMap.push_back(std::make_pair("return", RETURN));
    keyMap.push_back(std::make_pair("void", VOID));
    keyMap.push_back(std::make_pair("while", WHILE));
    keyMap.push_back(std::make_pair("string", STR));
}

/*
 *函数名称：initOperMapping
 *参数：无
 *实现功能：初始化数学运算符号Map
 *最近更改时间：4/30
 *更改作者：谢远峰
 *完成情况：DONE
 */
void initOperMapping()
{
    operMap.clear();
    operMap.push_back(std::make_pair("*", MUL));
    operMap.push_back(std::make_pair("/", DIV));
    operMap.push_back(std::make_pair("%", MOD));
    operMap.push_back(std::make_pair("+", ADD));
    operMap.push_back(std::make_pair("-", SUB));
    operMap.push_back(std::make_pair("<", LES_THAN));
    operMap.push_back(std::make_pair(">", GRT_THAN));
    operMap.push_back(std::make_pair("=", ASG));
    operMap.push_back(std::make_pair("++", SELF_ADD));
    operMap.push_back(std::make_pair("--", SELF_SUB));
    operMap.push_back(std::make_pair("<=", LES_EQUAL));
    operMap.push_back(std::make_pair(">=", GRT_EQUAL));
    operMap.push_back(std::make_pair("==", EQUAL));
    operMap.push_back(std::make_pair("!=", NOT_EQUAL));
    operMap.push_back(std::make_pair("&&", AND));
    operMap.push_back(std::make_pair("||", OR));
    operMap.push_back(std::make_pair("+=", COMPLETE_ADD));
    operMap.push_back(std::make_pair("-=", COMPLETE_SUB));
    operMap.push_back(std::make_pair("*=", COMPLETE_MUL));
    operMap.push_back(std::make_pair("/=", COMPLETE_DIV));
    operMap.push_back(std::make_pair("%=", COMPLETE_MOD));
}

/*
 *函数名称：initLimitMapping
 *参数：无
 *实现功能：初始化界符号Map
 *最近更改时间：4/30
 *更改作者：谢远峰
 *完成情况：DONE
 */
void initLimitMapping()
{
    limitMap.clear();
    limitMap.push_back(std::make_pair("(", LEFT_BRA));
    limitMap.push_back(std::make_pair(")", RIGHT_BRA));
    limitMap.push_back(std::make_pair("[", LEFT_INDEX));
    limitMap.push_back(std::make_pair("]", RIGHT_INDEX));
    limitMap.push_back(std::make_pair("{", L_BOUNDER));
    limitMap.push_back(std::make_pair("}", R_BOUNDER));
    limitMap.push_back(std::make_pair(".", POINTER));
    limitMap.push_back(std::make_pair(",", COMMA));
    limitMap.push_back(std::make_pair(";", SEMI));
}

/*
 *函数名称：initAddMap
 *参数：无
 *实现功能：初始化常量类型符号Map
 *最近更改时间：4/30
 *更改作者：谢远峰
 *完成情况：DONE
 */
void initAddMap()
{
    AddMap.clear();
    AddMap.push_back(std::make_pair("STR", str_val));
    AddMap.push_back(std::make_pair("CHAR", char_val));
    AddMap.push_back(std::make_pair("FLOAT", float_val));
    AddMap.push_back(std::make_pair("INT", int_val));
    AddMap.push_back(std::make_pair("init", INIT));
    AddMap.push_back(std::make_pair("IDN", IDN));
}

/*
 *函数名称：initNode
 *参数：无
 *实现功能：初始化三个表的头结点
 *最近更改时间：4/30
 *更改作者：谢远峰
 *完成情况：DONE
 */
void initNode()
{
    normalHead = new NormalNode();
    strcpy(normalHead->content, "");
    strcpy(normalHead->describe, "");
    normalHead->type = -1;
    normalHead->addr = -1;
    normalHead->line = -1;
    normalHead->next = NULL;

    errorHead = new ErrorNode();
    strcpy(errorHead->content, "");
    strcpy(errorHead->describe, "");
    errorHead->line = -1;
    errorHead->next = NULL;

    idenHead = new IdentiferNode();
    strcpy(idenHead->content, "");
    strcpy(idenHead->describe, "");
    idenHead->type = -1;
    idenHead->addr = -1;
    idenHead->line = -1;
    idenHead->next = NULL;
}

/*
 *函数名称：createNewNode
 *参数：token内容，token描述，token类型，token所在行地址，token所在行数
 *实现功能：根据传入参数创建TOKEN结点
 *最近更改时间：4/30
 *更改作者：谢远峰
 *完成情况：DONE
 */
void createNewNode(char const* content, char const* descirbe, int type, int addr, int line)
{
    NormalNode* p = normalHead;
    NormalNode* temp = new NormalNode();

    while (p->next != NULL)
    {
        p = p->next;
    }

    strcpy(temp->content, content); // 内容
    strcpy(temp->describe, descirbe);
    temp->type = type; // 类型
    temp->addr = addr; // 地址
    temp->line = line; // 行号
    temp->next = NULL; // 下一个结点

    p->next = temp; // 将新结点指向原来的尾结点
}

/*
 *函数名称：createNewError
 *参数：token内容，token描述，token类型，token所在行地址，token所在行数
 *实现功能：根据传入参数创建错误TOKEN结点
 *最近更改时间：4/30
 *更改作者：谢远峰
 *完成情况：DONE
 */
void createNewError(char const* content, char const* descirbe, int type, int line)
{
    ErrorNode* p = errorHead;
    ErrorNode* temp = new ErrorNode();

    strcpy(temp->content, content);
    strcpy(temp->describe, descirbe);
    temp->type = type;
    temp->line = line;
    temp->next = NULL;
    while (p->next != NULL)
    {
        p = p->next;
    }
    p->next = temp;
}

/*
 *函数名称：createNewError
 *参数：token内容，token描述，token类型，token所在行地址，token所在行数
 *实现功能：加入新的标识符结点
 *最近更改时间：4/30
 *更改作者：谢远峰
 *完成情况：DONE
 */
int createNewIden(char const* content, char const* descirbe, int type, int line)
{
    static int static_iden_number = 0; //模拟标志符的地址
    IdentiferNode* p = idenHead;
    IdentiferNode* temp = new IdentiferNode();
    int flag = 0;
    int addr_temp = -2;
    while (p->next != NULL)
    {
        if (strcmp(content, p->next->content) == 0)
        {
            flag = 1;
            addr_temp = p->next->addr;
        }
        p = p->next;
    }
    if (flag == 0)
    {
        addr_temp = ++static_iden_number; //用自增来模拟入口地址
    }
    strcpy(temp->content, content);
    strcpy(temp->describe, descirbe);
    temp->type = type;
    temp->addr = addr_temp;
    temp->line = line;
    temp->next = NULL;
    p->next = temp;
    return addr_temp;
}

/*
 *函数名称：printNode1
 *参数：无
 *实现功能：输出打印识别到的TOKEN
 *最近更改时间：4/30
 *更改作者：谢远峰
 *完成情况：DONE
 */
void printNode1()
{
    FILE* fp = fopen("output//Filecifa.txt", "a+");
    fprintf(fp, "TOKEN:\n[ ");
    NormalNode* p = normalHead;
    p = p->next;
    while (p != NULL)
    {
        switch (p->type)
        {
        case int_val:
            fprintf(fp, "INT, ");
            break;
        case float_val:
            fprintf(fp, "FLOAT, ");
            break;
        case char_val:
            fprintf(fp, "CHAR, ");
            break;
        case str_val:
            fprintf(fp, "STRING, ");
            break;
        case IDN:
            if (!strcmp(p->content, "main"))
                fprintf(fp, "MAIN, ");
            else
                fprintf(fp, "IDN, ");
            break;
        default:
            fprintf(fp, "%s, ", p->content);
            break;
        }
        p = p->next;
    }
    fprintf(fp, "]\n");
    fclose(fp);
    // free(fp);
}

/*
 *函数名称：printNode2
 *参数：无
 *实现功能：输出打印识别到的TOKEN
 *最近更改时间：4/30
 *更改作者：谢远峰
 *完成情况：DONE
 */
void printNode2()
{
    NormalNode* p = normalHead;
    p = p->next;
    FILE* fp = fopen("output//Filecifa.txt", "a+");
    fprintf(fp, "\n\n");
    while (p != NULL)
    {
        if (p->type == IDN)
        {
            fprintf(fp, "%s %s %s %s\n", p->content, "<", "IDN", ">");
        }
        else if (p->type < 20 && p->type >= 0)
        {
            fprintf(fp, "%s %s %s %s\n", p->content, "<", p->content, ",_>");
        }
        else if (p->type > 16 && p->type < 30)
        {
            fprintf(fp, "%s %s %s %s\n", p->content, "<", "CONST", ">");
        }
        else if (p->type >= 70 && p->type < 100)
        {
            fprintf(fp, "%s %s %s %s\n", p->content, "<", "OP", ">");
        }
        else if (p->type >= 100)
        {
            fprintf(fp, "%s %s %s %s\n", p->content, "<", "SE", ",_>");
        }
        p = p->next;
    }
    fprintf(fp, "\n\n");
    fclose(fp);
    // free(fp);
}

/*
 *函数名称：printNodeLink
 *参数：无
 *实现功能：输出打印识别到的TOKEN的详细信息
 *最近更改时间：4/30
 *更改作者：谢远峰
 *完成情况：DONE
 */
void printNodeLink()
{
    FILE* fp = fopen("output//TokenAnalysis.txt", "a+");
    NormalNode* p = normalHead;
    p = p->next;
    fprintf(fp, "***********************词法分析表************************\n");
    fprintf(fp, "%-8s %-10s %-11s %-10s %-8s \n", "内容", "描述", "种别码", "地址", "行号");
    while (p != NULL)
    {
        if (p->type == IDN)
        {
            fprintf(fp, "%-8s %-10s %-11d %-10d %-8d \n", p->content, p->describe, p->type, p->addr, p->line);
        }
        else
        {
            fprintf(fp, "%-8s %-10s %-10d %-15d \n", p->content, p->describe, p->type, p->line);
        }
        p = p->next;
    }
    fprintf(fp, "\n\n");
    fclose(fp);
    // free(fp);
}

/*
 *函数名称：printErrorLink
 *参数：无
 *实现功能：输出打印未识别到的TOKEN的详细信息
 *最近更改时间：4/30
 *更改作者：谢远峰
 *完成情况：DONE
 */
void printErrorLink()
{
    FILE* fp = fopen("output//ErrorAnalysis.txt", "a+");
    ErrorNode* p = errorHead;
    p = p->next;
    fprintf(fp, "***********************错误表************************\n");
    fprintf(fp, "%-8s %-10s %-8s %-8s \n", "内容", "描述", "类型", "行号");
    while (p != NULL)
    {
        fprintf(fp, "%-8s %-10s %-8d %-8d \n", p->content, p->describe, p->type, p->line);
        p = p->next;
    }
    fprintf(fp, "\n\n");
    fclose(fp);
    // free(fp);
}

void printIdentLink()
{
    FILE* fp = fopen("output//IdenList.txt", "a+");
    IdentiferNode* p = idenHead;
    p = p->next;
    fprintf(fp, "***********************符号表************************\n");
    fprintf(fp, "%-8s %-10s %-11s %-10s %-8s \n", "内容", "描述", "种别码", "地址", "行号");
    while (p != NULL)
    {
        fprintf(fp, "%-8s %-10s %-10d %-15d \n", p->content, p->describe, p->type, p->line);
        p = p->next;
    }
    fprintf(fp, "\n\n");
    fclose(fp);
    // free(fp);
}

/*
 *函数名称：close
 *参数：无
 *实现功能：删除所有的表头
 *最近更改时间：4/30
 *更改作者：谢远峰
 *完成情况：DONE
 */
void close()
{
    // delete idenHead;
    free(idenHead);
    // delete errorHead;
    free(errorHead);
    // delete normalHead;
    free(normalHead);
}

/*
 *函数名称：seekKey
 *参数：TOKEN的起始字符指针
 *实现功能：进入关键字表进行查询，返回种别号，默认标识符
 *最近更改时间：4/30
 *更改作者：谢远峰
 *完成情况：DONE
 */
int seekKey(char* word)
{
    for (int i = 0; i < int(keyMap.size()); i++)
    {
        if (strcmp(word, keyMap[i].first) == 0)
        {
            return keyMap[i].second;
        }
    }
    return IDN;
}

/*
 *函数名称：scanner
 *参数：无
 *实现功能：打开测试文件，逐行读取字符获取TOKEN，并根据键值表查找，归类为终结符表和非终结符表并输出
 *最近更改时间：4/30
 *更改作者：谢远峰
 *完成情况：DONE
 */
void scanner()
{
    char ch;
    char array[30]; //单词长度上限??30
    char* word;
    int i;
    int line = 1; //行数

    FILE* infile;
    infile = fopen("input//test.txt", "r");
    while (!infile)
    {
        printf("打开文件失败！\n");
        return;
    }
    ch = fgetc(infile);
    while (ch != EOF)
    {
        i = 0;
        //以字母或者下划线开,处理关键字或者标识符
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch == '_')
        {
            while ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || ch == '_')
            {
                array[i++] = ch;
                ch = fgetc(infile);
            }
            word = new char[i + 1];
            memcpy(word, array, i);
            word[i] = '\0';
            int seekTemp = seekKey(word);
            if (seekTemp != IDN)
            { //首先查看是否为关键字
                createNewNode(word, KEY_DESC, seekTemp, -1, line);
            }
            else
            {
                int addr_tmp = createNewIden(word, IDENTIFER_DESC, seekTemp, line);
                createNewNode(word, IDENTIFER_DESC, seekTemp, addr_tmp, line);
            }
            fseek(infile, -1L, SEEK_CUR); //向后回退一??
        }
        //以数字开头，处理数字
        else if (ch >= '0' && ch <= '9')
        {
            int flag = 0;
            int flag2 = 0;
            //处理整数
            while (ch >= '0' && ch <= '9')
            {
                array[i++] = ch;
                ch = fgetc(infile);
            }
            //处理float
            if (ch == '.')
            {
                flag2 = 1;
                array[i++] = ch;
                ch = fgetc(infile);
                if (ch >= '0' && ch <= '9')
                {
                    while (ch >= '0' && ch <= '9')
                    {
                        array[i++] = ch;
                        ch = fgetc(infile);
                    }
                }
                else
                {
                    flag = 1;
                }
            }
            word = new char[i + 1];
            memcpy(word, array, i);
            word[i] = '\0';
            if (flag == 1)
            { //错误的float类型
                createNewError(word, FLOAT_ERROR, FLOAT_ERROR_NUM, line);
            }
            else
            {
                if (flag2 == 0)
                {
                    createNewNode(word, CONSTANT_DESC, int_val, -1, line);
                }
                else
                {
                    createNewNode(word, CONSTANT_DESC, float_val, -1, line);
                }
            }
            fseek(infile, -1L, SEEK_CUR); //向后回退一??
        }
        //??"/"开??
        else if (ch == '/')
        {
            ch = fgetc(infile);
            //处理运算??"/="
            if (ch == '=')
            {
                createNewNode("/=", OPE_DESC, COMPLETE_DIV, -1, line);
            } //处理除号
            else
            {
                createNewNode("/", OPE_DESC, DIV, -1, line);
            }
        }
        //处理常量字符??
        else if (ch == '"')
        {
            ch = fgetc(infile);
            i = 0;
            while (ch != '"')
            {
                array[i++] = ch;
                if (ch == '\n')
                {
                    line++;
                }
                ch = fgetc(infile);
                if (ch == EOF)
                {
                    createNewError(_NULL, STRING_ERROR, STRING_ERROR_NUM, line);
                    return;
                }
            }
            word = new char[i + 1];
            memcpy(word, array, i);
            word[i] = '\0';
            createNewNode(word, CONSTANT_DESC, str_val, -1, line);
        }
        //处理常量字符
        else if (ch == '\'')
        {
            ch = fgetc(infile);
            i = 0;
            while (ch != '\'')
            {
                array[i++] = ch;
                if (ch == '\n')
                {
                    line++;
                }
                ch = fgetc(infile);
                if (ch == EOF)
                {
                    createNewError(_NULL, CHARCONST_ERROR, CHARCONST_ERROR_NUM, line);
                    return;
                }
            }
            word = new char[i + 1];
            memcpy(word, array, i);
            word[i] = '\0';
            createNewNode(word, CONSTANT_DESC, char_val, -1, line);
        }
        else if (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\n')
        {
            if (ch == '\n')
            {
                line++;
            }
        }
        else
        {
            if (ch == EOF)
            {
                return;
            }
            //处理-开头的运算??
            else if (ch == '-')
            {
                array[i++] = ch;
                ch = fgetc(infile);
                if (ch >= '0' && ch <= '9')
                {
                    int flag = 0;
                    int flag2 = 0;
                    //处理整数
                    while (ch >= '0' && ch <= '9')
                    {
                        array[i++] = ch;
                        ch = fgetc(infile);
                    }
                    //处理float
                    if (ch == '.')
                    {
                        flag2 = 1;
                        array[i++] = ch;
                        ch = fgetc(infile);
                        if (ch >= '0' && ch <= '9')
                        {
                            while (ch >= '0' && ch <= '9')
                            {
                                array[i++] = ch;
                                ch = fgetc(infile);
                            }
                        }
                        else
                        {
                            flag = 1;
                        }
                    }
                    word = new char[i + 1];
                    memcpy(word, array, i);
                    word[i] = '\0';
                    if (flag == 1)
                    {
                        createNewError(word, FLOAT_ERROR, FLOAT_ERROR_NUM, line);
                    }
                    else
                    {
                        if (flag2 == 0)
                        {
                            createNewNode(word, CONSTANT_DESC, INT, -1, line);
                        }
                        else
                        {
                            createNewNode(word, CONSTANT_DESC, FLOAT, -1, line);
                        }
                    }
                    fseek(infile, -1L, SEEK_CUR); //向后回退一??
                }
                else if (ch == '-')
                {
                    createNewNode("--", OPE_DESC, SELF_SUB, -1, line);
                }
                else if (ch == '=')
                {
                    createNewNode("-=", OPE_DESC, SELF_SUB, -1, line);
                }
                else
                {
                    createNewNode("-", OPE_DESC, SUB, -1, line);
                    fseek(infile, -1L, SEEK_CUR);
                }
            }
            //处理+开头的运算
            else if (ch == '+')
            {
                ch = fgetc(infile);
                if (ch == '+')
                {
                    createNewNode("++", OPE_DESC, SELF_ADD, -1, line);
                }
                else if (ch == '=')
                {
                    createNewNode("+=", OPE_DESC, COMPLETE_ADD, -1, line);
                }
                else
                {
                    createNewNode("+", OPE_DESC, ADD, -1, line);
                    fseek(infile, -1L, SEEK_CUR);
                }
            }
            //处理*开头的运算
            else if (ch == '*')
            {
                ch = fgetc(infile);
                if (ch == '=')
                {
                    createNewNode("*=", OPE_DESC, COMPLETE_MUL, -1, line);
                }
                else
                {
                    createNewNode("*", OPE_DESC, MUL, -1, line);
                    fseek(infile, -1L, SEEK_CUR);
                }
            }
            //处理%开头的运算??
            else if (ch == '%')
            {
                ch = fgetc(infile);
                if (ch == '=')
                {
                    createNewNode("%=", OPE_DESC, COMPLETE_MOD, -1, line);
                }
                else
                {
                    createNewNode("%", OPE_DESC, MOD, -1, line);
                    fseek(infile, -1L, SEEK_CUR);
                }
            }
            //处理&开头的运算
            else if (ch == '&')
            {
                ch = fgetc(infile);
                if (ch == '&')
                {
                    createNewNode("&&", OPE_DESC, AND, -1, line);
                }
            }
            //处理<开头的运算
            else if (ch == '<')
            {
                ch = fgetc(infile);
                if (ch == '=')
                {
                    createNewNode("<=", OPE_DESC, LES_EQUAL, -1, line);
                }
                else
                {
                    createNewNode("<", OPE_DESC, LES_THAN, -1, line);
                    fseek(infile, -1L, SEEK_CUR);
                }
            }
            //处理>开头的运算??
            else if (ch == '>')
            {
                ch = fgetc(infile);
                if (ch == '=')
                {
                    createNewNode(">=", OPE_DESC, GRT_EQUAL, -1, line);
                }
                else
                {
                    createNewNode(">", OPE_DESC, GRT_THAN, -1, line);
                    fseek(infile, -1L, SEEK_CUR);
                }
            }
            //处理|开头的运算??
            else if (ch == '|')
            {
                ch = fgetc(infile);
                if (ch == '|')
                {
                    createNewNode("||", OPE_DESC, OR, -1, line);
                }
            }
            else if (ch == '=')
            {
                ch = fgetc(infile);
                if (ch == '=')
                {
                    createNewNode("==", OPE_DESC, EQUAL, -1, line);
                }
                else
                {
                    createNewNode("=", OPE_DESC, ASG, -1, line);
                    fseek(infile, -1L, SEEK_CUR);
                }
            }
            else if (ch == '(')
            {
                brace_count[0].second++;
                lineBra[0][brace_count[0].second] = line;
                createNewNode("(", CLE_OPE_DESC, LEFT_BRA, -1, line);
            }
            else if (ch == ')')
            {
                brace_count[1].second++;
                lineBra[1][brace_count[1].second] = line;
                createNewNode(")", CLE_OPE_DESC, RIGHT_BRA, -1, line);
            }
            else if (ch == '[')
            {
                brace_count[2].second++;
                lineBra[2][brace_count[2].second] = line;
                createNewNode("[", CLE_OPE_DESC, LEFT_INDEX, -1, line);
            }
            else if (ch == ']')
            {
                brace_count[3].second++;
                lineBra[3][brace_count[3].second] = line;
                createNewNode("]", CLE_OPE_DESC, RIGHT_INDEX, -1, line);
            }
            else if (ch == '{')
            {
                brace_count[4].second++;
                lineBra[4][brace_count[4].second] = line;
                createNewNode("{", CLE_OPE_DESC, L_BOUNDER, -1, line);
            }
            else if (ch == '}')
            {
                brace_count[5].second++;
                lineBra[5][brace_count[5].second] = line;
                createNewNode("}", CLE_OPE_DESC, R_BOUNDER, -1, line);
            }
            else if (ch == '.')
            {
                createNewNode(".", CLE_OPE_DESC, POINTER, -1, line);
            }
            else if (ch == ',')
            {
                createNewNode(",", CLE_OPE_DESC, COMMA, -1, line);
            }
            else if (ch == ';')
            {
                createNewNode(";", CLE_OPE_DESC, SEMI, -1, line);
            }
            else
            {
                char temp[2];
                temp[0] = ch;
                temp[1] = '\0';
                createNewError(temp, CHAR_ERROR, CHAR_ERROR_NUM, line);
            }
        }
        ch = fgetc(infile);
    }
}

/*
 *函数名称：BraMappingError
 *参数：无
 *实现功能：判定括号的匹配情况（小括号，中括号，大括号）
 *最近更改时间：4/30
 *更改作者：谢远峰
 *完成情况：DONE
 */
void BraMappingError()
{
    if (brace_count[0].second != brace_count[1].second)
    {
        int i = (brace_count[0].second > brace_count[1].second) ? (brace_count[0].second - brace_count[1].second) :
                                                                  (brace_count[1].second - brace_count[0].second);
        bool flag = (brace_count[0].second > brace_count[1].second) ? true : false;
        if (flag)
        {
            while (i--)
            {
                createNewError(_NULL, LEFT_BRA_ERROR, LEFT_BRA_ERROR_NUM, lineBra[0][i + 1]);
            }
        }
        else
        {
            while (i--)
            {
                createNewError(_NULL, RIGHT_BRA_ERROR, RIGHT_BRA_ERROR_NUM, lineBra[1][i + 1]);
            }
        }
    }
    if (brace_count[2].second != brace_count[3].second)
    {
        int i = (brace_count[2].second > brace_count[3].second) ? (brace_count[2].second - brace_count[3].second) :
                                                                  (brace_count[3].second - brace_count[2].second);
        bool flag = (brace_count[2].second > brace_count[3].second) ? true : false;
        if (flag)
        {
            while (i--)
            {
                createNewError(_NULL, LEFT_INDEX_ERROR, LEFT_INDEX_ERROR_NUM, lineBra[2][i + 1]);
            }
        }
        else
        {
            while (i--)
            {
                createNewError(_NULL, RIGHT_INDEX_ERROR, RIGHT_INDEX_ERROR_NUM, lineBra[3][i + 1]);
            }
        }
    }
    if (brace_count[4].second != brace_count[5].second)
    {
        int i = (brace_count[4].second > brace_count[5].second) ? (brace_count[4].second - brace_count[5].second) :
                                                                  (brace_count[5].second - brace_count[4].second);
        bool flag = (brace_count[4].second > brace_count[5].second) ? true : false;
        if (flag)
        {
            while (i--)
            {
                createNewError(_NULL, L_BOUNDER_ERROR, L_BOUNDER_ERROR_NUM, lineBra[4][i + 1]);
            }
        }
        else
        {
            while (i--)
            {
                createNewError(_NULL, R_BOUNDER_ERROR, R_BOUNDER_ERROR_NUM, lineBra[5][i + 1]);
            }
        }
    }
}

void LexAnalysis()
{
    // 词法分析的部分
    initBraceMapping();
    initKeyMapping();
    initOperMapping();
    initLimitMapping();
    initAddMap();
    initNode();
    scanner();
    BraMappingError();
    printNodeLink();
    printErrorLink();
    printIdentLink();
    printNode1();
    printNode2();
    return;
}