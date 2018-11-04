#include "listacandidatos.h"


ListaCandidatos::ListaCandidatos()
{
    head=NULL;
}

ListaCandidatos::ListaCandidatos(string nomeDoArquivo)
{
    ifstream fcin(nomeDoArquivo);

    head=NULL;
    string dados;
    Candidato *c;
    stringstream Stream;

    getline(fcin,dados);
    cout << "criacao da lista de candidatos de: " << dados << endl;

    while(getline(fcin,dados)){
      c= new Candidato(dados);
      adicioneComoHead(c);
    }

}

void ListaCandidatos::adicioneComoHead(Candidato* C)
{
    head=new NoCandidato(C, head);
}

bool ListaCandidatos::estaVazia()
{
    if(head==NULL) return true;
    else return false;
}

int ListaCandidatos::tamanho()
{
    int cont=0;
    NoCandidato *aux;

    if(head!=NULL){
        cont=1;
        aux=head;

        while(aux->next!=NULL){
            cont++;
            aux=aux->next;
        }
    }

    return cont;
}

string ListaCandidatos::toString()
{
        stringstream stream;
        NoCandidato* aux;

        if(head!=NULL){
            aux= new NoCandidato(head->conteudo,head->next);
            stream<<head->conteudo->sobrenome<<" "<<head->conteudo->nome
                 <<" "<<head->conteudo->nota;
            while(aux->next!=NULL){
                aux->conteudo=aux->next->conteudo;
                aux->next=aux->next->next;
                stream<<" --> "<<aux->conteudo->sobrenome<<" "<< aux->conteudo->nome
                     <<" "<<aux->conteudo->nota;
            }
            stream<<" --> "<<aux->next;
        }
        else{
            stream<<NULL;
        }

        return stream.str();
}

bool ListaCandidatos::remove(string nome, string sobrenome)
{
    NoCandidato *it, *aux;

    it=head;

    if(it!=NULL){

        //Conferir a cabeça
        if(it->conteudo->igual(nome, sobrenome)){
            head=it->next;
            delete it;
            return true;
        }

        //Conferir o resto
        while(it->next!=NULL){
            if(it->next->conteudo->igual(nome, sobrenome)){
                aux=it->next;
                it->next=it->next->next;
                delete aux;
                return true;
            }
            it=it->next;
        }
    }

    return false;
}

void ListaCandidatos::filtrarCandidatos(int nota)
{
    NoCandidato *it, *aux;

    if(head!=NULL){

        //Conferir a cabeça
        while(head->conteudo->nota<nota){
            aux=head;
            head=head->next;
            delete aux;

            if(head==NULL){
                break;
            }
        }

        //Conferir o resto
        if(head!=NULL){
            it=head;
            while(it->next!=NULL){
                if((it->next->conteudo->nota)<nota){
                    aux=it->next;
                    it->next=it->next->next;
                    delete aux;
                }
                else{
                    it=it->next;
                }
            }
        }
    }
}

void ListaCandidatos::concatena(ListaCandidatos *l)
{
    NoCandidato *aux;

    if(head!=NULL){
        aux=head;

        while(aux->next!=NULL){
            aux=aux->next;
        }
        aux->next=l->head;
    }
    else{
        head=l->head;
    }
}
