import random

def bogosort(l):
    while not in_order(l):
        random.shuffle(l)
    return l

def in_order(l):
    if not l:
        return True
    last = l[0]
    for x in l[1:]:
        if x < last:
            return False
        last = x
    return True

if __name__ == "__main__":
    random_list = [random.randint(0, 10000) for _ in range(1000)]
    bogosort(random_list)
