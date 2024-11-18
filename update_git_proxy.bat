@echo off

:: 初始化变量
setlocal enabledelayedexpansion

:: 获取本机 IPv4 地址
for /f "tokens=2 delims=:" %%A in ('ipconfig ^| findstr /r "IPv4.*"') do (
    set IP=%%A
    :: 去掉可能的空格
    set IP=!IP:~1!
    :: 只获取第一个有效的 IP，退出循环
    goto FoundIP
)

:NoIP
echo 未检测到有效的 IPv4 地址
pause
exit /b

:FoundIP
:: 设置端口号
set PORT=7890

:: 判断是否成功获取 IP
if "%IP%"=="" (
    echo 未检测到有效的 IP 地址
    pause
    exit /b
)

echo 检测到代理地址: %IP%:%PORT%

:: 配置 git 代理
git config --global http.proxy http://%IP%:%PORT%
git config --global https.proxy http://%IP%:%PORT%

echo 已更新 Git 代理配置
pause
