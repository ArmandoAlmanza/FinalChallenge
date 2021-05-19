class Character:
    fairies = 0
    health = 3

    def __init__(self, name):
        super().__init__()
        self.name = name

    def setName(self, name):
        self.name = name

    def getHealth(self):
        return self.health

    def setHealth(self, _health):
        self.health = _health

    def getFairies(self):
        return self.fairies

    def setFairies(self, _fairies):
        self.fairies = _fairies

    def getName(self):
        return self.name

    def setName(self, _name):
        self.name = _name

    def getDamage(self):
        return self.health - 1

    def damaged(self, azar):
        print('You encounter the ogre')
        if self.getHealth() == 1:
            if azar:
                self.setHealth(self.getDamage())
                print('Sorry buddy but is game over')
            else:
                print('You dont receive damage but you have 1hp')
        else:
            if azar:
                self.setHealth(self.getDamage())
                print(f'you receive damage, your health if {self.getHealth()}hp')
            else:
                print('You dont receive damage')

    def fairy(self, azar):
        print('Look! a fairy\nCareful she can scape')
        if azar:
            self.setFairies(self.getFairies() + 3)
            print(f'You catch the fairy!!! well done, now you have {self.getFairies()} fairies'
                    f'\nYou build a house for the fairy')
        else:
            print('oooo bad luck she scape... better luck next time')
