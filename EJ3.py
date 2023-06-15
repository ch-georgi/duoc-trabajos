import math as mp

def areaCirculo(radio):
    return (2 * mp.pi) * radio
def perimetroCuadrado(lado):
    return 4 * lado
def printCalculo(tipo : int, valor):
    if tipo == 1:
        print(f"El área de un círculo de radio {valor} es " , areaCirculo(valor))
    elif tipo == 2:
        print(f"El perímetro de un cuadrado lado {valor} es " , perimetroCuadrado(valor))
    else:
        print("No es una operación válida")
def inicio():
    opcion = 0
    num = 0
    enMenu = True
    print("===Bienvenido===")
    while enMenu:
        print("\nIndique que desea realizar:\n[1]Cacular el área de un circulo")
        print("[2]Calcular el perímetro de un cuadrado\n\n[0]Salir\n")
        try:
            opcion = int(input())
            if not opcion in [0,1,2]:
                raise Exception
            enMenu = False
        except:
            print("Opcion ingresada inválida")
        if opcion == 0 and enMenu == False:
            print("Adios.")
        elif opcion == 1 and enMenu == False:
            radio = 0.0
            while True:
                try:
                    radio = float(input("Ingrese el radio del circulo: "))
                    if radio <= 0:
                        raise Exception
                    break
                except:
                    print("Radio inválido")
            printCalculo(1,radio)
            print("===========")
            enMenu = True
        elif opcion == 2 and enMenu == False:
            lado = 0.0
            while True:
                try:
                    lado = float(input("Ingrese el lado del cuadrado: "))
                    if lado <= 0:
                        raise Exception
                    break
                except:
                    print("Valor inválido")
            printCalculo(2,lado)
            print("===========")
            enMenu = True
        else:
            print("Opción inválida")
inicio()