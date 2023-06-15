def printMenu(menu):
    print("Menú:")
    indice = 1
    for key, value in menu.items():
        print(f"[{indice}]\t{key}\t\t${value}")
        indice += 1
def agregarProducto(opcion : int,menu : dict,boleta : dict, cantidad : int):
    keyProducto = list(menu)[opcion-1]
    if keyProducto in boleta:
        boleta[keyProducto] = boleta[keyProducto] + cantidad
    else:
        boleta[keyProducto] = cantidad
    return boleta
def totalizar(menu : dict, boleta : dict):
    total = 0
    for key, value in boleta.items():
        total += (menu[key] * value)
    return total
def printBoleta(menu : dict, boleta : dict, cantProductos : int):
    for key, value in boleta.items():
        print(f"{key} x {value}\t\t",(menu[key] * value))
    print("=================================")
    print("Cantidad de productos: ",cantProductos)
    total = totalizar(menu,boleta)
    descuento = 0
    if total >= 3000:
        descuento = total * 0.1
        total = total - descuento
        print("Descuento compra igual o sobre $3000: ",descuento)
    print(f"Total a pagar: ",total)
def inicio():
    carta = {
    "Espresso": 1500,
    "Capuchino": 1800,
    "Latte": 1600,
    "Moca": 1700
    }
    opcion = 0
    cantProductos = 0
    enMenu = True
    boleta = dict()
    print("===Bienvenido===")
    while enMenu:
        print("Seleccione el producto a comprar: ")
        printMenu(carta)
        if(cantProductos > 0):
            print("\n\n[0]\tTotalizar")
        else:
            print("\n\n[0]\tSalir")
        try:
            opcion = int(input())
            if(opcion == 0):
                enMenu = False
                break
            if((len(carta)) < opcion or opcion < 1):
                raise Exception
            cantidad = int(input("Ingrese cantidad: "))
            if(cantidad < 1):
                raise Exception
            boleta = agregarProducto(opcion,carta,boleta, cantidad)
            cantProductos += cantidad
        except:
            print("Valor ingresado inválido")
    if(cantProductos > 0):
        printBoleta(carta,boleta,cantProductos)
        print("\n\nMuchas gracias por su compra.")
    else:
        print("Adios.")
inicio()