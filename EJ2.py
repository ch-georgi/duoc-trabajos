import numpy as np

cantFilas = 0
cantColumnas = 0
def generarMatriz(filas : int,columnas : int):
    arr = np.random.rand(filas,columnas)
    return arr
def datosMatriz(arr):
    print("Valores en arreglo:")
    print(arr)
    print("\nSuma por filas:")
    filas = arr.shape[0]
    columnas = arr.shape[1]
    for i in range(filas):
        sumaFila = arr[i,:].sum()
        print(f"Fila[{i}]: {sumaFila}")
    print("\nPromedio por columnas:")
    sumaColumnas = 0
    for i in range(columnas):
        sumaColumnas = sumaColumnas + arr[:,i].sum()
        print(sumaColumnas / columnas)
def inicio():
    while True:
        try:
            cantFilas = int(input("Ingrese cantidad de filas: "))
            if cantFilas < 3 or cantFilas > 6:
                raise Exception
            break
        except:
            print("Valor ingresado inválido")
    while True:
        try:
            cantColumnas = int(input("Ingrese cantidad de columnas: "))
            if cantColumnas < 3 or cantColumnas > 6:
                raise Exception
            break
        except:
            print("Valor ingresado inválido")
    datosMatriz(generarMatriz(cantFilas,cantColumnas))
inicio()