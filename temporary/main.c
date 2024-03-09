#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

struct Birthday {
  int year, month, day;
};

struct Stu {
  char name[20];
  char id[18];
  char sex[5];
  struct Birthday birth;
  char nationality[20];
  char classs[20];
  int num;
};  // 学生信息

void menu() {
  printf("--------------------\n");
  printf("|      首页        |\n");
  printf("|                  |\n");
  printf("|1.添加学生信息    |\n");
  printf("|2.删除学生信息    |\n");
  printf("|3.修改学生信息    |\n");
  printf("|4.查询学生信息    |\n");
  printf("|5.将信息存入文件中|\n");
  printf("|6.从文件中读取信息|\n");
  printf("|0.退出            |\n");
  printf("--------------------\n");
  printf("请选择：");
}

void add_student(struct Stu* stu, int* a) {
  printf("请输入学生姓名：");
  scanf("%s", stu[*a].name);
  printf("请输入学生身份证号：");
  scanf("%s", stu[*a].id);
  printf("请输入学生性别：");
  scanf("%s", stu[*a].sex);
  printf("请输入学生出生年月日(例:2000 1 1):");
  scanf("%d %d %d", &stu[*a].birth.year, &stu[*a].birth.month,
        &stu[*a].birth.day);
  printf("请输入学生民族：");
  scanf("%s", stu[*a].nationality);
  printf("请输入学生班级：");
  scanf("%s", stu[*a].classs);
  printf("请输入学生学号：");
  scanf("%d", &stu[*a].num);
  (*a)++;
}

void delete_student(struct Stu* stu, int* a) {
  printf("请输入你想删除的学生学号：");
  int num;
  scanf("%d", &num);

  int i, j;
  for (i = 0; i < *a; i++) {
    if (stu[i].num == num) {
      for (j = i; j < *a - 1; j++) {
        stu[j] = stu[j + 1];
      }
      (*a)--;
      return;
    }
  }
  printf("未存入该学生信息！\n");
  return;
}

int menu_amend() {
  printf("1.学生姓名\n");
  printf("2.学生身份证号\n");
  printf("3.学生性别\n");
  printf("4.学生出生年月日\n");
  printf("5.学生民族\n");
  printf("6.学生班级\n");
  printf("7.学生学号\n");
  printf("0.返回首页\n");
  printf("请选择你要修改的学生信息的序号：");

  int j;
  scanf("%d", &j);

  return j;
}

void amend_studnet(struct Stu* stu, int* a) {
  printf("请输入你要修改的学生学号：");
  int n;
  scanf("%d", &n);
  printf("\n");

  for (int i = 0; i < *a; i++) {
    if (stu[i].num == n) {
      int b = menu_amend();

      printf("请输入修改信息:");
      switch (b) {
        case 1: {
          scanf("%s", stu[i].name);
          break;
        }
        case 2: {
          scanf("%d", stu[i].id);
          break;
        }
        case 3: {
          scanf("%s", stu[i].sex);
          break;
        }
        case 4: {
          scanf("%d%d%d", &stu[i].birth.year, &stu[i].birth.month,
                &stu[i].birth.day);
          break;
        }
        case 5: {
          scanf("%s", stu[i].nationality);
        }
        case 6: {
          scanf("%s", stu[*a].classs);
          break;
        }
        case 7: {
          scanf("%d", stu[i].num);
          break;
        }
        case 0: {
          break;
        }
        default: {
          printf("非法选项，请重新选择！\n");
          break;
        }
      }
      printf("修改完成！\n");
      return;
    }
  }
  printf("未存入该学生信息！\n");
  return;
}

void inquire_student(struct Stu* stu, int* a) {
  printf("请输入你想查询的学生学号：");
  int num;
  scanf("%d", &num);

  for (int i = 0; i < *a; i++) {
    if (stu[i].num == num) {
      printf("学生姓名：%s\n", stu[i].name);
      printf("学生身份证号：%d\n", stu[i].id);
      printf("学生性别：%s\n", stu[i].sex);
      printf("学生出生年月日:%d.%d.%d\n", stu[i].birth.year, stu[i].birth.month,
             stu[i].birth.day);
      printf("学生民族：%s\n", stu[i].nationality);
      printf("学生班级：%s\n", stu[i].classs);
      printf("学生学号：%d\n", stu[i].num);
      return;
    }
  }
  printf("未存入该学生信息！\n");
  return;
}

void file_save_student(struct Stu* stu, int* a) {
  FILE* fp;
  fp = fopen("student.txt", "w");
  if (fp == NULL) {
    printf("无法打开文件\n");
    return;
  }

  for (int i = 0; i < *a; i++) {
    fprintf(fp, "%s %d %s %d %d %d %s %s %s %d", stu[i].name, stu[i].id,
            stu[i].sex, stu[i].birth.year, stu[i].birth.month, stu[i].birth.day,
            stu[i].nationality, stu[i].classs, stu[i].num);
  }
  fclose(fp);
  printf("信息已保存到文件中！\n");
}

void file_read_student(struct Stu* stu, int* a) {
  FILE* fp;
  fp = fopen("student.txt", "r");
  if (fp == NULL) {
    printf("无法打开文件\n");
    return;
  }

  for (int i = 0; i < *a; i++) {
    fscanf(fp, "%s %d %s %d %d %d %s %s %s %d", stu[i].name, stu[i].id,
           stu[i].sex, stu[i].birth.year, stu[i].birth.month, stu[i].birth.day,
           stu[i].nationality, stu[i].classs, stu[i].num);
  }

  fclose(fp);
  printf("已读取文件中的信息！\n");
}

int main() {
  struct Stu student[100];
  int choice, i = 0;

  while (1) {
    menu();
    scanf("%d", &choice);

    switch (choice) {
      case 1: {
        add_student(student, &i);
        break;
      }
      case 2: {
        delete_student(student, &i);
        break;
      }
      case 3: {
        amend_studnet(student, &i);
        break;
      }
      case 4: {
        inquire_student(student, &i);
        break;
      }
      case 5: {
        file_save_student(student, &i);
        break;
      }
      case 6: {
        file_read_student(student, &i);
        break;
      }
      case 0:
        return 0;
      default: {
        printf("非法选项，请重新选择\n");
        break;
      }
    }
  }

  return 0;
}