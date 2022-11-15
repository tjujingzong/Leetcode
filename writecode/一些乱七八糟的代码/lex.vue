<template>
  <div id="LexecalResult">
    <div id="main">
      <div id="note" class="animate__animated animate__flipInX">
        <div class="title">
          <strong>Tips：</strong>
        </div>
        <div class="content">
          下面是根据您上传的程序代码后智能分析出的词素以及token序列，如果您需要修改程序代码请点击下方按钮返回编辑页面重新编辑~
          <br />
          <div class="link-card" @click="backup">
            <a href="#">
              <div class="left">
                <img src="https://cdn.jsdelivr.net/gh/volantis-x/cdn-org/logo/256/safari.png" />
              </div>
              <div class="right">
                <p class="text">返回编辑页面</p>
                <p class="url">
                  如果喜欢此网站，不妨
                  <kbd>Ctrl</kbd>+
                  <kbd>D</kbd>收藏一下😛！
                </p>
              </div>
            </a>
          </div>
        </div>
      </div>
      <div id="lexemes" class="animate__animated animate__flipInX">
        <div class="title">
          <strong>您输入的程序代码经分析后词素序列如下：</strong>
        </div>
        <div class="content">[{{component}}]</div>
      </div>
      <div id="token" class="animate__animated animate__fadeIn">
        <div class="table-container">
          <table>
            <thead>
              <tr>
                <th style="text-align:center">单词</th>
                <th style="text-align:center">所属类型</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(item,i) in token" :key="i">
                <td style="text-align:center">{{token[i].lexem}}</td>
                <td style="text-align:center">{{token[i].type}}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      <div id="error" class="animate__animated animate__flipInX">
        <div class="title">
          <strong>您的代码可能存在的错误有：</strong>
        </div>
        <div class="content" v-for=" (e,j) in error" :key="j">
          <i class="fas fa-exclamation-circle"></i>
          &nbsp;{{e}}
        </div>
      </div>
    </div>
  </div>
</template>

<script>
const KeyWord_Set = new Set([
  "while",
  "for",
  "continue",
  "break",
  "if",
  "else",
  "float",
  "int",
  "char",
  "void",
  "return",
  "string",
  "cout"
]);
const OP_Set = new Set([
  "+",
  "-",
  "*",
  "/",
  "%",
  "=",
  ">",
  "<",
  "==",
  "<=",
  ">=",
  "!=",
  "++",
  "--",
  "&&",
  "||",
  "+=",
  "-=",
  "*=",
  "/=",
  "%="
]);
const SE_Set = new Set(["(", ")", "{", "}", ";", ",", "[", "]"]);
var row = 1;
export default {
  name: "LexecalResult",
  methods: {
    backup() {
      this.$router.push({ name: "CodeEditor" });
    },
    analyze(code) {
      // console.log(code);
      var arr = code.trim().split("\n");
      // alert(arr);
      for (let i = 0; i < arr.length; i++) {
        var temp = "";
        row = i + 1;
        var content = arr[i];
        // alert(content);
        for (let index = 0; index < content.length; index++) {
          // 获取当前字符
          var str = content.substring(index, index + 1);
          if (temp === ``) {
            // 当前字符为双引号 即读入字符串
            if (str === '"') {
              // 能找到第二个双引号
              if (content.indexOf('"', index + 1) != -1) {
                var firstIndex = index;
                var secondIndex = content.indexOf('"', index + 1);
                var string = content.substring(firstIndex + 1, secondIndex);
                this.component.push('"');
                this.token.push({ lexem: '"', type: "<SE,_>" });
                this.component.push("STRING");
                this.token.push({
                  lexem: string,
                  type: "<CONST," + string + ">"
                });
                this.component.push('"');
                this.token.push({ lexem: '"', type: "<SE,_>" });
                index = content.indexOf('"', index + 1);
                continue;
              } else {
                this.component.push('"');
                this.token.push({ lexem: '"', type: "<SE,_>" });
                this.component.push("STRING");
                this.token.push({
                  lexem: content.substring(index + 1),
                  type: "<CONST," + content.substring(index + 1) + ">"
                });
                this.error.push(
                  "第" +
                    row +
                    "行字符串结尾缺少双引号: " +
                    content.substring(index)
                );
                break;
              }
            }
            if (str === " " || str === "\t") {
              continue;
            }
            if (this.isKeyWord(str)) {
              if (index != content.length - 1) {
                var doubleStr = content.substring(index, index + 2);
                if (this.isKeyWord(doubleStr)) {
                  this.component.push(doubleStr);
                  this.token.push({
                    lexem: doubleStr,
                    type: "<OP," + doubleStr + ">"
                  });
                  index++;
                  continue;
                }
              }
              this.component.push(str);
              if (SE_Set.has(str)) {
                this.token.push({ lexem: str, type: "<SE,_>" });
              } else if (OP_Set.has(str)) {
                this.token.push({ lexem: str, type: "<OP,_>" });
              }
              continue;
            }
            // 当前字符为变量名或变量名的一部分
            // 或整形及其一部分
            // 修改temp
            temp = temp + str;
          } else {
            // 再讨论temp不为空的情况
            // 当前字符为空格
            if (str === ` ` || str === "\t") {
              this.updateComponentAndToken(temp);
              temp = ``;
              continue;
            }
            if (str === "(") {
              this.component.push(temp);
              this.token.push({ lexem: temp, type: "<IDN," + temp + ">" });
              temp = ``;
              this.component.push("(");
              this.token.push({ lexem: "(", type: "<SE,_>" });
              continue;
            }
            if (this.isKeyWord(str)) {
              this.updateComponentAndToken(temp);
              if (index != content.length - 1) {
                var doubleStr = content.substring(index, index + 2);
                if (this.isKeyWord(doubleStr)) {
                  this.component.push(doubleStr);
                  this.token.push({
                    lexem: doubleStr,
                    type: "<OP," + doubleStr + ">"
                  });
                  index++;
                  temp = ``;
                  continue;
                }
              }
              temp = ``;
              this.component.push(str);
              if (SE_Set.has(str)) {
                this.token.push({ lexem: str, type: "<SE,_>" });
              } else if (OP_Set.has(str)) {
                this.token.push({ lexem: str, type: "<OP,_>" });
              }
              continue;
            }
            temp = temp + str;
            if (index === content.length - 1) {
              this.updateComponentAndToken(temp.trim());
            }
          }
        }
      }
    },
    isKeyWord(str) {
      if (KeyWord_Set.has(str)) return true;
      if (OP_Set.has(str)) return true;
      if (SE_Set.has(str)) return true;
      return false;
    },
    updateComponentAndToken(str) {
      // console.log(str);
      // if (str[0] === "'" && str[str.length - 1] === "'") console.log(str);
      // 首先判断是否为关键字
      if (this.isKeyWord(str)) {
        this.component.push(str);
        if (KeyWord_Set.has(str)) {
          // console.log(str);
          this.token.push({
            lexem: str,
            type: "<" + str.toUpperCase() + ",_>"
          });
        } else if (SE_Set.has(str)) {
          this.token.push({ lexem: str, type: "<SE,_>" });
        } else if (OP_Set.has(str)) {
          this.token.push({ lexem: str, type: "<OP,_>" });
        }
      } else if (/^-?\d+$/.test(str)) {
        // 判断是否为整形变量
        this.component.push("INT:" + str);
        this.token.push({ lexem: str, type: "<CONST," + str + ">" });
      } else if (/^(-?\d+)(\.\d+)?$/.test(str)) {
        // 判断是否为浮点数
        this.component.push("FLOAT:" + str);
        this.token.push({ lexem: str, type: "<CONST," + str + ">" });
      } else if (str[0] === "'" && str[str.length - 1] === "'") {
        // 判断是否为字符
        // console.log(str);
        if (str.length > 3) {
          this.error.push("第" + row + "行存在单引号包裹字符串错误");
        }
        this.component.push("'");
        this.token.push({ lexem: "'", type: "<SE,_>" });
        this.component.push("CHAR:" + str.substring(1, str.length - 1));
        if (str.length > 3) {
          this.token.push({
            lexem: str.substring(1, str.length - 1),
            type: "<ERROR," + str.substring(1, str.length - 1) + ">"
          });
        } else {
          this.token.push({
            lexem: str.substring(1, str.length - 1),
            type: "<CONST," + str.substring(1, str.length - 1) + ">"
          });
        }
        this.component.push("'");
        this.token.push({ lexem: "'", type: "<SE,_>" });
      } else if (/^[_$]?[a-zA-Z0-9]+/.test(str)) {
        // 判断是否为变量名
        // console.log(str);
        this.component.push("IDN:" + str);
        this.token.push({ lexem: str, type: "<IDN," + str + ">" });
      } else {
        this.token.push({ lexem: str, type: "<ERROR," + str + ">" });
        this.error.push("第" + row + "行存在非法变量: " + str);
      }
    }
  },
  mounted() {
    // alert(this.$route.params.code);
    var code = this.$route.params.code;
    this.analyze(code);
  },
  data() {
    return {
      component: [],
      token: [],
      error: []
    };
  }
};
</script>

<style scoped>
#LexecalResult {
  color: #d1d2d2;
  /* background: 0% 0% / auto repeat rgb(171, 184, 195)
    url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAwAAAAMCAYAAABWdVznAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAACFJREFUeNpiZGBg4GegAsBlCD8TqSYNQg2Mo6FEBAAIMACdPABtrSW/IQAAAABJRU5ErkJggg=="); */
  background: #313438;
  min-height: 100vh;
  overflow: hidden;
  display: flex;
  flex-direction: column;
  align-items: center;
}
#LexecalResult #main {
  width: 80%;
  min-height: 200px;
  /* background: yellow; */
  margin: 40px auto;
}
#LexecalResult #main #lexemes {
  box-sizing: border-box;
  width: 100%;
  margin-top: 1rem;
  margin-bottom: 1rem;
  padding: 0 1rem;
  border-radius: 6px;
  background: #455955;
  border: 1px solid #3ead51;
  min-height: 100px;
}
#LexecalResult #main #note {
  box-sizing: border-box;
  width: 100%;
  margin-top: 1rem;
  margin-bottom: 1rem;
  padding: 0 1rem;
  border-radius: 6px;
  background: #425465;
  border: 1px solid #2887d3;
  min-height: 100px;
}
#LexecalResult #main #note .link-card {
  margin-right: 1em;
  background: #3a3a3a;
  display: inline-flex;
  align-items: center;
  cursor: pointer;
  text-align: center;
  /* min-width: 361px; */
  max-width: 100%;
  box-shadow: 0 1px 2px 0px rgb(0 0 0 / 10%);
  color: #bbb;
  border-radius: 8px;
  margin-top: 10px;
  transition: 0.3s;
}
#LexecalResult #main #note .link-card:hover {
  box-shadow: 0 4px 8px 0px rgb(0 0 0 / 10%), 0 2px 4px 0px rgb(0 0 0 / 10%),
    0 4px 8px 0px rgb(0 0 0 / 10%), 0 8px 16px 0px rgb(0 0 0 / 10%);
}
kbd {
  color: #444 !important;
  padding: 3px 5px !important;
  border-radius: 0.25em !important;
  box-shadow: inset 0 -2px 0 #d3d3d4, 0 1px 1px #000 !important;
  font: 11px SFMono-Regular, Consolas, Liberation Mono, Menlo, monospace !important;
  border-radius: 4px !important;
  border: 1px solid #d2d2d2 !important;
  border-bottom-width: 2px !important;
  background: #fafafa !important;
  padding-left: 4px !important;
  padding-right: 4px !important;
  letter-spacing: initial;
  margin-right: 5px;
}
#LexecalResult #main #note .link-card a {
  align-items: center;
  text-decoration: none;
  color: #bbb;
  display: flex;
  width: 100%;
  justify-content: space-between;
}
#LexecalResult #main #note .link-card a .left {
  width: 54px;
  height: 54px;
  margin: 12px;
  overflow: hidden;
  flex-shrink: 0;
  position: relative;
}
#LexecalResult #main #note .link-card a .right {
  overflow: hidden;
  margin-right: 16px;
  margin-left: 10px;
}
#LexecalResult #main #note .link-card a .right p {
  margin: 0;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  font-weight: 900;
  font-family: "STFangsong";
  text-align: left;
}
#LexecalResult #main #note .link-card a .left img {
  display: block;
  position: absolute;
  /* border-radius: 8px/4; */
  height: 100%;
  width: 100%;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}
#LexecalResult #main .title {
  margin-top: 1rem;
  font-size: 1.2rem;
  line-height: 1.2;
}
#LexecalResult #main .content {
  font-size: 1.015rem;
  line-height: 1.5;
  margin-top: 0.5rem;
  margin-bottom: 1rem;
  letter-spacing: 0.25rem;
}
#LexecalResult #main #token {
  margin-top: 1rem;
  width: 100%;
}
#LexecalResult #main #token .table-container {
  border-radius: 6px;
  overflow: hidden;
  width: 100%;
}
#LexecalResult #main #token .table-container table:not([class]) {
  width: 100%;
  border-collapse: collapse;
  overflow: auto;
  /* display: inline-block; */
  max-width: 100%;
  vertical-align: text-top;
}
#LexecalResult #main #token .table-container table:not([class]) th {
  background-color: #393e44;
  filter: brightness(80%);
}
#LexecalResult #main #token .table-container table:not([class]) td,
#LexecalResult #main #token .table-container table:not([class]) th {
  padding: 8px 16px;
  border: 2px solid #464d56;
  line-height: 1.5;
  font-size: 90%;
}
#LexecalResult #main #token .table-container table:not([class]) tr {
  word-break: keep-all;
  background-color: #393e44;
  transition: all 0.28s ease;
  -moz-transition: all 0.28s ease;
  -webkit-transition: all 0.28s ease;
  -o-transition: all 0.28s ease;
}
#LexecalResult #main #token .table-container table:not([class]) tr:hover {
  opacity: 0.9;
  cursor: url("//cdn.jsdelivr.net/gh/pdone/static/img/cursor/link.cur"), pointer !important;
}
#LexecalResult #main #token .table-container td,
#LexecalResult #main #token .table-container th {
  padding: 0;
}
#LexecalResult #main #error {
  box-sizing: border-box;
  width: 100%;
  margin-top: 1rem;
  margin-bottom: 1rem;
  padding: 0 1rem;
  border-radius: 6px;
  background: #574c52;
  border: 1px solid #d1453c;
  min-height: 100px;
}
</style>