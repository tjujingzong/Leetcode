#include <Windows.h>
#include <iostream>
#include <string>
#include <chrono>
#include <thread>
#include <iomanip>
#include<vector>

void SimulateTyping(const std::wstring& text) {
    INPUT input;
    input.type = INPUT_KEYBOARD;
    input.ki.time = 0;
    input.ki.dwExtraInfo = 0;

    for (wchar_t ch : text) {
        if (ch == L'\n') {
            // 模拟按下 Shift 键
            input.ki.wVk = VK_SHIFT;
            input.ki.wScan = 0;
            input.ki.dwFlags = 0;
            SendInput(1, &input, sizeof(INPUT));

            // 模拟按下 Enter 键
            input.ki.wVk = VK_RETURN;
            input.ki.wScan = 0;
            input.ki.dwFlags = 0;
            SendInput(1, &input, sizeof(INPUT));

            // 松开 Shift 键和 Enter 键
            input.ki.wVk = VK_RETURN;
            input.ki.wScan = 0;
            input.ki.dwFlags = KEYEVENTF_KEYUP;
            SendInput(1, &input, sizeof(INPUT));

            input.ki.wVk = VK_SHIFT;
            input.ki.wScan = 0;
            input.ki.dwFlags = KEYEVENTF_KEYUP;
            SendInput(1, &input, sizeof(INPUT));
        }
        else {
            // 模拟普通字符的输入
            input.ki.wVk = 0;
            input.ki.wScan = ch;
            input.ki.dwFlags = KEYEVENTF_UNICODE;
            SendInput(1, &input, sizeof(INPUT));
            input.ki.dwFlags = KEYEVENTF_KEYUP | KEYEVENTF_UNICODE;
            SendInput(1, &input, sizeof(INPUT));
        }

        std::this_thread::sleep_for(std::chrono::milliseconds(10));
    }
}

int main() {
    HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleTextAttribute(hConsole, FOREGROUND_GREEN);

    // 重置为默认颜色
    SetConsoleTextAttribute(hConsole, FOREGROUND_RED | FOREGROUND_GREEN | FOREGROUND_BLUE);
    std::vector<std::string> lines = {
        "使用帮助:这个程序能够帮助你将剪切板内容模拟为键盘输出。",
        "教程：复制好答案后运行程序再点击编译器窗口即可"
    };
    int maxWidth = 0;
    for (const std::string& line : lines) {
        if (line.length() > maxWidth) {
            maxWidth = line.length();
        }
    }

    std::cout << "**********************************" << std::endl;
    for (const std::string& line : lines) {
        int padding = maxWidth - line.length();
        std::string formattedLine = "* " + line + std::string(padding, ' ') + " *";
        std::cout << formattedLine << std::endl;
    }
    std::cout << "**********************************" << std::endl;
    std::this_thread::sleep_for(std::chrono::seconds(5));

   if (!OpenClipboard(nullptr)) {
        std::cerr << "无法打开剪切板" << std::endl;
        return 1;
    }

    HANDLE hData = GetClipboardData(CF_UNICODETEXT);
    if (hData == nullptr) {
        std::cerr << "无法获取剪切板数据" << std::endl;
        CloseClipboard();
        return 1;
    }

    wchar_t* clipboardText = static_cast<wchar_t*>(GlobalLock(hData));
    if (clipboardText == nullptr) {
        std::cerr << "无法锁定剪切板数据" << std::endl;
        CloseClipboard();
        return 1;
    }

    CloseClipboard();

    // 模拟键盘输出
    SimulateTyping(clipboardText);

    GlobalUnlock(hData);

    return 0;
}
