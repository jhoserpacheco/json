package modelo;


import java.util.*;

public abstract interface crud<A> {

    public boolean agregar(A a);

    public boolean eliminar(long a);

    public boolean actualizar(A a);

    public List<A> consultar();
}
