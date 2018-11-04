#include <iostream>

#include "ListaCandidatos.h"

int main(){

  ListaCandidatos* lista = new ListaCandidatos("C:\\Users\\italo\\OneDrive\\Documentos\\UFRN\\Est de Dados\\Pratica_01\\Pratica01\\candidatsBourgogne.txt");
  cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString() << endl << endl;

  ListaCandidatos* lista1 = new ListaCandidatos("C:\\Users\\italo\\OneDrive\\Documentos\\UFRN\\Est de Dados\\Pratica_01\\Pratica01\\candidatsPicardie.txt");
  cout << "lista de " << lista1->tamanho() << " candidatos: " << lista1->toString() << endl << endl;

  cout << "concatenacao" << endl;

  lista->concatena(lista1);

  cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString() << endl << endl;
}
