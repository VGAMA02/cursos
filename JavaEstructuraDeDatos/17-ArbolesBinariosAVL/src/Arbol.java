//Arboles AVL
public class Arbol {
    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }
    public Nodo obtenerRaiz() {
        return raiz;
    }
    //Metodo para buscar un nodo
    public Nodo buscar(int d, Nodo r)
    {
        if(raiz == null)
        {
            return null;
        }
        else if(r.dato == d)
        {
               return r;
        }
        else if(r.dato < d)
        {
            return buscar(d,r.derecho);
        }
        else
        {
            return buscar(d,r.izquierdo);
        }
    }
    //Metodo para obtener el factor de equilibrio
    public int obtenerFE(Nodo x)
    {
        if(x == null)
        {
            return -1;
        }
        else{
            return x.fe;
        }
    }
    //Rotacion simple izquierda
    public Nodo rotacionIzq(Nodo c)
    {
        Nodo auxiliar = c.izquierdo;
        c.izquierdo = auxiliar.derecho;
        auxiliar.derecho = c;
        c.fe = Math.max(obtenerFE(c.izquierdo),obtenerFE(c.derecho)) + 1;
        auxiliar.fe = Math.max(obtenerFE(auxiliar.izquierdo),obtenerFE(auxiliar.derecho)) + 1;
        return auxiliar;
    }
    //Rotacion simple derecha
     public Nodo rotacionDer(Nodo c)
    {
        Nodo auxiliar = c.derecho;
        c.derecho = auxiliar.izquierdo;
        auxiliar.izquierdo = c;
        c.fe = Math.max(obtenerFE(c.izquierdo),obtenerFE(c.derecho)) + 1;
        auxiliar.fe = Math.max(obtenerFE(auxiliar.izquierdo),obtenerFE(auxiliar.derecho)) + 1;
        return auxiliar;
    }
     //rotacion doble a la izquierda
     public Nodo rotacionDobleIzq(Nodo c)
     {
         Nodo temporal;
         c.izquierdo = rotacionDer(c.izquierdo);
         temporal = rotacionIzq(c);
         return temporal;
     }
     //rotacion doble a la derecha
      public Nodo rotacionDobleDer(Nodo c)
     {
         Nodo temporal;
         c.derecho = rotacionIzq(c.derecho);
         temporal = rotacionDer(c);
         return temporal;
     }
      //Metodo para insertar
      public Nodo insertarAVL(Nodo nuevo, Nodo subAr)
      {
          Nodo nuevoPadre = subAr;
          if(nuevo.dato < subAr.dato)
          {
              if(subAr.izquierdo == null)
              {
                  subAr.izquierdo = nuevo;
              }
              else
              {
                  subAr.izquierdo = insertarAVL(nuevo, subAr.izquierdo);
                  if( (obtenerFE(subAr.izquierdo) - obtenerFE(subAr.derecho) == 2 )  )
                  {
                        if(nuevo.dato < subAr.izquierdo.dato){
                            nuevoPadre = rotacionIzq(subAr);
                        }
                        else
                        {
                           nuevoPadre = rotacionDobleIzq(subAr); 
                        }
                  }
              }
          }else if(nuevo.dato > subAr.dato)
          {
              if(subAr.derecho == null){
                  subAr.derecho = nuevo;
              }
              else{
                  subAr.derecho = insertarAVL(nuevo,subAr.derecho);
                  if((obtenerFE(subAr.derecho) - obtenerFE(subAr.izquierdo) == 2))
                  {
                      if(nuevo.dato > subAr.derecho.dato){
                          nuevoPadre = rotacionDer(subAr);
                      }
                      else
                      {
                          nuevoPadre = rotacionDobleDer(subAr);
                      }
                  }
              }
          }
          else
          {
              System.out.println("Nodo duplicado");
          }
          //Actualizando el FE
          if( (subAr.izquierdo == null) && (subAr.derecho != null) ){
              subAr.fe = subAr.derecho.fe + 1;
          }else if((subAr.derecho == null) && (subAr.izquierdo != null)){
              subAr.fe = subAr.izquierdo.fe +1;
          }
          else
          {
              subAr.fe = Math.max(obtenerFE(subAr.izquierdo),obtenerFE(subAr.derecho)) + 1;
          }
          return nuevoPadre;
      }//insertar
      //Metodo para insertar
      public void insertar(int d)
      {
          Nodo nuevo = new Nodo(d);
          if(raiz == null)
          {
              raiz = nuevo;
          }
          else
          {
              raiz = insertarAVL(nuevo, raiz);
          }
      }
    //Recorridos
    //Metodo para recorrer el arbol inOrden
    public void inOrden(Nodo r)
    {
        if(r != null)
        {
            inOrden(r.izquierdo);
             System.out.print(r.dato + ", ");
            inOrden(r.derecho);
        }
        else
        {
            
        }
    }
    //Metodo para reccorrer el arbol en preORDEN
    public void preOrden(Nodo r)
    {
        if(r != null)
        {
            System.out.print(r.dato + ", ");
            preOrden(r.izquierdo);
            preOrden(r.derecho);
        }
        else
        {
            
        }
    }
      
}//clase
