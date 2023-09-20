# https://blog.csdn.net/FrenzyTechAI/article/details/131259440
import os
import sys
import openai
import io
sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')

openai.api_key = os.getenv("OPENAI_API_KEY")
audio_file= open("./data/generative_ai_topics_clip.mp3", "rb")
transcript = openai.Audio.transcribe("whisper-1", audio_file, response_format="srt",
                                     prompt="这是一段Onboard播客，里面会聊到PALM这个大语言模型。这个模型也叫做Pathways Language Model。")
print(transcript)
