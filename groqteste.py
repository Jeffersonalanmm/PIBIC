import os
import json
from groq import Groq

with open("config.json", "r") as config_file:
    config = json.load(config_file)
    api_key = config["api_key"]

client = Groq(api_key=api_key)

temperature = 0

chat_completion = client.chat.completions.create(
    messages=[
        {
            "role": "user",
            "content": "Define a dijkstra algorithm in Java",
        }
    ],
    model="llama-3.3-70b-versatile",
)

print(chat_completion.choices[0].message.content)
