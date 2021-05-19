import character as characters
import wizard as wizards
import re
import random
import os

letters = re.compile('^[a-zA-Z0-9 ]{3,10}$')
numbers = re.compile('^\d+$')
character = characters.Character('Default')
wizard = wizards.Wizard()


def dice():
    return random.randint(1, 6)


def azar():
    luck = random.randint(1, 2)
    return luck == 1


def main():
    over = False
    loop = True
    while loop:
        name = input('Enter the name of your character\n--> ')
        if not letters.search(name):
            print('Please only enter letters\nMin length: 3\nMax length: 10')
        else:
            character.setName(name or "Jamon Sad")
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
                if dices == 1 or dices == 3:
                    character.damaged(azar())
                    os.system('pause')
                elif dices == 2 or dices == 4:
                    character.fairy(azar())
                    os.system('pause')
                elif dices == 5 or dices == 6:
                    wizard.move(azar())
                    os.system('pause')
            if character.getHealth() == 0:
                over = True
                print('Good bye, you did it well')
            if character.getFairies() == 12:
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
              f'{(character.getHealth() * 10 + character.getFairies() * 25)}')
        print('Sale hasta la pocimaaaa')


if __name__ == '__main__':
    main()
