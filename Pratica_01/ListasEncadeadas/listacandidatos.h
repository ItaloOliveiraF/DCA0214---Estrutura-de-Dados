#ifndef LISTACANDIDATOS_H
#define LISTACANDIDATOS_H
#include "candidato.h"
#include "nocandidato.h"
#include <cstring>
#include <sstream>
#include <iostream>
#include <fstream>

class ListaCandidatos
{
public:
    NoCandidato *head;

    ListaCandidatos();
    ListaCandidatos(string nomeDoArquivo);
    void adicioneComoHead(Candidato *C);
    bool estaVazia();
    int tamanho();
    string toString();
    bool remove(string nome, string sobrenome);
    void filtrarCandidatos(int nota);
    void concatena(ListaCandidatos *l);

};

#endif // LISTACANDIDATOS_H
