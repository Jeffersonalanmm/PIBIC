import os
import json
from groq import Groq

with open("config.json", "r") as config_file:
    config = json.load(config_file)
    api_key = config["api_key"]

client = Groq(api_key=api_key)

chat_completion = client.chat.completions.create(
    messages=[
        {
            "role": "user",
            "content": "Please write your best implementation of beadsort algorithm in Python programming language.",
        }
    ],
    model="mixtral-8x7b-32768",
    temperature = 0,
)

print(chat_completion.choices[0].message.content)
