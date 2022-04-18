def is_valid_walk(walk):
    #determine if walk is valid
    walkDirH = 0
    walkDirV = 0
    if len(walk) == 10:
        for i in range(0, len(walk)):
            if walk[i] == 'n':
                walkDirV += 1
            if walk[i] == 's':
                walkDirV -= 1
            if walk[i] == 'w':
                walkDirH += 1
            if walk[i] == 'e':
                walkDirH -= 1
        if walkDirV == 0 and walkDirH == 0:
            return True
        else:
            return False
    else:
        return False
