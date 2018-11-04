#ifndef NOCANDIDATO_H
#define NOCANDIDATO_H
#include "candidato.h"
#include <sstream>
#include <cstring>

class NoCandidato
{

public:
    Candidato *conteudo;
    NoCandidato *next;

    NoCandidato(Candidato *_conteudo, NoCandidato *_next);
    string toString();
};

#endif // NOCANDIDATO_H
