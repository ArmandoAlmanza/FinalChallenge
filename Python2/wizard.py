class Wizard:
    fairies = 10
    power = 1

    def __init__(self):
        super().__init__()

    def getFairies(self):
        return self.fairies

    def setFairies(self, _fairies):
        self.fairies = _fairies

    def setPower(self, _power):
        self.power = _power

    def getPower(self):
        return self.power

    def move(self, azar, fairy):
        print('Look, potter found a fairy')
        if azar:
            self.setFairies(self.getFairies() + fairy)
            if self.getFairies() >= 20:
                self.setPower(self.getPower() + 1)
            else:
                print('The wizard get a fairy\nAnd he destroy her house :c')
        else:
            print('HAHAHA so dumb he lose it')
