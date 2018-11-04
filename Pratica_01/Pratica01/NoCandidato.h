#ifndef _NOCANDIDATO_H
#define _NOCANDIDATO_H
#include "Candidato.h"
#include <cstring>
#include <sstream>


class NoCandidato{

	Candidato *conteudo;
	NoCandidato *next;

	public:

		NoCandidato(Candidato *cand, NoCandidato *prox){
			conteudo=cand;
			next=prox;
		}

		toString(){
			stringstream stream;
			
		}



};




#endif