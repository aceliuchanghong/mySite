# https://blog.csdn.net/FrenzyTechAI/article/details/131259440
import os
import sys
import openai
import io

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')


# fileName = sys.argv[1]
# prompt = sys.argv[2]
# openai.api_key = os.getenv("OPENAI_API_KEY")
# audio_file = open("./data/generative_ai_topics_clip.mp3", "rb")
# transcript = openai.Audio.transcribe("whisper-1", audio_file, response_format="srt",
#                                      prompt="这是一段Onboard播客，里面会聊到PALM这个大语言模型。这个模型也叫做Pathways Language Model。")
# print(transcript)

def getSrtFIle(audio_file, prompt, srcpath="src/main/java/com/liu/site/util/video2voice/mp3/",
               despath="src/main/java/com/liu/site/util/video2voice/srt/"):
    realFilePath = srcpath + audio_file
    openai.api_key = os.getenv("OPENAI_API_KEY")
    try:
        if not os.path.exists(realFilePath):
            print("Err not exists:" + realFilePath)
            return
        file = open(realFilePath, "rb")
        transcript = openai.Audio.transcribe("whisper-1", file, response_format="srt",
                                             prompt=prompt)
        with open(despath + audio_file + ".srt", 'w') as f:
            f.write(transcript)
    except Exception as e:
        print("Input Error:", e)


getSrtFIle("saveHeart.mp3", "this is a audio about heart")
