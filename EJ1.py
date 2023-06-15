import numpy as np

num = 0
def generarArreglo():
    arr = np.random.randint(1,100,10)
    return arr 
def buscarEnArreglo(num : int):
    arr = generarArreglo()
    print(arr)
    return num in arr
def inicio():
    while True:
        try:
            num = int(input("Ingrese el numero a buscar"))
            break
        except:
            print("Número inválido")
    if buscarEnArreglo(num):
        print("Numero encontrado")
    else:
        print("No se ha encontrado el numero")
inicio()