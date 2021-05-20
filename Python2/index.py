import character as characters
import wizard as wizards
import re
import random
import os

letters = re.compile('^[a-zA-Z0-9 ]{3,10}$')
numbers = re.compile('^\d+$')
character = characters.Character('Player 1')
wizard = wizards.Wizard()


def dice():
    return random.randint(1, 8)


def azar():
    luck = random.randint(1, 2)
    return luck == 1


def azarFairy():
    fairy = random.randint(1, 5)
    return fairy


def main():
    over = False
    loop = True
    house = 0
    while loop:
        name = input('Enter the name of your character\n--> ')
        if not letters.search(name):
            print('Please only enter letters\nMin length: 3\nMax length: 10')
        else:
            character.setName(name or "Player 1")
            loop = False
    else:
        print(
            f'The initial status of your character is:\nHealth {character.getHealth()}hp\nFairies '
            f'{character.getFairies()}')
    while not over:
        dices = dice()
        roll = input('you wanna roll the dice or leave?\n1 -> roll\n2 -> leave\n-->')
        if roll == '1':
            if not numbers.search(roll):
                print('Sorry only enter numbers')
            else:
                if dices == 1 or dices == 5:
                    character.damaged(azar())
                    os.system('pause')
                elif dices == 2 or dices == 6:
                    character.fairy(azar(), azarFairy())
                    os.system('pause')
                elif dices == 3 or dices == 7:
                    wizard.move(azar(), azarFairy())
                    os.system('pause')
                elif dices == 4 or dices == 8:
                    if character.houses(character.getPieces() == 1):
                        houses = ++house
                        print('You build a house for the fairies, their so happy :3')
            if character.getHealth() == 0:
                over = True
                print('Good bye, you did it well')
            if character.getFairies() >= 10:
                over = True
                print('Dude you did it awesome')
            if wizard.getPower() == 2:
                over = True
                print('The wizard is too strong, we cant defeat him')
        elif roll == '2':
            over = True
        else:
            print('Please enter something valid')
    else:
        print(f'the score of {character.getName()} is of '
              f'{(character.getHealth() * 10 + character.getFairies() * 25)}'
              f'\nYou build {houses} houses for the fairies')
        print('Sale hasta la pocimaaaa')


if __name__ == '__main__':
    main()
