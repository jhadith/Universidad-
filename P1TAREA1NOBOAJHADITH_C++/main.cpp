#include <iostream>
#include <fstream>
using namespace std;
float noboaN1[3];
float noboaPromedio = 0, noboaSuma=0;
int opcion;
void noboaIngreso();
void noboaNota();
void noboaArchivo();
void noboaMenu();


void noboaMenu(){

    do{
    cout<<"PROGRAMA PARA EL INGRESO DE SUS TRES NOTAS Y SU PROMEDIO"<<endl;
   cout<<"1. Registrar notas"<<endl;
    cout<<"2. Promedio de notas"<<endl;
    cout<<"3. Salir"<<endl;
    cout<<"Ingrese una opcion del menu"<<endl;
    cin>>opcion;
    fflush(stdin);

        switch(opcion){
        case 1:
            noboaIngreso();
            break;
        case 2:
            noboaNota();
            break;
        case 3:
            cout<<"Saliendo"<<endl;
            break;
        default:
            cout<<"Opcion incorrecta, intente nuevamnete"<<endl;
            break;
        }
    }while(opcion!=3);

}

void noboaIngreso(){

    cout<<"Ingrese sus  3 notas"<<endl;
    for (int i=0 ; i<3 ; i++){
            cout<<"Ingrese la nota "<< (i + 1) << ": " <<endl;
            cin>>noboaN1[i];
            while(noboaN1[i]<0 || noboaN1[i]>20){
                cout<<"Solo se permiten notas de 0 a 20, vuelva a ingresar"<<endl;
                cin>>noboaN1[i];
            }
    }

    cout<<"Notas ingresadas correctamente"<<endl;

}

void noboaNota(){
  for(int i= 0 ; i<3 ; i++){
        noboaSuma= noboaSuma+noboaN1[i];
    }
    noboaPromedio=noboaSuma/3;
    cout<<"Su promedio es: "<<noboaPromedio<<endl;
    if (noboaPromedio>14){
        cout<<"Usted ha sido aprobado"<<endl;
    }else{
    cout<<"Ha sido reprobado"<<endl;
    }
noboaArchivo();
}

void noboaArchivo(){
ofstream archivo("noboaNotas.txt");
    if(archivo.is_open()){
            for(int i=0 ; i<3 ; i++){
                    archivo<<"Nota "<< (i + 1) << ": " <<noboaN1[i]<<endl;
            }
                archivo<<"------------------------------"<<endl;
                archivo<<"Promedio: "<<noboaPromedio<<endl;
                 if (noboaPromedio > 14) {
            archivo<<"Resultado: Aprobado"<<endl;
        } else {
            archivo<<"Resultado: Reprobado"<<endl;
        }
        archivo.close();
        cout<<"Notas registradas en el archivo 'noboaNotas.txt'."<<endl;
    } else {
        cout<<"Error"<<endl;
    }
}


int main()
{
    noboaMenu();
    return 0;
}
