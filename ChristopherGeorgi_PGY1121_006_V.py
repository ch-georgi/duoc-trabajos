from itertools import cycle
import numpy as np
import os
lotes = np.array([
    #[disponibilidad('','X')],[descripción],[cliente(rut)]
    [['','Tamaño: 345 m2',''],['','Tamaño: 789 m2',''],['','Tamaño: 256 m2',''],['','Tamaño: 1000 m2',''],['','Tamaño: 500 m2','']],
    [['','Tamaño: 750 m2',''],['','Tamaño: 300 m2',''],['','Tamaño: 1500 m2',''],['','Tamaño: 200 m2',''],['','Tamaño: 800 m2','']],
    [['','Tamaño: 400 m2',''],['','Tamaño: 1200 m2',''],['','Tamaño: 600 m2',''],['','Tamaño: 900 m2',''],['','Tamaño: 150 m2','']],
    [['','Tamaño: 2000 m2',''],['','Tamaño: 100 m2',''],['','Tamaño: 1800 m2',''],['','Tamaño: 450 m2',''],['','Tamaño: 2500 m2','']],
    [['','Tamaño: 50 m2',''],['','Tamaño: 3000 m2',''],['','Tamaño: 75 m2',''],['','Tamaño: 4000 m2',''],['','Tamaño: 600 m2','']]
])
clientes = list()
def getLotes():
    disponibles = 25
    print("Lista de lotes:")
    for x in range(5):
        for y in range(5):
            print(f"[{lotes[x][y][0] if lotes[x][y][0] else ' ' }]", end=" ")
            if lotes[x][y][0] == 'X':
                disponibles -= 1 
        print()
    print(f"Lotes disponibles: {disponibles}\n ")
def comprarLote(x: int, y: int, cliente: str):
    if(estaDisponible(x,y)):
        lotes[x][y][0] = 'X'
        lotes[x][y][2] = cliente
        return True
    else:
        return False
def estaDisponible(x: int, y: int):
    if(lotes[x][y][0] == ''):
        return True
    else:
        return False
def capturaFila():
    while True:
        fila = inputInt("Fila: ")
        if fila < 1 or fila > 5:
            print("Valor ingresado inválido\n")
        else:
            break
    return fila
def capturaColumna():
    while True:
        columna = inputInt("Columna: ")
        if columna < 1 or columna > 5:
            print("Valor ingresado inválido\n")
        else:
            break
    return columna
def crearNuevoCliente(rut: str,nombre: str, telefono: int, email: str):
    match = False
    for cliente in clientes:
        if rut in cliente:
            match = True
    if(not match):
        clientes.append([rut,nombre,telefono,email])
    return rut
def validarRut(rut):
	rut = rut.upper();
	rut = rut.replace("-","")
	rut = rut.replace(".","")
	aux = rut[:-1]
	dv = rut[-1:]
	revertido = map(int, reversed(str(aux)))
	factors = cycle(range(2,8))
	s = sum(d * f for d, f in zip(revertido,factors))
	res = (-s)%11
	if str(res) == dv:
		return True
	elif dv=="K" and res==10:
		return True
	else:
		return False
def tomarDatosCliente():
    while True:
        try:
            rut = input("Rut: ")
            if(not validarRut(rut)):
                raise Exception
            nombre = input("Nombre: ")
            telefono = int(input("Teléfono: +56 "))
            email = input("E-mail:")
            if email.find('@') == -1 or email.find('.') == -1:
                raise Exception
            break
        except:
            print("Uno de los valores ingresados es inválido")
    return crearNuevoCliente(rut,nombre,telefono,email)
def detalleLote(x: int, y: int, compra = False):
    print(f"Lote {x+1},{y+1}")
    print(f"Detalles:\n{lotes[x][y][1]}")
    if lotes[x][y][2]:
        if not compra:
            print("Estado: No disponible\nPropietario:")
        for cliente in clientes:
            if cliente[0] == lotes[x][y][2]:
                print(f"\tRut: {cliente[0]}\n\tNombre: {cliente[1]}")
                print(f"\tTeléfono: {cliente[2]}\n\tE-mail: {cliente[3]}")
        print()
    else:
        print("Estado: Disponible")
        print()
def getClientes():
    if len(clientes) > 0:
        i = 0
        for cliente in clientes:
            print(f"Cliente [{i+1}/{len(clientes)}] =========")
            print(f"Rut:\t{cliente[0]}")
            print(f"Nombre:\t{cliente[1]}")
            print(f"Telefono:\t{cliente[2]}")
            print(f"E-mail:\t{cliente[3]}\n ")
            i += 1
    else:
        print("Actualmente no hay clientes para mostrar")
def inputInt(mensaje: str):
    while True:
        try:
            n = int(input(mensaje))
            break
        except:
            print("Valor ingresado inválido\n ")
    return n
def mostrarMenu():
    print("Elija una opción ========")
    print("[1]\tVer disponibilidad de lotes")
    print("[2]\tSeleccionar un lote")
    print("[3]\tVer detalles del lote seleccionado")
    print("[4]\tVer Clientes")
    print("\n\n[5]\tSalir")
def llamarOpcion(opcion: int):
    match opcion:
        case 1:
            os.system('cls')
            getLotes()
        case 2:
            os.system('cls')
            while True:
                print("Ingrese las coordenadas del lote (valores de 1 a 5 por coordenada):")
                fila = capturaFila()
                columna = capturaColumna()
                if estaDisponible(fila-1,columna-1):
                    print("¡El lote esta disponible!")
                    print("Ahora solo necesitamos algunos datos para proceder con la compra")
                    comprarLote(fila-1,columna-1,tomarDatosCliente())
                    print(f"¡Perfecto!¡Ahora el lote {fila},{columna} es tuyo!\n ")
                    detalleLote(fila-1,columna-1)
                    break
                else:
                    print("El lote seleccionado ya no está disponible.")
                    detalleLote(fila-1,columna-1)
        case 3:
            os.system('cls')
            print("Ingrese las coordenadas del lote (valores de 1 a 5 por coordenada):")
            fila = capturaFila()
            columna = capturaColumna()
            detalleLote(fila-1,columna-1)
        case 4:
            os.system('cls')
            getClientes()
        case _:
            return
    print('\n==================================================\n')
def inicio():
    print("LoteosDuoc =========================\n\nBienvenido")
    while True:
        opcion = 0
        print("¿Que desea hacer?")
        mostrarMenu()
        while True:
            opcion = inputInt('')
            if opcion < 1 or opcion > 5:
                print("Valor ingresado inválido\n")   
                opcion = mostrarMenu()
            else:
                break
        if opcion != 5:
            llamarOpcion(opcion)
        else:
            break
    print("Gracias por utilizar el servicio 'LoteosDuoc'")
    
inicio()
    
    
    
    
'''print("hola")
getLotes()
detalleLote(0,2)
lotes[0][2][0] = "X"
getLotes()
lotes[0][2][2] = "123"
clientes.append(['123','jose','456','asd@asd.cl'])
detalleLote(0,2)
detalleLote(0,3)'''
