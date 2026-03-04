import sys
import time
import uuid
import requests


username = input("Username: ")
message = input("Message: ")
cnt = int(input("Count: "))
delay = int(input("Delay (ms): "))
c = 0



print()
print("Username:",username)
print("Message:",message)
print("Count:",cnt)
print("Delay:",delay)


continue_ = input("Continue? (Y/n): ").strip().lower()
if continue_ in ("n", "no", "nie"):
    sys.exit()





while cnt > c:
    id = uuid.uuid4()




    data_ = {
        "username": username,
        "question": message,
        "deviceId": str(id),
        "gameSlug": "",
        "referrer": "nic.pl"
    }





    try:
        resp = requests.post(
            "https://ngl.link/api/submit",
            data=data_,
            headers={"Content-Type": "application/x-www-form-urlencoded"}
        )
        if resp.ok:
            print("Send",c)
    except requests.RequestException:
        print("fail")










    c += 1
    time.sleep(delay / 1000)
