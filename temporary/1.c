#include <stdio.h>
#include <string.h>
#include <ctype.h>

#define ALPHABET_SIZE 26

// 英文字母的频率表
const float english_freq[ALPHABET_SIZE] = {
    8.167, 1.492, 2.782, 4.253, 12.702, 2.228, 2.015, 6.094, 6.966, 0.153,
    0.772, 4.025, 2.406, 6.749, 7.507, 1.929, 0.095, 5.987, 6.327, 9.056,
    2.758, 0.978, 2.360, 0.150, 1.974, 0.074
};

// 统计字符频率
void calculate_frequency(const char *text, float *freq) {
    int count[ALPHABET_SIZE] = {0};
    int total = 0;
    
    for (int i = 0; text[i] != '\0'; i++) {
        if (isalpha(text[i])) {
            count[tolower(text[i]) - 'a']++;
            total++;
        }
    }
    
    for (int i = 0; i < ALPHABET_SIZE; i++) {
        freq[i] = ((float)count[i] / total) * 100;
    }
}

// 找到频率最接近的字母
char find_closest_freq(float freq, const float *english_freq) {
    float min_diff = 100.0;
    char best_match = 'a';
    
    for (int i = 0; i < ALPHABET_SIZE; i++) {
        float diff = (english_freq[i] > freq) ? (english_freq[i] - freq) : (freq - english_freq[i]);
        if (diff < min_diff) {
            min_diff = diff;
            best_match = 'a' + i;
        }
    }
    
    return best_match;
}

// 生成破译表
void generate_decryption_table(const float *text_freq, char *decryption_table) {
    for (int i = 0; i < ALPHABET_SIZE; i++) {
        decryption_table[i] = find_closest_freq(text_freq[i], english_freq);
    }
}

// 手动调整破译表
void manual_adjustment(char *decryption_table) {
    char choice;
    char from, to;
    
    printf("是否需要手动调整破译表？(y/n): ");
    scanf(" %c", &choice);
    
    while (choice == 'y') {
        printf("输入需要调整的密文字符: ");
        scanf(" %c", &from);
        printf("输入对应的明文字符: ");
        scanf(" %c", &to);
        
        decryption_table[from - 'a'] = to;
        
        printf("是否需要继续手动调整破译表？(y/n): ");
        scanf(" %c", &choice);
    }
}

// 解密
void decrypt_text(const char *ciphertext, const char *decryption_table, char *plaintext) {
    for (int i = 0; ciphertext[i] != '\0'; i++) {
        if (isalpha(ciphertext[i])) {
            char decrypted_char = decryption_table[tolower(ciphertext[i]) - 'a'];
            plaintext[i] = isupper(ciphertext[i]) ? toupper(decrypted_char) : decrypted_char;
        } else {
            plaintext[i] = ciphertext[i];
        }
    }
    plaintext[strlen(ciphertext)] = '\0';
}

int main() {
    char ciphertext[] = "hzsrnqc klyy wqc flo mflwf ol zqdn nsoznj wskn lj xzsrbjnf,wzSxz ggv zghhnf ol ozn glco z1fnco hnlhrn; nsoznj jnrgosdnc1j fnqj kjsnfbc, wsz sc xnjogsfrv gljn efecegr. zn rsdnb grlfn sf zsc zlecn sf cqdsrrn jlw, wzsozni flfn hnfnojgonb. q csfyrn blgncosx cekksnb ol cnjdn zsg. zn pingmkqconb gfb bsfnb go on xrep, go zlejc ggoznggosxqrrv ksanb, sf on cggn jllg, go on cggn ogprn, fndnj ogmsfy zsc gnqrc wsoz lozni gngpnjc, gexz rncc pisfysfy g yenco woz zsg; gfb wnfo z1gn go nagorv gsbfsyzo, 1frv ol josin go lfxn ol pnb. zn fndni ecnb on xlcv xggpnic wsxz ozn inklig hildsbnc kli soc kqdlejnb gngpnjc. n hqcenb onf zlejc leo 1k on ownfov-klej sf cqdsrrn jlw, nsoznj sf crnnhsfy lj ggmsfy zsc olsrno.";
    char plaintext[500];
    
    float text_freq[ALPHABET_SIZE] = {0};
    char decryption_table[ALPHABET_SIZE] = {0};
    
    calculate_frequency(ciphertext, text_freq);
    generate_decryption_table(text_freq, decryption_table);
    
    // 手动调整破译表
    manual_adjustment(decryption_table);
    
    decrypt_text(ciphertext, decryption_table, plaintext);
    
    printf("解密后的文本：\n%s\n", plaintext);
    
    return 0;
}

