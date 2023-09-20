# https://blog.csdn.net/zhengzaifeidelushang/article/details/116016447
import sys

print("传入参数的总长度为：", len(sys.argv))
print("type:", type(sys.argv))
print("function name:", sys.argv[0])
try:
    print("第一个传入的参数为:", sys.argv[1])
    print("第二个传入的参数为:", sys.argv[2])
except Exception as e:
    print("Input Error:", e)