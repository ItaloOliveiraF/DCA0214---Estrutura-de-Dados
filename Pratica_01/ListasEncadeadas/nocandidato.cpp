#include "nocandidato.h"

NoCandidato::NoCandidato(Candidato *_conteudo, NoCandidato *_next)
{
    conteudo=_conteudo;
    next=_next;
}

string NoCandidato::toString()
{
    stringstream stream;
    NoCandidato aux(conteudo, next);

    if(conteudo!=NULL){
        stream<<conteudo->sobrenome<<" "<<conteudo->nome
             <<" "<<conteudo->nota;
        while(aux.next!=NULL){
            aux.conteudo=aux.next->conteudo;
            aux.next=aux.next->next;
            stream<<" --> "<<aux.conteudo->sobrenome<<" "<< aux.conteudo->nome
                 <<" "<<aux.conteudo->nota;
        }
        stream<<" --> "<<aux.next;
    }
    else{
        stream<<'0';
    }

    return stream.str();
}
